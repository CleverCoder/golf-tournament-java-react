package com.tournament.golf.service;

import com.tournament.golf.apimodel.*;
import com.tournament.golf.exception.TournamentExistsException;
import com.tournament.golf.model.HoleScore;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
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
        userHoleScores.put(player.getId(), createInitialHoleScores(currentTournament.getCoursePars().size()));

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

        // Calculate total score and relative to par
        int totalScore = holeScores.stream().mapToInt(HoleScore::getSwings).sum();
        int totalPar = currentTournament.getTotalPar();
        int relativeToPar = totalScore - totalPar;

        player.setHolesCompleted(holeScores.size());
        player.setRelativeToPar(relativeToPar);

        return score;
    }

    private int calculateTotalPar(List<Integer> coursePars) {
        return coursePars != null ? coursePars.stream().mapToInt(Integer::intValue).sum() : 0;
    }

    private static List<HoleScore> createInitialHoleScores(int numberOfHoles) {
        return IntStream.range(0, numberOfHoles)
                .mapToObj(i -> new HoleScore(i + 1, 0))
                .collect(Collectors.toList());
    }

}