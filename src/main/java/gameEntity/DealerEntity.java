package gameEntity;

import java.util.List;

public interface DealerEntity {
    public void shuffleCards();
    public Card dealCard();
    public void newRound();
    public List<Card> flop();
    public Card turn();
    public Card river();
    public int evaluateHandStrength(List<Card> cards);
}
