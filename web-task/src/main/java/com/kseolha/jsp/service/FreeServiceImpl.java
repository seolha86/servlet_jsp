package com.kseolha.jsp.service;

import com.kseolha.jsp.dao.FreeDao;
import com.kseolha.jsp.domain.Board;
import com.kseolha.jsp.domain.Criteria;
import com.kseolha.jsp.domain.Member;

import java.util.List;

public class FreeServiceImpl implements FreeService {
    private FreeDao dao = new FreeDao();

    @Override
    public Long register(Board board) {
        return (long) dao.insert(board);
    }

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
    public int getIndex(Long bno) {
        return dao.getIdx(bno);
    }

    @Override
    public List<Board> list(Criteria cri) {
        return dao.selectList(cri);
    }

    @Override
    public int listCount(Criteria cri) {
        return dao.selectListCount(cri);
    }

    @Override
    public void modify(Board board) {
        dao.update(board);
    }

    @Override
    public void remove(Long bno) {
        dao.delete(bno);
    }

    @Override
    public void withdrawnBoard(Member member) {
        dao.withdrawnMember(member);
    }
}
