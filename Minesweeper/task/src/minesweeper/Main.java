package minesweeper;

import java.util.Random;
import java.util.Scanner;

public class Main {
    // TODO need to accept user defined size of m x n field
    static Scanner sc = new Scanner(System.in);
    static String[][] board = new String[9][9];
    static int mines;

    public static void showBoard() {
        /* show board */
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
        /* set the mines */
        while (count > 0) {
            int p = rand.nextInt(8);
            int q = rand.nextInt(8);
            if (!board[p][q].equals("X")) {
                board[p][q] = "X";
                count--;
            }
        }
        /* fill the rest in */
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                if (!board[i][j].equals("X"))
                    board[i][j] = ".";
            }
        }

        /* draw proximity */
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                count = 0;
                if (!board[i][j].equals("X")) {
                    switch (i) {
                        case (0):
                            switch (j) {
                                case (0):
                                    // (0,0) top left
                                    if (board[i + 1][j].equals("X"))
                                        count++;
                                    if (board[i + 1][j + 1].equals("X"))
                                        count++;
                                    if (board[i][j + 1].equals("X"))
                                        count++;
                                    break;
                                case (8):
                                    // (0, 8) bottom left
                                    if (board[i + 1][j].equals("X"))
                                        count++;
                                    if (board[i + 1][j - 1].equals("X"))
                                        count++;
                                    if (board[i][j - 1].equals("X"))
                                        count++;
                                    break;
                                default:
                                    // (0,j) left
                                    if (board[i][j - 1].equals("X"))
                                        count++;
                                    if (board[i + 1][j - 1].equals("X"))
                                        count++;
                                    if (board[i + 1][j].equals("X"))
                                        count++;
                                    if (board[i + 1][j + 1].equals("X"))
                                        count++;
                                    if (board[i][j + 1].equals("X"))
                                        count++;
                            }
                            break;
                        case (8):
                            switch (j) {
                                case (0):
                                    // (8,0) top right
                                    if (board[i - 1][j].equals("X"))
                                        count++;
                                    if (board[i - 1][j + 1].equals("X"))
                                        count++;
                                    if (board[i][j + 1].equals("X"))
                                        count++;
                                    break;
                                case (8):
                                    // (8,8) bottom right
                                    if (board[i - 1][j].equals("X"))
                                        count++;
                                    if (board[i - 1][j - 1].equals("X"))
                                        count++;
                                    if (board[i][j - 1].equals("X"))
                                        count++;
                                    break;
                                default:
                                    // (8,j) right
                                    if (board[i][j - 1].equals("X"))
                                        count++;
                                    if (board[i - 1][j - 1].equals("X"))
                                        count++;
                                    if (board[i - 1][j].equals("X"))
                                        count++;
                                    if (board[i - 1][j + 1].equals("X"))
                                        count++;
                                    if (board[i][j + 1].equals("X"))
                                        count++;
                            }
                            break;
                        default:
                            if (j == 0){
                                // top
                                if (board[i - 1][j].equals("X"))
                                    count++;
                                if (board[i - 1][j + 1].equals("X"))
                                    count++;
                                if (board[i][j + 1].equals("X"))
                                    count++;
                                if (board[i + 1][j + 1].equals("X"))
                                    count++;
                                if (board[i + 1][j].equals("X"))
                                    count++;
                            } else if (j == 8) {
                                // bottom
                                if (board[i - 1][j].equals("X"))
                                    count++;
                                if (board[i - 1][j - 1].equals("X"))
                                    count++;
                                if (board[i][j - 1].equals("X"))
                                    count++;
                                if (board[i + 1][j - 1].equals("X"))
                                    count++;
                                if (board[i + 1][j].equals("X"))
                                    count++;
                            } else {
                                if (board[i - 1][j - 1].equals("X"))
                                    count++;
                                if (board[i][j - 1].equals("X"))
                                    count++;
                                if (board[i + 1][j - 1].equals("X"))
                                    count++;
                                if (board[i - 1][j].equals("X"))
                                    count++;
                                if (board[i + 1][j].equals("X"))
                                    count++;
                                if (board[i - 1][j + 1].equals("X"))
                                    count++;
                                if (board[i][j + 1].equals("X"))
                                    count++;
                                if (board[i + 1][j + 1].equals("X"))
                                    count++;
                            }
                    }
                }
                if (count != 0)
                    board[i][j] = String.valueOf(count);
            }
        }
        showBoard();
    }
}
