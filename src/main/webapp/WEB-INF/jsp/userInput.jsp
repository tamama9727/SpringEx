<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력화면</title>
<script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
</head>
<body>
	<form method="post" action="/ajax/user/insert">

		<label>이름 </label> <input type="text" name="name" id="nameInput">
		<label>생년월일 </label> <input type="text" name="yyyymmdd" id="yyyymmddInput">
		<label>자기소개</label> <br>
		<textarea rows="5" cols="100" name="introduce" id="introduceInput"></textarea>
		<label>이메일 </label> <input type="text" name="email" id = "emailInput"> <br>
		<button type="submit" id="adBtn">입력</button>
	</form>
	
	<script>
		${document}.ready(function(){
			
			${"#adBtn"}.on("click" , function(){
				let name = ${"#nameInput"}.val();
				let yyyymmdd = ${"#yyyymmddInput"}.val();
				let introduce = ${"#introduceInput"}.val();
				let email = ${"#emailInput"}.val();
				
				if(name == ""){
					alert("이름을 입력하세요");
					return;
				}
				
				if(yyyymmdd == ""){
					alert("생년월일을 입력하세요");
					return;
				}
				
				if(introduce == ""){
					alert("자기소개를 입력하세요");
					return;
				}
				
				if(email == ""){
					alert("이메일을 입력하세요");
					return;
				}
			});
		});
	</script>

</body>
</html>