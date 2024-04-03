package org.example;

import org.example.exception.InvalidBotCountException;
import org.example.exception.InvalidDimensionException;
import org.example.exception.InvalidPlayerException;
import org.example.model.Board;
import org.example.model.Game;
import org.example.model.Player;
import org.example.model.PlayerType;
import org.example.service.WinningStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InvalidBotCountException, InvalidPlayerException, InvalidDimensionException {
        WinningStrategy winningStrategy = null;

        System.out.println("Make board");
        int dimension = 3;

        //Players
        Player player1 = Player.create()
                            .setName("Player_1")
                            .setId(1)
                            .setPlayerType(PlayerType.HUMAN)
                            .setSymbol('*')
                            .build();
        Player player2 = Player.create()
                .setName("Player_2")
                .setId(2)
                .setPlayerType(PlayerType.HUMAN)
                .setSymbol('0')
                .build();
        Game game = Game.create()
                        .setPlayers(List.of(player1, player2))
                        .setDimension(dimension)
                        .setWinningStrategy(winningStrategy)
                        .build();
        Board board = new Board(dimension);
        board.display();
//
    }
}