package com.example.tennis_backend.controller;

import com.example.tennis_backend.model.Player;
import com.example.tennis_backend.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/api/players/search")
    public List<Player> searchPlayers(@RequestParam String suffix) {
        return playerService.searchPlayersBySuffix(suffix);
    }
}
