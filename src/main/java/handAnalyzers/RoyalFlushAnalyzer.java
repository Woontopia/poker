package handAnalyzers;

import Checkers.SymbolChecker;
import gameEntity.Card;
import gameEntity.HandTypes;

import java.util.List;

public class RoyalFlushAnalyzer extends Analyzer{

    private final SymbolChecker symbolChecker;

    public RoyalFlushAnalyzer(Analyzer next) {
        super(next);
        symbolChecker = new SymbolChecker();
    }

    @Override
    public int analyzeHand(List<Card> cards) {
        List<Card> sameSymbolCards = symbolChecker.sameSymbolCards(cards);
        if (sameSymbolCards.size() >= 5 && checkForRoyalFlushCards(cards)) {
            return HandTypes.ROYAL_FLUSH.getHandStrength();
        }
        return nextAnalyzer.analyzeHand(cards);
    }

    private boolean checkForRoyalFlushCards(List<Card> cards) {
        return containsCard(cards, 1) && containsCard(cards, 10) && containsCard(cards, 11) && containsCard(cards, 12) && containsCard(cards, 13);
    }

    private boolean containsCard(List<Card> cards, int valueToCheck) {
        for (Card card: cards) {
            if (card.getCardInfo().getValue0() == valueToCheck) {
                return true;
            }
        }
        return false;
    }
}
