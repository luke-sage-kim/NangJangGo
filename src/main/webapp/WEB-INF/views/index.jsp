<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%String contextPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>냉장고 프로젝트</title>

    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;700&display=swap" rel="stylesheet"> <!-- 구글 폰트 임포트 -->
</head>
<body>
<header>
    <%@ include file="fragments/header.jsp"%>
</header>

<main>
    <h1>냉장고 프로젝트</h1>
    <img src="images/refri1.png" alt="main1">
</main>

<footer>
    <%@ include file="fragments/modal.jsp"%>
</footer>

<script defer src="/js/Main.js"></script>
</body>
</html>