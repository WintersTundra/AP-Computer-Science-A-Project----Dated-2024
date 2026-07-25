package Project;

import java.io.*;

public class Pet {
	private final String petName;
	private String petNickname;
	private int prestigeLevel;
	private int level; 
	private int exp;
	
	/* Constructor for the Pet class
	 * 
	 * @param - int num : the number that the user picked for the type of fish
	 * 
	 * Calls findPetType(num) to convert user input to the actual type of fish
	 */
	public Pet(int num) {
		petName = findPetType(num); // Calling findPetType in the Pet class
		petNickname = findPetType(num);
		prestigeLevel = 0;
		level = 1;
		exp = 20;
	}
	
	/* Method purpose: Shows the main menu for all things pets and The Secret related 
	 *				   Is printed every time that the user exits out any of the sub-menus
	 */
	public void menu() throws InterruptedException {
		getPet(); //Shows an image of the pet
		System.out.println("~~~~~~~~~~~~~~~~~~");
		System.out.println("Pet: " + petName);
		System.out.println("Pet Name: " + petNickname);
		System.out.println("~~~~~~~~~~~~~~~~~~");
		System.out.println("Actions (Type the number only): ");
		System.out.println("1. View stats");
		System.out.println("2. Take care of fish");
		System.out.println("3. Save");
		System.out.println("4. Change Nickname ");
		System.out.println("5. Visit shop ");
		//if statement controls whether "Read Notes" is shown. If the user has at least 1 note it is shown
		if (!mainGameConsole.secretHelper.getClues(0).equals("???")
				|| !mainGameConsole.secretHelper.getClues(1).equals("???")
				|| !mainGameConsole.secretHelper.getClues(2).equals("???")) {
			System.out.println("6. Read Notes");
		}
		//if statement controls whether "Are you... okay?" is shown. Is shown when user has all three notes as that is when the areYouOkay variable in theSecret in true
		if (!mainGameConsole.secretHelper.getAreYouOkay()) {
			System.out.print("7. Are you");
			mainGameConsole.textHelper.dot3(1000, 1, false);
			System.out.print(" okay?");
		}
		System.out.println();
	}

	/* Method purpose: Shows the statistics of the pet
	 * 
	 * This method contains one of the three notes needed, and is obtained when the pet's level is at least 35
	 */
	public void viewStats() throws IOException, InterruptedException {
		mainGameConsole.textHelper.sleep(2000);
		System.out.println("~~~~~~~~~~~~~~~~~~");
		System.out.println("Pet: " + petName);
		System.out.println("Pet Name: " + petNickname);
		System.out.println("Pet Prestige: " + prestigeLevel); // Users cannot prestige at this version of the game
		System.out.println("Pet Level: " + level);
		System.out.println("Pet EXP: " + exp);
		System.out.println("~~~~~~~~~~~~~~~~~~");
		mainGameConsole.textHelper.sleep(5000);

		System.out.println("\nPlease note that you cannot prestige in this version of the game. I mean simulator.");
		mainGameConsole.textHelper.sleep(1500);
		System.out.println("I am okay");
		mainGameConsole.textHelper.sleep(5000);
		//When the goldfish is at least level 35, and the user hasn't read the note, this will run 
		if (level >= 35 && mainGameConsole.secretHelper.getRead2() == false) {
			System.out.print("Seems like " + petNickname + ", your " + petName + ", is swimming oddly");
			mainGameConsole.textHelper.dot3(4000, 1, true);
			System.out.println("Check up on your goldfish? Y/N");
			String ans = mainGameConsole.textHelper.readLine();
			mainGameConsole.textHelper.sleep(2000);
			if (mainGameConsole.responseHelper.yesAnswers.contains(ans)) {
				System.out.println("It spits out a note");
				mainGameConsole.textHelper.sleep(1500);
				System.out.print("The note reads");
				mainGameConsole.textHelper.dot3(3000, 1, true);
				mainGameConsole.textHelper.dot3(5000, 0, true);
				System.out.print("\"But I have to admit that it's a bit dark here\"");
				mainGameConsole.textHelper.dot3(4000, 1, true);
				System.out.println("What is that supposed to mean?");
				mainGameConsole.secretHelper.updateRead2(); // Updates hasRead2 to true so that this wouldn't run again 
				mainGameConsole.textHelper.sleep(2000);
				mainGameConsole.secretHelper.addClues("I have to admit that it's a bit dark here", 1); // Adds the clue to the clue array in theSecret class
				mainGameConsole.textHelper.sleep(2000);
				mainGameConsole.secretHelper.updateAreYouOkay(); // Checks if all notes have been found			
			}
		}
		System.out.println("Input anything to return to the main menu");
		/*holder allows the user to return to the main menu whenever they want 
		*so that they are not bombarded with the main menu without having enough time to look at the stats */
		String holder = mainGameConsole.textHelper.readLine();
		mainGameConsole.textHelper.sleep(2000);
	}
	
	/* Method purpose: Outputs the save menu and processes the user input for it
	 * 				   Is used to exp gaining / leveling up the pet
	 * 				   Is required for one of the three notes
	 * Uses the flavorText() method to add more flavor to some of the choices
	 */
	public void care() throws IOException, InterruptedException {
		int wrongChoice = 0; // Variable to count how many times a wrong input is inputted. If >10 then narrator will ridicule the user
		while (true) {
			System.out.println("~~~~~~~~~~~~~~Care Menu~~~~~~~~~~~~~~");
			mainGameConsole.textHelper.sleep(2000);
			System.out.println("1. Feed " + petNickname + " fish food");
			System.out.println("2. Do a 20% water change");
			System.out.println("3. Do a 50% water change");
			System.out.println("4. Do a full water change");
			System.out.println("5. Socialize with " + petNickname);
			System.out.println("6. Hug " + petNickname);
			System.out.println("7. Observe " + petNickname);
			System.out.println("8. Exit menu ");
			System.out.println();
			mainGameConsole.textHelper.sleep(1000);
			
			System.out.println("Enter the NUMBER: ");
			int choice = mainGameConsole.textHelper.readInt();
			
			if (choice == 1) {
				exp += (int) (Math.random() * 20) + 40;
				mainGameConsole.textHelper.sleep(2000);
				levelUp(); // Calls the levelUp method in the Pet class and checks if the user's pet can level up
				System.out.println(petNickname + " is feeling very happy after eating.");
				mainGameConsole.textHelper.sleep(3000);
				System.out.println(petNickname + " blows some bubbles at you");
				
			} else if (choice == 2) {
				exp += (int) (Math.random() * 10) + 40;
				levelUp(); // Calls the levelUp method in the Pet class and checks if the user's pet can level up
				mainGameConsole.textHelper.sleep(2000);
				System.out.println("* You do a 20% water change *");
				flavorText(); // Calls the flavorText method in the Pet class 
				
			} else if (choice == 3) {
				exp += (int) (Math.random() * 30) + 40;
				levelUp(); // Calls the levelUp method in the Pet class and checks if the user's pet can level up
				mainGameConsole.textHelper.sleep(2000);
				System.out.println("* You do a 50% water change *");
				flavorText(); // Calls the flavorText method in the Pet class 
				
			} else if (choice == 4) {
				exp += (int) (Math.random() * 50) + 40;
				levelUp(); // Calls the levelUp method in the Pet class and checks if the user's pet can level up
				mainGameConsole.textHelper.sleep(2000);
				System.out.println("* You do a full water change *");
				flavorText(); // Calls the flavorText method in the Pet class 

			} else if (choice == 5) {
				exp += (int) (Math.random() * 20) + 40;
				levelUp(); // Calls the levelUp method in the Pet class and checks if the user's pet can level up
				mainGameConsole.textHelper.sleep(2000);
				System.out.println("* You socialize with " + petNickname + " *");
				mainGameConsole.textHelper.sleep(2000);
				System.out.println(petNickname + " is loving the attention!");
				mainGameConsole.textHelper.sleep(2000);

			} else if (choice == 6) {
				exp += 42; //The meaning of life!
				levelUp(); // Calls the levelUp method in the Pet class and checks if the user's pet can level up
				System.out.println("* You hug your fish *");
				mainGameConsole.textHelper.sleep(2000);
				System.out.println(petNickname + " doesn't know what to think.");
				mainGameConsole.textHelper.sleep(2000);

			} else if (choice == 7) {
				mainGameConsole.textHelper.sleep(2000);
				System.out.println("* You watch your fish for a bit *");
				mainGameConsole.textHelper.dot3(3000, 0, true);
				mainGameConsole.textHelper.sleep(2000);
				System.out.println("It is very relaxing");
				mainGameConsole.textHelper.sleep(2000);
				mainGameConsole.textHelper.dot3(3000, 0, true);
				mainGameConsole.textHelper.sleep(2000);
				flavorText(); // Calls the flavor text method in the Pet class 
				
			} else if (choice == 8) {
				mainGameConsole.textHelper.sleep(2000);
				System.out.println("* You decide to wrap up for the day. *");
				mainGameConsole.textHelper.sleep(2000);
				break;
				
			} else if (choice == 999 && mainGameConsole.textHelper.getIsDev()) { // Choice for testing when needed
				level += 5;
				
			} else { //Safety case just in case the user puts in a bad input
				System.out.println("What you talking about. That is not a value choice.");
				mainGameConsole.textHelper.sleep(2000);
				wrongChoice++;
				if (wrongChoice > 10) {
					System.out.println("You users are so terrible at reading instructions. What can I even say.");
					mainGameConsole.textHelper.sleep(2000);
					System.out.println("Even your goldfish is looking at you weirdly.");
				}
			}
		}
	}

	/* Method purpose: The fake save method
	 * 				   When the user runs this method on the 4th time, one of three notes is discovered
	 */
	public void save() throws IOException, InterruptedException {
		if (mainGameConsole.secretHelper.getSaveTotal() < 3) {
			System.out.println("I said that you could save, but I lied. Imagine believing me.");
			mainGameConsole.textHelper.sleep(2000);
			System.out.println("MHWAHWHAHAHA IM SO EVILLL.");
			mainGameConsole.textHelper.sleep(2000);
			System.out.println("Would you like to return to the menu? Y/N");
			String ans = mainGameConsole.textHelper.readLine();
			
			if (mainGameConsole.responseHelper.yesAnswers.contains(ans)) {
				mainGameConsole.textHelper.sleep(1000);
				System.out.println("Okay, going back!");
				mainGameConsole.textHelper.sleep(4000);
				System.out.println("* Out of the corner of your eyes, you see something... strange");
				mainGameConsole.textHelper.sleep(3000);
				System.out.println("Perhaps there's more than what meets the eye?");
				mainGameConsole.textHelper.sleep(3000);
				/* These if statements attempt to push the player in the right direction of calling the method 4 times */
				if(mainGameConsole.secretHelper.getSaveTotal()==0) {
					System.out.println("\"The simplest tool of the writer is repetition.... The simplest tool of the writer is repetition.\" \n -Phillip Gerard");
				}
				if(mainGameConsole.secretHelper.getSaveTotal()==1) {
					System.out.println("... more than what meets the eye?");
				}
				if(mainGameConsole.secretHelper.getSaveTotal()==2) {
					System.out.println("... the current eye?");
				}
				mainGameConsole.textHelper.sleep(3500);
				System.out.println("It's probably nothing! Don't worry about it");
				mainGameConsole.secretHelper.updateSaveTotal(); // Calls and updates how many times the save() method has been called
				mainGameConsole.textHelper.sleep(3000);
				
			} else if (mainGameConsole.responseHelper.noAnswers.contains(ans)) {
				//If the user says 'no' to leaving, this will continue to loop until they say yes
				while (true) {
					System.out.print("I guess you can stay");
					mainGameConsole.textHelper.dot3(2000, 1, true);
					mainGameConsole.textHelper.sleep(20000);
					System.out.println("Sooo... There's nothing here, so do you want to return to the menu? Y/N");
					ans = mainGameConsole.textHelper.readLine();
					if (mainGameConsole.responseHelper.yesAnswers.contains(ans)) {
						mainGameConsole.textHelper.sleep(1000);
						System.out.println("Okay, going back!");
						mainGameConsole.textHelper.sleep(2000);
						mainGameConsole.secretHelper.updateSaveTotal(); // Calls and updates how many times the save() method has been called
						break;
					}
				}
			}
		} else if (mainGameConsole.secretHelper.getSaveTotal() == 3) {
			/* Location of one of the notes */
			System.out.println("Why are you here again? I already TOLD YOU that there's NOTHING HERE.");
			mainGameConsole.textHelper.sleep(2000);
			System.out.println("T H E R E  I S  N O T H I N G  H E R E");
			mainGameConsole.textHelper.sleep(2000);
			mainGameConsole.textHelper.dot3(2000, 1, true);
			mainGameConsole.textHelper.sleep(3000);
			System.out.println("Is that clearer?");
			mainGameConsole.textHelper.sleep(3000);
			System.out.println("Wait. What are you looking at???");
			mainGameConsole.textHelper.sleep(3000);
			System.out.println("* You see a black goldfish with red eyes *");
			mainGameConsole.textHelper.sleep(3000);
			System.out.println("* He has a piece of paper in his fins *");
			mainGameConsole.textHelper.sleep(3000);
			System.out.println("* You forcibly take it from him *");
			mainGameConsole.textHelper.sleep(3000);
			System.out.println("* He attempts to fight back, but it is no use since he is a goldfish *");
			mainGameConsole.textHelper.sleep(3000);
			System.out.println("* You open the note *");
			mainGameConsole.textHelper.sleep(3000);
			mainGameConsole.secretHelper.addClues("I am okay", 0); // Adds the clue to the clue array in theSecret class
			System.out.println("\"Maybe this place is a bit scary. But I am okay\", it reads");
			mainGameConsole.textHelper.sleep(3000);
			System.out.println("Hey, get out of here! Stop harrassing my fish!");
			mainGameConsole.textHelper.sleep(3000);
			mainGameConsole.secretHelper.updateAreYouOkay(); // Checks if all three clues have been found
			mainGameConsole.secretHelper.updateSaveTotal(); // Calls and updates how many times the save() method has been called
			
		} else if (mainGameConsole.secretHelper.getSaveTotal() > 3) {
			mainGameConsole.textHelper.sleep(2000);
			System.out.println("* You open the door labeled save, just to see a dark nonentity *");
			mainGameConsole.textHelper.sleep(3000);
			System.out.print(
					"* It seems to be calling out for help, but before you can do anything something pulls you back *");
			mainGameConsole.textHelper.dot3(1500, 0, true);
			mainGameConsole.textHelper.sleep(4000);
			System.out.println("\" I  a m  o k a y \", it echos");
			mainGameConsole.textHelper.sleep(3000);
			mainGameConsole.secretHelper.updateSaveTotal(); // Calls and updates how many times the save() method has been called
		}
	}
	
	/* Mutator method to update the level when exp >= 100
	 * Is conditionally recursive just in case exp>=200 so the extra exp isn't lost for the players
	 */
	public void levelUp() {
		if (exp >= 100) {
			exp -= 100;
			level++;
			if(exp>=100) {
				// Recursive just in case, by the off chance, that when this is called the user can level up twice or more (aka exp>200)
				levelUp();
			}
		}
	}
	/* Method purpose: Used to add different flavor for taking care of the pet.
	 * 				   Flavor text comes in my own experiences with my goldfish 
	 */
	public void flavorText() throws InterruptedException {
		mainGameConsole.textHelper.sleep(3000);
		int num = (int) (Math.random() * 100) + 1;
		
		if (num > 90) {
			System.out.println(petNickname + " is attacking the glass of the tank.");
		} else if (num > 80) {
			System.out.println(petNickname + " is chasing its own tail. What a cutie!");
		} else if (num > 70) {
			System.out.println(petNickname + "'s scales are shining brightly under the sun.");
		} else if (num > 60) {
			System.out.println(petNickname + " is nibbling on the aquarium plants.");
		} else if (num > 50) {
			System.out.println(petNickname + " is riding on the bubbles of the air stone.");
		} else if (num > 40) {
			System.out.println(
					petNickname + " is shaking its head violently after being let out of that gosh darn goldfish net.");
		} else if (num > 30) {
			System.out.println(petNickname + " is resting at the bottom of the aquarium.");
		} else if (num > 20) {
			System.out.println(petNickname + " is moving is eyes weirdly at you.");
		} else if (num > 10) {
			System.out.println(petNickname + " is trying to eat an invisible pellet.");
		} else if (num > 0) {
			System.out.println(petNickname
					+ " is understanding the laws of physics (and also toying with death) by jumping out of the water.");
		}
		mainGameConsole.textHelper.sleep(3000);
	}
	
	/* Method purpose: To find the pet type that the user picked from their number input
	 * 				   Users are asked to input a number so that a misspelling of the pet type can be avoided
	 * 
	 * @param - num = the choice, in integer format, that the user entered
	 * @return a String that is the type of goldfish that the user picked
	 */
	public String findPetType(int num) {
		if (num == 1) {
			return "Common goldfish";
		} else if (num == 2) {
			return "Fantail goldfish";
		} else if (num == 3) {
			return "Comet goldfish";
		} else if (num == 4) {
			return "Goldfish";
		} else {
			// Easter egg fish
			return "Easter Fish";			
		}
	}
	
	/* Mutator method for pet nickname
	 * 
	 * @param newNick - is the new nickname that has been written in by the user
	 */
	public void changeNickname(String newNick) {
		petNickname = newNick;
	}
	
	/* Method purpose: Prints out the goldfish image whenever needed
	 * 
	 * Art credit from https://www.asciiart.eu/ by Max Strandberg
	 */
	public void getPet() {
		System.out.println("Max     /\\\r\n" 
						 + "      _/./\r\n" 
	                     + "   ,-'    `-:.,-'/\r\n" 
				         + "  > O )<)    _  (\r\n"
				         + "   `-._  _.:' `-.\\\r\n" 
				         + "       `` \\;");
	}

	/* The following methods are accessors for Pet class variables */
	
	//@return the name that the user calls the pet 
	public String getNick() {
		return petNickname;
	}
	//@return the type of goldfish
	public String getPetType() {
		return petName;
	}
	//@return the prestige level
	public int getPrest() {
		return prestigeLevel;
	}
	//@return the level of the pet
	public int getLevel() {
		return level;
	}
	//@return current pet experience
	public int getExp() {
		return exp;
	}
}
