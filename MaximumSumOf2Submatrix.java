package Matrix;

import java.util.Scanner;

public class MaximumSumOf2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String splitPattern = ", ";
        int[][] matrix = SumMatrixElements.readNewMatrix(rows, cols, scanner, splitPattern);
        int sumMax = 0;
        int[][] maxMatrix = new int[2][2];

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int current = matrix[row][col];
                int right = matrix[row][col + 1];
                int bottom = matrix[row + 1][col];
                int bottomRight = matrix[row + 1][col + 1];

                int currentSum = current + right + bottomRight + bottom;

                if (currentSum > sumMax) {
                    sumMax = currentSum;
                    maxMatrix = new int[][]{
                            {current, right},
                            {bottom, bottomRight}
                    };
                }
            }
        }
        printMatrix(maxMatrix);
        System.out.println(sumMax);
    }
    public static void printMatrix(int[][] matrix) {
        for (int [] arr : matrix) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
