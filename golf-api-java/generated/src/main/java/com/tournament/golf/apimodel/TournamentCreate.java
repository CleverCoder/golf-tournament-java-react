package com.tournament.golf.apimodel;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * TournamentCreate
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-25T14:29:10.223704700-04:00[America/New_York]")
public class TournamentCreate {

  @Valid
  private List<Integer> coursePars = new ArrayList<>();

  public TournamentCreate() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TournamentCreate(List<Integer> coursePars) {
    this.coursePars = coursePars;
  }

  public TournamentCreate coursePars(List<Integer> coursePars) {
    this.coursePars = coursePars;
    return this;
  }

  public TournamentCreate addCourseParsItem(Integer courseParsItem) {
    if (this.coursePars == null) {
      this.coursePars = new ArrayList<>();
    }
    this.coursePars.add(courseParsItem);
    return this;
  }

  /**
   * Array of par values for each hole
   * @return coursePars
  */
  @NotNull @Size(min = 18, max = 18) 
  @Schema(name = "coursePars", example = "[4,5,3,4,5,4,4,3,4,4,4,4,4,5,4,3,5,3]", description = "Array of par values for each hole", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("coursePars")
  public List<Integer> getCoursePars() {
    return coursePars;
  }

  public void setCoursePars(List<Integer> coursePars) {
    this.coursePars = coursePars;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TournamentCreate tournamentCreate = (TournamentCreate) o;
    return Objects.equals(this.coursePars, tournamentCreate.coursePars);
  }

  @Override
  public int hashCode() {
    return Objects.hash(coursePars);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TournamentCreate {\n");
    sb.append("    coursePars: ").append(toIndentedString(coursePars)).append("\n");
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

