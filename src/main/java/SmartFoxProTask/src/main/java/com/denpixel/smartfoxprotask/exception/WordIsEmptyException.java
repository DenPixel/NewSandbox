package com.denpixel.smartfoxprotask.exception;

import org.springframework.http.HttpStatus;

public class WordIsEmptyException extends GameException {
    public WordIsEmptyException() {
        super(HttpStatus.BAD_REQUEST, "Word is empty");
    }
}
