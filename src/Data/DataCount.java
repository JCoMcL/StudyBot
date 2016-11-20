package Data;

import java.sql.*;

public class DataCount extends DataAccess
{	
	private String sql =	"SELECT COUNT(*) AS length FROM Table1 ";
	public DataCount(String Parameters)	{sql+=Parameters;}
	
	public Integer count()
	{
        Integer Count = null;
        try (Connection conn = DataAccess.connect(); Statement stmt  = conn.createStatement(); ResultSet rs    = stmt.executeQuery(sql))
        	{
        	Count = rs.getInt("length");
        	System.out.println(Count);
        	}

        catch (SQLException e) 
    		{System.err.println( e.getClass().getName() + ": " + e.getMessage() );}
        return Count;
    }
	public static void main(String args[]){}
}