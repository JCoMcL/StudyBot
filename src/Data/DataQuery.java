package Data;

import java.sql.*;

public class DataQuery {
	public String sql;
	public DataQuery(String Select, String Where, String Equals)
	{
		sql = "SELECT "+Select+" FROM Table1 WHERE "+Where+" = "+Equals;
	}
	public String queryString(Integer row) 
    {
        String result = null;
 
        try (
        	Connection conn = DataAccess.connect();	
        	Statement stmt = conn.prepareStatement(sql);
        	ResultSet rs  = stmt.executeQuery(sql);
        	){
           	result = rs.getString("Desc1");
           	
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
		
	public Integer[] queryArrayInt(String Subject) 
    {
		DataCount countSubject = new DataCount("WHERE Subject = '"+Subject+"'");
        Integer[] result = new Integer[countSubject.count()];
        try (Connection conn = DataAccess.connect();	PreparedStatement pstmt = conn.prepareStatement(sql)) 
        	{
           		pstmt.setString(1, Subject);
           		ResultSet rs  = pstmt.executeQuery();
           		Integer i = 0;
           		while(rs.next())
				{
					result[i] = rs.getInt("rowid");
					i++;
				}
           		pstmt.close();
           		conn.close();
       		} 
        catch (SQLException e) 
    	{
    	//System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    	//System.exit(0);
    	}
        return result;
    }
	public static void main(String[] args) 
	{}
}
