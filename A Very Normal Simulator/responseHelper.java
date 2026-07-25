package Project;

/* Class use: class is to help with accepting different inputs from users outside of Y/N just in case
* by putting it in this class, it reduces the clutter in the other classes and increase readability 
* why not just see if input.charAt(0) = 'Y'/;N'? the answer might not make sense; "your goldfish" =/= "yes"
*/
import java.util.*;

public class responseHelper {
	public List<String> yesAnswers = new ArrayList<String>();
	public List<String> noAnswers = new ArrayList<String>();
	
	/*Constructor initializes all of the arrays*/
	public responseHelper() {		
		yesAnswers.add("Y");
		yesAnswers.add("y");
		yesAnswers.add("yes");
		yesAnswers.add("Yes");
		yesAnswers.add("Yup");
		yesAnswers.add("yup");
		yesAnswers.add("Yep");
		yesAnswers.add("yep");
		yesAnswers.add("Yea");
		yesAnswers.add("yea");
		yesAnswers.add("Ye");
		yesAnswers.add("ye");
		yesAnswers.add("Ya");
		yesAnswers.add("ya");

		noAnswers.add("N");
		noAnswers.add("n");
		noAnswers.add("No");
		noAnswers.add("no");
		noAnswers.add("Nah");
		noAnswers.add("nah");
		noAnswers.add("Nope");
		noAnswers.add("nope");
	}
}
