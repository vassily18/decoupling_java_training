package fr.lernejo.guessgame;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player{
    Logger log = LoggerFactory.getLogger("player");
    java.util.Scanner scanner = new Scanner(System.in);

    public long askNextGuess() {
        System.out.print("Input Number: ");
        String inp = this.scanner.nextLine();
        return Long.parseLong(inp);
    }

    public void respond(boolean lowerOrGreater) {
    }
}
