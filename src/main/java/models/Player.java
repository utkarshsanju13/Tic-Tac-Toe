package models;

import exception.InvalidRowOrColMoveException;

import java.util.Scanner;

public class Player {

    private int id;
    private String name;
    private char Symbol;
    private PlayerType playerType;

    public Player(int id, String name, char symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        Symbol = symbol;
        this.playerType = playerType;
    }

    public Move makeMove(Board board) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row for the target cell");
        int row = sc.nextInt();
        System.out.println("Enter the col for the target cell");
        int col = sc.nextInt();

        if(row > board.getDimension()-1 || col > board.getDimension()-1){
            throw new InvalidRowOrColMoveException("Please enter a valid row and coumn to make the vlaid move");
        }
        Cell playedMoveCell = board.getMatrix().get(row).get(col);

        playedMoveCell.setCellState(CellState.FILLED);
        playedMoveCell.setPlayer(this);

        return new Move(playedMoveCell,this);
    }

    public char getSymbol() {
        return Symbol;
    }

    public void setSymbol(char symbol) {
        Symbol = symbol;
    }
    public PlayerType getPlayerType() {

        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
