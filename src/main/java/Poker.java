public class Poker {
    private static final String ORDER = "2345689TJQKA";

    private char num;
    private char color;

    public Poker(String poker) {
        this.num = poker.charAt(0);
        this.color = poker.charAt(1);
    }

    public char getNum() {
        return num;
    }

    public char getColor() {
        return color;
    }

    public boolean isNumBiggerThan(Poker poker) {
        return ORDER.indexOf(num) > ORDER.indexOf(poker.getNum());
    }

}
