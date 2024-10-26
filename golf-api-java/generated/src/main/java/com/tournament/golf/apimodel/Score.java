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
 * Score
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-25T14:29:10.223704700-04:00[America/New_York]")
public class Score {

  private UUID playerId;

  private Integer holeNumber;

  private Integer strokes;

  private Integer relativeToPar;

  public Score playerId(UUID playerId) {
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

  public Score holeNumber(Integer holeNumber) {
    this.holeNumber = holeNumber;
    return this;
  }

  /**
   * Get holeNumber
   * minimum: 1
   * maximum: 18
   * @return holeNumber
  */
  @Min(1) @Max(18) 
  @Schema(name = "holeNumber", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("holeNumber")
  public Integer getHoleNumber() {
    return holeNumber;
  }

  public void setHoleNumber(Integer holeNumber) {
    this.holeNumber = holeNumber;
  }

  public Score strokes(Integer strokes) {
    this.strokes = strokes;
    return this;
  }

  /**
   * Get strokes
   * minimum: 1
   * @return strokes
  */
  @Min(1) 
  @Schema(name = "strokes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("strokes")
  public Integer getStrokes() {
    return strokes;
  }

  public void setStrokes(Integer strokes) {
    this.strokes = strokes;
  }

  public Score relativeToPar(Integer relativeToPar) {
    this.relativeToPar = relativeToPar;
    return this;
  }

  /**
   * Score relative to par for this hole (negative is under par)
   * @return relativeToPar
  */
  
  @Schema(name = "relativeToPar", description = "Score relative to par for this hole (negative is under par)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("relativeToPar")
  public Integer getRelativeToPar() {
    return relativeToPar;
  }

  public void setRelativeToPar(Integer relativeToPar) {
    this.relativeToPar = relativeToPar;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Score score = (Score) o;
    return Objects.equals(this.playerId, score.playerId) &&
        Objects.equals(this.holeNumber, score.holeNumber) &&
        Objects.equals(this.strokes, score.strokes) &&
        Objects.equals(this.relativeToPar, score.relativeToPar);
  }

  @Override
  public int hashCode() {
    return Objects.hash(playerId, holeNumber, strokes, relativeToPar);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Score {\n");
    sb.append("    playerId: ").append(toIndentedString(playerId)).append("\n");
    sb.append("    holeNumber: ").append(toIndentedString(holeNumber)).append("\n");
    sb.append("    strokes: ").append(toIndentedString(strokes)).append("\n");
    sb.append("    relativeToPar: ").append(toIndentedString(relativeToPar)).append("\n");
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

