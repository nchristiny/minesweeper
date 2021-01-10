package minesweeper;

import java.util.Random;
import java.util.Scanner;

public class Main {
    // TODO need to accept user defined size of m x n field
    static Scanner sc = new Scanner(System.in);
    // TODO use char[][]
    static String[][] board = new String[9][9];

    public static void showBoard() {
        /* show board */
        System.out.println(" |123456789|");
        System.out.println("-|---------|-");
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                if (j == 0)
                    System.out.print((i + 1) + "|");
                if (board[i][j].equals("X"))
                    board[i][j] = ".";
                System.out.print(board[i][j]);
                if (j == 8)
                    System.out.println("|");
            }
        }
        System.out.println("-|---------|-");
    }

    public static void main(String[] args) throws Exception {
        System.out.print("How many mines do you want on the field? > ");
        int mines;
        mines = sc.nextInt();
        Random rand = new Random();
        int count;

        /* filler */
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                board[i][j] = ".";
            }
        }

        /* set the mines */
        while (mines > 0) {
            int p = rand.nextInt(8);
            int q = rand.nextInt(8);
            if ((board[p + 1][q + 1] != null) || (!board[p + 1][q + 1].equals("X"))) {
                board[p + 1][q + 1] = "X";
                mines--;
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