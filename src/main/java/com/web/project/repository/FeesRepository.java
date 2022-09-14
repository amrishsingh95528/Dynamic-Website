package com.web.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.project.entity.Fees;
@Repository
public interface FeesRepository extends JpaRepository<Fees, Long>	{

}
