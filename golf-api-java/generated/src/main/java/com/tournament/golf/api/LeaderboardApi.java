/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.tournament.golf.api;

import com.tournament.golf.apimodel.Leaderboard;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-25T14:29:10.223704700-04:00[America/New_York]")
@Validated
@Tag(name = "Leaderboard", description = "Leaderboard operations")
public interface LeaderboardApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /api/leaderboard : Get current leaderboard
     *
     * @return Current leaderboard (status code 200)
     *         or No tournament exists (status code 404)
     */
    @Operation(
        operationId = "getLeaderboard",
        summary = "Get current leaderboard",
        tags = { "Leaderboard" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Current leaderboard", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Leaderboard.class))
            }),
            @ApiResponse(responseCode = "404", description = "No tournament exists")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/leaderboard",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Leaderboard> getLeaderboard(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"lastUpdated\" : \"2000-01-23T04:56:07.000+00:00\", \"players\" : [ { \"relativeToPar\" : \"relativeToPar\", \"currentScore\" : 5, \"playerName\" : \"playerName\", \"position\" : 0, \"parOfPlayedHoles\" : 1, \"holesCompleted\" : 10, \"playerId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, { \"relativeToPar\" : \"relativeToPar\", \"currentScore\" : 5, \"playerName\" : \"playerName\", \"position\" : 0, \"parOfPlayedHoles\" : 1, \"holesCompleted\" : 10, \"playerId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
