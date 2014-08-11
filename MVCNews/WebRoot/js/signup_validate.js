function validateEmail(mid){
	if(!(/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/.test(mid))){
		$('#tip_email').text("�����˻����Ʊ����������ʽ");
		return false ;
	} else {
		$('#tip_email').text("");
		return true ;
	}
}

function validatePassword(password){
	if(!(/^\w{5,15}$/.test(password))){
		$('#tip_psw').text("��������ĸ��������ɣ�������6-16λ֮��");
		return false ;
	} else {
		$('#tip_psw').text("");
		return true ;
	}
}

function validatePhone(telephone){
	if(!(/^((\d{3,4})|\d{3,4}-)?\d{7,8}$/.test(telephone))){
		$('#tip_phone').text("�ֻ��������������");
		return false ;
	} else {
		$('#tip_phone').text("");
		return true ;
	}
}

function validatePswConf(conf){
	$('#tip_phone').text("�ֻ��������������");
	if($('#id_password').val() != conf){
		$('#tip_pswconf').text("�����������벻һ��");
		return false ;
	} else {
		$('#tip_pswconf').text("");
		return true ;
	}
}

//function validateEmail(email){
//	if(!(/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/.test(email))){
//		document.getElementById("address_msg").innerHTML = "<img src=\""+url+"/images/wrong.gif\">" + "<font color=\"red\">Email��ַ��ʽ����</font>" ;
//		return false ;
//	} else {
//		document.getElementById("address_msg").innerHTML = "<img src=\""+url+"/images/right.gif\">" + "<font color=\"green\">Email��ַ������ȷ��</font>" ;
//		return true ;
//	}
//}
function validateIdNumber(IdNumber){
	if(!(isIdCardNo(IdNumber))){	// 100088
		$("#tip_idnumber").text("��������ȷ�����֤����");
		return false ;
	} else {
		$('#tip_idnumber').text("");
		return true ;
	}
}
function validateRealName(name){
	if(name == null){	// 100088
		$("#tip_realname").text("��ʵ����������Ϊ��");
		return false ;
	} else {
		$('#tip_realname').text("");
		return true ;
	}
}
function isIdCardNo(num)
{  
       num = num.toUpperCase(); 
         //���֤����Ϊ15λ����18λ��15λʱȫΪ���֣�18λǰ17λΪ���֣����һλ��У��λ������Ϊ���ֻ��ַ�X��  
       if (!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(num)))  
       {
               alert('��������֤�ų��Ȳ��ԣ����ߺ��벻���Ϲ涨��\n15λ����ӦȫΪ���֣�18λ����ĩλ����Ϊ���ֻ�X��');
               return false;
        }
			//У��λ����ISO 7064:1983.MOD 11-2�Ĺ涨���ɣ�X������Ϊ������10��
			//����ֱ�����������ں�У��λ
		var len, re;
		len = num.length;
		if (len == 15)
		{
			re = new RegExp(/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/);
			var arrSplit = num.match(re);
			
			//������������Ƿ���ȷ
			var dtmBirth = new Date('19' + arrSplit[2] + '/' + arrSplit[3] + '/' + arrSplit[4]);
			var bGoodDay;
			bGoodDay = (dtmBirth.getYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4]));
			if (!bGoodDay)
			{
			    alert('��������֤����������ڲ��ԣ�');  
			    return false;
			}
			else
			{
			//��15λ���֤ת��18λ
			//У��λ����ISO 7064:1983.MOD 11-2�Ĺ涨���ɣ�X������Ϊ������10��
			          var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
			           var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
			           var nTemp = 0, i;  
			            num = num.substr(0, 6) + '19' + num.substr(6, num.length - 6);
			           for(i = 0; i < 17; i ++)
			          {
			                nTemp += num.substr(i, 1) * arrInt[i];
			           }
			           num += arrCh[nTemp % 11];  
			            return num;  
			}  
		}
		if (len == 18)
		{
			re = new RegExp(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/);
			var arrSplit = num.match(re);
			
			//������������Ƿ���ȷ
			var dtmBirth = new Date(arrSplit[2] + "/" + arrSplit[3] + "/" + arrSplit[4]);
			var bGoodDay;
			bGoodDay = (dtmBirth.getFullYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4]));
			if (!bGoodDay)
			{
				alert(dtmBirth.getYear());
				alert(arrSplit[2]);
				alert('��������֤����������ڲ��ԣ�');
				return false;
			}
			else
			{
				//����18λ���֤��У�����Ƿ���ȷ��
				//У��λ����ISO 7064:1983.MOD 11-2�Ĺ涨���ɣ�X������Ϊ������10��
				var valnum;
				var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
				var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
				var nTemp = 0, i;
				for(i = 0; i < 17; i ++)
				{
					nTemp += num.substr(i, 1) * arrInt[i];
				}
				valnum = arrCh[nTemp % 11];
				if (valnum != num.substr(17, 1))
				{
					alert('18λ���֤��У���벻��ȷ��Ӧ��Ϊ��' + valnum);
					return false;
				}
				return num;
			}
		}
		return false;
} 

function validate(f){
	return	validateEmail(f.email.value) && 
			validatePassword(f.password.value) && 
			validatePswConf(f.pswconf.value) && 
//			validateConf(f.conf.value) && 
			validatePhone(f.phone.value) && 
			validateIdNumber(f.idnumber.value) && 
			validateRealName(f.realName.value);
}