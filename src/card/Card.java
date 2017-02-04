package card;

public class Card implements Comparable<Card> {
	private Suit[] suits = {Suit.SPADES, Suit.HEARTS, Suit.DIAMONDS, Suit.CLUBS, Suit.JOKER};
	protected int serial_num;
	protected Suit suit;
	protected int num;
	/*
	 * constructor
	 */
	public Card(int n) {
		this.serial_num = n;
		transform();
	}
	
	/*
	 * 決定該張撲克牌的花色與數字
	 */
	private void transform() {
		if (this.serial_num != 52)
			this.num = (this.serial_num % 13) + 1;
		else
			this.num = -1;
		
		suit = suits[this.serial_num / 13];
	}
	
	public int getNum() {
		return num;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 以文字說明方式表示撲克牌
	 */
	@Override
	public String toString() {
		return suit.toString() + String.format(" %2d", num);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 實作比較二張撲克牌的大小(排序時使用)
	 */
	@Override
	public int compareTo(Card o) {
		return this.serial_num - o.serial_num;
	}
	
	
}
