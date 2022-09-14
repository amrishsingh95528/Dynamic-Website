package com.web.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.project.entity.Manager;
@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long>{
	List<Manager> findByUsernameAndPassword(String username, String password);
	
}
