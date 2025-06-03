package models;

import Strategies.winningStrategy.WinningStrategy;
import exception.InvalidBotCountException;
import exception.InvalidPlayerSizeException;
import exception.InvalidSymbolSetupException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private Board currentboard;
    private List<Player> players;
    private Player currentPlayer;
    private GameStatus gameStatus;
    private List<Move> moves;
    private List<Board> boardState;
    private List<WinningStrategy> winningStrategies;

    private int numberOfSymbol;

    private Game(Board currentboard, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.currentboard = currentboard;
        this.players = players;
        this.currentPlayer = null;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.boardState = new ArrayList<>();
        this.winningStrategies = winningStrategies;
        this.numberOfSymbol = players.size();
    }

    public static Builder builder(){
        return new Builder();
    }

    public Board getCurrentboard() {
        return currentboard;
    }

    public void setCurrentboard(Board currentboard) {
        this.currentboard = currentboard;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<Board> getBoardState() {
        return boardState;
    }

    public void setBoardState(List<Board> boardState) {
        this.boardState = boardState;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public int getNumberOfSymbol() {
        return numberOfSymbol;
    }

    public void setNumberOfSymbol(int numberOfSymbol) {
        this.numberOfSymbol = numberOfSymbol;
    }

    public static class Builder{

        private Board currentboard;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimension;


        public Builder setCurrentboard(Board currentboard) {
            this.currentboard = currentboard;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        private void validateNUmberOfPlayers(){
            // boars size is N : player will be N-1
            //if there is bot : player will be N-2

            if(players.size() < currentboard.getDimension() -2 || players.size() >= currentboard.getDimension()){
                throw new InvalidPlayerSizeException("Player size should be N-2 or N-1 as per the board size");
            }
        }

        private void validatePlayerSymbol(){
//            HashSet<Character> symbols = new HashSet<>();
//            //TODO : convert to below using lambada and streams
//
//            for(Player player: players){
//                symbols.add(player.getSymbol());
//            }

            HashSet<Character> symbols = players.stream()
                    .map(Player::getSymbol)
                    .collect(Collectors.toCollection(HashSet::new));

            if(symbols.size() != players.size()){
                throw new InvalidSymbolSetupException("There should be unique symbol of every player");
            }
        }

        private void validateBotCount(){
//            int botCount = 0;
//            //TODO : convert to below using lambada and streams
//            for(Player  players : players){
//                if(players.getPlayerType().equals(PlayerType.BOT)){
//                    botCount++;
//                }
//            }

            long botCount = (int) players.stream()
                    .filter(player -> player.getPlayerType().equals(PlayerType.BOT))
                    .count();

            if(botCount > 1 || botCount < 0){
                throw new InvalidBotCountException("The number of bot is invalid");
            }
        }

        private void validate(){
            validateBotCount();
            validatePlayerSymbol();
            validateNUmberOfPlayers();
        }

        public Game build(){
            validate();
            return  new Game(new Board(dimension),players,winningStrategies);
        }

    }
}
