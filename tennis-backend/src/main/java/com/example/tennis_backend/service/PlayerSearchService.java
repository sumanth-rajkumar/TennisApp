package com.example.tennis_backend.service;

import com.example.tennis_backend.model.Player;
import com.googlecode.concurrenttrees.radix.ConcurrentRadixTree;
import com.googlecode.concurrenttrees.radix.RadixTree;
import com.googlecode.concurrenttrees.radix.node.concrete.DefaultCharArrayNodeFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerSearchService {
    private RadixTree<Player> tree = new ConcurrentRadixTree<>(new DefaultCharArrayNodeFactory());

    public void addPlayers(List<Player> players) {
        for (Player player : players) {
            tree.put(player.getName(), player);
        }
    }

    public Iterable<Player> searchPlayers(String character) {
        return tree.getValuesForKeysStartingWith(character);
    }
}

