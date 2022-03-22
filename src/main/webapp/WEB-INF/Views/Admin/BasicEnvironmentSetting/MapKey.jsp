<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>지도키관리</title>
</head>
<body>
	<div class="wrap">
		<form class="Mapkeypopup">
			<table>
				<caption>네이버 지도키 관리</caption>
					<tr>
						<th>URL</th>
						<<td>
							<input name="title" size="50" maxlength="100">
						</td>
						
					</tr>
					<tr>
						<th>지도키</th>
						<<td>
							<input name="title" size="50" maxlength="100">
						</td>
						
						<!-- 지도키와 URL 저장하는 버튼이다. 이것을 굳이 a태그로 만들어야 하나? 
						아니면 button으로 해야할까?  
						내가 하려는 것은 저장하고 보내는 기능이 아니라. 저장하고 보여주고 관리하는 것이다.-->

						<a onclick="" value="키저장"></a>
					</tr>	
				</table>	
		</form>
	</div>
</body>
</html>