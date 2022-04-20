package Matrix;

import java.util.Scanner;

public class MousePositionG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] field = new String[size][size];
        int cheeseEaten = 0;
        for (int i = 0; i < size; i++) {
            String[] currentRow = scanner.nextLine().split("");
            field[i] = currentRow;
        }
        int mouseCurrentRow = 0;
        int mouseCurrentColumn = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                String currentSymbol = field[row][col];
                if (currentSymbol.equals("M")) {
                    mouseCurrentRow = row;
                    mouseCurrentColumn = col;
                    break;
                }
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            int mousePreviousRow = mouseCurrentRow;
            int mousePreviousCol = mouseCurrentColumn;
            String symbolAtNewPosition = "";
            if ("up".equals(command)) {
                if (mouseCurrentRow - 1 >= 0) {
                    mouseCurrentRow -= 1;
                } else {
                    System.out.println("Where is the mouse?");
                    field[mouseCurrentRow][mouseCurrentColumn] = "-";
                    break;
                }
            } else if ("down".equals(command)) {
                if (mouseCurrentRow + 1 < size) {
                    mouseCurrentRow += 1;
                } else {
                    System.out.println("Where is the mouse?");
                    field[mouseCurrentRow][mouseCurrentColumn] = "-";
                    break;
                }
            } else if ("left".equals(command)) {
                if (mouseCurrentColumn - 1 >= 0) {
                    mouseCurrentColumn -= 1;
                } else {
                    System.out.println("Where is the mouse?");
                    field[mouseCurrentRow][mouseCurrentColumn] = "-";
                    break;
                }
            } else if ("right".equals(command)) {
                if (mouseCurrentColumn + 1 < size) {
                    mouseCurrentColumn += 1;
                } else {
                    System.out.println("Where is the mouse?");
                    field[mouseCurrentRow][mouseCurrentColumn] = "-";
                    break;
                }
            }

            symbolAtNewPosition = field[mouseCurrentRow][mouseCurrentColumn];
            if (symbolAtNewPosition.equals("c")) {
                cheeseEaten++;
                field[mouseCurrentRow][mouseCurrentColumn] = "M";
                field[mousePreviousRow][mousePreviousCol] = "-";
            } else if (symbolAtNewPosition.equals("B")) {
                field[mouseCurrentRow][mouseCurrentColumn] = "M";
                field[mousePreviousRow][mousePreviousCol] = "-";
                continue;
            } else if (symbolAtNewPosition.equals("-")) {
                field[mouseCurrentRow][mouseCurrentColumn] = "M";
                field[mousePreviousRow][mousePreviousCol] = "-";
            }
            command = scanner.nextLine();
        }
        if (cheeseEaten < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseEaten);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseEaten);
        }
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
        }
    }
}
