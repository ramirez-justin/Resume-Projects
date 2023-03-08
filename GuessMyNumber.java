//Justin Ramirez

import java.util.Scanner;
import javax.swing.*;

public class GuessMyNumber extends JFrame {
    

    public GuessMyNumber() {

    }

    public static void main(String[] args) {
        int computerNum = (int) (Math.random()*100 + 1);
        int userAnswer = 0;
        int count = 1;
        Scanner sc = new Scanner(System.in);
        // mode selection
        System.out.println("Please Select a mode");
        char mode = sc.next().charAt(0);
        // User picks a number
        if (mode == 'U')
        
        
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

    public static void computerGuess(int n) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Guess My Number!" + "\nPlease think of a number between 1 and 100");        
        n = sc.nextInt();
        while(n <= 0){
            System.out.print("Enter a positive integer for n:");
            n = sc.nextInt();
        }
        int low = 1;
        int high = 100;
        int guess = (low + high) / 2;
        while (low <= high) { 
            System.out.print("Is yor number " + guess + "? \nPlease enter C for correct, H for too high, or L for too low. \nEnter your response (H/L/C): ");
            char response = sc.next().charAt(0);
            if (response == 'L') {
                low = guess + 1;
            } else if (response == 'H') {
                high = guess - 1;
            } else if (response == 'C') {
                System.out.println("Thank you for playing Guess My Number!");
                break;
            } else {
                System.out.println("Invalid response. Please enter 'L', 'H', or 'C'.");
            }
            guess = (low + high) / 2;
        }
        sc.close();
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