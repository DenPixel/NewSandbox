package com.denpixel.smartfoxprotask.exception;

import org.springframework.http.HttpStatus;

public class CityNotFoundException extends GameException {
    public CityNotFoundException(String city) {
        super(HttpStatus.BAD_REQUEST, "City " + city + " not found");
    }
}
