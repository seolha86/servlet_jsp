package com.kseolha.jsp.member.controller;

import com.kseolha.jsp.domain.Member;
import com.kseolha.jsp.service.MemberService;
import com.kseolha.jsp.service.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/signup")
public class Signup extends HttpServlet {
    private MemberService memberService = new MemberServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/member/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");

        Member member = new Member(id, pw, name);
        memberService.register(member);
        response.sendRedirect(request.getContextPath() + "/");
    }
}
