package com.learners.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.learners.models.LessonsList;

public interface LessonsListRepository extends PagingAndSortingRepository<LessonsList, Long>{

}
