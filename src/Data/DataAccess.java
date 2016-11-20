package Data;

import java.sql.*;

public class DataAccess {

	public static Connection connect() 
		{
        String url = "jdbc:sqlite:SBData1.db";
        Connection conn = null;
        try 						
        	{conn = DriverManager.getConnection(url);} 
        catch (SQLException e) 		
        	{/*System.out.println(e.getMessage());*/}
        //System.out.println("Connected");
        return conn;
        }

}

