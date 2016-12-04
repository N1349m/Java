
public class HwScore {
	private static final double A = 0.9, B = 0.8, C = 0.7, D = 0.6;
	private static double totalEarnedPoints = 0, totalPossiblePoints = 0; 
	private double earnedPoints, possiblePoints;
	
	//********************************************
	
	public HwScore(double score, double total) {
		earnedPoints = score;
		possiblePoints = total;
		HwScore.totalEarnedPoints += score;
		HwScore.totalPossiblePoints += total;
	}
	
	//********************************************
	
	public void printGrade() {
		String grade;
		
		grade = calcLetterGrade(earnedPoints, possiblePoints);
		System.out.println("On this homework, you earned " + earnedPoints + 
				" out of " + possiblePoints + " possible points: " + grade);
	}
	
	//********************************************
	
	public static void printOverallGrade() {
		String grade;
		double score = HwScore.totalEarnedPoints;
		double total = HwScore.totalPossiblePoints;
		
		grade = calcLetterGrade(score, total);
		System.out.println("On all homeworks, you earned " + score + 
				" out of " + total + " possible points: " + grade);
	}
	
	//********************************************
	
	private static String calcLetterGrade(double score, double total) {
		String grade;
		double ratio;
		
		ratio = score / total;
		if (ratio >= HwScore.A) {
			grade = "A";
		} else if (ratio >= HwScore.B) {
			grade = "B";
		} else if (ratio >= HwScore.C) {
			grade = "C";
		} else if (ratio >= HwScore.D) {
			grade = "D";
		} else {
			grade = "F";
		}
		return grade;
	}
}
