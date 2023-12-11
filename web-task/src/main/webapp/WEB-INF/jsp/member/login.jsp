<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ko">
<%@ include file="../common/head.jsp"%>
<body>
<%@ include file="../common/header.jsp"%>
    <div id="container">
        <form method="post" name="frm" class="form">
            <label for="id" class="hidden">ID</label>
            <input id="id" type="text" name="id" placeholder="아이디" style="width: 93%;"><br>
            <label for="pw" class="hidden">PW</label>
            <input id="pw" type="password" name="pw" placeholder="비밀번호" style="width: 93%;"><br><br>
            <div>
                <div class="result"><output name="result"></output></div>
                <label><input type="checkbox" value="remember-me">아이디 저장</label>
            </div>
            <button id="login" class="confirm" name="login">로그인</button>
        </form>
    </div>
    <%@ include file="../common/footer.jsp"%>
</body>
</html>
