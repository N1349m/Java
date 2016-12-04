import java.util.Scanner;

public class TextParsing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		boolean okInput;
		char badCharacter,firstCharacter;
		String pigWord,suffix,line;
		
		
		System.out.print("Enter a word: ");
		line = scanner.next();
		while (!line.equals("q")){
			okInput = true;
			for (int i = 0; i <= line.length()-1;i++){
				if (!(Character.isLetter(line.charAt(i)))) {
					okInput = false;
					System.out.print("Invalid input - can't process this character: " + line.charAt(i));
				}
				
			}
			if (okInput) {
				pigWord = "";
				firstCharacter = line.charAt(0);
				
				if (firstCharacter=='a' || firstCharacter=='e' || firstCharacter=='i' 
						|| firstCharacter=='o' || firstCharacter=='u') {
					pigWord += firstCharacter;
					suffix = "";
				} else {
					suffix = firstCharacter + "ay";
				}
				pigWord += line.substring(1) + suffix;
				System.out.println("In Pig Latin, that's " + pigWord);
			}
			System.out.print("Enter a word: ");
			line = scanner.next();
		}
		System.out.print("I hope you enjoyed your porcine experience! Please come again.");
	}

}
