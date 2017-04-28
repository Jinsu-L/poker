package com.edu.cnu.poker;

import lombok.Data;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cse on 2017-04-17.
 */
@Data
public class Evaluator {
    public Ranking evaluate(List<Card> cardList) {
        Map<Suit, Integer> suitMap = new HashMap<>();
        Map<Rank, Integer> rankMap = new HashMap<>();

        for (Card card : cardList) {
            Suit suit = card.getSuit();
            Integer count = suitMap.getOrDefault(suit, 0);
            suitMap.put(suit, count + 1);
        }

        for (Card card : cardList) {
            Rank rank = card.getRank();
            Integer count = rankMap.getOrDefault(rank, 0);
            rankMap.put(rank, count + 1);
        }

        if (rankMap.size() == 5) {
            Collections.sort(cardList);
            if (cardList.get(4).getRank().getValue() - cardList.get(0).getRank().getValue() == 4) {
                if (suitMap.size() == 1) {
                    return Ranking.STRAIGHTFLUSH;
                }
                return Ranking.STRAIGHT;
            }
            if (suitMap.size() == 1) {
                if (cardList.get(0).getRank().getValue() == 1 && cardList.get(1).getRank().getValue() == 10) {
                    return Ranking.ROYALFLUSH;
                }
                return Ranking.FLUSH;
            }
        }

        if (rankMap.size() == 4) {
            for (int value : rankMap.values()) {
                if (value == 2) {
                    return Ranking.ONEPAIR;
                }
            }
        }

        if (rankMap.size() == 3) {
            int count = 0;
            for (int value : rankMap.values()) {
                if (value == 2) {
                    count++;
                    if (count == 2) {
                        return Ranking.TWOPAIR;
                    }
                }
                if (value == 3) {
                    return Ranking.TRIPLE;
                }
            }
        }

        if (rankMap.size() == 2) {
            for (int value : rankMap.values()) {
                if (value == 4) {
                    return Ranking.FOURCARD;
                }
                return Ranking.FULLHOUSE;
            }
        }
        return Ranking.HIGHCARD;
    }
}
