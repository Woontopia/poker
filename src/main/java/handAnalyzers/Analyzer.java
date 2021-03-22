package handAnalyzers;

import gameEntity.Card;
import gameEntity.HandTypes;

import java.util.List;

public abstract class Analyzer {

    public Analyzer nextAnalyzer;

    public Analyzer(Analyzer next) {
        nextAnalyzer = next;
    }

    public abstract int analyzeHand(List<Card> cards);
}
