package gameEntity;

import gameTypes.SupportedTypes;

import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class Deck {
    Stack<Card> deck = new Stack<>();

    public Deck(SupportedTypes gameType) {
        if (gameType == SupportedTypes.ROYAL) {
            initialiseRoyalDeck();
            return;
        }
        initialiseDeck();
    }

    private void initialiseDeck() {
        for (CardSymbol symbol: CardSymbol.values()) {
            for (int i = 1; i <= 13; i++) {
                deck.add(new Card(i, symbol));
            }
        }
    }

    private void initialiseRoyalDeck() {
        // Initialise deck only containing 10, Jack, Queen, King and Ace for Royal Hold'em Poker
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card getTopCard() {
        if (!deck.empty()) {
            return deck.pop();
        }
        return null;
    }

}
