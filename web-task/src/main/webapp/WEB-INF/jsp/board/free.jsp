<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ksha0
  Date: 2023-03-11
  Time: 오후 1:46
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
            <h2>자유게시판</h2>
            <form class="search-form">
                <input type="hidden" name="page" value="1">
                <input type="hidden" name="amount" value="${page.cri.amount}">
                <input type="hidden" name="category" value="${page.cri.category}">
                <div class="search">
                    <c:set var="values" value="title,content"/>
                    <select name="type" class="search-option" style="width: 100px">
                        <c:forTokens items="${values}" delims="," var="value">
                            <option value="${value}" ${page.cri.type == value ? 'selected' : ''}>${value}</option>
                        </c:forTokens>
                    </select>
                    <input id="search" name="keyword" type="text" placeholder="검색" value="${page.cri.keyword}">
                    <button type="submit"><i class="fas fa-search"></i></button>
                </div>
            </form>
            <a href="write"><div class="confirm write">글쓰기</div></a>
        </div>
        <div class="board-list">
            <c:forEach var="free" items="${frees}" varStatus="stat">
                <a href="free-detail?bno=${free.bno}">
                    <div>
                        <div class="no">${free.bno}</div>
                        <div class="title">${free.title}<span style="margin: 0 15px; font-size: 12px; color: #86898f">${free.hitcount}</span></div>
                        <div class="writer">${free.writer}</div>
                        <div class="date">${free.regdate}</div>
                    </div>
                </a>
            </c:forEach>
        </div>

        <div class="page">
            <c:if test="${page.doublePrev}">
                <a href="free?pageNum=${page.startPage - 1}&amount=${page.cri.amount}"><div><<</div></a>
            </c:if>
            <c:if test="${page.prev}">
                <a href="free?pageNum=${page.cri.pageNum - 1}&amount=${page.cri.amount}"><div><</div></a>
            </c:if>
            <c:forEach begin="${page.startPage}" end="${page.endPage}" var="i">
                <a href="free?pageNum=${i}&amount=${page.cri.amount}"><div style="${page.cri.pageNum == i ? 'color: white; background-color: #222;' : ''}">${i}</div></a>
            </c:forEach>
            <c:if test="${page.next}">
                <a href="free?pageNum=${page.cri.pageNum + 1}&amount=${page.cri.amount}"><div>></div></a>
            </c:if>
            <c:if test="${page.doubleNext}">
                <a href="free?pageNum=${page.endPage + 1}&amount=${page.cri.amount}"><div>>></div></a>
            </c:if>
        </div>
    </div>
</main>
<%@ include file="../common/footer.jsp"%>
<script>
    $(".amount").change(function () {
        let page = '${page.cri.pageNum}';
        let amount = $(this).val();

        let obj = {
            pageNum : page,
            amount : amount
        };

        location.search = $.param(obj);
    })
</script>
</body>
</html>
