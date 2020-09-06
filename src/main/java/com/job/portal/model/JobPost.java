package com.job.portal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JobPost {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	private String keywords;
	private int experienceMin;
	private int experienceMax;
	private int salaryMin;
	private int salaryMax;
	private String location;
	private int owner;
	private Date createdOn;

	public JobPost() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getExperienceMin() {
		return experienceMin;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public void setExperienceMin(int experienceMin) {
		this.experienceMin = experienceMin;
	}

	public int getExperienceMax() {
		return experienceMax;
	}

	public void setExperienceMax(int experienceMax) {
		this.experienceMax = experienceMax;
	}

	public int getSalaryMin() {
		return salaryMin;
	}

	public void setSalaryMin(int salaryMin) {
		this.salaryMin = salaryMin;
	}

	public int getSalaryMax() {
		return salaryMax;
	}

	public void setSalaryMax(int salaryMax) {
		this.salaryMax = salaryMax;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


}
