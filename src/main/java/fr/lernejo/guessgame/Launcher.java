package fr.lernejo.guessgame;

import java.security.SecureRandom;
import java.util.Objects;

public class Launcher {
    public static void main(String[] args) {

        if (Objects.equals(args[0], "-interactive")){
            HumanPlayer player = new HumanPlayer();
            Simulation simulation = new Simulation(player);
            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextInt(100);
            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }
        else if (Objects.equals(args[0], "-auto")){
            long chosenNum = 0;
            try{
                chosenNum = Long.parseLong(args[1]);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("Usage: ./binary -interactive    OR    ./binary -auto <Number to guess>");

            }
            ComputerPlayer player = new ComputerPlayer();
            Simulation simulation = new Simulation(player);
            simulation.initialize(chosenNum);
            simulation.loopUntilPlayerSucceed(1000);
        }
        else {
            System.out.println("Usage: ./binary -interactive    OR    ./binary -auto <Number to guess>");
        }

    }
}
