package com.scaler.siri.lldprjoects.TicTacToe.controller;

import com.scaler.siri.lldprjoects.TicTacToe.Exceptions.DuplicateSymbolFoundException;
import com.scaler.siri.lldprjoects.TicTacToe.Exceptions.InvalidBotCountException;
import com.scaler.siri.lldprjoects.TicTacToe.Exceptions.InvalidPlayerCountException;
import com.scaler.siri.lldprjoects.TicTacToe.Models.Game;
import com.scaler.siri.lldprjoects.TicTacToe.Models.GameState;
import com.scaler.siri.lldprjoects.TicTacToe.Models.Player;
import com.scaler.siri.lldprjoects.TicTacToe.strategies.WinningStrategy.WinningStrategy;

import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) throws InvalidBotCountException, InvalidPlayerCountException, DuplicateSymbolFoundException {
        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public GameState checkState(Game game){
        return game.getGameState();
    }

    public String getWinner(Game game){
        return game.getWinner().getName();
    }

    public void printBoard(Game game){
        game.printBoard();
    }

}
