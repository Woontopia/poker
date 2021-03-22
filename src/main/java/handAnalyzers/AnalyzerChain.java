package handAnalyzers;

public class AnalyzerChain {
    private Analyzer chain;

    public AnalyzerChain() {
        chain = new RoyalFlushAnalyzer(new StraighFlushAnalyzer(new FourAKindAnalyzer(new FullHouseAnalyzer(new FlushAnalyzer(new StraightAnalyzer(new ThreeAKindAnalyzer(new TwoPairAnalyzer(new OnePairAnalyzer(new HighCardAnalyzer(null))))))))));
    }


}
