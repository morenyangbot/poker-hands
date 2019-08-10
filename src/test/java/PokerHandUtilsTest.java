import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PokerHandUtilsTest {

    private final Poker TH = new Poker("TH");
    private final Poker TC = new Poker("TC");
    private final Poker TS = new Poker("TS");
    private final Poker TD = new Poker("TD");

    private final Poker JH = new Poker("JH");
    private final Poker JC = new Poker("JC");
    private final Poker JS = new Poker("JS");
    private final Poker JD = new Poker("JD");

    private final Poker QH = new Poker("QH");
    private final Poker QC = new Poker("QC");
    private final Poker QS = new Poker("QS");
    private final Poker QD = new Poker("QD");

    private final Poker KH = new Poker("KH");
    private final Poker KC = new Poker("KC");
    private final Poker KS = new Poker("KS");
    private final Poker KD = new Poker("KD");

    private final Poker AH = new Poker("AH");
    private final Poker AC = new Poker("AC");
    private final Poker AS = new Poker("AS");
    private final Poker AD = new Poker("AD");

    @Test
    public void should_return_true_when_give_a_pair_hand() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(AH, AC, KC, JH, TD));

        boolean isPair = PokerHandUtils.isPair(pokerHand);

        assertTrue(isPair);
    }

    @Test
    public void should_return_false_when_give_a_three_of_a_kind_hand_in_is_pair() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(AH, AC, AS, JH, TD));

        boolean isPair = PokerHandUtils.isPair(pokerHand);

        assertFalse(isPair);
    }

    @Test
    public void should_return_false_when_give_a_not_pair_hand() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(JH, TH, QS, KH, AD));

        boolean isPair = PokerHandUtils.isPair(pokerHand);

        assertFalse(isPair);
    }

    @Test
    public void should_return_true_when_give_a_tow_pairs_hand() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(AH, AC, KC, JH, JD));
        boolean isTowPairs = PokerHandUtils.isTowPairs(pokerHand);
        assertTrue(isTowPairs);
    }

    @Test
    public void should_return_false_when_give_a_three_of_a_kind_hand_in_is_two_pairs() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(AH, AC, AS, JH, QD));
        boolean isTowPairs = PokerHandUtils.isTowPairs(pokerHand);
        assertFalse(isTowPairs);
    }

    @Test
    public void should_return_true_when_give_a_three_of_a_kind_hand_in_is_three_of_a_kind() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(AH, AC, AS, JH, TD));

        boolean isThreeOfAKind = PokerHandUtils.isThreeOfAKind(pokerHand);

        assertTrue(isThreeOfAKind);
    }

    @Test
    public void should_return_false_when_give_a_two_pairs_hand_in_is_three_of_a_kind() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(AH, AC, JS, JH, TD));

        boolean isThreeOfAKind = PokerHandUtils.isThreeOfAKind(pokerHand);

        assertFalse(isThreeOfAKind);
    }

    @Test
    public void should_return_true_when_give_a_straight_hands_in_is_straight() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(AH, KC, JS, QD, TD));
        boolean isStraight = PokerHandUtils.isStraight(pokerHand);
        assertTrue(isStraight);
    }

    @Test
    public void should_return_false_when_give_a_straight_flush_hands_in_is_straight() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(AH, KH, JH, QH, TH));
        boolean isStraight = PokerHandUtils.isStraight(pokerHand);
        assertFalse(isStraight);
    }

    @Test
    public void should_return_true_when_give_a_flush_hands_in_is_flush() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(AH, AH, JH, QH, TH));
        boolean isFlush = PokerHandUtils.isFlush(pokerHand);
        assertTrue(isFlush);
    }

    @Test
    public void should_return_false_when_give_a_flush_hands_in_is_flush() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(AH, KH, JH, QH, TH));
        boolean isFlush = PokerHandUtils.isFlush(pokerHand);
        assertFalse(isFlush);
    }

    @Test
    public void should_return_true_when_given_a_full_house_hands_in_is_full_house() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(AH, AS, AD, QD, QH));
        boolean isFullHouse = PokerHandUtils.isFullHouse(pokerHand);
        assertTrue(isFullHouse);
    }

    @Test
    public void should_return_false_when_given_a_four_of_a_kind_hands_in_is_full_house() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(AH, AS, AD, AC, QH));
        boolean isFullHouse = PokerHandUtils.isFullHouse(pokerHand);
        assertFalse(isFullHouse);
    }

    @Test
    public void should_return_true_when_given_a_four_of_a_kind_hands_in_is_four_of_a_kind() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(AH, AS, AD, AC, QH));
        boolean isFourOfAKind = PokerHandUtils.isFourOfAKind(pokerHand);
        assertTrue(isFourOfAKind);
    }

    @Test
    public void should_return_true_when_given_a_full_house_hands_in_is_four_of_a_kind() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(AH, AS, AD, QD, QH));
        boolean isFourOfAKind = PokerHandUtils.isFourOfAKind(pokerHand);
        assertFalse(isFourOfAKind);
    }
}