public class Deck extends GroupOfCards
{
	public static final int TOTAL_CARDS = 52;

	//***************************************

	public Deck()
	{
		super(TOTAL_CARDS);

		for (int i=0; i<TOTAL_CARDS; i++)
		{
			addCard(new Card((2 + i%13), i/13));
		}
	} // end constructor

	//***************************************

	public void shuffle() {
		for (int unshuffled = getCurrentSize(); unshuffled>-1; unshuffled--) {
			addCard(removeCard((int) (52*Math.random())));
		}
	}

	//***************************************

	public Card dealCard() {
		return removeCard(0);
	}
	
	//***************************************
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		
		deck.shuffle();
		deck.dealCard().display();
		deck.dealCard().display();
	}

} // end class Deck