package com.scaler.siri.lldprjoects.TicTacToe.strategies.WinningStrategy;

import com.scaler.siri.lldprjoects.TicTacToe.Models.Board;
import com.scaler.siri.lldprjoects.TicTacToe.Models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
