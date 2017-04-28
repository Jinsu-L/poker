package com.edu.cnu.poker;

/**
 * Created by cse on 2017-04-17.
 */
public enum Suit {
    SPADES("Spades"),
    HEARTS("Hearts"),
    CLUBS("Clubs"),
    DIAMONDS("Diamonds");
    String name;

    Suit(String name) {
        this.name = name;
    }
}
