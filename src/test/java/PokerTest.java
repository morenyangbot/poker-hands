import org.junit.Test;

import static org.junit.Assert.*;

public class PokerTest {


    @Test
    public void should_return_true_when_AH_is_bigger_then_2S() {
        Poker poker = new Poker("AH");
        Poker poker1 = new Poker("2S");

        boolean result = poker.isNumBiggerThan(poker1);

        assertTrue(result);
    }

    @Test
    public void should_return_1_when_AH_compare_num_with_2S() {
        Poker poker = new Poker("AH");
        Poker poker1 = new Poker("2S");

        int result = poker.compareByNum(poker1);

        assertEquals(1, result);
    }
}