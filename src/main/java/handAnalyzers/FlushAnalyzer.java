package handAnalyzers;

import gameEntity.Card;

import java.util.List;

public class FlushAnalyzer extends Analyzer{

    public FlushAnalyzer(Analyzer next) {
        super(next);
    }

    @Override
    public int analyzeHand(List<Card> cards) {
        return 0;
    }
}
