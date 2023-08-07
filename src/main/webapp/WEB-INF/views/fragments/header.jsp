<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>


</head>
<script defer src="/js/Main.js"></script>
<link href="<%=contextPath%>/css/main.css" rel="stylesheet" type="text/css">



<body>
<div class="headerLogin">
    <c:choose>
        <c:when test="${loginYn == 1}">
            <!-- User is logged in -->
            <a href="<%=contextPath%>/logout">로그아웃</a>
            <a href="<%=contextPath%>/mypage">마이페이지</a> <br>
            ${loginName}님 환영합니다
            <script>
                // 로그인 성공 알림창
                alert("로그인 성공");
            </script>
        </c:when>
        <c:otherwise>
            <!-- User is not logged in -->
            <div class="loginGroup">
                <button onclick="openModal()">로그인</button>
                <a href="<%=contextPath%>/join" class="signupButton">회원가입</a>
            </div>
            <c:if test="${loginYn == 0}">
                <script>
                    // 로그인 실패 알림창
                    alert("로그인 실패");
                </script>
            </c:if>
        </c:otherwise>
    </c:choose>
</div>
<%@ include file="../fragments/modal.jsp"%>


</body>


</html>