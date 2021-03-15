package gameEntity.player;

import gameEntity.Card;

import java.util.ArrayList;

public class Human extends Player {

    public Human(int maxNumberCards, String name) {
        super.maxNumberOfCards = maxNumberCards;
        super.name = name;
    }

    @Override
    public void addCard(Card card) {
        if (hand.size() < maxNumberOfCards) {
            hand.add(card);
        }
    }

    @Override
    public ArrayList<Card> getCards() {
        return hand;
    }

    @Override
    public void emptyHand() {
        hand = new ArrayList<>();
    }

    @Override
    public void printHand() {
        System.out.println("------------------");
        System.out.println(name + " Hand");
        for (Card card: hand) {
            card.printCard();
        }
        System.out.println("------------------");
    }
}
