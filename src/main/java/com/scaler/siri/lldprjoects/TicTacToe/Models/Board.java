package com.scaler.siri.lldprjoects.TicTacToe.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board {
    private List<List<Cell>> board;
    private int dimension;

    public Board(int dimension) {
        this.dimension = dimension;

        this.board = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {
            board.add(new ArrayList<>());
            for (int j = 0; j < dimension; j++) {
                board.get(i).add(new Cell(i,j));
            }
        }
    }

    public void printBoard(){
        for(List<Cell> row : board){
            for(Cell cell : row){
                if(cell.getCellState() == CellState.EMPTY){
                    System.out.print("|  |");
                }
                else{
                    System.out.print("|" + cell.getPlayer().getSymbol().getaChar() + "|");
                }
            }
            System.out.println();
        }
    }
}
