<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
#tab {
	border: 1px solid;
}

body {
	margin: auto;
}
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/FzAjax.js"></script>
<script type="text/javascript">
	// 编写ajax函数   
	function getJsonData() {
		// 获取元素
		var ipt = document.getElementById("ipt");
		// 获取内容
		var nameval ="name="+ ipt.value;
		 getJSON("get","UserServlet",nameval,true,function(ajax){
				// 获取响应内容
				var doc = ajax.responseXML;
				//value属性值  innerHTML标签之间的值
				alert(doc.getElementsByTagName("name")[0].innerHTML);
				/* var obj =eval('('+result+')'); */
				
				// 处理响应内容
				var tab = document.getElementById("tab");
				tab.innerHTML = "";
				// 插入一行表格
				var tr = tab.insertRow(0);
				var td1 = tr.insertCell(0);
				td1.innerHTML = "用户名";
				var td2 = tr.insertCell(1);
				td2.innerHTML = "性别";
				var td3 = tr.insertCell(2);
				td3.innerHTML = "描述";
				// 
				
		 },null,null,function(ajax){
				document.getElementById("tab").innerHTML = "<img src='imgs/timg.gif' width='500px' height = '500px' >";
 
		 });
	}
</script>

</head>


<body>
	<input type="text" name="username" value=""  id="ipt"/>
	<input type="button" value="提交" id="btn" onclick="getJsonData()" />
	<table id="tab"></table>
	
</body>

</html>