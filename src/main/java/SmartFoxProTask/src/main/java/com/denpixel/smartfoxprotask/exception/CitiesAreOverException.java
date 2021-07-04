package com.denpixel.smartfoxprotask.exception;

import org.springframework.http.HttpStatus;

public class CitiesAreOverException extends GameException {
    public CitiesAreOverException() {
        super(HttpStatus.NOT_FOUND, "Cities are over");
    }
}
