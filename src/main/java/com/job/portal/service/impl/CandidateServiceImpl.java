package com.job.portal.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.portal.common.JobStatus;
import com.job.portal.core.exception.BusinessLogicException;
import com.job.portal.dao.ApplicationRepository;
import com.job.portal.dao.JobRepository;
import com.job.portal.dao.UsersRepository;
import com.job.portal.model.Application;
import com.job.portal.model.JobPost;
import com.job.portal.model.Users;
import com.job.portal.service.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private ApplicationRepository applicationRepository;

	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private JobRepository jobRepository;

	@Override
	public Application applyJob(int jobId, int userId) throws BusinessLogicException {

		Users currentUser = userRepository.findById(userId).get();
		JobPost job = jobRepository.findById(jobId).get();

		if (applicationRepository.getByJobAndCandidate(job, currentUser).size() > 0) {
			throw new BusinessLogicException("You have already applied for this job");
		}

		Application app = new Application();
		app.setJob(job);
		app.setCandidate(currentUser);
		app.setStatus(JobStatus.APPLICATION_SUBMITTED.name());
		app.setCreatedOn(new Date());
		app.setUpdatedOn(new Date());
		return applicationRepository.save(app);
	}

	@Override
	public List<Application> getApplications(int userId) {
		return applicationRepository.getByCandidate(userRepository.findById(userId).get());
	}

	@Override
	public Application getApplication(int applicationId) {

		return applicationRepository.findById(applicationId).get();
	}

	@Override
	public List<JobPost> getJobs() {
		return jobRepository.findAll();
	}

}
