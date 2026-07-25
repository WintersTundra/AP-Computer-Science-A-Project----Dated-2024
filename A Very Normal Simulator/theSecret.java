package Project;

import java.io.*;

public class theSecret {
	private int saveTotal;
	private boolean hasRead2;
	private boolean areYouOkay;
	private String[] clues = new String[3];

	/* Constructor for theSecret class */
	public theSecret() {
		saveTotal = 0;
		hasRead2 = false;
		areYouOkay = true;
		clues[0] = "???";
		clues[1] = "???";
		clues[2] = "???";
	}

	/*
	 * Method purpose: The ending method of the game. To get a code, answering yes is
	 * necessary
	 * 
	 * @param Pet pet - pet of the user
	 */
	public void areYouOkay(Pet pet) throws InterruptedException, IOException {
		System.out.println("Why do you ask that?");
		mainGameConsole.textHelper.sleep(2000);
		System.out.println("Of course I'm okay!");
		mainGameConsole.textHelper.sleep(3000);
		System.out.println("It's me and my fish!");
		mainGameConsole.textHelper.sleep(3000);
		System.out.print("We are okay! I think");
		mainGameConsole.textHelper.dot3(5000, 1, true);
		System.out.print("Maybe just");
		mainGameConsole.textHelper.dot3(5000, 1, false);
		System.out.print("a bit lonely");
		mainGameConsole.textHelper.dot3(5000, 1, false);
		System.out.print("sometimes");
		mainGameConsole.textHelper.dot3(5000, 0, true);
		System.out.println("Maybe I'm not.");
		mainGameConsole.textHelper.sleep(4000);
		System.out.println("It's hard to be a fishkeeper sometimes");
		mainGameConsole.textHelper.sleep(3000);
		System.out.println("Rarely anyone visits me");
		mainGameConsole.textHelper.sleep(3000);
		System.out.print("Only the goldfish");
		mainGameConsole.textHelper.dot3(3000, 1, false);
		mainGameConsole.textHelper.dot3(3000, 1, true);
		System.out.println("Hey! I have an idea!");
		mainGameConsole.textHelper.sleep(3000);
		System.out.println("Do you want to stay here with me and keep fish together?");
		mainGameConsole.textHelper.sleep(3000);
		System.out.println("You also get to learn some of my passive aggressiveness!");
		mainGameConsole.textHelper.sleep(3000);

		System.out.println("Y/N");
		String ans = mainGameConsole.textHelper.readLine();
		mainGameConsole.textHelper.sleep(2000);

		// If the user answers 'yes' (or a variant), they will get a code. If they do
		// not, the narrator will get mad and 'banish' them.
		if (mainGameConsole.responseHelper.yesAnswers.contains(ans)) {
			System.out.println("Well, thats great!");
			mainGameConsole.textHelper.sleep(3000);
			System.out.print("I've never thought that people want to.");
			mainGameConsole.textHelper.dot3(3000, 1, true);
			mainGameConsole.textHelper.sleep(3000);
			System.out.println("I'm glad you're here.");
			mainGameConsole.textHelper.sleep(3000);
			System.out.println("First thing that you can do is to keep taking care of your fish");
			mainGameConsole.textHelper.sleep(3000);
			System.out.println("I'll get the other stuff in order first, then I'll let you know about the next steps");
			mainGameConsole.textHelper.sleep(3000);
			System.out.println("Oh yea, here's the credits, or smt.\n");
			mainGameConsole.textHelper.sleep(3000);
			credits(); //Calls the credit method in theSecret class and prints out the credits
			mainGameConsole.textHelper.sleep(5000);
			System.out.println("\nOkay, back to the fish!");
			mainGameConsole.textHelper.sleep(5000);
			System.out.println("Save Code (For next game)");
			System.out.println(pet.getPetType() + ";" + pet.getNick() + ";" + pet.getPrest() + ";" + pet.getLevel()
					+ ";" + pet.getExp()); //Save code given to the player
		} else {
			// Case where narrator banishes them
			mainGameConsole.textHelper.dot3(3000, 1, true);
			System.out.println("I'm not surprised.");
			mainGameConsole.textHelper.sleep(3000);
			System.out.println("What can I say?");
			mainGameConsole.textHelper.sleep(3000);
			System.out.println("Everyone that comes here does so for their own interests.");
			mainGameConsole.textHelper.sleep(3000);
			System.out.println("Just the world we live in.");
			mainGameConsole.textHelper.sleep(3000);
			System.out.println("You better go before I decide not to let you.");
			mainGameConsole.textHelper.dot3(3000, 0, true);
			mainGameConsole.textHelper.sleep(3000);
			System.out.println("I said, G E T  O U T.");
			mainGameConsole.textHelper.sleep(3000);
			credits(); //Calls the credit method in theSecret class and prints out the credits
			System.out.println("End.");
		}
	}

	/*
	 * Method purpose: A shop where things are always out of stock apart from the
	 * mystery box. Mystery box contains one of three notes
	 */
	public void theSecretsShop() throws InterruptedException, IOException {
		mainGameConsole.textHelper.dot3(3000, 1, false);
		mainGameConsole.textHelper.sleep(2000);
		System.out.println("Welcome to the black market! ");
		mainGameConsole.textHelper.sleep(3000);
		System.out.println("You can buy unconventional fish products here.");
		mainGameConsole.textHelper.sleep(3000);
		System.out.println("What would you like? Type in the NUMBER");
		mainGameConsole.textHelper.sleep(3000);
		System.out.println("1. Black market fish flakes (??% (>40%) increase for exp)");
		System.out.println("2. Black market fish pellets (??% (>40%) increase for exp)");

		if (clues[2].equals("???")) {
			System.out.println("3. Mystery box");
		}

		int ans = mainGameConsole.textHelper.readInt();

		// Makes sure that, if the user enters 3 again after getting the mystery box, that
		// they will not be able to get it again
		if (ans == 3 && !clues[2].equals("???")) {
			ans = 4;
		}
		mainGameConsole.textHelper.sleep(3000);

		switch (ans) {
		case 1:
			System.out.println("Sorry! Currently out of stock!");
			mainGameConsole.textHelper.sleep(3000);
			break;
		case 2:
			System.out.println("Sorry! Currently out of stock!");
			mainGameConsole.textHelper.sleep(3000);
			break;
		case 3:
			//Location of one of the notes
			System.out.println("Oki! 30 fish coins please.");
			mainGameConsole.textHelper.dot3(2000, 1, true);
			mainGameConsole.textHelper.sleep(2000);
			System.out.println("Thank you! Here's your mystery box!");
			mainGameConsole.textHelper.sleep(3000);
			System.out.println("* You open the mystery box *");
			mainGameConsole.textHelper.dot3(2000, 1, true);
			System.out.println("It's just a piece of paper???");
			mainGameConsole.textHelper.sleep(3000);
			System.out.print("It reads");
			mainGameConsole.textHelper.dot3(2000, 1, false);
			System.out.println(" \"I don't think I'm okay.\"");
			mainGameConsole.textHelper.sleep(3000);
			System.out.println("Huh, what a weird mystery box.");
			mainGameConsole.textHelper.sleep(3000);
			clues[2] = "I don't think I'm okay"; //Adds the clue to the array
			updateAreYouOkay(); //checks if all of the notes have been found
			break;
		default: // Safety case
			System.out.println("That is not an option. Cya later!");
			mainGameConsole.textHelper.sleep(3000);
			break;
		}
	}

	/*
	 * Method purpose: Prints out the clues when the user inputs 6 into the main
	 * menu
	 */
	public void readClues() throws InterruptedException {
		System.out.println("~~~~~~~~~~Clues~~~~~~~~~~~");
		for (String k : clues) {
			mainGameConsole.textHelper.sleep(2000);
			System.out.println("\"" + k + "\"");
			mainGameConsole.textHelper.sleep(2000);
		}
		mainGameConsole.textHelper.sleep(4000);
	}

	/*
	 * Method purpose: Prints out the credits for the game ASCII letter art from
	 * www.asciiart.eu
	 */
	public void credits() throws InterruptedException {
		System.out.print("Thank you for playing");
		mainGameConsole.textHelper.dot3(1000, 1, true);
		System.out.println();
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
		System.out.println("Made by Fiona Li!");
		mainGameConsole.textHelper.sleep(3000);
		System.out.println("Various ASCII art from https://www.asciiart.eu/");
		mainGameConsole.textHelper.sleep(3000);
		System.out.println("Some help from various different Stack Overflow / Exchange threads");
		mainGameConsole.textHelper.sleep(3000);
		System.out.println("Next game wen?");
	}

	/*
	 * The following methods are accessors and mutators, in pairs for their
	 * respective variables
	 */

	// @return saveTotal - number of times that the user has ran the save method in
	// the Pet class
	public int getSaveTotal() {
		return saveTotal;
	}

	// updates the save total
	public void updateSaveTotal() {
		saveTotal++;
	}

	// @return hasRead2 - boolean variable that stores if the user has read the note
	// in the stats method in the Pet class
	public boolean getRead2() {
		return hasRead2;
	}

	// updates hasRead2
	public void updateRead2() {
		hasRead2 = true;
	}

	// @param - int n: the index of the clue that would like to be returned
	// @return - the clue at index n
	public String getClues(int n) {
		return clues[n];
	}

	// updates/adds the clues to the array when one is found
	// @param clue - the text of the clue
	//        n - the index of the array that the clue is stored
	public void addClues(String clue, int n) {
		clues[n] = clue;
	}

	// @return areYouOkay - a very important end game boolean variable
	public boolean getAreYouOkay() {
		return areYouOkay;
	}

	// updates AreYouOkay when necessary
	public void updateAreYouOkay() {
		// If all clues are found, then areYouOkay=false;
		if (clues[0] != "???" && clues[1] != "???" && clues[2] != "???") {
			areYouOkay = false;
		}
	}
}
