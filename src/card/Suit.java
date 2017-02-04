package card;

public enum Suit {
	SPADES("黑桃"),
	HEARTS("紅心"),
	DIAMONDS("方塊"),
	CLUBS("梅花"),
	JOKER("鬼牌");
	
	private String s;
	
	private Suit(String s) {
		this.s = s;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 * 以中文表示撲克牌花色
	 */
	@Override
	public String toString() {
		return this.s;
	}
	
}
