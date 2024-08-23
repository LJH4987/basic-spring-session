package com.example.basicspringsession.service;

import com.example.basicspringsession.dto.MemberSaveRequestDto;
import com.example.basicspringsession.dto.MemberSaveResponseDto;
import com.example.basicspringsession.dto.MemberSimpleResponseDto;
import com.example.basicspringsession.repository.MemberRepository;
import com.example.basicspringsession.entity.Member; // Member 엔티티 클래스 임포트
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberSaveResponseDto saveMember(MemberSaveRequestDto requestDto) {
        Member newMember = new Member(requestDto.getName());
        Member savedMember = memberRepository.save(newMember);

        return new MemberSaveResponseDto(savedMember.getName());
    }

    public List<MemberSimpleResponseDto> getMembers() {
        List<Member> members = memberRepository.findAll();

        List<MemberSimpleResponseDto> memberSimpleResponseDtos = new ArrayList<>();
        for (Member member : members) {
            memberSimpleResponseDtos.add(new MemberSimpleResponseDto(member.getId(), member.getName()));
        }

        return memberSimpleResponseDtos;
    }
}