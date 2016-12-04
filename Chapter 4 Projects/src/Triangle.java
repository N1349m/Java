import java.util.Scanner;
public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int sideSize; //Size of 1 side of triangle

		System.out.print("Enter the size of the equal sides in an isosceles triangle: ");
		sideSize = scanner.nextInt();
		int i,j,k;

		for (i=1; i<=sideSize; i++){
			System.out.print("*");

			if (i>2 && i<sideSize){
				for (k = 1;k<=i-2;k++){
					System.out.print(" ");
				}
			}
			if (i>1){
				System.out.print("*");
			}
			
			if (i==sideSize) {
				for(j = 1;j<=sideSize-2;j++){
					System.out.print("*");
				}
			}
			System.out.print("\n");
		}
	}
}