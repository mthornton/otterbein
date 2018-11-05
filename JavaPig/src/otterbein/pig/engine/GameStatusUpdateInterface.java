package otterbein.pig.engine;

import java.util.*;

interface GameStatusUpdateInterface {

  public int VERBOSITY_HIGH = 10;
  public int VERBOSITY_MEDIUM = 9;
  public int VERBOSITY_LOW = 8;
  public int VERBOSITY_NONE = 7;

  public void setVerbosityLevel(int verbosityLevel);

  public void newTurn(int turnNumber, ActivePlayer p1, ActivePlayer p2);

  public void playerRolls(ActivePlayer player, int rollValue);

  public void pigOut(ActivePlayer player);

  public void pass(ActivePlayer player);

  public void tournamentOver(ArrayList<TournamentPlayer> players);

  public void tournamentMatchOver(TournamentPlayer player1, TournamentPlayer player2);
}
