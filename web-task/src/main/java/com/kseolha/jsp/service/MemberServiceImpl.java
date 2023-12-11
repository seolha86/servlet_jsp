package com.kseolha.jsp.service;

import com.kseolha.jsp.dao.MemberDao;
import com.kseolha.jsp.domain.Member;

public class MemberServiceImpl implements MemberService{
    private MemberDao dao = new MemberDao();

    @Override
    public void register(Member member) {
        dao.insert(member);
    }

    @Override
    public int login(String id, String pw) {
        Member member = dao.selectOne(id);
        if (member == null) {
            return 2;
        } else if (!member.getPw().equals(pw)) {
            return 3;
        } else {
            return 1;
        }
    }

    @Override
    public Member get(String id) {
        return dao.selectOne(id);
    }

    @Override
    public void modify(Member member) {
        dao.update(member);
    }

    @Override
    public void withdraw(Member member) {
        dao.delete(member);
    }

    @Override
    public int idChk(String id) {
        return dao.idCheck(id);
    }
}
