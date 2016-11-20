package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataCheck 
{
	public static Boolean Match(Integer Id, String Desc2)
	{
		String sql = "SELECT COUNT(*) AS length FROM Table1 WHERE rowid = ? AND Desc2 = ?";
        Boolean result = true;
		
		try (Connection conn = DataAccess.connect();	PreparedStatement pstmt = conn.prepareStatement(sql)) 
    	{
			pstmt.setString(1, ""+Id);
			pstmt.setString(2, Desc2);
			ResultSet rs  = pstmt.executeQuery();
			if(rs.getInt("length") == 0)	{result = false;}
       	
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
}
