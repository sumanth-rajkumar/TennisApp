package com.example.tennis_backend.service;

import com.example.tennis_backend.model.Player;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Service
public class PlayerService {

    @Value("${csv.file.path}")
    private String csvFilePath;

    private final ResourceLoader resourceLoader;
    private List<Player> players;

    public PlayerService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @PostConstruct
    public void loadPlayers() {
        Resource csvFile = resourceLoader.getResource(csvFilePath);
        try (Reader reader = new InputStreamReader(csvFile.getInputStream())) {
            players = new CsvToBeanBuilder<Player>(reader)
                .withType(Player.class)
                .build()
                .parse();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load players from CSV file", e);
        }
    }

    public List<Player> searchPlayersBySuffix(String suffix) {
        return players.stream()
            .filter(player -> player.getName().endsWith(suffix))
            .toList();
    }
}
