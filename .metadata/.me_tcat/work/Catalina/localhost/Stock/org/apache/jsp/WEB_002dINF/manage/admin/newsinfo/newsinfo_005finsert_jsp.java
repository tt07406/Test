package org.apache.jsp.WEB_002dINF.manage.admin.newsinfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newsinfo_005finsert_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head><title>增加新闻</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath());
      out.write("/edit/themes/default/default.css\">\r\n");
      out.write("<style type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("    .source {\r\n");
      out.write("    width: 700px;\r\n");
      out.write("    font-size: 12px;\r\n");
      out.write("    font-family:Courier New;\r\n");
      out.write("    border: 1px solid #AAAAAA;\r\n");
      out.write("    background-color: #F0F0EE;\r\n");
      out.write("    padding: 5px;\r\n");
      out.write("    }\r\n");
      out.write("    .source pre {\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    }\r\n");
      out.write("    form {\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    }\r\n");
      out.write("    .editor {\r\n");
      out.write("    margin-top: 5px;\r\n");
      out.write("    margin-bottom: 5px;\r\n");
      out.write("    }\r\n");
      out.write("  </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    function addFile(){\r\n");
      out.write("    var myTB = document.getElementById(\"myTB\");\r\n");
      out.write("    var rowNum = myTB.rows.length-3;\r\n");
      out.write("    var newRow = myTB.insertRow(rowNum);\r\n");
      out.write("    var cells_0 = newRow.insertCell(0);\r\n");
      out.write("    cells_0.innerHTML = \"新增附件：\";\r\n");
      out.write("    var cells_1 = newRow.insertCell(1);\r\n");
      out.write("    cells_1.innerHTML = \"<input type='file' name='attachment' />\";\r\n");
      out.write("   \r\n");
      out.write("    }\r\n");
      out.write("    </script>\r\n");
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
      out.write("/js/newsinfo_validate.js\">\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\" charset=\"utf-8\" src=\"");
      out.print(request.getContextPath());
      out.write("/edit/lang/zh_CN.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" charset=\"utf-8\" src=\"");
      out.print(request.getContextPath());
      out.write("/edit/kindeditor.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" charset=\"utf-8\" src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery-1.11.1.min.js\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\tvar editor;\r\n");
      out.write("\t$(document).ready(function (){\r\n");
      out.write("\t\t//渲染编辑器\r\n");
      out.write("\t\tKindEditor.ready(function(K) {\r\n");
      out.write("\t\t\teditor = K.create('#note',{\r\n");
      out.write("\t\t\t\titems:[\r\n");
      out.write("\t\t\t\t\t'preview','fontname','fontsize','forecolor','hilitecolor','bold','italic','underline','strikethrough','justifyleft','justifycenter','justifyright','hr','image','emoticons','fullscreen'\r\n");
      out.write("\t\t\t\t],\r\n");
      out.write("\t\t\t\tuploadJson : '");
      out.print(request.getContextPath());
      out.write("/uploadAction.action',\r\n");
      out.write("\t\t\t\tfilterMode: true,\r\n");
      out.write("\t\t\t\tafterBlur: function(){this.sync();},\r\n");
      out.write("\t\t\t\tafterChange : function() {\r\n");
      out.write("\t\t\t\t\t$('#alreadyInput').html(this.count());\r\n");
      out.write("\t\t\t\t\t$('#stillInput').html(2000-this.count());\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("<center> \r\n");
      out.write("<form action=\"NewsInfo_insert\" method=\"post\" onSubmit=\"return validate(this)\" enctype=\"multipart/form-data\">\r\n");
      out.write("<table border=\"1\" width=\"100%\" cellpadding=\"5\" cellspacing=\"0\" bgcolor=\"F2F2F2\" id=\"myTB\">\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td colspan=\"4\">\r\n");
      out.write("\t\t\t<h1>增加新闻</h1>\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td><font size=\"2\">标题：</font></td>\r\n");
      out.write("\t\t<td><input type=\"text\" name=\"name\" onBlur=\"validateName(this.value)\"></td>\r\n");
      out.write("\t\t<td><span id=\"name_msg\"><font color=\"RED\">*</font></span></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td><font size=\"2\">作者：</font></td>\r\n");
      out.write("\t\t<td><input type=\"text\" name=\"author\" onBlur=\"validateAuthor(this.value)\"></td>\r\n");
      out.write("\t\t<td><span id=\"author_msg\"><font color=\"RED\">*</font></span></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td><font size=\"2\">描述：</font></td>\r\n");
      out.write("\t\t<td><input type=\"text\" name=\"describe\"></td>\r\n");
      out.write("\t\t<td><span id=\"amount_msg\"><font color=\"RED\">*</font></span></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td colspan=\"3\"><font size=\"2\">分类：</font></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t<table border=\"0\" >\t\t\t\t\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td><font size=\"2\">附件：</font></td>\r\n");
      out.write("\t\t<td><input type=\"file\" name=\"attachment\"\"></td>\r\n");
      out.write("\t\t<td><input type=\"button\" value=\"添加\" onclick=\"addFile()\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td colspan=\"2\"><font size=\"2\">内容：</font></td>\r\n");
      out.write("\t\t<td><span id=\"file_msg\"><font color=\"RED\">*</font></span></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td colspan=\"4\">\r\n");
      out.write("\t\t\t<div class=\"editor\">\r\n");
      out.write("\t\t\t\t<textarea id=\"note\" name=\"content\" style=\"width:650px;height:200px;visibility:hidden;\">\r\n");
      out.write("\t\t\t\t</textarea>你已输入<span id=\"alreadyInput\"></span>字，还能输入<span id=\"stillInput\"></span>字<br/>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr onMouseOver=\"changeColor(this,'white')\" onMouseOut=\"changeColor(this,'F2F2F2')\">\r\n");
      out.write("\t\t<td colspan=\"4\">\r\n");
      out.write("\t\t    <input type=\"hidden\" name=\"cp\" value=\"");
      out.print(request.getParameter("cp"));
      out.write("\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"ls\" value=\"");
      out.print(request.getParameter("ls"));
      out.write("\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"pg\" value=\"");
      out.print(request.getParameter("pg"));
      out.write("\">\r\n");
      out.write("\t\t\t<input type=\"submit\" value=\"添加\">\r\n");
      out.write("\t\t\t<input type=\"reset\" value=\"重置\">\t\t</td>\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/manage/admin/newsinfo/newsinfo_insert.jsp(105,3) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${types}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/manage/admin/newsinfo/newsinfo_insert.jsp(105,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("newstype");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t<tr>\r\n");
          out.write("\t\t\t\t\t<td><span class=\"STYLE6\"><input type=\"checkbox\" name=\"typeid\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${newstype.newsTypeName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${newstype.newsTypeName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</span></td>\r\n");
          out.write("\t\t\t\t\t</tr>\r\n");
          out.write("\t\t\t");
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
