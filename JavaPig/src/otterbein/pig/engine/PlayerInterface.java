package otterbein.pig.engine;


public interface PlayerInterface {

  /**
  * Called repeatedly on the players turn until either the player pigs out
  * of the player passes
  *
  * @param goalTotal The total that will win the game
  * @param turnTotal The total players has this turn
  * @param currentTotal The player total score NOT counting this turn's total
  * @param opponentTotal The opponents total score
  */
  public boolean willPlay(int goalTotal, int turnTotal, int currentTotal, int opponentTotal);


  /**
  * Name of the player, just used for display.
  */
  public String getPlayerName();

}
