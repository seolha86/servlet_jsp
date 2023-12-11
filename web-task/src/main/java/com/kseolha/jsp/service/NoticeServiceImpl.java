package com.kseolha.jsp.service;

import com.kseolha.jsp.dao.NoticeDao;
import com.kseolha.jsp.domain.Board;
import com.kseolha.jsp.domain.Criteria;

import java.util.List;

public class NoticeServiceImpl implements NoticeService {
    private NoticeDao dao = new NoticeDao();

    @Override
    public Board get(Long bno) {
        dao.increaseHitCount(bno);
        return dao.selectOne(bno);
    }

    @Override
    public Board getNP(Long bno) {
        return dao.selectOne(bno);
    }

    @Override
    public List<Board> list(Criteria cri) {
        return dao.selectList(cri);
    }

    @Override
    public int listCount(Criteria cri) {
        return dao.selectListCount(cri);
    }
}
