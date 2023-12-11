package com.kseolha.jsp.board.controller;

import com.kseolha.jsp.domain.Board;
import com.kseolha.jsp.service.FreeService;
import com.kseolha.jsp.service.FreeServiceImpl;
import com.kseolha.jsp.util.ParamSolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/board/write")
public class FreeWriteController extends HttpServlet {
    private FreeService freeService = new FreeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("member") == null) {
            resp.sendRedirect(req.getContextPath() + "/member/login");
            return;
        }
        req.getRequestDispatcher("/WEB-INF/jsp/board/write.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (ParamSolver.isLogin(req)) {
            Board board = ParamSolver.getParams(req, Board.class);
            freeService.register(board);
            resp.sendRedirect("free");
            return;
        }
        resp.sendRedirect(req.getContextPath() + "/member/login?href=" + URLEncoder.encode(req.getRequestURI(), "utf-8"));
    }
}
