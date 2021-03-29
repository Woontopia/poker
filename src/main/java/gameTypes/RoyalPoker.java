package gameTypes;

public class RoyalPoker extends PokerGame {
    public RoyalPoker() {
        super.MAXPLAYERS = 7;
        super.MINPLAYERS = 3;
    }

    @Override
    public void play() {
        super.printNotAvailable();
    }

    @Override
    public void newRound() {

    }

    @Override
    public void dealCards() {

    }

    @Override
    public void printPlayerHands() {

    }
}
