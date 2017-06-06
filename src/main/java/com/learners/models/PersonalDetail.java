package com.learners.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PersonalDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
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
	
}
