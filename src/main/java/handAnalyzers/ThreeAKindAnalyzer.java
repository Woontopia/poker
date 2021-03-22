package handAnalyzers;

import gameEntity.Card;

import java.util.List;

public class ThreeAKindAnalyzer extends Analyzer{

    public ThreeAKindAnalyzer(Analyzer next) {
        super(next);
    }

    @Override
    public int analyzeHand(List<Card> cards) {
        return 0;
    }
}
