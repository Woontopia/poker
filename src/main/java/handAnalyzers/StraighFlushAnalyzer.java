package handAnalyzers;

import Checkers.StraightChecker;
import Checkers.SymbolChecker;
import gameEntity.Card;
import gameEntity.HandTypes;

import java.util.List;

public class StraighFlushAnalyzer extends Analyzer{

    private StraightChecker straightChecker;
    private SymbolChecker symbolChecker;

    public StraighFlushAnalyzer(Analyzer next) {
        super(next);
        straightChecker = new StraightChecker();
        symbolChecker = new SymbolChecker();
    }

    @Override
    public int analyzeHand(List<Card> cards) {
//        List<Card> sameSymbolCards = symbolChecker.sameSymbolCards(cards);
//        if (sameSymbolCards.size() >= 5 && straightChecker.containsStraight(sameSymbolCards, 5)) {
//            return HandTypes.STRAIGHT_FLUSH.getHandStrength();
//        }
        return nextAnalyzer.analyzeHand(cards);
    }
}
