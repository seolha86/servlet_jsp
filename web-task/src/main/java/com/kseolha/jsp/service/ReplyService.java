package com.kseolha.jsp.service;

import com.kseolha.jsp.domain.Member;
import com.kseolha.jsp.domain.Reply;

import java.util.List;

public interface ReplyService {
    Long register(Reply reply);
    List<Reply> list(Long bno);
    int remove(Long rno);
    Reply get(Long rno);
    void withdrawnReply(Member member);
    void boardremove(Long bno);
}
