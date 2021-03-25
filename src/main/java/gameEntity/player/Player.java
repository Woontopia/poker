package gameEntity.player;

import gameEntity.Card;
import gameEntity.HandTypes;

import java.util.ArrayList;

public abstract class Player implements Comparable{
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

    public void printHandType() {
        for (HandTypes handType: HandTypes.values()) {
            if (handStrength == handType.getHandStrength()) {
                System.out.println(name + " has " + handType);
            }
        }
    }

    @Override
    public int compareTo(Object o) {
        int compareNumber = ((Player) o).handStrength;
        return compareNumber - this.handStrength;
    }
}
