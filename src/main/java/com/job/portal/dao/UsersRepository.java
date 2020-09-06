package com.job.portal.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.portal.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
	
	Optional<Users> findByEmail(String email);

	List<Users> findByIdIn(List<Long> userIds);

	Boolean existsByEmail(String email);
}
