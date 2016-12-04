
public class HwScoreDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HwScore hw1, hw2, hw3, hw4;
		
		hw1 = new HwScore(26.5, 30);
		hw2 = new HwScore(29, 27.5);
		hw3 = new HwScore(0, 20);
		hw4 = new HwScore(16, 20);
		
		hw1.printGrade();
		hw2.printGrade();
		hw3.printGrade();
		
		HwScore.printOverallGrade();
	}

}
