package com.kseolha.jsp.board.controller;

import com.kseolha.jsp.domain.Criteria;
import com.kseolha.jsp.service.FreeService;
import com.kseolha.jsp.service.FreeServiceImpl;
import com.kseolha.jsp.service.ReplyService;
import com.kseolha.jsp.service.ReplyServiceImpl;
import com.kseolha.jsp.util.ParamSolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/remove")
public class FreeRemoveController extends HttpServlet {
    private FreeService freeService = new FreeServiceImpl();
    private ReplyService replyService = new ReplyServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (ParamSolver.isLogin(req)) {
            Criteria cri = ParamSolver.getParams(req, Criteria.class);
            replyService.remove(Long.valueOf(req.getParameter("bno")));
            freeService.remove(Long.valueOf(req.getParameter("bno")));
            resp.sendRedirect("free" + "?" + cri.getFullQueryString());
        }
    }
}