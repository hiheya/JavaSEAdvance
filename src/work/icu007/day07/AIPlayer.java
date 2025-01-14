package work.icu007.day07;

public class AIPlayer extends Player {
    public AIPlayer(String name) {
        super(name);
    }

    // 简单的出牌逻辑：出最小的一张牌
    public Card playCard(Card lastCard) {
        /*List<Card> handCards = getHandCards();
        if (lastCard == null) {
            // 如果是首轮出牌，出最小的一张
            return playSmallestCard();
        } else {
            // 跟牌逻辑：出刚好能压过 lastCard 的最小牌
            for (Card card : handCards) {
                if (card.compareTo(lastCard) > 0) {
                    handCards.remove(card);
                    return card;
                }
            }
        }*/
        return null; // 无牌可出
    }

    private Card playSmallestCard() {
        /*List<Card> handCards = getHandCards();
        handCards.sort(Comparator.comparingInt(Card::getRankValue));
        Card smallestCard = handCards.get(0);
        handCards.remove(smallestCard);*/
        return /*smallestCard*/null;
    }
}