package joe1;
// implements various methods of class GradeBook
// - a data analysis of grades of students in various tests

public class GradeBookTest
{
	public static void main(String[] args)
	{
		int[][] gradesArray = {{87, 96, 70}, {68, 87, 90}, {94, 100, 90}, {100, 81, 82},
				{83, 65, 85}, {78, 87, 65}, {85, 75, 83}, {91, 94, 100}, {76, 72, 84},
				{87, 93, 73}};
		
		GradeBook mygrad = new GradeBook("JOH101 - Introduction to Java Programming with Johanson",
				gradesArray);
		System.out.printf("Welcome to the grade book for%n%s%n%n", mygrad.getCourseName());
		mygrad.processGrades();
	}
}