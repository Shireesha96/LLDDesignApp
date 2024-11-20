package com.scaler.siri.lldprjoects.TicTacToe.strategies.WinningStrategy;

import com.scaler.siri.lldprjoects.TicTacToe.Models.Board;
import com.scaler.siri.lldprjoects.TicTacToe.Models.Move;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements WinningStrategy {
    Map<Integer, Map<Character, Integer>> colCounts = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        char symbol = move.getPlayer().getSymbol().getaChar();

        if(!colCounts.containsKey(col)){
            colCounts.put(col, new HashMap<>());
        }

        Map<Character, Integer> currentColCounts = colCounts.get(col);
        if(!currentColCounts.containsKey(symbol)){
            currentColCounts.put(symbol, 0);
        }

        currentColCounts.put(symbol, currentColCounts.get(symbol) + 1);

        if(currentColCounts.get(symbol) == board.getDimension())
        {
            return true;
        }
        return false;
    }
}
