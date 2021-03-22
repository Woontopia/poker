package handAnalyzers;

import gameEntity.Card;

import java.util.List;

public class OnePairAnalyzer extends Analyzer{

    public OnePairAnalyzer(Analyzer next) {
        super(next);
    }

    @Override
    public int analyzeHand(List<Card> cards) {
        return 0;
    }
}
