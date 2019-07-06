package com.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.ws.rs.ext.ParamConverter.Lazy;

/**
 * Entity implementation class for Entity: Host
 *
 */
@Entity

public class Host implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column
	private String fullname;
	
	
	 
	
	 @OneToMany(cascade=CascadeType.ALL  , mappedBy="host" , fetch = FetchType.EAGER)
	 private List<Guest> guests;
	
	
	
	public Host() {
		super();
	}



	public Host( int id, String fullname) {
		super();
		this.fullname = fullname;
		this.id = id;
	}
	
	public Host( int id) {
		super();
		this.id = id;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFullname() {
		return fullname;
	}



	public void setFullname(String fullname) {
		this.fullname = fullname;
	}



	public List<Guest> getGuests() {
		return guests;
	}



	public void setGuests(List<Guest> guests) {
		this.guests = guests;
	}




	  @Override public String toString() { 
		  return "Host [id=" + id + ", fullname=" + fullname + ", guests=" + guests + "]"; 
		  }
	
	
	
	
	
	
	
	
   
}
