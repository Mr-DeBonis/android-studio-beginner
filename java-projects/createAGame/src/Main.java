import java.util.Random;
import java.util.Scanner;

/**
 * We are going to make a GAME!
 * The concept is: Generate a random number and ask the user to guess the number,
 * continue asking until you receive the number
 * after 5 times of guessing show a game over message
 * <p>
 * Here is how it works:
 * Show a welcome message
 * Ask the User's name and say hello to the user
 * Ask if we should start the game
 * After receiving a positive answer generate a random number and ask for the user's guess
 * If the guess is correct show a congratulation message and quit the game
 * If the number is not correct, ask again until you receive the correct answer
 * As a hint, beside the first time, every time that you are asking for a number, tell the user  to guess higher or lower
 * If the User failed 5 times, show a game over message and quit the game
 */
public class Main {
    public static void main(String[] args) {
        // Welcome message
        System.out.printf("Hello and welcome!");

        // Ask user's name and hello
        System.out.println("Please enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Hello " + name + "!");

        System.out.println("Would you like to play a game? (Yes/No)");
        String answer = scanner.next();

        if (answer.toLowerCase().equals("yes")) {
            Random random = new Random();
            int randomNumber = random.nextInt(20);
            boolean hasWon = false;

            int timesTried = 0;
            do {
                timesTried++;
                System.out.println("Guess a number:");
                int guess = scanner.nextInt();
                if (guess == randomNumber) {
                    System.out.println("Congratulations, you won!");
                    hasWon = true;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Guess higher!");
                } else {
                    System.out.println("Guess lower!");
                }
            } while (timesTried < 5);

            if (!hasWon) {
                System.out.println("Game over!");
            }

            System.out.println("The number is " + randomNumber);
        } else {
            System.out.println("Good bye!");
        }

    }
}