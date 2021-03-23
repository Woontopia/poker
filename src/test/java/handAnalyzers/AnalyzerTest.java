package handAnalyzers;

import gameEntity.Card;
import gameEntity.CardSymbol;
import gameEntity.Dealer;
import gameEntity.HandTypes;
import gameTypes.SupportedTypes;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AnalyzerTest {

    private Dealer dealer = new Dealer(SupportedTypes.TEXASHOLDEM);
    @Test
    public void testRoyalFlush() {
        var cards = new ArrayList<Card>();
        cards.add(new Card(1, CardSymbol.SPADE));
        cards.add(new Card(10, CardSymbol.SPADE));
        cards.add(new Card(11, CardSymbol.SPADE));
        cards.add(new Card(12, CardSymbol.SPADE));
        cards.add(new Card(13, CardSymbol.SPADE));
        cards.add(new Card(7, CardSymbol.HEART));
        cards.add(new Card(10, CardSymbol.DIAMOND));
        int strength = dealer.evaluateHandStrength(cards);
        assertEquals(HandTypes.ROYAL_FLUSH.getHandStrength(), strength);
    }

    @Test
    public void testStraightFlush() {
        var cards = new ArrayList<Card>();
        cards.add(new Card(2, CardSymbol.SPADE));
        cards.add(new Card(4, CardSymbol.SPADE));
        cards.add(new Card(5, CardSymbol.SPADE));
        cards.add(new Card(3, CardSymbol.SPADE));
        cards.add(new Card(6, CardSymbol.SPADE));
        cards.add(new Card(11, CardSymbol.HEART));
        cards.add(new Card(10, CardSymbol.DIAMOND));
        int strength = dealer.evaluateHandStrength(cards);
        assertEquals(HandTypes.STRAIGHT_FLUSH.getHandStrength(), strength);
    }

    @Test
    public void testFourAKind() {
        var cards = new ArrayList<Card>();
        cards.add(new Card(2, CardSymbol.DIAMOND));
        cards.add(new Card(2, CardSymbol.SPADE));
        cards.add(new Card(2, CardSymbol.HEART));
        cards.add(new Card(2, CardSymbol.CLUB));
        cards.add(new Card(6, CardSymbol.SPADE));
        cards.add(new Card(11, CardSymbol.HEART));
        cards.add(new Card(10, CardSymbol.DIAMOND));
        int strength = dealer.evaluateHandStrength(cards);
        assertEquals(HandTypes.FOUR_OF_A_KIND.getHandStrength(), strength);
    }

    @Test
    public void testFullHouse() {
        var cards = new ArrayList<Card>();
        cards.add(new Card(12, CardSymbol.SPADE));
        cards.add(new Card(12, CardSymbol.CLUB));
        cards.add(new Card(12, CardSymbol.DIAMOND));
        cards.add(new Card(11, CardSymbol.SPADE));
        cards.add(new Card(11, CardSymbol.HEART));
        cards.add(new Card(6, CardSymbol.SPADE));
        cards.add(new Card(10, CardSymbol.DIAMOND));
        int strength = dealer.evaluateHandStrength(cards);
        assertEquals(HandTypes.FULL_HOUSE.getHandStrength(), strength);
    }

    @Test
    public void testFlush() {
        var cards = new ArrayList<Card>();
        cards.add(new Card(2, CardSymbol.SPADE));
        cards.add(new Card(7, CardSymbol.SPADE));
        cards.add(new Card(4, CardSymbol.SPADE));
        cards.add(new Card(1, CardSymbol.SPADE));
        cards.add(new Card(6, CardSymbol.SPADE));
        cards.add(new Card(11, CardSymbol.HEART));
        cards.add(new Card(10, CardSymbol.DIAMOND));
        int strength = dealer.evaluateHandStrength(cards);
        assertEquals(HandTypes.FLUSH.getHandStrength(), strength);
    }

    @Test
    public void testStraight() {
        var cards = new ArrayList<Card>();
        cards.add(new Card(2, CardSymbol.SPADE));
        cards.add(new Card(4, CardSymbol.CLUB));
        cards.add(new Card(5, CardSymbol.HEART));
        cards.add(new Card(3, CardSymbol.SPADE));
        cards.add(new Card(6, CardSymbol.DIAMOND));
        cards.add(new Card(11, CardSymbol.HEART));
        cards.add(new Card(10, CardSymbol.DIAMOND));
        int strength = dealer.evaluateHandStrength(cards);
        assertEquals(HandTypes.STRAIGHT.getHandStrength(), strength);
    }

    @Test
    public void testThreeAKind() {
        var cards = new ArrayList<Card>();
        cards.add(new Card(5, CardSymbol.SPADE));
        cards.add(new Card(5, CardSymbol.CLUB));
        cards.add(new Card(5, CardSymbol.HEART));
        cards.add(new Card(3, CardSymbol.SPADE));
        cards.add(new Card(6, CardSymbol.DIAMOND));
        cards.add(new Card(11, CardSymbol.HEART));
        cards.add(new Card(10, CardSymbol.DIAMOND));
        int strength = dealer.evaluateHandStrength(cards);
        assertEquals(HandTypes.THREE_OF_A_KIND.getHandStrength(), strength);
    }

    @Test
    public void testTwoPair() {
        var cards = new ArrayList<Card>();
        cards.add(new Card(5, CardSymbol.SPADE));
        cards.add(new Card(5, CardSymbol.CLUB));
        cards.add(new Card(7, CardSymbol.HEART));
        cards.add(new Card(7, CardSymbol.SPADE));
        cards.add(new Card(6, CardSymbol.DIAMOND));
        cards.add(new Card(11, CardSymbol.HEART));
        cards.add(new Card(10, CardSymbol.DIAMOND));
        int strength = dealer.evaluateHandStrength(cards);
        assertEquals(HandTypes.TWO_PAIR.getHandStrength(), strength);
    }

    @Test
    public void testPair() {
        var cards = new ArrayList<Card>();
        cards.add(new Card(1, CardSymbol.SPADE));
        cards.add(new Card(1, CardSymbol.CLUB));
        cards.add(new Card(5, CardSymbol.HEART));
        cards.add(new Card(3, CardSymbol.SPADE));
        cards.add(new Card(6, CardSymbol.DIAMOND));
        cards.add(new Card(11, CardSymbol.HEART));
        cards.add(new Card(10, CardSymbol.DIAMOND));
        int strength = dealer.evaluateHandStrength(cards);
        assertEquals(HandTypes.ONE_PAIR.getHandStrength(), strength);
    }

    @Test
    public void testHighCard() {
        var cards = new ArrayList<Card>();
        cards.add(new Card(13, CardSymbol.SPADE));
        cards.add(new Card(5, CardSymbol.CLUB));
        cards.add(new Card(2, CardSymbol.HEART));
        cards.add(new Card(3, CardSymbol.SPADE));
        cards.add(new Card(6, CardSymbol.DIAMOND));
        cards.add(new Card(11, CardSymbol.HEART));
        cards.add(new Card(10, CardSymbol.DIAMOND));
        int strength = dealer.evaluateHandStrength(cards);
        assertEquals(HandTypes.HIGH_CARD.getHandStrength(), strength);
    }
}