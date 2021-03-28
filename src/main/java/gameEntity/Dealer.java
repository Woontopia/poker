package gameEntity;

import gameEntity.player.Player;
import gameTypes.SupportedTypes;
import handAnalyzers.Analyzer;
import handAnalyzers.AnalyzerChain;
import utilities.TieSettler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealer {
    private Deck deck;
    private SupportedTypes gameType;

    public Dealer(SupportedTypes pokerType) {
        gameType = pokerType;
        newRound();
    }

    public void newRound() {
        deck = new Deck(gameType);
    }

    public void shuffleCards() {
        deck.shuffle();
    }

    public Card dealCard() {
        return deck.getTopCard();
    }

    public List<Card> flop() {
        System.out.println("Dealer yells FLOP!");
        ArrayList<Card> flop = new ArrayList<>();
        flop.add(showCard());
        flop.add(showCard());
        flop.add(showCard());
        return flop;
    }

    public Card turn() {
        System.out.println("Dealer yells TURN!");
        return showCard();
    }

    public Card river() {
        System.out.println("Dealer yells RIVER!");
        return showCard();
    }

    public int evaluateHandStrength(List<Card> cards) {
        return new AnalyzerChain().getHandStrength(cards);
    }

    private Card showCard() {
        burnCard();
        return deck.getTopCard();
    }

    private void burnCard() {
        deck.getTopCard();
    }
}
