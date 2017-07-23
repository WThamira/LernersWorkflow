package com.learners.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.learners.models.LPermit;

public interface LPermitRepository extends PagingAndSortingRepository<LPermit, Long> {

}
