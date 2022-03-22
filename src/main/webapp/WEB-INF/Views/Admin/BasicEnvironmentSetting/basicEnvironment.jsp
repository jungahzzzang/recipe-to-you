<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>기본환경설정</title>
<link rel="stylesheet"
	href="../../../Resources/Admin/Css/BasicEnvironmentSetting/basciEnvironment.css">
</head>
<body>

	<div class="wrap">
		<div class="main-content">
			<!-- 전체 테이블 구조 전체적으로 8개의 테이블이 있고 하나의 폼으로 제출한다.  -->
			<form action="" method="POST" name="userComment" autocomplete="off" name="basic_form">				<table class="subtitle" align="center">
					<caption>| 사이트 타이틀명 설정</caption>
					<tr>
						<th>타이틀명</th>
						<td><input name="title" size="50" maxlength="100"></td>
					</tr>
				</table>
				<table class="subtitle" align="center">
					<caption>| 사이트명 설정</caption>
					<tr>
						<th>사이트명</th>
						<td><input name="title" size="50" maxlength="100"></td>
					</tr>
				</table>
				<table class="subtitle" align="center">
					<caption>| 관리자 이메일 설정</caption>
					<tr>
						<th>관리자 이메일</th>
						<td><input name="title" size="50" maxlength="100"></td>
					</tr>
				</table>
				<table class="subtitle" align="center">
					<caption>| 즐겨찾기 설정</caption>
					<tr>
						<th>즐겨찾기명</th>
						<td><input name="title" size="50" maxlength="100"></td>
					</tr>
				</table>
				<table class="subtitle" align="center">
					<caption>| 관리자휴대번호 설정</caption>
					<tr>
						<th>관리자휴대번호</th>
						<td><input name="title" size="50" maxlength="100"></td>
					</tr>
				</table>
				<table class="subtitle" align="center">
					<caption>| 프레임셋 설정</caption>
					<tr>
						<th>프레임셋</th>
						<td><input type="radio" id="use" name="number" checked>사용함
							<input type="radio" id="use" name="number" checked>사용하지
							않음</td>
					</tr>
				</table>
				<!-- 두번째 테이블  -->
				<table class="subtitle" align="center">
					<caption>| 메타태그 설정</caption>
					<tr>
						<th>메타태그 입력</th>
						<td>
							<form>
								<textarea rows='5' cols='50'></textarea>
							</form>
						</td>
					</tr>
				</table>
				<table class="subtitle" align="center">
					<caption>| 지도API/ 약도 설정</caption>
					<tr>
						<th>카카오지도 API</th>
						<td>
							<button value="팝업창호출" onclick="showPopup()">지도키관리</button>
							 <script anguage="javascript">
	 							 function showPopup() { window.open("MapKey.jsp", "a", "width=700, height=500, left=100, top=50"); }
	  						</script>
						</td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" id="address_kakao" name="address"readonly /></td>
					</tr>
					<!-- 카카오지도 자바스크립트 적용 부분 -->
					<tr>
						<th>상세 주소</th>
						<td><input type="text" name="address_detail" /></td>
					</tr>
						<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
						<script>
									window.onload = function() {
										document
												.getElementById("address_kakao")
												.addEventListener(
														"click",
														function() { //주소입력칸을 클릭하면
															//카카오 지도 발생
															new daum.Postcode(
																	{
																		oncomplete : function(
																				data) { //선택시 입력값 세팅
																			document
																					.getElementById("address_kakao").value = data.address; // 주소 넣기
																			document
																					.querySelector(
																							"input[name=address_detail]")
																					.focus(); //상세입력 포커싱
																		}
																	}).open();
														});
									}
						</script>
					</tr>
					<tr>
						<th>약도설정</th>
						<td><input type="radio" id="use" name="number" checked>지도API사용
							<input type="radio" id="use" name="number" checked>파일업로드
							<input name="kakaoMap">
							<div id="map" style="width: 500px; height: 400px;"></div> <!-- 카카오지도 연동 도메인이 꼭 필요 -->
							<script type="text/javascript"
								src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b8b4b9b2fef23c0f4624cc74033495df"></script>
							<script>
										var container = document.getElementById('map');
										var options = {
											center: new kakao.maps.LatLng(33.450701, 126.570667),
											level: 3
										};
								
										var map = new kakao.maps.Map(container, options);
									</script></td>
					</tr>
				</table>
			</form>
			
			<!-- 전체 설정을 저장하는 기능  -->
			<div>
				<a onclick="#">
					<button>저장하기</button>
				</a>
			</div>
		</div>
	</div>
</body>
</html>