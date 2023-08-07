<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>

</head>


<style>
    h1 {
        margin: auto;
        text-align: center;
    }
</style>
<body>
<!-- 로그인 모달 창 -->
<div id="loginModal" class="modal" style="display: none;">
    <div class="modal-content">
        <span class="close" onclick="closeModal()">&times;</span>
        <form action="/login" method="post">
            <label for="m_id">아이디:</label>
            <input type="text" id="m_id" name="m_id" required>
            <label for="m_pass">비밀번호:</label>
            <input type="password" id="m_pass" name="m_pass" required>
            <input type="submit" value="로그인">
        </form>
    </div>
</div>
<style>
    /* 모달 창 스타일 */
    .modal {
        display: none;
        position: fixed;
        z-index: 1;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        overflow: auto;
        background-color: rgba(0, 0, 0, 0.4);
    }

    .modal-content {
        background-color: #fefefe;
        margin: 10% auto;
        padding: 20px;
        border: 1px solid #888;
        max-width: 300px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    }

    .close {
        float: right;
        font-size: 28px;
        font-weight: bold;
    }

    .close:hover,
    .close:focus {
        color: #000;
        text-decoration: none;
        cursor: pointer;
    }

    /* 폼 스타일 */
    form {
        display: flex;
        flex-direction: column;
    }

    label {
        margin-bottom: 5px;
        font-weight: bold;
    }

    input[type="text"],
    input[type="password"] {
        padding: 8px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 3px;
    }

    input[type="submit"] {
        padding: 8px;
        background-color: #4CAF50;
        color: #fff;
        border: none;
        border-radius: 3px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>



<!-- 회원정보수정 모달 창 -->
<div id="updateModal" class="modal" style="display: none;">
    <div class="modal-content">
        <span class="close" onclick="closeUpdateMemberModal()">&times;</span>
        <form action="/member/update" method="post">
            <label for="m_name">이름:</label>
            <input type="text" id="m_name" name="m_name" required value="${loginName}">


            <input type="submit" value="수정하기">
        </form>
    </div>
</div>




<!-- 냉장고 등록 창 -->
<div id="addRefriModal" class="modal" style="display: none;">
    <div class="modal-content">
        <span class="close" onclick="closeRefriModal()">&times;</span>
        <form action="/refri" method="post">
            <label for="r_name">냉장고명:</label>
            <input type="text" id="r_name" name="r_name" required>

            <input type="submit" value="추가">
        </form>
    </div>
</div>



<!-- 냉장고 재고추가전용 모달창 -->
<div id="addItemModal" class="modal" style="display: none;">
    <div class="modal-content">
        <span class="close" onclick="closeModal()">&times;</span>
        <form id="addItemForm"  action="/item" method="post">

            <input type="hidden" id="refri_id" name="refri_id" value="${refri_id}">
            <label for="i_name">제품명:</label>
            <input type="text" id="i_name" name="i_name" required>
            <label for="i_category">품목명:</label>
            <input type="text" id="i_category" name="i_category" required>
            <label for="i_loc">위치:</label>
            <input type="text" id="i_loc" name="i_loc" required>
            <label for="i_expiration">유통기한:</label>
            <input type="date" id="i_expiration" name="i_expiration" required>
            <input type="submit" value="추가">
        </form>
    </div>
</div>





</body>


</html>