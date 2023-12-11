package com.kseolha.jsp.board.controller;

import com.kseolha.jsp.domain.Criteria;
import com.kseolha.jsp.domain.PageDto;
import com.kseolha.jsp.service.FreeService;
import com.kseolha.jsp.service.FreeServiceImpl;
import com.kseolha.jsp.util.ParamSolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/free")
public class FreeListController extends HttpServlet {
    private FreeService freeService = new FreeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Criteria cri = ParamSolver.getParams(req, Criteria.class);
        req.setAttribute("frees", freeService.list(cri));
        req.setAttribute("page", new PageDto(freeService.listCount(cri), cri));
        req.getRequestDispatcher("/WEB-INF/jsp/board/free.jsp").forward(req, resp);
    }
}