package com.job.portal.service.impl;

import org.springframework.stereotype.Service;

import com.job.portal.service.JobBatchService;

@Service
public class JobBatchServiceImpl implements JobBatchService{
	
	/**
	 * This is the method for fetching Jobs details from external sources.
	 * This service will be run as batch (using Cron expression) and will be 
	 * responsible for populating Jobs in our system
	 * @param None.
	 * @return Nothing.
	 */
	@Override
	public void getJobs() {
		// TODO Auto-generated method stub
		
		// We can provide different implementation of Batch Service for different sources 
		// for example one service will consume JSON , another will consume XML
		// Integration contract will ensure that we get the data in specific format

	}


}
