<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%> 
<script type="text/javascript">
  function validate(f){
  			if (!(/^[a-zA-Z]\w{5,17}$/.test(f.mid.value))){
  				alert("以字母开头，长度在6-18之间！");
  				f.mid.focus();
  				return false;
  			}
  			if (!(/^\w{5,15}$/.test(f.password.value))){
  				alert("密码必须是5~15位！");
  				f.password.focus();
  				return false;
  			}
  			return true;
  } 
</script>
<center>
	<h1>会员登陆</h1>
	<hr>
	<s:text name="info"></s:text>
	<s:form action="UserLogin" method="post" onsubmit="return validate(this);"> 
	    <s:textfield name="mid" label="用户名"/>
	    <s:password  name="password" label="密&nbsp;&nbsp;码"/>
	    <s:textfield name="code" label="验证码"/><img src="image.jsp"><br>
		<s:submit value="登陆"/>
		<s:reset value="重置"/>
		<a href="regist.jsp">新用户注册</a>
	</s:form>
</center>