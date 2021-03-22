package Checkers;

import gameEntity.Card;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StraightChecker {

    public void straight(List<Card> cards, int numberOfTimes) {
        Collections.sort(cards);
        for(int i = 0; i < cards.size(); i++) {
            int startingIndex = i;
            //Loop next five cards if possible
            if (cards.get(i).getCardInfo().getValue0() + 1 == cards.get(i).getCardInfo().getValue0()) {

            }
//            if (i + 1 == cards.size()) {
//
//            } else {
//                if (cards.get(i).getCardInfo().getValue0() + 1 == cards.get(i).getCardInfo().getValue0()) {
//
//                }
//            }
        }
    }

    public boolean isConsecutive(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i + 1) != list.get(i)) {
                return false;
            }
        }
        return true;
    }
}
