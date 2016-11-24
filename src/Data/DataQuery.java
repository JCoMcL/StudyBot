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
		
	public void queryArrayInt(String sql, String field) 
    {	
		 try (
		        Connection conn = this.connect();	
		        Statement stmt = conn.prepareStatement(sql);
		        ResultSet rs  = stmt.executeQuery(sql);
		        ){
           		Integer i = 0;
           		this.ArrayInt = new Integer[rs.getFetchSize()];
           		while(rs.next())
				{
					ArrayInt[i] = rs.getInt(field);
					i++;
				}
           		stmt.close();
           		conn.close();
       		} 
        catch (SQLException e) 
    	{
    	//System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    	//System.exit(0);
    	}   
    }
}
