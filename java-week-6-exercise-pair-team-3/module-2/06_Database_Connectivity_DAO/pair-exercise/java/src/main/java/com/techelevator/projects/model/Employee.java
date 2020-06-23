package com.techelevator.projects.model;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
	private Long employeeId;
	private Long departmentId;
	private String firstName;
	private String lastName;
	private LocalDate birthDay;
	private char gender;
	private LocalDate hireDate;

	public Employee() {
	}

	public Employee(Long employeeId, Long departmentId, String firstName, String lastName, LocalDate birthDay, char gender, LocalDate hireDate) {
		this.employeeId = employeeId;
		this.departmentId = departmentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.gender = gender;
		this.hireDate = hireDate;
	}

	public Long getId() {
		return employeeId;
	}
	public void setId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Employee)) return false;
		Employee employee = (Employee) o;
		return getGender() == employee.getGender() &&
				Objects.equals(employeeId, employee.employeeId) &&
				Objects.equals(getDepartmentId(), employee.getDepartmentId()) &&
				Objects.equals(getFirstName(), employee.getFirstName()) &&
				Objects.equals(getLastName(), employee.getLastName()) &&
				Objects.equals(getBirthDay(), employee.getBirthDay()) &&
				Objects.equals(getHireDate(), employee.getHireDate());
	}


	@Override
	public int hashCode() {
		return Objects.hash(employeeId, getDepartmentId(), getFirstName(), getLastName(), getBirthDay(), getGender(), getHireDate());
	}


	@Override
	public String toString() {
		return "Employee{" +
				"employeeId=" + employeeId +
				", departmentId=" + departmentId +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", birthDay=" + birthDay +
				", gender=" + gender +
				", hireDate=" + hireDate +
				'}';
	}
}
