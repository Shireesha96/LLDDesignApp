package com.scaler.siri.lldprjoects.TicTacToe.strategies.WinningStrategy;

import com.scaler.siri.lldprjoects.TicTacToe.Models.Board;
import com.scaler.siri.lldprjoects.TicTacToe.Models.Move;
import com.scaler.siri.lldprjoects.TicTacToe.Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy {
    Map<Integer, Map<Character, Integer>> rowCounts = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        char symbol = move.getPlayer().getSymbol().getaChar();

        if(!rowCounts.containsKey(row)) {
            rowCounts.put(row, new HashMap<>());
        }

        Map<Character, Integer> currentRowCounts = rowCounts.get(row);
        if(!currentRowCounts.containsKey(symbol))
        {
            currentRowCounts.put(symbol, 0);
        }

        currentRowCounts.put(symbol, currentRowCounts.get(symbol) + 1);

        if(currentRowCounts.get(symbol) == board.getDimension()){
            return true;
        }
        return false;

    }
}
