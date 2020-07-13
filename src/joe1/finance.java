package joe1;
//creates a class and sets various properties regarding financial details

public class finance
{
	private int id;
	private String name;
	private double salary;
	
	public finance(String name, int id, double salary)
	{
		if (id <= 0)
			throw new IllegalArgumentException("ID can only be a positive integer!");
		if (salary < 0)
			throw new IllegalArgumentException("Salary cannot be negative!");
		
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setId(int id)
	{
		if (id <= 0)
			throw new IllegalArgumentException("ID can only be a positive integer!");
		this.id = id;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setSalary(int salary)
	{
		if (salary < 0)
			throw new IllegalArgumentException("Salary cannot be negative!");
		this.salary = salary;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	@Override
	public String toString()
	{
		return String.format("%n%s: %s%n%s: %d%n%s: %.2f%n", "Name", getName(), 
				"Identification Number", getId(), "Base salary", getSalary());
	}
}
