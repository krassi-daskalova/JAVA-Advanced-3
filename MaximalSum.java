package Matrix;

import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int rows = Integer.parseInt(command.split("\\s+")[0]);
        int cols = Integer.parseInt(command.split("\\s+")[1]);

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }


    }
}
