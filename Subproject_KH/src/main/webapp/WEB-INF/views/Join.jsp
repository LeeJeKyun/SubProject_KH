<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="favicon.ico">
<title>회원가입</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
// jQuery
$(function() {
	
	$("#btnJoin").mouseover(function() {
		
		$("#btnJoin").css("cursor","pointer")
	})
	
	$("form").submit( function() {
		// 유효성 검사가 false일 때
		if( !checkInfo() ) {
			return false
		} 
	})
	
	// id focus 초기화
	$("#id").focus();
	
	$("#id").focus(function() {
		$("#idmsg").html("")
	})
	
	// id input blur 시 이벤트 설정
	$("#id").blur(function() {
		var idReg = /^[a-zA-z][a-zA-z0-9]{4,19}$/
		
		if ( !idReg.test( $("#id").val())) {
			$("#idmsg").html("아이디는 5~20자리 영문과 숫자만 가능합니다")
		}
		
		if( $("#id").val() == '') {
			$("#idmsg").html("아이디를 입력해주세요!")
		}
	})

	
	$("#pw").focus(function() {
		
		$("#pwmsg").html("")
		
		if( $("#id").val() == '') {
			$("#idmsg").html("아이디를 입력해주세요!")
		}
	})
	
	$("#pw").blur(function() {
		
		if( $("#pw").val() == '' ) {
			$("#pwmsg").html("비밀번호를 입력해주세요!")
		}
		
		var pwReg = /^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[!@#$%^&*\-_=+])[a-zA-Z0-9!@#$%^&*\-_=+]{8,20}$/
		
		if ( !pwReg.test( $("#pw").val())) {
				$("#pwmsg").html("비밀번호는 영문 대소문자, 숫자, 특수문자 8~20자")
		}
		
	})
	
	$("#rpw").focus(function() {

		if( $("#pw").val() == '' ) {
			$("#pwmsg").html("비밀번호를 입력해주세요!")
		}
		
		if( $("#rpw").val() == '') {
			$("#rpwmsg").html("비밀번호를 입력해주세요!")
		}
		
		
	})
	
	$("#rpw").blur(function() {
		if( $("#pw").val() != $("#rpw").val()) {
			$("#rpwmsg").html("비밀번호가 다릅니다")
		}
		if( $("#id").val() == '') {
			$("#idmsg").html("아이디를 입력해주세요!")
		}
		if( $("#pw").val() == '') {
			$("#pwmsg").html("비밀번호를 입력해주세요!")
		}
		if( $("#rpw").val() == '') {
			$("#rpwmsg").html("비밀번호를 입력해주세요!")
		}
	})
	
	$("#mail").focus(function() {
		if( $("#id").val() == '') {
			$("#idmsg").html("아이디를 입력해주세요!")
		}
		if( $("#pw").val() == '') {
			$("#pwmsg").html("비밀번호를 입력해주세요!")
		}
		if( $("#rpw").val() == '') {
			$("#rpwmsg").html("비밀번호를 입력해주세요!")
		}
	})
	
	$("#mail").blur(function() {
		if( $("#id").val() == '') {
			$("#idmsg").html("아이디를 입력해주세요!")
		}
		if( $("#pw").val() == '') {
			$("#pwmsg").html("비밀번호를 입력해주세요!")
		}
		if( $("#rpw").val() == '') {
			$("#rpwmsg").html("비밀번호를 입력해주세요!")
		}
		if( $("#mail").val() == '') {
			$("#mailmsg").html("이메일을 입력해주세요!")
		}
	})
	
	
	// 포커스 들어오면 문구 삭제
	
	$("#pw").focus(function() {
		$("#pwmsg").html("")
	})
	$("#rpw").focus(function() {
		$("#rpwmsg").html("")
	})
	$("#mail").focus(function() {
		$("#mailmsg").html("")
	})
	
})
// Global Scope
function checkInfo() {
	
	if( $("#id").val() == '') {
		$("#idmsg").html("아이디를 입력해주세요!")
		return false
	}
	
	var idReg = /^[a-zA-z][a-zA-z0-9]{4,19}$/
	
	if ( !idReg.test( $("#id").val())) {
		$("#idmsg").html("아이디는 5~20자리 영문과 숫자만 가능합니다")
		return false
	}
	
	if( $("#pw").val() == '') {
		$("#pwmsg").html("비밀번호를 입력해주세요!")
		return false
	}
	
	var pwReg = /^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[!@#$%^&*\-_=+])[a-zA-Z0-9!@#$%^&*\-_=+]{8,20}$/
	
	if ( !pwReg.test( $("#pw").val())) {
			$("#pwmsg").html("비밀번호는 영문 대소문자, 숫자, 특수문자 8~20자")
		return false
	}
	
	if( $("#pw").val() != $("#rpw").val() ) {
		$("#rpwmsg").html("비밀번호가 다릅니다")
		return false
	}

	if( $("#rpw").val() == '' ) {
		$("#rpwmsg").html("비밀번호가 다릅니다")
		return false
	}

	if( $("#mail").val() == '' ) {
		$("#mailmsg").html("이메일을 입력해주세요")
	}
	
	var mReg = /^[0-9a-zA-Z]([\-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([\-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
	if( !mReg.test( $("#mail").val())) {
		$("#mailmsg").html("이메일 형식에 맞게 입력해주세요")
	}
	
	return true;
}
</script>
<style type="text/css">
@font-face {
	font-family: 'NotoSansKR';
	font-style: normal;
	font-weight: 400;
	src: url(../kh/resources/font/NotoSansKR-Regular.otf);
}
body { font-family: 'NotoSansKR', sans-serif; }
#joinWrap {
	margin: 0 auto;
	width: 300px;
}
h1 {
	text-align: center;
	margin-bottom: 50px;
	font-weight: bold;
}
.contentWrap{
	display: block;
}
input{
	width: 295px;
	height: 35px;
	border-radius: 5px;
	border: 1px solid #ccc;
}
.content{
	margin-bottom: 3px;
	font-weight: bold;
}
.errmsg{
	display: block;
	color: red;
	font-size: 0.8em;
	margin-bottom: 23px;
	height: 17px;
}
.info{
	font-size: 0.6em;
	font-weight: bold;
}
#btnJoin{
	width: 295px;
	height: 40px;
	background-color: #3999E9;
	border: none;
	color: white;
	font-weight: bold;
	font-size: 1.0em;
	border-radius: 5px;
}
#siteInfo{
	position: relative;
	height: 75px;
}
#law{
	font-size: 0.9em;
	text-decoration: underline;
	color: #118FF9;
	position: absolute;
	top: 75px;
	left: 50px;
}
#plaw{
	font-size: 0.9em;
	text-decoration: underline;
	color: #118FF9;
	position: absolute;
	top: 75px;
	left: 140px;
}
#bottom{
	text-align: center;
}
</style>
</head>
<body>
<div id="joinWrap">
<form action="/kh/member/join" method="post">
	<h1>KH 커뮤니티</h1>
	

		<span class="content">아이디</span>
		<span class="info">(5~20자리 영문과 숫자만 가능)</span>
		<span class="contentWrap">
			<input type="text" id="id" name="id">
		</span>
		<span class="errmsg" id="idmsg"></span>
	
		<span class="content">비밀번호</span>
		<span class="info">(영문 대소문자, 숫자, 특수문자 8~20자)</span>
		<span class="contentWrap">
			<input type="password" id="pw" name="pw">
		</span>
		<span class="errmsg" id="pwmsg"></span>
	
		<span class="content">비밀번호 재확인</span>
		<span class="contentWrap">
			<input type="password" id="rpw" name="rpw">
		</span>
		<span class="errmsg" id="rpwmsg"></span>
	
		<span class="content">이메일</span>
		<span class="contentWrap">
			<input type="text" id="mail" name="mail">
		</span>
		<span class="errmsg" id="mailmsg"></span>
	
		<button id="btnJoin" name="join" >Join Us</button>
		
		<div id="siteInfo">
			<span id="law"><a href="">이용약관</a></span>
			<span id="plaw"><a href="">개인정보처리방침</a></span>
		</div>
		
		<div id="bottom">
			<h6>KH351 Copyright by Sub-Project</h6>
		</div>
	
	
	
</form>	
</div>
</body>
</html>