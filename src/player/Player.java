package player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import card.Card;

public class Player {
	private String name;
	private List<Card> cards = new ArrayList<Card>(); 
	/*
	 * constructor
	 */
	public Player(String name) {
		this.name = name;
	}
	/*
	 * 新增手牌給玩家
	 */
	public void addCard(Card c) {
		removeCard(c);
	}
	/*
	 * 將一樣數字的卡片丟棄
	 */
	private void removeCard(Card c) {
		int old_len = getCardAmount();
		cards = cards.stream().filter(card->card.getNum() != c.getNum()).collect(Collectors.toList());
		
		int new_len = getCardAmount();
		if (old_len == new_len) cards.add(c);
	}
	/*
	 * 秀出玩家剩餘的手牌
	 */
	public void showCards() {
		String tmp = cards.stream().sorted().map(Card::toString).collect(Collectors.joining(":", "<", ">"));
		System.out.println(name + ":" + tmp);
	}
	
	/*
	 * 抽玩家的牌
	 */
	public void drawCard(Player player, int idx) {
		this.addCard(player.getPlayerHandCards(idx));
	}
	/*
	 * 檢查鬼牌是否在該玩家手上
	 */
	public boolean isJokerHere() {
		if (cards.stream().filter(card -> (card.getNum() == -1)).collect(Collectors.toList()).size() > 0)
			return true;
		else
			return false;
	}
	/*
	 * 檢查玩家剩餘牌數
	 */
	public int getCardAmount() {
		return cards.size();
	}
	
	/*
	 * 被其他玩家抽到的牌
	 */
	public Card getPlayerHandCards(int idx) {
		Card card = this.cards.remove(idx);
		return card;
	}
}
