package org.apache.jsp.WEB_002dINF.manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_005ftop_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.release();
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
      out.write(" \r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>管理页面</title>\r\n");
      out.write("<script language=JavaScript>\r\n");
      out.write("function logout(){\r\n");
      out.write("\tif (confirm(\"您确定要退出控制面板吗？\"))\r\n");
      out.write("\ttop.location = \"adminLogout\";\r\n");
      out.write("\treturn false;\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<script language=JavaScript1.2>\r\n");
      out.write("function showsubmenu(sid) {\r\n");
      out.write("\tvar whichEl = eval(\"submenu\" + sid);\r\n");
      out.write("\tvar menuTitle = eval(\"menuTitle\" + sid);\r\n");
      out.write("\tif (whichEl.style.display == \"none\"){\r\n");
      out.write("\t\teval(\"submenu\" + sid + \".style.display=\\\"\\\";\");\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\teval(\"submenu\" + sid + \".style.display=\\\"none\\\";\");\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<meta http-equiv=Content-Type content=text/html;charset=gb2312>\r\n");
      out.write("<meta http-equiv=\"refresh\" content=\"60\">\r\n");
      out.write("<script language=JavaScript1.2>\r\n");
      out.write("function showsubmenu(sid) {\r\n");
      out.write("\tvar whichEl = eval(\"submenu\" + sid);\r\n");
      out.write("\tvar menuTitle = eval(\"menuTitle\" + sid);\r\n");
      out.write("\tif (whichEl.style.display == \"none\"){\r\n");
      out.write("\t\teval(\"submenu\" + sid + \".style.display=\\\"\\\";\");\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\teval(\"submenu\" + sid + \".style.display=\\\"none\\\";\");\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<base target=\"main\">\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/backImages/skin.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body leftmargin=\"0\" topmargin=\"0\">\r\n");
      out.write("<table width=\"100%\" height=\"64\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"admin_topbg\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td width=\"61%\" height=\"64\"><img src=\"");
      out.print(request.getContextPath());
      out.write("/backImages/logo.png\" width=\"279\" height=\"68\" border=\"0\"></td>\r\n");
      out.write("    <td width=\"39%\" valign=\"top\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td width=\"74%\" height=\"38\" class=\"admin_txt\">管理员：<b>\r\n");
      out.write("\t\t");
      if (_jspx_meth_s_005fproperty_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</b> 您好,感谢登陆使用！</td>\r\n");
      out.write("        <td width=\"22%\"><a href=\"#\" target=\"_self\" onClick=\"logout();\"><img src=\"");
      out.print(request.getContextPath());
      out.write("/backImages/out.gif\" alt=\"安全退出\" width=\"46\" height=\"20\" border=\"0\"></a></td>\r\n");
      out.write("        <td width=\"4%\">&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td height=\"19\" colspan=\"3\">&nbsp;</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_s_005fproperty_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f0 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f0.setParent(null);
    // /WEB-INF/manage/admin_top.jsp(47,2) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f0.setValue("#session.admin.adminName");
    int _jspx_eval_s_005fproperty_005f0 = _jspx_th_s_005fproperty_005f0.doStartTag();
    if (_jspx_th_s_005fproperty_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
    return false;
  }
}
