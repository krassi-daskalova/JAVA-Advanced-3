package Matrix;

import java.sql.SQLOutput;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[num][num];

        fillMatrix(scanner, matrix);
        int sumPrimary = sumPrimary(matrix);
        int sumSecondary = sumSecondary(matrix);
        System.out.println(Math.abs(sumPrimary - sumSecondary));
    }

    private static int sumSecondary(int[][] matrix) {
        int sumSecondary = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (col == matrix.length - row - 1) {
                    sumSecondary += matrix[row][col];
                }
            }
        }
        return sumSecondary;
    }

    private static int sumPrimary(int[][] matrix) {
        int sumPrimaryDiagonal = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (row == col) {
                    sumPrimaryDiagonal += matrix[row][col];
                }
            }
        }
        return sumPrimaryDiagonal;
    }

    public static void fillMatrix(Scanner scanner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}
