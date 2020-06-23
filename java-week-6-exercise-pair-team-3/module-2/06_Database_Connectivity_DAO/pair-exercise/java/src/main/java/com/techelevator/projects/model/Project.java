package com.techelevator.projects.model;

import java.time.LocalDate;
import java.util.Objects;

public class Project {
	private Long id;
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;

	public Project(Long id, String name, LocalDate startDate, LocalDate endDate) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Project() {
	}

	public Project(Long id, String name) {
		this(id, name, null, null);
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Project)) return false;
		Project project = (Project) o;
		return Objects.equals(id, project.id) &&
				Objects.equals(name, project.name) &&
				Objects.equals(startDate, project.startDate) &&
				Objects.equals(endDate, project.endDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, startDate, endDate);
	}

	@Override
	public String toString() {
		return "Project{" +
				"id=" + id +
				", name='" + name + '\'' +
				", startDate=" + startDate +
				", endDate=" + endDate +
				'}';
	}

}
