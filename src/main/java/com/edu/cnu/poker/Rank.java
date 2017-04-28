package com.edu.cnu.poker;

/**
 * 카드의 가능한 rank들.
 */
public enum Rank {
    ACE("Ace", 1), TWO("2", 2), THREE("3", 3), FOUR("4", 4), FIVE("5", 5), SIX("6", 6), SEVEN("7", 7), EIGHT("8",
            8), NINE("9", 9), TEN("10", 10), JACK("Jack", 11), QUEEN("Queen", 12), KING("King", 13);

    private String name;
    private int value;

    Rank(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public static Rank getRankByValue(int value) {
        for (Rank rank : Rank.values()) {
            if (rank.getValue() == value)
                return rank;
        }

        throw new NoSuchRankException();
    }

}