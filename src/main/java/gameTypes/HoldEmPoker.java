package gameTypes;

import gameEntity.Card;
import gameEntity.CommunityPool;
import gameEntity.Dealer;
import gameEntity.player.Player;
import utilities.TieSettler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HoldEmPoker extends PokerGame {
    private CommunityPool pool;

    public HoldEmPoker() {
        super.MAXPLAYERS = 9;
        super.MINPLAYERS = 2;
        super.playerNumberOfCards = 2;
        initialiseGame();
    }

    @Override
    public void play() {
        while (super.playing) {
            super.dealer.shuffleCards();
            dealCards();
            dealerActions();
            calculatePlayerHandStrengths();
            showCards();
            determineWinner();
            super.askForNewRound();
        }
    }

    @Override
    public void newRound() {
        pool.emptyPool();
        super.dealer.newRound();
        emptyPlayersHands();
    }

    public void determineWinner() {
        Collections.sort(super.players);
        Player winner = (super.settler.isGameTied(super.players)) ? super.settler.settleTie(super.players, pool) : super.players.get(0);
        printResult(winner);
    }

    private void calculatePlayerHandStrengths() {
        for (Player player: super.players) {
            player.assignStrength(super.dealer.evaluateHandStrength(combine2Lists(player.getCards(), pool.getPool())));
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
            for (Player player: super.players) {
                player.addCard(super.dealer.dealCard());
            }
            cardsDealt++;
        }
    }

    private void printPlayerHands() {
        for (Player player: super.players) {
            player.printHand();
        }
    }

    private void emptyPlayersHands() {
        for (Player player: super.players) {
            player.emptyHand();
        }
    }

    private void showCards() {
        pool.printPool();
        printPlayerHands();
    }

    private void dealerActions() {
        pool.addCards(super.dealer.flop());
        pool.addCard(super.dealer.turn());
        pool.addCard(super.dealer.river());
    }

    private void initialiseGame() {
        super.askNumberOfPlayers();
        pool = new CommunityPool(5);
        super.dealer = new Dealer(SupportedTypes.TEXASHOLDEM);
        super.settler = new TieSettler();
        super.addPlayers();
    }

    private void printResult(Player winner) {
        System.out.print("Winner is ");
        winner.printHandType();
        for (Player player: super.players) {
            if (player != winner) {
                player.printHandType();
            }
        }
    }

}
