public class PokerHandUtils {

    public static boolean isPair(PokerHand pokerHand) {
        // 取出数字，去重，如果比原来的小则证明一定有重复的
        return pokerHand.getPokers().stream().map(Poker::getNum).distinct().count() < pokerHand.getPokers().size();
    }

    public static boolean isTowPairs(PokerHand pokerHand) {
        final int REPEAT_TIMES = 2;
        return pokerHand.getPokers().stream().map(Poker::getNum).distinct().count() + REPEAT_TIMES == pokerHand.getPokers().size();
    }
}
