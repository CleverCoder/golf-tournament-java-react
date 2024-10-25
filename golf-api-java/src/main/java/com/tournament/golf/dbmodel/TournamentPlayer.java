package com.tournament.golf.dbmodel;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.OffsetDateTime;

@Entity
@Table(name = "tournament_players", schema = "public")
public class TournamentPlayer {
    @EmbeddedId
    private TournamentPlayerId id;

    @MapsId("tournamentId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "tournament_id", nullable = false)
    private Tournament tournament;

    @MapsId("playerId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @ColumnDefault("0")
    @Column(name = "holes_completed")
    private Integer holesCompleted;

    @ColumnDefault("0")
    @Column(name = "current_score")
    private Integer currentScore;

    @ColumnDefault("0")
    @Column(name = "relative_to_par")
    private Integer relativeToPar;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    public TournamentPlayerId getId() {
        return id;
    }

    public void setId(TournamentPlayerId id) {
        this.id = id;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Integer getHolesCompleted() {
        return holesCompleted;
    }

    public void setHolesCompleted(Integer holesCompleted) {
        this.holesCompleted = holesCompleted;
    }

    public Integer getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(Integer currentScore) {
        this.currentScore = currentScore;
    }

    public Integer getRelativeToPar() {
        return relativeToPar;
    }

    public void setRelativeToPar(Integer relativeToPar) {
        this.relativeToPar = relativeToPar;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

}