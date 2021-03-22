package Checkers;

import gameEntity.Card;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ValueChecker {

    public boolean sameValueCard(List<Card> cards, int numberOfOccurrences) {
        for (Card card: cards) {
            if (Collections.frequency(cards, card.getCardInfo().getValue0()) == numberOfOccurrences) {
                return true;
            }
        }
        return false;
    }
}
