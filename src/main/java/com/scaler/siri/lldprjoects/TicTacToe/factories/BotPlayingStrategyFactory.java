package com.scaler.siri.lldprjoects.TicTacToe.factories;

import com.scaler.siri.lldprjoects.TicTacToe.Models.BotDifficultyLevel;
import com.scaler.siri.lldprjoects.TicTacToe.strategies.BotPlayingStrategy.BotPlayingStrategy;
import com.scaler.siri.lldprjoects.TicTacToe.strategies.BotPlayingStrategy.HardBotPlayingStrategy;
import com.scaler.siri.lldprjoects.TicTacToe.strategies.BotPlayingStrategy.EasyBotPlayingStrategy;
import com.scaler.siri.lldprjoects.TicTacToe.strategies.BotPlayingStrategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyForDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        if(difficultyLevel == BotDifficultyLevel.EASY) {
            return new EasyBotPlayingStrategy();
        }
        else if(difficultyLevel == BotDifficultyLevel.MEDIUM){
            return new MediumBotPlayingStrategy();
        }
        else if(difficultyLevel == BotDifficultyLevel.HARD) {
            return new HardBotPlayingStrategy();
        }
        return null;
    }

}
