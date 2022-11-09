package model.employee.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeResponse {

	@JsonProperty("data")
	private Data data;

	@JsonProperty("message")
	private String message;

	@JsonProperty("status")
	private String status;

	public Data getData(){
		return data;
	}

	public String getMessage(){
		return message;
	}

	public String getStatus(){
		return status;
	}
}