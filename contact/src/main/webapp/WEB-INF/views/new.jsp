<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>연락처 추가</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">새 연락처 등록</h2>

        <form action="/contacts/save" method="post">
            <div class="mb-3">
                <label class="form-label">이름</label>
                <input type="text" class="form-control" name="name" required>
            </div>
            <div class="mb-3">
                <label class="form-label">전화번호</label>
                <input type="text" class="form-control" name="phonenumber" placeholder="010-1234-5678" required>
            </div>
            <div class="mb-3">
                <label class="form-label">이메일</label>
                <input type="email" class="form-control" name="email" placeholder="example@domain.com">
            </div>
            <div class="mb-3">
                <label class="form-label">주소</label>
                <input type="text" class="form-control" name="address">
            </div>
            <div class="mb-3">
                <label class="form-label">메모</label>
                <textarea class="form-control" name="memo" rows="3"></textarea>
            </div>

            <div class="d-flex justify-content-between">
                <button type="submit" class="btn btn-primary" >저장</button>
                <a href="/contacts/list" class="btn btn-secondary" >취소</a>
            </div>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
