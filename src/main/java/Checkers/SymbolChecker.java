package Checkers;

import gameEntity.Card;
import gameEntity.CardSymbol;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SymbolChecker {

    public List<Card> sameSymbolCards(List<Card> cards) {
        Collections.sort(cards);
        List<Card> sameSymbolCards = getCardsOfSameSymbol(cards);
        return sameSymbolCards;
    }

    private List<Card> getCardsOfSameSymbol(List<Card> cards) {
        int highestCount = 0;
        List<Card> sameSymbolCards = new ArrayList<>();
        for (CardSymbol symbol: CardSymbol.values()) {
            int count = 0;
            List<Card> currentList = new ArrayList<>();
            for (Card card: cards) {
                if (card.getCardInfo().getValue1() == symbol) {
                    currentList.add(card);
                    count++;
                }
            }
            if (count > highestCount) {
                sameSymbolCards = currentList;
                highestCount = count;
            }
        }
        return sameSymbolCards;
    }
}
