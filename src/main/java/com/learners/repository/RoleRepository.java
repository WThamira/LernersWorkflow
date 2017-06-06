package com.learners.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.learners.models.Role;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long>{

}
