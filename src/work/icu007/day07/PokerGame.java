package work.icu007.day07;

import java.util.*;

public class PokerGame {

    private static Player chooseLandlord(Player[] players) {
        Random rand = new Random();
        int landlordIndex = rand.nextInt(players.length);
        return players[landlordIndex];
    }

    public static void main(String[] args) {
        // 初始化扑克牌
        List<Card> deck = createDeck();
        Collections.shuffle(deck);

        // 创建玩家
        Player humanPlayer = new Player("用户");
        AIPlayer aiPlayer1 = new AIPlayer("电脑1");
        AIPlayer aiPlayer2 = new AIPlayer("电脑2");

        // 玩家数组
        Player[] players = {humanPlayer, aiPlayer1, aiPlayer2};

        // 随机选择地主
        Player landlord = chooseLandlord(players);
        System.out.println(landlord.getName() + "是地主！");

        // 发牌
        dealCards(deck, players);

        // 游戏循环
        Card lastCard = null;
        Player currentPlayer = landlord; // 地主先出牌

        while (true) {
            System.out.println(currentPlayer.getName() + "的回合");

            if (currentPlayer instanceof AIPlayer) {
                // 电脑玩家出牌
                Card playedCard = ((AIPlayer) currentPlayer).playCard(lastCard);
                if (playedCard != null) {
                    lastCard = playedCard;
                    System.out.println(currentPlayer.getName() + "出牌: " + playedCard);
                } else {
                    System.out.println(currentPlayer.getName() + "过牌");
                }
            } else {
                // 用户玩家出牌
//                System.out.println("你的手牌: " + humanPlayer.getHandCards());
                System.out.println("请输入你想出的牌的序号 (从0开始): ");
                Scanner scanner = new Scanner(System.in);
                int index = scanner.nextInt();

//                Card playedCard = humanPlayer.getHandCards().get(index);
//                humanPlayer.removeCard(playedCard);
//                lastCard = playedCard;
//                System.out.println("你出牌: " + playedCard);
            }

            // 检查胜负
//            if (currentPlayer.hasNoCards()) {
//                System.out.println(currentPlayer.getName() + "获胜！");
//                break;
//            }

            // 切换到下一个玩家
            currentPlayer = nextPlayer(currentPlayer, players);
        }
    }

    private static List<Card> createDeck() {
        String[] suits = {"♥", "♠", "♣", "♦"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        List<Card> deck = new ArrayList<>();

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(suit, rank));
            }
        }
        deck.add(new Card("Joker", "Big"));
        deck.add(new Card("Joker", "Small"));
        return deck;
    }

    private static void dealCards(List<Card> deck, Player[] players) {
        int playerCount = players.length;
        for (int i = 0; i < deck.size(); i++) {
//            players[i % playerCount].addCard(deck.get(i));
        }
    }

    private static Player nextPlayer(Player currentPlayer, Player[] players) {
        // 玩家轮流出牌，玩家0、1、2依次轮流
        int currentIndex = Arrays.asList(players).indexOf(currentPlayer);
        int nextIndex = (currentIndex + 1) % players.length;
        return players[nextIndex];
    }
}

