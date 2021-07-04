package com.denpixel.smartfoxprotask.exception;

import org.springframework.http.HttpStatus;

public class CharacterMismatchException extends GameException {
    public CharacterMismatchException() {
        super(
                HttpStatus.BAD_REQUEST,
                "The first letter of the player's word does not match the last letter of the system"
        );
    }
}
