import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.*;

public class PokerHandTest {

    @Test
    public void should_return_a_sorted_poker_list_in_get_method_when_create_a_poker_hand() {
        Poker poker = new Poker("AH");
        Poker poker1 = new Poker("2S");
        Poker poker2 = new Poker("3D");
        Poker poker3 = new Poker("TC");
        Poker poker4 = new Poker("8H");

        PokerHand pokerHand = new PokerHand(Arrays.asList(poker, poker1, poker2, poker3, poker4));

        assertEquals(poker1, pokerHand.getPokers().get(0));
        assertEquals(poker, pokerHand.getPokers().get(4));
    }

    @Test
    public void should_return_a_correct_map_in_get_num_size_map() {
        Poker poker = new Poker("AH");
        Poker poker1 = new Poker("2S");
        Poker poker2 = new Poker("3D");
        Poker poker3 = new Poker("TC");
        Poker poker4 = new Poker("2H");
        PokerHand pokerHand = new PokerHand(Arrays.asList(poker, poker1, poker2, poker3, poker4));

        Map<Character, Long> numSizeMap = pokerHand.getPokersNumSizeMap();
        assertTrue(numSizeMap.containsKey('A'));
        assertTrue(numSizeMap.containsKey('2'));
        assertTrue(numSizeMap.containsKey('3'));
        assertTrue(numSizeMap.containsKey('T'));
        assertEquals(Long.valueOf(2), numSizeMap.get('2'));
    }
}