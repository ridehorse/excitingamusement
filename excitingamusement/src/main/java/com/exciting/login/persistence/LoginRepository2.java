package com.exciting.login.persistence;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exciting.entity.Board;
import com.exciting.entity.Member;


public interface LoginRepository2 extends JpaRepository<Board, String>{
	
	@Query("SELECT m FROM Member m WHERE m.member_id = :member_id")
	Member findByMember_id(@Param("member_id") String member_id);
	
	@Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Member m WHERE m.member_id = :member_id")
	Boolean existsByMember_id(@Param("member_id") String member_id);
	
	@Query("SELECT CASE WHEN COUNT(m) > 0 AND m.m_kakao_id <> 'false' THEN true ELSE false END FROM Member m WHERE m.m_kakao_id = :m_kakao_id")
	Boolean existsByM_kakao_id(@Param("m_kakao_id") String m_kakao_id);
	
	Optional<Board> findById(@Param("id") String id);
	
	
	@Transactional
	@Modifying
    @Query("UPDATE Member m SET m.m_pass = :m_pass WHERE m.member_id = :member_id")
    int updateByM_pass(@Param("member_id") String member_id, @Param("m_pass") String m_pass);
	
	
	
}
