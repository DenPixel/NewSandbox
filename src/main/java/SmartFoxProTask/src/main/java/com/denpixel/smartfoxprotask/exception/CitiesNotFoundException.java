package com.denpixel.smartfoxprotask.exception;

import org.springframework.http.HttpStatus;

public class CitiesNotFoundException extends GameException {
    public CitiesNotFoundException() {
        super(HttpStatus.NOT_FOUND);
    }
}
