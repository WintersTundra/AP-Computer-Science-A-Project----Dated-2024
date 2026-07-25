
1. Describe in detail the whole journey of creating your project! I want to understand your process and what you learned from embarking on creating a program that is larger in scale than what you may be used to from assignments. <br><br>
> Firstly, a few inspirations:
> The game is centered around goldfish keeping. I personally have a lot of goldfish throughout the years and currently have three. I absolutely love them and observe them on a daily basis (the flavor text describes some of the things I see my own goldfish do). I’d thought it would be amazing to honor them in this project. Most of the options for care are things that I do for my goldfish, minus the hugging goldfish one.
> As for the mystery and “’The Secret”, I am an avid fan of crime and mystery books so I decided to combine it into this project to also make it a little detective game as well: finding the truth of the narrator of the game.
> 
> The title and fish image were from https://www.asciiart.eu/ and https://www.asciiart.eu/animals/fish respectively.
> 
> 
> I split up the different portions into their related classes for better organization. Things related to the fish are in the Pet class, and things more closely related to “The Secret” are in theSecret class. In addition, I choose to use a text and response helper to help streamline the process of writing Input/Output of the game. It is a lot easier to read and to call textHelper.dot3([something]) than to copy and paste the for loops over and over again. The classes were great at helping me organize the methods, and it’s even more appreciated when I do it myself compared to just doing assignments. 
> 
> The mainGameConsole is the central driver of the game as it starts the game in addition to calling the necessary methods.
> The Pet class contains related instantaneous variables and methods to the pet. Stats, care, and save are all methods that are related to the pet. The stats method is for looking at how good your pet is (and is also where one of the notes are found) and the care method is for taking care of the fish. The save method was always supposed to have one of the notes in addition to an actual way to save your present process. However, I couldn’t think of an effective way to save the current process and reload the code back into the game so the real saving part was scrapped. I think this could be added after I have more experience with coding, however. 
> The theSecret class contains instantaneous variables and methods that relate closely to the secret. The secretShop method contains the ‘black market’ of the game and has one of the notes. The use of switch-case-default was from a coincidental finding as discussed later. 
> 
> As mentioned earlier, the textHelper class is to help with outputting text more efficiently and to make the code more readable.
> The responseHelper class helps with accepting multiple types of different “yes” and “no”. It does not have any methods as its purpose, for now, is to store the ArrayLists.  In the future, it is possible to expand responseHelper. It could help with user-input safeguards, for example, which is the main reason that this is a class and not just static lists that are declared in the mainGameConsole. The responseHelper object is static initialized in the mainGameConsole as well to reduce the clutter of initializing a new responseHelper or the ArrayLists with the possible answers in every class.
> 
> The first class that I started to write was mainGameConsole, second was textHelper, third was responseHelper, fourth was Pet, and fifth was theSecret. These classes were all developed at the same time after their initial creation, depending on what I needed and at what point. For instance, I only wrote the stats method when I needed to call it in mainGameConsole. I wrote the dot3() method when the need arises.
> textHelper and responseHelper were the first two classes to be completed fully, which isn’t too surprising considering their importance for the rest of the classes and functionality in general. 
> 


2. Describe the obstacles you faced. <br>
> I was initially overly ambitious with the project. Some of my ambitions that I wasn’t able to do: I wanted to have a lot of ASCII animations, a big and useful shop, fish training and playing, player/fish vs. entity fighting (You would find out one of the notes from this originally), fighting statistics and boost items, etc.. However, I was limited by my inexperience with coding and making games and found that I was unable to go through with the ones I have listed. One of the things that I was able to add, the pet care option, was a struggle to code so that it would connect to the rest of the game nicely.
> 
> In addition, I had a hard time coming up with the “how to get to The Secret” part. I knew what The Secret would be, just not the process of getting to it. 
> 
> I found it sometimes difficult to write concise comments that efficiently depicted what the method was doing.

3. Describe how you overcame those obstacles. <br>
> 1. I had to recognize the limits of my abilities and decide on what to cut and what I can push myself to do. I did a ton of research to get some elements down (Some are mentioned in Q1) and I also did a lot of testing to check that the program works as intended, especially on the parts where I struggled to write the code.
> 
> 2. I toyed with different ideas, such as linear progression, battles, etc., but I settled on the notes for simplicity and a play-for-reward type of structure. I felt that this structure was the best fit for my skill level.  
> 
> 3. For the methods that I had a hard time with, I decided to make a quick table of the use, parameters, return elements, and important things in that method. Then, I combined the uses and important things together and used @param and @return for the parameters and return elements. I looked at how some other developers wrote comments (mainly in the lesson video from Unit 5 and some images from the internet) and attempted to model mine after theirs. 

4. What further additions would enhance your project if you had more time and skill? <br>
> I would add more safeguards for the user. For instance, if the user accidentally enters a String instead of an int, the program would let them know and ask them to input it again instead of throwing an error and crashing the entire program, especially when there aren't any save progress codes. I definitely had this happen to me more than once when testing. Perhaps I would add it in the textHelper/responseHelper class so that any time a read input method is called, it would check in that method and do it for every input so I don’t need to go back and edit every single input prompt. 
> 
> I would also add more items to the shop and actually make them usable, in addition to adding methods of gaining the fish coins. This would make the caring for the fish part more interactive and varied. 
> 
> Harder to find clues beyond the ones I have right now can make the game more engaging. They will also have more lore and make the plot more intriguing as well. Also, adding easter eggs could be a delightful treat for those who find it.
> 
> I would like to be able to allow the user to have more than one fish, perhaps storing the pets in an ArrayList: 
> 	ArrayList<Pet> petList = new ArrayList<Pet>();
> 
> 
> A save-process code would also be nice to have. In addition to having the fake save method, a real save method would actually give a code to the players so that they can leave and return to the game whenever they want. 


