package otterbein.pig.player;

import otterbein.pig.engine.*;

public class PlayerGoBigOrGoHome implements PlayerInterface {

    private int holdCap;

    public PlayerGoBigOrGoHome() {
      this.holdCap = 50;
    }



    public boolean willPlay(int goalTotal, int turnTotal, int currentTotal, int opponentTotal) {

      if (currentTotal + turnTotal > goalTotal) {
        return false;
      }

      return (turnTotal<=holdCap);

    }



    public String getPlayerName() {
      return "Go for it!";
    }
}
