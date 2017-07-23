package com.learners.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "trail_detail")
public class TrailDetail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany(mappedBy="trailDetail",cascade=CascadeType.REMOVE,fetch = FetchType.EAGER)
	private Set<TrailVehicalClass> tVClass;
	
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private RegistrationDetail regDetail;
}
