package thuissensoren;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.json.JSONObject;

import thuissensoren.model.Measurement;

public class DataMine {
	
	String ip = "http://192.168.2.109";
	
	ThuisSensorenHttpClient thuisSensorenHttpClient = new ThuisSensorenHttpClient(ip);
	
	public static final ZoneId ZONEID = ZoneId.of("Europe/Amsterdam");
	
	private ThuisSensorenRepository thuisSensorenRepository;
	
	public DataMine(ThuisSensorenRepository thuisSensorenRepository) {
		this.thuisSensorenRepository = thuisSensorenRepository;
	}
	
	public void mine() {
		System.out.println("mining...");
		JSONObject data = thuisSensorenHttpClient.getResource("/sensors");
		Measurement measurement = jsonToMeasurement(data);
		if(measurement != null) {
		thuisSensorenRepository.save(measurement);
		} else {
			System.out.println("measurement is null!");
		}
	}
	
	private Measurement jsonToMeasurement(JSONObject json) {
		ZonedDateTime recordedTime = ZonedDateTime.now();
		double TVOC = json.getDouble("TVOC");
		double eCO2 = json.getDouble("eCO2");
		double rawH2 = json.getDouble("rawH2");
		double rawEthanol = json.getDouble("rawEthanol");
		double temperature = json.getDouble("Temperature");
		double relative_humidity = json.getDouble("Relative Humidity");
		double absolute_humidity = json.getDouble("Absolute Humidity");
		int ESP8266 = json.getInt("ESP8266");
		
		
		return new Measurement(recordedTime,TVOC,eCO2,rawH2,rawEthanol,temperature,relative_humidity,absolute_humidity,ESP8266);
	}
}
