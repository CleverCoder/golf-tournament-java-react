package com.tournament.golf.controller;

import com.tournament.golf.api.LeaderboardApi;
import com.tournament.golf.apimodel.Leaderboard;
import com.tournament.golf.service.GolfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeaderboardController implements LeaderboardApi {
    private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);
    private final GolfService golfService;

    public LeaderboardController(GolfService golfService) {
        this.golfService = golfService;
    }

    @Override
    public ResponseEntity<Leaderboard> getLeaderboard() {
        return ResponseEntity.ok(golfService.getLeaderboard());
    }
}
