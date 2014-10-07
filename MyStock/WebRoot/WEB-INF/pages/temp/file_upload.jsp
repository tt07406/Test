<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Insert title here</title>
<link href="front/css/bootstrap.css" rel="stylesheet">
<link href="front/css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
<script src="front/js/jquery.min.js"></script>
<script src="front/js/fileinput.js" type="text/javascript"></script>
</head>
<body>
<div style="width:1000px;margin: 0 auto;">
<form action="UploadController" method="post" enctype="multipart/form-data">
	<input id="input-id"  type="file" class="file" data-preview-file-type="text" >
</form>
</div>
<script type="text/javascript">
$(document).ready(function(){
	// initialize with defaults
	$("#input-id").fileinput();
	// with plugin options
	$("#input-id").fileinput({'showUpload':false, 'previewFileType':'any'});
});
</script>
</body>
</html>