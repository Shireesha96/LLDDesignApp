package com.scaler.siri.lldprjoects.TicTacToe.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Move {
    private Player player;
    private Cell cell;

    public Move(Cell cell, Player player) {
        this.cell = cell;
        this.player = player;
    }

}
