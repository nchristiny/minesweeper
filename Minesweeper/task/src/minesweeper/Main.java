package minesweeper;

import java.util.Random;
import java.util.Scanner;

public class Main {
    // TODO need to accept user defined size of m x n field
    static Scanner sc = new Scanner(System.in);
    // TODO use char[][]
    static String[][] board = new String[9][9];
    static int mines;

    public static void showBoard() {
        /* show board */
        System.out.println("|123456789|");
        System.out.println("-|---------|-");
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                if (j == 0)
                    System.out.print((i + 1) + "|");
                System.out.print(board[i][j]);
                if (j == 8)
                    System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("-|---------|-");
    }

    public static void main(String[] args) {
        System.out.print("How many mines do you want on the field? > ");
        mines = sc.nextInt();
        Random rand = new Random();
        int count;
        /* set the mines */
        while (mines > 0) {
            int p = rand.nextInt(8);
            int q = rand.nextInt(8);
            if (!board[p][q].equals("X")) {
                board[p][q] = "X";
                mines--;
            }
        }
        /* fill the rest in */
        for (int j = 0; j <= 8; j++) {
            for (int i = 0; i <= 8; i++) {
                if (!board[i][j].equals("X"))
                    board[i][j] = ".";
            }
        }

        /* draw proximity */
        for (int j = 0; j <= 8; j++) {
            for (int i = 0; i <= 8; i++) {
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
