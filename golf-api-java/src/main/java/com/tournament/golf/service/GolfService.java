package com.tournament.golf.service;

import com.tournament.golf.apimodel.*;
import com.tournament.golf.exception.TournamentExistsException;
import com.tournament.golf.model.HoleScore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class GolfService {
    // In-memory storage for tournaments
    private Tournament currentTournament;
    private final ConcurrentHashMap<UUID, Player> players = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<UUID, List<HoleScore>> userHoleScores = new ConcurrentHashMap<>();

    public Tournament createTournament(TournamentCreate tournamentCreate) {
        if (this.currentTournament != null) {
            throw new TournamentExistsException("There is already an active tournament");
        }

        Tournament tournament = new Tournament()
                .coursePars(tournamentCreate.getCoursePars())
                .id(UUID.randomUUID())
                .totalPar(calculateTotalPar(tournamentCreate.getCoursePars()));

        this.currentTournament = tournament;
        return tournament;
    }

    public Tournament getTournament() {
        return this.currentTournament;
    }


    public Player addPlayer(PlayerCreate playerCreate) {
        Player player = new Player()
                .id(UUID.randomUUID())
                .name(playerCreate.getName())
                .holesCompleted(0);
        players.put(player.getId(), player);

        // Init hole scores for the player
        userHoleScores.put(player.getId(), new ArrayList<>());

        return player;
    }

    public List<Player> getPlayers() {
        return List.copyOf(players.values());
    }

    // Submit score for a player and hole, return the updated scores for all holes
    public Score submitScore(ScoreSubmission scoreSubmission) {
        Player player = players.get(scoreSubmission.getPlayerId());
        if (player == null) {
            throw new IllegalArgumentException("Player not found");
        }

        List<HoleScore> holeScores = userHoleScores.get(player.getId());
        if (holeScores == null) {
            throw new IllegalArgumentException("Player has no hole scores");
        }

        var coursePars = this.currentTournament.getCoursePars();

        if (scoreSubmission.getHoleNumber() < 1 || scoreSubmission.getHoleNumber() > coursePars.size()) {
            throw new IllegalArgumentException("Invalid hole number");
        }

        if (scoreSubmission.getStrokes() < 1) {
            throw new IllegalArgumentException("Invalid number of strokes");
        }

        var holeScore = holeScores.stream().filter(hs -> hs.getHoleNumber() == scoreSubmission.getHoleNumber()).findFirst();
        if (holeScore.isPresent()) {
            holeScore.get().setSwings(scoreSubmission.getStrokes());
        } else {
            holeScores.add(new HoleScore(scoreSubmission.getHoleNumber(), scoreSubmission.getStrokes()));
        }

        // return score
        var holePar = coursePars.get(scoreSubmission.getHoleNumber() - 1);
        var score = new Score()
                .playerId(player.getId())
                .holeNumber(scoreSubmission.getHoleNumber())
                .strokes(scoreSubmission.getStrokes())
                .relativeToPar(scoreSubmission.getStrokes() - holePar);

        player.setHolesCompleted(holeScores.size());

        // Calculate total score and relative to par if all holes are completed
        if (player.getHolesCompleted() == coursePars.size()) {
            int totalScore = holeScores.stream().mapToInt(HoleScore::getSwings).sum();
            int totalPar = currentTournament.getTotalPar();
            int relativeToPar = totalScore - totalPar;
            player.setRelativeToPar(relativeToPar);
        }

        return score;
    }

    private int calculateTotalPar(List<Integer> coursePars) {
        return coursePars != null ? coursePars.stream().mapToInt(Integer::intValue).sum() : 0;
    }

    public Leaderboard getLeaderboard() {
        var leaderboard = new Leaderboard();

        // Convert values to list and sort players
        List<Player> sortedPlayers = players.values().stream()
                .sorted((p1, p2) -> {
                    if (p1.getRelativeToPar() == null || p2.getRelativeToPar() == null) {
                        return 0;
                    }

                    // First compare by relative to par
                    if (!Objects.equals(p1.getRelativeToPar(), p2.getRelativeToPar())) {
                        return p1.getRelativeToPar() - p2.getRelativeToPar();
                    }
                    // Break ties by holes completed
                    return p2.getHolesCompleted() - p1.getHolesCompleted();
                })
                .toList();

        AtomicInteger position = new AtomicInteger(1);
        var leaderBoardEntries = sortedPlayers.stream().map(player -> {
            String relativeToPar = null;
            if (player.getRelativeToPar() != null) {
                relativeToPar = player.getRelativeToPar() == 0 ? "E" : player.getRelativeToPar().toString();
            }

            return new LeaderboardEntry()
                    .position(position.getAndIncrement())
                    .playerId(player.getId())
                    .playerName(player.getName())
                    .holesCompleted(player.getHolesCompleted())
                    .relativeToPar(relativeToPar)
                    .currentScore(getUserCurrentScore(player.getId()));
        }).toList();

        leaderboard.setPlayers(leaderBoardEntries);

        return leaderboard;
    }

    private int getUserCurrentScore(UUID playerId) {
        var holeScores = userHoleScores.get(playerId);
        if (holeScores == null) {
            return 0;
        }

        return holeScores.stream().mapToInt(HoleScore::getSwings).sum();
    }
}