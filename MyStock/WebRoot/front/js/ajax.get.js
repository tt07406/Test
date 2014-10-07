//全局变量，存储Ajax返回数据
var GLOBAL={};
GLOBAL.artlist=[];
/* 函数功能:创建XMLHttpRequest对象
 * 参数列表:无
 *  返回值:XMLHttpRequest对象
 */
function XMLHttpRequestCreat(){
	var xmlhttp;
	if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	}else{// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlhttp;
}

/*函数功能:获得文章列表
 *参数列表:type--文章类型
 * 返回值:null
 */
(function FF0010(){
	//创建XMLHttpRequest
	var xmlhttp=XMLHttpRequestCreat();
	//配置XMLHttpRequest对象
	xmlhttp.open("GET","http://localhost:8080/Stockii Personal Temp/test.txt",true);
	//设置回调函数
	xmlhttp.onreadystatechange=function(){
	  if (xmlhttp.readyState==4 && xmlhttp.status==200){
	    //document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
		  GLOBAL.artlist=eval("("+xmlhttp.responseText+")");
		  //显示文章列表
		  var i=0;
		  while(GLOBAL.artlist.index[i]){
			  var liObj="<li class='lsit_item'><a href='javascript:void(0)'>"+GLOBAL.artlist.index[i].newsInfoTitle+"</a></li>";
			  $("#article_list").append(liObj);
			  i++;
		  }
	    }
	};
	//发送数据
	xmlhttp.send();
})();

/* 函数功能:查看文章详细信息 包括文章id，文章名，作者，文章详细信息，创建时间等
 * 参数列表:id--文章id;
 *  返回值:
 */
(function FF0011(id){
	//创建XMLHttpRequest
	var xmlhttp=XMLHttpRequestCreat();	
	//配置XMLHttpRequest对象
	xmlhttp.open("GET","http://localhost:8080/Stockii Personal Temp/test.txt",true);
	//设置回调函数
	xmlhttp.onreadyStateChange=function(){
	  if (xmlhttp.readyState==4 && xmlhttp.status==200){
	    //document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
	     tt=xmlhttp.responseText;
	    }
	};
	//发送数据
	xmlhttp.send();
})();
