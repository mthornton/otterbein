package otterbein.pig.engine;

import java.util.*;

/**
* Responds to status events by outputing to console.
*/
class GameStatusUpdate implements GameStatusUpdateInterface {

  private int outputLevel = VERBOSITY_LOW;

  public void setVerbosityLevel(int verbosityLevel) {
    outputLevel = verbosityLevel;
  }

  
  public void newTurn(int turnNumber, ActivePlayer p1, ActivePlayer p2) {
    if (outputLevel >= VERBOSITY_HIGH) {
      System.out.println("\n-----------");
      System.out.println("Turn " + turnNumber);
      System.out.println(p1.toString());
      System.out.println(p2.toString());
    }
  }


  public void playerRolls(ActivePlayer player, int rollValue) {
    if (outputLevel >= VERBOSITY_HIGH) {
      System.out.println(player.getPlayer().getPlayerName() + " rolled " + rollValue);
    }
  }


  public void pigOut(ActivePlayer player) {
    if (outputLevel >= VERBOSITY_HIGH) {
      System.out.println(player.getPlayer().getPlayerName() + " Pig Out!");
    }
  }


  public void pass(ActivePlayer player) {
    if (outputLevel >= VERBOSITY_HIGH) {
      System.out.println(player.getPlayer().getPlayerName() + " passing.  Earned " + player.getTurnTotal() + " for a new total of " + (player.getCurrentTotal() + player.getTurnTotal()));
    }
  }


  public void tournamentMatchOver(TournamentPlayer player1, TournamentPlayer player2) {

    System.out.println(player1.getPlayer().getPlayerName() + " won " + player1.getWins());
    System.out.println(player2.getPlayer().getPlayerName() + " won " + player2.getWins());
    System.out.println("");
  }


  public void tournamentOver(ArrayList<TournamentPlayer> players) {

      System.out.println("\n------------------------");
      System.out.println("-- Tournament results --");
      System.out.println("------------------------\n");

      for(TournamentPlayer player : players) {
        System.out.println(player.getPlayer().getPlayerName() + " wins : " + player.getMatchWins() + " losses : " + player.getMatchLosses());
      }
  }

} // end class
