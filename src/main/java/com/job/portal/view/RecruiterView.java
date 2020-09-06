package com.job.portal.view;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.job.portal.core.IPortalView;
import com.job.portal.model.Application;
import com.job.portal.model.JobPost;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecruiterView implements IPortalView{
	
	private JobPost job;
	private List<JobPost> jobs;
	private List<Application> applications;
	private Application application;
	
	public RecruiterView() {}

	public JobPost getJob() {
		return job;
	}

	public void setJob(JobPost job) {
		this.job = job;
	}

	public List<JobPost> getJobs() {
		return jobs;
	}

	public void setJobs(List<JobPost> jobs) {
		this.jobs = jobs;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}
		

}
