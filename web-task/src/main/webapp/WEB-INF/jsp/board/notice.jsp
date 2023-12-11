<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ksha0
  Date: 2023-03-12
  Time: 오전 1:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<%@ include file="../common/head.jsp"%>
<body>
<%@ include file="../common/header.jsp"%>
<main id="container">
    <div>
        <div class="board-title">
            <h2>공지사항</h2>
        </div>
        <div class="board-list">
            <c:forEach var="notice" items="${notices}" varStatus="stat">
                <a href="notice-detail?bno=${notice.bno}">
                    <div>
                        <div class="no">${notice.bno}</div>
                        <div class="title">${notice.title}</div>
                        <div class="writer"><span style="margin: 0 15px; font-size: 12px; color: #86898f">${notice.hitcount}</span></div>
                        <div class="date">${notice.regdate}</div>
                    </div>
                </a>
            </c:forEach>
        </div>
<%--        <div class="board-menu">--%>
<%--            <a href="write.html"><div class="confirm write">글쓰기</div></a>--%>
<%--        </div>--%>
        <div class="page">
            <c:if test="${page.doublePrev}">
                <a href="notice?pageNum=${page.startPage - 1}&amount=${page.cri.amount}"><div><<</div></a>
            </c:if>
            <c:if test="${page.prev}">
                <a href="notice?pageNum=${page.cri.pageNum - 1}&amount=${page.cri.amount}"><div><</div></a>
            </c:if>
            <c:forEach begin="${page.startPage}" end="${page.endPage}" var="i">
                <a href="notice?pageNum=${i}&amount=${page.cri.amount}"><div style="${page.cri.pageNum == i ? 'color: white; background-color: #222;' : ''}">${i}</div></a>
            </c:forEach>
            <c:if test="${page.next}">
                <a href="notice?pageNum=${page.cri.pageNum + 1}&amount=${page.cri.amount}"><div>></div></a>
            </c:if>
            <c:if test="${page.doubleNext}">
                <a href="notice?pageNum=${page.endPage + 1}&amount=${page.cri.amount}"><div>>></div></a>
            </c:if>
        </div>
    </div>
</main>
<%@ include file="../common/footer.jsp"%>
</body>
</html>
