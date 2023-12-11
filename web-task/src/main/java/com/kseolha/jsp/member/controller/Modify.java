package com.kseolha.jsp.member.controller;

import com.kseolha.jsp.domain.Member;
import com.kseolha.jsp.service.MemberService;
import com.kseolha.jsp.service.MemberServiceImpl;
import com.kseolha.jsp.util.ParamSolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/myInfo")
public class Modify extends HttpServlet {
    private MemberService memberService = new MemberServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/member/my-info.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Member member = ParamSolver.getParams(req, Member.class);
        memberService.modify(member);
        resp.sendRedirect(req.getContextPath() + "/");
    }
}
