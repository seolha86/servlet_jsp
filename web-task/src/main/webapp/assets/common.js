$(function () {
    $('.slider').bxSlider({
        auto: true,
    });

    $("#menu2").mouseover(function () {
        $(".subMenu").show();
    }).mouseout(function () {
        $(".subMenu").hide();
    }).change(function () {
        $(".subMenu").show();
    })

    $("#login").on("click", function () {
        let id = $("#id").val().trim();
        let pw = $("#pw").val().trim();

        frm.result.innerHTML = "";

        if (!id.length) {
            event.preventDefault();
            frm.result.innerHTML = "아이디를 입력하세요"
        } else if (!pw.length) {
            event.preventDefault();
            frm.result.innerHTML = "비밀번호를 입력하세요"
        }
        $(this).submit();
    })

    $("#signup").on("click", function () {
        let id = $("#id").val().trim();
        let pw = $("#pw").val().trim();
        let pwCk = $("#pwCheck").val().trim();
        let name = $("#name").val().trim();

        let idTest =  /^[a-z]+[a-z0-9]{3,19}$/g;
        let pwTest = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{3,16}$/;
        let nameTest = /[ㄱ-힣]/;

        frm.result.innerHTML = "";

        if (!id.length) {
            event.preventDefault();
            frm.result.innerHTML = "아이디를 입력하세요"
            $("#id").focus();
        } else if (id.length < 4) {
            event.preventDefault();
            frm.result.innerHTML = "아이디를 4글자 이상 입력하세요"
            $("#id").focus();
        } else if (!idTest.test(id)) {
            event.preventDefault();
            frm.result.innerHTML = "형식에 맞는 아이디를 입력해주세요"
            $("#id").focus();
        } else if (!pw.length) {
            event.preventDefault();
            frm.result.innerHTML = "비밀번호를 입력하세요"
            $("#pw").focus();
        } else if (pw.length < 4) {
            event.preventDefault();
            frm.result.innerHTML = "비밀번호를 4글자 이상 입력하세요"
            $("#pw").focus();
        } else if (!pwTest.test(pw)) {
            event.preventDefault();
            frm.result.innerHTML = "형식에 맞는 비밀번호를 입력해주세요"
            $("#pw").focus();
        } else if (!pwCk.length) {
            event.preventDefault();
            frm.result.innerHTML = "비밀번호 확인을 입력하세요"
            $("#pwCheck").focus();
        } else if (pwCk !== pw) {
            event.preventDefault();
            frm.result.innerHTML = "비밀번호가 일치하지 않습니다."
            $("#pwCheck").focus();
        } else if (!name.length) {
            event.preventDefault();
            frm.result.innerHTML = "이름을 입력하세요"
            $("#name").focus();
        } else if (!nameTest.test(name)) {
            event.preventDefault();
            frm.result.innerHTML = "이름을 입력하세요"
            $("#name").focus();
        }
        $(this).submit();
    })

    $("#infoModify").on("click", function () {
        let pw = $("#oldPw").val().trim();
        let newPw = $("#pw").val().trim();
        let newPWChk = $("#newPwChk").val().trim();

        frm.result.innerHTML = "";

        if (!pw.length) {
            event.preventDefault();
            frm.result.innerHTML = "비밀번호를 입력하세요"
            $("#oldPw").focus();
        } else if (pw.length < 4) {
            event.preventDefault();
            frm.result.innerHTML = "비밀번호를 4글자 이상 입력하세요"
            $("#oldPw").focus();
        } else if (!newPw.length) {
            event.preventDefault();
            frm.result.innerHTML = "새 비밀번호를 입력하세요"
            $("#pw").focus();
        } else if (newPw.length < 4) {
            event.preventDefault();
            frm.result.innerHTML = "새 비밀번호를 4글자 이상 입력하세요"
            $("#pw").focus();
        } else if (newPWChk !== newPw) {
            event.preventDefault();
            frm.result.innerHTML = "비밀번호가 일치하지 않습니다."
            $("#newPwChk").focus();
        }
        $(this).submit();
    })

    $(".frm-menu div:first-child").on("click", function () {
        location.href = "notice.html"
    })

    $("#write").on("click", function () {
        let title = $("#title").val();
        let content = $("#content").val();

        frm.result.innerHTML = "";

        if (!title.length) {
            event.preventDefault();
            frm.result.innerHTML = "제목을 입력하세요";
            $("#title").focus();
        } else if (!content.length) {
            event.preventDefault();
            frm.result.innerHTML = "내용을 입력하세요";
            $("#content").focus();
        }
        $(this).submit();
    })
})

