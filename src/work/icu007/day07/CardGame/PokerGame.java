package work.icu007.day07.CardGame;


import java.util.*;
import java.util.stream.Collectors;

public class PokerGame {
    private static List<Card> deck;
    private static String[] suits;
    private static String[] ranks;
    private static int value;
    private static List<Card> landlordCards;
    private static Player player;
    private static Player computerPlayer01;
    private static Player computerPlayer02;
    private static Scanner scanner;
    private static Player currentPlayer;
    private static PlayedCards lastPlayedCards;
    private static CardPattern lastCardPattern;


    public PokerGame() {
        deck = new ArrayList<>();
        suits = new String[]{"♥", "♦", "♣", "♠"};
        ranks = new String[]{"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        value = 3;
        landlordCards = new ArrayList<>();
        player = new Player("玩家");
        computerPlayer01 = new Player("电脑01");
        computerPlayer02 = new Player("电脑02");
        scanner = new Scanner(System.in);
        initializeDeck();
    }
    public static void main(String[] args) {
        PokerGame game = new PokerGame();

        game.start();

    }

    private void start() {
        System.out.println("======== 斗地主游戏开始 ========");

        dealCards();
        System.out.println("发牌完成：");
        player.showHandsCard();

        chooseLandlord();

        gameLoop();
    }

    private void gameLoop() {
        System.out.println("\n=== 开始出牌 ===");
        int passCount = 0;

        while (true) {
            System.out.println("\n当前回合：" + currentPlayer.getName());
            if (passCount >= 2) {
                lastPlayedCards = null;
                passCount = 0;
                System.out.println("新的回合开始！");
            }

            if (currentPlayer == player) {
                playerTurn();
            } else {
                computerPlayerTurn(currentPlayer);
            }

            // 检查输赢
            if (checkWin(currentPlayer)) {
                announceWinner(currentPlayer);
                break;
            }

            if (lastPlayedCards != null && lastPlayedCards.getCards().isEmpty()) {
                passCount++;
            } else {
                passCount = 0;
            }

            currentPlayer = getNextPlayer(currentPlayer);
        }
    }

    private void playerTurn() {
        player.showHandsCard();

        // 显示上家出的牌
        if (lastPlayedCards != null && !lastPlayedCards.getCards().isEmpty()) {
            System.out.println("上家出牌：" + lastPlayedCards.getCards() + lastPlayedCards.getCardPattern());
        }

        System.out.println("请选择要出的牌（输入牌的索引，从0开始，用空格分隔，输入-1表示不出）：");

        String input = scanner.nextLine();
        if (input.equals("-1")) {
            System.out.println("玩家选择不出牌");
            lastPlayedCards = new PlayedCards(new ArrayList<>(), CardPattern.INVALID, 0);
            return;
        }

        List<Card> selectedCardList = new ArrayList<>();
        try {
            for (String idx : input.split(" ")) {
                int index = Integer.parseInt(idx);
                if (index < player.getCards().size()) {
                    selectedCardList.add(player.getCards().get(index));
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("输入无效，请重新选择");
            playerTurn();
            return;
        }
        PlayedCards selectedCards = CardPatternHelper.cardListToPlayedCards(selectedCardList);
        if (isValidPlay(selectedCards)){
            System.out.println("玩家出牌：" + selectedCards.getCards() + " (" + selectedCards.getCardPattern() + ")");

            for (Card card : selectedCardList) {
                player.getCards().remove(card);
            }

            lastPlayedCards = selectedCards;
        } else {
            System.out.println("无效的牌型或无法大过上家的牌，请重新选择");
            playerTurn();
        }
    }

    private void computerPlayerTurn(Player computerPlayer) {
        System.out.println("\n" + computerPlayer.getName() + "的回合");
        computerPlayer.showHandsCard();

        // 统计手牌
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (Card card : computerPlayer.getCards()) {
            countMap.put(card.getValue(), countMap.getOrDefault(card.getValue(), 0) + 1);
        }

        List<Card> selectedCardsList = new ArrayList<>();
        Random random = new Random();

        // 如果是新的一轮（没有上家牌）
        if (lastPlayedCards == null || lastPlayedCards.getCards().isEmpty()) {
            selectedCardsList = findNewRoundCards(computerPlayer, countMap, random);
        } else {
            // 需要大过上家的牌
            selectedCardsList = findBiggerCards(computerPlayer, countMap, lastPlayedCards);
        }

        // 处理出牌结果
        if (!selectedCardsList.isEmpty()) {
            PlayedCards selectedCards = CardPatternHelper.cardListToPlayedCards(selectedCardsList);
            System.out.println(computerPlayer.getName() + "出牌：" + selectedCardsList +
                    " (" + selectedCards.getCardPattern()+ ")");

            // 移除出掉的牌
            computerPlayer.getCards().removeAll(selectedCardsList);
            lastPlayedCards = selectedCards;
        } else {
            System.out.println(computerPlayer.getName() + "选择不出");
            lastPlayedCards = new PlayedCards(new ArrayList<>(), CardPattern.INVALID, 0);
        }
    }

    // 查找新一轮可以出的牌
    private List<Card> findNewRoundCards(Player computerPlayer, HashMap<Integer, Integer> countMap, Random random) {
        List<Card> selectedCards = new ArrayList<>();
        int randomNum = random.nextInt(10);

        // 按照不同概率出不同牌型
        if (randomNum < 4) {  // 40%概率出单牌
            selectedCards = findSmallestSingle(computerPlayer, countMap);
        } else if (randomNum < 7) {  // 30%概率出对子
            selectedCards = findSmallestPair(computerPlayer, countMap);
        } else if (randomNum < 9) {  // 20%概率出三张
            selectedCards = findSmallestThree(computerPlayer, countMap);
        } else {  // 10%概率出顺子或连对
            selectedCards = findStraightOrPairs(computerPlayer, countMap);
        }

        // 如果没找到对应牌型，就出最小的单牌
        if (selectedCards.isEmpty()) {
            selectedCards = findSmallestSingle(computerPlayer, countMap);
        }

        return selectedCards;
    }

    // 查找能大过上家的牌
    private List<Card> findBiggerCards(Player computerPlayer, HashMap<Integer, Integer> countMap,
                                       PlayedCards lastPlayed) {
        List<Card> selectedCards;

        switch (lastPlayed.getCardPattern()) {
            case SINGLE:
                selectedCards = findBiggerSingle(computerPlayer, countMap, lastPlayed.getWeight());
                break;
            case PAIR:
                selectedCards = findBiggerPair(computerPlayer, countMap, lastPlayed.getWeight());
                break;
            case THREE:
                selectedCards = findBiggerThree(computerPlayer, countMap, lastPlayed.getWeight());
                break;
            case THREE_WITH_ONE:
                selectedCards = findBiggerThreeWithOne(computerPlayer, countMap, lastPlayed.getWeight());
                break;
            case THREE_WITH_PAIR:
                selectedCards = findBiggerThreeWithTwo(computerPlayer, countMap, lastPlayed.getWeight());
                break;
            case STRAIGHT:
                selectedCards = findBiggerStraight(computerPlayer, countMap, lastPlayed);
                break;
            case STRAIGHT_PAIR:
                selectedCards = findBiggerStraightPair(computerPlayer, countMap, lastPlayed);
                break;
            default:
                // 如果是其他牌型，尝试用炸弹
                selectedCards = findBomb(computerPlayer, countMap);
                break;
        }

        // 如果找不到普通牌型能大过上家，尝试使用炸弹
        if (selectedCards.isEmpty() && lastPlayed.getCardPattern() != CardPattern.BOMB &&
                lastPlayed.getCardPattern() != CardPattern.ROCKET) {
            selectedCards = findBomb(computerPlayer, countMap);
        }

        // 如果还是找不到，并且上家不是王炸，尝试使用王炸
        if (selectedCards.isEmpty() && lastPlayed.getCardPattern() != CardPattern.ROCKET) {
            selectedCards = findRocket(computerPlayer);
        }

        return selectedCards;
    }

    // 查找最小的单牌
    private List<Card> findSmallestSingle(Player computerPlayer, HashMap<Integer, Integer> countMap) {
        Optional<Card> smallestCard = computerPlayer.getCards().stream()
                .min(Card::compareTo);
        return smallestCard.map(Collections::singletonList)
                .orElse(new ArrayList<>());
    }

    // 查找能大过指定值的单牌
    private List<Card> findBiggerSingle(Player computerPlayer, HashMap<Integer, Integer> countMap,
                                        int targetWeight) {
        return computerPlayer.getCards().stream()
                .filter(card -> card.getValue() > targetWeight)
                .min(Card::compareTo)
                .map(Collections::singletonList)
                .orElse(new ArrayList<>());
    }

    // 查找最小的对子
    private List<Card> findSmallestPair(Player computerPlayer, HashMap<Integer, Integer> countMap) {
        List<Card> result = new ArrayList<>();
        Optional<Map.Entry<Integer, Integer>> smallestPair = countMap.entrySet().stream()
                .filter(entry -> entry.getValue() >= 2)
                .min(Map.Entry.comparingByKey());

        if (smallestPair.isPresent()) {
            int value = smallestPair.get().getKey();
            computerPlayer.getCards().stream()
                    .filter(card -> card.getValue() == value)
                    .limit(2)
                    .forEach(result::add);
        }
        return result;
    }

    // 查找能大过指定值的对子
    private List<Card> findBiggerPair(Player computerPlayer, HashMap<Integer, Integer> countMap,
                                      int targetWeight) {
        List<Card> result = new ArrayList<>();
        Optional<Map.Entry<Integer, Integer>> biggerPair = countMap.entrySet().stream()
                .filter(entry -> entry.getValue() >= 2 && entry.getKey() > targetWeight)
                .min(Map.Entry.comparingByKey());

        if (biggerPair.isPresent()) {
            int value = biggerPair.get().getKey();
            computerPlayer.getCards().stream()
                    .filter(card -> card.getValue() == value)
                    .limit(2)
                    .forEach(result::add);
        }
        return result;
    }
    // 查找能大过指定值的三张
    private List<Card> findBiggerThree(Player computerPlayer, HashMap<Integer, Integer> countMap,
                                      int targetWeight) {
        List<Card> result = new ArrayList<>();
        Optional<Map.Entry<Integer, Integer>> biggerThree = countMap.entrySet().stream()
                .filter(entry -> entry.getValue() >= 3 && entry.getKey() > targetWeight)
                .min(Map.Entry.comparingByKey());

        if (biggerThree.isPresent()) {
            int value = biggerThree.get().getKey();
            computerPlayer.getCards().stream()
                    .filter(card -> card.getValue() == value)
                    .limit(3)
                    .forEach(result::add);
        }
        return result;
    }

    // 查找能大过指定值的三带一
    private List<Card> findBiggerThreeWithOne(Player computerPlayer, HashMap<Integer, Integer> countMap,
                                              int targetWeight) {
        List<Card> selectedCards = new ArrayList<>();

        // 首先找到比目标值大的三张
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() >= 3 && entry.getKey() > targetWeight) {
                final int currentThreeValue = entry.getKey();

                // 添加三张相同的牌
                List<Card> threeCards = computerPlayer.getCards().stream()
                        .filter(card -> card.getValue() == currentThreeValue)
                        .limit(3)
                        .collect(Collectors.toList());
                selectedCards.addAll(threeCards);

                // 寻找单张牌（不能是已选择的三张中的牌）
                Optional<Card> single = computerPlayer.getCards().stream()
                        .filter(card -> card.getValue() != currentThreeValue)
                        .findFirst();

                // 如果找到了单张，添加进去
                if (single.isPresent()) {
                    selectedCards.add(single.get());
                    return selectedCards;  // 找到完整组合，直接返回
                } else {
                    return new ArrayList<>();  // 没找到单张，返回空列表
                }
            }
        }

        return new ArrayList<>();  // 没找到合适的三张，返回空列表
    }

    // 查找能大过指定值的三带二（任意两张牌）
    private List<Card> findBiggerThreeWithTwo(Player computerPlayer, HashMap<Integer, Integer> countMap,
                                              int targetWeight) {
        List<Card> selectedCards = new ArrayList<>();

        // 首先找到比目标值大的三张
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() >= 3 && entry.getKey() > targetWeight) {
                final int currentThreeValue = entry.getKey();

                // 添加三张相同的牌
                List<Card> threeCards = computerPlayer.getCards().stream()
                        .filter(card -> card.getValue() == currentThreeValue)
                        .limit(3)
                        .collect(Collectors.toList());
                selectedCards.addAll(threeCards);

                // 寻找任意两张不同的牌（不能是已选择的三张中的牌）
                List<Card> remainingCards = computerPlayer.getCards().stream()
                        .filter(card -> card.getValue() != currentThreeValue)
                        .collect(Collectors.toList());

                // 如果剩余牌数量大于等于2，取前两张
                if (remainingCards.size() >= 2) {
                    selectedCards.add(remainingCards.get(0));
                    selectedCards.add(remainingCards.get(1));
                    return selectedCards;  // 找到完整组合，直接返回
                } else {
                    return new ArrayList<>();  // 剩余牌不足两张，返回空列表
                }
            }
        }

        return new ArrayList<>();  // 没找到合适的三张，返回空列表
    }

    // 查找最小的三张
    private List<Card> findSmallestThree(Player computerPlayer, HashMap<Integer, Integer> countMap) {
        List<Card> result = new ArrayList<>();
        Optional<Map.Entry<Integer, Integer>> smallestThree = countMap.entrySet().stream()
                .filter(entry -> entry.getValue() >= 3)
                .min(Map.Entry.comparingByKey());

        if (smallestThree.isPresent()) {
            int value = smallestThree.get().getKey();
            computerPlayer.getCards().stream()
                    .filter(card -> card.getValue() == value)
                    .limit(3)
                    .forEach(result::add);
        }
        return result;
    }

    // 查找炸弹
    private List<Card> findBomb(Player computerPlayer, HashMap<Integer, Integer> countMap) {
        List<Card> result = new ArrayList<>();
        Optional<Map.Entry<Integer, Integer>> bomb = countMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 4)
                .min(Map.Entry.comparingByKey());

        if (bomb.isPresent()) {
            int value = bomb.get().getKey();
            computerPlayer.getCards().stream()
                    .filter(card -> card.getValue() == value)
                    .forEach(result::add);
        }
        return result;
    }

    // 查找王炸
    private List<Card> findRocket(Player computerPlayer) {
        List<Card> result = new ArrayList<>();
        List<Card> sortedCards = new ArrayList<>(computerPlayer.getCards());
        Collections.sort(sortedCards);

        if (sortedCards.size() >= 2 &&
                sortedCards.get(sortedCards.size()-1).getValue() == 17 && // 大王
                sortedCards.get(sortedCards.size()-2).getValue() == 16) { // 小王
            result.add(sortedCards.get(sortedCards.size()-2));
            result.add(sortedCards.get(sortedCards.size()-1));
        }
        return result;
    }

    // 查找顺子或连对
    private List<Card> findStraightOrPairs(Player computerPlayer, HashMap<Integer, Integer> countMap) {
        // 先尝试找顺子，如果找不到再找连对
        List<Card> straight = findStraight(computerPlayer, countMap);
        if (!straight.isEmpty()) {
            return straight;
        }

        return findConsecutivePairs(computerPlayer, countMap);
    }

    // 查找顺子
    private List<Card> findStraight(Player computerPlayer, HashMap<Integer, Integer> countMap) {
        List<Card> result = new ArrayList<>();
        List<Integer> values = new ArrayList<>(countMap.keySet());
        Collections.sort(values);

        // 寻找最长的可能顺子
        List<Integer> consecutiveValues = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            int currentValue = values.get(i);
            // 顺子不能超过A（14）
            if (currentValue >= 15) {
                continue;
            }

            if (consecutiveValues.isEmpty() ||
                    currentValue == consecutiveValues.get(consecutiveValues.size() - 1) + 1) {
                consecutiveValues.add(currentValue);
            } else {
                // 如果不连续，且已有的连续数字达到5个或以上，就可以组成顺子
                if (consecutiveValues.size() >= 5) {
                    break;
                }
                // 否则重新开始寻找
                consecutiveValues.clear();
                consecutiveValues.add(currentValue);
            }
        }

        // 如果找到至少5张连续的牌
        if (consecutiveValues.size() >= 5) {
            // 随机选择顺子长度（5到实际连续长度之间）
            Random random = new Random();
            int straightLength = random.nextInt(consecutiveValues.size() - 4) + 5;

            // 取出对应长度的顺子
            for (int i = 0; i < straightLength; i++) {
                int value = consecutiveValues.get(i);
                // 找到第一张对应点数的牌
                for (Card card : computerPlayer.getCards()) {
                    if (card.getValue() == value) {
                        result.add(card);
                        break;
                    }
                }
            }
        }

        return result;
    }

    // 查找连对
    private List<Card> findConsecutivePairs(Player computerPlayer, HashMap<Integer, Integer> countMap) {
        List<Card> result = new ArrayList<>();
        List<Integer> pairValues = new ArrayList<>();

        // 找出所有的对子
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            // 不包括2和王
            if (entry.getValue() >= 2 && entry.getKey() < 15) {
                pairValues.add(entry.getKey());
            }
        }
        Collections.sort(pairValues);

        // 寻找连续的对子
        List<Integer> consecutivePairs = new ArrayList<>();
        for (int i = 0; i < pairValues.size(); i++) {
            int currentValue = pairValues.get(i);

            if (consecutivePairs.isEmpty() ||
                    currentValue == consecutivePairs.get(consecutivePairs.size() - 1) + 1) {
                consecutivePairs.add(currentValue);
            } else {
                // 如果不连续，且已有的连续对子达到3对或以上，就可以组成连对
                if (consecutivePairs.size() >= 3) {
                    break;
                }
                // 否则重新开始寻找
                consecutivePairs.clear();
                consecutivePairs.add(currentValue);
            }
        }

        // 如果找到至少3对连续的牌
        if (consecutivePairs.size() >= 3) {
            // 随机选择连对长度（3对到实际连续长度之间）
            Random random = new Random();
            int pairLength = random.nextInt(consecutivePairs.size() - 2) + 3;

            // 取出对应长度的连对
            for (int i = 0; i < pairLength; i++) {
                int value = consecutivePairs.get(i);
                int pairCount = 0;
                // 找到两张对应点数的牌
                for (Card card : computerPlayer.getCards()) {
                    if (card.getValue() == value) {
                        result.add(card);
                        pairCount++;
                        if (pairCount == 2) {
                            break;
                        }
                    }
                }
            }
        }

        return result;
    }

    // 查找能大过指定顺子的顺子
    private List<Card> findBiggerStraight(Player computerPlayer, HashMap<Integer, Integer> countMap,
                                          PlayedCards lastPlayed) {
        List<Card> result = new ArrayList<>();
        int straightLength = lastPlayed.getCards().size();
        int minValue = lastPlayed.getWeight() + 1;  // 需要比上家顺子的最大牌大

        // 统计可用的连续单牌
        List<Integer> availableValues = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getKey() >= minValue && entry.getKey() < 15) {  // 不能超过A
                availableValues.add(entry.getKey());
            }
        }
        Collections.sort(availableValues);

        // 查找连续的值
        for (int startIdx = 0; startIdx <= availableValues.size() - straightLength; startIdx++) {
            boolean isValid = true;
            for (int i = 0; i < straightLength - 1; i++) {
                if (availableValues.get(startIdx + i + 1) != availableValues.get(startIdx + i) + 1) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                // 找到符合条件的连续值，构建顺子
                for (int i = 0; i < straightLength; i++) {
                    int value = availableValues.get(startIdx + i);
                    for (Card card : computerPlayer.getCards()) {
                        if (card.getValue() == value) {
                            result.add(card);
                            break;
                        }
                    }
                }
                break;
            }
        }

        return result;
    }

    // 查找能大过指定连对的连对
    private List<Card> findBiggerStraightPair(Player computerPlayer, HashMap<Integer, Integer> countMap,
                                              PlayedCards lastPlayed) {
        List<Card> result = new ArrayList<>();
        int pairCount = lastPlayed.getCards().size() / 2;  // 对子的数量
        int minValue = lastPlayed.getWeight() + 1;  // 需要比上家连对的最大牌大

        // 统计可用的对子
        List<Integer> pairValues = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() >= 2 && entry.getKey() >= minValue && entry.getKey() < 15) {
                pairValues.add(entry.getKey());
            }
        }
        Collections.sort(pairValues);

        // 查找连续的对子
        for (int startIdx = 0; startIdx <= pairValues.size() - pairCount; startIdx++) {
            boolean isValid = true;
            for (int i = 0; i < pairCount - 1; i++) {
                if (pairValues.get(startIdx + i + 1) != pairValues.get(startIdx + i) + 1) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                // 找到符合条件的连续对子
                for (int i = 0; i < pairCount; i++) {
                    int value = pairValues.get(startIdx + i);
                    int pairCount2 = 0;
                    for (Card card : computerPlayer.getCards()) {
                        if (card.getValue() == value) {
                            result.add(card);
                            pairCount2++;
                            if (pairCount2 == 2) {
                                break;
                            }
                        }
                    }
                }
                break;
            }
        }

        return result;
    }

    private boolean isValidPlay(PlayedCards selectedCards) {
        if (selectedCards.getCards().isEmpty()) {
            return false;
        }

        if (lastPlayedCards == null || lastPlayedCards.getCards().isEmpty()) {
            return selectedCards.getCardPattern() != CardPattern.INVALID;
        }

        return CardPatternHelper.canBeat(lastPlayedCards, selectedCards);
    }



    private boolean checkWin(Player player) {
        return player.getCards().isEmpty();
    }

    private void announceWinner(Player winner) {
        System.out.println("\n=== 游戏结束 ===");
        System.out.println(winner.getName() + " 获胜！");

        // 显示所有玩家剩余的牌
        System.out.println("\n最终手牌：");
        player.showHandsCard();
        computerPlayer01.showHandsCard();
        computerPlayer02.showHandsCard();
    }

    private Player getNextPlayer(Player currentPlayer) {
        if (currentPlayer == player) {
            return computerPlayer01;
        } else if (currentPlayer == computerPlayer01) {
            return computerPlayer02;
        } else {
            return player;
        }
    }

    private void chooseLandlord() {
        System.out.println("\n地主牌" + landlordCards);
        System.out.println("=== 选择地主阶段 ===");
        System.out.println("是否当地主？(y/n)");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            player.setLandLord(true);
            currentPlayer = player;
            System.out.println("你成为地主");
            for (Card landlordCard : landlordCards) {
                player.addCard(landlordCard);
            }
        } else {
            Random random = new Random();
            if (random.nextBoolean()) {
                computerPlayer01.setLandLord(true);
                currentPlayer = computerPlayer01;
                System.out.println("电脑01成为地主");
                for (Card landlordCard : landlordCards) {
                    computerPlayer01.addCard(landlordCard);
                }
            } else {
                computerPlayer02.setLandLord(true);
                currentPlayer = computerPlayer02;
                System.out.println("电脑02成为地主");
                for (Card landlordCard : landlordCards) {
                    computerPlayer02.addCard(landlordCard);
                }
            }
        }
        System.out.println("\n=== 最终手牌 ===");
        player.showHandsCard();
        computerPlayer01.showHandsCard();
        computerPlayer02.showHandsCard();
    }

    private void dealCards() {
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
        // 洗牌
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
    public static PlayedCards cardListToPlayedCards(List<Card> cards) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (Card card : cards) {
            countMap.put(card.getValue(), countMap.getOrDefault(card.getValue(), 0) + 1);
        }

        if (cards.isEmpty()) {
            return new PlayedCards(cards, CardPattern.INVALID, -1);
        }
        CardPattern otherCardPattern = judgePattern(cards, countMap);
        int weight = calculateWeight(cards, otherCardPattern, countMap);
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

        // 顺子
        if (isStraight(cards, countMap)) {
            return CardPattern.STRAIGHT;
        }

        // 连对
        if (isStraightPair(cards, countMap)) {
            return CardPattern.STRAIGHT_PAIR;
        }

        // 飞机
        if (isAirplane(cards, countMap)) {
            return CardPattern.AIRPLANE;
        }
        // 四带二
        if (isFourWithTwo(cards, countMap)) {
            return CardPattern.FOUR_WITH_TWO;
        }

        // 炸弹
        if (isBomb(cards, countMap)) {
            return CardPattern.BOMB;
        }

        // 王炸
        if (isRocket(cards, countMap)) {
            return CardPattern.ROCKET;
        }

        return CardPattern.INVALID;
    }

    private static boolean isStraight(List<Card> cards, HashMap<Integer, Integer> countMap) {
        if (cards.size() < 5 || countMap.size() != cards.size()) {
            return false;
        }

        // 最后一张牌不能超过A
        if (cards.get(cards.size() - 1).getValue() >= CardRank.ACE.getValue()) {
            return false;
        }

        // 判断是否连续
        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i).getValue() - cards.get(i - 1).getValue() != 1) {
                return false;
            }
        }
        // 都通过了 返回true
        return true;
    }
    private static boolean isStraightPair(List<Card> cards, HashMap<Integer, Integer> countMap) {
        if (cards.size() < 6 || cards.size() %2 != 0) {
            return false;
        }

        // 是否都是对子
        for (int value : countMap.values()) {
            if (value != 2) {
                return false;
            }
        }

        // 判断是否连续
        Set<Integer> keySet = countMap.keySet();
        ArrayList<Integer> keyList = new ArrayList<>(keySet);
        Collections.sort(keyList);
        for (int i = 1; i < keyList.size(); i++) {
            if (keyList.get(i) - keyList.get(i - 1) != 1) {
                return false;
            }
        }
        // 都通过了 返回true
        return true;
    }

    private static boolean isAirplane(List<Card> cards, Map<Integer, Integer> countMap) {
        if (cards.size() != 6 && cards.size() != 8 && cards.size() != 10) {
            return false;
        }
        // 统计出现三次牌的rank
        // 以及对子
        int twoCount = 0;
        ArrayList<Integer> threeRanks = new ArrayList<>();
        for (Map.Entry<Integer, Integer> rankEntry : countMap.entrySet()) {
            if (rankEntry.getValue() == 3) {
                threeRanks.add(rankEntry.getKey());
            } else if (rankEntry.getValue() == 2) {
                  twoCount++;
            }
        }
        if (cards.size() == 10 && twoCount != 2) {
            return false;
        }
        return threeRanks.size() == 2 && Math.abs(threeRanks.get(0) - threeRanks.get(1)) == 1;
    }

    private static boolean isFourWithTwo(List<Card> cards, Map<Integer, Integer> countMap) {
        return cards.size() == 6 && countMap.containsValue(4);
    }

    private static boolean isBomb(List<Card> cards, Map<Integer, Integer> countMap) {
        return cards.size() == 4 && countMap.size() == 1 && countMap.containsValue(4);
    }

    private static boolean isRocket(List<Card> cards, Map<Integer, Integer> countMap) {
        if (cards.size() != 2) {
            return false;
        }
        return countMap.size() == 2 &&
                countMap.containsKey(CardRank.SMALL_KING.getValue()) &&
                countMap.containsKey(CardRank.BIG_KING.getValue());
    }

    private static int calculateWeight(List<Card> cards, CardPattern cardPattern, HashMap<Integer, Integer> countMap) {
        if (cards.isEmpty()) {
            return 0;
        }
        switch (cardPattern) {
            case SINGLE, PAIR, THREE, BOMB:
                return cards.get(0).getValue();
            case STRAIGHT:
            case STRAIGHT_PAIR:
                return cards.get(cards.size() - 1).getValue();
            case THREE_WITH_ONE:
            case THREE_WITH_PAIR:
                for (Map.Entry<Integer, Integer> valueEntry : countMap.entrySet()) {
                    if (valueEntry.getValue() == 3) {
                        return valueEntry.getKey();
                    }
                }
                return -1;
            case AIRPLANE:
                int maxAirplane = -1;
                for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                    if (entry.getValue() == 3) {
                        if (entry.getKey() > maxAirplane) {
                            maxAirplane = entry.getKey();
                        }
                    }
                }
                return maxAirplane; // 如果没有找到返回 -1
            case ROCKET:
                return CardRank.BIG_KING.getValue();
            default:
                return  -1;
        }
    }

    public static boolean canBeat(PlayedCards lastCard, PlayedCards currentCard) {
        if (lastCard.getCardPattern() == CardPattern.INVALID || lastCard.getCards().isEmpty()) {
            return true;
        }
        if (currentCard.getCardPattern() == lastCard.getCardPattern() && currentCard.getCards().size() != lastCard.getCards().size()) {
            System.out.println("请确认牌数一致");
            return false;
        }
        // 王炸大任意牌型
        if (currentCard.getCardPattern() == CardPattern.ROCKET) {
            return true;
        }
        // 炸弹大除王炸外的其他牌
        if (currentCard.getCardPattern() == CardPattern.BOMB) {
            if (lastCard.getCardPattern() == CardPattern.ROCKET) return false;
            if (lastCard.getCardPattern() == CardPattern.BOMB) return currentCard.getWeight() > lastCard.getWeight();
            return true;
        }
        return lastCard.getCardPattern() == currentCard.getCardPattern() && currentCard.getWeight() > lastCard.getWeight();
    }
}