package otterbein.pig.engine;



class ActivePlayer {

  private PlayerInterface player;
  private int turnTotal = 0;
  private int currentTotal = 0;
  private int goalScore = 0;


  public ActivePlayer(PlayerInterface player, int goalScore) {
    this.player = player;
    this.goalScore = goalScore;
  }


  public PlayerInterface getPlayer() { return player; }


  public boolean willPlay(int opponentTotal) {
    return player.willPlay(goalScore, turnTotal, currentTotal, opponentTotal);
  }


  public int getTurnTotal() { return turnTotal; }


  public void addToTurnTotal(int points) {
    turnTotal += points;
  }


  public int getCurrentTotal() { return currentTotal; }


  public void settleTurn() {
    currentTotal += turnTotal;
    turnTotal = 0;
  }


  public void pigOut() {
    turnTotal = 0;
  }


  public boolean isWinner() {
    return currentTotal >= goalScore;
  }


  public String toString() {
    return player.getPlayerName() + " Score = " + currentTotal;
  }

}
