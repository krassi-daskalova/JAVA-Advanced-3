package Matrix;

import java.util.Scanner;

public class FindTheRealQueenMine {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = readCharMatrix(scanner);
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                char currentChar = matrix[row][col];
                if(currentChar == 'q'){
                    //int currentRow = Integer.parseInt(matrix[0]);
                }
            }
        }
    }
    public static char[][] readCharMatrix(Scanner scanner) {
        char[][] matrix = new char[8][8];
        for (int row = 0; row < 8; row++) {
            String line = scanner.nextLine();
            String[] elements = line.split("\\s+");
            for (int i = 0; i < elements.length; i++) {
                char current = elements[i].charAt(0);
                matrix[row][i] = current;
            }
        }
        return matrix;
    }
}
