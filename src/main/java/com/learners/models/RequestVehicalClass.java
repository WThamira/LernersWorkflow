package com.learners.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import com.learners.models.enums.WorkType;

import lombok.Data;


@Data
@Entity
@Table(name = "request_vehical_class")
public class RequestVehicalClass implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.ORDINAL)
	private VehicleClasses vehicleClass;
	
	@Enumerated(EnumType.ORDINAL)
	private WorkType workType;
	
	@Column(name="old_vehical_class_register_date")
	@Temporal(TemporalType.DATE)
	private Date oldVehicalClassRegisterDate;
	
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private RegistrationDetail regDetail;
	

}
