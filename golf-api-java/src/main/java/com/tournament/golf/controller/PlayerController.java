package com.tournament.golf.controller;

import com.tournament.golf.api.PlayersApi;
import com.tournament.golf.apimodel.Player;
import com.tournament.golf.apimodel.PlayerCreate;
import com.tournament.golf.service.GolfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController implements PlayersApi {

    private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);
    private final GolfService golfService;

    public PlayerController(GolfService golfService) {
        this.golfService = golfService;
    }

    @Override
    public ResponseEntity<Player> createPlayer(PlayerCreate playerCreate) {
        return ResponseEntity.ok(this.golfService.addPlayer(playerCreate));
    }

    @Override
    public ResponseEntity<List<Player>> listPlayers() {
        return ResponseEntity.ok(this.golfService.getPlayers());
    }
}
