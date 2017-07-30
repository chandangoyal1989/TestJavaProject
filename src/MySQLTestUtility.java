

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLTestUtility
{
    static public String connectionString = "jdbc:mysql://192.168.1.3:3306/";
    static public String dbName = "TestGpsTycoon";
    static String driver = "com.mysql.jdbc.Driver";
    static public String username = "root";
    static public String password = "root1234";
    
       
    public static Connection getConnection() 
    {
        Connection conn = null;
        try
        {
        	Class.forName(driver).newInstance();
        } 
        catch (ClassNotFoundException e)
        {
            System.out.println("Driver not available");
        } 
        catch (InstantiationException e)
        {
			e.printStackTrace();
		} 
        catch (IllegalAccessException e)
        {
			e.printStackTrace();
		}

        try
        {
            conn = DriverManager.getConnection(connectionString+dbName,username,password); // connection is created
        } 
        catch (SQLException sqlEx) 
        {
            sqlEx.printStackTrace();
        	try 
        	{
                conn = getConnection();
            } 
        	catch (StackOverflowError e)
        	{
                throw new StackOverflowError();
            }
        }
        catch (Exception e) 
        {
        	e.printStackTrace();
		}
      return conn;
   }


   

 
    public static void closeConnection(Connection con) 
    {

        if (con != null)
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void closeStatement(PreparedStatement ps)
    {
        if (ps != null)
        {
            try
            {
                System.out.println("Utility");
                ps.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    }

    public static void closeResultSet(ResultSet rs)
    {
        if (rs != null)
        {
            try
            {
                rs.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    }
}
