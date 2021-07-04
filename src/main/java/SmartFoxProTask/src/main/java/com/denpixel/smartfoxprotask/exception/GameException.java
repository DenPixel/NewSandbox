package com.denpixel.smartfoxprotask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class GameException extends ResponseStatusException {
    public GameException(HttpStatus status) {
        super(status);
    }

    public GameException(HttpStatus status, String reason) {
        super(status, reason);
    }
}
