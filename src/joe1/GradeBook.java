package joe1;
//creates various methods for analyzing students' scores in various tests

public class GradeBook
{
	private String courseName;
	private int[][] grades;
	
	public GradeBook(String courseName, int[][] grades)
	{
		this.courseName = courseName;
		this.grades = grades;
	}
	
	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}
	
	public String getCourseName()
	{
		return courseName;
	}
	
	public void processGrades()
	{
		outputGrades();
		System.out.printf("%n%s %d%n%s %d%n%n", "Lowest grade in the grade book is",
				getMinimum(), "Highest grade in the grade book is", getMaximum());
		outputBarChart();
	}
	
	public int getMinimum()
	{
		int lowGrade = grades[0][0];
		for (int[] stud:grades)
		{
			for (int grad:stud)
			{
				if (grad < lowGrade)
					lowGrade = grad;
			}
		}
		return lowGrade;
	}
	
	public int getMaximum()
	{
		int highGrade = grades[0][0];
		for (int[] stud:grades)
		{
			for (int grad:stud)
			{
				if (grad > highGrade)
					highGrade = grad;
			}
		}
		return highGrade;
	}
	
	public double getAverage(int[] setOfGrades)
	{
		int total = 0;
		for (int grad:setOfGrades)
			total += grad;
		return (double) total/setOfGrades.length;
	}
	
	public void outputBarChart()
	{
		System.out.println("Overall grade distribution: ");
		int[] freq = new int[11];
		for (int[] stud:grades)
		{
			for (int grad:stud)
				++freq[grad/10];
		}
		for (int count = 0; count < freq.length; count++)
		{
			if (count == 10)
				System.out.printf("%5d: ", 100);
			else
				System.out.printf("%02d-%02d: ", count*10, count*10 + 9);
			
			for (int star = 0; star < freq[count]; star++)
				System.out.print("*");
		
			System.out.println();
		}
	}
	
	public void outputGrades()
	{
		System.out.printf("The grades are:%n%n");
		System.out.print("            ");
		
		for (int test = 0; test < grades[0].length; test++)
			System.out.printf("Test %d  ", test + 1);
		
		System.out.println("Average");
		
		for (int student = 0; student < grades.length; student++)
		{
			System.out.printf("Student %2d", student + 1);
			
			for (int tst:grades[student])
				System.out.printf("%8d", tst);
			
			double average = getAverage(grades[student]);
			System.out.printf("%9.2f%n", average);
		}
	}
}