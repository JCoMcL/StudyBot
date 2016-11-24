package Data;

import java.sql.*;

public class DataCount extends DataAccess
{		
	public Integer count(String sql)
	{
        Integer Count = null;
        try (Connection conn = this.connect(); Statement stmt  = conn.createStatement(); ResultSet rs    = stmt.executeQuery(sql))
        	{
        	Count = rs.getInt("length");
        	System.out.println(Count);
        	}

        catch (SQLException e) 
    		{System.err.println( e.getClass().getName() + ": " + e.getMessage() );}
        return Count;
    }
}