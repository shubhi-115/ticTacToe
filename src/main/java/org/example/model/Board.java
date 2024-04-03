package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;
    public Board(int size){
        this.size = size;
        this.board = new ArrayList<>(this.size);
        for(int i=0;i<size;i++){
            this.board.add(new ArrayList<>());
            for(int j=0;j<size;j++){
                this.board.get(i).add(new Cell(i,j));
            }
        }
    }
    public void display(){
        for(int i=0;i<size;i++) {
            List<Cell> cells = board.get(i);
            for (Cell cell : cells) {
                cell.display();
            }
            System.out.println();
        }
    }
}
