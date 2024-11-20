package com.scaler.siri.lldprjoects;

import com.scaler.siri.lldprjoects.TicTacToe.Exceptions.DuplicateSymbolFoundException;
import com.scaler.siri.lldprjoects.TicTacToe.Exceptions.InvalidBotCountException;
import com.scaler.siri.lldprjoects.TicTacToe.Exceptions.InvalidPlayerCountException;
import com.scaler.siri.lldprjoects.TicTacToe.Models.*;
import com.scaler.siri.lldprjoects.TicTacToe.controller.GameController;
import com.scaler.siri.lldprjoects.TicTacToe.strategies.WinningStrategy.ColWinningStrategy;
import com.scaler.siri.lldprjoects.TicTacToe.strategies.WinningStrategy.DiagonalWinningStrategy;
import com.scaler.siri.lldprjoects.TicTacToe.strategies.WinningStrategy.RowWinningStrategy;
import com.scaler.siri.lldprjoects.TicTacToe.strategies.WinningStrategy.WinningStrategy;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class LldPrjoectsApplication {

    public static void main(String[] args) throws InvalidBotCountException, InvalidPlayerCountException, DuplicateSymbolFoundException {

        //start the game
        //Game.Builder builder = new Game.Builder();
//        builder.setDimension(3).setPlayers(new ArrayList<>()).setWinningStrategies(null);
//        Game game = builder.build();

        // Game class itslef should provide Builder class object
//        Game game = new Game.Builder()
//                .setDimension(3)
//                .setPlayers(new ArrayList<>())
//                .setWinningStrategies(null)
//                .build();

        //to have a layer of abstraction, instead of directly accessing the game class in client(main method) use controller

        GameController gameController = new GameController();
        List<Player> players = List.of(
                new Player(1, "Kunal", PlayerType.HUMAN, new Symbol('X')),
                new Player(2, "Siri", PlayerType.HUMAN, new Symbol('O'))
               // new Bot(2,"Bot",new Symbol('O'), BotDifficultyLevel.EASY)
        );

        List<WinningStrategy> winningStrategies = List.of(
                new RowWinningStrategy(),
                new ColWinningStrategy(),
                new DiagonalWinningStrategy()
        );
        Game game = gameController.startGame(3, players, winningStrategies);
        while(gameController.checkState(game) == GameState.IN_PROGRESS){

            gameController.printBoard(game);

            gameController.makeMove(game);
        }

        if(gameController.checkState(game) == GameState.ENDED){
            System.out.println("Game Ended");
            System.out.println("Winner is " + gameController.getWinner(game));
        }
        else if(gameController.checkState(game) == GameState.DRAW){
            System.out.println("Game Ended");
            System.out.println("GAME DRAW");
        }
    }

}
