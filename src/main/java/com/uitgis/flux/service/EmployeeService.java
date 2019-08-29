package com.uitgis.flux.service;

import com.uitgis.flux.entity.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
	public void create(Employee e);

	public Mono<Employee> findById(Integer id);

	public Flux<Employee> findByName(String name);

	public Flux<Employee> findAll();

	public Mono<Employee> update(Employee e);

	public Mono<Void> delete(Integer id);
}
