package Data;

import java.sql.*;

public class DataInsert extends DataAccess{

	public void insert(String sql) 
    {
        try (Connection conn = this.connect();	Statement stmt = conn.createStatement()) 
        	{           	
           	stmt.executeUpdate(sql);
           	stmt.close();
            conn.commit();
            conn.close();
       		} 
        catch (SQLException e) 
        	{
        	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        	//System.exit(0);
        	}
        System.out.println("Insert Operation Successful");
    }
}

