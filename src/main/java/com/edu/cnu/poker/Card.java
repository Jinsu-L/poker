package com.edu.cnu.poker;

import lombok.Data;

/**
 * Created by cse on 2017-04-17.
 */
@Data
public class Card implements Comparable<Card> {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Card(int value, Suit suit) {
        this.rank = Rank.getRankByValue(value);
        this.suit = suit;
    }


    public int compareTo(Card o) {
        return this.rank.getValue() - o.rank.getValue();
    }
}
