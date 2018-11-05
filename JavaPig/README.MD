JavaPig

[Pig](https://en.wikipedia.org/wiki/Pig_(dice_game)) is classic, and fun, dice game.

This program is a system that allows people to implement their own pig playing AI and compete with other AIs.

# Building
The build has been tested on JDK 1.8+.  To build, navigate to the src folder and:
```
javac otterbein/pig/engine/*.java otterbein/pig/player/*.java
```

Or, you can just run the supplied script in the src folder:
```
./build.sh
```

# Running
Run the program with:
```
java -cp . otterbein/pig/engine/Pig
```

Or, you can just run the supplied script in the src folder:
```
./run.sh
```

The program will pick up all the class files in the player folder and have them play each other in a round robin fashion for 5,000 rounds.  Each round consists of 2 games with the two player taking turns going first.  You can override the number of rounds from the command line:
```
java -cp . otterbein/pig/engine/Pig 10000
```

# Adding your own AI
To create your own AI player, create a java file implementing PlayerInterface.  Each time your player needs to decide if they should play or not, the willPlay method is called.  Your program's job is to return true if you want to roll, false to hold.

# Design
## Auto generated UML diagram
![alt text][UML]
