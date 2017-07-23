package com.learners.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.learners.models.enums.VehicleClasses;

import lombok.Data;


@Data
@Entity
@Table(name = "l_permit_vehical_class")
public class LPermitVehicalClass implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.ORDINAL)
	private VehicleClasses vehicleClass;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfIssue;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfexpired;
	
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private LPermit lPermit;
	

}
