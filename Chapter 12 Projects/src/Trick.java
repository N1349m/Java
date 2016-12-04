
public class Trick extends GroupOfCards{
	private int winner;
	private Card winningCard;
	private boolean hearts = false;
	private boolean queen = false;

	//*********************************

	public Trick(int players) {
		super(2*players - 1);
	}

	//*********************************

	public int getWinner() {
		return winner;
	}

	//*********************************

	public Card getWinningCard() {
		return winningCard;
	}

	//*********************************

	public boolean getHearts() {
		return hearts;
	}

	//*********************************

	public boolean getQueen() {
		return queen;
	}

	//*********************************
	
	public void update(int playerNum, Card card) {
		if (isWinner(card)) {
			winner = playerNum;
			winningCard = card;
		}
		
		if (card.getSuit() == 2) {
			hearts = true;
		}
		
		if (card.getNum() == 12 && card.getSuit() == 3) {
			queen = true;
		}
	}
	
	//*********************************
	
	private boolean isWinner(Card card) {
		boolean exists = winningCard != null;
		boolean sameSuit = card.getSuit() == winningCard.getSuit();
		boolean smallerNumber = card.getNum() < winningCard.getNum();
		if (exists && (sameSuit || smallerNumber)) {
			return false;
		} else {
			return true;
		}
	}
}