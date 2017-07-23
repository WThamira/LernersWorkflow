package com.learners.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.learners.models.Exam;

public interface ExamRepo extends PagingAndSortingRepository<Exam, Long>{

}
