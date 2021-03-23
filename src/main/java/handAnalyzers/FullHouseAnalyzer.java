package handAnalyzers;

import Checkers.ValueChecker;
import gameEntity.Card;
import gameEntity.HandTypes;

import java.util.List;

public class FullHouseAnalyzer extends Analyzer{

    private final ValueChecker valueChecker;

    public FullHouseAnalyzer(Analyzer next) {
        super(next);
        valueChecker = new ValueChecker();
    }

    @Override
    public int analyzeHand(List<Card> cards) {
        if (valueChecker.sameValueCard(cards, 3) && valueChecker.sameValueCard(cards, 2)) {
            return HandTypes.FULL_HOUSE.getHandStrength();
        }
        return nextAnalyzer.analyzeHand(cards);
    }
}
