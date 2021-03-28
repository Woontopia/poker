package utilities;

import Checkers.ValueChecker;
import gameEntity.Card;
import gameEntity.CommunityPool;
import gameEntity.player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TieSettler {

    private int bestHandStrength = 0;

    public Player settleTie(List<Player> players, CommunityPool pool) {
        return settlePairDraws(getAllPlayersInvolved(players), pool, 4);
    }

    public boolean isGameTied(List<Player> players) {
        bestHandStrength = players.get(0).getHandStrength();
        int count = 0;
        for (Player player:players) {
            if (player.getHandStrength() == bestHandStrength) {
                count++;
            }
        }
        return count >= 2;
    }

    private Player settlePairDraws(List<Player> players, CommunityPool pool, int numberOfCardsInPair) {
        ValueChecker valueChecker = new ValueChecker();
        ArrayList<Player> playerList = new ArrayList<>();
        int highestValue = getHighestCardPairValue(players, pool, numberOfCardsInPair);
        for (Player player:players) {
            if (valueChecker.getValueOfPair(combine2Lists(player.getCards(), pool.getPool()), numberOfCardsInPair) == highestValue) {
                playerList.add(player);
            }
        }
        if (playerList.size() == 1) {
            return playerList.get(0);
        }
        if (numberOfCardsInPair == 2) {
            return settleDraw(players, 0);
        }
        return settlePairDraws(playerList, pool, numberOfCardsInPair - 1);
    }

    private Player settleDraw(List<Player> players, int indexOfCard) {
        int highestCard = getXHighestCard(players, indexOfCard);
        ArrayList<Player> playerList = new ArrayList<>();
        for (Player player:players) {
            if (getCardAt(player.getCards(), indexOfCard) == highestCard) {
                playerList.add(player);
            }
        }
        if (playerList.size() == 1) {
            return playerList.get(0);
        }
        return settleDraw(playerList, indexOfCard + 1);
    }

    /**
     * Returns the highest value of a pair of X cards between all the players
     *
     * @param players
     * @param pool
     * @param numberOfCardsInPair
     * @return
     */
    private int getHighestCardPairValue(List<Player> players, CommunityPool pool, int numberOfCardsInPair) {
        ValueChecker valueChecker = new ValueChecker();
        int highestValue = 0;
        for (Player player:players) {
            int valueOfPair = valueChecker.getValueOfPair(combine2Lists(player.getCards(), pool.getPool()), numberOfCardsInPair);
            if (valueOfPair > highestValue) {
                highestValue = valueOfPair;
            }
        }
        return highestValue;
    }

    private int getXHighestCard(List<Player> players, int xHighestCard) {
        int value = 0;
        for (Player player: players) {
            int playersCard = getCardAt(player.getCards(), xHighestCard);
            if (playersCard > value) {
                value = playersCard;
            }
        }
        return value;
    }

    private int getCardAt(List<Card> cards, int indexOfCard) {
        Collections.sort(cards);
        if (indexOfCard < cards.size()) {
            return cards.get((cards.size() - 1) - indexOfCard).getCardInfo().getValue0();
        }
        return 0;
    }

    private List<Player> getAllPlayersInvolved(List<Player> players) {
        ArrayList<Player> involvedPlayers = new ArrayList<>();
        for (Player player:players) {
            if (player.getHandStrength() == bestHandStrength) {
                involvedPlayers.add(player);
            }
        }
        return  involvedPlayers;
    }

    private List<Card> combine2Lists(List<Card> listOne, List<Card> listTwo) {
        List<Card> combinedList = new ArrayList<>(listOne);
        combinedList.addAll(listTwo);
        return combinedList;
    }
}
