package joe1;

//creates an account class that returns a name of someone living with you - to be instantiated later

public class Account
{
	private String id;
	public String acc(String name)
	{
		id = name;
		return id + " lives with you!";
	}
}