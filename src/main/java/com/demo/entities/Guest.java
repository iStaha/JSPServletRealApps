package com.demo.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Guest implements Serializable {
    private static final long serialVersionUID = 1L;

    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
    private String name;
    private Date signingDate;
    
    
    @ManyToOne
    @JoinColumn(name="host_id", nullable=false)
	private Host host;
	


	public Guest() {
		super();
	}




	public Guest(String name , Host host ) {
        this.name = name;
        this.signingDate = new Date(System.currentTimeMillis());
	    this.host = host; 
    }
    
    
    

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getSigningDate() {
		return signingDate;
	}

	public void setSigningDate(Date signingDate) {
		this.signingDate = new Date(System.currentTimeMillis());
	}

	public Host getHost() {
		return host;
	}

	public void setHost(Host host) {
		this.host = host;
	}

	// String Representation:
    @Override
    public String toString() {
        return name + " (signed on " + signingDate + ")";
    }
}