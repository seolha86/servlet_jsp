package com.kseolha.jsp.service;

import com.kseolha.jsp.domain.Member;

public interface MemberService {
    // 회원가입
    void register(Member member);
    // 로그인
    int login(String id, String pw);
    // 회원 단일 조회
    Member get(String id);
    // 회원목록 조회

    // 정보 수정
    void modify(Member member);
    // 탈퇴
    void withdraw(Member member);

    int idChk(String id);
}
