package com.job.portal.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.portal.common.JobStatus;
import com.job.portal.dao.ApplicationRepository;
import com.job.portal.dao.JobRepository;
import com.job.portal.model.Application;
import com.job.portal.model.JobPost;
import com.job.portal.service.RecruiterService;

@Service
public class RecruiterServiceImpl implements RecruiterService {

	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private ApplicationRepository applicationRepository;

	@Override
	public JobPost postJob(JobPost job) {
		job.setCreatedOn(new Date());
		return jobRepository.save(job);
	}

	@Override
	public List<JobPost> getJobPosts(int userId) {

		return jobRepository.getByOwner(userId);
	}

	@Override
	public List<Application> getApplications(int jobId) {

		return applicationRepository.getByJobId(jobId);
	}

	@Override
	public Application changeApplicationStatus(int applicationId, JobStatus status) {
		Application application = applicationRepository.findById(applicationId).get();
		application.setStatus(status.name());
		application.setUpdatedOn(new Date());

		return applicationRepository.save(application);
	}

	@Override
	public JobPost getJobPost(int jobId) {
		return jobRepository.findById(jobId).get();
	}

}
