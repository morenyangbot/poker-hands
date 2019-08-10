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
}
