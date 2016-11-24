package Data;

import java.sql.*;

public class DataQuery extends DataAccess
{	
	public Integer[] ArrayInt;
	
	public String queryString(String sql, String field) 
    {
        String result = null;
        try (
        	Connection conn = this.connect();	
        	Statement stmt = conn.prepareStatement(sql);
        	ResultSet rs  = stmt.executeQuery(sql);
        	){
           	result = rs.getString(field);
           	stmt.close();
            conn.close();
       		} 
        catch (SQLException e) 
        	{
        	//System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        	//System.exit(0);
        	}
		return result;
    }
		
		public Integer queryInt(String sql, String field) 
	    {
	        Integer result = null;
	        try (
	        	Connection conn = this.connect();	
	        	Statement stmt = conn.prepareStatement(sql);
	        	ResultSet rs  = stmt.executeQuery(sql);
	        	){
	           	result = rs.getInt(field);
	           	stmt.close();
	            conn.close();
	       		} 
	        catch (SQLException e) 
	        	{
	        	//System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        	//System.exit(0);
	        	}
			return result;  
	    }
		
	public Integer[] queryArrayInt(String sql, String field) 
    {
		try (
				Connection conn = this.connect();	
		        Statement stmt = conn.createStatement();
		        ResultSet rs  = stmt.executeQuery(sql);
		        ){
           		Integer i = 0;
           		DataCount count = new DataCount();
           		this.ArrayInt = new Integer[count.count("SELECT COUNT(*) AS length FROM Table1 WHERE Subject = 'Irish' OR Subject = 'Maths'")];
           		while(rs.next())
				{
					ArrayInt[i] = rs.getInt(field);
					System.out.println(ArrayInt[i]);
					i++;
				}
           		stmt.close();
           		conn.close();
       		} 
        catch (SQLException e) 
    	{
    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    	//System.exit(0);
    	}
		return ArrayInt;
    }
	public static void main(String[] args)
	{
		DataQuery test = new DataQuery();
		System.out.println(test.queryArrayInt("SELECT rowid FROM Table1 WHERE Subject = 'Irish' OR Subject = 'Maths'", "rowid"));
	}
}
