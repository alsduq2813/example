package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{

}
