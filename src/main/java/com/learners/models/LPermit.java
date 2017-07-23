package com.learners.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "l_permit")
public class LPermit implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id",length = 50)
	private String id;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfIssue;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfexpired;
	
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	private RegistrationDetail registrationDetail;
	
	@OneToMany(mappedBy="lPermit",cascade=CascadeType.REMOVE)
	private Set<LPermitVehicalClass> reqClass;
}
