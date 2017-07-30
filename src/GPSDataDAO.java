import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.util.JSON;

public class GPSDataDAO
{
	DB db;
	
	public void insertDeviceData(DeviceData devicedata)
	{
		try
		{
			db = MongoDBUtility.getConnection();
			DBCollection collection = db.getCollection("tbgpsdata"); 	
			Gson gson = new Gson();
			BasicDBObject obj = (BasicDBObject)JSON.parse(gson.toJson(devicedata));
	        collection.insert(obj);
	        System.out.println(obj);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
