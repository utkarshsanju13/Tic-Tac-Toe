package Strategies.botPlayingStrategy;

import models.BotDifficultyLevel;

public class BotPlayingStartegyFactory {

    public static BotPlayingStrategy getBotPLayingStrategy(BotDifficultyLevel botDifficultyLevel){

//        This below code could be there but we implement only EasyBotPlayingStarategy
//        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY)){
//            return new EasyBotPlayingStarategy();
//        }else if(botDifficultyLevel.equals(BotDifficultyLevel.MEDIUM)){
//            return new MeduimBotPlayingStrategy();
//        }else{
//            return new HardBotPlayingStrategy();
//        }
        //TODO : Add other medium and hard
        return new EasyBotPlayingStarategy();
    }
}
