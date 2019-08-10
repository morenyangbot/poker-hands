import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PokerHandUtilsTest {

    private final Poker TH = new Poker("TD");
    private final Poker TC = new Poker("TD");
    private final Poker TS = new Poker("TD");
    private final Poker TD = new Poker("TD");

    private final Poker JH = new Poker("JD");
    private final Poker JC = new Poker("JD");
    private final Poker JS = new Poker("JD");
    private final Poker JD = new Poker("JD");

    private final Poker QH = new Poker("QD");
    private final Poker QC = new Poker("QD");
    private final Poker QS = new Poker("QD");
    private final Poker QD = new Poker("QD");

    private final Poker KH = new Poker("KD");
    private final Poker KC = new Poker("KD");
    private final Poker KS = new Poker("KD");
    private final Poker KD = new Poker("KD");

    private final Poker AH = new Poker("AH");
    private final Poker AC = new Poker("AC");
    private final Poker AS = new Poker("AS");
    private final Poker AD = new Poker("AD");

    @Test
    public void should_return_true_when_give_a_pair_hand() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(AH, AC, AS, JH, TD));

        boolean isPair = PokerHandUtils.isPair(pokerHand);

        assertTrue(isPair);
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
}