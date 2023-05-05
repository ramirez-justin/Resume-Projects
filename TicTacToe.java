import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        runGame();
    }
    /**
     * Controls the flow of the game
     */ 
    public static void runGame() {
        Scanner sc = new Scanner(System.in); // Scanner for input
        String[][] gameBoard = new String[3][3]; // gameBoard matrix
        Boolean xTurn = true; // Tracks whos turn it is
        initializeGame(gameBoard); // method that fills board with spaces
        while (getWinner(gameBoard) == " ") { // while loop for game
            System.out.println(); // empty space
            printCurrentBoard(gameBoard); 
            System.out.println(); // empty space
            if (xTurn)
                System.out.println("It is X's turn");
            else 
                System.out.println("It is O's turn");
            getUserInput(xTurn, gameBoard, sc);
            xTurn = !xTurn;
            if (isBoardFull(gameBoard))
                break;
        }
        printCurrentBoard(gameBoard);
        if (isBoardFull(gameBoard))
            System.out.println("It was the cat's game! The result is a tie.");
        else
            System.out.println("Congratulations player " + getWinner(gameBoard) + ", you have won!");
        sc.close();
    }

    /**
     * Sets cells of 2D array to spaces
     * @param gameBoard
     */ 
    public static void initializeGame(String[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = " ";
            }
        }
    }

    /**
     * Prints whatever is in the current board
     * @param gameBoard
     */ 
    public static void printCurrentBoard(String[][] gameBoard) {
        System.out.printf(" %s | %s | %s\n", gameBoard[0][0], gameBoard[0][1], gameBoard[0][2]);
        System.out.println("- - - - - -");
        System.out.printf(" %s | %s | %s\n", gameBoard[1][0], gameBoard[1][1], gameBoard[1][2]);
        System.out.println("- - - - - -");
        System.out.printf(" %s | %s | %s\n", gameBoard[2][0], gameBoard[2][1], gameBoard[2][2]);

    }

    /**
     * gets the user input and if valid, sets the game board appropriately
     * @param xTurn true if it is X's turn
     * @param gameBoard current game board 
     * @param sc Scanner object from runGame() method
     */ 
    public static void getUserInput(boolean xTurn, String[][] gameBoard, Scanner sc) {
        int row, column;
        System.out.println("Please enter the row THEN the column, each from 0, 1 or 2, separated by a space:");
        row = sc.nextInt();
        column = sc.nextInt();
        sc.nextLine();
        if (!cellAlreadyOccupied(row, column, gameBoard) && xTurn == true) {
            gameBoard[row][column] = "X";
        } else if (!cellAlreadyOccupied(row, column, gameBoard) && xTurn == false) {
            gameBoard[row][column] = "O";
        } else if (cellAlreadyOccupied(row, column, gameBoard)) {
            System.out.println("That cell is already occupied!");
            getUserInput(xTurn, gameBoard, sc);
        } else {
            System.out.println("That was not a valid input");
        }
        System.out.println();
    }

    // Returns true if a given cell, by row and column, is already full
    public static boolean cellAlreadyOccupied(int row, int col, String[][] gameBoard) {
        if (gameBoard[row][col] == " ")
            return false;
        else 
            return true;
    }

    // Returns "X" or "O" if there is a clear winner, or " " if there is no winner
    public static String getWinner(String[][] gameBoard) {
        if (gameBoard[0][0] == "X" && gameBoard[0][1] == "X" && gameBoard[0][2] == "X")
            return "X";
        else if (gameBoard[1][0] == "X" && gameBoard[1][1] == "X" && gameBoard[1][2] == "X")
            return "X";
        else if (gameBoard[2][0] == "X" && gameBoard[2][1] == "X" && gameBoard[2][2] == "X")
            return "X";
        else if (gameBoard[0][0] == "X" && gameBoard[1][0] == "X" && gameBoard[2][0] == "X")
            return "X";
        else if (gameBoard[0][1] == "X" && gameBoard[1][1] == "X" && gameBoard[2][1] == "X")
            return "X";
        else if (gameBoard[0][2] == "X" && gameBoard[1][2] == "X" && gameBoard[2][2] == "X")
            return "X";
        else if (gameBoard[0][0] == "X" && gameBoard[1][1] == "X" && gameBoard[2][2] == "X")
            return "X";
        else if (gameBoard[0][2] == "X" && gameBoard[1][1] == "X" && gameBoard[2][0] == "X")
            return "X";
        else if (gameBoard[0][0] == "O" && gameBoard[0][1] == "O" && gameBoard[0][2] == "O")
            return "O";
        else if (gameBoard[1][0] == "O" && gameBoard[1][1] == "O" && gameBoard[1][2] == "O")
            return "O";
        else if (gameBoard[2][0] == "O" && gameBoard[2][1] == "O" && gameBoard[2][2] == "O")
            return "O";
        else if (gameBoard[0][0] == "O" && gameBoard[1][0] == "O" && gameBoard[2][0] == "O")
            return "O";
        else if (gameBoard[0][1] == "O" && gameBoard[1][1] == "O" && gameBoard[2][1] == "O")
            return "O";
        else if (gameBoard[0][2] == "O" && gameBoard[1][2] == "O" && gameBoard[2][2] == "O")
            return "O";
        else if (gameBoard[0][0] == "O" && gameBoard[1][1] == "O" && gameBoard[2][2] == "O")
            return "O";
        else if (gameBoard[0][2] == "O" && gameBoard[1][1] == "O" && gameBoard[2][0] == "O")
            return "O";
        else 
            return " ";
    }

    // Returns whether or not the game board is full
    public static boolean isBoardFull(String[][] gameBoard) {
        boolean full = false;
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == " ") {
                    full = false;
                    return full;
                } else {
                    full = true;
                }
            }
        }
        return full;
    }
}
