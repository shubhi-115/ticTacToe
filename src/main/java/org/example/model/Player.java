package org.example.model;

public class Player {
    private int id;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return Symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    private String name;
    private char Symbol;
    private PlayerType playerType;
}
