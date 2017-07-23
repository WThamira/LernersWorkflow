package com.learners.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.learners.models.PersonalDetail;;

public interface PersonalDetailRepository extends PagingAndSortingRepository<PersonalDetail, String>{
	PersonalDetail findOneByNicAndUserRolesName(@Param("nic")String nic,@Param("name")String name);
	
	
	PersonalDetail findOneByNic(@Param("nic")String nic);

}
