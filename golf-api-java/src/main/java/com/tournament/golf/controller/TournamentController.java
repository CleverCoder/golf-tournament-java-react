package com.tournament.golf.controller;

import com.tournament.golf.api.TournamentApi;
import com.tournament.golf.apimodel.Tournament;
import com.tournament.golf.apimodel.TournamentCreate;
import com.tournament.golf.service.GolfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TournamentController implements TournamentApi {

    private static final Logger logger = LoggerFactory.getLogger(TournamentController.class);
    private final GolfService golfService;

    public TournamentController(GolfService golfService) {
        this.golfService = golfService;
    }

    @Override
    public ResponseEntity<Tournament> getTournament() {
        var t = golfService.getTournament();
        if (t == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(golfService.getTournament());
    }

    @Override
    public ResponseEntity<Tournament> createTournament(TournamentCreate tournamentCreate) {
        var t = golfService.createTournament(tournamentCreate);
        return ResponseEntity.ok(t);
    }

}
