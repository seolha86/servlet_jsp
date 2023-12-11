package com.kseolha.jsp.service;

import com.kseolha.jsp.domain.Board;
import com.kseolha.jsp.domain.Criteria;
import com.kseolha.jsp.domain.Member;

import java.util.List;

public interface FreeService {
    Long register(Board board);
    Board get(Long bno);
    Board getNP(Long bno);
    int getIndex(Long bno);
    List<Board> list(Criteria cri);
    int listCount(Criteria cri);
    void modify(Board board);
    void remove(Long bno);
    void withdrawnBoard(Member member);
}
