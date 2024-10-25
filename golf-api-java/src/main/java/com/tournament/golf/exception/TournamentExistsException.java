package com.tournament.golf.exception;

public class TournamentExistsException extends RuntimeException {
    public TournamentExistsException(String message) {
        super(message);
    }
}
