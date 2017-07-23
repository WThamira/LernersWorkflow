package com.learners.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.learners.models.Role;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
	List<Role> findAll();
	Role findOneByName(String name);
}
