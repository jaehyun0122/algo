<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,com.ssafy.guestbook.servlet.GuestBookDto"%>
	<%@ include file="/include/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SSAFY - 글목록</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        mark.sky {
            background: linear-gradient(to top, #54fff9 20%, transparent 30%);
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#modifyBtn").click(function () {
                location.href = "/guestbook/modify.jsp";
            });
            $("#removeBtn").click(function () {
                location.href = "/guestbook/remove.jsp";
            });
            $("#registerBtn").click(function () {
                location.href = "/guestbook/write.jsp";
            });
        });
    </script>
</head>
<body>
    <div class="container text-center mt-3">
        <div class="col-lg-8 mx-auto">
            <h2 class="p-3 mb-3 shadow bg-light"><mark class="sky">글목록</mark></h2>
            <div class="m-3 text-right">
                <button type="button" id="registerBtn" class="btn btn-link">글 쓰기</button>
                <button type="button" id="modifyBtn" class="btn btn-link">글 수정</button>
                <button type="button" id="removeBtn" class="btn btn-link">글 삭제</button>
            </div>
<c:if test="${!empty articles}">
	<c:forEach var="article" items="${articles }">
			<table class="table table-active text-left">
				<tbody>
					<tr class="table-info">
						<td>작성자 : ${article.userId}</td>
						<td class="text-right">작성일 : ${article.regTime}</td>
					</tr>
					<tr>
						<td colspan="2" class="table-danger">
							<strong>${article.articleNo}. ${article.subject }</strong>
						</td>
					</tr>
					<tr>
						<td class="p-4" colspan="2">
							${article.content }
						</td>
					</tr>
				</tbody>
			</table>
	</c:forEach>
</c:if>
<c:if test="${empty articles }">

			<table class="table table-active text-center">
				<tr class="table-info">
					<td>작성한 글이 없습니다.</td>
				</tr>
			</table>
</c:if>
		</div>
    </div>
</body>
</html>