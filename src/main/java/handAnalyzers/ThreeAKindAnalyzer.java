package handAnalyzers;

import Checkers.ValueChecker;
import gameEntity.Card;
import gameEntity.HandTypes;

import java.util.List;

public class ThreeAKindAnalyzer extends Analyzer{

    private final ValueChecker valueChecker;

    public ThreeAKindAnalyzer(Analyzer next) {
        super(next);
        valueChecker = new ValueChecker();
    }

    @Override
    public int analyzeHand(List<Card> cards) {
        if (valueChecker.sameValueCard(cards, 3)) {
            return HandTypes.THREE_OF_A_KIND.getHandStrength();
        }
        return nextAnalyzer.analyzeHand(cards);
    }
}
