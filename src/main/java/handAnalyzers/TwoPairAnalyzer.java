package handAnalyzers;

import Checkers.ValueChecker;
import gameEntity.Card;
import gameEntity.HandTypes;

import java.util.List;

public class TwoPairAnalyzer extends Analyzer{

    private final ValueChecker valueChecker;

    public TwoPairAnalyzer(Analyzer next) {
        super(next);
        valueChecker = new ValueChecker();
    }

    @Override
    public int analyzeHand(List<Card> cards) {
        if (valueChecker.twoTimesSameValue(cards, 2)) {
            return HandTypes.TWO_PAIR.getHandStrength();
        }
        return nextAnalyzer.analyzeHand(cards);
    }
}
