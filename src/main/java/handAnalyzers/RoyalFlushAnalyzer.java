package handAnalyzers;

import gameEntity.Card;

import java.util.List;

public class RoyalFlushAnalyzer extends Analyzer{

    public RoyalFlushAnalyzer(Analyzer next) {
        super(next);
    }

    @Override
    public int analyzeHand(List<Card> cards) {
        return 0;
    }
}
