package Checkers;

import gameEntity.Card;
import gameEntity.CardSymbol;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SymbolChecker {

    public boolean sameSymbol(List<Card> cards, int numberOfOccurrences) {
        Collections.sort(cards);
        return getHighestCountOfSymbolOccurrence(cards) == numberOfOccurrences;
    }

    private int getHighestCountOfSymbolOccurrence(List<Card> cards) {
        int highestCount = 0;
        for (CardSymbol symbol: CardSymbol.values()) {
            int count = 0;
            for (Card card: cards) {
                if (card.getCardInfo().getValue1() == symbol) {
                    count++;
                }
            }
            if (count > highestCount) {
                highestCount = count;
            }
        }
        return highestCount;
    }
}
