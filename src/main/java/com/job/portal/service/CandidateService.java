package com.job.portal.service;

import java.util.List;

import com.job.portal.core.exception.BusinessLogicException;
import com.job.portal.model.Application;
import com.job.portal.model.JobPost;

public interface CandidateService {

	Application applyJob(int jobId, int userId) throws BusinessLogicException;

	List<Application> getApplications(int userId);

	Application getApplication(int applicationId);
	
	List<JobPost> getJobs();

}
