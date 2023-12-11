package com.kseolha.jsp.service;

import com.kseolha.jsp.dao.ReplyDao;
import com.kseolha.jsp.domain.Member;
import com.kseolha.jsp.domain.Reply;

import java.util.List;

public class ReplyServiceImpl implements ReplyService{
    ReplyDao dao = new ReplyDao();

    @Override
    public Long register(Reply reply) {
        return (long) dao.insert(reply);
    }

    @Override
    public List<Reply> list(Long bno) {
        return dao.selectList(bno);
    }

    @Override
    public int remove(Long rno) {
        return dao.delete(rno);
    }

    @Override
    public Reply get(Long rno) {
        return dao.selectOne(rno);
    }

    @Override
    public void withdrawnReply(Member member) {
        dao.withdrawnMember(member);
    }

    @Override
    public void boardremove(Long bno) {
        dao.freeDelete(bno);
    }
}
