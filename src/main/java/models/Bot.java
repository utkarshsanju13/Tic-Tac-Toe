package models;

import Strategies.botPlayingStrategy.BotPlayingStartegyFactory;
import Strategies.botPlayingStrategy.BotPlayingStrategy;

public class Bot extends Player {

    private BotDifficultyLevel botDifficultyLevel;

    private BotPlayingStrategy botPlayingStrategy;

    public Bot(Long id, Symbol symbol, String name, BotDifficultyLevel botDifficultyLevel){
        super(id,symbol,name,PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
//        this.botPlayingStrategy = getBotStrategyBasedOnDifficultyLevel(botDifficultyLevel); THIS should not initialize we at backend decide the strategy on the basis of
//        botDifficultyLevel
        this.botPlayingStrategy = BotPlayingStartegyFactory.getBotPLayingStrategy(botDifficultyLevel);
    }

    @Override
    public Move makeMove(Board board){
            Move move = botPlayingStrategy.makeMove(board);
            move.setPlayer(this);

            return move;
    }
}
