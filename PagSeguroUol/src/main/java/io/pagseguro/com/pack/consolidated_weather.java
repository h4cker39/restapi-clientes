package io.pagseguro.com.pack;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class consolidated_weather implements Serializable {
	       //consolidated_weather


	private List<Long> id;

	private List<String> weather_state_name;

	private List<String> weather_state_abbr;

	private List<String> wind_direction_compass;

	private List<String> created;

	private List<String> applicable_date;
	
	private List<Float> min_temp;
	
	private List<Float> max_temp;
	
	private List<Float> the_temp;
	
	private List<Float> wind_speed;
	
	private List<Float> wind_direction;
	
	private List<Float> air_pressure;
	
	private List<Integer> humidity;
	
	private List<Float> visibility;
	
	private List<Integer> predictability;
	
	
	private String time;
	
	private String sun_rise;
	
	private String sun_set;
	
	private String timezone_name;
	
	private Parent parent;
	
	
	public List<Long> getId() {
		return id;
	}





	public void setId(List<Long> id) {
		this.id = id;
	}





	public List<String> getWeather_state_name() {
		return weather_state_name;
	}





	public void setWeather_state_name(List<String> weather_state_name) {
		this.weather_state_name = weather_state_name;
	}





	public List<String> getWeather_state_abbr() {
		return weather_state_abbr;
	}





	public void setWeather_state_abbr(List<String> weather_state_abbr) {
		this.weather_state_abbr = weather_state_abbr;
	}





	public List<String> getWind_direction_compass() {
		return wind_direction_compass;
	}





	public void setWind_direction_compass(List<String> wind_direction_compass) {
		this.wind_direction_compass = wind_direction_compass;
	}





	public List<String> getCreated() {
		return created;
	}





	public void setCreated(List<String> created) {
		this.created = created;
	}





	public List<String> getApplicable_date() {
		return applicable_date;
	}





	public void setApplicable_date(List<String> applicable_date) {
		this.applicable_date = applicable_date;
	}





	public List<Float> getMin_temp() {
		return min_temp;
	}





	public void setMin_temp(List<Float> min_temp) {
		this.min_temp = min_temp;
	}





	public List<Float> getMax_temp() {
		return max_temp;
	}





	public void setMax_temp(List<Float> max_temp) {
		this.max_temp = max_temp;
	}





	public List<Float> getThe_temp() {
		return the_temp;
	}





	public void setThe_temp(List<Float> the_temp) {
		this.the_temp = the_temp;
	}





	public List<Float> getWind_speed() {
		return wind_speed;
	}





	public void setWind_speed(List<Float> wind_speed) {
		this.wind_speed = wind_speed;
	}





	public List<Float> getWind_direction() {
		return wind_direction;
	}





	public void setWind_direction(List<Float> wind_direction) {
		this.wind_direction = wind_direction;
	}





	public List<Float> getAir_pressure() {
		return air_pressure;
	}





	public void setAir_pressure(List<Float> air_pressure) {
		this.air_pressure = air_pressure;
	}





	public List<Integer> getHumidity() {
		return humidity;
	}





	public void setHumidity(List<Integer> humidity) {
		this.humidity = humidity;
	}





	public List<Float> getVisibility() {
		return visibility;
	}





	public void setVisibility(List<Float> visibility) {
		this.visibility = visibility;
	}





	public List<Integer> getPredictability() {
		return predictability;
	}





	public void setPredictability(List<Integer> predictability) {
		this.predictability = predictability;
	}





	@Override
	public String toString() {
		return "consolidated_weather{" + "id='"+id + '\'' 
				+ ",weather_state_name=" + weather_state_name + '\'' 
				+ ",weather_state_abbr=" + weather_state_abbr + '\''
				+  ",wind_direction_compass=" + wind_direction_compass + '\''+
				",created=" + created + '\'' +
				",applicable_date=" + applicable_date + '\''+
				",min_temp=" + min_temp + '\'' + 
				",max_temp=" + max_temp + '\'' +
				",the_temp=" + the_temp + '\'' +
				",wind_speed=" + wind_speed + '\'' +
				".wind_direction=" + wind_direction + '\'' +
				"air_pressure=" + air_pressure + '\'' +
				"humidity=" + humidity +'\'' +
				"visibility=" + visibility + '\'' +
				"predictability=" + predictability +
				
				'}';
	}		
}
