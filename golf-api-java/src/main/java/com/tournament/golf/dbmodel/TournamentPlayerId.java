package com.tournament.golf.dbmodel;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class TournamentPlayerId implements Serializable {
    private static final long serialVersionUID = -994487743524730252L;
    @NotNull
    @Column(name = "tournament_id", nullable = false)
    private UUID tournamentId;

    @NotNull
    @Column(name = "player_id", nullable = false)
    private UUID playerId;

    public UUID getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(UUID tournamentId) {
        this.tournamentId = tournamentId;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public void setPlayerId(UUID playerId) {
        this.playerId = playerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TournamentPlayerId entity = (TournamentPlayerId) o;
        return Objects.equals(this.tournamentId, entity.tournamentId) &&
                Objects.equals(this.playerId, entity.playerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tournamentId, playerId);
    }

}