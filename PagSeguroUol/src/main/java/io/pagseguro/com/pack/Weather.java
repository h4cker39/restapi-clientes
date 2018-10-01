package io.pagseguro.com.pack;

import java.io.Serializable;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Weather implements Serializable {
  
	
	 private String title;
	 private String location_type;
	 private int woeid;
	 private String latt_long;
	 
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getLocation_type() {
		return location_type;
	}
	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}
     
	public int getWoeid() {
		return woeid;
	}
	public void setWoeid(int woeid) {
		this.woeid = woeid;
	}
	public String getLatt_long() {
		return latt_long;
	}
	public void setLatt_long(String latt_long) {
		this.latt_long = latt_long;
	}
	 
	 @Override
	 public String toString() {
		 
		return "{" +
		             "title=' " + title + '\''
				      +",location_type=" + location_type + '\''+
				       ",woeid=" + woeid + '\''+
				       ",latt_long=" + latt_long + '\'' 
				       + '}';
	 }
}
