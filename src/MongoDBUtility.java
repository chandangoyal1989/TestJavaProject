
import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoDBUtility 
{
	private static MongoClient conn=new MongoClient("192.168.1.3", 27017);
	
	@SuppressWarnings("deprecation")
	public static DB getConnection()
	{
		DB db=null;
		try
		{
			db = conn.getDB("gpstycoon");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return db;
	}
	public static void closeConnection(MongoClient conn)
	{
    	
    	if(conn!=null)
    	{
			try 
			{
				conn.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
    }
	
	
}
