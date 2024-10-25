package com.tournament.golf.controller;

import com.tournament.golf.api.ScoresApi;
import com.tournament.golf.apimodel.Score;
import com.tournament.golf.apimodel.ScoreSubmission;
import com.tournament.golf.service.GolfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoresController implements ScoresApi {
    private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);
    private final GolfService golfService;

    public ScoresController(GolfService golfService) {
        this.golfService = golfService;
    }

    @Override
    public ResponseEntity<Score> submitScore(ScoreSubmission scoreSubmission) {
        return ResponseEntity.ok(this.golfService.submitScore(scoreSubmission));
    }
}
