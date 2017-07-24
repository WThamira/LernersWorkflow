package com.learners.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "complete_lecture")
public class CompleteLecture implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "lessons_id")
	private LessonsList lessonList;

	@Id
	@ManyToOne
	@JoinColumn(name = "registration_detail_id")
	private RegistrationDetail regDetails;

	@NotNull
	@Temporal(TemporalType.DATE)
	private Date date;

}
