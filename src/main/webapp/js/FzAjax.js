// 响应数据类型为json-----（eval()）
// js中函数可以作为一个对象当作参数
// method----请求方式get/post(String)
// url-------请求地址String
// data------参数例如：name=zhangsan&sex=0,无参数时传入null
// async-----控制false同步true异步
// deal200/404/500/----函数:传入时最好时匿名的函数,没有传入null
function getJSON(method,url,data,async,deal200,deal404,deal500,deal) {
	// 创建ajax引擎
   var ajax = getAjax();
    // 复写onreadystatechange函数
       // 复写onreadystatechange函数
       ajax.onreadystatechange = function() {
        // 判断Ajax状态码
        if (ajax.readyState == 4) {
            // 判断响应状态码
            if (ajax.status == 200) {
                // 获取响应内容
            	if(deal200){//强转boolean
            		deal200(ajax);
            	}
            } else if (ajax.status == 404) {
            	if(deal404){
            		deal404(ajax);
            	}
            } else if (ajax.status == 500) {
            	if(deal500){
            		deal500(ajax);
            	}
            }
        } else {
        	if(deal!=null){
        		deal(ajax);
        	}
        }
    }  
    // 发送请求
    if(method=="get"){
        ajax.open(method,url+(data==null?"":"?"+data),async)
        ajax.send(null); // 用来传递post参数的
    }else if(method=="post"){
        ajax.open(method,url,async);
        ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
        ajax.send(data);
    }

}

// 响应数据类型为xml-----（eval()）

// 创建ajax引擎
function getAjax(){
    var ajax;
    if(window.XMLHttpRequest){
        ajax = new XMLHttpRequest();
    }else if(window.ActiveXObject){
        ajax = new ActiveXObject("MSxml2.XMLHTTP");
    }
    return ajax;
}

// //json格式
// deal200 = function(ajax){
//     // 获取响应内容
//     var result = ajax.responseText;
//     var obj =eval('('+result+')');
//     // 处理响应内容
//     var tab = document.getElementById("tab");
//     tab.innerHTML = "";
//     // 插入一行表格
//     var tr = tab.insertRow(0);
//     var td1 = tr.insertCell(0);
//     td1.innerHTML = "用户名";
//     var td2 = tr.insertCell(1);
//     td2.innerHTML = "性别";
//     var td3 = tr.insertCell(2);
//     td3.innerHTML = "描述";
// }

// //xml格式
// deal200 = function(ajax){
//     // 获取响应内容
//     var doc = ajax.responseXML;
//     //value属性值  innerHTML标签之间的值
//     alert(doc.getElementsByTagName("name")[0].innerHTML);
//     /* var obj =eval('('+result+')'); */
    
//     // 处理响应内容
//     var tab = document.getElementById("tab");
//     tab.innerHTML = "";
//     // 插入一行表格
//     var tr = tab.insertRow(0);
//     var td1 = tr.insertCell(0);
//     td1.innerHTML = "用户名";
//     var td2 = tr.insertCell(1);
//     td2.innerHTML = "性别";
//     var td3 = tr.insertCell(2);
//     td3.innerHTML = "描述";
// }
