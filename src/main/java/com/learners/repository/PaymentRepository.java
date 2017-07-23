package com.learners.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.learners.models.Payment;

public interface PaymentRepository extends PagingAndSortingRepository<Payment, Long>{

}
