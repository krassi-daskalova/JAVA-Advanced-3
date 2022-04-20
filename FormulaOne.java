package Matrix;

import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int commands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        fillMatrix(scanner, size, matrix);
        int rowOfThePlayer = 0;
        int colOfThePlayer = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                char currentElement = matrix[row][col];
                if (currentElement == 'P') {
                    rowOfThePlayer = row;
                    colOfThePlayer = col;
                    break;
                }
            }
        }

        boolean winner = false;
        for (int command = 1; command <= commands; command++) {
            String directionMovement = scanner.nextLine();
            int newRow = 0;
            int newCol = 0;
            switch (directionMovement) {
                case "up":
                    newRow = checkIfItIsOut(rowOfThePlayer - 1, size);
                    newCol = checkIfItIsOut(colOfThePlayer, size);
                    if (matrix[newRow][newCol] == 'B') {
                        newRow = checkIfItIsOut(rowOfThePlayer - 2, size);
                        newCol = checkIfItIsOut(colOfThePlayer, size);
                    }
                    break;
                case "down":
                    newRow = checkIfItIsOut(rowOfThePlayer + 1, size);
                    newCol = checkIfItIsOut(colOfThePlayer, size);
                    if (matrix[newRow][newCol] == 'B') {
                        newRow = checkIfItIsOut(rowOfThePlayer + 2, size);
                        newCol = checkIfItIsOut(colOfThePlayer, size);
                    }
                    break;
                case "left":
                    newRow = checkIfItIsOut(rowOfThePlayer, size);
                    newCol = checkIfItIsOut(colOfThePlayer - 1, size);
                    if (matrix[newRow][newCol] == 'B') {
                        newRow = checkIfItIsOut(rowOfThePlayer, size);
                        newCol = checkIfItIsOut(colOfThePlayer - 2, size);
                    }
                    break;
                case "right":
                    newRow = checkIfItIsOut(rowOfThePlayer, size);
                    newCol = checkIfItIsOut(colOfThePlayer + 1, size);
                    if (matrix[newRow][newCol] == 'B') {
                        newRow = checkIfItIsOut(rowOfThePlayer, size);
                        newCol = checkIfItIsOut(colOfThePlayer + 2, size);
                    }
                    break;
            }
            if (matrix[newRow][newCol] == 'T') {
                newRow = rowOfThePlayer;
                newCol = colOfThePlayer;
            } else {
                if (matrix[newRow][newCol] == 'F') {
                    winner = true;
                }
                matrix[rowOfThePlayer][colOfThePlayer] = '.';
                matrix[newRow][newCol] = 'P';
                rowOfThePlayer = newRow;
                colOfThePlayer = newCol;
            }
        }
        if (winner) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        printMatrix(matrix);


    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static int checkIfItIsOut(int value, int size) {
        if (value < 0) {
            value = size - 1;
        } else if (value >= size) {
            value = 0;
        }
        return value;
    }

    private static void fillMatrix(Scanner scanner, int size, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
        }
    }
}
