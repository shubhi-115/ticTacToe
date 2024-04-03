package org.example.model;

public class Player {
    private int id;

    private String name;
    private char symbol;
    private PlayerType playerType;
    private Player(){

    }
    private Player(int id, String name, char symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }
    public static Builder create() {
        return new Builder();
    }
    public static class Builder{
        private int id;
        private String name;
        private char symbol;
        private PlayerType playerType;
        public Builder setId(int id) {
            this.id = id;
            return this;
        }
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setSymbol(char symbol) {
            this.symbol = symbol;
            return this;
        }
        public Builder setPlayerType(PlayerType playerType) {
            this.playerType = playerType;
            return this;
        }
        public Player build(){
            return new Player(this.id, this.name, this.symbol, this.playerType);
        }
    }
}
