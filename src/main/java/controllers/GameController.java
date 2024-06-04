package controllers;

import Strategies.winningStrategy.WinningStrategy;
import exception.MoreThanOneBotException;
import exception.PlayerCountMissMatchException;
import models.Game;
import models.GameState;
import models.Player;

import java.util.List;

//Controller are stateless
//If we declare Game game; as an instance in GAmeController taht the controller is stateful with a single
//That mean sa gameController can start only a single game
public class GameController {

    public Game startGame(int dimensionOfBoard, List<Player> players, List<WinningStrategy> winningStrategies) throws MoreThanOneBotException, PlayerCountMissMatchException {


        return Game
                .getBuilder()
                .setDimension(dimensionOfBoard)
                .setPlayers(players)
                .setWinningStrategy(winningStrategies)
                .build();

    }

    public void makeMove(Game game){
            game.makemove();
    }

    public GameState checkState(Game game){
        return  null;
    }

    public Player getWinner(Game game){
        return null;
    }

    public void displayBoard(){

    }

    public void undo(Game game){

    }



}
