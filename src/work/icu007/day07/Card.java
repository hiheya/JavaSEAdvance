package work.icu007.day07;

class Card implements Comparable<Card> {
    private final String suit;  // 花色
    private final String rank;  // 点数

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getRankValue() {
        return switch (rank) {
            case "2" -> 2;
            case "3" -> 3;
            case "4" -> 4;
            case "5" -> 5;
            case "6" -> 6;
            case "7" -> 7;
            case "8" -> 8;
            case "9" -> 9;
            case "10" -> 10;
            case "J" -> 11;
            case "Q" -> 12;
            case "K" -> 13;
            case "A" -> 14;
            case "Joker" -> 15;
            case "Big" -> 16;
            default -> 0;
        };
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.getRankValue(), other.getRankValue());
    }

    @Override
    public String toString() {
        return rank + suit;
    }
}