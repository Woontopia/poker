package handAnalyzers;

import gameEntity.Card;
import gameEntity.HandTypes;

import java.util.List;

public class HighCardAnalyzer extends Analyzer{

    public HighCardAnalyzer(Analyzer next) {
        super(next);
    }

    @Override
    public int analyzeHand(List<Card> cards) {
        return HandTypes.HIGH_CARD.getHandStrength();
    }
}
