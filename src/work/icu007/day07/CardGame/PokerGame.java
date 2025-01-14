package work.icu007.day07.CardGame;


import java.util.*;

public class PokerGame {
    /*static final int CARD_3 = 3;
    static final int CARD_4 = 4;
    static final int CARD_5 = 5;
    static final int CARD_6 = 4;
    static final int CARD_7 = 7;
    static final int CARD_8 = 8;
    static final int CARD_9 = 9;
    static final int CARD_10 = 10;
    static final int CARD_J = 11;
    static final int CARD_Q = 12;
    static final int CARD_K = 13;
    static final int CARD_A = 14;
    static final int CARD_2 = 15;
    static final int CARD_SMALL_KING = 16;
    static final int CARD_BIG_KING = 17;*/
    static List<Card> deck = new ArrayList<>();
    static String[] suits = {"♥", "♦", "♣", "♠"};
    static String[] ranks = {"3", "4", "5", "6", "7", "8", "9" , "10", "J", "Q", "K", "A", "2"};
    static int value = 3;
    static List<Card> landlordCards = new ArrayList<>();
    static Player player = new Player("玩家");
    static Player computerPlayer01 = new Player("电脑01");
    static Player computerPlayer02 = new Player("电脑02");
    public static void main(String[] args) {
        // 初始化
        initializeDeck();

        // 发牌
        dealCards();

        player.showHandsCard();
        computerPlayer01.showHandsCard();
        computerPlayer02.showHandsCard();
        System.out.println("地主牌" + landlordCards);

    }

    private static void dealCards() {
        for (int i = 0; i < 3; i++) {
            landlordCards.add(deck.get(i));
        }
        for (int i = 3; i < deck.size(); i++) {
            Card card = deck.get(i);
            if (i % 3 == 0) {
                player.addCard(card);
            } else if (i % 3 == 1) {
                computerPlayer01.addCard(card);
            } else {
                computerPlayer02.addCard(card);
            }
        }
    }

    private static void initializeDeck() {
        for (String rank : ranks) {
            for (String suit : suits) {
                deck.add(new Card(suit, rank, value));
            }
            value++;
        }
        deck.add(new Card("","小王",value++));
        deck.add(new Card("","大王",value));
        Collections.shuffle(deck);
    }
}

enum CardPattern {
    SINGLE,          // 单牌
    PAIR,           // 对子
    THREE,          // 三张
    THREE_WITH_ONE, // 三带一
    THREE_WITH_PAIR, // 三带二
    STRAIGHT,       // 顺子
    STRAIGHT_PAIR,  // 连对
    AIRPLANE,       // 飞机
    FOUR_WITH_TWO,  // 四带二
    BOMB,           // 炸弹
    ROCKET,         // 王炸
    INVALID         // 无效牌型
}

enum CardRank {
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14),
    TWO(15),
    SMALL_KING(16),
    BIG_KING(17),
    CARD_INVALID(-1);

    private final int value;

    CardRank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // 静态方法通过值查找对应的枚举常量
    public static CardRank fromValue(int value) {
        for (CardRank rank : CardRank.values()) {
            if (rank.getValue() == value) {
                return rank;
            }
        }
        return CardRank.CARD_INVALID;
    }
}

class PlayedCards {
    private List<Card> cards;
    private CardPattern cardPattern;
    // 权重
    private int weight;

    public PlayedCards(List<Card> cards, CardPattern cardPattern, int weight) {
        this.cards = cards;
        this.cardPattern = cardPattern;
        this.weight = weight;
    }

    public List<Card> getCards() {
        return cards;
    }

    public CardPattern getCardPattern() {
        return cardPattern;
    }

    public int getWeight() {
        return weight;
    }
}

class Player {
    // 玩家名字
    private String name;
    // 玩家手牌
    private List<Card> handsCard;
    // 玩家
    private boolean isLandLord;

    public Player(String name) {
        this.name = name;
        this.handsCard = new ArrayList<>();
        this.isLandLord = false;
    }

    // 添加手牌
    public void addCard(Card card) {
        handsCard.add(card);
        Collections.sort(handsCard);
    }

    public List<Card> getCards() {
        return this.handsCard;
    }

    public void setLandLord(boolean isLandLord) {
        this.isLandLord = isLandLord;
    }

    public boolean isLandLord() {
        return isLandLord;
    }

    public String getName() {
        return this.name;
    }

    public void showHandsCard() {
        System.out.println(name + "的手牌：");
        for (Card card : handsCard) {
            System.out.print(/*CardRank.fromValue(card.getValue()).getValue() +*/ card.toString() + " ");
        }
        System.out.println();
    }
}

class Card implements Comparable<Card> {
    // 花色
    private String suit;
    // 牌面
    private String rank;
    // 比较大小需要用到的value
    private int value;

    public Card(String suit,String rank ,int value ) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    @Override
    public String toString() {
        return suit + rank ;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Card o) {
        return this.value - o.value;
    }
}

class CardPatternHelper {
    public static PlayedCards judgePattern(List<Card> cards) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (Card card : cards) {
            countMap.put(card.getValue(), countMap.getOrDefault(card.getValue(), 0) + 1);
        }

        if (cards.isEmpty()) {
            return new PlayedCards(cards, CardPattern.INVALID, -1);
        }
        CardPattern otherCardPattern = judgePattern(cards, countMap);
        int weight = calculateWeight(cards, otherCardPattern);

        return new PlayedCards(cards, otherCardPattern, weight);


    }

    private static CardPattern judgePattern(List<Card> cards, HashMap<Integer, Integer> countMap) {
        // 单牌
        if (cards.size() == 1) {
            return CardPattern.SINGLE;
        }
        // 对子
        if (cards.size() == 2 && countMap.size() == 1) {
            return CardPattern.PAIR;
        }

        // 三张
        if (cards.size() == 3 && countMap.size() == 1) {
            return CardPattern.THREE;
        }

        // 三带一
        if (cards.size() == 4 && countMap.containsValue(3)) {
            return CardPattern.THREE_WITH_ONE;
        }

        // 三带二
        if (cards.size() == 5 && countMap.containsValue(3) && countMap.containsValue(2)) {
            return CardPattern.THREE_WITH_PAIR;
        }

        return CardPattern.INVALID;
    }

    private static int calculateWeight(List<Card> cards, CardPattern cardPattern) {
        return -1;
    }
}