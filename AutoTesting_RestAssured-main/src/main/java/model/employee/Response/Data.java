package model.employee.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data{

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	@JsonProperty("salary")
	private String salary;

	@JsonProperty("age")
	private String age;

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public String getSalary(){
		return salary;
	}

	public String getAge(){
		return age;
	}
}