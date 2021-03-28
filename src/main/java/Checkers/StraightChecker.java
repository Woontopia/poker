package Checkers;

import gameEntity.Card;
import java.util.Collections;
import java.util.List;

public class StraightChecker {

    public boolean containsStraight(List<Card> cards, int numberOfCards) {
        Collections.sort(cards);
        int count = 1;
        for (int i = 0; i < cards.size(); i++) {
            if (i + 1 < cards.size()) {
                if(!sameValue(cards, i, i + 1)) {
                    count = (isConsecutive(cards, i, i + 1)) ? count + 1 : 1;
                }
            } else {
                if (cards.get(i).getCardInfo().getValue0() == 13 && cards.get(0).getCardInfo().getValue0() == 1) {
                    count++;
                }
            }
            if (count == numberOfCards) {
                return true;
            }
        }
        return false;
    }

    private boolean isConsecutive(List<Card> cards, int firstIndex, int secondIndex) {
        return cards.get(firstIndex).getCardInfo().getValue0() + 1 == cards.get(secondIndex).getCardInfo().getValue0();
    }

    private boolean sameValue(List<Card> cards, int firstIndex, int secondIndex) {
        return cards.get(firstIndex).getCardInfo().getValue0().equals(cards.get(secondIndex).getCardInfo().getValue0());
    }
}
