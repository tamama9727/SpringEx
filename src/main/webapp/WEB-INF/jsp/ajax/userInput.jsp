<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userInput</title>
</head>
<body>
	<%-- <form method = "post" action = "/ajax/user/insert">--%>
		<label>이름</label> <input type = "text" name = "name" id = "nameInput"><br>
		<label>생년월일</label> <input type = "text" name = "yyyymmdd" id = "yyyymmddInput"><br>
		<label>자기소개</label><br>
		<textarea rows = "5" cols = "30" name = "introduce" id = "introduceInput"></textarea><br>
		<label>이메일</label> <input type = "text" name = "email" id = "emailInput"><br>
		<button type = "submit" id="adBtn">추가</button>
	
	<script>
		${document}.ready(function(){
			
			${"#adBtn"}.on("click" , function(){
				let name = ${"#nameInput"}.val();
				let yyyymmdd = ${"#yyyymmddInput"}.val();
				let introduce = ${"#introduceInput"}.val();
				let email = ${"#emailInput"}.val();
				
				if(name == ""){
					alert("이름을 입력하세요");
					return false;
				}
				
				if(yyyymmdd == ""){
					alert("생년월일을 입력하세요");
					return false;
				}
				
				if(introduce == ""){
					alert("자기소개를 입력하세요");
					return false;
				}
				
				if(email == ""){
					alert("이메일을 입력하세요");
					return false;
				}
				$.ajax({
					type:"post",
					url:"/ajax/user/insert",
					data:{"name":name , "yyyymmdd":yyyymmdd , "introduce":introduce , "email":email },
					success:function(data){
						alert(data)
						
					},
					error:function(){
						alert("에러발생");
					}
				});
				
			});
	
			
/* 			${"#adBtn"}.on("click" , function(){
				let name = ${"#nameInput"}.val();
				let yyyymmdd = ${"#yyyymmddInput"}.val();
				let introduce = ${"#introduceInput"}.val();
				let email = ${"#emailInput"}.val();
				
				if(name == ""){
					alert("이름을 입력하세요");
					return false;
				}
				
				if(yyyymmdd == ""){
					alert("생년월일을 입력하세요");
					return false;
				}
				
				if(introduce == ""){
					alert("자기소개를 입력하세요");
					return false;
				}
				
				if(email == ""){
					alert("이메일을 입력하세요");
					return false;
				}
			});
		}); */
	</script>
</body>
</html>