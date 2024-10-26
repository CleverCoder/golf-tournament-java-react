package com.tournament.golf.apimodel;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Tournament
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-25T14:29:10.223704700-04:00[America/New_York]")
public class Tournament {

  private UUID id;

  @Valid
  private List<Integer> coursePars;

  private Integer totalPar;

  public Tournament id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @Valid 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Tournament coursePars(List<Integer> coursePars) {
    this.coursePars = coursePars;
    return this;
  }

  public Tournament addCourseParsItem(Integer courseParsItem) {
    if (this.coursePars == null) {
      this.coursePars = new ArrayList<>();
    }
    this.coursePars.add(courseParsItem);
    return this;
  }

  /**
   * Array of par values for each hole (must be 18 holes)
   * @return coursePars
  */
  
  @Schema(name = "coursePars", description = "Array of par values for each hole (must be 18 holes)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("coursePars")
  public List<Integer> getCoursePars() {
    return coursePars;
  }

  public void setCoursePars(List<Integer> coursePars) {
    this.coursePars = coursePars;
  }

  public Tournament totalPar(Integer totalPar) {
    this.totalPar = totalPar;
    return this;
  }

  /**
   * Get totalPar
   * @return totalPar
  */
  
  @Schema(name = "totalPar", example = "72", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalPar")
  public Integer getTotalPar() {
    return totalPar;
  }

  public void setTotalPar(Integer totalPar) {
    this.totalPar = totalPar;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tournament tournament = (Tournament) o;
    return Objects.equals(this.id, tournament.id) &&
        Objects.equals(this.coursePars, tournament.coursePars) &&
        Objects.equals(this.totalPar, tournament.totalPar);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, coursePars, totalPar);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tournament {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    coursePars: ").append(toIndentedString(coursePars)).append("\n");
    sb.append("    totalPar: ").append(toIndentedString(totalPar)).append("\n");
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

