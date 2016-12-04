import java.util.Scanner;
import javax.swing.*;
import java.awt.Font;
public class Spawn {
	private char[][] grid = {{' ',' ',' ',' ',' ',' '},
			{' ',' ','X',' ',' ',' '},
			{' ',' ',' ','X',' ',' '},
			{' ','X','X','X',' ',' '},
			{' ',' ',' ',' ',' ',' '}};
	private int rows = 5, cols = 6;

	//*****************************************

	public void nextGeneration() {
		//System.out.println("Next generation");
		int nextTo;

		char[][] temp = copy(grid);

		for (int row=0; row<rows; row++) {
			for (int col=0; col<cols; col++) {
				boolean alive = false, condition = false;

				if (grid[row][col] == 'X') 
					alive = true;

				nextTo = nextTo(grid, row, col);
				if (!alive) {
					if (nextTo == 3) {
						condition = true;
					}
				} else {
					if (nextTo == 3 | nextTo == 2) {
						condition = true;
					}
				}
				if (!alive && condition) {
					temp[row][col] = 'X';
				}

				if (alive && !condition) {
					temp[row][col] = ' ';
				}

				alive = false;
				condition = false;
			}
		}
		grid = copy(temp);
	}

	//******************************************

	public void loadGrid() {
		Scanner scanner = new Scanner(System.in);
		String gridValues;

		System.out.print("Enter number of rows in spawn grid:");
		rows = scanner.nextInt();
		System.out.print("Enter number of clumns in spawn grid:");
		cols = scanner.nextInt();
		scanner.nextLine();
		grid = new char[rows][cols];

		System.out.println("Enter a column with " + rows + 
				" rows and "+ cols + " columns.");
		System.out.println("\nBlank indicates empty. X indicates alive");

		for (int i=0; i<rows; i++) {
			gridValues = scanner.nextLine();
			for (int j=0; j<gridValues.length(); j++) {
				grid[i][j] = gridValues.charAt(j);
			}
			for (int j=0; j<cols-gridValues.length(); j++) {
				grid[i][j] = ' ';
			}
		}
	}

	//*******************************************

	public void evolve() {
		Scanner scanner = new Scanner(System.in);
		int time;

		System.out.print("Number of generations to be spawned: ");
		time = scanner.nextInt();

		for (int i=0; i<time; i++) {
			this.nextGeneration();
		}
	}

	//*******************************************

	public String print() {
		String output="";

		for (int row=0; row<rows; row++) {
			if (row>0)
				output += '\n';
			for (int col=0; col<cols; col++) {
				output += grid[row][col];
			}
		}

		return output;
	}

	//*******************************************

	public void printSpecial() {
		JFrame window = new JFrame("Game of Spawn");
		JTextArea area = new JTextArea();
		String display = print();

		window.setSize(220, 230);
		window.add(area);
		area.append("_____________________________");
		for (int i=0; i<display.length()-1; i++) {
			if (display.charAt(i) == ' ')
				area.append("   ");
			if (display.charAt(i) == '\n') {
				area.append('\u2502' + "\n" + '\u2502');
			}
			if (display.charAt(i) == 'X') {
				area.append('\u263A' + "");
			}
		}


		window.setVisible(true);
	}

	//********************************************

	private char[][] copy(char[][] array) {
		char[][] output = new char[rows][cols];

		for (int row=0; row<rows; row++) {
			for (int col=0; col<cols; col++) {
				output[row][col] = array[row][col];
			}
		}
		return output;
	}

	//*********************************************

	private int nextTo(char[][] array, int row, int col) {
		int output = 0;
		boolean border = true;
		boolean center = false;

		for (int i=-1; i<2; i++) {
			for (int j=-1; j<2; j++) {
				if (row==0 & i==-1) {
					border = false;
				}

				if (row==rows-1 & i==1) {
					border = false;
				}

				if (col==0 & j==-1) {
					border = false;
				}

				if (col==cols-1 & j==1) {
					border = false;
				}

				if (i==0 & j==0) {
					center = true;
				}

				if (border & !center) {
					if (array[row + i][col + j] == 'X') {
						output++;
					}
				}

				border = true;
				center = false;
			}
		}

		return output;
	}
}
