package otterbein.pig.player;

import otterbein.pig.engine.*;
import java.util.Random;

public class PlayerRandom implements PlayerInterface {
	
	private Random random = new Random();

    public boolean willPlay(int goalTotal, int turnTotal, int currentTotal, int opponentTotal) {
    	//Expected value of a single dice roll is 3.5
    	//Expected number of attempts with 1/6 chance of failure is 6
    	//6 * 3.5 = 21, very close to the Hold-at-20 strategy
    	//However, rolling with probability 7/8 seems to work better in practice
    	return random.nextDouble() >= (1.0 / 8.0);
    }

    public String getPlayerName() {
      return "Rando";
    }
}
