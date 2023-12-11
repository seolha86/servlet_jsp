package com.kseolha.jsp.member.controller;

import com.kseolha.jsp.domain.Member;
import com.kseolha.jsp.service.*;
import com.kseolha.jsp.util.ParamSolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/withdraw")
public class Withdrawal extends HttpServlet {
    private MemberService memberService = new MemberServiceImpl();
    private FreeService freeService = new FreeServiceImpl();
    private ReplyService replyService = new ReplyServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Member member = (Member) req.getSession().getAttribute("member");
        replyService.withdrawnReply(member);
        freeService.withdrawnBoard(member);
        memberService.withdraw(member);
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath() + "/");
    }
}