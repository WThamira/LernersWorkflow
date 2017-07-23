package com.learners.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "exam")
public class Exam implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id",length = 50)
	private String id;
	
	private int mark;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private RegistrationDetail regDetail;
}
