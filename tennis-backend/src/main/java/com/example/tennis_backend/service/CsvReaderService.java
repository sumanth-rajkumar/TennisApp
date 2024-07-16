package com.example.tennis_backend.service;

import com.example.tennis_backend.model.Player;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvReaderService {
    public List<Player> readCsv(String filePath) {
        List<Player> players = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Player player = new Player(values[0], values[1], values[2], values[3]); // Adjust as per your CSV structure
                players.add(player);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }

}
