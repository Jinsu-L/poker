package com.edu.cnu.poker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by user on 2017-04-28.
 */
public class RankTest {

    @Test
    public void 랭크6_확인() {
        assertThat(Rank.SIX.getValue(), is(6));
    }

    @Test(expected = NoSuchRankException.class)
    public void 랭크는_13이하여야한다() {
        Rank.getRankByValue(14);
    }

    @Test(expected = NoSuchRankException.class)
    public void 랭크는_1이상이여야한다() {
        Rank.getRankByValue(-1);
    }
}