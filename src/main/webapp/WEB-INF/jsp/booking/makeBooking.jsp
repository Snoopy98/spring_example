<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<%-- datepicker를 위해 slim 버전이 아닌 jquery를 import한다. --%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
	
<%-- datepicker --%>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<style>
header {height:100px;}

.banner {height:500px;}

nav {height:40px; background-color:#E3871F;}
.nav-item .nav-link:hover {background-color:#A76417;}

.contents {min-height:500px;}
.contents .reservation-box {width:450px;}
.reserve {height:250px;}
.reserve .real-time-reserved {background-color:#B1520F;}
.reserve .confirm {background-color: #CF6317;}
.reserve .inquiry {background-color:#B1520F;}
.reserve-confirm {color:#fff; font-size: 25px; }

footer {height:80px; margin-top:30px;}

.input-form {width:230px; height:30px; margin-left:10px;}
.nav{background-color:#DF7401;}
.nav-link{color:white;}
</style>
</head>
<body>
<div id="wrap" class="container">
		<header class="d-flex justify-content-center align-items-center">
			<div class="display-4">통나무 팬션</div>
		</header>
		<nav>
			<ul class="nav nav-fill">
				<li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">팬션소개</a></li>
				<li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">객실보기</a></li>
				<li class="nav-item"><a href="/booking/make_booking_view" class="nav-link text-white font-weight-bold">예약하기</a></li>
				<li class="nav-item"><a href="/booking/booking_list_view" class="nav-link text-white font-weight-bold">예약목록</a></li>
			</ul>
		</nav>
		<section class="contents">
			<h2 class="text-center font-weight-bold m-4">예약 하기</h2>
			<div class="d-flex justify-content-center">
				<div class="reservation-box">
					<div class="subject-text my-2 font-weight-bold">이름</div>
					<input type="text" class="form-control" id="name">

					<div class="subject-text my-2 font-weight-bold">예약날짜</div>
					<input type="text" class="form-control" id="date">

					<div class="subject-text my-2 font-weight-bold">숙박일수</div>
					<input type="text" class="form-control" id="day">

					<div class="subject-text my-2 font-weight-bold">숙박인원</div>
					<input type="text" class="form-control" id="headcount">

					<div class="subject-text my-2 font-weight-bold">전화번호</div>
					<input type="text" class="form-control" id="phoneNumber">
					
					<button type="button" id="reservationBtn"
						class="btn btn-warning w-100 mt-3">예약하기</button>
				</div>
			</div>
		</section>
		<footer>
			<div class="text-secondary"> 
				<div><small>제주특별자치도 제주시 애월읍</small></div>
				<div><small>사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 / 대표:김통목</small></div> 
				<div><small>Copyright 2025 tongnamu. All right reserved.</small></div>
			</div>
		</footer>
	</div>
	<script>
		$(document).ready(function(){
			$('#date').datepicker({
				dateFormat : "yy-mm-dd",
				minDate:0 
			});
			
			$('#reservationBtn').on('click',function(){
				//alert("클릭");
				let name = $('#name').val().trim();
				let date = $('#date').val().trim();
				let day = $('#day').val().trim();
				let headcount = $('#headcount').val().trim();
				let phoneNumber = $('#phoneNumber').val().trim();
			
				//validation
				if(name == ""){
					alert("이름을 입력해주세요.");
					return;
				}
				if(date == ""){
					alert("날짜를 선택해주세요.");
					return;
				}
				if(day == ""){
					alert("숙박일수를 입력해주세요.");
					return;
				}
				if(isNaN(day)){ // 숫자가 아닐때 참 (나중에 다른건 정규식 검색)
					alert("숙박일수는 숫자만 입력 가능합니다.");
				return;
				}
				
				if(headcount ==""){
					alert("숙박인원을 입력해주세요");
					return;
				}
				if(isNaN(headcount)){
					alert("숙박인원은 숫자만 입력 가능합니다.")
					return;
				}
				if(phoneNumber == ""){ // 전화번호 정규식 검색
					alert("핸드폰 번호를 입력해주세요.")
					return;
				}
				
				$.ajax({
					// request
					type:"post"
					,url:"/booking_success"
					,data:{"name":name, "date":date, "day":day, "headcount":headcount, "phoneNumber":phoneNumber}
				//response
				,success:function(data){
					if(data.result == "성공"){
						alert("booking insert success");
						location.href = "/booking_Site_View";
					}else{
						alert(data.errorMessage);
					}
				}// success
				,error:function(request,status,error){
					alert("예약 실패했습니다. 관리자에게 문의 해주세요.")
				}//error
				});//ajax
			});// 예약하기 버튼
		});//ready
	</script>
</body>
</html>