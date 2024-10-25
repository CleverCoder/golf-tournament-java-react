package com.tournament.golf.dbmodel;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "scores", schema = "public")
public class Score {
    @Id
    @ColumnDefault("uuid_generate_v4()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TournamentPlayer tournamentPlayers;

    @NotNull
    @Column(name = "hole_number", nullable = false)
    private Integer holeNumber;

    @NotNull
    @Column(name = "strokes", nullable = false)
    private Integer strokes;

    @NotNull
    @Column(name = "relative_to_par", nullable = false)
    private Integer relativeToPar;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TournamentPlayer getTournamentPlayers() {
        return tournamentPlayers;
    }

    public void setTournamentPlayers(TournamentPlayer tournamentPlayers) {
        this.tournamentPlayers = tournamentPlayers;
    }

    public Integer getHoleNumber() {
        return holeNumber;
    }

    public void setHoleNumber(Integer holeNumber) {
        this.holeNumber = holeNumber;
    }

    public Integer getStrokes() {
        return strokes;
    }

    public void setStrokes(Integer strokes) {
        this.strokes = strokes;
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