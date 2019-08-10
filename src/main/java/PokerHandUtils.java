public class PokerHandUtils {

    public static boolean isPair(PokerHand pokerHand) {
        // 取出数字，去重，如果去重后只有四个数字则证明是pair
        final long PAIR_HAND_DISTINCT_SIZE = 4;
        return pokerHand.getPokers().stream().map(Poker::getNum).distinct().count() == PAIR_HAND_DISTINCT_SIZE;
    }

    public static boolean isTowPairs(PokerHand pokerHand) {
        final int REPEAT_TIMES = 2;
        return pokerHand.getPokers().stream().map(Poker::getNum).distinct().count() + REPEAT_TIMES == pokerHand.getPokers().size();
    }
}
