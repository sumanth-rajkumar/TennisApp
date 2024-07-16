package com.example.tennis_backend.model;

public class Player {

    private String id;
    private String name;
    private String country;
    private String ranking;

    // Getters and Setters
    public Player(String id, String name, String country, String ranking) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.ranking = ranking;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }
}
