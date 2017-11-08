##Anna L., Ricardo L.

* a) 2D side-scrolling game; player controls a character with arrow keys and space bar, to jump over sheep, slimes, racoons, etc.
There's a menu where you can customize your avatar, choose background, choose difficulty, read instructions, see high scores...
* b) As a player character, you can jump over different obstacles/animals in order to accumulate points and advance through different levels.
You can also attack the animals with dual images of your player character to eliminate the obstacles from the screen.
* c) Software runs, pulls up menu screen upon run, everything works.
* d) Better physics, power-ups, changing maps (backgrounds) with each level change, make it more obvious that you've advanced a level by clearing the screen/getting bigger etc.
* e)The current readme file is in decent conditions. One thing it does not mention is how the code is set up or anything about the code in general. 
* f)It works fine and everything seems to be well described maybe as we dive deeper into this prject we'll notice some things that are missing or targets that need description or wee'll need to modify it as we add feautures but as of now it looks great. It turns out though that there is a bug that needs to be fixed.
* g)yea there's definetely enough issues to earn us 1000 points some that look fun like adding obstacles you can jump on.
* h)we have not added any as some of the stuff we had thought of like power ups and portals were added 2 years ago so maybe we'll work on that. There also appears to be a 0 score issue which looks like fun.
* i)In my opinion there are three main components to this game theres the CountryRunnerJPanel which keeps track of mostly evrything. there's then the sprite class and the SpriteSequenceClass which is defined withing the file as a glorified array list with an index to curretn position so the Jpanel relies heavily on that. The Sprite class is where all the sprites inherit from and the sprites are everything. the main characters extend sprite the bad guys extend obtacle which extends sprite. That pretty much tells you everything
* j)there appears to be a base runner junit test as well as a test for the sprite class. As with everything theres always opportunities to expand the testing even though the game appears to work fine and one would think it is not nessary to add more test. 
