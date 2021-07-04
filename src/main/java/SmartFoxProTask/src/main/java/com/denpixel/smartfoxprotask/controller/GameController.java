package com.denpixel.smartfoxprotask.controller;

import com.denpixel.smartfoxprotask.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    private final GameService service;

    @Autowired
    public GameController(GameService service) {
        this.service = service;
    }

    @GetMapping("/begin")
    public String begin() {
        return service.start();
    }

    @GetMapping("/next")
    public String next(@RequestParam String word) {
        return service.nextWord(word);
    }

    @PostMapping("/end")
    public String end() {
        return service.end();
    }

}
