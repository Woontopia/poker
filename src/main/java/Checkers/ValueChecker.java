package Checkers;

import gameEntity.Card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValueChecker {

    public boolean sameValueCard(List<Card> cards, int numberOfCards) {
        List<Integer> cardValues = buildListOfCardValues(cards);
        for (Card card: cards) {
            if (Collections.frequency(cardValues, card.getCardInfo().getValue0()) == numberOfCards) {
                return true;
            }
        }
        return false;
    }

    public boolean twoTimesSameValue(List<Card> cards, int numberOfCards) {
        Collections.sort(cards);
        int counter = 0;
        int firstValue = 0;
        List<Integer> cardValues = buildListOfCardValues(cards);
        for (Card card: cards) {
            if ((Collections.frequency(cardValues, card.getCardInfo().getValue0()) == numberOfCards) && (card.getCardInfo().getValue0() != firstValue)) {
                counter++;
                firstValue = card.getCardInfo().getValue0();
                if (counter == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getValueOfPair(List<Card> cards, int numberOfCards) {
        List<Integer> cardValues = buildListOfCardValues(cards);
        for (Card card: cards) {
            if (Collections.frequency(cardValues, card.getCardInfo().getValue0()) == numberOfCards) {
                return card.getCardInfo().getValue0();
            }
        }
        return 0;
    }

    private List<Integer> buildListOfCardValues(List<Card> cards) {
        List<Integer> cardValues = new ArrayList<>();
        for (Card card: cards) {
            cardValues.add(card.getCardInfo().getValue0());
        }
        Collections.sort(cardValues);
        return cardValues;
    }
}
