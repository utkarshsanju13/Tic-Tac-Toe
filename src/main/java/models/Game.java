package models;

import Strategies.winningStrategy.WinningStrategy;
import exception.MoreThanOneBotException;
import exception.PlayerCountMissMatchException;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players;

    private Board board;

    private List<Move> moves;

    private Player winner;

    private GameState gameState;

    private int nextMovePlayerIndex;

    private List<WinningStrategy> winningStategies;

    //Always try to write constructor to avoid null pointer exception
    private Game(int dimension, List<WinningStrategy> winningStrategies, List<Player> players){
        this.winningStategies = winningStrategies;
        this.players = players;
        this.board = new Board(dimension);
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.nextMovePlayerIndex = 0;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public void makemove() {
        Player currentMovePlayer = players.get(nextMovePlayerIndex);
        System.out.println("It is "+ currentMovePlayer.getName() + " 's move. Please make your move");

        Move move = currentMovePlayer.makeMove(board);




    }


    //Game builder is called by controller
    public static class Builder{
        private List<Player> players;

        private int dimension;

        private List<WinningStrategy> winningStrategies;

        public Builder setPlayers(List<Player> players){
            this.players = players;
            return this;
        }

        public Builder setDimension(int dimension){
            this.dimension = dimension;
            return this;
        }

        public Builder setWinningStrategy(List<WinningStrategy> winningStrategies){
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Builder addPlayer(Player player){
            this.players.add(player);
            return this;
        }

        public Builder addWinningStrategy(WinningStrategy winningStrategy){
            this.winningStrategies.add(winningStrategy);
            return this;
        }

        private void validateBotCount() throws MoreThanOneBotException {
            int botCount = 0;
            for(Player player: players){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount++;
                }
            }

            if(botCount > 1){
                throw new MoreThanOneBotException();
            }
        }

        private void validatePlayerCount() throws PlayerCountMissMatchException {
            if(players.size() != dimension - 1){
                throw new PlayerCountMissMatchException();
            }
        }

        private void validateUniqueSymbolForPlayers(){

        }

        public void validate() throws MoreThanOneBotException, PlayerCountMissMatchException {
            validateBotCount();
            validatePlayerCount();
            validateUniqueSymbolForPlayers();
        }

        public Game build() throws MoreThanOneBotException, PlayerCountMissMatchException {
            validate();
            return new Game(dimension, winningStrategies, players);
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }

    public List<WinningStrategy> getWinningStategies() {
        return winningStategies;
    }

    public void setWinningStategies(List<WinningStrategy> winningStategies) {
        this.winningStategies = winningStategies;
    }
}
