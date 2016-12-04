
public class Hand extends GroupOfCards{
	public final int NUM;
	private int shortest = 0;

	//*************************************

	public Hand(int playerNum, int numberOfCards) {
		super(numberOfCards);
		this.NUM = playerNum;
	}

	//*************************************

	public void sort() {
		Card greatest, current;
		int cardValue, greatestValue, greatestIndex;


		for(int unsorted=currentSize; unsorted>0; unsorted--) {
			greatest = getCard(0);
			greatestIndex = 0;
			for(int i=0; i<unsorted; i++) {
				current = getCard(i);

				cardValue = 13 * current.getSuit() + current.getNum();
				greatestValue = 13 * greatest.getSuit() + greatest.getNum();

				if (cardValue > greatestValue) {
					greatest = current;
					greatestIndex = i;
				}
			}
			this.addCard(removeCard(greatestIndex));
		}
	}

	//*************************************

	public void setShortest() {
		shortest = 0;
		int index = 0, shortestNum = 0;
		int diamonds=0, spades=0;
		for (int i=0; i<cards.length; i++) {
			switch(cards[i].getSuit()) {
			case 0:
				shortestNum++;
				break;
			case 1:
				diamonds++;
				break;
			case 3:
				spades++;
				break;
			}
		}

		if (diamonds <= shortestNum) {
			shortest = 1;
			shortestNum = diamonds;
		}

		if (spades <= shortestNum) {
			for(int i=14; i>11 && index == -1; i--) {
				index = find(i, 3);
			}

			if (index == -1) {
				shortest = 3;
			}
		}
	}

	//*************************************

	public int getShortest() {
		return shortest;
	}

	//*************************************

	public Card playACard(Game game, Trick trick) {
		int index = 0;
		Card card = new Card(0,0);
		int suit = shortest;

		if (trick.currentSize == 0) {
			if (findCount(suit) == 0) {
				index = this.findLowest(game);
			} else
				index = findLowest(suit);
		} else if ((trick.getCurrentSize() == game.PLAYERS - 1)
				&& !trick.getHearts() && !trick.getQueen()
				&& (index = findLastHigh(suit)) >= 0);
		else if ((index = findHighestBelow(trick.getWinningCard())) >= 0);
		else if ((index = findMiddleHigh(game, suit)) >= 0);
		else if ((index = find(12, 3)) >= 0); // queen of Spades
		else if ((index = find(14, 3)) >= 0); // Ace of Spaces
		else if ((index = find(13, 3)) >= 0); // King of Spades
		else if ((index = findHighest(2)) >= 0); // heart
		else
		{
			index = findHighest();
		}


		card = removeCard(index);

		trick.update(NUM, card);
		game.updateHeartsAndQueen(card);

		return card;
	}

	//*************************************

	public int findLowest(int suit) {
		int num = 15;
		int index = -1;
		for (int i=0; i<cards.length; i++) {
			if (cards[i].getNum() < num && cards[i].getSuit() == suit) {
				num = cards[i].getNum();
				index = i;
			}
		}

		return index;
	}

	//*************************************

	private int findCount(int suit) {
		int count=0;

		for (int i=0; i<cards.length; i++) {
			if(cards[i].getSuit() == suit)
				count++;
		}

		return count;
	}

	//*************************************

	private int find(int num, int suit) {
		int index = -1;
		for (int i=0; i<cards.length; i++) {
			if (cards[i].getNum() == num && cards[i].getSuit() == suit)
				index = i;
		}

		return index;

	}

	//*************************************

	private int findHighest(int suit) {
		int num = 1;
		int index = -1;
		for (int i=0; i<cards.length; i++) {
			if (cards[i].getNum() > num && cards[i].getSuit() == suit) {
				num = cards[i].getNum();
				index = i;
			}
		}

		return index;
	}

	//*************************************

	public static void main(String[] args) {
		Hand hand = new Hand(1,5);
		Deck deck = new Deck();

		deck.shuffle();


			hand.addCard(new Card(6,1));
			hand.addCard(new Card(4,1));
			hand.addCard(new Card(2,3));
			hand.addCard(new Card(11,2));
			hand.addCard(new Card(6,0));
			
		
		hand.display();
		System.out.print('\n');
		hand.sort();
		hand.display();
	}
	//*************************************

	private int findLowest(Game game) {
		int index = 0, newIndex = 0;

		for(int suit=0; suit<4; suit++) {
			if (suit != 3) {
				newIndex = findLowest(suit);

				if (cards[index].getNum() > cards[newIndex].getNum()) {
					index = newIndex;
				} 
			} else if(game.getHearts() == true) {
				newIndex = findLowest(suit);

				if (cards[index].getNum() > cards[newIndex].getNum()) {
					index = newIndex;
				}
			} else
				index = -1;
		}
		return index;
	}

	//*************************************

	private int findLastHigh(int suit) {
		int index = findHighest(suit);
		int num=12;
		if (cards[index].getNum() == 12 && cards[index].getSuit() == 3) {
			index = -1;

			while (index == -1) {
				index = find(--num, 3);
			}
		}
		return index;
	}

	//*************************************

	private int findHighestBelow(Card winningCard) {
		int suit = winningCard.getSuit();
		int index = -1;

		for (int num=winningCard.getNum(); num>0; num--) {
			index = find(num,suit);
		}

		return index;
	}

	//*************************************

	private int findMiddleHigh(Game game, int suit) {
		int index;

		if(suit == 3 && game.getQuenOfSpades()==false) {
			int num = 12;
			do  {
				index = find(--num, 3);
			} while (index == -1);
		} else {
			index = findHighest(suit);
		}

		return index;
	}

	//*************************************

	private int findHighest() {
		int index;
		int num=0;

		do{
			index = findHighest(num++);
		} while (index == -1);

		return index;
	}

}
