import java.util.stream.IntStream;

import card.Card;
import player.Player;

public class Test {

	public static void main(String[] args) {
		Player[] players;
		int[] handcards;
		
		Player p1 = new Player("Alice");
		Player p2 = new Player("Brown");
		Player p3 = new Player("Chloe");
		Player p4 = new Player("Daisy");
		
		Card[] poker = new Card[53];
		IntStream.range(0, 53).forEach(i -> poker[i] = new Card(i));
		
		IntStream.range(0, 53).forEach(i -> {
			int random = (int)(Math.random()*53);
			
			Card c = poker[i];
			poker[i] = poker[random];
			poker[random] = c;
		});

		IntStream.range(0, 53).forEach(i -> {
			if (i % 4 == 0) p1.addCard(poker[i]);
			if (i % 4 == 1) p2.addCard(poker[i]);
			if (i % 4 == 2) p3.addCard(poker[i]);
			if (i % 4 == 3) p4.addCard(poker[i]);
		});
		
		players = new Player[]{p1, p2, p3, p4};
		handcards = new int[]{p1.getCardAmount(), p2.getCardAmount(), p3.getCardAmount(), p4.getCardAmount()};
		System.out.println("===================初始手牌==================");
		p1.showCards();
		p2.showCards();
		p3.showCards();
		p4.showCards();
		System.out.println("===================開始賽局==================");
		
		int game = 1;
		int idx_atk = 0, idx_def = 1;
		boolean isOver = false;
		
		while (!isOver) {	
			if (handcards[idx_atk % 4] != 0 && handcards[idx_def % 4] != 0) {
				players[idx_atk % 4].drawCard(players[idx_def % 4], (int)(Math.random()*handcards[idx_def % 4]));
				handcards[idx_atk % 4] = players[idx_atk % 4].getCardAmount();
				handcards[idx_def % 4] = players[idx_def % 4].getCardAmount();
				
				System.out.printf("===================第%2d局==================\n", game);
				
				p1.showCards();
				p2.showCards();
				p3.showCards();
				p4.showCards();
				game++;
				
			}
			if (handcards[idx_atk % 4] != 0 && handcards[idx_def % 4] == 0) {
				idx_def++;
			} else if (handcards[idx_atk % 4] == 0 && handcards[idx_def % 4] != 0) {
				idx_atk++;
			} else {
				idx_atk++; idx_def++;
			}
			
			if ((handcards[0] + handcards[1] + handcards[2] + handcards[3]) == 1) {
				isOver = true;
			}
			
		}
		System.out.println("===================遊戲結束==================");
	}
	
}
