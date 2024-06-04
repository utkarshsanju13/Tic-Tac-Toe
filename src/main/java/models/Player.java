package models;

import java.util.Scanner;

public class Player {

    private Long id;

    private Symbol symbol;

    private String name;

    private PlayerType playerType;

    private Scanner scanner;


    public Player(Long id, Symbol symbol, String name, PlayerType playerType) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.playerType = playerType;
        this.scanner = new Scanner(System.in);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Move makeMove(Board board){

        System.out.println("Please Enter the row on which you want to place your symbol (0 based indexing)");
        int row = scanner.nextInt();

        System.out.println("Please Enter the col on which you want to place your symbol (0 based indexing)");
        int col = scanner.nextInt();

        return new Move(new Cell(row,col),this);


    }
}
