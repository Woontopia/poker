package handAnalyzers;

import gameEntity.Card;

import java.util.List;

public class TwoPairAnalyzer extends Analyzer{

    public TwoPairAnalyzer(Analyzer next) {
        super(next);
    }

    @Override
    public int analyzeHand(List<Card> cards) {
        return 0;
    }
}
