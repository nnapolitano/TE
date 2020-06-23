package com.techelevator.projects.model;

import java.util.Objects;

public class Department {

	private Long id;
	private String name;

	public Department() {
	}



	public Department(Long id, String name) {
		this.id = id;
		this.name = name;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Department)) return false;
		Department department = (Department) o;
		return Objects.equals(getId(), department.getId()) &&
				Objects.equals(getName(), department.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public String toString() {
		return "Department{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
