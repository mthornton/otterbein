package otterbein.pig.engine;


/**
* Wrapper to hold a play and thier stats for a tournament.  Used in TournamentManager.
*/
class TournamentPlayer {

  private int wins = 0;             //games won
  private int losses = 0;           //games lost
  private int matchWins = 0;        //matches won
  private int matchLosses = 0;      //matches lost
  private PlayerInterface player;



  public static TournamentPlayer createTournamentPlayerFromFile(String filename) {

    try {
      PlayerInterface player = loadPlayerNamed(filename);

      return new TournamentPlayer(player);

    } catch (Exception e) {
      return null;
    }
  }



  private TournamentPlayer(PlayerInterface player) {

    this.player = player;
  }


  public PlayerInterface getPlayer() { return player; }


  public void addMatchWin() { matchWins++; }


  public void addMatchLoss() { matchLosses++; }


  public int getMatchWins() { return matchWins; }


  public int getMatchLosses() { return matchLosses; }


  public void addWin() { wins++; }


  public int getWins() { return wins; }


  public void addLoss() { losses++; }


  public int getLosses() { return losses; }


  public void resetStats() {
      wins = 0;
      losses = 0;
  }



  /**
  * Loads a PlayerInterface from a class name.
  * The class must be in the players folder and it must implement PlayerInterface.
  *
  * @param className Name of the file to load.
  */
  private static PlayerInterface loadPlayerNamed(String className) throws Exception {

    try {
      String fullyQualifiedName = "otterbein.pig.player." + className.replace(".class", "");
      Class<?> c = Class.forName(fullyQualifiedName);

      PlayerInterface player = (PlayerInterface) c.newInstance();

      return player;
    }
    catch (Exception e) {
      throw e;
    }
  }

} // end class
