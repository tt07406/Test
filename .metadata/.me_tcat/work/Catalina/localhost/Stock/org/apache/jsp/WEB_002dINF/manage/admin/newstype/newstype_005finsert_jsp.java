package org.apache.jsp.WEB_002dINF.manage.admin.newstype;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newstype_005finsert_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head><title>增加新的频道</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write(".STYLE6 {font-size: 12px}\r\n");
      out.write(".STYLE10 {font-size: 14px; font-weight: bold; }\r\n");
      out.write("-->\r\n");
      out.write("</style></head>\r\n");
      out.write("<body>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery-1.11.1.min.js\">\r\n");
      out.write("</script>\r\n");
      out.write("\t<script language=\"javascript\">\r\n");
      out.write("\t\tfunction changeColor(obj,color){\r\n");
      out.write("\t\t\tobj.bgColor = color ;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction show(thisurl){\r\n");
      out.write("\t\t\twindow.open(thisurl,\"新闻发布系统\",\"widht=500,height=200,scrollbars=yes,resizeable=no\") ;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<script language=\"javascript\">\r\n");
      out.write("\t\tvar url = \"");
      out.print(request.getContextPath());
      out.write("\" ;\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<script language=\"javascript\" charset=\"gb2312\" src=\"");
      out.print(request.getContextPath());
      out.write("/js/newstype_validate.js\">\r\n");
      out.write("\t</script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction validateAccount(value){\r\n");
      out.write("\t\tvalidateName(value);\r\n");
      out.write("\t\t$(\"#result\").load(\"");
      out.print(request.getContextPath());
      out.write("/manage/validateName.action\",{userName:value,type:2});\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<center> \r\n");
      out.write("<form action=\"NewsType_insert\" method=\"post\" onSubmit=\"return validate(this)\">\r\n");
      out.write("<table border=\"1\" width=\"100%\" cellpadding=\"5\" cellspacing=\"0\" bgcolor=\"F2F2F2\">\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t<h1>增加新的频道</h1>\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td><font size=\"2\">名称：</font></td>\r\n");
      out.write("\t\t<td><input type=\"text\" name=\"name\" onBlur=\"validateAccount(this.value)\"><div id=\"result\"></div></td>\r\n");
      out.write("\t\t<td><span id=\"name_msg\"><font color=\"RED\">*</font></span></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td><font size=\"2\">描述：</font></td>\r\n");
      out.write("\t\t<td><input type=\"text\" name=\"note\" onBlur=\"validateNote(this.value)\"></td>\r\n");
      out.write("\t\t<td><span id=\"note_msg\"><font color=\"RED\">*</font></span></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td colspan=\"4\">\r\n");
      out.write("\t\t\t<input type=\"submit\" value=\"添加\" />\r\n");
      out.write("\t\t\t<input type=\"reset\" value=\"重置\" />\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("</center>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
