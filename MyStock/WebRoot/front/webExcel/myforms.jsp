<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html  xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>我的表单</title>
<!--[if IE]>
<STYLE type=text/css media=screen>@import url(./ie.css );
</STYLE>
<![endif]-->
<!--[if lte IE 7]>
	<style type="text/css" media="screen">
    @import url("./ie7.css");
	</style>	
<![endif]-->
<!--SCRIPT type=text/javascript src="js/ext-base.js"></SCRIPT-->
<!--SCRIPT type=text/javascript src="js/ext-all0.js"></SCRIPT-->
<link rel="stylesheet" type="text/css" href="ext-2.2/resources/css/ext-all.css" />
<script type="text/javascript" src="ext-2.2/adapter/ext/ext-base.min.js"></script>
<script type="text/javascript" src="ext-2.2/ext-all.js"></script>
<script type=text/javascript src="js/6excel.js"></SCRIPT>
<link rel="stylesheet" type="text/css" href="js/6excel.css" />
<script type=text/javascript>
	function load(){			
		window.ogID = '' ;
		window.ogWID = '' ;
        var application = new Bao.Excel(document.body);
        // Display logo..
        var logo_div = document.getElementById('logo');
		if ( logo_div ) {
			//logo_div.style.display = "block"; 
		}
	}
</script>
</head>
<bodY id=body onload="load();">
    <div style="z-index: 1001;" id="logo"></div>
    
    <div id=west></div>
    
    <div id=north></div>
    
    <div style="z-index: 50000; position: absolute" id=dialog-container></div>
    
    <div id=center></div>
    
    <div style="width: 200px; height: 200px; overflow: hidden" id=east></div>
    
    <div id=south></div>
</body>
</html>