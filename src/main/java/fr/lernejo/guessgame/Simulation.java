package fr.lernejo.guessgame;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public boolean res;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }


    private boolean nextRound() {
        long m = player.askNextGuess();
        logger.log("Player entered " + String.format("%d",m)  + " result:");
        this.res = m == numberToGuess;
        if (m == numberToGuess){
            logger.log("Win");
            return true;
        }
        if (m < numberToGuess){
            logger.log("Greater");
            player.respond(true);
            System.out.println("Plus grand !");
        }
        if (m > numberToGuess){
            logger.log("Lower");
            player.respond(false);
            System.out.println("Plus Petit !");
        }


        return false;
    }

    public void loopUntilPlayerSucceed(long MaxLoop) {
        logger.log("New game !");
        long start = System.currentTimeMillis();
        long n = 0;
        logger.log("Chosen number: " + numberToGuess);
        while (!nextRound() && (n < MaxLoop)){
            logger.log("Round n" + n);
            n += 1;
        }
        long end = System.currentTimeMillis();
        logger.log((end - start) + " ");
    }
}
