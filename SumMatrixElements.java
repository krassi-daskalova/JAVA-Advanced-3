package Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numOfRowsAndCols = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(numOfRowsAndCols[0]);
        int cols = Integer.parseInt(numOfRowsAndCols[1]);

        String splitPattern = ", ";
        int[][] matrix = readNewMatrix(rows, cols, scanner, splitPattern);
        int sum = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sum += matrix[row][col];
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
    public static int[][] readNewMatrix(int rows, int cols, Scanner scanner, String splitPattern) {
        int[][] newMatrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            newMatrix[row] = Arrays.stream(scanner.nextLine().split(splitPattern))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return newMatrix;
    }
}







