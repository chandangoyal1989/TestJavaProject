


import java.text.SimpleDateFormat;
import java.util.Date;


public class DeviceData
{
	private String imei;
	private Long simNo;
	private String vehicalNo;
	private Double latitude;
	private Double longitude;
	private Double speed;
	private Double direction;
	private Integer satellite;
	private Integer gsmSignal;
	private Double fuel;
	private Double battery;
	private Double temprature;
	private Boolean ignition;
	private Boolean ac;
	private Boolean devicePower;
	private Boolean simStatus;
	private Boolean doorStatus;
	private Boolean lightStatus;
	private Boolean sos;
	private Boolean loadStatus;
	private String dateTime;
	private Double distance;
	private Double milegae;
	private String stringType;
	private Boolean tamper;
	private Double sensor;
	private String createdOn;
	
	
	public String getVehicalNo() {
		return vehicalNo;
	}
	public void setVehicalNo(String vehicalNo) {
		this.vehicalNo = vehicalNo;
	}
	
	public String getImei() 
	{
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public Double getSpeed() {
		return speed;
	}
	public void setSpeed(Double speed) {
		this.speed = speed;
	}
	public Double getDirection() {
		return direction;
	}
	public void setDirection(Double direction) {
		this.direction = direction;
	}
	public Double getFuel() {
		return fuel;
	}
	public void setFuel(Double fuel) {
		this.fuel = fuel;
	}
	public Double getBattery() {
		return battery;
	}
	public void setBattery(Double battery) {
		this.battery = battery;
	}
	public Double getTemprature() {
		return temprature;
	}
	public void setTemprature(Double temprature) {
		this.temprature = temprature;
	}
	public Boolean isIgnition() {
		return ignition;
	}
	public void setIgnition(Boolean ignition) {
		this.ignition = ignition;
	}
	public Boolean isAc() {
		return ac;
	}
	public void setAc(Boolean ac) {
		this.ac = ac;
	}
	public Boolean isDevicePower() {
		return devicePower;
	}
	public void setDevicePower(Boolean devicePower) {
		this.devicePower = devicePower;
	}
	public Boolean isSimStatus() {
		return simStatus;
	}
	public void setSimStatus(Boolean simStatus) {
		this.simStatus = simStatus;
	}
	public Boolean isDoorStatus() {
		return doorStatus;
	}
	public void setDoorStatus(Boolean doorStatus) {
		this.doorStatus = doorStatus;
	}
	public Boolean isLightStatus() {
		return lightStatus;
	}
	public void setLightStatus(Boolean lightStatus) {
		this.lightStatus = lightStatus;
	}
	public Boolean isSos() {
		return sos;
	}
	public void setSos(Boolean sos) {
		this.sos = sos;
	}
	public Boolean isLoadStatus() {
		return loadStatus;
	}
	public void setLoadStatus(Boolean loadStatus) {
		this.loadStatus = loadStatus;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date date)
	{
		SimpleDateFormat simpleDateFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.dateTime = simpleDateFmt.format(date);
		
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Long getSimNo() {
		return simNo;
	}
	public void setSimNo(Long simNo) {
		this.simNo = simNo;
	}
	public Double getMilegae() {
		return milegae;
	}
	public void setMilegae(Double milegae) {
		this.milegae = milegae;
	}
	public String getStringType() {
		return stringType;
	}
	public void setStringType(String stringType) {
		this.stringType = stringType;
	}
	public Integer getSatellite() {
		return satellite;
	}
	public void setSatellite(Integer satellite) {
		this.satellite = satellite;
	}
	public Boolean isTamper() {
		return tamper;
	}
	public void setTamper(Boolean tamper) {
		this.tamper = tamper;
	}
	public Integer getGsmSignal() {
		return gsmSignal;
	}
	public void setGsmSignal(Integer gsmSignal) {
		this.gsmSignal = gsmSignal;
	}
	public Double getSensor() {
		return sensor;
	}
	public void setSensor(Double sensor) {
		this.sensor = sensor;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	
	
}