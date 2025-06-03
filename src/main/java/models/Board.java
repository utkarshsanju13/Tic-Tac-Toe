package models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int dimension;
    private List<List<Cell>> matrix;

    public Board(int dimension) {
        this.dimension = dimension;
        matrix = new ArrayList<>();

        for(int i = 0 ; i < dimension; i++){
            matrix.add(new ArrayList<>()); //Adding the internal arrayList
            for(int j = 0; j < dimension; j++){
                matrix.get(i).add(new Cell(i,j));
            }
        }
    }

    public void displayBoard(){
        for(int i = 0 ; i < dimension; i++){
            List<Cell> row = matrix.get(i);
            for(Cell cell : row){
                cell.displaycell();
            }
            System.out.println();
        }
    }

    public List<List<Cell>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<Cell>> matrix) {
        this.matrix = matrix;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
}
