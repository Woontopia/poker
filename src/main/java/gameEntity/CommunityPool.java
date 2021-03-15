package gameEntity;

import java.util.ArrayList;
import java.util.List;

public class CommunityPool {
    private int nbCards;
    private List<Card> pool = new ArrayList<>();

    public CommunityPool(int nbCards) {
        this.nbCards = nbCards;
    }

    public void addCard(Card card) {
        if (pool.size() < nbCards) {
            pool.add(card);
            printPool();
        }
    }

    public void addCards(List<Card> cards) {
        for (Card card: cards) {
            if (pool.size() < nbCards) {
                pool.add(card);
            }
        }
        printPool();
    }

    public List<Card> getPool() {
        return pool;
    }

    public int getPoolSize() {
        return pool.size();
    }

    public void emptyPool() {
        pool = new ArrayList<>();
    }

    public void printPool() {
        System.out.println("------------------");
        System.out.println("Community Pool");
        for (Card card: pool) {
            card.printCard();
        }
        System.out.println("------------------");
    }
}
