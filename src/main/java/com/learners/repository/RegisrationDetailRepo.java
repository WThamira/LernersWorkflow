package com.learners.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.learners.models.RegistrationDetail;

public interface RegisrationDetailRepo extends PagingAndSortingRepository<RegistrationDetail, Long>{

}
