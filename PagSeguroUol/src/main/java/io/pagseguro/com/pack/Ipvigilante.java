package io.pagseguro.com.pack;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Ipvigilante implements Serializable {
	
	
	private String status;

	@Column(columnDefinition="clob")
	private Data data;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	
	@Override 
	public String toString() {
		return "{" + 
	              "status='" + status +'\''
				+ ", Data=" + data +
				'}';
				
	}
	
}
