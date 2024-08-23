package com.example.basicspringsession.controller;

import com.example.basicspringsession.dto.MemberSaveRequestDto;
import com.example.basicspringsession.dto.MemberSaveResponseDto;
import com.example.basicspringsession.dto.MemberSimpleResponseDto;
import com.example.basicspringsession.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<MemberSaveResponseDto> saveMember(MemberSaveRequestDto requestDto) {
        return ResponseEntity.ok(memberService.saveMember(requestDto));
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberSimpleResponseDto>> getMembers() {
        return ResponseEntity.ok(memberService.getMembers());
    }

}
