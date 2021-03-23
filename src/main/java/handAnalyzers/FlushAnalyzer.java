package handAnalyzers;

import Checkers.SymbolChecker;
import gameEntity.Card;
import gameEntity.HandTypes;

import java.util.List;

public class FlushAnalyzer extends Analyzer{

    private final SymbolChecker symbolChecker;

    public FlushAnalyzer(Analyzer next) {
        super(next);
        symbolChecker = new SymbolChecker();
    }

    @Override
    public int analyzeHand(List<Card> cards) {
        if (symbolChecker.sameSymbolCards(cards).size() >= 5) {
            return HandTypes.FLUSH.getHandStrength();
        }
        return nextAnalyzer.analyzeHand(cards);
    }
}
