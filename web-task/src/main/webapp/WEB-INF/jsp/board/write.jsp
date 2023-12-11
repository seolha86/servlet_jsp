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
        <input id="title" name="title" type="text" placeholder="제목을 입력하세요">
        <textarea name="content" id="content" placeholder="내용을 입력하세요" required></textarea>
        <input type="hidden" name="writer" value="${member.id}">
        <div>
            <output class="result" name="result"></output>
            <div class="frm-menu">
                <div><a href="board"><button class="confirm" type="button">취소</button></a></div>
                <div><button id="write" class="confirm">등록</button></div>
            </div>
        </div>
    </form>
</main>
<%@ include file="../common/footer.jsp"%>
<script>
    $(function () {
        $("#write").click(function () {
            let title = $("#title").val();
            let content = $("#content").val();

            console.log(title.includes("script") || content.includes("script"))
            if (title.includes("script")) {
                alert("사용할 수 없는 단어가 포함되어 있습니다.")
                return;
            }
        })
    })
</script>
</body>
</html>
