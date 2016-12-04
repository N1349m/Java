import java.util.Scanner;

public class PhoneNumberDissector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String phoneNumber, cc, area, local;
		int dashIndex, dashCount; 

		System.out.println("PHONE NUMBER DISSECTOR");
		System.out.println("\nvEnter a phone number in the form cc-area-local,");
		System.out.println("where cc = country code digits, area = area code digits,");
		System.out.println("and local = local phone digits.");
		System.out.println("Or enter q to quit:");
		phoneNumber = scanner.next();

		while (!phoneNumber.equalsIgnoreCase("q")) {
			dashCount = 0;
			for (int i = 0; i <= phoneNumber.length() - 1; i++) {
				if (phoneNumber.charAt(i) == '-')
					dashCount += 1;
			}
			if (dashCount == 0) {
				cc = "?";
				area = "?";
				local = phoneNumber;
			} else if (dashCount ==1) {
				dashIndex = phoneNumber.indexOf('-');
				cc = "?";
				area = phoneNumber.substring(0, dashIndex);
				local = phoneNumber.substring(dashIndex+1);
			} else {
				dashIndex = phoneNumber.indexOf('-');
				cc = phoneNumber.substring(0, dashIndex);
				phoneNumber = phoneNumber.substring(dashIndex+1);

				dashIndex = phoneNumber.indexOf('-');
				area = phoneNumber.substring(0,dashIndex);
				local = phoneNumber.substring(dashIndex+1);
			}
				System.out.println("\ncountry code = " + cc);
				System.out.println("area code = " + area);
				System.out.println("local phone number = " + local);

				System.out.println("\nEnter a phone number in the form cc-area-local,");
				System.out.println("where cc = country code digits, area = area code digits,");
				System.out.println("and local = local phone digits.");
				System.out.println("Or enter q to quit:");
				phoneNumber = scanner.next();
			}
		}

}
