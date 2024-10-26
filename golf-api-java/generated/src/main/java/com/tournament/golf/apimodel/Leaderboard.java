package com.tournament.golf.apimodel;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.tournament.golf.apimodel.LeaderboardEntry;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Leaderboard
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-25T14:29:10.223704700-04:00[America/New_York]")
public class Leaderboard {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime lastUpdated;

  @Valid
  private List<@Valid LeaderboardEntry> players;

  public Leaderboard lastUpdated(OffsetDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

  /**
   * Get lastUpdated
   * @return lastUpdated
  */
  @Valid 
  @Schema(name = "lastUpdated", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastUpdated")
  public OffsetDateTime getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(OffsetDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public Leaderboard players(List<@Valid LeaderboardEntry> players) {
    this.players = players;
    return this;
  }

  public Leaderboard addPlayersItem(LeaderboardEntry playersItem) {
    if (this.players == null) {
      this.players = new ArrayList<>();
    }
    this.players.add(playersItem);
    return this;
  }

  /**
   * Get players
   * @return players
  */
  @Valid 
  @Schema(name = "players", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("players")
  public List<@Valid LeaderboardEntry> getPlayers() {
    return players;
  }

  public void setPlayers(List<@Valid LeaderboardEntry> players) {
    this.players = players;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Leaderboard leaderboard = (Leaderboard) o;
    return Objects.equals(this.lastUpdated, leaderboard.lastUpdated) &&
        Objects.equals(this.players, leaderboard.players);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastUpdated, players);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Leaderboard {\n");
    sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
    sb.append("    players: ").append(toIndentedString(players)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

