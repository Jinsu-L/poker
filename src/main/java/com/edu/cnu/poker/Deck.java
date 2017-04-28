package com.edu.cnu.poker;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by cse on 2017-04-17.
 */
@Data
public class Deck {

    private int numberOfDeck;
    private List<Card> cardList;

    public Deck(int numberOfDeck) {
        this.numberOfDeck = numberOfDeck;
        this.cardList = new ArrayList<>();
        createCard(numberOfDeck);
    }

    private void createCard(int numberOfDeck) {
        //card 생성
        for (int j = 0; j < numberOfDeck; j++) {
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    Card card = new Card(rank, suit);
                    cardList.add(card);
                }
            }
        }
        Collections.shuffle(cardList);
    }

    public int getTotalCard() {
        return cardList.size();
    }

    public Card drawCard() {
        if (cardList.isEmpty()) {
            throw new NoMoreCardException();
        }
        return cardList.remove(0);
    }
}
