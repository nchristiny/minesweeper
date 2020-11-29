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
        // calculate proximity to mines
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                // Three cases 1. corner, 2. side, 3. middle space.
                // Of four corners and four sides
                if (board[i][j] != "X") {
                    count = 0;
                    // top left
                    if (i == 0 && j == 0) {
                        if (board[i + 1][j] == "X")
                            count++;
                        if (board[i + 1][j + 1] == "X")
                            count ++;
                        if (board[i][j + 1] == "X")
                            count++;
                    }
                    // top right
                    else if (i == 8 && j == 0) {
                        if (board[i - 1][j] == "X")
                            count++;
                        if (board[i - 1][j + 1] == "X")
                            count ++;
                        if (board[i][j + 1] == "X")
                            count++;
                    }
                    // bottom left
                    else if (i == 0 && j == 8) {
                        if (board[i + 1][j] == "X")
                            count++;
                        if (board[i + 1][j - 1] == "X")
                            count ++;
                        if (board[i][j - 1] == "X")
                            count++;
                    }
                    // bottom right
                    else if (i == 8 && j == 8) {
                        if (board[i - 1][j] == "X")
                            count++;
                        if (board[i - 1][j - 1] == "X")
                            count ++;
                        if (board[i][j - 1] == "X")
                            count++;
                    }
                    // left
                    else if ((i > 0 && i <= 7) && j == 0) {
                        if (board[i - 1][j] == "X")
                            count++;
                        if (board[i - 1][j + 1] == "X")
                            count++;
                        if (board[i][j + 1] == "X")
                            count++;
                        if (board[i + 1][j + 1] == "X")
                            count++;
                        if (board[i + 1][j] == "X")
                            count++;
                    }
                    // top
                    else if (i == 0 && (j > 0 && j <= 7)) {
                        if (board[i][j - 1] == "X")
                            count++;
                        if (board[i + 1][j - 1] == "X")
                            count++;
                        if (board[i + 1][j] == "X")
                            count++;
                        if (board[i + 1][j + 1] == "X")
                            count++;
                        if (board[i][j + 1] == "X")
                            count++;
                    }
                    // right
                    else if ((i > 0 && i <= 7) && j == 8) {
                        if (board[i - 1][j] == "X")
                            count++;
                        if (board[i - 1][j - 1] == "X")
                            count++;
                        if (board[i][j - 1] == "X")
                            count++;
                        if (board[i + 1][j - 1] == "X")
                            count++;
                        if (board[i + 1][j] == "X")
                            count++;
                    }
                    // bottom
                    else if (i == 8 && (j > 0 && j <= 7)) {
                        if (board[i][j - 1] == "X")
                            count++;
                        if (board[i - 1][j - 1] == "X")
                            count++;
                        if (board[i - 1][j] == "X")
                            count++;
                        if (board[i - 1][j + 1] == "X")
                            count++;
                        if (board[i][j + 1] == "X")
                            count++;
                    }
                    // the rest of 'em
                    else {
                        if (board[i - 1][j - 1] == "X")
                            count++;
                        if (board[i][j - 1] == "X")
                            count++;
                        if (board[i + 1][j - 1] == "X")
                            count++;
                        if (board[i - 1][j] == "X")
                            count++;
                        if (board[i + 1][j] == "X")
                            count++;
                        if (board[i - 1][j + 1] == "X")
                            count++;
                        if (board[i][j + 1] == "X")
                            count++;
                        if (board[i + 1][j + 1] == "X")
                            count++;
                    }
                    if (count != 0)
                        board[i][j] = String.valueOf (count);
                }
            }
        }
        showBoard();
    }
}
