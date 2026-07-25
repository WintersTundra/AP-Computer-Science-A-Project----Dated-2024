package Project;

import java.io.*;

public class textHelper {
	/* For isOn = 0 -> No waiting for line-by-line text
	 * isOn = 1 -> Yes waiting for line-by-line text
	 */
	private boolean isDev;
	private int isOn; 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	/*Constructor used for testing*/
	public textHelper(boolean dev, int is) {
		isDev = dev;
		isOn = is;
	}
	
	/*Constructor used for players*/
	public textHelper() { 
		isDev = false;
		isOn = 1;
	}
	
	/* Method purpose: for printing out ... either horizontally or vertically
	 * @param -
	 * time = amount of time stopped
	 * vertOrHori = 0 : vertical ; vertOrHori = 1: horizontal
	 * newLine = false : no new line after the ... ; newLine = true : new line after
	 * */
	public void dot3(int time, int vertOrHori, boolean newLine) throws InterruptedException { 
		
		if ((isDev == false || isOn == 1) ) { 
			//These ones do not skip the waiting, generally for players  and for testing when looking at if the stops are long/short enough
			if (vertOrHori == 0) {
				//By design, the vertical ... will always have a new line after it, so we do not consider newLine
				for (int i = 0; i < 3; i++) { 
					System.out.println(".");
					Thread.sleep(time);
				}
			}
			if (vertOrHori == 1) {
				// This is for horizontal ... 
				for (int i = 0; i < 3; i++) {
					System.out.print(".");
					Thread.sleep(time);
				}
				// Horizontal ... might be in the middle of a sentence, so having newLine allows for flexibility in terms of next line formatting
				if (newLine) {
					System.out.println();
				}
			}
		}  else { 
			//These ones skip the waiting so that the game can be tested more efficiently 
			if (vertOrHori == 0) { //This is for vertical
				for (int i = 0; i < 3; i++) {
					System.out.println(".");
				}
			} else if (vertOrHori == 1) { //This is for horizontal 
				for (int i = 0; i < 3; i++) {
					System.out.print(".");
				}
				if (newLine) {
					System.out.println();
				}

			}
		}
	}
	
	/* Method purpose: This method is an extension of the sleep() method from Thread
	 * 					It has been modified so that sleep() is optional depending on the user
	 * @param n = amount of time in milliseconds to wait
	 */
	public void sleep(int n) throws InterruptedException {
		if (isOn == 1) {
			Thread.sleep(n);
		}
	}
	
	/* Accessor method for isDev variable
	 * Is mainly used to only check if a user has the permissions to input 999 when leveling up
	 * @return the variable getIsDev - true if user is dev, false otherwise
	 */
	public boolean getIsDev() {
		return isDev;
	}
	
	/* The following methods' purpose: To read various inputs
	 * These are all concentrated in textHelper to reduce the need for BufferedReader declarations every class
	 */
	
	//@return the user input if it is an int
	int readInt() throws IOException {
		return Integer.parseInt(br.readLine());
	}
	
	//@return the user input if it is a String
	String readLine() throws IOException {
		return br.readLine().trim();
	}
}
