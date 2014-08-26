package org.apache.jsp.WEB_002dINF.manage.admin.newsinfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class split_005fpage_005fplugin_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

	int currentPage = 1 ;	// 为当前所在的页，默认在第1页
	int lineSize = 20 ;		// 每次显示的记录数
	long allRecorders = 0 ;	// 表示全部的记录数
	long pageSize = 1 ;		// 表示全部的页数（尾页）
	int lsData[] = {1,3,5,7,9,10,15,20,25,30,50,100} ;
	String keyWord = request.getParameter("kw") ;	// 接收查询关键字
	String url = request.getParameter("url") ;

      out.write('\r');
      out.write('\n');

	try{
		currentPage = Integer.parseInt(request.getParameter("cp")) ;
	} catch(Exception e) {}
	try{
		lineSize = Integer.parseInt(request.getParameter("ls")) ;
	} catch(Exception e) {}
	try{
		allRecorders = Long.parseLong(request.getParameter("allRecorders")) ;
	} catch(Exception e) {}
	if(keyWord == null){
		keyWord = "" ;	// 如果模糊查询没有关键字，则表示查询全部
	}

      out.write('\r');
      out.write('\n');

	pageSize = (allRecorders + lineSize -1) / lineSize ;
	if(pageSize == 0){
		pageSize = 1 ;
	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\tfunction go(num){\r\n");
      out.write("\t\tdocument.getElementById(\"cp\").value = num ;\r\n");
      out.write("\t\tdocument.spform.submit() ;\t// 表单提交\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<form name=\"spform\" action=\"");
      out.print(url);
      out.write("\" method=\"post\">\r\n");
      out.write("\t输入查询关键字：<input type=\"text\" name=\"kw\" value=\"");
      out.print(keyWord);
      out.write("\">\r\n");
      out.write("\t<input type=\"submit\" value=\"查询\"><br>\r\n");
      out.write("\t<input type=\"button\" value=\"首页\" onclick=\"go(1)\" ");
      out.print(currentPage==1?"DISABLED":"");
      out.write(">\r\n");
      out.write("\t<input type=\"button\" value=\"上一页\" onclick=\"go(");
      out.print(currentPage-1);
      out.write(')');
      out.write('"');
      out.write(' ');
      out.print(currentPage==1?"DISABLED":"");
      out.write(">\r\n");
      out.write("\t<input type=\"button\" value=\"下一页\" onclick=\"go(");
      out.print(currentPage+1);
      out.write(')');
      out.write('"');
      out.write(' ');
      out.print(currentPage==pageSize?"DISABLED":"");
      out.write(">\r\n");
      out.write("\t<input type=\"button\" value=\"尾页\" onclick=\"go(");
      out.print(pageSize);
      out.write(')');
      out.write('"');
      out.write(' ');
      out.print(currentPage==pageSize?"DISABLED":"");
      out.write(">\r\n");
      out.write("\t跳转到第<select name=\"selcp\" onchange=\"go(this.value)\">\r\n");
      out.write("\t\t");

			for(int x=1;x<=pageSize;x++){
		
      out.write("\r\n");
      out.write("\t\t\t\t<option value=\"");
      out.print(x);
      out.write('"');
      out.write(' ');
      out.print(x==currentPage?"SELECTED":"");
      out.write('>');
      out.print(x);
      out.write("</option>\r\n");
      out.write("\t\t");

			}
		
      out.write("\r\n");
      out.write("\t</select>页\r\n");
      out.write("\t每页显示\r\n");
      out.write("\t\t<select name=\"ls\" onchange=\"go(1)\">\r\n");
      out.write("\t\t");

			for(int x=0;x<lsData.length;x++){
		
      out.write("\r\n");
      out.write("\t\t\t<option value=\"");
      out.print(lsData[x]);
      out.write('"');
      out.write(' ');
      out.print(lsData[x]==lineSize?"SELECTED":"");
      out.write('>');
      out.print(lsData[x]);
      out.write("</option>\r\n");
      out.write("\t\t");

			}
		
      out.write("\r\n");
      out.write("\t\t</select>\r\n");
      out.write("\t条\r\n");
      out.write("\t<input type=\"hidden\" name=\"cp\" id=\"cp\" value=\"1\">\r\n");
      out.write("</form>");
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
