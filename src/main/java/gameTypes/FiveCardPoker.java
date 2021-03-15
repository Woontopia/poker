package gameTypes;

public class FiveCardPoker extends PokerGame {

    public FiveCardPoker() {
        super.MAXPLAYERS = 6;
        super.MINPLAYERS = 4;
    }

    @Override
    public void play() {
        super.printNotAvailable();
    }
}
