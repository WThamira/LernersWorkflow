package com.learners.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.learners.models.PersonalDetail;

public interface PersonalDetailRepository extends PagingAndSortingRepository<PersonalDetail, Long>{

}
