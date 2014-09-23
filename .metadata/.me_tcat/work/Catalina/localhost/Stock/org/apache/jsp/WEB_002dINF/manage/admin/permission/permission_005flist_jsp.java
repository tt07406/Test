package org.apache.jsp.WEB_002dINF.manage.admin.permission;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class permission_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fiterator_005fvar_005fvalue;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fiterator_005fvar_005fvalue = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fiterator_005fvar_005fvalue.release();
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
      out.write("<head><title>权限列表</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write(".STYLE6 {font-size: 12px}\r\n");
      out.write(".STYLE10 {font-size: 14px; font-weight: bold; }\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\t<script language=\"javascript\">\r\n");
      out.write("\t\tfunction changeColor(obj,color){\r\n");
      out.write("\t\t\tobj.bgColor = color ;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction doDelete(){\r\n");
      out.write("\t\t\tif(window.confirm(\"确认删除？\")){\r\n");
      out.write("\t\t\t\treturn true ;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\treturn false ;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction show(thisurl){\r\n");
      out.write("\t\t\twindow.open(thisurl,\"新闻发布系统\",\"widht=500,height=370,scrollbars=yes,resizeable=no\") ;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<center>\r\n");
      out.write("\t<h1>权限列表</h1>\r\n");
      out.write("<TABLE BORDER=\"1\" cellpadding=\"5\" cellspacing=\"0\" bgcolor=\"F2F2F2\" width=\"100%\">\r\n");
      out.write("\t<TR onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE10\">编号</span></td>\r\n");
      out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE10\">身份证号</span></td>\r\n");
      out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE10\">授权ID</span></td>\r\n");
      out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE10\">权限等级</span></td>\r\n");
      out.write("\t\t<td align=\"center\" valign=\"middle\" colspan=\"2\"><span class=\"STYLE10\">操作</span></td>\r\n");
      out.write("\t</TR>\r\n");
      if (_jspx_meth_s_005fiterator_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</table>\r\n");
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

  private boolean _jspx_meth_s_005fiterator_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:iterator
    org.apache.struts2.views.jsp.IteratorTag _jspx_th_s_005fiterator_005f0 = (org.apache.struts2.views.jsp.IteratorTag) _005fjspx_005ftagPool_005fs_005fiterator_005fvar_005fvalue.get(org.apache.struts2.views.jsp.IteratorTag.class);
    _jspx_th_s_005fiterator_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fiterator_005f0.setParent(null);
    // /WEB-INF/manage/admin/permission/permission_list.jsp(39,0) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fiterator_005f0.setValue("all");
    // /WEB-INF/manage/admin/permission/permission_list.jsp(39,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fiterator_005f0.setVar("item");
    int _jspx_eval_s_005fiterator_005f0 = _jspx_th_s_005fiterator_005f0.doStartTag();
    if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fiterator_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fiterator_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t<TR onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
        out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE6\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.permissionId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</span></td>\r\n");
        out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE6\"><a href=\"#\" onclick=\"show('Permission_show.action?permissionid=");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.permissionId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("')\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.idNumber}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</a></span></td>\r\n");
        out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE6\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.authenticationId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</span></td>\r\n");
        out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE6\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.permissionLevel}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</span></td>\r\n");
        out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE6\">\r\n");
        out.write("\t\t\t<a href=\"Permission_updatepre.action?permissionid=");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.permissionId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\">修改</a>\r\n");
        out.write("\t\t</span></td>\r\n");
        out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE6\">\r\n");
        out.write("\t\t\t<a href=\"Permission_delete.action?permissionid=");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.permissionId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" onclick=\"return doDelete()\">删除</a>\r\n");
        out.write("\t\t</span></td>\r\n");
        out.write("\t</TR>\r\n");
        int evalDoAfterBody = _jspx_th_s_005fiterator_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fiterator_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fiterator_005fvar_005fvalue.reuse(_jspx_th_s_005fiterator_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fiterator_005fvar_005fvalue.reuse(_jspx_th_s_005fiterator_005f0);
    return false;
  }
}
