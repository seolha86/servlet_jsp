package com.kseolha.jsp.member.controller;

import com.kseolha.jsp.service.MemberService;
import com.kseolha.jsp.service.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/member/login")
public class Login extends HttpServlet {
    private MemberService memberService = new MemberServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/member/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");

        String msg = "";
        switch (memberService.login(id, pw)) {
            case 1:
                req.getSession().setAttribute("member", memberService.get(id));
                req.getSession().setAttribute("id", id);
                req.getSession().setAttribute("pw", memberService.get(pw));
                resp.sendRedirect(req.getContextPath() + "/");
                break;

            case 2 :
                msg = "아이디가 존재하지 않습니다.";
                msg = URLEncoder.encode(msg, "utf-8");
                resp.sendRedirect(req.getContextPath() + "/member/login?msg=" + msg);
                break;

            case 3:
                msg = "비밀번호가 일치하지 않습니다";
                msg = URLEncoder.encode(msg, "utf-8");
                resp.sendRedirect(req.getContextPath() + "/member/login?msg=" + msg);
        }
    }
}