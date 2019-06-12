package br.pro.hashi.ensino.desagil.desafio.model;

import java.util.Random;


public class Target extends Element {
    private final Board board;

    public Target(int row, int col, Board board) {
        super(row, col);
        this.board = board;
    }

    private void move(int rowShift, int colShift) {
        row += rowShift;
        col += colShift;
    }

    public void move() {
        Random randRow = new Random();
        Random randCol = new Random();

        int rowDir = randRow.nextInt(3);
        int colDir = randCol.nextInt(3);

        if ((row < board.getNumRows() - 1) && rowDir == 0 && !board.isWall(row + 1, col)) {
            move(1, 0);
        } else if ((row > 0) && rowDir == 1 && !board.isWall(row - 1, col)) {
            move(-1, 0);
        }
        if ((col < board.getNumCols() - 1) && colDir == 0 && !board.isWall(row, col + 1)) {
            move(0, 1);
        } else if ((col > 0) && colDir == 1 && !board.isWall(row, col - 1)) {
            move(0, -1);
        }

    }
}
