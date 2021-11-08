package ru.roon.sergei.algorithm;

public class SurroundedRegions {

    private static final char CHAR_X = 'X';
    private static final char CHAR_O = 'O';

    public void solve(char[][] board) {
        markEdges(board);
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[i].length - 1; j++) {
                mark(board, i, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == CHAR_O) {
                    board[i][j] = CHAR_X;
                }
                if (board[i][j] == '1') {
                    board[i][j] = CHAR_O;
                }
            }
        }


    }

    private void markEdges(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == CHAR_O) {
                board[0][i] = '1';
            }
            if (board[board.length - 1][i] == CHAR_O) {
                board[board.length - 1][i] = '1';
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == CHAR_O) {
                board[i][0] = '1';
            }
            if (board[i][board[i].length - 1] == CHAR_O) {
                board[i][board[i].length - 1] = '1';
            }
        }
    }

    private void mark(char[][] board, int i, int j) {
        if (i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1) {
            return;
        }
        if (board[i][j] == CHAR_O) {
            if (board[i - 1][j] == '1'
                || board[i][j - 1] == '1'
                || board[i + 1][j] == '1'
                || board[i][j + 1] == '1') {
                board[i][j] = '1';
            }

            if (board[i][j] == '1') {
                if (board[i - 1][j] != '1') {
                    mark(board, i - 1, j);
                }
                if (board[i][j - 1] != '1') {
                    mark(board, i, j - 1);
                }
                if (board[i + 1][j] != '1') {
                    mark(board, i + 1, j);
                }
                if (board[i][j + 1] != '1') {
                    mark(board, i, j + 1);
                }
            }
        }

    }
}
