package com.web.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.project.entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

	List<Admin> findByUsernameAndPassword(String username, String password);

}
