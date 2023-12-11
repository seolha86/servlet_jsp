<%--
  Created by IntelliJ IDEA.
  User: ksha0
  Date: 2023-03-11
  Time: 오후 7:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<%@ include file="../common/head.jsp"%>
<body>
<%@ include file="../common/header.jsp"%>
<main id="container">
    <form id="writing" name="frm" method="post">
        <input id="title" name="title" type="text" placeholder="제목을 입력하세요" value="${free.title}">
        <textarea name="content" id="content" placeholder="내용을 입력하세요" required>${free.content}</textarea>
        <input type="hidden" name="writer" value="${member.id}">
        <div>
            <output class="result" name="result"></output>
            <div class="frm-menu">
                <input type="hidden" name="bno" value="${free.bno}">
                <input type="hidden" name="pageNum" value="${cri.pageNum}">
                <input type="hidden" name="bno" value="${cri.amount}">
                <input type="hidden" name="bno" value="${cri.category}">
                <input type="hidden" name="bno" value="${cri.type}">
                <input type="hidden" name="bno" value="${cri.keyword}">
                <div><a href="free"><button class="confirm" type="button">취소</button></a></div>
                <div><button id="write" class="confirm">등록</button></div>
            </div>
        </div>
    </form>
</main>
<%@ include file="../common/footer.jsp"%>
</body>
</html>
