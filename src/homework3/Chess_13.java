package homework3;

import java.util.Arrays;

public class Chess_13 {
    public static void main(String[] args) {
        String[][] arrChess = new String[8][8];
        for (int i = 0; i < arrChess.length; i++) {
            for (int j = 0; j < arrChess.length; j++) {
                if ((i + j) % 2 == 0) {
                    arrChess[i][j] = "W";
                } else arrChess[i][j] = "B";
            }
        }
        for (int i = 0; i < arrChess.length; i++) {
            for (int j = 0; j < arrChess.length; j++) {
                System.out.print(" " + arrChess[i][j] + " ");
            }
            System.out.println();
        }
    }
}