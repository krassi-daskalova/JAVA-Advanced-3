package Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static int[][] readNewMatrix(int rows, int cols, Scanner scanner, String splitPattern) {
        int[][] newMatrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            newMatrix[row] = Arrays.stream(scanner.nextLine().split(splitPattern))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return newMatrix;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = rows;
        String splitPattern = " ";
        int[][] matrix = readNewMatrix(rows, cols, scanner, splitPattern);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == col) {
                    int current = matrix[row][col];
                    System.out.print(current + " ");
                }
            }
        }
        System.out.println();
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix.length){
            int current = matrix[row][col];
            System.out.print(current + " ");
            row--;
            col++;
        }
    }
}

