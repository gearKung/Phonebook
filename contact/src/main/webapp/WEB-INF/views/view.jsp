<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>연락처 상세보기</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">연락처 상세보기</h2>

        <div class="card">
            <div class="card-body">
                <p class="card-text"><strong>이름 :</strong> ${contact.name}</p>
                <p class="card-text"><strong>전화번호 :</strong> ${contact.phonenumber}</p>
                <p class="card-text"><strong>이메일 :</strong> ${contact.email}</p>
                <p class="card-text"><strong>주소 :</strong> ${contact.address}</p>
                <p class="card-text"><strong>메모 :</strong> ${contact.memo}</p>
            </div>
        </div>

        <div class="mt-4">
            <a class="btn btn-secondary" onclick="location.href='/contacts/list'">뒤로가기</a>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
