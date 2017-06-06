package com.learners.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nic", length = 20)
	private String nic;

	@NotNull
	@Size(min = 5, max = 60)
	@Column(name = "password", length = 60)
	private String password;

	@Email
	@Column(nullable = false, unique = true)
	private String email;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "user")
	private PersonalDetail personalDetail;

	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinTable(joinColumns = {
			@JoinColumn(name = "user_nic", referencedColumnName = "nic", nullable = true) }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "id", nullable = true) })
	private Set<Role> roles = new HashSet<>();

	// public void setPassword(String password) {
	// this.password = new BCryptPasswordEncoder().encode(password);
	// }// End set Password

}
