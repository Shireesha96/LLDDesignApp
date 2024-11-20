package com.scaler.siri.lldprjoects.TicTacToe.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Setter
@Getter
public class Player {
   private long id;
   private String name;
   private Symbol symbol;
   private PlayerType playerType;
   private Scanner scanner;

    public Player(long id, String name, PlayerType playerType, Symbol symbol) {
        this.id = id;
        this.name = name;
        this.playerType = playerType;
        this.symbol = symbol;
        this.scanner = new Scanner(System.in);
    }

    public Move makeMove(Board board) {
        System.out.println("Enter the row where you want to make the move");
        int row = scanner.nextInt();
        System.out.println("Enter the column where you want to make the move");
        int column = scanner.nextInt();

        return new Move(new Cell(row, column), this);
    }
}
