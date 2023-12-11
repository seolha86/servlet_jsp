<%@ page import="com.kseolha.jsp.service.NoticeService" %>
<%@ page import="com.kseolha.jsp.service.NoticeServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: ksha0
  Date: 2023-03-11
  Time: 오후 5:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<%@ include file="../common/head.jsp"%>
<body>
<%@ include file="../common/header.jsp"%>
<div id="container">
    <div class="detail-wrap">
        <div class="detail-title">
            ${notice.title}
        </div>
        <div class="detail-info">
<%--            <span>${notice.writer}</span>--%>
            <span>${notice.regdate}</span>
        </div>
        <div class="detail-content">
            <br><br>
            ${notice.content}
        </div>
    </div>
    <div class="writing">
        <% if (request.getAttribute("noticeNext") != null) { %>
        <a href="${pageContext.request.contextPath}/board/notice-detail?bno=${noticeNext.bno}">
            <div class="next" style="padding: 0 15px">
                <div style="display: inline-block; font-size: 25px; margin-right: 30px">▴ <span style="font-size: 16px">다음 글</span></div>
                <span class="detail-np">${noticeNext.title}</span>
            </div>
        </a>
        <% } else { %>
        <div style="height: 40px; line-height: 40px; padding: 15px; border-bottom: 1px solid #86898f">
            <div style="display: inline-block; font-size: 25px; margin-right: 30px">▴ <span style="font-size: 16px">다음 글</span></div>
            <span class="detail-np">다음 글이 없습니다.</span>
        </div>
        <%
            }
            if (request.getAttribute("noticePrev") != null) {
        %>
        <a href="${pageContext.request.contextPath}/board/notice-detail?bno=${noticePrev.bno}">
            <div class="previous" style="padding: 0 15px">
                <div style="display: inline-block; font-size: 25px; margin-right: 30px">▾ <span style="font-size: 16px">이전 글</span></div>
                <span class="detail-np">${noticePrev.title}</span>
            </div>
        </a>
        <% } else { %>
        <div style="height: 40px; line-height: 40px; padding: 15px; border-top: 1px solid #86898f; border-bottom: 1px solid #86898f">
            <div style="display: inline-block; font-size: 25px; margin-right: 30px">▾ <span style="font-size: 16px">이전 글</span></div>
            <span class="detail-np">이전 글이 없습니다.</span>
        </div>
        <% } %>
    </div>
    <a href="javascript:history.back()"><div class="confirm list">목록</div></a>
</div>
<%@ include file="../common/footer.jsp"%>
</body>
</html>
