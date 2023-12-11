package com.kseolha.jsp.board.controller;

import com.kseolha.jsp.domain.Criteria;
import com.kseolha.jsp.service.FreeService;
import com.kseolha.jsp.service.FreeServiceImpl;
import com.kseolha.jsp.util.ParamSolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/free-detail")
public class FreeDetailController extends HttpServlet {
    private FreeService freeService = new FreeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Criteria cri = ParamSolver.getParams(req, Criteria.class);
        req.setAttribute("cri", cri);
        req.setAttribute("free", freeService.get(Long.valueOf(req.getParameter("bno"))));
        req.setAttribute("freeNext", freeService.getNP(freeService.getNP(Long.valueOf(req.getParameter("bno"))).getNextBno()));
        req.setAttribute("freePrev", freeService.getNP(freeService.getNP(Long.valueOf(req.getParameter("bno"))).getPrevBno()));
        req.setAttribute("freeWriter", freeService.getNP(Long.valueOf(req.getParameter("bno"))).getWriter());
        req.getRequestDispatcher("/WEB-INF/jsp/board/free-detail.jsp").forward(req, resp);
    }
}
