import java.util.Scanner;

public class VariableNameChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String variableName;
		boolean isLegal,onlyAllowedCharacters = true,firstCharLowercase;
		
		System.out.print("Enter a variable name (q to quit): ");
		variableName = scanner.nextLine();
		
		while (!variableName.equals("q")) {
			isLegal = Character.isLetter(variableName.charAt(0)) ;
			for (int i = 0; i <= variableName.length()-1;i++) {
				if (isLegal == true) {
					isLegal = !Character.isSpaceChar(variableName.charAt(i));
				}
				
				if (onlyAllowedCharacters == true) {
					onlyAllowedCharacters = Character.isLetterOrDigit(variableName.charAt(i));
				}
			}
			firstCharLowercase = Character.isLowerCase(variableName.charAt(0));
			
			if (!isLegal) {
				System.out.println("Illegal.");
			} else if (isLegal && !(onlyAllowedCharacters && firstCharLowercase)) {
				System.out.println("Legal, but uses poor style.");	
			} else {
				System.out.println("Good!");
			}
			
			System.out.print("Enter a variable name (q to quit): ");
			variableName = scanner.nextLine();
		}
		
	}

}
