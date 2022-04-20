package Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int rows = n;
        int cols = n;
        String splitPattern = "";

        String[][] matrix = readNewMatrix(rows, cols, scanner, splitPattern);
        printMatrix(matrix);

    }

    public static String[][] readNewMatrix(int rows, int cols, Scanner scanner, String splitPattern) {
        String[][] newMatrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            newMatrix[row] = (String[]) Arrays.stream(scanner.nextLine().split(splitPattern))
                    .toArray();
        }
        return newMatrix;
    }

    public static void printMatrix(String[][] matrix) {
        for (String [] arr : matrix) {
            for (String num : arr) {
                System.out.print(num);
            }
            System.out.println();
        }
    }
}
