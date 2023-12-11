<%--
  Created by IntelliJ IDEA.
  User: ksha0
  Date: 2023-03-11
  Time: 오전 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<%@ include file="../common/head.jsp" %>
<body>
<%@ include file="../common/header.jsp" %>
    <div id="container">
        <form name="frm" method="post">
            <label for="id" class="hidden">ID</label>
            <input id="id" type="text" name="id" placeholder="아이디를 입력하세요"><br>
            <label for="pw" class="hidden">비밀번호</label>
            <input id="pw" type="password" name="pw" placeholder="비밀번호를 입력하세요"><br>
            <label for="pwCheck" class="hidden">비밀번호 확인</label>
            <input id="pwCheck" type="password" name="pwChk" placeholder="비밀번호 확인을 입력하세요"><br>
            <label for="name" class="hidden">이름</label>
            <input id="name" type="text" name="name" placeholder="이름을 입력하세요"><br>
            <div class="result"><output name="result"></output></div>
            <button id="signup" class="confirm" name="signup">회원가입</button>
        </form>
    </div>
<%@ include file="../common/footer.jsp" %>
<script>
    let contextPath = '${pageContext.request.contextPath}';
    let path = contextPath + "/idValidation"

    frm.result.innerHTML = "";

    $("#id").blur(function () {
        let id = $("#id").val();

        if(!id) {
            frm.result.innerHTML = "생성할 수 없는 아이디입니다."
            $("#id").focus();
            return
        }

        $.ajax({
            url : path,
            data : {id : id},
            method : "POST",
            success : function (result) {
                if (result == 0) {
                    console.log("아이디 생성 불가")
                    frm.result.innerHTML = "이미 존재하는 아이디입니다.";
                    $("#id").focus();
                } else {
                    frm.result.innerHTML = "";
                }
            }
        })
    })
</script>
</body>
</html>
