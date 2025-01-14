package work.icu007.day07;

import java.util.*;

// Card.java
public class CGCard implements Comparable<CGCard> {
    private String suit;
    private String rank;
    private int value;

    public CGCard(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return suit + rank;
    }

    @Override
    public int compareTo(CGCard other) {
        return this.value - other.value;
    }
}

// Player.java


/*class Player {
    private String name;
    private List<CGCard> cards;
    private boolean isLandlord;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
        this.isLandlord = false;
    }

    public void addCard(CGCard card) {
        cards.add(card);
        Collections.sort(cards);
    }

    public List<CGCard> getCards() {
        return cards;
    }

    public void setLandlord(boolean landlord) {
        this.isLandlord = landlord;
    }

    public boolean isLandlord() {
        return isLandlord;
    }

    public String getName() {
        return name;
    }

    public void showCards() {
        System.out.print(name + "的牌: ");
        for (CGCard card : cards) {
            System.out.print(card + " ");
        }
        System.out.println();
    }
}*/

// CardPattern.java
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

class PlayedCards {
    private List<CGCard> cards;
    private CardPattern pattern;
    private int weight; // 用于比较大小

    public PlayedCards(List<CGCard> cards, CardPattern pattern, int weight) {
        this.cards = cards;
        this.pattern = pattern;
        this.weight = weight;
    }

    public List<CGCard> getCards() { return cards; }
    public CardPattern getPattern() { return pattern; }
    public int getWeight() { return weight; }
}

class CardPatternHelper {
    public static PlayedCards judgePattern(List<CGCard> cards) {
        if (cards == null || cards.isEmpty()) {
            return new PlayedCards(cards, CardPattern.INVALID, 0);
        }

        // 先排序
        Collections.sort(cards);

        // 统计每个点数的张数
        Map<Integer, Integer> countMap = new HashMap<>();
        for (CGCard card : cards) {
            countMap.put(card.getValue(), countMap.getOrDefault(card.getValue(), 0) + 1);
        }

        // 判断王炸
        if (isRocket(cards)) {
            return new PlayedCards(cards, CardPattern.ROCKET, Integer.MAX_VALUE);
        }

        // 判断炸弹
        if (isBomb(cards)) {
            return new PlayedCards(cards, CardPattern.BOMB, cards.get(0).getValue() + 1000);
        }

        // 判断其他牌型
        CardPattern pattern = judgeOtherPatterns(cards, countMap);
        int weight = calculateWeight(cards, pattern);

        return new PlayedCards(cards, pattern, weight);
    }

    private static boolean isRocket(List<CGCard> cards) {
        return cards.size() == 2 &&
                cards.get(0).getValue() >= 14 &&
                cards.get(1).getValue() >= 14;
    }

    private static boolean isBomb(List<CGCard> cards) {
        return cards.size() == 4 &&
                cards.get(0).getValue() == cards.get(3).getValue();
    }

    private static CardPattern judgeOtherPatterns(List<CGCard> cards, Map<Integer, Integer> countMap) {
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

        // 顺子（至少5张）
        if (isStraight(cards, countMap)) {
            return CardPattern.STRAIGHT;
        }

        // 连对（至少3对）
        if (isStraightPair(cards, countMap)) {
            return CardPattern.STRAIGHT_PAIR;
        }

        // 飞机（三张相连）
        if (isAirplane(cards, countMap)) {
            return CardPattern.AIRPLANE;
        }

        // 四带二
        if (isFourWithTwo(cards, countMap)) {
            return CardPattern.FOUR_WITH_TWO;
        }

        return CardPattern.INVALID;
    }

    private static boolean isStraight(List<CGCard> cards, Map<Integer, Integer> countMap) {
        if (cards.size() < 5 || countMap.size() != cards.size()) {
            return false;
        }

        // 不能超过A
        if (cards.get(cards.size() - 1).getValue() >= 12) {
            return false;
        }

        // 检查是否连续
        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i).getValue() - cards.get(i-1).getValue() != 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isStraightPair(List<CGCard> cards, Map<Integer, Integer> countMap) {
        if (cards.size() < 6 || cards.size() % 2 != 0) {
            return false;
        }

        // 检查是否都是对子
        for (int count : countMap.values()) {
            if (count != 2) {
                return false;
            }
        }

        // 检查是否连续
        List<Integer> values = new ArrayList<>(countMap.keySet());
        Collections.sort(values);
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) - values.get(i-1) != 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAirplane(List<CGCard> cards, Map<Integer, Integer> countMap) {
        // 简化版飞机判断：两个连续的三张
        if (cards.size() != 6) {
            return false;
        }

        List<Integer> threes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 3) {
                threes.add(entry.getKey());
            }
        }

        if (threes.size() != 2) {
            return false;
        }

        Collections.sort(threes);
        return threes.get(1) - threes.get(0) == 1;
    }

    private static boolean isFourWithTwo(List<CGCard> cards, Map<Integer, Integer> countMap) {
        if (cards.size() != 6) {
            return false;
        }

        boolean hasFour = false;
        for (int count : countMap.values()) {
            if (count == 4) {
                hasFour = true;
                break;
            }
        }
        return hasFour;
    }

    private static int calculateWeight(List<CGCard> cards, CardPattern pattern) {
        if (cards.isEmpty()) {
            return 0;
        }

        switch (pattern) {
            case SINGLE:
            case PAIR:
            case THREE:
                return cards.get(0).getValue();
            case STRAIGHT:
            case STRAIGHT_PAIR:
                return cards.get(cards.size() - 1).getValue();
            case THREE_WITH_ONE:
            case THREE_WITH_PAIR:
                // 找到三张的那个牌的值
                Map<Integer, Integer> countMap = new HashMap<>();
                for (CGCard card : cards) {
                    countMap.put(card.getValue(), countMap.getOrDefault(card.getValue(), 0) + 1);
                }
                for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                    if (entry.getValue() == 3) {
                        return entry.getKey();
                    }
                }
            case AIRPLANE:
                // 返回最大的三张的值
                return cards.get(cards.size() - 1).getValue();
            default:
                return 0;
        }
    }

    public static boolean canBeat(PlayedCards lastPlayed, PlayedCards currentPlayed) {
        // 王炸可以打任何牌
        if (currentPlayed.getPattern() == CardPattern.ROCKET) {
            return true;
        }

        // 炸弹可以打任何非王炸的牌
        if (currentPlayed.getPattern() == CardPattern.BOMB) {
            if (lastPlayed.getPattern() == CardPattern.ROCKET) {
                return false;
            }
            if (lastPlayed.getPattern() == CardPattern.BOMB) {
                return currentPlayed.getWeight() > lastPlayed.getWeight();
            }
            return true;
        }

        // 其他牌型必须相同，且权重更大
        return currentPlayed.getPattern() == lastPlayed.getPattern() &&
                currentPlayed.getWeight() > lastPlayed.getWeight();
    }
}

// Game.java


class Game {
    private List<CGCard> deck;
    private List<CGCard> landlordCards;
    private Player player;
    private Player computer1;
    private Player computer2;
    private PlayedCards lastPlayedCards;
    private Scanner scanner;
    private Player currentPlayer;

    public Game() {
        deck = new ArrayList<>();
        landlordCards = new ArrayList<>();
        player = new Player("玩家");
        computer1 = new Player("电脑1");
        computer2 = new Player("电脑2");
        scanner = new Scanner(System.in);
        initializeDeck();
    }

    private void initializeDeck() {
        String[] suits = {"♠", "♥", "♣", "♦"};
        String[] ranks = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        // 添加普通牌
        int value = 1;
        for (String rank : ranks) {
            for (String suit : suits) {
                deck.add(new CGCard(suit, rank, value));
            }
            value++;
        }

        // 添加大小王
        deck.add(new CGCard("", "小王", value++));
        deck.add(new CGCard("", "大王", value));

        // 洗牌
        Collections.shuffle(deck);
    }

    public void start() {
        System.out.println("=== 斗地主游戏开始 ===");

        // 发牌
        dealCards();

        // 显示玩家手牌
        System.out.println("\n发牌完成！");
        player.showCards();

        // 选择地主
        chooseLandlord();

        // 游戏主循环
        gameLoop();
    }

    private void dealCards() {
        // 预留三张地主牌
        for (int i = 0; i < 3; i++) {
            landlordCards.add(deck.get(i));
        }
        System.out.println("地主牌: " + landlordCards);

        // 发牌给三个玩家
        for (int i = 3; i < deck.size(); i++) {
            if (i % 3 == 0) {
                player.addCard(deck.get(i));
            } else if (i % 3 == 1) {
                computer1.addCard(deck.get(i));
            } else {
                computer2.addCard(deck.get(i));
            }
        }
    }

    private void chooseLandlord() {
        System.out.println("\n=== 选择地主阶段 ===");
        System.out.println("是否当地主？(y/n)");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("y")) {
            player.setLandlord(true);
            currentPlayer = player;
            System.out.println("你成为地主！");

            // 把地主牌加入玩家手牌
            for (CGCard card : landlordCards) {
                player.addCard(card);
            }
        } else {
            // 随机选择一个电脑当地主
            Random random = new Random();
            if (random.nextBoolean()) {
                computer1.setLandlord(true);
                currentPlayer = computer1;
                System.out.println("电脑1成为地主！");
                for (CGCard card : landlordCards) {
                    computer1.addCard(card);
                }
            } else {
                computer2.setLandlord(true);
                currentPlayer = computer2;
                System.out.println("电脑2成为地主！");
                for (CGCard card : landlordCards) {
                    computer2.addCard(card);
                }
            }
        }

        System.out.println("\n=== 最终手牌 ===");
        player.showCards();
        computer1.showCards();
        computer2.showCards();
    }

    private void gameLoop() {
        System.out.println("\n=== 开始出牌 ===");
        Player lastPlayer = null;
        int passCount = 0;

        while (true) {
            System.out.println("\n当前回合: " + currentPlayer.getName());

            // 如果已经连续两家过牌，新的一轮开始
            if (passCount >= 2) {
                lastPlayedCards = null;
                passCount = 0;
                System.out.println("新的回合开始！");
            }

            // 根据玩家类型执行不同的出牌逻辑
            if (currentPlayer == player) {
                playerTurn();
            } else {
                computerTurn(currentPlayer);
            }

            // 检查是否有玩家出完牌
            if (checkWin(currentPlayer)) {
                announceWinner(currentPlayer);
                break;
            }

            // 更新过牌计数
            if (lastPlayedCards != null && lastPlayedCards.getCards().isEmpty()) {
                passCount++;
            } else {
                passCount = 0;
            }

            // 记录上家
            lastPlayer = currentPlayer;
            // 切换到下一个玩家
            currentPlayer = getNextPlayer(currentPlayer);
        }
    }

    private void playerTurn() {
        player.showCards();

        // 显示上家出的牌
        if (lastPlayedCards != null && !lastPlayedCards.getCards().isEmpty()) {
            System.out.println("上家出牌：" + lastPlayedCards.getCards() +
                    " (" + lastPlayedCards.getPattern() + ")");
        }

        System.out.println("请选择要出的牌（输入牌的索引，从0开始，用空格分隔，输入-1表示不出）：");

        String input = scanner.nextLine();
        if (input.equals("-1")) {
            System.out.println("玩家选择不出牌");
            lastPlayedCards = new PlayedCards(new ArrayList<>(), CardPattern.INVALID, 0);
            return;
        }

        List<CGCard> selectedCards = new ArrayList<>();
        try {
            for (String idx : input.split(" ")) {
                int index = Integer.parseInt(idx);
                if (index >= 0 && index < player.getCards().size()) {
                    selectedCards.add(player.getCards().get(index));
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("输入无效，请重新选择");
            playerTurn();
            return;
        }

        if (isValidPlay(selectedCards)) {
            PlayedCards currentPlay = CardPatternHelper.judgePattern(selectedCards);
            System.out.println("玩家出牌：" + selectedCards + " (" + currentPlay.getPattern() + ")");

            for (CGCard card : selectedCards) {
                player.getCards().remove(card);
            }
            lastPlayedCards = currentPlay;
        } else {
            System.out.println("无效的牌型或无法大过上家的牌，请重新选择");
            playerTurn();
        }
    }

    private void computerTurn(Player computer) {
        List<List<CGCard>> possiblePlays = findPossiblePlays(computer.getCards());

        // 如果是第一手牌或者新的一轮
        if (lastPlayedCards == null/* || lastPlayedCards.getCards().isEmpty()*/) {
            if (!possiblePlays.isEmpty()) {
                // 选择最小的可出牌型
                List<CGCard> cardsToPlay = possiblePlays.get(0);
                playCards(computer, cardsToPlay);
            } else {
                System.out.println(computer.getName() + "无牌可出，选择不出");
                lastPlayedCards = new PlayedCards(new ArrayList<>(), CardPattern.INVALID, 0);
            }
            return;
        }

        // 查找能大过上家的牌
        List<CGCard> bestPlay = findBestPlay(possiblePlays);
        if (bestPlay != null) {
            playCards(computer, bestPlay);
        } else {
            System.out.println(computer.getName() + "选择不出牌");
            lastPlayedCards = new PlayedCards(new ArrayList<>(), CardPattern.INVALID, 0);
        }

        computer.showCards();
    }

    private List<List<CGCard>> findPossiblePlays(List<CGCard> cards) {
        List<List<CGCard>> possiblePlays = new ArrayList<>();

        // 添加所有单牌
        for (CGCard card : cards) {
            possiblePlays.add(Collections.singletonList(card));
        }

        // 查找对子
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getValue() == cards.get(i + 1).getValue()) {
                possiblePlays.add(Arrays.asList(cards.get(i), cards.get(i + 1)));
            }
        }

        // 查找三张
        for (int i = 0; i < cards.size() - 2; i++) {
            if (cards.get(i).getValue() == cards.get(i + 1).getValue() &&
                    cards.get(i + 1).getValue() == cards.get(i + 2).getValue()) {
                possiblePlays.add(Arrays.asList(cards.get(i), cards.get(i + 1), cards.get(i + 2)));
            }
        }

        // 可以添加更多牌型的查找...

        return possiblePlays;
    }

    private List<CGCard> findBestPlay(List<List<CGCard>> possiblePlays) {
        for (List<CGCard> play : possiblePlays) {
            PlayedCards currentPlay = CardPatternHelper.judgePattern(play);
            if (lastPlayedCards != null && CardPatternHelper.canBeat(lastPlayedCards, currentPlay)) {
                return play;
            }
        }
        return null;
    }

    private void playCards(Player player, List<CGCard> cards) {
        PlayedCards currentPlay = CardPatternHelper.judgePattern(cards);
        System.out.println(player.getName() + "出牌：" + cards + " (" + currentPlay.getPattern() + ")");

        for (CGCard card : cards) {
            player.getCards().remove(card);
        }
        lastPlayedCards = currentPlay;
    }

    private boolean isValidPlay(List<CGCard> cards) {
        if (cards.isEmpty()) {
            return false;
        }

        PlayedCards currentPlay = CardPatternHelper.judgePattern(cards);

        // 如果是第一手牌，或者新的一轮（即上家选择不出），任何有效牌型都可以出
        if (lastPlayedCards == null || lastPlayedCards.getCards().isEmpty()) {
            return currentPlay.getPattern() != CardPattern.INVALID;
        }

        // 否则需要判断是否能大过上家的牌
        return CardPatternHelper.canBeat(lastPlayedCards, currentPlay);
    }

    private boolean checkWin(Player player) {
        return player.getCards().isEmpty();
    }

    private void announceWinner(Player winner) {
        System.out.println("\n=== 游戏结束 ===");
        System.out.println(winner.getName() + " 获胜！");

        // 显示所有玩家剩余的牌
        System.out.println("\n最终手牌：");
        player.showCards();
        computer1.showCards();
        computer2.showCards();
    }

    private Player getNextPlayer(Player currentPlayer) {
        if (currentPlayer == player) {
            return computer1;
        } else if (currentPlayer == computer1) {
            return computer2;
        } else {
            return player;
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
