package work.icu007.day07;

import java.util.Comparator;
import java.util.List;

enum CardType {
    SINGLE, PAIR, THREE, STRAIGHT, PAIR_STRAIGHT, THREE_WITH_ONE, BOMB, KING_BOMB, INVALID
}

class CardUtils {

    // 判断一组牌的类型
    public static CardType getCardType(List<Card> cards) {
        if (cards == null || cards.isEmpty()) return CardType.INVALID;

        int cardCount = cards.size();
        if (cardCount == 1) {
            return CardType.SINGLE;
        } else if (cardCount == 2 && cards.get(0).getRank().equals(cards.get(1).getRank())) {
            return CardType.PAIR;
        } else if (cardCount == 3 && cards.get(0).getRank().equals(cards.get(1).getRank()) && cards.get(1).getRank().equals(cards.get(2).getRank())) {
            return CardType.THREE;
        } else if (cardCount >= 5) {
            if (isStraight(cards)) {
                return CardType.STRAIGHT;
            } else if (isPairStraight(cards)) {
                return CardType.PAIR_STRAIGHT;
            } else if (isThreeWithOne(cards)) {
                return CardType.THREE_WITH_ONE;
            } else if (isBomb(cards)) {
                return CardType.BOMB;
            } else if (isKingBomb(cards)) {
                return CardType.KING_BOMB;
            }
        }
        return CardType.INVALID;
    }

    // 比较两组牌的大小
    public static boolean compareCards(List<Card> currentCards, List<Card> lastCards) {
        CardType currentType = getCardType(currentCards);
        CardType lastType = getCardType(lastCards);

        // 如果牌型不同，只有炸弹和王炸可以打过其他牌型
        if (currentType == CardType.BOMB && lastType != CardType.BOMB) return true;
        if (currentType == CardType.KING_BOMB) return true;
        if (currentType != lastType) return false;

        // 如果牌型相同，比较大小
        currentCards.sort(Comparator.comparingInt(Card::getRankValue));
        lastCards.sort(Comparator.comparingInt(Card::getRankValue));

        // 根据牌型比较大小
        switch (currentType) {
            case SINGLE:
            case PAIR:
            case THREE:
                return currentCards.get(0).getRankValue() > lastCards.get(0).getRankValue();
            case STRAIGHT:
            case PAIR_STRAIGHT:
                return currentCards.size() == lastCards.size() &&
                        currentCards.get(0).getRankValue() > lastCards.get(0).getRankValue();
            case THREE_WITH_ONE:
            case BOMB:
                return currentCards.get(0).getRankValue() > lastCards.get(0).getRankValue();
            default:
                return false;
        }
    }

    private static boolean isStraight(List<Card> cards) {
        cards.sort(Comparator.comparingInt(Card::getRankValue));
        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i).getRankValue() != cards.get(i - 1).getRankValue() + 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPairStraight(List<Card> cards) {
        if (cards.size() % 2 != 0) return false;
        cards.sort(Comparator.comparingInt(Card::getRankValue));
        for (int i = 0; i < cards.size(); i += 2) {
            if (!cards.get(i).getRank().equals(cards.get(i + 1).getRank())) {
                return false;
            }
            if (i > 0 && cards.get(i).getRankValue() != cards.get(i - 2).getRankValue() + 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isThreeWithOne(List<Card> cards) {
        cards.sort(Comparator.comparingInt(Card::getRankValue));
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getRank().equals(cards.get(i + 1).getRank()) && cards.get(i).getRank().equals(cards.get(i + 2).getRank())) {
                return true;
            }
        }
        return false;
    }

    private static boolean isBomb(List<Card> cards) {
        cards.sort(Comparator.comparingInt(Card::getRankValue));
        return cards.size() == 4 && cards.get(0).getRank().equals(cards.get(1).getRank()) &&
                cards.get(1).getRank().equals(cards.get(2).getRank()) &&
                cards.get(2).getRank().equals(cards.get(3).getRank());
    }

    private static boolean isKingBomb(List<Card> cards) {
        return cards.size() == 2 && cards.get(0).getRank().equals("Joker") && cards.get(1).getRank().equals("Big");
    }
}
