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
<script type="text/javascript">
	// 编写ajax函数   
	function getJsonData() {
		// 获取元素
		var ipt = document.getElementById("ipt");
		// 获取内容
		var nameval = ipt.value;
		
		// 创建ajax引擎
		var ajax;
		if (window.XMLHttpRequest) {
			ajax = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			ajax = new ActiveXObject("MSxml2.XMLHTTP");
		}

		//复写onreadystatechange()函数
		ajax.onreadystatechange = function() {
			//判断ajax状态码
			if (ajax.readyState == 4) {
				// 判断响应状态码
				if (ajax.status == 200) {
					// 获取响应内容
					var result = ajax.responseText;
					var obj =eval('('+result+')');
					
					
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
					var tr = tab.insertRow(1);
					var td1 = tr.insertCell(0);
					td1.innerHTML = obj.id;
					var td2 = tr.insertCell(1);
					td2.innerHTML =obj.name;
					var td3 = tr.insertCell(2);
					td3.innerHTML =obj.sex;
					
				}
			} else {
				document.getElementById("tab").innerHTML = "<img src='imgs/timg.gif' width='500px' height = '500px' >";
			}
		}
		// 发送请求
		ajax.open("get", "UserServlet?name="+nameval);
		ajax.send(null);
	}
</script>

</head>


<body>
	<input type="text" name="username" value=""  id="ipt"/>
	<input type="button" value="提交" id="btn" onclick="getJsonData()" />
	<table id="tab"></table>
	
</body>

</html>