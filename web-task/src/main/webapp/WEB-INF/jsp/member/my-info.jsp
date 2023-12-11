<%--
  Created by IntelliJ IDEA.
  User: ksha0
  Date: 2023-03-13
  Time: 오후 7:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<%@ include file="../common/head.jsp" %>
<body>
<%@ include file="../common/header.jsp" %>
<div id="container">
    <form method="post" name="frm" class="form">
        <label for="id" class="hidden">ID</label>
        <input id="id" type="text" name="id" placeholder="아이디" value="${member.id}" readonly><br>
        <label for="oldPw" class="hidden">PW</label>
        <input id="oldPw" type="password" name="oldPw" placeholder="현재 비밀번호"><br>
        <label for="pw" class="hidden">NEWPW</label>
        <input id="pw" type="password" name="pw" placeholder="새 비밀번호"><br>
        <label for="newPwChk" class="hidden">NEWPWCHK</label>
        <input id="newPwChk" type="password" name="newPwChk" placeholder="새 비밀번호 확인"><br>
        <div class="result"><output name="result"></output></div>
        <button id="infoModify" class="confirm" name="infoModify">정보 수정</button>
        <a href="${pageContext.request.contextPath}/withdraw" class="withdraw">
            <div id="secession" name="secession" class="confirm" style="display: inline-block; right: 20px; bottom: 20px; background-color: red; border: 0 solid; width: 100%;">탈퇴</div>
        </a>
    </form>
</div>
<%@ include file="../common/footer.jsp" %>
<script>
    $(function () {
        $("#infoModify").on("click", function () {
            let sessionPw = String(${member.pw});
            let pw = $("#oldPw").val().trim();
            frm.result.innerHTML = "";
            if (sessionPw !== pw) {
                event.preventDefault();
                frm.result.innerHTML = "비밀번호가 일치하지 않습니다."
                $("#oldPw").focus();
            }
            console.log(sessionPw !== pw)
        })

        $(".withdraw").click(function () {
            if(confirm("탈퇴하시겠습니까?")) {
                if(!confirm("정말 탈퇴하시겠습니까?")) {
                    return false;
                }
            } else {
                return false;
            }
        })
    })

</script>
</body>
</html>
