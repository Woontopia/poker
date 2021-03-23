package Checkers;

import gameEntity.Card;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StraightChecker {

    public boolean containsStraight(List<Card> cards, int numberOfCards) {
        Collections.sort(cards);
        int longuestStart = 0;
        int longuestLength = 0;
        int currentStart = 0;
        while(currentStart < cards.size()) {
            int currentLength = 0;
            while(currentLength + currentLength < cards.size() && cards.get(currentStart).getCardInfo().getValue0() + currentLength == cards.get(currentStart + currentLength).getCardInfo().getValue0()) {
                currentLength++;
                if(currentLength > longuestLength) {
                    longuestLength = currentLength;
                    longuestStart = currentStart;
                }
                currentStart += currentLength;
            }
        }
        return longuestLength == numberOfCards;
    }
}
