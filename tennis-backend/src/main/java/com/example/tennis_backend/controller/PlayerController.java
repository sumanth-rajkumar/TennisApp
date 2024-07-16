package com.example.tennis_backend.controller;

import com.example.tennis_backend.model.Player;
import com.example.tennis_backend.service.CsvReaderService;
import com.example.tennis_backend.service.PlayerSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {
    @Autowired
    private CsvReaderService csvReaderService;

    @Autowired
    private PlayerSearchService playerSearchService;

    @GetMapping("/loadPlayers")
    public String loadPlayers() {
        List<Player> players = csvReaderService.readCsv("path/to/your/file.csv");
        playerSearchService.addPlayers(players);
        return "Players loaded successfully!";
    }

    @GetMapping("/search")
    public Iterable<Player> searchPlayers(@RequestParam String suffix) {
        return playerSearchService.searchPlayers(suffix);
    }
}
