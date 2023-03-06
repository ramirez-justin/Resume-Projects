//Justin Ramirez

import java.util.Scanner;
import javax.swing.*;

public class GuessMyNumber{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer n: ");
        int n = sc.nextInt();
        while(n <= 0){
            System.out.print("Enter a positive integer for n:");
            n = sc.nextInt();
        }
        int low = 0;
        int high = n-1;
        int guess = (low + high) / 2;
        System.out.println("Welcome to Guess My Number!" + "\nPlease think of a number between 0 and "+ high);

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
}