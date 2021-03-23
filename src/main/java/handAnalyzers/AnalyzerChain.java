package handAnalyzers;

import gameEntity.Card;

import java.util.List;

public class AnalyzerChain {
    private final Analyzer chain;

    public AnalyzerChain() {
        chain = new RoyalFlushAnalyzer(new StraighFlushAnalyzer(new FourAKindAnalyzer(new FullHouseAnalyzer(new FlushAnalyzer(new StraightAnalyzer(new ThreeAKindAnalyzer(new TwoPairAnalyzer(new OnePairAnalyzer(new HighCardAnalyzer(null))))))))));
    }

    public int getHandStrength(List<Card> cards) {
        return chain.analyzeHand(cards);
    }


}
