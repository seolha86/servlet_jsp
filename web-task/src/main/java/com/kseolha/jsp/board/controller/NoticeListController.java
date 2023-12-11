package com.kseolha.jsp.board.controller;

import com.kseolha.jsp.domain.Criteria;
import com.kseolha.jsp.domain.PageDto;
import com.kseolha.jsp.service.FreeService;
import com.kseolha.jsp.service.FreeServiceImpl;
import com.kseolha.jsp.service.NoticeService;
import com.kseolha.jsp.service.NoticeServiceImpl;
import com.kseolha.jsp.util.ParamSolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/notice")
public class NoticeListController extends HttpServlet {
    private NoticeService noticeService = new NoticeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Criteria cri = ParamSolver.getParams(req, Criteria.class);
        req.setAttribute("notices", noticeService.list(cri));
        req.setAttribute("page", new PageDto(noticeService.listCount(cri), cri));
        req.getRequestDispatcher("/WEB-INF/jsp/board/notice.jsp").forward(req, resp);
    }
}
