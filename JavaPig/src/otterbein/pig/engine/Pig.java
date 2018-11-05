package otterbein.pig.engine;

import java.util.*;
import java.io.*;
import otterbein.pig.player.*;

public class Pig {



  public static void main (String[] args) {

    System.out.println("\n===================");
    System.out.println("= Pig Death Match =");
    System.out.println("===================\n");

    //defalt to 5000 rounds (10,000 games)
    int numberOfRounds = 5000;

    //but allow the user to override
    if (args.length > 1) {
      numberOfRounds = Integer.parseInt(args[1]);
    }

    //get all the player file names
    ArrayList<String> fileNames = getPlayerFileNames();

    if (fileNames.size() < 2) {
      System.out.println("Need at least 2 player classes in the player folder.");
      System.exit(1);
    }

    //the game manager communicates what is happening via the GameStatusUpdateInterface
    //this allows us flexability of creating different types of updats UIs
    //right now, using an update class that outputs to the console

    GameStatusUpdate gameStatusUpdate = new GameStatusUpdate();
    //gameStatusUpdate.setVerbosityLevel(11);
    GameManager.getInstance().setStatusUpdate(gameStatusUpdate);

    TournamentManager tm = new TournamentManager(fileNames, gameStatusUpdate);

    tm.playRoundRobin(numberOfRounds);


    // SemiOptimal p1 = new SemiOptimal();
    // PlayerGoBigOrGoHome p2 = new PlayerGoBigOrGoHome();
    // GameManager.getInstance().playGame(p1, p2);
  }



  /**
  * Returns all the .class files in the player folder
  */
  private static ArrayList<String> getPlayerFileNames() {

    ArrayList<String> fileNames = new ArrayList<String>();

    File folder = new File("otterbein/pig/player");
    File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) {
        if (listOfFiles[i].getName().endsWith(".class")) {
          fileNames.add(listOfFiles[i].getName());
        }
      }
    }

    return fileNames;
  }




} // end class
