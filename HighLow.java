import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class HighLow {
			// declare global variables and initialize some variables
	public static boolean playAgain = true;
	public static int guessCounter = 0;
	public static int randomInteger;

	public static void main(String[] args) {
				//Generate a random number between -100 and 1000 for the user to guess
		randomInteger = generateRandomNumber(-100, 1000);
				//System.out.println(randomInteger);
				// while the playAgain is true will continue the loop - initialized to true - set to false when user says no
				// to the play again question - will also update counter during each loop to count number of tries taken 
				// to guess the correct number
		while (playAgain) {
			guessCounter++;
			int userNumber = getUsersNumber(); //call method to ask user for number
			if (userNumber > randomInteger) {
				System.out.println("Number is too high! Try again");
			} else if (userNumber < randomInteger) {
				System.out.println("Number is to low! Try again");
			} else {
					// if the user input number is equal to the random number will call 
					// method to ask if they wish play again if yes will repeat loop if no
					// will set playAgain to false
				playAgain(); 
			}
		}

	}
			// let the user know that they have correct number and how
			// many tries it took to guess that number, will then
			// ask if they wish play again if yes will generate new randomNumber  
			// and reset counter 
			//if no will output thank you and will set playAgain to false
	private static boolean playAgain() {
		System.out.println("That is correct!!!");
		System.out.println("It took you " + guessCounter + " tries to guess the number!");
		System.out.println("Do you wish to play again? (y/n)");
		Scanner play = new Scanner(System.in);
		String yesOrNo = play.next();
		if (yesOrNo.toLowerCase().startsWith("n")) {
			playAgain = false;
			System.out.println("Thank you for playing. Have a great day!");
			play.close();
		} else if (yesOrNo.toLowerCase().startsWith("y")) {
			playAgain = true;
			randomInteger = generateRandomNumber(-100, 1000);
				//System.out.println(randomInteger);
			guessCounter = 0;
		}
		return playAgain;
	}
			// method will tell the user to select a number between -100 and 1000 then
			// will accept the number that the user inputs and returns the number entered
	private static int getUsersNumber() {
		System.out.println("Please enter a number between -100 and 1000");
		Scanner getNumber = new Scanner(System.in);
		int userNumber = getNumber.nextInt();
		if (!playAgain) {
			getNumber.close();
		}
		return userNumber;
	}

			// generates the random number between the 2 numbers that were sent into method
			// then returns that number
	private static int generateRandomNumber(int number1, int number2) {
		int randomInteger = ThreadLocalRandom.current().nextInt(number1, number2);
		return randomInteger;
	}
}
# HighLow
