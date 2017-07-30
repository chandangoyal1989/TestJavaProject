import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DataMigration
{
	void getAndPushData() throws SQLException, ParseException
	{
		int count=0;
		String gpsIMEI=null;
		Connection mysqlconn= (Connection) MySQLUtility.getConnection();
		
		Statement mysqlsmt=(Statement) mysqlconn.createStatement();
		ResultSet rs=mysqlsmt.executeQuery("select * from tbProcessedData where IMEI = '009592327938' OR IMEI='007508979643' OR IMEI = '008588004145'" );
		ResultSet rs1=mysqlsmt.executeQuery("select VehicleNumber,IMEI from tbvehicle where customerid='shinder'");
		
		DeviceData devicedata=new DeviceData();
		HashMap<String, String> vehicalNoIMEIMap=new HashMap<String,String>();
		while(rs1.next())
		{
			vehicalNoIMEIMap.put(rs1.getString(2), rs1.getString(1));
		}
		
		
		while(rs.next())
		{
		System.out.println(rs.getDouble(18));
		rs.next();
		gpsIMEI=rs.getString(2);
		devicedata.setImei(gpsIMEI);
		devicedata.setSpeed(rs.getDouble(3));
		devicedata.setDirection(rs.getDouble(4));
		devicedata.setFuel(rs.getDouble(5));
		devicedata.setTemprature(rs.getDouble(6));
		
		if(new Integer(rs.getInt(7))!=null &&new Integer(rs.getInt(7))==1 )
			devicedata.setIgnition(true);
		else
			devicedata.setIgnition(false);
		
		if(new Integer(rs.getInt(8))!=null &&new Integer(rs.getInt(8))==1)
			devicedata.setAc(true);
		else
			devicedata.setAc(false);
		
		if(new Integer(rs.getInt(9))!=null &&new Integer(rs.getInt(9))==1)
			devicedata.setDevicePower(true);
		else
			devicedata.setDevicePower(false);
		
		if(new Integer(rs.getInt(10))!=null &&new Integer(rs.getInt(10))==1)
			devicedata.setSimStatus(true);
		else
			devicedata.setSimStatus(false);
		
		if(new Integer(rs.getInt(11))!=null &&new Integer(rs.getInt(11))==1)
			devicedata.setDoorStatus(true);
		else
			devicedata.setDoorStatus(false);
		
		if(new Integer(rs.getInt(12))!=null &&new Integer(rs.getInt(12))==1)
			devicedata.setLightStatus(true);
		else
			devicedata.setLightStatus(false);
		
		if(new Integer(rs.getInt(13))!=null &&new Integer(rs.getInt(13))==1)
			devicedata.setSos(true);
		else
			devicedata.setSos(false);
		
		if(new Integer(rs.getInt(14))!=null &&new Integer(rs.getInt(14))==1)
			devicedata.setLoadStatus(true);
		else
			devicedata.setLoadStatus(false);			
		
		devicedata.setLatitude(rs.getDouble(15));
		devicedata.setLongitude(rs.getDouble(16));
		devicedata.setDistance(rs.getDouble(18));
		devicedata.setSimNo(rs.getLong(19));
		devicedata.setBattery(rs.getDouble(23));
		
		String datetime=rs.getString(24);
		SimpleDateFormat simpleDateFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		
		devicedata.setDateTime(simpleDateFmt.parse(datetime));
		devicedata.setSatellite(rs.getInt(25));
		devicedata.setGsmSignal(rs.getInt(26));
		
		if(rs.getString(27)!=null)
			devicedata.setTamper(true);
		else
			devicedata.setTamper(false);
		
		
		devicedata.setSensor(rs.getDouble(28));
		devicedata.setStringType(rs.getString(29));
		
		devicedata.setVehicalNo(vehicalNoIMEIMap.get(gpsIMEI));
		
		GPSDataDAO dao=new GPSDataDAO();
		dao.insertDeviceData(devicedata);

		count++;
		
		System.out.println("Record migrated from Mysql to mongodb :"+count);
	}
		
		rs.close();
		rs1.close();
		mysqlconn.close();
		MySQLUtility.closeConnection(mysqlconn);
	}
	public static void main(String args[]) throws SQLException, ParseException
	{
		DataMigration dm=new DataMigration();
		dm.getAndPushData();
	}

}
