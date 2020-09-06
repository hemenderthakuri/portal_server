package com.job.portal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.portal.model.JobPost;

@Repository
public interface JobRepository extends JpaRepository<JobPost, Integer> {

	List<JobPost> getByOwner(int id);
}
