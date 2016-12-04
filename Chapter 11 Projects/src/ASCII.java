
public class ASCII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String formatSpec = "%3d\t%s\t%3d\t%s\t%3d\t%s\t%3d\t%s\t\n";
		
		System.out.println("Dec\t \tDec\t \tDec\t \tDec\t \t");
		System.out.println("---\t \t---\t \t---\t \t---\t \t");
		
		for (int i=0; i<32; i++) {
			System.out.printf(formatSpec, i,(char) i, i+32, (char) (i+32),
					i+64, (char) (i+64), i+96, (char) (i+96));
		}
	}

}
