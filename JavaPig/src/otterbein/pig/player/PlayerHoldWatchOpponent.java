package otterbein.pig.player;

import otterbein.pig.engine.*;


public class PlayerHoldWatchOpponent implements PlayerInterface {

    private int holdCap;


    public PlayerHoldWatchOpponent() {
      this.holdCap = 20;
    }



    public boolean willPlay(int goalTotal, int turnTotal, int currentTotal, int opponentTotal) {

      if (currentTotal + turnTotal > goalTotal) {
        return false;
      }

      int cap = holdCap;

      if (opponentTotal > (currentTotal + turnTotal)) {
        cap = (int)Math.round((holdCap * 1.05));
      }

      if(turnTotal > 0) {
        if (opponentTotal * 1.1 < (currentTotal + turnTotal)) {
          cap = (int)Math.round((holdCap * 0.8));
        }
      }

      return (turnTotal<=cap);

    }



    public String getPlayerName() {
      return "PlayerHoldWatchOpponent" + holdCap;
    }
}
