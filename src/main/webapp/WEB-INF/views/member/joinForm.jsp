<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%String contextPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
    /* 폼 스타일 */
    form {
        max-width: 400px;
        margin: 0 auto;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    }

    label {
        font-weight: bold;
    }

    input[type="text"],
    input[type="password"] {
        width: 50%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 3px;
        box-sizing: border-box; /* 내용 영역에 패딩과 테두리 크기를 포함하도록 지정 */
        vertical-align: middle; /* 수직 정렬 */
    }

    input[type="submit"] {
        padding: 10px;
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
</head>
<body>

<form action="/join" method="post">
    <label for="m_id">아이디:</label>
    <input type="text" id="m_id" name="m_id" required>
    <br>
    <label for="m_pass">비밀번호:</label>
    <input type="password" id="m_pass" name="m_pass" required>
    <br>
    <label for="m_name">성함:</label>
    <input type="text" id="m_name" name="m_name" required>
    <br>
    <label for="m_email">이메일:</label>
    <input type="text" id="m_email" name="m_email" required>

    <input type="submit" value="가입하기">
</form>
</body>
</html>