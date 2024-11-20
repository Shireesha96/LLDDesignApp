package com.scaler.siri.lldprjoects.TicTacToe.Models;

import com.scaler.siri.lldprjoects.TicTacToe.factories.BotPlayingStrategyFactory;
import com.scaler.siri.lldprjoects.TicTacToe.strategies.BotPlayingStrategy.BotPlayingStrategy;

public class Bot extends Player{
    private BotDifficultyLevel difficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(long id, String name, Symbol symbol, BotDifficultyLevel difficultyLevel)
    {
        super(id, name, PlayerType.BOT, symbol);
        this.difficultyLevel = difficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyForDifficultyLevel(difficultyLevel);
    }

    public BotDifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {

        Move move = botPlayingStrategy.makeMove(board);
        move.setPlayer(this);
        return move;
    }

}
