package handAnalyzers;

import Checkers.ValueChecker;
import gameEntity.Card;
import gameEntity.HandTypes;

import java.util.List;

public class OnePairAnalyzer extends Analyzer{

    private final ValueChecker valueChecker;

    public OnePairAnalyzer(Analyzer next) {
        super(next);
        valueChecker = new ValueChecker();
    }

    @Override
    public int analyzeHand(List<Card> cards) {
        if (valueChecker.sameValueCard(cards, 2)) {
            return HandTypes.ONE_PAIR.getHandStrength();
        }
        return nextAnalyzer.analyzeHand(cards);
    }
}
