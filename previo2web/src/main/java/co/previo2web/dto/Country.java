package co.previo2web.dto;

import java.io.Serializable;

import lombok.Data;

@Data 
public class Country implements Serializable {
	
	public String id;
	public String name;
	
	public Country() {
		
	}
	
	

	public Country(String id, String name) {
		//super();
		this.id = id;
		this.name = name;
	}
	
	public Country(String name) {
		//super();
		this.name = name;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
