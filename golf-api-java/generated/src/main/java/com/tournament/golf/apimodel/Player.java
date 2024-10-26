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
 * Player
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-25T14:29:10.223704700-04:00[America/New_York]")
public class Player {

  private UUID id;

  private String name;

  private Integer holesCompleted;

  private Integer relativeToPar;

  public Player id(UUID id) {
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

  public Player name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Player holesCompleted(Integer holesCompleted) {
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

  public Player relativeToPar(Integer relativeToPar) {
    this.relativeToPar = relativeToPar;
    return this;
  }

  /**
   * Current score relative to par (negative is under par)
   * @return relativeToPar
  */
  
  @Schema(name = "relativeToPar", description = "Current score relative to par (negative is under par)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    Player player = (Player) o;
    return Objects.equals(this.id, player.id) &&
        Objects.equals(this.name, player.name) &&
        Objects.equals(this.holesCompleted, player.holesCompleted) &&
        Objects.equals(this.relativeToPar, player.relativeToPar);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, holesCompleted, relativeToPar);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Player {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    holesCompleted: ").append(toIndentedString(holesCompleted)).append("\n");
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

