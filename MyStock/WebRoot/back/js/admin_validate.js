function validateAdminName(name){
	if(name == ""){
		document.getElementById("adminid_msg").innerHTML = "<img src=\""+url+"/images/wrong.gif\">" + "<font color=\"red\">����Ա���Ʋ���Ϊ�գ�</font>" ;
		return false ;
	} else {
		document.getElementById("adminid_msg").innerHTML = "<img src=\""+url+"/images/right.gif\">" + "<font color=\"green\">����Ա����������ȷ��</font>" ;
		return true ;
	}
}
function validateNote(note){
	if(note == ""){
		document.getElementById("note_msg").innerHTML = "<img src=\""+url+"/images/wrong.gif\">" + "<font color=\"red\">����Ա���鲻��Ϊ�գ�</font>" ;
		return false ;
	} else {
		document.getElementById("note_msg").innerHTML = "<img src=\""+url+"/images/right.gif\">" + "<font color=\"green\">����Ա����������ȷ��</font>" ;
		return true ;
	}
}
function validatePassword(password){
	if(!(/^[a-zA-Z]\w{4,17}$/.test(password))){
		document.getElementById("password_msg").innerHTML = "<img src=\""+url+"/images/wrong.gif\">" + "<font color=\"red\">�����������ĸ��ͷ��������5-18֮�䣡</font>" ;
		return false ;
	} else {
		document.getElementById("password_msg").innerHTML = "<img src=\""+url+"/images/right.gif\">" + "<font color=\"green\">����������ȷ��</font>" ;
		return true ;
	}
}
function validateNewPassword(password){
	if(!(/^[a-zA-Z]\w{4,17}$/.test(password))){
		document.getElementById("new_password_msg").innerHTML = "<img src=\""+url+"/images/wrong.gif\">" + "<font color=\"red\">�����������ĸ��ͷ��������5-18֮�䣡</font>" ;
		return false ;
	} else {
		document.getElementById("new_password_msg").innerHTML = "<img src=\""+url+"/images/right.gif\">" + "<font color=\"green\">��¼����������ȷ��</font>" ;
		return true ;
	}
}
function validateConf(conf){
	if(document.getElementById("newpassword").value != conf){
		document.getElementById("conf_msg").innerHTML = "<img src=\""+url+"/images/wrong.gif\">" + "<font color=\"red\">������������벻һ�£�</font>" ;
		return false ;
	} else {
		document.getElementById("conf_msg").innerHTML = "<img src=\""+url+"/images/right.gif\">" + "<font color=\"green\">������֤ͨ����</font>" ;
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