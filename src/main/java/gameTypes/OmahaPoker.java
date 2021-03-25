package gameTypes;

public class OmahaPoker extends PokerGame {

    public OmahaPoker() {
        super.MAXPLAYERS = 10;
        super.MINPLAYERS = 2;
    }

    @Override
    public void play() {
        super.printNotAvailable();
    }

    @Override
    public void newRound() {

    }
}
