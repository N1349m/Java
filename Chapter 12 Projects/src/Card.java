
public class Card {
	private int num;
	private int suit;
	
	//************************
	
	public Card(int num, int suit) {
		this.num = num;
		this.suit = suit;
	}
	
	//************************
	
	public int getSuit() {
		return suit;
	}
	
	public int getNum( ){
		return num;
	}
	
	//************************
	
	public void display() {
		String output = "";
		
		switch(num) {
		case 11:
			output += "Jack";
			break;
		case 12:
			output += "Queen";
			break;
		case 13:
			output += "King";
			break;
		case 14:
			output += "Ace";
			break;
		default:
			output += num;
		}
		
		output += " of ";
		
		switch(suit) {
		case 0:
			output += "clubs";
			break;
		case 1:
			output += "diamonds";
			break;
		case 2:
			output += "hearts";
			break;
		case 3:
			output += "spades";
			break;
		}
		
		System.out.println(output);
	}
}
