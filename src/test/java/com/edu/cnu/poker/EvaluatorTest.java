package com.edu.cnu.poker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by cse on 2017-04-17.
 */
public class EvaluatorTest {

    @Test
    public void SUIT가_5개가동일하면_플러쉬다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.CLUBS),
                new Card(4,Suit.CLUBS),
                new Card(8,Suit.CLUBS),
                new Card(13,Suit.CLUBS),
                new Card(2,Suit.CLUBS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("FLUSH"));
    }

    @Test
    public void 값이_같은_카드가_4장_있으면_포카드이다(){
        Evaluator evaluator=new Evaluator();
        List<Card> cardList=Arrays.asList(
                new Card(1,Suit.CLUBS),
                new Card(1,Suit.DIAMONDS),
                new Card(1,Suit.HEARTS),
                new Card(1,Suit.SPADES),
                new Card(10,Suit.DIAMONDS)
        );
        String result=evaluator.evaluate(cardList);
        assertThat(result,is("Four Card"));
    }
}