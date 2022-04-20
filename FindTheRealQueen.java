package Matrix;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[8][8];
        readMatrix(scanner, matrix);
        boolean isValidQueen = false;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                char currentChar = matrix[row][col];
                if (currentChar == 'q') {
                    //проверка по хоризонтал
                    for (int colsToCheck = 0; colsToCheck < col; colsToCheck++) {
                        if (matrix[row][colsToCheck] == 'q') {
                            isValidQueen = false;
                            break;
                        } else {
                            isValidQueen = true;
                        }
                    }
                    for (int colsToCheck = col + 1; colsToCheck < 8; colsToCheck++) {
                        if (matrix[row][colsToCheck] == 'q') {
                            isValidQueen = false;
                            break;
                        } else {
                            isValidQueen = true;
                        }
                    }
                    //проверка по вертикал, ако по хоризонтал е валидна
                    if (isValidQueen) {
                        for (int rowsToCheck = 0; rowsToCheck < row; rowsToCheck++) {
                            if (matrix[rowsToCheck][col] == 'q') {
                                isValidQueen = false;
                                break;
                            } else {
                                isValidQueen = true;
                            }
                        }
                        for (int rowsToCheck = row + 1; rowsToCheck < 8; rowsToCheck++) {
                            if (matrix[rowsToCheck][col] == 'q') {
                                isValidQueen = false;
                                break;
                            } else {
                                isValidQueen = true;
                            }
                        }
                    }
                    //проверка по ляв диагонал, ако предходните са валидни
                    if (isValidQueen) {
                        if (row > 0 && col > 0) {
                            int currentRowToLeft = row - 1;
                            int currentColToLeft = col - 1;
                            while (currentRowToLeft >= 0 && currentColToLeft >= 0) {
                                if (matrix[currentRowToLeft][currentColToLeft] == 'q') {
                                    isValidQueen = false;
                                    break;
                                } else {
                                    isValidQueen = true;
                                }
                                currentRowToLeft--;
                                currentColToLeft--;
                            }
                        }
                        if (row < 7 && col < 7) {
                            int currentRowToRight = row + 1;
                            int currentColToRight = col + 1;
                            while (currentRowToRight < 8 && currentColToRight < 8) {
                                if (matrix[currentRowToRight][currentColToRight] == 'q') {
                                    isValidQueen = false;
                                    break;
                                } else {
                                    isValidQueen = true;
                                }
                                currentRowToRight++;
                                currentColToRight++;
                            }
                        }
                    }
                    //проверка по десен диагонал, ако предходните са валидни
                    if (isValidQueen) {
                        if (row < 7 && col > 0) {
                            int currentRowToLeft = row + 1;
                            int currentColToLeft = col - 1;
                            while (currentRowToLeft <= 7 && currentColToLeft >= 0) {
                                if (matrix[currentRowToLeft][currentColToLeft] == 'q') {
                                    isValidQueen = false;
                                    break;
                                } else {
                                    isValidQueen = true;
                                }
                                currentRowToLeft++;
                                currentColToLeft--;
                            }
                        }
                        if (row > 0 && col < 7) {
                            int currentRowToRight = row - 1;
                            int currentColToRight = col + 1;
                            while (currentRowToRight >= 0 && currentColToRight < 8) {
                                if (matrix[currentRowToRight][currentColToRight] == 'q') {
                                    isValidQueen = false;
                                    break;
                                } else {
                                    isValidQueen = true;
                                }
                                currentRowToRight--;
                                currentColToRight++;
                            }
                        }
                    }
                    if (isValidQueen) {
                        System.out.println(row + " " + col);
                        break;
                    }
                }
            }
            if (isValidQueen) {
                break;
            }
        }
    }

    private static void readMatrix(Scanner scanner, char[][] matrix) {
        for (int i = 0; i < 8; i++) {
            String[] currentRowStr = scanner.nextLine().split("\\s+");
            char[] currentRow = new char[currentRowStr.length];
            for (int j = 0; j < currentRowStr.length; j++) {
                currentRow[j] = currentRowStr[j].charAt(0);
            }
            matrix[i] = currentRow;
        }
    }
}