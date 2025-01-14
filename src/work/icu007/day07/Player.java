package work.icu007.day07;

/*public class Player {
    private String name;           // 玩家名称
    private List<Card> handCards;  // 手牌

    public Player(String name) {
        this.name = name;
        this.handCards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHandCards() {
        return handCards;
    }

    public void addCard(Card card) {
        handCards.add(card);
    }

    public void removeCard(Card card) {
        handCards.remove(card);
    }

    public boolean hasNoCards() {
        return handCards.isEmpty();
    }

    @Override
    public String toString() {
        return name + "的手牌: " + handCards;
    }
}*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
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
}
