package tictactoe;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        char[][] board = {
            {'_', '_', '_', '_'},
            {'_', '_', '_', '_'},
            {'_', '_', '_', '_'},
            {'_', '_', '_', '_'}
        };
        printBoard(board);

        Scanner scanner = new Scanner(System.in);
        char player = 'X';
        while (true) {
            System.out.println(player);
            System.out.print("y=");
            int y = scanner.nextInt();
            if (y<0 || y>=board.length) {
                System.out.println("wrong y");
                continue;
            }
            
            System.out.print("x=");
            int x = scanner.nextInt();
            if (x<0 || x>=board.length) {
                System.out.println("wrong x");
                continue;
            }
            
            if (board[y][x] != '_') {
                System.out.println("wrong y and x");
                continue;
            }
            
            

            board[y][x] = player;

            printBoard(board);
            
            //check rows for victory
            for (int i = 0; i < board.length; i++) {
                boolean rowIsFull = true;
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] != player) {
                        rowIsFull = false;
                    }
                }
                if (rowIsFull) {
                    System.out.println(player + " wins!");
                    return;
                }
            }
            
            //check columns for victory
            for (int i = 0; i < board.length; i++) {
                boolean columnIsFull = true;
                for (int j = 0; j < board[i].length; j++) {
                    if (board[j][i] != player) {
                        columnIsFull = false;
                    }
                }
                if (columnIsFull) {
                    System.out.println(player + " wins!");
                    return;
                }
            }
            
            //check diagonals for victory
            boolean firstDiagonalIsFull = true;
            boolean secondDiagonalIsFull = true;
            for (int j = 0; j < board.length; j++) {
                if (board[j][j] != player) {
                    firstDiagonalIsFull = false;
                }
                if (board[board.length - 1 -j][j] != player) {
                    secondDiagonalIsFull = false;
                }
            }
            if (firstDiagonalIsFull || secondDiagonalIsFull) {
                System.out.println(player + " wins!");
                return;
            }

            if (player == 'X') {
                player = '0';
            } else {
                player = 'X';
            }
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println(" _______");
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }
}
