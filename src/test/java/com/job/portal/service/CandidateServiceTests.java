package com.job.portal.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.job.portal.dao.ApplicationRepository;
import com.job.portal.dao.JobRepository;
import com.job.portal.dao.UsersRepository;
import com.job.portal.model.JobPost;
import com.job.portal.service.impl.CandidateServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CandidateServiceTests {
	

	@InjectMocks
	CandidateServiceImpl candidateService;
	
	@Mock
	private ApplicationRepository applicationRepository;

	@Mock
	private UsersRepository userRepository;

	@Mock
	private JobRepository jobRepository;
	
	@Test
	public void getJobsTest() {
		List<JobPost> list = new ArrayList<JobPost>();
		JobPost job1 = new JobPost();
		JobPost job2 = new JobPost();
		JobPost job3 = new JobPost();
		list.add(job1);
		list.add(job2);
		list.add(job3);
		
		when(jobRepository.findAll()).thenReturn(list);
		
		List<JobPost> jobs = candidateService.getJobs();
		
		assertEquals(3, jobs.size());
		verify(jobRepository, times(1)).findAll();
	}
	
	/* other test cases */
	
	
}
