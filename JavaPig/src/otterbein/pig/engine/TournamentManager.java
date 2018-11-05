package otterbein.pig.engine;

import java.util.*;


/**
* Manages a group of players in a tournament.
*/
class TournamentManager {

  ArrayList<TournamentPlayer> players = new ArrayList<TournamentPlayer>();
  GameStatusUpdateInterface gameStatusUpdate;

  public TournamentManager(ArrayList<String> playerFileNames, GameStatusUpdateInterface gameStatusUpdate) {

    this.gameStatusUpdate = gameStatusUpdate;

    for (String filename : playerFileNames) {
      try {
        players.add(TournamentPlayer.createTournamentPlayerFromFile(filename));
      }
      catch (Exception e) {

      }
    }
  }



  /**
  * Accessor to the tournament player list.
  */
  public ArrayList<TournamentPlayer> getPlayers() {
    return players;
  }



  /**
  * Have each player play each other.
  *
  * @param numberOfRounds number of rounds to play - note that one round includes two games
  */
  public void playRoundRobin(int numberOfRounds) {

    //have every player play every other player
    for (int p1=0;p1<players.size();p1++) {
      for (int p2=(p1+1);p2<players.size();p2++) {
        try {
          resetStats();
          playMatch(players.get(p1), players.get(p2), numberOfRounds);
        } catch (Exception e) {
          System.out.println("Error : " + e.toString());
        }
      }
    }

    gameStatusUpdate.tournamentOver(players);
  }


  /**
  * Resets the stats for all the players.
  */
  private void resetStats() {

    for(TournamentPlayer player : players) {
      player.resetStats();
    }
  }



  /**
  * Plays a match between two players.
  *
  * @param player1FileName Name of the first player file to load and play
  * @param player2FileName Name of the second player file to load and play
  * @param numberOfRounds Number of rounds to play.  Each round consists of two
  * games with player1 going first in the first game and player2 in the second.
  */
  private void playMatch(TournamentPlayer tournamentPlayer1, TournamentPlayer tournamentPlayer2, int numberOfRounds) throws Exception{

    PlayerInterface player1 = tournamentPlayer1.getPlayer();
    PlayerInterface player2 = tournamentPlayer2.getPlayer();

    for (int i = 0;i<numberOfRounds;i++) {

      //each round two games are played with ech player getting a chance to go first

      PlayerInterface playerWinner = GameManager.getInstance().playGame(player1, player2);
      if(playerWinner == player1) {
        tournamentPlayer1.addWin();
        tournamentPlayer2.addLoss();
      }
      else {
        tournamentPlayer1.addLoss();
        tournamentPlayer2.addWin();
      }


      PlayerInterface playerWinner2 = GameManager.getInstance().playGame(player2, player1);
      if(playerWinner == player1) {
        tournamentPlayer1.addWin();
        tournamentPlayer2.addLoss();
      }
      else {
        tournamentPlayer1.addLoss();
        tournamentPlayer2.addWin();
      }

    }


    //determine the winner of the match
    if (tournamentPlayer1.getWins() > tournamentPlayer2.getWins()) {
        tournamentPlayer1.addMatchWin();
        tournamentPlayer2.addMatchLoss();
    }
    else {
      tournamentPlayer1.addMatchLoss();
      tournamentPlayer2.addMatchWin();
    }

    gameStatusUpdate.tournamentMatchOver(tournamentPlayer1, tournamentPlayer2);

  }


} // end class
