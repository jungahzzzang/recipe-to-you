<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>������ �α�</title>
	<link rel=��stylesheet�� href=��https://use.fontawesome.com/releases/v5.14.0/css/all.css��
     integrity=��sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc�� crossorigin=��anonymous��>
 	<link href=��https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap�� rel=��stylesheet��>
	<link rel="stylesheet" href="../../../Resources/Admin/Css/Point/pointRecord.css">
	<link rel="stylesheet" href="../../../Resources/Admin/Css/HomePageHeaderSide/reset.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="../../../Resources/Admin/Js/Point/pointRecord.js" charset="UTF-8"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css">
	
</head>
<body>
	<!-- �����ݷα� ������
		.mainTitle : �ֻ�� ȸ�� ���� �ڽ�
		.list_head : ��¥ �˻� ��ư�� �ִ� ���̺�
		.pointList_wrap : ������ �α� ���� ���̺�
		������, ���� �۾� ���� �����ؼ� css���� �ʿ�
		
	-->
	
	<div class="wrap">
		<div class="mainTitle">
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right-square-fill" viewBox="0 0 16 16">
  			<path d="M0 14a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2a2 2 0 0 0-2 2v12zm4.5-6.5h5.793L8.146 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L10.293 8.5H4.5a.5.5 0 0 1 0-1z"/>
			</svg>
			�����ݷα�
		</div>
	<form action="#" method="post">
	
		<div class="list_head">
			<table align="center" id="tableGroup">
				<tr>
					<td>
						<input type="checkbox">
						<!-- �޷� js �����Ǿ����� -->
						<input type="text" id="datepicker1"> ~
  						<input type="text" id="datepicker2">
						<input class="btn_option" type="button" value="���ó�¥">
						<input class="btn_option" type="button" value="�ֱ�1����">
						<input class="btn_option" type="button" value="�ֱ�15��">
						<input class="btn_option" type="button" value="�ֱ� 1����">
						<input class="btn_option" type="button" value="�ֱ�2����">
						<input class="btn_option" type="button" value="�ֱ�3����">
					</td>
				</tr>
				<tr>
					<td>
						<select name="payOption">
							<option value="pay_Option">����</option>
							<option value="Pay">����</option>
							<option value="Subtract">����</option>
						</select>
						
						<select name="searchOption">
							<option value="user_Id">���̵�</option>
							<option value="user_name">�̸�</option>
						</select>
						<input type="text" name="userSearch">
						<input class="search_btn" type="button" value="�˻�">
					</td>
				</tr>	
			</table>
			</div>
			
		<div class="middle_titleBox">
			�� 5���� �αװ� �˻��Ǿ����ϴ�.		
		</div>
		
		<div class="pointList_wrap">
		<table  align="center" id="tableGroup">
			<thead>
				<tr align="center" class="table_title">
					<td width="6%">
					<!-- ���̺� ���� �ִ� üũ�ڽ� Ŭ���� ��ü���õǴ� js�����Ǿ����� -->
					<input type="checkbox" id="checkAll" name="chk">
					</td>
					<td id="idCol">���̵�</td>
					<td id="nameCol">�̸�</td>
					<td id="cateCol">����</td>
					<td id="pointCol">������</td>
					<td id="logCol">�α�</td>
					<td id="dateCol">�߻���¥</td>
				</tr>
			</thead>
				
			<tbody class = "table_content">
				<tr>
					<td width="6%"><input type="checkbox" name="chk"></td>
					<!-- Ŭ���� ȸ������ �������� �Ѿ -->
					<td><a href="../User/aduserInfo.jsp">ezenac</a></td>
					<td>����</td>
					<td>����</td>
					<td>10</td>
					<td>��ǰ���� �ֹ��ڵ� : RANKUP_1468815394(����)</td>
					<td>2016-07-18-13:17:04</td>
				</tr>	
				
				<tr>
					<td width="6%"><input type="checkbox" name="chk"></td>
					<td><a href="../User/aduserInfo.jsp">ezenac</a></td>
					<td>����</td>
					<td>����</td>
					<td>10</td>
					<td>��ǰ���� �ֹ��ڵ� : RANKUP_1468815394(����)</td>
					<td>2016-07-18-13:17:04</td>
				</tr>	
				
				<tr>
					<td width="6%"><input type="checkbox" name="chk"></td>
					<td><a href="../User/aduserInfo.jsp">ezenac</a></td>
					<td>����</td>
					<td>����</td>
					<td>10</td>
					<td>��ǰ���� �ֹ��ڵ� : RANKUP_1468815394(����)</td>
					<td>2016-07-18-13:17:04</td>
				</tr>	
				
				<tr>
					<td width="6%"><input type="checkbox" name="chk"></td>
					<td><a href="../User/aduserInfo.jsp">ezenac</a></td>
					<td>����</td>
					<td>����</td>
					<td>10</td>
					<td>��ǰ���� �ֹ��ڵ� : RANKUP_1468815394(����)</td>
					<td>2016-07-18-13:17:04</td>
				</tr>	
				
				<tr>
					<td width="6%"><input type="checkbox" name="chk"></td>
					<td><a href="../User/aduserInfo.jsp">ezenac</a></td>
					<td>����</td>
					<td>����</td>
					<td>10</td>
					<td>��ǰ���� �ֹ��ڵ� : RANKUP_1468815394(����)</td>
					<td>2016-07-18-13:17:04</td>
				</tr>	
			</tbody>	
		</table>
		</div>	
		
		<!-- ��ưŬ���� ��ü���õǴ� js�����Ǿ����� -->
		<input type="button" value="��ü����" id="check_all">
		<!-- ��ưŬ���� ��ü���� �����Ǵ� js�����Ǿ����� -->
		<input type="button" value="��ü����" id="uncheck_all"><br><br><br>
		
		<div class="page_wrap">
			<div class="page_nation">
				<a class="arrow pprev" href="#"></a>
				<a class="arrow prev" href="#"></a>
				<a class="selectPage" href="#">1</a>
				<a href="#">2</a>
				<a href="#">3</a>
				<a href="#">4</a>
				<a href="#">5</a>
				<a href="#">6</a>
				<a href="#">7</a>
				<a href="#">8</a>
				<a href="#">9</a>
				<a class="arrow next" href="#"></a>
				<a class="arrow nnext" href="#"></a>
			</div>
		</div>	
	</form>	
	</div>
</body>
</html>