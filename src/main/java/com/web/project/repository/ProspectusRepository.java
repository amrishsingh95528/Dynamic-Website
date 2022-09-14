package com.web.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.project.entity.Prospectus;

@Repository
public interface ProspectusRepository extends JpaRepository<Prospectus, Long>{

}
