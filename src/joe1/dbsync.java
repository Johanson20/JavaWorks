package joe1;

//This program attempts the synchronisation of two databases by looping through each
//for changes between them, and using the data in the source to update the target
//where differences exist

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.DatabaseMetaData;

//This program attempts the synchronisation of two databases by looping through each
//for changes between them, and using the data in the source to update the target
//where differences exist
public class dbsync
{	
    //a method for splitting strings using a delimiter, \, in this case
    public static String str_split(String sentence)
    {
	String[] words = sentence.split("/");
	String last_word = words[words.length - 1];
	return last_word;
    }
	
    public static void main(String args[])
    {	
	//creates several private static variables for both databases
	final String db1 = "jdbc:mysql://localhost:3306/d1";
	final String db2 = "jdbc:mysql://localhost:3306/d2";
		
	int count = 1;	//initialization for number of databases to be compared (2)
		
	final String user = "Johanson";	//username and password
	final String pass = "pp";
		
	String current_table;
	String update_query, delete_query;

	ArrayList<Object> insert_query = new ArrayList<>();
		
        //Class.forName("com.mysql.jdbc.Driver");
		
	try
        {
            //attempts to connect to both databases,
            //executes both queries and extracts metadata for each table
            Connection connection1 = DriverManager.getConnection(db1, user, pass);
            System.out.printf("Database %d has been accessed!%n%n", count++);
            Statement statement1 = connection1.createStatement();
            ResultSet rs, resultSet1, resultSet2;
			
            Connection connection2 = DriverManager.getConnection(db2, user, pass);
            System.out.printf("Database %d has been accessed!%n%n", count++);
            Statement statement2 = connection2.createStatement();
			
            //extracts tables from the first database
            DatabaseMetaData md = (DatabaseMetaData) connection1.getMetaData();
            rs = md.getTables(null,  null,  "%", null);
			
            //loops through each table
            while (rs.next())
            {
                current_table = rs.getString(3);
				
                String query1 = "SELECT * FROM " + current_table;	//creates queries
                Object field_value;
                String query2 = query1;
			
                //executes queries created for both databases
                resultSet1 = statement1.executeQuery(query1);
                ResultSetMetaData metaData1 = resultSet1.getMetaData();
                int noC1 = metaData1.getColumnCount();
				
                resultSet2 = statement2.executeQuery(query2);
                ResultSetMetaData metaData2 = resultSet2.getMetaData();
                int noC2 = metaData2.getColumnCount();
                
                //creates arraylists of objects	for tables and ids
                ArrayList<Object> list1 = new ArrayList<>();
                ArrayList<Object> list2 = new ArrayList<>();
                
                ArrayList<Object> id1 = new ArrayList<>();
                ArrayList<Object> id2 = new ArrayList<>();
			
                //loops through each table and adds columns to the object lists created
                while (resultSet1.next())
                {
                    for (int i=1; i<=noC1; i++)
                        list1.add(resultSet1.getObject(i));
                }
                
                //generates id values
                for (int i=0; i<list1.size(); i+=noC1)
                        id1.add(list1.get(i));
                for (int i=0; i<list2.size(); i+=noC2)
                        id2.add(list2.get(i));
                
                //stores column names
                for (int i=0; i<list1.size(); i+=noC1)
                        id1.add(list1.get(i));
		
                while (resultSet2.next())
                {
                    for (int i=1; i<=noC2; i++)
                        list2.add(resultSet2.getObject(i));
                }
                
			
                //prints out corresponding tables in both databases
                System.out.println("Table for: " + current_table);
                System.out.println(list1);
                System.out.println(list2);
                System.out.println();
			
                //starts comparison if corresponding entries are not all the same
                if ( !(list1.equals(list2)) )
                {
                    //loops through, testing equality of entries in corresponding tables of
                    //both databases
                        for (int j=1; j<=Math.min(list1.size(), list2.size()); j++)
			{	
                            //checks equality in length of databases for update query
                            if ( !(list1.get(j-1).equals(list2.get(j-1))) )
                            {	
				//since lists created are one-dimensional, care must be taken for
				//the updates, by accounting properly for column indexes to be updated
				if (j%noC1 != 0)
				{	
                                    if (((Object) list1.get(j-1)).getClass().getSimpleName().equals("String"))
/*checks if fields*/                    field_value = "'" + (String) list1.get(j-1) + "'";
/*to be updated*/                   else
/*are strings*/                         field_value = list1.get(j-1);
                                        update_query = "UPDATE " + current_table + " SET " + 
                                            metaData2.getColumnName(j%noC1) + " = " + field_value + " WHERE "
                                            + metaData2.getColumnName(1) + " = " + list2.get(noC1*(j/noC1));
				}
				else
				{	
                                    if (((Object) list1.get(j-1)).getClass().getSimpleName().equals("String"))
					field_value = "'" + (String) list1.get(j-1) + "'";
                                    else
					field_value = list1.get(j-1);
                                        update_query = "UPDATE " + current_table + " SET " + 
                                            metaData2.getColumnName(noC1) + " = " + field_value + " WHERE " 
                                            + metaData2.getColumnName(1) + " = " + list2.get(j-noC1);
				}
				//first prints out the update query
				System.out.println(update_query);
				//then implements the update in sql
				statement2.executeUpdate(update_query);
                            }
                        }
                        
                if ( !(id1.equals(id2)) )
                {   if (id1.size() > id2.size())
                    {   //insertion query for new rows
			//loops through each additional row
                	for (int mini =  Math.min(list1.size(), list2.size()); 
                                mini < Math.max(list1.size(), list2.size()); mini += noC1)
                        {
                            //inserts column names
                            insert_query.add("INSERT INTO " + current_table + " (");
				
                            for (int m=1; m<=noC1; m++)
                            {	if (m == noC1)
                                    insert_query.add((String) metaData2.getColumnName(m));
                            else
                                    insert_query.add((String) metaData2.getColumnName(m) + ",");
                            }
                            insert_query.add(") VALUES (");
                            //insert values here
                            for (int n=mini+1; n<=noC1+mini; n++)
                            {
                            if (n != noC1+mini)
                            {   
                                if ((list1.get(n-1)).getClass().getSimpleName().equals("String"))
                                    insert_query.add("'" + list1.get(n-1) + "',");
                                else
                                    insert_query.add(list1.get(n-1) + ","); }
                            else
                                if ((list1.get(n-1)).getClass().getSimpleName().equals("String"))
                                    insert_query.add("'" + list1.get(n-1) + "')");
                                else
                                    insert_query.add(list1.get(n-1) + "'");
                            
                            }
                        }	
                            //converts the insert_query's object array to a string
                            ArrayList<String> inserts = new ArrayList<>();
                            for (Object i:insert_query)
                            	inserts.add((String) i);
                            String insert = String.join(" " , inserts);
				
                            //first prints out the insert query
                            System.out.println(insert);
                            //then executes the insert query
                            statement2.executeUpdate(insert);
                            insert_query.clear();	//clears content of insert query for fresh lookup
                    }
                    else
                    {
                        //deletes excess rows
                        delete_query = "DELETE FROM " + current_table + " WHERE " + 
                                metaData2.getColumnName(1) + " = " + list2.get(list1.size());
                        statement2.executeUpdate(delete_query);     
                    }
                }
            }
            }
	}
	catch (SQLException sqlException)
	{
            //throws an exception here if comparison of databases is logically impossible
            sqlException.printStackTrace();
            throw new IllegalStateException("Discrepancies exist in both databases!");
	}
    }
}
