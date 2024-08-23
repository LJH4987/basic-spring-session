package com.example.basicspringsession.repository;

import com.example.basicspringsession.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {
}
