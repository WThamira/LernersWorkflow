package com.learners.repository;

import java.util.Optional;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

import com.learners.models.QUser;
import com.learners.models.User;
import com.querydsl.core.types.dsl.StringPath;



public interface UserRepository extends PagingAndSortingRepository<User, Long>,QueryDslPredicateExecutor<User>,QuerydslBinderCustomizer<QUser> {

	User findFirstByUserName(@Param("userName") String userName);

	@PreAuthorize("@userRepository.findFirstByUserName(#userName)?.userName == authentication?.name")
	User findByUserName(@Param("userName") String userName);

	Optional<User> findOneByUserName(@Param("userName") String userName);

	User findOneByRolesNameAndPersonalDetailNic(@Param("role") String name, @Param("nic") String nic);
	

    @Override
    default public void customize(QuerydslBindings bindings, QUser root) {
        bindings.bind(String.class).first(
          (StringPath path, String value) -> path.containsIgnoreCase(value));
        bindings.excluding(root.email);
    }
}
