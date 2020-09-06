package com.job.portal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.portal.model.Application;
import com.job.portal.model.JobPost;
import com.job.portal.model.Users;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

	List<Application> getByCandidate(Users user);

	List<Application> getByJobId(int id);
	
	List<Application> getByJobAndCandidate(JobPost job, Users user);

}
