package handAnalyzers;

import gameEntity.Card;

import java.util.List;

public class StraightAnalyzer extends Analyzer{

    public StraightAnalyzer(Analyzer next) {
        super(next);
    }

    @Override
    public int analyzeHand(List<Card> cards) {
        return nextAnalyzer.analyzeHand(cards);
    }
}
