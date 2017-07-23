package com.learners.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "registration_detail")
public class RegistrationDetail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="register_number")
	private String registrationNumber;
	
	
	@Column(name="register_date")
	@Temporal(TemporalType.DATE)
	private Date registerDate;
	
	@Column(name="old_driving_licence_number")
	private String oldDrivingLicenceNumber;
	
	@Column(name="old_licence_issue_date")
	@Temporal(TemporalType.DATE)
	private Date oldLicenceIssuedate;
	
	@Column(name="ntmi_date")
	@Temporal(TemporalType.DATE)
	private Date ntmiDate;
	
	@Column(name="ntmi_number",length = 100)
	private String ntmiNumber;
	
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	private PersonalDetail pdetails;
	
	@OneToMany(mappedBy="regDetail",cascade=CascadeType.REMOVE)
	private Set<RequestVehicalClass> reqClass;
	
	@OneToMany(mappedBy="registrationDetail",cascade=CascadeType.REMOVE)
	private Set<LPermit> lpermit;
	
	@OneToMany(mappedBy="regDetail",cascade=CascadeType.REMOVE)
	private Set<TrailDetail> trailDetail;
	
	@OneToMany(mappedBy="regDetail",cascade=CascadeType.REMOVE)
	private Set<Exam> examDetail;
	
	@OneToMany(mappedBy="regDetail",cascade=CascadeType.REMOVE)
	private Set<Invoice> invoice;
	
	@OneToMany(mappedBy = "regDetails",fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
	private Set<CompleteLecture> lecList;
}
