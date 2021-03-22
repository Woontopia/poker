package gameEntity;

import org.javatuples.Pair;

import java.io.PrintWriter;

public class Card implements Comparable{
    private int number;
    private CardSymbol symbol;
    PrintWriter printWriter = new PrintWriter(System.out,true);

    public Card(int number, CardSymbol symbol) {
        this.number = number;
        this.symbol = symbol;
    }

    public Pair<Integer, CardSymbol> getCardInfo() {
        return Pair.with(number, symbol);
    }

    public void printCard() {
        String cardValue = getCorrespondingSymbol();
        System.out.println("┌─────────┐");
        System.out.println("│" + cardValue + "        │");
        System.out.println("│         │");
        printWriter.println("│    " + getUnicodeSymbol() +"    │");
        System.out.println("│         │");
        System.out.println("│        " + cardValue+ "│");
        System.out.println("└─────────┘");
    }

    /**
     * Gets the unicode equivalent of the cards symbol
     *
     * @return unicode equivalent of the symbol
     */
    private char getUnicodeSymbol() {
        if (symbol == CardSymbol.CLUB) {
            return '\u2663';
        }
        if (symbol == CardSymbol.HEART) {
            return '\u2665';
        }

        if (symbol == CardSymbol.SPADE) {
            return '\u2660';
        }
        return '\u2666';
    }

    /**
     * Gets the card corresponding symbol (A, T, J, Q, K)
     *
     * @return card character in a string
     */
    private String getCorrespondingSymbol() {
        if (number == 1) {
            return "A";
        }
        if (number == 10) {
            return "T";
        }
        if (number == 11) {
            return "J";
        }
        if (number == 12) {
            return "Q";
        }
        if (number == 13) {
            return "K";
        }
        return Integer.toString(number);
    }

    @Override
    public int compareTo(Object o) {
        int compareNumber = ((Card) o).getCardInfo().getValue0();
        // For ascending order
        return this.number - compareNumber;
    }
}
