package thuissensoren.model;

import java.time.ZonedDateTime;

import javax.persistence.*;

@Entity
@Table(name = "measurement")
public class Measurement {

	
	private ZonedDateTime recordedTime;
	

	private double TVOC;
	

	private double eCO2;
	

	private double rawH2;
	

	private double rawEthanol;
	

	private double temperature;
	

	private double relative_humidity;
	

	private double absolute_humidity;
	

	private int ESP8266;
	

	private String measurementId;
	
	public Measurement() {};

	public Measurement(ZonedDateTime recordedTime, double tVOC, double eCO2, double rawH2, double rawEthanol,
			double temperature, double relative_humidity, double absolute_humidity, int eSP8266) {
		super();
		this.recordedTime = recordedTime;
		TVOC = tVOC;
		this.eCO2 = eCO2;
		this.rawH2 = rawH2;
		this.rawEthanol = rawEthanol;
		this.temperature = temperature;
		this.relative_humidity = relative_humidity;
		this.absolute_humidity = absolute_humidity;
		ESP8266 = eSP8266;
		this.measurementId = "room:"+eSP8266+" DateTime:"+recordedTime;
	}

	@Column(name = "recorded_time")
	public ZonedDateTime getRecordedTime() {
		return recordedTime;
	}

	public void setRecordedTime(ZonedDateTime recordedTime) {
		this.recordedTime = recordedTime;
	}

	@Column(name = "TVOC")
	public double getTVOC() {
		return TVOC;
	}

	public void setTVOC(double tVOC) {
		TVOC = tVOC;
	}

	@Column(name = "eCO2")
	public double geteCO2() {
		return eCO2;
	}

	public void seteCO2(double eCO2) {
		this.eCO2 = eCO2;
	}

	@Column(name = "rawH2")
	public double getRawH2() {
		return rawH2;
	}

	public void setRawH2(double rawH2) {
		this.rawH2 = rawH2;
	}

	@Column(name = "raw_Ethanol")
	public double getRawEthanol() {
		return rawEthanol;
	}

	public void setRawEthanol(double rawEthanol) {
		this.rawEthanol = rawEthanol;
	}

	@Column(name = "temperature")
	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	@Column(name = "relative_humidity")
	public double getRelative_humidity() {
		return relative_humidity;
	}

	public void setRelative_humidity(double relative_humidity) {
		this.relative_humidity = relative_humidity;
	}

	@Column(name = "absolute_humidity")
	public double getAbsolute_humidity() {
		return absolute_humidity;
	}

	public void setAbsolute_humidity(double absolute_humidity) {
		this.absolute_humidity = absolute_humidity;
	}

	@Column(name = "room")
	public int getESP8266() {
		return ESP8266;
	}

	public void setESP8266(int eSP8266) {
		ESP8266 = eSP8266;
	}

	@Id
	@Column(name = "measurement_id")
	public String getMeasurementId() {
		return measurementId;
	}

	public void setMeasurementId(String measurementId) {
		this.measurementId = measurementId;
	}
	
	
	
	
}
