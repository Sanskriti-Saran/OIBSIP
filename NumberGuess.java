
import java.util.Scanner;

public class NumberGuess {

	public static void
	guessingNumberGame()
	{
		Scanner sc = new Scanner(System.in);
		int number = 1 + (int)(100 * Math.random());
        
        System.out.println("Number of trials? ");
        int K = sc.nextInt();
        int i, guess;
		System.out.println("A number is chosen" + " between 1 to 100."+ "\nGuess the number"+ " within above trials.");

		for (i = 0; i < K; i++) {
			System.out.println("Guess the number:");
			guess = sc.nextInt();
			if (number == guess) {
				System.out.println("Congratulations!" + " You guessed the number.");
				break;
			}
			else if (number > guess && i != K - 1) {
				System.out.println("The number is "+ "greater than " + guess);
			}
			else if (number < guess && i != K - 1) {
				System.out.println("The number is"	+ " less than " + guess);
			}
		}
		if (i == K) {
			System.out.println("All trials have been used");

			System.out.println("The number was " + number);
		}
	}
    public static void main(String arg[])
	{
		guessingNumberGame();
	}
}
