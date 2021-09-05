$(document).ready(function () {
    if(localStorage.getItem('login')){
        let check = localStorage.login;
        if(check==="OK"){
            $(".loginNav").css("display","inline");
            $("#unlogined_top").css("display", "none");
            $("#logined_top").css("display", "inline");
        } else {
            $(".loginNav").css("display","none");
            $("#unlogined_top").css("display", "inline");
            $("#logined_top").css("display", "none");
        }
    };

    //로그인 버튼 클릭시
    $("#login_btn").on("click", function(){
        let id = $("#ID").val();
        let pw = $("#PW").val();

        if(id===localStorage.id){
            if(pw===localStorage.pass){
                localStorage.setItem("login","OK");
                window.location.reload();
            }else {
                alert("비밀번호가 잘못되었습니다.");
            }
        }else {
            alert("아이디가 존재하지 않습니다.");
        }
    });
    
    //로그아웃
    $("#logout_btn").on("click", function () {
        localStorage.setItem("login", "No");
        window.location.reload();
    });

    //회원가입
    $("#signupBtn").on("click", function () {
        id = $("#id").val();
        pass = $("#pass").val();
        name = $("#name").val();
        address = $("#address").val();
        ph = $("#ph").val();

        if(id==""){
            alert("아이디를 입력하세요");
            $("#id").focus();
            return;
        }
        if(pass==""){
            alert("비밀번호를 입력하세요");
            $("#pass").focus();
            return;
        }
        if(name==""){
            alert("이름을 입력하세요");
            $("#name").focus();
            return;
        }
        if(address==""){
            alert("주소를 입력하세요");
            $("#address").focus();
            return;
        }
        if(ph==""){
            alert("전화번호를 입력하세요");
            $("#ph").focus();
            return;
        }

        localStorage.setItem('id', id);
        localStorage.setItem('pass', pass);
        localStorage.setItem('name', name);
        localStorage.setItem('address', address);
        localStorage.setItem('ph', ph);
        window.location.reload();
    });
});
