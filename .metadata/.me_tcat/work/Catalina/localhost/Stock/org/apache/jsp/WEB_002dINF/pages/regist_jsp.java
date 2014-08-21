package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class regist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\t<script language=\"javascript\">\r\n");
      out.write("\t\tfunction changeColor(obj,color){\r\n");
      out.write("\t\t\tobj.bgColor = color ;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<script language=\"javascript\">\r\n");
      out.write("\t\tvar url = \"");
      out.print(request.getContextPath());
      out.write("\" ;\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<script language=\"javascript\" charset=\"gb2312\" src=\"");
      out.print(request.getContextPath());
      out.write("/js/member_validate.js\">\r\n");
      out.write("\t</script>\r\n");
      out.write("<center> \r\n");
      out.write("<form action=\"userRegister\" method=\"post\" onSubmit=\"return validate(this)\">\r\n");
      out.write("<table border=\"1\" width=\"100%\" cellpadding=\"5\" cellspacing=\"0\" bgcolor=\"F2F2F2\">\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t<h1>注册会员</h1>\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td><font size=\"2\">登录名：</font></td>\r\n");
      out.write("\t\t<td><input type=\"text\" name=\"mid\" onBlur=\"validateMid(this.value)\"></td>\r\n");
      out.write("\t\t<td><span id=\"mid_msg\"><font color=\"RED\">*</font></span></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td><font size=\"2\">真实姓名：</font></td>\r\n");
      out.write("\t\t<td><input type=\"text\" name=\"realName\" onBlur=\"validateName(this.value)\"></td>\r\n");
      out.write("\t\t<td><span id=\"name_msg\"><font color=\"RED\">*</font></span></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td><font size=\"2\">性别：</font></td>\r\n");
      out.write("\t\t<td><input type=\"radio\" name=\"sex\" value=\"male\" checked=\"checked\" />男\r\n");
      out.write("\t\t\t<input type=\"radio\" name=\"sex\" value=\"female\" />女</td>\r\n");
      out.write("\t\t<td><span><font color=\"RED\">*</font></span></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td><font size=\"2\">登录密码：</font></td>\r\n");
      out.write("\t\t<td><input type=\"password\" id=\"password\" name=\"password\" onBlur=\"validatePassword(this.value)\"></td>\r\n");
      out.write("\t\t<td><span id=\"password_msg\"><font color=\"RED\">*</font></span></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td><font size=\"2\">确认密码：</font></td>\r\n");
      out.write("\t\t<td><input type=\"password\" name=\"conf\" onBlur=\"validateConf(this.value)\"></td>\r\n");
      out.write("\t\t<td><span id=\"conf_msg\"><font color=\"RED\">*</font></span></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td><font size=\"2\">Email地址：</font></td>\r\n");
      out.write("\t\t<td><input type=\"text\" name=\"email\" onBlur=\"validateEmail(this.value)\"></td>\r\n");
      out.write("\t\t<td><span id=\"address_msg\"><font color=\"RED\">*</font></span></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td><font size=\"2\">联系电话：</font></td>\r\n");
      out.write("\t\t<td><INPUT TYPE=\"text\" NAME=\"phone\" onBlur=\"validateTelephone(this.value)\"></td>\r\n");
      out.write("\t\t<td><span id=\"telephone_msg\"><font color=\"RED\">*</font></span></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td><font size=\"2\">身份证号：</font></td>\r\n");
      out.write("\t\t<td><input type=\"text\" name=\"idNum\" onBlur=\"validateIdNumber(this.value)\"></td>\r\n");
      out.write("\t\t<td><span id=\"zipcode_msg\"><font color=\"RED\">*</font></span></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td colspan=\"3\"><font size=\"2\">其它信息：</font></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t\t<textarea id=\"info\" name=\"info\" style=\"width:100%;height:200px;\">\r\n");
      out.write("\t\t\t\t</textarea>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t<input type=\"submit\" value=\"注册\">\r\n");
      out.write("\t\t\t<input type=\"reset\" value=\"重置\">\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("</center>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
