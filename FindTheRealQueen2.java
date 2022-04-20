package Matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindTheRealQueen2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> positionsOfQueens = new ArrayList<>();
        List<Integer> realQueens = new ArrayList<>();

        String[][] board = new String[8][8];
        for (int r = 0; r < 8; r++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int c = 0; c < 8; c++) {
                board[r][c] = line[c];
                if (board[r][c].charAt(0) == 'q') {
                    positionsOfQueens.add(r);
                    positionsOfQueens.add(c);
                }
            }
        }

        while (!positionsOfQueens.isEmpty()) {
            int row = positionsOfQueens.get(0);
            int col = positionsOfQueens.get(1);

            boolean isFake = false;

            for (int i = 2; i < positionsOfQueens.size(); i++) {
                if (positionsOfQueens.get(i) == row || positionsOfQueens.get(i) == col) {
                    isFake = true;
                    break;
                }
            }

            if (!isFake) { //DOWN & RIGHT
                int r1 = row;


                int c1 = col;

                for (int i = 1; i < 8; i++) {
                    r1 += 1;
                    c1 += 1;
                    if (r1 >= 8 || c1 >= 8) {
                        break;
                    }
                    if (board[r1][c1].charAt(0) == 'q') {
                        isFake = true;
                        break;
                    }
                }

            }

            if (!isFake) { // UP & LEFT
                int r2 = row;
                int c2 = col;

                for (int i = 0; i < 8; i++) {
                    r2 -= 1;
                    c2 -= 1;
                    if (r2 <= 0 || c2 <= 0) {
                        break;
                    }
                    if (board[r2][c2].charAt(0) == 'q') {
                        isFake = true;
                        break;
                    }
                }

            }

            if (!isFake) {  //DOWN & LEFT
                int r3 = row;
                int c3 = col;

                for (int i = 1; i < 8; i++) {
                    r3 += 1;
                    c3 -= 1;
                    if (r3 >= 8 || c3 <= 0) {
                        break;
                    }
                    if (board[r3][c3].charAt(0) == 'q') {
                        isFake = true;
                        break;
                    }
                }

            }

            if (!isFake) { //UP & RIGHT
                int r4 = row;
                int c4 = col;

                for (int i = 1; i < 8; i++) {
                    r4 -= 1;
                    c4 += 1;
                    if (r4 <= 0 || c4 >= 8) {
                        break;
                    }
                    if (board[r4][c4].charAt(0) == 'q') {
                        isFake = true;
                        break;
                    }
                }

            }

            if (!isFake) {
                realQueens.add(row);
                realQueens.add(col);
            }

            positionsOfQueens.remove(0);
            positionsOfQueens.remove(0);
        }

        if (!realQueens.isEmpty()) {
            System.out.println(realQueens.get(0) + " " + realQueens.get(1));
        }

    }
}