package com.scaler.siri.lldprjoects.TicTacToe.strategies.BotPlayingStrategy;

import com.scaler.siri.lldprjoects.TicTacToe.Models.Board;
import com.scaler.siri.lldprjoects.TicTacToe.Models.Cell;
import com.scaler.siri.lldprjoects.TicTacToe.Models.CellState;
import com.scaler.siri.lldprjoects.TicTacToe.Models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Board board) {
       for(List<Cell> row : board.getBoard()){
           for(Cell cell : row){
               if(cell.getCellState() == CellState.EMPTY){
                   return new Move(cell, null
                   );
               }
           }
       }
        return null;
    }
}
