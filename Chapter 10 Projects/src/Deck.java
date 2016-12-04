import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> deck = new ArrayList<Card>();

	//*****************************************

	public Deck() {
		for (int num=1; num<=13; num++) {
			deck.add(new Card(num, 'C'));
		}

		for (int num=1; num<=13; num++) {
			deck.add(new Card(num, 'D'));
		}

		for (int num=1; num<=13; num++) {
			deck.add(new Card(num, 'H'));
		}

		for (int num=1; num<=13; num++) {
			deck.add(new Card(num, 'S'));
		}
	}


	//*****************************************

	public Card dealCard() {
		return deck.remove(deck.size()-1);
	}

	//*****************************************

	public String toString() {
		String output = "";

		for (int i=0; i<deck.size(); i++) {
			output += (deck.get(i) + " ");

			if ((i+1)%5 == 0) {
				output += '\n';
			}
		}

		return output;
	}
}
