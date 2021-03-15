package gameTypes;

import gameEntity.Card;
import gameEntity.CommunityPool;
import gameEntity.Dealer;
import gameEntity.player.Player;

import java.util.ArrayList;
import java.util.List;

public class HoldEmPoker extends PokerGame {
    private CommunityPool pool;

    public HoldEmPoker() {
        super.MAXPLAYERS = 9;
        super.MINPLAYERS = 2;
        super.playerNumberOfCards = 2;
        super.askNumberOfPlayers();
        pool = new CommunityPool(5);
        dealer = new Dealer(SupportedTypes.TEXASHOLDEM);
        super.addPlayers();
    }

    @Override
    public void play() {
        dealer.shuffleCards();
        dealCards();
        pool.addCards(dealer.flop());
        pool.addCard(dealer.turn());
        pool.addCard(dealer.river());
        // Calculate hands
        calculatePlayerHandStrengths();
        pool.printPool();
        printPlayerHands();
        // show winning player
        // playAgain?
        System.out.println("Fuck");
    }

    private void calculatePlayerHandStrengths() {
        for (Player player: players) {
            player.assignStrength(dealer.evaluateHandStrength(combine2Lists(player.getCards(), pool.getPool())));
        }
    }

    private List<Card> combine2Lists(List<Card> listOne, List<Card> listTwo) {
        List<Card> combinedList = new ArrayList<>(listOne);
        combinedList.addAll(listTwo);
        return combinedList;
    }

    private void dealCards() {
        int cardsDealt = 0;
        while(cardsDealt < playerNumberOfCards) {
            for (Player player: players) {
                player.addCard(dealer.dealCard());
            }
            cardsDealt++;
        }
    }

    private void printPlayerHands() {
        for (Player player: players) {
            player.printHand();
        }
    }

    private void newRound() {
        pool.emptyPool();
        dealer.newRound();
        emptyPlayersHands();
    }

    private void emptyPlayersHands() {
        for (Player player: players) {
            player.emptyHand();
        }
    }
}
