import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class DecodeLabs_Java_P1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        char playAgain;

        System.out.println("====================================");
        System.out.println("     NUMBER GUESSING GAME");
        System.out.println("====================================");

        do {

            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts && !guessedCorrectly) {

                try {
                    System.out.print("\nEnter your guess: ");
                    int guess = sc.nextInt();

                    attempts++;

                    if (guess > targetNumber) {
                        System.out.println("Too High!");
                    }
                    else if (guess < targetNumber) {
                        System.out.println("Too Low!");
                    }
                    else {
                        System.out.println("Correct! You guessed the number.");
                        System.out.println("Attempts used: " + attempts);

                        guessedCorrectly = true;
                        score++;
                    }

                    System.out.println("Remaining Attempts: "
                            + (maxAttempts - attempts));

                }
                catch (InputMismatchException e) {

                    System.out.println("Invalid Input! Enter a valid number.");
                    sc.next();

                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nGame Over!");
                System.out.println("Correct Number was: " + targetNumber);
            }

            System.out.println("\nCurrent Score: " + score);

            System.out.print("\nPlay Again? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\n====================================");
        System.out.println("Final Score : " + score);
        System.out.println("Thank You For Playing!");
        System.out.println("====================================");

        sc.close();
    }
}