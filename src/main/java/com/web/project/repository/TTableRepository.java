package com.web.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.project.entity.TTable;

@Repository
public interface TTableRepository extends JpaRepository<TTable, Long>{

}
