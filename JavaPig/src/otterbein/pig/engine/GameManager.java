package otterbein.pig.engine;


import java.util.*;


/**
* Facilitates one game of pig between two players.
*/
public class GameManager {

  private static final GameManager instance = new GameManager();

  private GameStatusUpdateInterface statusUpdate;

  private static final int PIGOUT = 1;

  private int goalScore = 100;
  private int sidesOfDice = 6;



  /**
  * Private constructor to enfore the singleton pattern
  */
  private GameManager() {}


  /**
  * Accessor for the singleton pattern
  */
  public static GameManager getInstance() {
      return instance;
  }


  /**
  * All output from the GameManager is raised as calls to this update interface.
  *
  * @param statusUpdate object that implements the GameStatusUpdateInterface that
  * will handel all status update events
  */
  public void setStatusUpdate(GameStatusUpdateInterface statusUpdate) {
      this.statusUpdate = statusUpdate;
  }


  /**
  * Plays a game between two supplied players.
  *
  * @param player1
  * @param player2
  */
  public PlayerInterface playGame(PlayerInterface player1, PlayerInterface player2) {

    ActivePlayer p1 = new ActivePlayer(player1, goalScore);
    ActivePlayer p2 = new ActivePlayer(player2, goalScore);

    int turn = 0;

    while(!p1.isWinner() && !p2.isWinner()) {

      playerTurn(p1, p2);

      if(!p1.isWinner()) {
        playerTurn(p2, p1);
      }

      turn++;

      if(statusUpdate != null) statusUpdate.newTurn(turn, p1, p2);

    }

    if(p1.isWinner()) {
      return p1.getPlayer();
    }
    else {
      return p2.getPlayer();
    }
  }



  private void playerTurn(ActivePlayer player, ActivePlayer opponent) {

    while (player.willPlay(opponent.getCurrentTotal())) {

      //roll the dice
      Random random = new Random();
      int diceValue = (random.nextInt(sidesOfDice) + 1);

      if(statusUpdate != null) statusUpdate.playerRolls(player, diceValue);

      if (diceValue==PIGOUT) {
        //player lost, zero out turn score and exit
        if(statusUpdate != null) statusUpdate.pigOut(player);
        player.pigOut();
        return;
      }
      else {
          player.addToTurnTotal(diceValue);
      }
    }

    if(statusUpdate != null) statusUpdate.pass(player);
    player.settleTurn();
  }

} // end class
