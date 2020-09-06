package com.job.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.portal.core.ResponseStatus;
import com.job.portal.core.ResponseView;
import com.job.portal.core.exception.BusinessLogicException;
import com.job.portal.model.Application;
import com.job.portal.model.JobPost;
import com.job.portal.security.CurrentUser;
import com.job.portal.security.UserPrincipal;
import com.job.portal.service.CandidateService;
import com.job.portal.view.CandidateView;
import com.job.portal.view.RecruiterView;

@RestController
@RequestMapping("/api/candidate/")
public class CandidateController extends AbstractController {

	@Autowired
	private CandidateService candidateService;

	@GetMapping("apply/{id}")
	public ResponseView apply(@CurrentUser UserPrincipal currentUser, @PathVariable("id") int jobId)
			throws BusinessLogicException {
		ResponseView responseView;
		CandidateView view = new CandidateView();

		Application application = candidateService.applyJob(jobId, currentUser.getId());
		view.setApplication(application);

		responseView = getResponseView(HttpStatus.OK.value(), ResponseStatus.SUCCESS, "Job applied successfully", view);
		return responseView;

	}

	@GetMapping("applications")
	public ResponseView getMyApplications(@CurrentUser UserPrincipal currentUser) {
		ResponseView responseView;
		CandidateView view = new CandidateView();

		List<Application> applications = candidateService.getApplications(currentUser.getId());
		view.setApplications(applications);

		responseView = getResponseView(HttpStatus.OK.value(), ResponseStatus.SUCCESS, "", view);
		return responseView;

	}

	@GetMapping("applications/{id}")
	public ResponseView getApplication(@PathVariable("id") int id) {
		ResponseView responseView;
		CandidateView view = new CandidateView();

		Application application = candidateService.getApplication(id);
		view.setApplication(application);

		responseView = getResponseView(HttpStatus.OK.value(), ResponseStatus.SUCCESS, "", view);
		return responseView;

	}

	// This controller will be replaced by Job search logic. Time being returning
	// all the jobs
	@GetMapping("/jobs")
	public ResponseView getJobPosts() throws Exception {
		ResponseView responseView;
		RecruiterView view = new RecruiterView();

		List<JobPost> jobs = candidateService.getJobs();

		view.setJobs(jobs);

		responseView = getResponseView(HttpStatus.OK.value(), ResponseStatus.SUCCESS, "", view);
		return responseView;

	}

}