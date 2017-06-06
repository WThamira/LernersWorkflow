package com.learners.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.learners.models.User;

public interface UserRepository extends PagingAndSortingRepository<User, String>{

}
