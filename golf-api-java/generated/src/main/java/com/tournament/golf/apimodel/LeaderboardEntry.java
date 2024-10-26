package com.tournament.golf.apimodel;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * LeaderboardEntry
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-25T14:29:10.223704700-04:00[America/New_York]")
public class LeaderboardEntry {

  private Integer position;

  private UUID playerId;

  private String playerName;

  private Integer holesCompleted;

  private String relativeToPar;

  private Integer parOfPlayedHoles;

  private Integer currentScore;

  public LeaderboardEntry position(Integer position) {
    this.position = position;
    return this;
  }

  /**
   * Get position
   * @return position
  */
  
  @Schema(name = "position", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("position")
  public Integer getPosition() {
    return position;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }

  public LeaderboardEntry playerId(UUID playerId) {
    this.playerId = playerId;
    return this;
  }

  /**
   * Get playerId
   * @return playerId
  */
  @Valid 
  @Schema(name = "playerId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("playerId")
  public UUID getPlayerId() {
    return playerId;
  }

  public void setPlayerId(UUID playerId) {
    this.playerId = playerId;
  }

  public LeaderboardEntry playerName(String playerName) {
    this.playerName = playerName;
    return this;
  }

  /**
   * Get playerName
   * @return playerName
  */
  
  @Schema(name = "playerName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("playerName")
  public String getPlayerName() {
    return playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public LeaderboardEntry holesCompleted(Integer holesCompleted) {
    this.holesCompleted = holesCompleted;
    return this;
  }

  /**
   * Get holesCompleted
   * minimum: 0
   * maximum: 18
   * @return holesCompleted
  */
  @Min(0) @Max(18) 
  @Schema(name = "holesCompleted", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("holesCompleted")
  public Integer getHolesCompleted() {
    return holesCompleted;
  }

  public void setHolesCompleted(Integer holesCompleted) {
    this.holesCompleted = holesCompleted;
  }

  public LeaderboardEntry relativeToPar(String relativeToPar) {
    this.relativeToPar = relativeToPar;
    return this;
  }

  /**
   * Score relative to par ('E' for even, or +/- number)
   * @return relativeToPar
  */
  
  @Schema(name = "relativeToPar", description = "Score relative to par ('E' for even, or +/- number)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("relativeToPar")
  public String getRelativeToPar() {
    return relativeToPar;
  }

  public void setRelativeToPar(String relativeToPar) {
    this.relativeToPar = relativeToPar;
  }

  public LeaderboardEntry parOfPlayedHoles(Integer parOfPlayedHoles) {
    this.parOfPlayedHoles = parOfPlayedHoles;
    return this;
  }

  /**
   * The total par value of played holes
   * @return parOfPlayedHoles
  */
  
  @Schema(name = "parOfPlayedHoles", description = "The total par value of played holes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("parOfPlayedHoles")
  public Integer getParOfPlayedHoles() {
    return parOfPlayedHoles;
  }

  public void setParOfPlayedHoles(Integer parOfPlayedHoles) {
    this.parOfPlayedHoles = parOfPlayedHoles;
  }

  public LeaderboardEntry currentScore(Integer currentScore) {
    this.currentScore = currentScore;
    return this;
  }

  /**
   * The current running score for played holes
   * @return currentScore
  */
  
  @Schema(name = "currentScore", description = "The current running score for played holes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("currentScore")
  public Integer getCurrentScore() {
    return currentScore;
  }

  public void setCurrentScore(Integer currentScore) {
    this.currentScore = currentScore;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LeaderboardEntry leaderboardEntry = (LeaderboardEntry) o;
    return Objects.equals(this.position, leaderboardEntry.position) &&
        Objects.equals(this.playerId, leaderboardEntry.playerId) &&
        Objects.equals(this.playerName, leaderboardEntry.playerName) &&
        Objects.equals(this.holesCompleted, leaderboardEntry.holesCompleted) &&
        Objects.equals(this.relativeToPar, leaderboardEntry.relativeToPar) &&
        Objects.equals(this.parOfPlayedHoles, leaderboardEntry.parOfPlayedHoles) &&
        Objects.equals(this.currentScore, leaderboardEntry.currentScore);
  }

  @Override
  public int hashCode() {
    return Objects.hash(position, playerId, playerName, holesCompleted, relativeToPar, parOfPlayedHoles, currentScore);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LeaderboardEntry {\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    playerId: ").append(toIndentedString(playerId)).append("\n");
    sb.append("    playerName: ").append(toIndentedString(playerName)).append("\n");
    sb.append("    holesCompleted: ").append(toIndentedString(holesCompleted)).append("\n");
    sb.append("    relativeToPar: ").append(toIndentedString(relativeToPar)).append("\n");
    sb.append("    parOfPlayedHoles: ").append(toIndentedString(parOfPlayedHoles)).append("\n");
    sb.append("    currentScore: ").append(toIndentedString(currentScore)).append("\n");
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

