package gameEntity.player;

import gameEntity.Card;

import java.util.ArrayList;

public abstract class Player {
    ArrayList<Card> hand = new ArrayList<>();
    int maxNumberOfCards;
    String name;
    int handStrength;

    public abstract void addCard(Card card);
    public abstract ArrayList<Card> getCards();
    public abstract void emptyHand();
    public abstract void printHand();

    public int getHandStrength() {
        return handStrength;
    }

    public void assignStrength(int value) {
        handStrength = value;
    }
}
