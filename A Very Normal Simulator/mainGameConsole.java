package Project;

import java.io.*;

public class mainGameConsole {
	/*
	 * Static variables for global use textHelper is re-initialized in the main
	 * method if the user is a dev
	 */
	static theSecret secretHelper = new theSecret();
	static textHelper textHelper = new textHelper();
	static responseHelper responseHelper = new responseHelper();

	public static void main(String args[]) throws IOException, InterruptedException {
		/* Basic game introduction and setup */
		System.out.println("Do you have a promo code. Y/N");
		String ans = textHelper.readLine();
		if (ans.equals("dev")) {
			int isOn = textHelper.readInt();
			textHelper = new textHelper(true, isOn); //re-initialized textHelper for devs
		} else if (responseHelper.yesAnswers.contains(ans)) {
			System.out.println("Lies. It doesn't exist.");
		} else if (responseHelper.noAnswers.contains(ans)) {
			System.out.println("Good. Because it doesn't exist.");
		} else {
			//A little easter egg if no valid answer is given
			System.out.println("ERR.. YOu HaVE CauSED aN eRRor. pleAse R-R-R-E---stAR---t");
			textHelper.sleep(50000);
			System.out.println("What. Why are you still here?");
			textHelper.sleep(4000);
			System.out.println("Wait. What are you looking at?");
			textHelper.sleep(4000);
			System.out.println("There's nothing here!");
			textHelper.sleep(4000);
			System.out.println("Get Lost!");
			System.exit(0);
		}
		textHelper.sleep(2000); // textHelper.sleep(time) stops the program for (time) so that the text appears
								// line by line
		
		// Art made from https://www.asciiart.eu/
		System.out.println("_______________________________________________________ \n"

				+ "   / \\    | \\ | | ___  _ __ _ __ ___   __ _| | \r\n"
				+ "  / _ \\   |  \\| |/ _ \\| '__| '_ ` _ \\ / _` | | \r\n"
				+ " / ___ \\  | |\\  | (_) | |  | | | | | | (_| | | \r\n"
				+ "/_/__ \\_\\ |_| \\_|\\___/|_|_ |_| |_| |_|\\__,_|_| \r\n"
				+ "/ ___|(_)_ __ ___  _   _| | __ _| |_ ___  _ __ \r\n"
				+ "\\___ \\| | '_ ` _ \\| | | | |/ _` | __/ _ \\| '__|\r\n"
				+ " ___) | | | | | | | |_| | | (_| | || (_) | |   \r\n"
				+ "|____/|_|_| |_| |_|\\__,_|_|\\__,_|\\__\\___/|_|   \n"
				+ "_______________________________________________________ \n\n\n");

		textHelper.sleep(5000);
		System.out.println("There are no secrets here.");
		textHelper.sleep(3000);
		System.out.println("There is nothing here.");
		textHelper.sleep(3000);
		System.out.println("I am okay.");
		textHelper.sleep(20000);
		textHelper.dot3(2500, 0, true);

		System.out.println("Okay fine. I'm glad you've found my pet simulator! \n");
		textHelper.sleep(3000);
		System.out.println("This is just a pet simulator. Pick a pet!");
		textHelper.sleep(3500);
		System.out.println("I know that the selection might not be a lot,");
		textHelper.sleep(3500);
		System.out.println("it's all I have in the shop right now. ");
		textHelper.sleep(4000);
		System.out.println("Which pet would you like? (Type the number)");
		textHelper.sleep(4000);
		System.out.println(" 1. Common goldfish \n 2. Fantail goldfish \n 3. Comet goldfish \n 4. Goldfish");
		int petNum1 = textHelper.readInt(); // User can pick a pet here
		Pet pet1 = new Pet(petNum1);
		pet1.getPet();
		textHelper.sleep(5000);
		System.out.println("A fantastic choice!");
		textHelper.sleep(3000);

		System.out.println("Oh yes, do you need a tutorial on how to save? Y/N"); // saving tutorial
		if (responseHelper.yesAnswers.contains(textHelper.readLine())) {
			textHelper.sleep(1000);
			System.out
					.println("Just enter in the number that is labeled as \"save\" as you're taking care of your pet!");
			textHelper.sleep(2000);
		}
		textHelper.sleep(1000);
		System.out.println("Okay! Have fun! Don't bother me anymore. I am okay. Here's your pet:");
		textHelper.sleep(4000);
		pet1.getPet();
		textHelper.sleep(6000);

		boolean first5 = true; // This ensures that the user wouldn't be let into the shop on their first
							   // attempt
		/* Main parts of the game is here */
		while (true) {
			pet1.menu(); // Displays the main menu
			int choice = textHelper.readInt();
			if (choice == 1) {
				pet1.viewStats(); // Calls the viewStats method in the Pet class

			} else if (choice == 2) {
				pet1.care(); // Calls the care method in the Pet class

			} else if (choice == 3) {
				pet1.save(); // Calls the save method in the Pet class

			} else if (choice == 4) {
				// Updates pet nickname
				System.out.println("New Nickname:");
				pet1.changeNickname(textHelper.readLine()); // Calls the mutator method in Pet class for nicknames
				textHelper.sleep(1000);
				System.out.println("Pet Name: " + pet1.getNick()); // Prints out the new nickname as confirmation
				textHelper.sleep(2000);

			} else if (choice == 5) {
				textHelper.sleep(2000);
				/* 20% chance to get into the shop */
				if (!first5) {
					if ((Math.random() * 100) + 1 > 80) {
						secretHelper.theSecretsShop(); // Calls theSecretsShop in the theSecret class
					} else {
						System.out.println("The shop is currently under construction, please come back later");
						System.out.println("But is it really closed? Or is it a ruse?");
						textHelper.sleep(4000);
					}

				} else {
					/* Used to ensure that the user doesn't get into the shop on their first try */
					System.out.println("The shop is currently under construction, please come back later");
					textHelper.sleep(4000);
					System.out.println("But is it really closed? Or is it a ruse? Is there something deeper here?");
					textHelper.sleep(4000);
					textHelper.dot3(1000, 1, true);
					System.out.println("More than what meets the eye?");
					textHelper.sleep(4000);
					first5 = false;
				}

			} else if (choice == 6 && (!secretHelper.getClues(0).equals("???")
					|| !secretHelper.getClues(1).equals("???") || !secretHelper.getClues(2).equals("???"))) {
				/* After the user gets at least one clue, they will be able to read it here */
				secretHelper.readClues();

			} else if (choice == 7 && !secretHelper.getAreYouOkay()) {
				/* Once the users get all the clues and they choose 7, there will be an option to continue to the next stage
				 */
				textHelper.sleep(2000);
				System.out.println("WARNING: YOU WILL BE UNABLE TO COME BACK TO THIS STAGE IF YOU CHOOSE TO CONTINUE");
				textHelper.sleep(4000);
				System.out.println("ARE YOU READY? Y/N");
				ans = textHelper.readLine();
				if (responseHelper.yesAnswers.contains(ans)) {
					// If the user continues, then the while loop will be 'broken out of' so that
					// the end of game method of areYouOkay will be called
					break;
				} else {
					// If the user doesn't want to continue yet, the while loop will keep running
					// and they will be returned to the main menu
					textHelper.sleep(1000);
					System.out.println("Okay, going back!");
					textHelper.sleep(4000);
				}

			} else {
				/* Safety case */
				textHelper.sleep(4000);
				System.out.println("What. That is not an option! Do you want to drive me crazy?1!?");
				textHelper.sleep(3000);
			}
		}

		textHelper.sleep(3000);
		secretHelper.areYouOkay(pet1); //Calls the end of game method areYouOkay from the theSecret class.
	}
}
