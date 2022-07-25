<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userInput</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
	<%-- <form method = "post" action = "/ajax/user/insert">--%>
		<label>이름</label> <input type = "text" name = "name" id = "nameInput"><button id="duplicateBtn" type = "button">중복확인</button><br>
		<label>생년월일</label> <input type = "text" name = "yyyymmdd" id = "yyyymmddInput"><br>
		<label>자기소개</label><br>
		<textarea rows = "5" cols = "30" name = "introduce" id = "introduceInput"></textarea><br>
		<label>이메일</label> <input type = "text" name = "email" id = "emailInput"><br>
		<button type = "button" id="addBtn">추가</button>
	
	<script>
		$(document).ready(function(){
			
			$("#duplicateBtn").on("click",function(){
				//이름 인풋에 입력한 이름이 중복인지 확인
				let name = $("#nameInput").val();
				if(name == ""){
					alert("이름을 입력하세요");
					return false;
				}
				
				$.ajax({
					type:"get",
					url:"/ajax/user/is_duplicate",
					data:{"name":name},
					success:function(data){
						if(data.is_duplicate){
							alert("중복된 이름 입니다");
						}else{
							alert("사용가능한 이릅입니다.");
						}
					},
					error:function(){
						alert("에러발생");
					}
				});
				
			});
			
			$("#addBtn").on("click" , function(){
				
				let name = $("#nameInput").val();
				let yyyymmdd = $("#yyyymmddInput").val();
				let introduce = $("#introduceInput").val();
				let email = $("#emailInput").val();
				
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
					//리스펀스를 위한 옵션
					success:function(data){
						//alert(data)
						//{"result" : "success" or "fail"} 값이 넘어 온다.
						
						//만약에 성공했으면 리스트로 이동
						if(data.result == "success"){
							location.href = "/ajax/user/list"
						}else{
							alert("삽입 실패!!")
						}
						//실패 했으면 alert 뛰우기
						alert(data.result);
						
						
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
			*/
		}); 
	</script>
</body>
</html>