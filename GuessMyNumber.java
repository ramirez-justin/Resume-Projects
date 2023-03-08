//Justin Ramirez

import java.util.Scanner;
import javax.swing.*;

public class GuessMyNumber extends JFrame {
    

    public GuessMyNumber() {

    }

    public static void main(String[] args) {
        int computerNum = (int) (Math.random()*100 + 1);
        int userAnswer = 0;
        char userResponse = 'X';
        int low = 1;
        int high = 100;
        int computerAnswer = low + (high - low) / 2;
        int count = 1;
        Scanner sc = new Scanner(System.in);
        // mode selection
        System.out.println("Please Select a mode");
        char mode = sc.next().charAt(0);
        
        // User picks a number
        if (mode == 'U') {
            JOptionPane.showMessageDialog(null,
               "Please think of a number between 1 and 100. ", "Guessing Game", 3);
            while (userResponse != 'C') {
                JOptionPane.showMessageDialog(null,
               "Is yor number" + computerAnswer, "Guessing Game", 3);
                String response = JOptionPane.showInputDialog(null, "Please enter C for correct, H for too high, or L for too low.");
                userResponse = response.charAt(0);
                JOptionPane.showMessageDialog(null, ""+ computerResponse(computerAnswer, userResponse));
                if (userResponse == 'L') {
                    low = computerAnswer + 1;
                } else if (userResponse == 'H') {
                    high = computerAnswer - 1;
                }
                count++;
                computerAnswer = low + (high - low) / 2;
            }
        }

        // Computer picks a number
        if (mode == 'C') {
            while (userAnswer != computerNum) {
            String response = JOptionPane.showInputDialog(null,
               "Enter a guess between 1 and 100", "Guessing Game", 3);
            userAnswer = Integer.parseInt(response);
            JOptionPane.showMessageDialog(null, ""+ userGuess(userAnswer, computerNum, count));
            count++;
            }
        }
        sc.close();
    }


    public static String computerResponse(int computerAnswer, char userResponse) {
        if (userResponse == 'C') {
            return "Thank you for playing Guess My Number!";
        } else if(userResponse != 'C' || userResponse != 'L' || userResponse != 'H'){
            return "Invalid response. Please enter 'L', 'H', or 'C'.";
        } else {
            return "Calculating a new guess.";
        }
    }

    public static String userGuess(int userAnswer, int computerNumber, int count) {
        if (userAnswer <=0 || userAnswer >100) {
            return "Your guess is invalid";
        }
        else if (userAnswer == computerNumber ){
            return "Correct!\nTotal Guesses: " + count;
        }
        else if (userAnswer > computerNumber) {
            return "Your guess is too high, try again.\nTry Number: " + count;
        }
        else if (userAnswer < computerNumber) {
            return "Your guess is too low, try again.\nTry Number: " + count;
        }
        else {
            return "Your guess is incorrect\nTry Number: " + count;
        }
    }
}