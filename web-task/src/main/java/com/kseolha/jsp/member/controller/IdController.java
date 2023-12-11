package com.kseolha.jsp.member.controller;

import com.kseolha.jsp.service.MemberService;
import com.kseolha.jsp.service.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/idValidation")
public class IdController extends HttpServlet {
    MemberService memberService = new MemberServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write( memberService.idChk(req.getParameter("id")) + "");
    }
}