package handAnalyzers;

import Checkers.StraightChecker;
import gameEntity.Card;
import gameEntity.HandTypes;

import java.util.List;

public class StraightAnalyzer extends Analyzer{

    private final StraightChecker straightChecker;

    public StraightAnalyzer(Analyzer next) {
        super(next);
        straightChecker = new StraightChecker();
    }

    @Override
    public int analyzeHand(List<Card> cards) {
        if (straightChecker.containsStraight(cards, 5)) {
            return HandTypes.STRAIGHT.getHandStrength();
        }
        return nextAnalyzer.analyzeHand(cards);
    }
}
