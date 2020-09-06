package com.job.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.portal.core.ResponseStatus;
import com.job.portal.core.ResponseView;
import com.job.portal.dto.ApplicationStatusDTO;
import com.job.portal.model.Application;
import com.job.portal.model.JobPost;
import com.job.portal.security.CurrentUser;
import com.job.portal.security.UserPrincipal;
import com.job.portal.service.RecruiterService;
import com.job.portal.view.RecruiterView;

@RestController
@RequestMapping("/api/recruiter")
public class RecruiterController extends AbstractController {

	@Autowired
	private RecruiterService recruiterService;

	@PostMapping("/post")
	public ResponseView createJobPost(@CurrentUser UserPrincipal currentUser, @RequestBody JobPost job)
			throws Exception {
		ResponseView responseView;
		RecruiterView view = new RecruiterView();

		job.setOwner(currentUser.getId());
		job = recruiterService.postJob(job);
		view.setJob(job);

		responseView = getResponseView(HttpStatus.OK.value(), ResponseStatus.SUCCESS, "", view);
		return responseView;
	}

	@GetMapping("/jobs")
	public ResponseView getJobPosts(@CurrentUser UserPrincipal currentUser) throws Exception {
		ResponseView responseView;
		RecruiterView view = new RecruiterView();

		List<JobPost> jobs = recruiterService.getJobPosts(currentUser.getId());

		view.setJobs(jobs);

		responseView = getResponseView(HttpStatus.OK.value(), ResponseStatus.SUCCESS, "", view);
		return responseView;

	}

	@GetMapping("/jobs/{id}")
	public ResponseView getJobPosts(@CurrentUser UserPrincipal currentUser, @PathVariable("id") int jobId) throws Exception {
		ResponseView responseView;
		RecruiterView view = new RecruiterView();

		JobPost job = recruiterService.getJobPost(currentUser.getId());

		view.setJob(job);

		responseView = getResponseView(HttpStatus.OK.value(), ResponseStatus.SUCCESS, "", view);
		return responseView;

	}

	@GetMapping("/jobs/application/{id}")
	public ResponseView getJobApplication(@PathVariable("id") int jobId) throws Exception {
		ResponseView responseView;
		RecruiterView view = new RecruiterView();

		List<Application> list = recruiterService.getApplications(jobId);
		view.setApplications(list);

		responseView = getResponseView(HttpStatus.OK.value(), ResponseStatus.SUCCESS, "", view);
		return responseView;
	}

	@PostMapping("/application/status/{id}")
	public ResponseView changeJobStatus(@PathVariable("id") int jobId, @RequestBody ApplicationStatusDTO dto) {
		ResponseView responseView;
		RecruiterView view = new RecruiterView();

		Application application = recruiterService.changeApplicationStatus(jobId, dto.getStatus());
		view.setApplication(application);

		responseView = getResponseView(HttpStatus.OK.value(), ResponseStatus.SUCCESS, "Status updated successfully",
				view);
		return responseView;
	}

}