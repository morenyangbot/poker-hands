import java.util.*;

public class PokerHand {
    private List<Poker> pokers;

    public PokerHand(List<Poker> pokers) {
        this.pokers = pokers;
        sort();
    }

    public List<Poker> getPokers() {
        return pokers;
    }

    private void sort() {
        this.pokers.sort(Poker::compareByNum);
    }

    public Map<Character, Long> getPokersNumSizeMap() {
        Map<Character, Long> pokersNumSizeMap = new TreeMap<Character, Long>();
        for (Poker poker :
                pokers) {
            char key = poker.getNum();
            Long size = pokersNumSizeMap.get(key);
            if (size != null) {
                pokersNumSizeMap.put(key, size + 1);
            } else {
                pokersNumSizeMap.put(key, (long) 1);
            }
        }
        return pokersNumSizeMap;
    }

    public Map<Character, Long> getPokerColorSizeMap() {
        Map<Character, Long> pokerColorSizeMap = new TreeMap<>();
        for (Poker poker :
                pokers) {
            char key = poker.getColor();
            Long size = pokerColorSizeMap.get(key);
            if (size != null) {
                pokerColorSizeMap.put(key, size + 1);
            } else {
                pokerColorSizeMap.put(key, (long) 1);
            }
        }
        return pokerColorSizeMap;
    }

    public HandCase getHandCase() {
        if (PokerHandUtils.isStraightFlush(this)) {
            return HandCase.STRAIGHT_FLUSH;
        }
        if (PokerHandUtils.isFourOfAKind(this)) {
            return HandCase.FOUR_OF_A_KIND;
        }
        if (PokerHandUtils.isFullHouse(this)) {
            return HandCase.FULL_HOUSE;
        }
        if (PokerHandUtils.isFlush(this)) {
            return HandCase.FLUSH;
        }
        if (PokerHandUtils.isStraight(this)) {
            return HandCase.STRAIGHT;
        }
        if (PokerHandUtils.isThreeOfAKind(this)) {
            return HandCase.THREE_OF_A_KIND;
        }
        if (PokerHandUtils.isTowPairs(this)) {
            return HandCase.TWO_PAIRS;
        }
        if (PokerHandUtils.isPair(this)) {
            return HandCase.PAIR;
        }
        return HandCase.HIGH_CARD;
    }

    public Poker getHighestPoker() {
        return pokers.get(pokers.size() - 1);
    }

    public Poker getHighestPokerInCase() {
        switch (getHandCase()) {
            case PAIR:
            case THREE_OF_A_KIND:
            case FOUR_OF_A_KIND:
            case TWO_PAIRS:
            case FULL_HOUSE:
                return getHighestPokerOfMostPokerSet();
            case HIGH_CARD:
            case STRAIGHT:
            case FLUSH:
            case STRAIGHT_FLUSH:
            default:
                return getHighestPoker();
        }
    }

    private Poker getHighestPokerOfMostPokerSet() {
        long maxCount = getPokersNumSizeMap().values().stream().mapToLong(Long::longValue).max().orElse(0);
        char maxCountNum = '2';
        for (char key : getPokersNumSizeMap().keySet()) {
            if (maxCount == getPokersNumSizeMap().get(key)) {
                maxCountNum = key;
            }
        }
        char finalMaxCountNum = maxCountNum;
        return pokers.stream().filter(poker -> poker.getNum() == finalMaxCountNum).findAny().orElse(null);
    }

    public CompareResult compareWin(PokerHand pokerHand) {
        if (getHandCase().getCode() > pokerHand.getHandCase().getCode()) {
            return CompareResult.WIN;
        } else if (getHandCase().getCode() < pokerHand.getHandCase().getCode()) {
            return CompareResult.LOSE;
        }
        CompareResult caseHighestCardCompareResult = getHighestPokerInCase().compareWin(pokerHand.getHighestPokerInCase());
        if (caseHighestCardCompareResult != CompareResult.DRAW) {
            return caseHighestCardCompareResult;
        }
        return getHighestPoker().compareWin(pokerHand.getHighestPoker());
    }
}
