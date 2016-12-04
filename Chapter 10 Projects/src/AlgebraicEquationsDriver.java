import java.util.*;
public class AlgebraicEquationsDriver {
	private static double[][] dCoefficients = {{-6, 33, 16}, {-7, 34, -8}, {-25, 22, 9}};
	private static double[] dRightSides = {-36, 43, -46};

	//**********************************************

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = setUp();
		double[][] coefficients = new double[n][n];
		double[] rightSides = new double[n];
		int[] oldRow = new int[n];

		for (int row=0; row<n; row++) {
			rightSides[row] = dRightSides[row];
			for (int col=0; col<n; col++) {
				coefficients[row][col] = dCoefficients[row][col];
			}
		}

		print("Equations", n, coefficients, rightSides);

		AlgebraicEquations.decompose(n, coefficients, oldRow);
		double[] solution = AlgebraicEquations.substitute(n,
				coefficients, oldRow, rightSides);

		print("Solution:", n, solution);

		rightSides = evaluate(n, dCoefficients, solution);

		print("Verification",n,dRightSides,rightSides);

	}

	//**********************************************

	private static int setUp() {
		Scanner scanner = new Scanner(System.in);
		int n;

		System.out.print("Number of Equations & Unknowns: ");
		n=scanner.nextInt();
		scanner.nextLine();

		if (n==0)
			n=3;
		else {
			dCoefficients = new double[Math.abs(n)][Math.abs(n)];
			dRightSides = new double[Math.abs(n)];
			if(n < 0) {
				n = -n;
				generateEquations(n, dCoefficients, dRightSides);
			} else {
				for (int row=0; row<n; row++) {
					System.out.println("\nEnter equation " + row + 
							"'s coefficients separated by spaces:");
					String input = scanner.nextLine();
					for (int col=0; col<n; col++) {
						if (input.indexOf(" ") != -1) {
							String num = input.substring(0, input.indexOf(" "));
							dCoefficients[row][col] = Double.valueOf(num);
							input = input.substring(input.indexOf(" ") + 1); 
						} else {
							dCoefficients[row][col] = Double.valueOf(input);
						}
					}
					System.out.println("Enter right side value:");
					dRightSides[row] = scanner.nextDouble();
					scanner.nextLine();
				}
			}
		}
		return n;
	}

	//**********************************************

	private static void generateEquations(int n, double[][] coefficients, 
			double[] rightSides) {

		for (int row=0; row<n; row++) {
			for (int col=0; col<n; col++) {
				coefficients[row][col] = Math.round(100 * (Math.random()-0.5));
			}
			rightSides[row] = Math.round(100 * (Math.random()-0.5));
		}
	}

	//**********************************************

	private static void print(String message, int n, double[][] coefficients, 
			double[] rightSide) {
		System.out.println(message);
		for (int row=0; row<n; row++) {
			for (int col=0; col<n; col++) {
				System.out.print(coefficients[row][col] + "\t");
			}
			System.out.println(rightSide[row]);
		}
	}

	//**********************************************

	private static void print(String message, int n, double[] solution) {
		System.out.println(message);
		for (int i=0; i<n; i++) {
			System.out.println(solution[i]);
		}
	}

	//***********************************************

	public static double[] evaluate(int n, double[][] coefficients, double[] solution) {
		double[] rightSides = new double[n];

		for (int row=0; row<n; row++) {
			for (int col=0; col<n; col++) {
				rightSides[row] += dCoefficients[row][col] * solution[col]; 
			}
		}

		return rightSides;
	}

	//***********************************************

	private static void print(String message, int n, double[] origRS, double[] checkRS) {
		System.out.println(message);
		for (int i=0; i<n; i++) {
			System.out.printf("%4.1f%6.1f\n", origRS[i], checkRS[i]);
		}
	}
}
