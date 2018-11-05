package otterbein.pig.player;

import otterbein.pig.engine.*;

public class PlayerNoRisk implements PlayerInterface {

    private int holdCap;

    public PlayerNoRisk() {
      this.holdCap = 1;
    }



    public boolean willPlay(int goalTotal, int turnTotal, int currentTotal, int opponentTotal) {

      if (currentTotal + turnTotal > goalTotal) {
        return false;
      }

      return (turnTotal<=holdCap);

    }



    public String getPlayerName() {
      return "No Risk No Reward";
    }
}
