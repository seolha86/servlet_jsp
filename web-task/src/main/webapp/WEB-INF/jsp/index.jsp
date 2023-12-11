<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="ko">
<%@ include file="common/head.jsp"%>
<body>
<div id="wrap">
    <%@ include file="common/header.jsp"%>

    <main id="container">
        <div class="slider">
            <div><img src="https://rs.nxfs.nexon.com/bannerusr/23/2/YRef24134100604.jpg" alt="크레이지아케이드"></div>
            <div><img src="https://rs.nxfs.nexon.com/bannerusr/23/3/EbKV10133226758.jpg" alt="바람의나라"></div>
            <div><img src="https://rs.nxfs.nexon.com/bannerusr/23/2/yfV224104312795.jpg" alt="메이플스토리"></div>
            <div><img src="https://rs.nxfs.nexon.com/bannerusr/23/2/cz2m21154357087.png" alt="마비노기"></div>
            <div><img src="https://rs.nxfs.nexon.com/bannerusr/23/2/fi1Y23134412217.png" alt="카트라이더"></div>
        </div>
        <section id="section">
            <div>
                <h2>추천 게임</h2>
                <div class="game-list">
                    <a href="https://kart.nexon.com/events/2023/0112/Event.aspx">
                        <div class="game">
                            <div class="gameImg">
                                <img src="https://rs.nxfs.nexon.com/gameusr/22/10/FwoV20055414911.png" alt="카트라이더">
                            </div>
                            <div class="gameName">
                                카트라이더
                            </div>
                        </div>
                    </a>
                    <a href="https://event.sa.nexon.com/230302/intro">
                        <div class="game">
                            <div class="gameImg">
                                <img src="https://rs.nxfs.nexon.com/gameusr/19/7/u72I29180233486.png" alt="서든어택">
                            </div>
                            <div class="gameName">
                                서든어택
                            </div>
                        </div>
                    </a>
                    <a href="https://dnfm.nexon.com/Event/2023/0223/update">
                        <div class="game">
                            <div class="gameImg">
                                <img src="https://rs.nxfs.nexon.com/gameusr/19/7/3CRJ29175605990.png" alt="던전앤파이터 모바일">
                            </div>
                            <div class="gameName">
                                던전앤파이터
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </section>

        <aside id="aside">
            <div class="login">
                <% if(session.getAttribute("member") == null) { %>
                <a href="member/login"><div id="login" class="confirm">로그인</div></a>
                <a href="member/contract"><div>회원가입</div></a>
                <a href=""><div>ID/PW 찾기</div></a>
                <% } else { %>
                <div style="height: 70px; line-height: 70px; text-align: center; color: white; background-color: #222222">${member.name}님 환영합니다!</div>
                <a href="member/myInfo"><div>마이페이지</div></a>
                <a href="member/logout"><div>로그아웃</div></a>
                <img src="https://blog.kakaocdn.net/dn/bM62UK/btrXcqaHG46/auh24NxVX09YZ4fPnk12y1/img.png" alt="주황버섯">
                <% } %>
            </div>
        </aside>

        <section>
            <div class="all-game">
                <h2>모든 게임</h2>
                <div class="game-list">
                    <a href="https://tr.sgp.nexon.com/index.asp">
                        <div class="game">
                            <div class="gameImg">
                                <img src="https://rs.nxfs.nexon.com/gameusr/20/5/8z7U08114212767.png" alt="테일즈런너">
                            </div>
                            <div class="gameName">
                                테일즈런너
                            </div>
                        </div>
                    </a>
                    <a href="https://maplestory.nexon.com/Promotion/event/2022/20221222/intro/3rd">
                        <div class="game">
                            <div class="gameImg">
                                <img src="https://rs.nxfs.nexon.com/gameusr/23/1/DkAb19101158804.png" alt="메이플스토리">
                            </div>
                            <div class="gameName">
                                메이플스토리
                            </div>
                        </div>
                    </a>
                    <a href="https://kart.nexon.com/events/2023/0112/Event.asp">
                        <div class="game">
                            <div class="gameImg">
                                <img src="https://rs.nxfs.nexon.com/gameusr/22/12/bzPV22102356357.png" alt="카트라이더">
                            </div>
                            <div class="gameName">
                                카트라이더
                            </div>
                        </div>
                    </a>
                    <a href="https://ca.nexon.com/Event_20230302">
                        <div class="game">
                            <div class="gameImg">
                                <img src="https://rs.nxfs.nexon.com/gameusr/22/11/q4X317170441452.png" alt="크레이지 아케이드">
                            </div>
                            <div class="gameName">
                                크레이지 아케이드
                            </div>
                        </div>
                    </a>
                    <a href="https://dd.nexon.com/ko/main">
                        <div class="game">
                            <div class="gameImg">
                                <img src="https://rs.nxfs.nexon.com/gameusr/22/11/odrl21145238079.png" alt="던전앤파이터 듀얼">
                            </div>
                            <div class="gameName">
                                던전앤파이터 듀얼
                            </div>
                        </div>
                    </a>
                    <a href="https://event.sa.nexon.com/230302/intro">
                        <div class="game">
                            <div class="gameImg">
                                <img src="https://rs.nxfs.nexon.com/gameusr/19/7/zihY29180233377.png" alt="서든어택">
                            </div>
                            <div class="gameName">
                                서든어택
                            </div>
                        </div>
                    </a>
                    <a href="https://bf.nexon.com/Main/Index">
                        <div class="game">
                            <div class="gameImg">
                                <img src="https://rs.nxfs.nexon.com/gameusr/21/9/uxWJ28144011619.gif" alt="버블파이터">
                            </div>
                            <div class="gameName">
                                버블파이터
                            </div>
                        </div>
                    </a>
                    <a href="https://r2beat-ko.valofe.com/">
                        <div class="game">
                            <div class="gameImg">
                                <img src="https://file.valofe.com/Valofe_file/web/vfun-ko/images/game/enroll/r2beatko-big-thumb-min.jpg" alt="알투비트">
                            </div>
                            <div class="gameName">
                                알투비트
                            </div>
                        </div>
                    </a>
                    <a href="https://getamped.juneinter.com/index.php">
                        <div class="game">
                            <div class="gameImg">
                                <img src="https://encdn.ldmnq.com/faq/images/kr/4d313533-53f9-44af-b90f-b897078453ae.jpg" alt="겟앰프드">
                            </div>
                            <div class="gameName">
                                겟앰프드
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </section>
    </main>

    <%@ include file="common/footer.jsp"%>
</div>
</body>
</html>