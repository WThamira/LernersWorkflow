package com.learners.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.learners.models.Invoice;

public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Long>{

}
