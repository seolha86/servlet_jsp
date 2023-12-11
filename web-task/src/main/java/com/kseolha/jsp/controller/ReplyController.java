package com.kseolha.jsp.controller;

import com.google.gson.Gson;
import com.kseolha.jsp.domain.Reply;
import com.kseolha.jsp.service.ReplyService;
import com.kseolha.jsp.service.ReplyServiceImpl;
import com.kseolha.jsp.util.ParamSolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Parameter;
import java.util.List;

@WebServlet("/reply")
public class ReplyController extends HttpServlet {
    private ReplyService replyService = new ReplyServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long bno = Long.valueOf(req.getParameter("bno"));
        List<Reply> replies = replyService.list(bno);
        Gson gson = new Gson();
        String json = gson.toJson(replies);
        resp.setContentType("application/json; charset=utf8");
        resp.getWriter().print(json);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (ParamSolver.isLogin(req)) {
            Long rno = Long.valueOf(req.getParameter("rno"));
            PrintWriter out = resp.getWriter();
            Reply reply = replyService.get(rno);
            out.print(reply != null && ParamSolver.isMine(req, replyService.get(rno).getWriter()) ? 0 : replyService.remove(rno));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (ParamSolver.isLogin(req)) {
            System.out.println("doPost");
            Reply reply = ParamSolver.getParams(req, Reply.class);
            replyService.register(reply);
        }
    }
}
