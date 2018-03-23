package com.learners.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.learners.models.enums.LessonType;

import lombok.Data;

@Data
@Entity
@Table(name = "lessons_list")
public class LessonsList implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.ORDINAL)
	private LessonType lessontype;
	
	@Column(name="lesson_english",length = 1000)
	private String leassonEn;
	
	@Column(name="lesson_sinhala",length = 1000)
	private String lessonSi;
	
	@OneToMany(mappedBy = "lessonList",fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
	private Set<CompleteLecture> lesList;
	
}
