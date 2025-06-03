package controllers;



import Strategies.winningStrategy.WinningStrategy;
import models.*;

import java.util.List;

//Controller are stateless
//If we declare Game game; as an instance in GAmeController taht the controller is stateful with a single
//That mean sa gameController can start only a single game
public class GameController {

    //create game is the start of the game
    public Game createGame(int dimension , List<Player> players, List<WinningStrategy> winningStrategies){
//        return new Game().builder()
//                .setDimension(dimension)
//                .setPlayers(players)
//                .setWinningStrategies()
//                        .build();
        return null;
    }

    public void displayGame(Game game){
        game.getCurrentboard().displayBoard();
    }

    public GameStatus getGameStatus(Game game){
        return null;
    }

    public Move executeMove(Game game, Player player){
        return null;
    }

    public Player checkWinner(Game game, Move lastMover){
        return null;
    }

    public Board undoMove(Game game, Move lastPlayedMove){
        return null;
    }




}
