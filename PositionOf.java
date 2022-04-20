package Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);

        int[][] matrix = new int[row][col];

        for (int rows = 0; rows < row; rows++) {
            matrix[rows] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        boolean isFound = false;
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int current = matrix[i][j];
                if (current == number) {
                    isFound = true;
                    System.out.println(i + " " + j);
                }
            }
        }
        if(!isFound){
            System.out.println("not found");
        }
    }
}
