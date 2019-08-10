import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PokerHandUtils {

    public static boolean isPair(PokerHand pokerHand) {
        // 取出数字，去重，如果去重后只有四个数字则证明是pair
        final long PAIR_HAND_DISTINCT_SIZE = 4;
        return pokerHand.getPokers().stream().map(Poker::getNum).distinct().count() == PAIR_HAND_DISTINCT_SIZE;
    }

    public static boolean isTowPairs(PokerHand pokerHand) {
        final long PAIR_HAND_DISTINCT_SIZE = 3;
        return pokerHand.getPokers().stream().map(Poker::getNum).distinct().count()
                == PAIR_HAND_DISTINCT_SIZE
                && pokerHand.getPokersNumSizeMap().containsValue(2L);
    }

    public static boolean isThreeOfAKind(PokerHand pokerHand) {
        final long THREE_OF_A_KIND_DISTINCT_SIZE = 3;
        return pokerHand.getPokers().stream().map(Poker::getNum).distinct().count()
                == THREE_OF_A_KIND_DISTINCT_SIZE
                && pokerHand.getPokersNumSizeMap().containsValue(3L);
    }

    protected static boolean isNumStraight(PokerHand pokerHand) {
        List<Integer> numIndexList = pokerHand.getPokers().stream().map(Poker::getNum).mapToInt(Poker.ORDER::indexOf).boxed().collect(Collectors.toList());
        int maxOffset = 0;
        for (int i = 1; i < numIndexList.size(); i++) {
            int offset = numIndexList.get(i) - numIndexList.get(i - 1);
            maxOffset = Math.max(offset, maxOffset);
        }

        return maxOffset == 1;
    }

    public static boolean isStraight(PokerHand pokerHand) {
        return isNumStraight(pokerHand) && pokerHand.getPokerColorSizeMap().size() > 1;
    }

    public static boolean isFlush(PokerHand pokerHand) {
        return pokerHand.getPokerColorSizeMap().size() == 1;
    }
}
