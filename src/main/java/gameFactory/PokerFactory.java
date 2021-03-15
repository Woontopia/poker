package gameFactory;

import gameTypes.*;

public class PokerFactory {

    public PokerGame startGame(SupportedTypes type) {
        if (type == SupportedTypes.TEXASHOLDEM) {
            return new HoldEmPoker();
        }
        if (type == SupportedTypes.OMAHA) {
            return new OmahaPoker();
        }
        if (type == SupportedTypes.FIVECARD) {
            return new FiveCardPoker();
        }
        if (type == SupportedTypes.ROYAL) {
            return new RoyalPoker();
        }
        return null;
    }
}
