<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>연락처 목록</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">연락처 목록</h2>

        <table class="table table-hover table-bordered align-middle">
            <thead class="table-dark">
                <tr>
                    <th>이름</th>
                    <th>연락처</th>
                    <th>이메일</th>
                    <th style="width: 220px;">상세보기|수정|삭제</th>
                </tr>
            </thead>
            <tbody>
                <%-- 반복문으로 데이터 출력 --%>
                <c:forEach var="contact" items="${pageList.list}">
                    <tr>
                        <td name="name">${contact.name}</td>
                        <td name="phonenumber">${contact.phonenumber}</td>
                        <td name="email">${contact.email}</td>
                        <td>
                            <a href="/contacts/view?id=${contact.id}" class="btn btn-info btn-sm">보기</a>
                            <a href="/contacts/edit?id=${contact.id}" class="btn btn-warning btn-sm">수정</a>
                            <a href="/contacts/delete?id=${contact.id}" class="btn btn-danger btn-sm" 
                           		 onclick="return confirm('정말 삭제하시겠습니까?')">삭제</a>
                           		
							<script>
							function YesorNo() {
								return confirm("정말 삭제하시겠습니까?")
							}
							</script>
							
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="text-end">
            <a class="btn btn-primary" onclick="location.href='/contacts/new'">연락처 추가</a>
        </div>
    </div>
	
	<nav aria-label="Page navigation">
	  <ul class="pagination justify-content-center">
	    <c:if test="${pageList.pre}">
	      <li class="page-item ${pageList.pre ? '' : 'disabled'}">
	        <a class="page-link" href="?requestPage=${pageList.startPage - 1}">이전</a>
	      </li>
	    </c:if>
	    
	    <c:forEach var="i" begin="${pageList.startPage}" end="${pageList.endPage}">
	      <li class="page-item ${i == pageList.currentPage ? 'active' : ''}">
	        <a class="page-link" href="?requestPage=${i}">${i}</a>
	      </li>
	    </c:forEach>
	    
	    <c:if test="${pageList.next}">
	      <li class="page-item ">
	        <a class="page-link" href="?requestPage=${pageList.endPage + 1}">다음</a>
	      </li>
	    </c:if>
	  </ul>
	</nav>
	
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
