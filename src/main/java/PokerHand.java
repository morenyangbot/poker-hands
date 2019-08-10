import java.util.Comparator;
import java.util.List;

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
}
