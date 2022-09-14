package com.web.project.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.web.project.entity.Member;


public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	public List<Member> findAllByOrderBySrAsc();
	
	@Query(value="SELECT * FROM member e WHERE e.sr_no LIKE %:keyword% or e.study_center_code LIKE %:keyword% or e.district LIKE %:keyword% or e.study_center_name LIKE %:keyword% or e.program_code_name LIKE %:keyword% or e.incharge LIKE %:keyword%", nativeQuery=true)
	List<Member> findByKeyword(@Param("keyword") String keyword);
}
