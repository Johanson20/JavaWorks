package joe1;
//showcases inheritance from class - finance, instantiated in class jo

public class financeTest extends finance
{
	private double bonus;
	
	public financeTest(String name, int id, double salary, double bonus)
	{
		super(name, id, salary);
		if (bonus < 0)
			throw new IllegalArgumentException("Bonus cannot be negative");
		
		this.bonus = bonus;
	}
	
	public void setBonus(double bonus)
	{
		if (bonus < 0)
			throw new IllegalArgumentException("Bonus cannot be negative");
		this.bonus = bonus;
	}
	
	public double getBonus()
	{
		return bonus;
	}
	
	public double getEarning()
	{
		return getBonus() + super.getSalary();
	}
	
	@Override
	public String toString()
	{
		return String.format("%s%s: %.2f%n", super.toString(),
				"Total earning", getEarning());
	}
}
