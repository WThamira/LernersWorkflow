package com.learners.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

import com.learners.models.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{
	
	User findFirstByUserName(@Param("userName") String userName);

	@PreAuthorize("@userRepository.findFirstByUserName(#userName)?.userName == authentication?.name")
	User findByUserName(@Param("userName") String userName);

	Optional<User> findOneByUserName(@Param("userName") String userName);
	

	User findOneByRolesNameAndPersonalDetailNic(@Param("role") String name,@Param("nic") String nic);
	
	
	
}
