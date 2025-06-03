package models;

public class Bot extends Player{

    private BotDifficultyLevel botDifficultyLevel;

    public Bot(int id, char symbol) {
        super(id, "CHITTI", symbol, PlayerType.BOT);
    }

    public Move makeMove(Board board) {
        return null;
    }
}
