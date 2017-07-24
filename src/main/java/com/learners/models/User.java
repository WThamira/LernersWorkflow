package com.learners.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "user")
@RequiredArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Pattern(regexp = "^[a-z0-9]*$")
	@Size(min = 1, max = 50)
	@Column(name = "userName", length = 50, unique = true, nullable = false)
	private String userName;

	@NotNull
	@Size(min = 5, max = 60)
	@Column(name = "password", length = 60)
//	@JsonIgnore
	private String password;

	@Email
	@Column(nullable = false, unique = true)
	private String email;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="personal_detail_nic")
	private PersonalDetail personalDetail;

	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinTable(joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true) }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "id", nullable = true) })
	private Set<Role> roles = new HashSet<>();

	 public void setPassword(String password) {
	 this.password = new BCryptPasswordEncoder().encode(password);
	 }// End set Password

}
