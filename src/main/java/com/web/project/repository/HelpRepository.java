package com.web.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.project.entity.Help;

@Repository
public interface HelpRepository extends JpaRepository<Help, Long>{

}
