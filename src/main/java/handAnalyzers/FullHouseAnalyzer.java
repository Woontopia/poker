package handAnalyzers;

import gameEntity.Card;

import java.util.List;

public class FullHouseAnalyzer extends Analyzer{

    public FullHouseAnalyzer(Analyzer next) {
        super(next);
    }

    @Override
    public int analyzeHand(List<Card> cards) {
        return 0;
    }
}
