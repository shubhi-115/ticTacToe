package org.example.model;
import org.example.exception.InvalidBotCountException;
import org.example.exception.InvalidDimensionException;
import org.example.exception.InvalidPlayerException;
import org.example.service.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
public class Game {
    private int dimension;
    private List<Player> players;
    private Player currentPlayer;
    private GameStatus gameStatus;
    private Player winner;
    private List<Move> moves;
    private List<Board> boardStates;
    private WinningStrategy winningStrategy;

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public List<Board> getBoardStates() {
        return boardStates;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    private Game(List<Player> players,int dimension, WinningStrategy winningStrategy) {
        this.dimension = dimension;
        this.players = players;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.moves =new ArrayList<Move>();
        this.boardStates = new ArrayList<>();
        this.winningStrategy= winningStrategy;
    }
    public static Builder create(){
        return new Builder();
    }
    public static class Builder{
        private int dimension;
        private List<Player> players;
        private WinningStrategy winningStrategy;
        public Builder setPlayers(List<Player> players){
            this.players = players;
            return this;
        }
        public Builder setDimension(Integer dimension){
            this.dimension =dimension;
            return this;
        }
        public Builder setWinningStrategy(WinningStrategy winningStrategy){
            this.winningStrategy = winningStrategy;
            return this;
        }
        private void validateBotCount() throws InvalidBotCountException{
            int botCount = 0;
            for(Player player : players){
                if(player.getPlayerType().equals(PlayerType.BOT)) {
                    botCount++;
                }
            }
            if(botCount > 1){
                throw new InvalidBotCountException("Bot count cannot be greater than 1");
            }
        }
        private void validateDimension() throws InvalidDimensionException{
            if(dimension < 3 || dimension > 10)
                throw new InvalidDimensionException("Dimension must be between 3 and 10");
        }
        private void validatePlayer() throws InvalidPlayerException {
            if(players.size() != (dimension-1))
                throw new InvalidPlayerException("Number of player is invalid");
            HashSet<Character> symbolSet = new HashSet<>();
            for(Player player : players){
                symbolSet.add(player.getSymbol());
            }
            if(symbolSet.size() != players.size())
                throw new InvalidPlayerException("Players do not have unique symbol");
        }
        private void validate() throws InvalidDimensionException, InvalidBotCountException, InvalidPlayerException {
            validateBotCount();
            validateDimension();
            validatePlayer();
        }
        public Game build() throws InvalidBotCountException, InvalidPlayerException, InvalidDimensionException {
            validate();
            return new Game(players,dimension, winningStrategy);
        }
    }

}
