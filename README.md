cs56-games-country-runner
=========================


project history
===============
```
 W14 | andrewberls 4pm | thetomcraig, sdrhoads | Running game with obstacles.
 W16 | omeed 5pm       |Dongyang Li, Yueyang Li| Running game with obstacles.
 M16 |                 |Karli Yokotake, Yuxiang (Ethan) Wang | Running game with obstacles.
 F16 |                 | William Huang, Ray Ouyang, Running game with obstacles
```

#Game Description

Country Runner is an "avoid-the-obstacles" sidescroller game. Ride your piggy through the countryside landscape while dodging livestock and other obstacles in your way. Crash into anything, and you'll fall off your pig...thats Gameover. The farther you get and the more obstacles you skillfully avoid the higher your score. View your highest scores on the title page...and try to beat them of course!


##<i>Title Screen</i>

Use the <b>UP</b> and <b>DOWN</b> arrow keys to cycle through your options. Press <b>RIGHT</b> to select. 
Select <b>Play</b> to start the game. 
Select <b>High Scores</b> to display user high scores.
Select <b>Instructions</b> to learn how to play.
Select <b>Choose Difficulty</b> choose the difficulty of the game. 
Select <b>Choose Avatar</b> to choose an avatar to pay.
Select <b>Choose Background</b> to choose a background for the game.
(The HighScores will be displayed on a pop up on Title Page)


##Instuctions

Avoid all obstacles that come into the screen. Could be a stationary scarecrow, or a dashing sheep.
Some crows could be overhead so time your jumps carefully.
Press the Up arrow key to jump, Left/Right arrow keys to move forward or backward.
Press the space key to use your magical powers and shoot an image of yourself to remove obstacles!
--------------------------
#Developer Notes

These notes will help the current or future developers understand the overall goals for Country Runner as well as some suggestions on how to imlement some of the main features. 

##<i>Country Runner Version 1.0 </i>

Country Runner is a sidescroller game developed in Java. 

###General Mechanics of the Game

The runner is fixed at a constant X coordinate and translates his Y coordinate. 
To make the runner look like he is moving in the X direction, the background's X coordinate translates  at the speed that you want the runner to appear to move.  

The background will be continuously replaced with the next bit of stage of in the background to make it appear as if the runner is traveling. This will also make jumping look like an arc. The background can repeat. 
 
 
We want the motion of the runner "feel good." Jumping should models simple physics; for example, slowing down until he reaches highest point in jump, and then speeds up on the way down.  The jumps will be exaggerated so that he can actually jump over the obstacles. 

###Running and Testing the Game
We are using ant to automate compiling, testing, and running. 
Type `ant run` to compile and run the game.
Type `ant -p` to view the currently available tasks you can perform. 



##<i>Ideas Future Versions of Country Runner</i>
Prevent the add score button from showing up on the game over screen when the score is 0.

Set a boundary that prevents the player from moving of the screen.

Runner jumps longer by holding down the <b>UP</b> button. Quickly tapping the <b>UP</b> button will result in shorter jumps. 

Layer the background to create depth. Layering wil consist of of several backgrounds (some of which have transparent parts) that each scroll slightly faster then one behind it. 

##<i>M16 Final Remarks</i>

This is a game that we control a character to move and jump to avoid obstacles and get scores. Once the character collides with obstacles, game is over. The Gui.java is to create the window. The JPanel and title screen classes are used to draw image in different states of the game. Runner, Sheep and Snail classes which extends Sprite class will create and handle the state and behavior of the objects in the game. Runner object is the main character. Sheep, Snail, Racoon, and Panda objects are the obstacle objects. For future development of this legacy project, developer could prevent the player from moving off screen. Also, developer can add shoot method to let the main character or obstacles shoot. Furthermore, developers also can make a layered background which makes the game look more comfortable. For the opportunity of refactoring the project, future developers can move the action listeners out and create a InputHandler class to handle user inputs.

##<i>M16 Final Remarks</i>

##<i>F16 Final Remarks</i>

This is a game that has obstacles that try to oppose the user getting a high score by running into your runner but the runner can avoid the obstacles through quick movement and using your magical powers to shoot an image of yourself to remove an obstacle. All the classes that oppose the runner are raccoons, snails, sheep, and pandas and these classes extend the Obstacle class which extends the Sprite class, where a sprite just simply represents an animated object or "a sprite is a two-dimensional bitmap that is integrated into a larger scene" (Taken from Wikipedia's Sprite Definition). For the future development of this sick project, one could do things that M16 said to do such as make a layered background or create an InputHandler class or take this project as it is very developed and infuse your creativity into this project in order to leave not only a mark on this project but make the project just fun because it will be so creativefor you! For example, one could add new objects that one thinks are funny, new power-ups that one thinks are cool, portals that bring the runner to another world, or just lots of things that are involved with one's creativity(This is not an English class so excuse the lack of parallelism). If one wants to learn class design, there are some problems with the class design such as the score variable being spread out through obstacle classes or too many classes simply being in one folder. Anyways, I hope the people after us have fun with this project because this one was a memorable one! :^)

##<i>F16 Final Remarks</i>