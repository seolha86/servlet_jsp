<%@ page import="com.kseolha.jsp.dao.FreeDao" %>
<%@ page import="com.kseolha.jsp.service.FreeService" %>
<%@ page import="com.kseolha.jsp.service.FreeServiceImpl" %><%--
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
    <form class="reply">
        <div class="detail-wrap">
                <div class="detail-title">
                    ${free.title}
                    <% if (session.getAttribute("member") != null && (session.getAttribute("id").equals(request.getAttribute("freeWriter")))) { %>
                        <a href="remove?bno=${free.bno}" class="remove"><span>삭제</span></a>
                        <a href="modify?bno=${free.bno}"><span>수정</span></a>
                    <% } %>
                </div>
                <div class="detail-info">
                    <span>${free.writer}</span>
                    <span>${free.regdate}</span>
                </div>
                <div class="detail-content">
                    <br><br>
                    ${free.content}
                </div>
            </div>

            <div id="reply">
                <textarea class="reply-text" name="" id="comment" cols="30" rows="10"></textarea>
                <button class="reply-btn write confirm">등록</button>
            </div>

            <ul class="replies">
                <li style="list-style: none">
                    <div style="padding: 15px;">
                        <p style="text-align: center">댓글이 없습니다.</p>
                    </div>
                </li>
            </ul>

            <div class="writing">
                <% if (request.getAttribute("freeNext") != null) { %>
                    <a href="${pageContext.request.contextPath}/board/free-detail?bno=${freeNext.bno}">
                        <div class="next" style="padding: 0 15px">
                            <div style="display: inline-block; font-size: 25px; margin-right: 30px">▴ <span style="font-size: 16px">다음 글</span></div>
                            <span class="detail-np">${freeNext.title}</span>
                        </div>
                    </a>
                <% } else { %>
                    <div style="height: 40px; line-height: 40px; padding: 15px; border-bottom: 1px solid #86898f">
                        <div style="display: inline-block; font-size: 25px; margin-right: 30px">▴ <span style="font-size: 16px">다음 글</span></div>
                        <span class="detail-np">다음 글이 없습니다.</span>
                    </div>
                <%
                    }
                    if (request.getAttribute("freePrev") != null) {
                %>
                    <a href="${pageContext.request.contextPath}/board/free-detail?bno=${freePrev.bno}">
                        <div class="previous" style="padding: 0 15px">
                            <div style="display: inline-block; font-size: 25px; margin-right: 30px">▾ <span style="font-size: 16px">이전 글</span></div>
                            <span class="detail-np">${freePrev.title}</span>
                        </div>
                    </a>
                <% } else { %>
                    <div style="height: 40px; line-height: 40px; padding: 15px; border-bottom: 1px solid #86898f">
                        <div style="display: inline-block; font-size: 25px; margin-right: 30px">▾ <span style="font-size: 16px">이전 글</span></div>
                        <span class="detail-np">이전 글이 없습니다.</span>
                    </div>
                <% } %>
        </div>
    </form>
    <a href="javascript:history.back()"><div class="confirm list">목록</div></a>
</div>
<%@ include file="../common/footer.jsp"%>
<script>
    $(".remove").click(function () {
        return confirm("글을 삭제 하시겠습니까?");
    })

    let contextPath = '${pageContext.request.contextPath}';
    let replyPath = contextPath + "/reply"
    let bno = '${free.bno}'
    let writer = '${member.id}'

    showList();

    function showList() {
        $.ajax({
            url : replyPath,
            data : {bno: bno},
            success : list
        })
    }

    function list(replies) {
        let str = "";

        console.log(replies)

        if(!replies.length) {
            str += `
                <li style="list-style: none; border-bottom: 1px solid #86898f">
                    <div style="padding: 15px;">
                        <p style="text-align: center">댓글이 없습니다.</p>
                    </div>
                </li>`
            $(".replies").html(str);
            return
        }

        for (let i in replies) {
            let r = replies[i];
            let isMine = writer === r.writer;

            str += `
                <li data-rno="\${r.rno}" style="list-style: none; padding: 15px; border-bottom: 1px solid #86898f">
                    <div style="height: 40px">
                        <a>
                            <span style="font-weight: bolder; float: left; margin-left: 15px; margin-top: 15px">\${r.writer}</span>
                            <span style="float: left; margin-left: 20px; margin-top: 15px">\${r.regdate}</span>
                        </a>
                        <div>`;
            str += isMine ? `<a href="" class="delete" style="color: red; float: right; margin-top: 15px; margin-right: 15px"><i class="fas fa-times"></i></a>` : ''
            str += `    </div>
                    </div>
                    <div>
                        <p style="text-align: left; margin-left: 15px">\${r.content}</p>
                    </div>
                </li>
            `
        }
        $(".replies").html(str);
    }

    $("#comment").next().click(function () {
        event.preventDefault();
        let content = $("#comment").val();
        if (!writer) {
            alert("로그인 후 작성해주세요");
            location.href = contextPath + '/member/login';
            return;
        } else if (!content) {
            alert("내용을 입력하세요");
            return;
        } else if ('${free.writer}' === '탈퇴회원') {
            alert("탈퇴회원의 게시글에는 댓글을 달 수 없습니다.");
            $("#comment").val('');
            return;
        }

        $.ajax({
            url : replyPath,
            data : {bno : bno, content : content, writer : writer},
            method : "POST",
            success : function (data) {
                alert("댓글이 성공적으로 작성되었습니다.");
                $("#comment").val('');
                showList();
            }
        })
    })

    $(".replies").on("click", ".delete", function () {
        event.preventDefault();
        if (!confirm("댓글을 삭제하시겠습니까?")) {
            return false;
        }
        let rno = $(this).closest("li").data("rno")

        $.ajax({
            url : replyPath + "?rno=" + rno,
            data : {rno: rno},
            method : "DELETE",
            success : function (data) {
                console.log(data)
                if(data == 1) {
                    alert("댓글이 삭제되었습니다.");
                    showList();
                }
            }
        })
    })

    // $(".replies").on("click", ".delete", function () {
    //     event.preventDefault();
    //     if (!confirm("댓글을 삭제하시겠습니까?")) {
    //         return false;
    //     }
    //
    //     let rno = $(this).closest("li").data("rno")
    //
    //     $.ajax({
    //         url : replyPath + "?rno=" + rno,
    //         data : {rno : rno},
    //         method : "DELETE",
    //         success : function (data) {
    //             if (data == 1) {
    //                 alert("댓글이 삭제되었습니다.");
    //                 showList();
    //             }
    //         }
    //     })
    // })
</script>
</body>
</html>
