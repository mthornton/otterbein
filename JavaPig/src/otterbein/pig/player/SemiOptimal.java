package otterbein.pig.player;

import otterbein.pig.engine.*;

public class SemiOptimal implements PlayerInterface {

    private int holdCap;



    public SemiOptimal() {
      this.holdCap = 21;
    }



    public boolean willPlay(int goalTotal, int turnTotal, int currentTotal, int opponentTotal) {

      if (currentTotal + turnTotal > goalTotal) {
        return false;
      }

      if (opponentTotal >= 71) {
        return true;
      }
      else {
        return turnTotal <= 21; //(21 + (4*((opponentTotal - currentTotal) / 8)));
      }


    }



    public String getPlayerName() {
      return "Semi optimal";
    }
}
