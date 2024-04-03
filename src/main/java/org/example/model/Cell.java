package org.example.model;

public class Cell {
    private int row;
    private int col;
    private CellState cellState;
    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;
    }
    public void display(){
        if(player==null){
            System.out.print("| |" + " ");
        }else{
            System.out.print("|" + player.getSymbol() + "|");
        }
    }
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CellState getCellState() {
        return cellState;
    }

    private Player player;
}
