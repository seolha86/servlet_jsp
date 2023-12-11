<%--
  Created by IntelliJ IDEA.
  User: ksha0
  Date: 2023-03-09
  Time: 오후 4:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div id="header">
    <a href="${pageContext.request.contextPath}/"><h1 class="index">NU</h1></a>
    <% if(session.getAttribute("member") == null) { %>
    <a href="${pageContext.request.contextPath}/member/login"><div class="header-sign in">로그인</div></a>
    <a href="${pageContext.request.contextPath}/member/contract"><div class="header-sign up">회원가입</div></a>
    <% } else { %>
    <a href="${pageContext.request.contextPath}/member/logout"><div class="header-sign up" style="margin-left: 100px">로그아웃</div></a>
    <% } %>
    <nav id="nav">
        <ul id="menu">
            <a href="${pageContext.request.contextPath}/" id="menu1">
                <div>
                    <li class="menu1">홈</li>
                </div>
            </a>
            <a href="${pageContext.request.contextPath}/board/notice">
                <div id="menu2">
                    <li class="menu2"> 게시판 </li>
                    <div class="subMenu">
                        <ul>
                            <a href="${pageContext.request.contextPath}/board/notice"><div id="notice"><li class="notice">공지사항</li></div></a>

                            <a href="${pageContext.request.contextPath}/board/free"><div id="free"><li class="free">자유게시판</li></div></a>
                        </ul>
                    </div>
                </div>
            </a>
        </ul>
    </nav>
</div>