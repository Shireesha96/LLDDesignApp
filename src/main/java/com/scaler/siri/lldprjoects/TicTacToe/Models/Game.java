package com.scaler.siri.lldprjoects.TicTacToe.Models;

import com.scaler.siri.lldprjoects.TicTacToe.Exceptions.DuplicateSymbolFoundException;
import com.scaler.siri.lldprjoects.TicTacToe.Exceptions.InvalidBotCountException;
import com.scaler.siri.lldprjoects.TicTacToe.Exceptions.InvalidPlayerCountException;
import com.scaler.siri.lldprjoects.TicTacToe.strategies.WinningStrategy.WinningStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Setter
@Getter
public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState;
    private Player winner;
    private int nextPlayerMoveIndex;
    private List<WinningStrategy> winningStrategies;

    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = new Board(dimension);
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.winningStrategies = winningStrategies;
        this.nextPlayerMoveIndex = 0;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        if(row >= 0 && row < board.getDimension() && col >= 0 && col < board.getDimension()
        && board.getBoard().get(row).get(col).getCellState() == CellState.EMPTY){
            return true;
        }
        return false;
    }

    public void makeMove()
    {
        Player currentPlayer = players.get(nextPlayerMoveIndex);
        System.out.println("Current player move: " + currentPlayer.getName());

        Move currentMove = currentPlayer.makeMove(board);
        if(!validateMove(currentMove)){
            return;
        }
        //move is invalid, add move in the board
        int row = currentMove.getCell().getRow();
        int col = currentMove.getCell().getCol();

        Cell cellToMark = board.getBoard().get(row).get(col);
        cellToMark.setPlayer(currentPlayer);
        cellToMark.setCellState(CellState.FILLED);

        Move finalMove = new Move(cellToMark, currentPlayer);
        moves.add(finalMove);

        nextPlayerMoveIndex++;
        nextPlayerMoveIndex = nextPlayerMoveIndex%players.size();

        //check if current player has won the game
        if(checkWinner(board, finalMove)){
            gameState = GameState.ENDED;
            winner = currentPlayer;
        }
        else if(moves.size() == board.getDimension() * board.getDimension()){
            gameState = GameState.DRAW;
        }
    }

    private boolean checkWinner(Board board, Move move) {
        for(WinningStrategy winningStrategy : winningStrategies) {
            if (winningStrategy.checkWinner(board, move)) {
                return true;
            }
        }
        return false;
    }

    public void printBoard(){
        board.printBoard();
    }

    //builder class as we shouldn't create Game object directly without validation
    // and have many parameters - Builder Design pattern

    public static class Builder
    {
        private List<Player> players;
        private int dimension;
        private List<WinningStrategy> winningStrategies;

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        private void validatePlayerSymbolCount() throws DuplicateSymbolFoundException {
            Map<Character, Integer> symbolCount = new HashMap<>();

            for(Player p : players){
                if(!symbolCount.containsKey(p.getSymbol().getaChar())){
                    symbolCount.put(p.getSymbol().getaChar(), 0);
                }

                symbolCount.put(p.getSymbol().getaChar(), symbolCount.get(p.getSymbol().getaChar()) + 1);

                if(symbolCount.get(p.getSymbol().getaChar()) > 1){
                    throw new DuplicateSymbolFoundException("No two players shoudln't have same symbol");
                }

            }

        }

        private void validatePlayerCount() throws InvalidPlayerCountException {
            if(players.size() != dimension-1){
                throw new InvalidPlayerCountException("Number of players should be " + (dimension - 1));
            }
        }

        private void validateBotCount() throws InvalidBotCountException {
            int botCount = 0;
            for(Player p : players){
                if(p.getPlayerType() == PlayerType.BOT){
                    botCount++;
                }

                if(botCount > 1){
                    throw new InvalidBotCountException("Only 1 bot is allowed per game");
                }
            }
        }

        private void validate() throws InvalidPlayerCountException, InvalidBotCountException, DuplicateSymbolFoundException {
            //validate no 2 players have same symbol
            validatePlayerSymbolCount();
            //validate number of players (player count = number of dimensions -1 allowed)
            validatePlayerCount();
            //validate bot count - only 1 bot allowed
            validateBotCount();
        }

        public Game build() throws InvalidBotCountException, InvalidPlayerCountException, DuplicateSymbolFoundException {
            validate();
            return new Game(
                dimension,
                players,
                winningStrategies
            );
        }


    }

}
