package org.apache.jsp.WEB_002dINF.manage.admin.newsinfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newsinfo_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.release();
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
      out.write("<head><title>新闻列表</title>\r\n");
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
      out.write("\t\tfunction show(thisurl){\r\n");
      out.write("\t\t\twindow.open(thisurl,\"新闻发布系统\",\"widht=500,height=370,scrollbars=yes,resizeable=no\") ;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("<body>\r\n");
      out.write("<center>\r\n");
      out.write("\t<h1>新闻列表</h1>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "split_page_plugin.jsp" + (("split_page_plugin.jsp").indexOf('?')>0? '&': '?') + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("allRecorders", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${recorders}", java.lang.String.class, (PageContext)_jspx_page_context, null, false), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("url", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false), request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("<TABLE BORDER=\"1\" cellpadding=\"5\" cellspacing=\"0\" bgcolor=\"F2F2F2\" width=\"100%\">\r\n");
      out.write("\t<TR onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE10\">ID</span></td>\r\n");
      out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE10\">标题</span></td>\r\n");
      out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE10\">描述</span></td>\r\n");
      out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE10\">创建时间</span></td>\r\n");
      out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE10\">作者</span></td>\r\n");
      out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE10\">分类</span></td>\r\n");
      out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE10\">创建者</span></td>\r\n");
      out.write("\t\t<td align=\"center\" valign=\"middle\" colspan=\"2\"><span class=\"STYLE10\">操作</span></td>\r\n");
      out.write("\t</TR>\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
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

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/manage/admin/newsinfo/newsinfo_list.jsp(38,1) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/manage/admin/newsinfo/newsinfo_list.jsp(38,1) '${newsInfos}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${newsInfos}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/manage/admin/newsinfo/newsinfo_list.jsp(38,1) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("newsvo");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t<TR onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
          out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE6\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${newsvo.newsInfoId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</span></td>\r\n");
          out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE6\"><a href=\"#\" onclick=\"show('NewsInfo_show.action?pid=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${newsvo.newsInfoId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("')\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${newsvo.newsInfoTitle}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</a></span></td>\r\n");
          out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE6\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${newsvo.newsInfoDescribe}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</span></td>\r\n");
          out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE6\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${newsvo.newsInfoTime}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</span></td>\r\n");
          out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE6\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${newsvo.newsAuthor}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</span></td>\r\n");
          out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE6\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${newsvo.newsType}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</span></td>\r\n");
          out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE6\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${newsvo.adminName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</span></td>\r\n");
          out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE6\"><a href=\"NewsInfo_updatepre?pid=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${newsvo.newsInfoId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("&cp=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("&ls=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${size}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("&pg=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\">修改</a></span></td>\r\n");
          out.write("\t\t<td align=\"center\" valign=\"middle\"><span class=\"STYLE6\"><a href=\"NewsInfo_delete?pid=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${newsvo.newsInfoId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("&cp=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("&ls=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${size}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("&pg=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\">删除</a></span></td>\r\n");
          out.write("\t</TR>\r\n");
          out.write("\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
