package com.uitgis.flux.repo;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.uitgis.flux.entity.Employee;

import reactor.core.publisher.Flux;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, Integer> {
	@Query("{ 'name': ?0 }")
	public Flux<Employee> findByName(final String name);
}
