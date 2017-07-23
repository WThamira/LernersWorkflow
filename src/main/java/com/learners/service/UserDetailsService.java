package com.learners.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.learners.models.User;
import com.learners.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Authenticate a user from the database.
 */
@Slf4j
@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Inject
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(final String login) {
		log.debug("Authenticating {}", login);
		String lowercaseLogin = login.toLowerCase();
		Optional<User> userFromDatabase = userRepository.findOneByUserName(lowercaseLogin);
		return userFromDatabase.map(user -> {
//			if (!user.getActivated()) {
//				throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
//			}
			List<GrantedAuthority> grantedAuthorities = user.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
			return new org.springframework.security.core.userdetails.User(lowercaseLogin, user.getPassword(),
					grantedAuthorities);
		}).orElseThrow(
				() -> new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the " + "database"));
	}// End loadUserByUsername()
	
}// End class UserDetailsService
