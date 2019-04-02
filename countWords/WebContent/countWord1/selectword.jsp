<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>词频统计页面</title>
	<style type="text/css">
		#divTable{
			width: 450px;
			height: 110px;
			margin: 0 auto;
			background-color: #33ccff;
		}
	</style>
</head>
<body>

<div id="divTable">	
<form action="" method="post">
	<table id="table1" border="1" cellspacing="0">
		<tr>
			<td>请输入想要查询的单词:</td>
			<td colspan="2"><input type="file" name="inputFile" id="inputFile"></td>
		</tr>
		<tr>
			<td>请输入想要查询的单词：</td>
			<td><input type="text" name="words" id="words"></td>
			<td><input type="submit" value="查询"></td>
		</tr>
		<tr>
			<td>请输入想要查询的前n个高频词汇：</td>
			<td><input type="text" name="number" id="number"></td>
			<td><input type="submit" value="查询"></td>
		</tr>
	</table>
</form>
</div>
</body>
<ml>
