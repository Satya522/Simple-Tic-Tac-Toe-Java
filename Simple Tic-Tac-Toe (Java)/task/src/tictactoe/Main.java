package tictactoe;

import java.util.Scanner;

/*  3rd stage code */
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//
//        System.out.println("---------");
//        for (int i = 0; i < 3; i++) {
//            System.out.println("| " + input.charAt(3*i) + " " + input.charAt(3*i + 1) + " " + input.charAt(3*i + 2) + " |");
//        }
//        System.out.println("---------");
//
//        analyzeGameState(input);
//    }
//
//    public static void analyzeGameState(String input) {
//        String result = "Game not finished";
//        int xCount = 0, oCount = 0, spaceCount = 0;
//
//        for (char c : input.toCharArray()) {
//            if (c == 'X') xCount++;
//            else if (c == 'O') oCount++;
//            else if (c == '_') spaceCount++;
//        }
//
//        if (Math.abs(xCount - oCount) > 1) {
//            result = "Impossible";
//        } else {
//            if (isWinning(input, 'X')) {
//                if (isWinning(input, 'O')) {
//                    result = "Impossible";
//                } else {
//                    result = "X wins";
//                }
//            } else if (isWinning(input, 'O')) {
//                result = "O wins";
//            } else if (spaceCount == 0) {
//                result = "Draw";
//            }
//        }
//
//        System.out.println(result);
//    }
//
//    public static boolean isWinning(String input, char player) {
//        for (int i = 0; i < 3; i++) {
//            if (input.charAt(3*i) == player && input.charAt(3*i + 1) == player && input.charAt(3*i + 2) == player) {
//                return true;
//            }
//            if (input.charAt(i) == player && input.charAt(i + 3) == player && input.charAt(i + 6) == player) {
//                return true;
//            }
//        }
//        if (input.charAt(0) == player && input.charAt(4) == player && input.charAt(8) == player) {
//            return true;
//        }
//        if (input.charAt(2) == player && input.charAt(4) == player && input.charAt(6) == player) {
//            return true;
//        }
//        return false;
//    }
//}
/* 4th stage code */
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//
//        char[][] grid = new char[3][3];
//        int index = 0;
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                grid[i][j] = input.charAt(index++); // Fill the grid row by row
//            }
//        }
//
//        printGrid(grid);
//
//        while (true) {
//            System.out.print("Enter the coordinates: ");
//            try {
//                int x = scanner.nextInt();
//                int y = scanner.nextInt();
//
//                if (x < 1 || x > 3 || y < 1 || y > 3) {
//                    System.out.println("Coordinates should be from 1 to 3!");
//                    continue;
//                }
//
//                // Adjust for array index and coordinate system
//                x--;
//                y--;
//
//                if (grid[x][y] != '_') {
//                    System.out.println("This cell is occupied! Choose another one!");
//                    continue;
//                }
//
//                grid[x][y] = 'X';
//                break;
//            } catch (Exception e) {
//                System.out.println("You should enter numbers!");
//                scanner.nextLine(); // discard invalid input
//            }
//        }
//
//        printGrid(grid);
//    }
//
//    public static void printGrid(char[][] grid) {
//        System.out.println("---------");
//        for (int i = 0; i < 3; i++) {
//            System.out.print("| ");
//            for (int j = 0; j < 3; j++) {
//                System.out.print((grid[i][j] == '_') ? "  " : grid[i][j] + " ");
//            }
//            System.out.println("|");
//        }
//        System.out.println("---------");
//    }
//}

/* 5th stage code */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] grid = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' ';
            }
        }

        printGrid(grid);

        char currentPlayer = 'X';
        while (true) {
            System.out.print("Enter the coordinates: ");
            try {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                if (x < 1 || x > 3 || y < 1 || y > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }

                // Adjust for array index and coordinate system
                x--;
                y--;

                if (grid[x][y] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }

                grid[x][y] = currentPlayer;
                printGrid(grid);

                if (checkWin(grid, currentPlayer)) {
                    System.out.println(currentPlayer + " wins");
                    break;
                } else if (isDraw(grid)) {
                    System.out.println("Draw");
                    break;
                }

                // Switch player
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine(); // discard invalid input
            }
        }
    }

    public static void printGrid(char[][] grid) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean checkWin(char[][] grid, char player) {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == player && grid[i][1] == player && grid[i][2] == player) {
                return true;
            }
            if (grid[0][i] == player && grid[1][i] == player && grid[2][i] == player) {
                return true;
            }
        }
        if (grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) {
            return true;
        }
        if (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player) {
            return true;
        }
        return false;
    }

    public static boolean isDraw(char[][] grid) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}