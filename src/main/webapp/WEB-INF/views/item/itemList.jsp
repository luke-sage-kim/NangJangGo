<%@ page import="java.util.Calendar" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.LocalDate" %>
<%String contextPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>나의 냉장고 품목들</title>

</head>
<%@ include file="../fragments/modal.jsp"%>
<script defer src="/js/Item.js"></script>

<style>
    .logout-container {
        color: #fff;
        text-align: right; /* 로그아웃 버튼 우측 정렬 */
    }
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin: 0; /* 페이지의 기본 여백을 제거함 */
    }

    h1 {
        text-align: center;
        margin: 20px 0;
        color: #4CAF50;
        background-color: #fff;
        padding: 10px;
        border-radius: 5px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
        border: 1px solid #ccc;
    }

    table th, table td {
        padding: 10px;
        text-align: center;
        border: 1px solid #ccc;
    }

    table th {
        background-color: #4CAF50;
        color: #fff;
    }

    table a {
        color: #4CAF50;
        text-decoration: none;
    }

    table a:hover {
        text-decoration: underline;
    }

    .btn-container {
        display: flex;
        justify-content: flex-end;
        margin-top: 10px;
    }

    .btn {
        padding: 10px 20px;
        background-color: #4CAF50;
        color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        margin-left: 10px;
    }

    .btn:hover {
        background-color: #45a049;
    }

    .back-link {
        display: block;
        text-align: center;
        margin-top: 20px;
        color: #4CAF50;
        text-decoration: none;
    }

    .back-link:hover {
        text-decoration: underline;
    }

    .searchContainer {
        display: flex;
        justify-content: center;
    }
</style>
<body>

<div class="logout-container">
    <a href="<%=contextPath%>/logout" >로그아웃</a>
</div>
<h1 > 나의 냉장고 품목들</h1>

<div style="height: 50%;  align-items: center;" style="width: 1000px;">


</div>

<div class="searchContainer">
    <form action="/search" style="width: 300px;">
        <input type="text" style="width: 300px;" name="keyword" placeholder="검색어를 입력하세요" value="${search}">
        <p>
    </form>
</div>

<table style="margin:auto;">
    <tr>
        <td hidden>번호</td>
        <td width="300px;">제품명</td>
        <td >품목명</td>
        <td width="140px;">위치</td>
        <td width="300px;">유통기한</td>
        <td width="140px;">상태</td>
    </tr>
    <c:forEach items="${listItem}" var="item">
        <tr>
            <td hidden>${item.item_id}</td>
            <td>${item.i_name}</td>
            <td>${item.i_category}</td>
            <td>${item.i_loc}</td>
            <td>${item.i_expiration}</td>
            <td>


                <c:set var="expirationDate" value="${item.i_expiration}" />
                <c:set var="currentDate" value="<%= new java.util.Date() %>" />
                <c:set var="sevenDaysAgo" value="${item.i_expiration.time - 7 * 24 * 60 * 60 * 1000}" />
                <c:choose>
                    <c:when test="${currentDate.after(expirationDate)}">
                        <span style="color: red;">소비불가</span>
                    </c:when>
                    <c:when test="${currentDate.time > sevenDaysAgo}">
                        <span style="color: orange;">유통기한 임박</span>
                    </c:when>

                    <c:otherwise>
                        <span style="color: green;">양호</span>

                    </c:otherwise>
                </c:choose>
            </td>

            <td> <input type="checkbox" name="checkbox1" value="${item.item_id}"></td>
        </tr>
    </c:forEach>

</table>
<c:set var="num" value="${page.total-page.start+1 }"></c:set>


<div style="text-align: center; margin-left: 300px;">
    <c:if test="${page  .startPage > page.pageBlock }">
        <a href="itemList?currentPage=${page.startPage-page.pageBlock}">[이전]</a>
    </c:if>
    <c:forEach var="i" begin="${page.startPage}" end="${page.endPage}">
<%--        <a href="itemList?currentPage=${i}">[${i}]</a>--%>
        <a href="item?refri_id=${item.refri_id}&currentPage=${i}">[${i}]</a>


    </c:forEach>
    <c:if test="${page.endPage < page.totalPage }">
        <a href="itemList?currentPage=${page.startPage+page.pageBlock}">[다음]</a>
    </c:if>
</div>

<div class="btn-container">
    <button class="btn" onclick="openModal('${item.item_id}', '${refri_id}')">제품 추가하기</button>
    <button class="btn" onclick="deleteSelectedItems()">제품 지우기</button>
</div>

<a class="back-link" href="javascript:history.back()">이전 페이지로 돌아가기</a>





</body>


</html>