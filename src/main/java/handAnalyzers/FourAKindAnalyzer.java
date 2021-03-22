package handAnalyzers;

import gameEntity.Card;

import java.util.List;

public class FourAKindAnalyzer extends Analyzer{
    public FourAKindAnalyzer(Analyzer next) {
        super(next);
    }

    @Override
    public int analyzeHand(List<Card> cards) {
        return 0;
    }
}
