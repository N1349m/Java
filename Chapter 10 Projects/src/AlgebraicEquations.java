import java.util.*;
public class AlgebraicEquations {

	public static void decompose(int n, double[][] coefficients, int[] oldRow) {
		double[] scalings = doScaling(n, coefficients);
		int maxRow;
		double swap;
		int swapInt;

		for (int row=0; row<n; row++) {
			oldRow[row] = row;
		}
		for (int col=0; col<n; col++) {
			doUpper(col, coefficients);
			maxRow = beginLower(col, coefficients, scalings);

			if (maxRow != col) {
				for(int k=0; k<n; k++) {
					swap = coefficients[maxRow][k];
					coefficients[maxRow][k] = coefficients[col][k];
					coefficients[col][k] = swap;
				}
				swapInt = oldRow[maxRow];
				oldRow[maxRow]=oldRow[col];
				oldRow[col] = swapInt;
			}

			if (col != (n-1)) {
				for (int row=(col+1); row<n; row++) {
					coefficients[row][col] /= coefficients[col][col];
				}
			}
		}
	}

	//****************************************

	private static double[] doScaling(int n, double[][] coefficients) {
		double[] scalings = new double[n];
		double max;

		for (int row=0; row<n; row++) {
			max = 0;

			for (int col=0; col<n; col++) {
				if (Math.abs(coefficients[row][col]) > max)
					max = Math.abs(coefficients[row][col]);
			}

			if (max==0) {

			}

			scalings[row] = 1/max; 
		}

		return scalings;
	}

	//****************************************

	private static void doUpper(int col, double[][] coefficients) {
		double sum;

		for (int row=0; row<col; row++) {
			sum = coefficients[row][col];
			for (int k=0; k<row; k++) {
				sum -= coefficients[row][k] * coefficients[k][col];
			}
			
			coefficients[row][col] = sum;
		}

	}

	//****************************************

	private static int beginLower(int col, double[][] coefficients, double[] scalings) {
		int rowMax;
		double max, sum;
		rowMax = col;
		max = 0;
		
		for (int row=col; row<coefficients.length; row++) {
			sum = coefficients[row][col];
			for (int k=0; k<col; k++) {
				sum -= coefficients[row][k] * coefficients[k][col];
			}
			
			coefficients[row][col] = sum;
			if (scalings[row] * Math.abs(sum) >=max) {
				max = scalings[row] * Math.abs(sum);
				rowMax = row;
			}
		}
		
		return rowMax;
	}

	//****************************************

	public static double[] substitute(int n, double [][] lowerUpper, 
			int[] oldRow, double[] rightSides) {
		rightSides = forward(n, lowerUpper, oldRow, rightSides);
		backward(n, lowerUpper, rightSides);
		return rightSides;
	}

	//****************************************

	private static double[] forward(int n, double[][] upperLower, int[] oldRow,
			double[] rightSides) {
		int firstNonZeroRow = -1;
		double[] solution = new double[n];
		double sum;
		
		for (int row=0; row<n; row++) {
		  sum = rightSides[oldRow[row]];
		  if (firstNonZeroRow > -1) {
		    for (int col=firstNonZeroRow; col<row; col++) {
		      sum -= upperLower[row][col] * solution[col];
		    }
		  } else if (sum != 0)
		    firstNonZeroRow = row;
		  solution[row] = sum;
		  
		}
		
		return solution;

	}
	
	//****************************************
	
	private static void backward(int n, double[][] lowerUpper, 
			double[] rightSides) {
		double sum;
		
		for (int row=n-1; row>=0; row--) {
			sum = rightSides[row];
			
			for (int col=row+1; col<n; col++) {
				sum -= lowerUpper[row][col] * rightSides[col];
			}
			
			rightSides[row] = sum / lowerUpper[row][row];
		}
	}
}
