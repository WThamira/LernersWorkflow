package com.learners.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.learners.models.RegistrationDetail;

public interface RegisrationDetailRepo extends PagingAndSortingRepository<RegistrationDetail, Long>{
	RegistrationDetail findOneByPdetailsNic(@Param("nic") String nic);
}
