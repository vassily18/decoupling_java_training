package fr.lernejo.guessgame;

public class ComputerPlayer implements Player{

    int min = 0;
    int max = 100;
    int prevGuess = 0;
    boolean resp = true;
    public long askNextGuess() {
        if (this.resp){
            this.min = prevGuess;
        }
        else{
            this.max = prevGuess;
        }
        long n = (this.min + this.max) / 2 ;
        this.prevGuess = (int) n;
        return n;
    }

    public void respond(boolean lowerOrGreater) {
        this.resp = lowerOrGreater;
    }
}
