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
}
