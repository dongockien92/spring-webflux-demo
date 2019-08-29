package com.uitgis.flux.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document
@ToString
@Getter
@Setter
public class Employee {
	@Id
	private int id;
	private String name;
	private long salary;
}
