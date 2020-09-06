package com.job.portal.service;

import java.util.List;

import com.job.portal.common.JobStatus;
import com.job.portal.model.Application;
import com.job.portal.model.JobPost;

public interface RecruiterService {

	JobPost postJob(JobPost job);
	
	List<JobPost> getJobPosts(int userId);
	
	JobPost getJobPost(int jobId);
	
	List<Application> getApplications(int jobId);
	
	Application changeApplicationStatus(int applicationId, JobStatus status);
}
