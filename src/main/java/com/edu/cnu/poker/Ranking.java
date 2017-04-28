package com.edu.cnu.poker;

/**
 * Created by J1N2U on 2017-04-22.
 */
public enum Ranking {
    HIGHCARD("HIGH CARD"),
    ONEPAIR("ONE PAIR"),
    TWOPAIR("TWO PAIR"),
    TRIPLE("TRIPLE"),
    STRAIGHT("STRAIGHT"),
    FLUSH("FLUSH"),
    FULLHOUSE("FULLHOUSE"),
    FOURCARD("FOURCARD"),
    STRAIGHTFLUSH("STRAIGHTFLUSH"),
    ROYALFLUSH("ROYALFLUSH");

    private String name;

    Ranking(String name) {
        this.name = name;
    }

}
