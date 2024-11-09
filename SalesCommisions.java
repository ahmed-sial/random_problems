/**
	(Sales Commissions) Use a one-dimensional array to solve the following problem: A com-
	pany pays its salespeople on a commission basis. The salespeople receive $200 per week plus 9% of
	their gross sales for that week. For example, a salesperson who grosses $5,000 in sales in a week re-
	ceives $200 plus 9% of $5,000, or a total of $650. Write an application (using an array of counters)
	that determines how many of the salespeople earned salaries in each of the following ranges (assume
	that each salesperson’s salary is truncated to an integer amount):
	a) $200–299
	b) $300–399
	c) $400–499
	d) $500–599
	e) $600–699
	f) $700–799
	g) $800–899
	h) $900–999
	i) $1,000 and over
	Summarize the results in tabular format.
 */
import java.util.Scanner;
public class SalesCommisions {
	public static void main(String[] args) {
		final int BASIC_SALARY = 200;
		System.out.print("Enter the total employees: ");
		Scanner input = new Scanner(System.in);
		int totalEmployees = input.nextInt();
		int[] grosses = new int[totalEmployees];
		System.out.println("Enter the grosses: ");
		for (int i = 0; i < grosses.length; i++) {
			grosses[i] = input.nextInt();
		}
		int[] totalSalaries = new int[totalEmployees];
		for (int i = 0; i < grosses.length; i++) {
			totalSalaries[i] = totalSalary(BASIC_SALARY, calculateCommision(grosses[i]));
		}
		int[] frequency = counter(totalSalaries);
		for (int i = 0; i < frequency.length; i++) {
			if (i == 8)
				System.out.printf("%8s ", "1000+:");
			else
				System.out.printf("%02d-%02d%s", (2 + i) * 100, (2 + i) * 100 + 99, ": ");
			System.out.println(frequency[i]);
		}
	}
	public static int calculateCommision(int soldGross) {
		return (int) (0.09 * soldGross);
	}
	public static int totalSalary(int basicSalary, int soldGross) {
		return (basicSalary + soldGross);
	}
	public static int[] counter(int[] totalSalaries) {
		int[] frequency = new int[9];
		for (int i = 0; i < totalSalaries.length; i++) {
			int value = totalSalaries[i] / 100;
			switch(value) {
				case 2:
					++frequency[0];
					break;
				case 3:
					++frequency[1];
					break;
				case 4:
					++frequency[2];
					break;
				case 5:
					++frequency[3];
					break;
				case 6:
					++frequency[4];
					break;
				case 7:
					++frequency[5];
					break;
				case 8:
					++frequency[6];
					break;
				case 9:
					++frequency[7];
					break;
				case 10:
					++frequency[8];
					break;
			}
		}
		return frequency;
	}
}
