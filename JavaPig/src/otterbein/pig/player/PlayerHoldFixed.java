package otterbein.pig.player;

import otterbein.pig.engine.*;

public class PlayerHoldFixed implements PlayerInterface {

    private int holdCap;


    public PlayerHoldFixed() {
      this.holdCap = 20;
    }



    public boolean willPlay(int goalTotal, int turnTotal, int currentTotal, int opponentTotal) {

      if (currentTotal + turnTotal > goalTotal) {
        return false;
      }

      return (turnTotal<=holdCap);

    }



    public String getPlayerName() {
      return "Hold Fixed at " + holdCap;
    }
}
