package handAnalyzers;

import gameEntity.Card;

import java.util.List;

public class StraighFlushAnalyzer extends Analyzer{

    public StraighFlushAnalyzer(Analyzer next) {
        super(next);
    }

    @Override
    public int analyzeHand(List<Card> cards) {
        return 0;
    }
}
