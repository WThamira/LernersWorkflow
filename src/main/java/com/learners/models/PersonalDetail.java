package com.learners.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.learners.models.enums.BloodGroup;
import com.learners.models.enums.Gender;

import lombok.Data;

@Data
@Entity
@Table(name = "personal_detail")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nic")
public class PersonalDetail implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="nic",length = 50)
	private String nic;
	
	@NotNull
	@Column(name="full_name",length = 100)
	private String fullName;
	
	@NotNull
	@Column(name="short_name",length = 20)
	private String shortName;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	@NotNull
	@Column(name="address",length = 100)
	private String address;
	
	
	@Enumerated(EnumType.ORDINAL)
	private Gender gender;
	
	private double height;
	
	private double weight;
	
	@Enumerated(EnumType.ORDINAL)
	private BloodGroup bloodGroup;
	
	@NotNull
	@Size(min = 9, max = 12)
	@Column(name="mobile_number",length = 100)
	@Pattern(regexp = "^[0-9]*$")
	private String mobileNumber;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy="personalDetail")
	private User user;
	
	@OneToMany(mappedBy="pdetails",fetch = FetchType.LAZY)
	private Set<RegistrationDetail>  registrationDetail;

	

}
