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
    public void 아무런_조합도_가능하지_않을경우_하이카드이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(8, Suit.DIAMONDS),
                new Card(5, Suit.HEARTS),
                new Card(2, Suit.SPADES),
                new Card(13, Suit.DIAMONDS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is(Ranking.HIGHCARD));
    }

    @Test
    public void 값이_같은_2장의_카드는_원페어이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(1, Suit.DIAMONDS),
                new Card(5, Suit.HEARTS),
                new Card(8, Suit.SPADES),
                new Card(10, Suit.DIAMONDS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is(Ranking.ONEPAIR));
    }

    @Test
    public void 페어가_2개이면_투페어이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(1, Suit.DIAMONDS),
                new Card(3, Suit.HEARTS),
                new Card(3, Suit.SPADES),
                new Card(10, Suit.DIAMONDS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is(Ranking.TWOPAIR));
    }

    @Test
    public void 값이_같은_카드가_3장이_있으면_트리플이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(1, Suit.DIAMONDS),
                new Card(1, Suit.HEARTS),
                new Card(5, Suit.SPADES),
                new Card(10, Suit.DIAMONDS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is(Ranking.TRIPLE));
    }

    @Test
    public void 섞인_짝패의_카드가_5장_연속되면_스트레이트이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(3, Suit.CLUBS),
                new Card(4, Suit.DIAMONDS),
                new Card(5, Suit.HEARTS),
                new Card(6, Suit.SPADES),
                new Card(7, Suit.DIAMONDS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is(Ranking.STRAIGHT));
    }

    @Test
    public void SUIT가_5개가동일하면_플러쉬다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(4, Suit.CLUBS),
                new Card(8, Suit.CLUBS),
                new Card(13, Suit.CLUBS),
                new Card(2, Suit.CLUBS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is(Ranking.FLUSH));
    }

    @Test
    public void 트리플과_페어가_있으면_풀하우스이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(1, Suit.DIAMONDS),
                new Card(1, Suit.HEARTS),
                new Card(10, Suit.SPADES),
                new Card(10, Suit.DIAMONDS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is(Ranking.FULLHOUSE));
    }

    @Test
    public void 값이_같은_카드가_4장_있으면_포카드이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(1, Suit.DIAMONDS),
                new Card(1, Suit.HEARTS),
                new Card(1, Suit.SPADES),
                new Card(10, Suit.DIAMONDS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is(Ranking.FOURCARD));
    }

    @Test
    public void 스트레이트가_같은_짝패이면_스트레이트플러시이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(5, Suit.CLUBS),
                new Card(6, Suit.CLUBS),
                new Card(7, Suit.CLUBS),
                new Card(8, Suit.CLUBS),
                new Card(9, Suit.CLUBS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is(Ranking.STRAIGHTFLUSH));
    }

    @Test
    public void 스트레이트_플러쉬가_10부터_에이스까지_연속이면_로얄플러시이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(10, Suit.CLUBS),
                new Card(11, Suit.CLUBS),
                new Card(12, Suit.CLUBS),
                new Card(13, Suit.CLUBS),
                new Card(1, Suit.CLUBS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is(Ranking.ROYALFLUSH));
    }


}