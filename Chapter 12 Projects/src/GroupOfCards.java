
public class GroupOfCards {
	Card[] cards;
	int currentSize;
	
	//*******************************
	
	public GroupOfCards() {
		
	}
	
	public GroupOfCards(int size) {
		this.currentSize = 0;
		cards = new Card[size];
	}
	
	//*******************************
	
	public int getCurrentSize() {
		return this.currentSize;
	}
	
	public Card getCard(int index) {
		return cards[index];
	}
	
	//*******************************
	
	public void addCard(Card card) {
		cards[currentSize++] = card;
	}
	
	//*******************************
	
	public Card removeCard(int index) {
		Card card = cards[index];
		
		currentSize--;
		for (int i=index; i<currentSize; i++) {
			cards[i] = cards[i+1];
		}
		
		return card;
	}
	
	//*******************************
	
	public void display() {
		for(int i=0; i<currentSize; i++) {
			cards[i].display();
		}
	}
	
	//******************************
	
	public static void main(String[] args) {
		GroupOfCards cards = new GroupOfCards(30);
		
		cards.addCard(new Card(14,0));
		cards.addCard(new Card(13,1));
		cards.addCard(new Card(12,2));
		cards.addCard(new Card(11,3));
		cards.removeCard(2);
		
		cards.display();
	}
}