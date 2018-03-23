package com.learners.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.learners.models.Invoice;

public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Long>{
	
	Invoice findOneByRegDetailPdetailsNic(@Param("nic") String nic); 
}
