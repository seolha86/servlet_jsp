package com.kseolha.jsp.board.controller;

import com.kseolha.jsp.service.NoticeService;
import com.kseolha.jsp.service.NoticeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/notice-detail")
public class NoticeDetailController extends HttpServlet {
    private NoticeService noticeService = new NoticeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("notice", noticeService.get(Long.valueOf(req.getParameter("bno"))));
        req.setAttribute("noticeNext", noticeService.getNP(noticeService.getNP(Long.valueOf(req.getParameter("bno"))).getNextBno()));
        req.setAttribute("noticePrev", noticeService.getNP(noticeService.getNP(Long.valueOf(req.getParameter("bno"))).getPrevBno()));
        req.getRequestDispatcher("/WEB-INF/jsp/board/notice-detail.jsp").forward(req, resp);
    }
}
