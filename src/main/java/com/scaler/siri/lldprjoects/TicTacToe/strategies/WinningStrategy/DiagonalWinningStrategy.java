package com.scaler.siri.lldprjoects.TicTacToe.strategies.WinningStrategy;

import com.scaler.siri.lldprjoects.TicTacToe.Models.Board;
import com.scaler.siri.lldprjoects.TicTacToe.Models.Move;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy {
    Map<Character, Integer> leftDiagonalMap = new HashMap<>();
    Map<Character, Integer> rightDiagonalMap = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char symbol = move.getPlayer().getSymbol().getaChar();

        if(row == col){
            if(!leftDiagonalMap.containsKey(symbol)){
                leftDiagonalMap.put(symbol, 0);
            }
            leftDiagonalMap.put(symbol, leftDiagonalMap.get(symbol) + 1);

            if(leftDiagonalMap.get(symbol) == board.getDimension()){
                return true;
            }
        }
        else if(row+col == board.getDimension()-1){
            if(!rightDiagonalMap.containsKey(symbol)){
                rightDiagonalMap.put(symbol, 0);
            }
            rightDiagonalMap.put(symbol, rightDiagonalMap.get(symbol)+1);

            if(rightDiagonalMap.get(symbol) == board.getDimension()){
                return true;
            }
        }

        return false;
    }
}
