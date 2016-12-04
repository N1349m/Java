
public class Game {
	public final int PLAYERS;
	private Deck deck = new Deck();
	private Hand[] players;
	private Trick[] tricks;
	private int numberOfTricks = 0;
	private boolean hearts = false;
	private boolean queenOfSpades = false;

	//*************************************

	public Game(int numberOfPlayers) {
		PLAYERS = numberOfPlayers;
		players = new Hand[PLAYERS];

		for (int i=0; i<PLAYERS; i++) {
			players[i] = new Hand(i,52/PLAYERS);
		}

		tricks = new Trick[52 / PLAYERS];
	}

	//*************************************

	public int getNumberOfTricks() {
		return numberOfTricks;
	}

	public boolean getHearts() {
		return hearts;
	}

	public boolean getQuenOfSpades( ){
		return queenOfSpades;
	}

	//*************************************

	public void playAGame() {
		deck.shuffle();

		int cardsLeft = 52 % PLAYERS;
		int playerNum = 0;
		int playerNumLowestIndex = 0;
		Card card;

		for (int j=0; j<52/PLAYERS; j++) {
			for (int i=0; i<PLAYERS; i++) {
				players[i].addCard(deck.dealCard());
		}
		}

		for (int i=0; i<PLAYERS; i++) {
			Hand hand = players[i];
			int lowestIndex;
			
			hand.sort();
			hand.setShortest();
			
			System.out.printf("\t\tplayer %d shortest= %d\n", 
					i, hand.getShortest());
			hand.display();
			
			
			lowestIndex = hand.findLowest(0);
			if (hand.getCard(lowestIndex).getNum() < 
					players[playerNum].getCard(playerNumLowestIndex).getNum()) {
				playerNum = i;
				playerNumLowestIndex = lowestIndex;
				
			}
		}
		
		for (int i=0; i< 52 / PLAYERS; i++) {
			Trick trick = new Trick(PLAYERS);
			int index = playerNumLowestIndex;
			
			numberOfTricks++;
			
			if(numberOfTricks == 1) {
				card = players[playerNum].getCard(index);
				players[playerNum].removeCard(index);
				trick.update(playerNum, card);
			}
			
			
		}
	}

	//*************************************

	public void updateHeartsAndQueen(Card card) {
		if(card.getSuit() == 2){
			System.out.println("Hearts has been broken");
			if (!hearts) {
				hearts = true;
			}
		}

		if (card.getSuit() == 2 && card.getNum() == 12) {
			queenOfSpades = true;
		}
	}

	//*************************************

	private int computePoints(int playerNum) {
		int points = 0;

		for( int i=0; i<numberOfTricks; i++) {
			if (tricks[i].getWinner() == playerNum) {
				for(int j=0; j<tricks[i].getCurrentSize(); j++) {
					Card card = tricks[i].getCard(j);

					if (card.getSuit() == 2 && card.getNum() == 12) {
						points += 13;
					}

					if(card.getSuit() == 2){
						points += 1;
					}
				}
			}
		}

		return points;
	}

}
