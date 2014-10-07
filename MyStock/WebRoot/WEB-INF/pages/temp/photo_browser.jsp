<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Insert title here</title>
<link href="front/css/css.css"  rel="stylesheet">

</head>
<body>
<body onload="slideShow()">
<div id="gallery">
  <div id="imagearea">
    <div id="image">
      <a href="javascript:imgNav(-1)" class="imgnav " id="previmg"></a>
      <a href="javascript:imgNav(1)" class="imgnav " id="nextimg"></a>
    </div>
  </div>
  <div id="thumbwrapper">
    <div id="thumbarea">
      <ul id="thumbs">
        <li value="1"><img src="front/img/1.jpg" width="179" height="100" alt="" /></li>
        <li value="2"><img src="front/img/2.jpg" width="179" height="100" alt="" /></li>
        <li value="3"><img src="front/img/3.jpg" width="179" height="100" alt="" /></li>
        <li value="4"><img src="front/img/4.jpg" width="179" height="100" alt="" /></li>
        <li value="5"><img src="front/img/5.jpg" width="179" height="100" alt="" /></li>
      </ul>
    </div>
  </div>
</div>
<script type="text/javascript">
var imgid = 'image';
var imgdir = 'front/img';
var imgext = '.jpg';
var thumbid = 'thumbs';
var auto = true;
var autodelay = 5;
</script>
<script type="text/javascript" src="front/js/slide.js"></script>
</body>
</html>