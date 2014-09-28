function validateAdminName(name){
	if(name == ""){
		document.getElementById("adminid_msg").innerHTML = "<img src=\""+url+"/images/wrong.gif\">" + "<font color=\"red\">管理员名称不能为空！</font>" ;
		return false ;
	} else {
		document.getElementById("adminid_msg").innerHTML = "<img src=\""+url+"/images/right.gif\">" + "<font color=\"green\">管理员名称输入正确！</font>" ;
		return true ;
	}
}
function validateNote(note){
	if(note == ""){
		document.getElementById("note_msg").innerHTML = "<img src=\""+url+"/images/wrong.gif\">" + "<font color=\"red\">管理员组简介不能为空！</font>" ;
		return false ;
	} else {
		document.getElementById("note_msg").innerHTML = "<img src=\""+url+"/images/right.gif\">" + "<font color=\"green\">管理员组简介输入正确！</font>" ;
		return true ;
	}
}
function validatePassword(password){
	if(!(/^[a-zA-Z]\w{4,17}$/.test(password))){
		document.getElementById("password_msg").innerHTML = "<img src=\""+url+"/images/wrong.gif\">" + "<font color=\"red\">密码必须以字母开头，长度在5-18之间！</font>" ;
		return false ;
	} else {
		document.getElementById("password_msg").innerHTML = "<img src=\""+url+"/images/right.gif\">" + "<font color=\"green\">密码输入正确！</font>" ;
		return true ;
	}
}
function validateNewPassword(password){
	if(!(/^[a-zA-Z]\w{4,17}$/.test(password))){
		document.getElementById("new_password_msg").innerHTML = "<img src=\""+url+"/images/wrong.gif\">" + "<font color=\"red\">密码必须以字母开头，长度在5-18之间！</font>" ;
		return false ;
	} else {
		document.getElementById("new_password_msg").innerHTML = "<img src=\""+url+"/images/right.gif\">" + "<font color=\"green\">登录密码输入正确！</font>" ;
		return true ;
	}
}
function validateConf(conf){
	if(document.getElementById("newpassword").value != conf){
		document.getElementById("conf_msg").innerHTML = "<img src=\""+url+"/images/wrong.gif\">" + "<font color=\"red\">两次输入的密码不一致！</font>" ;
		return false ;
	} else {
		document.getElementById("conf_msg").innerHTML = "<img src=\""+url+"/images/right.gif\">" + "<font color=\"green\">密码验证通过！</font>" ;
		return true ;
	}
}
function validate(f){
	return	validateAdminName(f.adminName.value) && 
			validateNote(f.note.value) &&
	        validateNewPassword(f.newpassword.value) &&
	        validatePassword(f.password.value) && 
			validateConf(f.conf.value);
}

function validateAdd(f){
	return	validateAdminName(f.adminName.value) && 
			validateNote(f.note.value) &&
	        validatePassword(f.password.value);
}