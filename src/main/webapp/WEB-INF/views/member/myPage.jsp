<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%String contextPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>냉장고 목록</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        header {
            background-color: #4CAF50;
            color: #fff;
            text-align: center;
            padding: 15px;
        }
        .logout-container {
            color: #fff;
            text-align: right; /* 로그아웃 버튼 우측 정렬 */
        }

        h1 {
            text-align: center;
            margin-top: 20px;
            margin-bottom: 20px;
            color: #fff; /* 글씨 색상을 하얀색(#fff)으로 변경 */
            background-color: #4CAF50; /* 배경 색상 추가 */
            padding: 10px; /* 좀 더 강조적인 배경을 위해 패딩 추가 */
            border-radius: 5px; /* 라운드된 모서리 적용 */
        }


        table {
            width: 80%;
            margin: 0 auto;
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

        h2 {
            text-align: center;
            color: #4CAF50;
        }

        .member-link {
            color: #4CAF50;
            text-decoration: none;
        }

        .member-link:hover {
            text-decoration: underline;
        }
        .member-container{
            text-align: center;
        }
    </style>


</head>


<script defer src="/js/MyPage.js"></script>
<script defer src="/js/Refri.js"></script>
<%@ include file="../fragments/modal.jsp"%>
<body>
<header>
    <div class="logout-container">
        <a href="<%=contextPath%>/logout" >로그아웃</a>
    </div>

    <h1>${loginName} 님의 냉장고 목록</h1>

</header>


<table>
    <tr>
        <th hidden>번호</th>
        <th>냉장고 이름</th>
        <th>선택</th>
    </tr>
    <c:forEach items="${listRefri}" var="refri">
        <tr>
            <td hidden>${refri.refri_id}</td>
            <td>
                <a href="/item?refri_id=${refri.refri_id}">${refri.r_name}</a>
            </td>
            <td><input type="checkbox" name="checkbox1" value="${refri.refri_id}"></td>
        </tr>
    </c:forEach>
</table>
<div class="btn-container">
    <button class="btn" onclick="openRefriModal('${refri.refri_id}')">냉장고 등록하기</button>
    <button class="btn" onclick="deleteSelectedItems()">냉장고 삭제</button>
</div>

<h2>회원 관리</h2>
<div class="member-container">
    <a href="#" onclick="openUpdateMemberModal();" class="member-link">회원 정보 수정</a>
    <form id="deleteForm" action="<%=contextPath%>/member/delete" method="post" style="display: inline;">
        <a href="#" onclick="return confirmDelete();" class="member-link">회원 탈퇴</a>
    </form>
</div>

</body>
</html>