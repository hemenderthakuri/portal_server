package com.job.portal.view;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.job.portal.core.IPortalView;
import com.job.portal.model.Application;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CandidateView implements IPortalView {

	private Application application;
	private List<Application> applications;

	public CandidateView() {
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

}
