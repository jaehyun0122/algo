<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글 삭제</title>
    <meta charset="utf-8">
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
            $("#rmbutton").click(function () {
                if (!$("#userid").val()) {
                    alert("아이디 입력!!!!");
                    return;
                } else if (!$("#articleno").val()) {
                    alert("글 번호 입력!!!!");
                    return;
                } else {
                    $("#removeform").attr("action", "/guestbook/guestbook").submit();
                }
            });
        });
    </script>
</head>
<body>
    <div class="container text-center mt-3">
        <div class="col-lg-8 mx-auto">
            <h2 class="p-3 mb-3 shadow bg-light"><mark class="sky">글 삭제</mark></h2>
            <form id="removeform" class="text-left mb-3" method="post" action="">
            	<input type="hidden" name="act" value="remove">
                <div class="form-group">
                    <label for="userid">작성자ID:</label>
                    <input type="text" class="form-control" id="userid" name="userid" placeholder="작성자ID...">
                </div>
                <div class="form-group">
                    <label for="articleno">글 번호:</label>
                    <input type="text" class="form-control" id="articleno" name="articleno" placeholder="글 번호...">
                </div>
                <div class="text-center">
                    <button type="button" id="rmbutton" class="btn btn-outline-primary">완료</button>
                    <button type="reset" class="btn btn-outline-danger">초기화</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>