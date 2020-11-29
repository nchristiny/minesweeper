package minesweeper;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String[][] board = new String[9][9];
    static int mines;

    public static void showBoard() {
        //show board
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.print("How many mines do you want on the field? > ");
        mines = sc.nextInt();
        int count = mines;
        Random rand = new Random();
        // set the mines
        while (count > 0) {
            // random coords for each mine
            int p = rand.nextInt(8);
            int q = rand.nextInt(8);
            if (board[p][q] != "X") {
                board[p][q] = "X";
                count--;
            }
        }
        // fill the rest in
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                if (board[i][j] != "X")
                    board[i][j] = ".";
            }
        }
        showBoard();
    }
}
