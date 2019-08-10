import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.*;

public class PokerHandTest {

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

    @Test
    public void should_return_a_correct_map_in_get_color_size_map() {
        Poker poker = new Poker("AH");
        Poker poker1 = new Poker("2S");
        Poker poker2 = new Poker("3D");
        Poker poker3 = new Poker("TC");
        Poker poker4 = new Poker("2H");
        PokerHand pokerHand = new PokerHand(Arrays.asList(poker, poker1, poker2, poker3, poker4));

        Map<Character, Long> numSizeMap = pokerHand.getPokerColorSizeMap();
        assertTrue(numSizeMap.containsKey('H'));
        assertTrue(numSizeMap.containsKey('S'));
        assertTrue(numSizeMap.containsKey('D'));
        assertTrue(numSizeMap.containsKey('C'));
        assertEquals(Long.valueOf(2), numSizeMap.get('H'));
    }

    @Test
    public void should_get_high_card_case_given_high_card_hands_in_get_hand_case() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(AH, new Poker("2S"), KC, JH, TD));
        HandCase handCase = pokerHand.getHandCase();
        assertEquals(HandCase.HIGH_CARD, handCase);
    }

    @Test
    public void should_get_pair_case_given_pair_hands_in_get_hand_case() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(AH, AC, KC, JH, QD));
        HandCase handCase = pokerHand.getHandCase();
        assertEquals(HandCase.PAIR, handCase);
    }

    @Test
    public void should_get_tow_pairs_case_given_tow_pairs_hands_in_get_hand_case() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(AH, AC, KC, JH, JD));
        HandCase handCase = pokerHand.getHandCase();
        assertEquals(HandCase.TWO_PAIRS, handCase);
    }

    @Test
    public void should_get_three_of_a_kind_case_given_three_of_a_kind_hands_in_get_hand_case() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(AH, AC, AS, JH, KD));
        HandCase handCase = pokerHand.getHandCase();
        assertEquals(HandCase.THREE_OF_A_KIND, handCase);
    }

    @Test
    public void should_get_straight_case_given_straight_hands_in_get_hand_case() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(AH, TS, KC, JH, QD));
        HandCase handCase = pokerHand.getHandCase();
        assertEquals(HandCase.STRAIGHT, handCase);
    }

    @Test
    public void should_get_flush_case_given_flush_hands_in_get_hand_case() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(AC, AC, KC, QC, JC));
        HandCase handCase = pokerHand.getHandCase();
        assertEquals(HandCase.FLUSH, handCase);
    }

    @Test
    public void should_get_full_house_case_given_full_house_hands_in_get_hand_case() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(AH, AC, AS, JH, JD));
        HandCase handCase = pokerHand.getHandCase();
        assertEquals(HandCase.FULL_HOUSE, handCase);
    }

    @Test
    public void should_get_four_of_a_kind_case_given_four_of_a_kind_hands_in_get_hand_case() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(AH, AC, AS, AD, JD));
        HandCase handCase = pokerHand.getHandCase();
        assertEquals(HandCase.FOUR_OF_A_KIND, handCase);
    }

    @Test
    public void should_get_straight_flush_case_given_straight_flush_hands_in_get_hand_case() {
        PokerHand pokerHand = new PokerHand(Arrays.asList(AH, QH, KH, JH, TH));
        HandCase handCase = pokerHand.getHandCase();
        assertEquals(HandCase.STRAIGHT_FLUSH, handCase);
    }
}