package com.job.portal.dto;

import org.springframework.stereotype.Component;

import com.job.portal.common.JobStatus;

@Component
public class ApplicationStatusDTO {

	private JobStatus status;

	public JobStatus getStatus() {
		return status;
	}

	public void setStatus(JobStatus status) {
		this.status = status;
	}
	
}
