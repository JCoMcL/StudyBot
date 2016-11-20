package Data;

import java.sql.*;

public class DataInsert extends DataAccess{

	public void insert(String Desc1, String Desc2, String Subject, String Topic, String Type) 
    {
        String sql = "INSERT INTO Table1(Desc1,Desc2,Subject,Topic, Type) VALUES(?,?,?,?,?)";
 
        try (Connection conn = DataAccess.connect();	PreparedStatement pstmt = conn.prepareStatement(sql)) 
        	{
           	pstmt.setString(1, Desc1);
           	pstmt.setString(2, Desc2);
           	pstmt.setString(3, Subject);
           	pstmt.setString(4, Topic);
           	pstmt.setString(5, Type);
           	
           	pstmt.executeUpdate();
           	pstmt.close();
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
    public static void main(String[] args) {}
}

