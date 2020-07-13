package joe1;
//testing multi-dimensional arrays

public class arrayInArray
{
	public static void main(String[] args)
	{
		String[][] financial = {{"Account_ID", "Account_number", "Bank", "Account_name"},
				{"0", "44238", "Sterling", "Tonia"}, {"1", "68416", "First", "Tony"},
				{"2", "78333", "GT", "Tolu"}};
		String[][] internet = {{"Account_ID", "Account_number", "Bank", "Account_name"},
				{"0", "44238", "Sterling", "TJ"}, {"1", "68416", "First", "Tony"},
				{"2", "78323", "GTB", "Tolu"}};
		
		for (int i=0; i<4; i++)
		{
			for (int j=0; j<4; j++)
			{
				if (financial[i][j] != internet[i][j]){
					internet[i][j] = financial[i][j];
					
					//String UPDATE_QUERY = String.format("UPDATE account SET %s = %s WHERE "
						//	+ "ID = %d", financial[0][j], financial[i][j], Integer.toString(i));
				
				}
			}
		}
		for (String[] loop:internet){
			for (String lo:loop){
				System.out.printf("%18s", lo);
			}
	System.out.println(" ");
		}
	}
}