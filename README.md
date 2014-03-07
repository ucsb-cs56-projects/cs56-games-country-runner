cs56-games-country-runner
=========================

#Game Description

Country Runner is an "avoid-the-obstacles" sidescroller game. Ride your piggy through the countryside landscape while dodging livestock and other obstacles in your way. Crash into anything, and you'll fall off your pig...thats Gameover. The farther you get and the more obstacles you skillfully avoid the higher your score. View your highest scores on the title page...and try to beat them of course!


##<i>Title Screen</i>

Use the <b>UP</b> and <b>DOWN</b> arrow keys to cycle through your options. Press <b>RIGHT</b> to select. 
Select <b>Play</b> to start the game. 
Select <b>Instructions</b> to learn how to play.
(The HighScores will be displayed on Title Page)


##Instuctions

Avoid all obstacles that come into the screen. Could be a stationary scarecrow, or a dashing sheep. Some crows could be overhead so time your jumps carefully. 

Press the <b>UP</b> arrow key to jump

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

Apply a scoring system to the game. Your score increases the farther you get without colliding with an obstacle. Keep a record of scores so that Highecores can be displayed on the Title Screen. 

Runner jumps longer by holding down the <b>UP</b> button. Quickly tapping the <b>UP</b> button will result in shorter jumps. 

Layer the background to create depth. Layering wil consist of of several backgrounds (some of which have transparent parts) that each scroll slightly faster then one behind it. 

