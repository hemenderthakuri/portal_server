package com.job.portal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "job_id")
	private JobPost job;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users candidate;
	
	private Date createdOn;
	private Date updatedOn;
	private String status;
	
	public Application() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JobPost getJob() {
		return job;
	}

	public void setJob(JobPost job) {
		this.job = job;
	}

	public Users getCandidate() {
		return candidate;
	}

	public void setCandidate(Users candidate) {
		this.candidate = candidate;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
