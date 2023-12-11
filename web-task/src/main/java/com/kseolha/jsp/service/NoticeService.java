package com.kseolha.jsp.service;

import com.kseolha.jsp.domain.Board;
import com.kseolha.jsp.domain.Criteria;

import java.util.List;

public interface NoticeService {
    Board get(Long bno);
    Board getNP(Long bno);
    List<Board> list(Criteria cri);
    int listCount(Criteria cri);
}
