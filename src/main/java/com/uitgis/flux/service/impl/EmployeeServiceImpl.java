package com.uitgis.flux.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uitgis.flux.entity.Employee;
import com.uitgis.flux.repo.EmployeeRepository;
import com.uitgis.flux.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepo;

	public void create(Employee e) {
		employeeRepo.save(e).subscribe();
	}

	public Mono<Employee> findById(Integer id) {
		return employeeRepo.findById(id);
	}

	public Flux<Employee> findByName(String name) {
		return employeeRepo.findByName(name);
	}

	public Flux<Employee> findAll() {
		return employeeRepo.findAll();
	}

	public Mono<Employee> update(Employee e) {
		return employeeRepo.save(e);
	}

	public Mono<Void> delete(Integer id) {
		return employeeRepo.deleteById(id);
	}
}
