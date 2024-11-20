package com.scaler.siri.lldprjoects.TicTacToe.strategies.BotPlayingStrategy;

import com.scaler.siri.lldprjoects.TicTacToe.Models.Board;
import com.scaler.siri.lldprjoects.TicTacToe.Models.Move;

public interface BotPlayingStrategy {
     Move makeMove(Board board);
}
