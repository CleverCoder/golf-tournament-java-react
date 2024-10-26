/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.tournament.golf.api;

import com.tournament.golf.apimodel.Score;
import com.tournament.golf.apimodel.ScoreSubmission;
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
@Tag(name = "Scores", description = "Score tracking operations")
public interface ScoresApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/scores : Submit score for a hole
     *
     * @param scoreSubmission  (required)
     * @return Score recorded (status code 201)
     *         or No tournament exists or player not found (status code 404)
     */
    @Operation(
        operationId = "submitScore",
        summary = "Submit score for a hole",
        tags = { "Scores" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Score recorded", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Score.class))
            }),
            @ApiResponse(responseCode = "404", description = "No tournament exists or player not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/api/scores",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Score> submitScore(
        @Parameter(name = "ScoreSubmission", description = "", required = true) @Valid @RequestBody ScoreSubmission scoreSubmission
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"strokes\" : 1, \"relativeToPar\" : 1, \"holeNumber\" : 2, \"playerId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}