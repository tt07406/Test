package org.apache.jsp.WEB_002dINF.manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class left_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<title>管理页面</title>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/js/prototype.lite.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/js/moo.fx.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/js/moo.fx.pack.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("body {\r\n");
      out.write("\tfont:12px Arial, Helvetica, sans-serif;\r\n");
      out.write("\tcolor: #000;\r\n");
      out.write("\tbackground-color: #EEF2FB;\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("}\r\n");
      out.write("#container {\r\n");
      out.write("\twidth: 182px;\r\n");
      out.write("}\r\n");
      out.write("H1 {\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("\twidth: 182px;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("\theight: 30px;\r\n");
      out.write("\tline-height: 20px;\t\r\n");
      out.write("}\r\n");
      out.write("H1 a {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\twidth: 182px;\r\n");
      out.write("\tcolor: #000;\r\n");
      out.write("\theight: 30px;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tmoz-outline-style: none;\r\n");
      out.write("\tbackground-image: url(images/menu_bgS.gif);\r\n");
      out.write("\tbackground-repeat: no-repeat;\r\n");
      out.write("\tline-height: 30px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("\tpadding: 0px;\r\n");
      out.write("}\r\n");
      out.write(".content{\r\n");
      out.write("\twidth: 182px;\r\n");
      out.write("\theight:15px;\r\n");
      out.write("\tmargin:0px;\r\n");
      out.write("\toverflow:hidden;\r\n");
      out.write("\tpadding:0px;\r\n");
      out.write("}\r\n");
      out.write(".MM ul {\r\n");
      out.write("\tlist-style-type: none;\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("\tpadding: 0px;\r\n");
      out.write("\tdisplay: block\r\n");
      out.write("}\r\n");
      out.write(".MM li {\r\n");
      out.write("\tfont-family: Arial, Helvetica, sans-serif;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tline-height: 26px;\r\n");
      out.write("\tcolor: #333333;\r\n");
      out.write("\tlist-style-type: none;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\theight: 26px;\r\n");
      out.write("\twidth: 182px;\r\n");
      out.write("\tpadding-left: 0px;\r\n");
      out.write("}\r\n");
      out.write(".MM {\r\n");
      out.write("\twidth: 182px;\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("\tpadding: 0px;\r\n");
      out.write("\tleft: 0px;\r\n");
      out.write("\ttop: 0px;\r\n");
      out.write("\tright: 0px;\r\n");
      out.write("\tbottom: 0px;\r\n");
      out.write("\tclip: rect(0px,0px,0px,0px);\r\n");
      out.write("}\r\n");
      out.write(".MM a:link {\r\n");
      out.write("\tfont-family: Arial, Helvetica, sans-serif;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tline-height: 26px;\r\n");
      out.write("\tcolor: #333333;\r\n");
      out.write("\tbackground-image: url(images/menu_bg1.gif);\r\n");
      out.write("\tbackground-repeat: no-repeat;\r\n");
      out.write("\theight: 26px;\r\n");
      out.write("\twidth: 182px;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("\tpadding: 0px;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write(".MM a:visited {\r\n");
      out.write("\tfont-family: Arial, Helvetica, sans-serif;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tline-height: 26px;\r\n");
      out.write("\tcolor: #333333;\r\n");
      out.write("\tbackground-image: url(images/menu_bg1.gif);\r\n");
      out.write("\tbackground-repeat: no-repeat;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("\tpadding: 0px;\r\n");
      out.write("\theight: 26px;\r\n");
      out.write("\twidth: 182px;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write(".MM a:active {\r\n");
      out.write("\tfont-family: Arial, Helvetica, sans-serif;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tline-height: 26px;\r\n");
      out.write("\tcolor: #333333;\r\n");
      out.write("\tbackground-image: url(images/menu_bg1.gif);\r\n");
      out.write("\tbackground-repeat: no-repeat;\r\n");
      out.write("\theight: 26px;\r\n");
      out.write("\twidth: 182px;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("\tpadding: 0px;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write(".MM a:hover {\r\n");
      out.write("\tfont-family: Arial, Helvetica, sans-serif;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tline-height: 26px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tcolor: #006600;\r\n");
      out.write("\tbackground-image: url(images/menu_bg2.gif);\r\n");
      out.write("\tbackground-repeat: no-repeat;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("\tpadding: 0px;\r\n");
      out.write("\theight: 26px;\r\n");
      out.write("\twidth: 182px;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<table width=\"100%\" height=\"280\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#EEF2FB\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td width=\"182\" valign=\"top\">   \r\n");
      out.write("       <h1 class=\"type\"><a href=\"javascript:void(0)\">新闻管理</a></h1>\r\n");
      out.write("      <div class=\"content\">\r\n");
      out.write("        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td><img src=\"");
      out.print(request.getContextPath());
      out.write("/backImages/menu_topline.gif\" width=\"182\" height=\"5\" /></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("        <ul class=\"MM\">\r\n");
      out.write("\t\t  <li><a href=\"/Stock/manage/admin/newsinfo/NewsInfo_insertpre.action\" target=\"main\">增加新闻</a></li>\r\n");
      out.write("\t\t  <li><a href=\"/Stock/manage/admin/newsinfo/NewsInfo_list.action\" target=\"main\">新闻列表</a></li>\r\n");
      out.write("\t\t  <li><a href=\"/Stock/manage/admin/newstype/newstype_insert.action\" target=\"main\">增加新闻类别</a></li>\r\n");
      out.write("\t\t  <li><a href=\"/Stock/manage/admin/newstype/NewsType_list.action\" target=\"main\">新闻类别列表</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("      <h1 class=\"type\"><a href=\"javascript:void(0)\">权限管理</a></h1>\r\n");
      out.write("      <div class=\"content\">\r\n");
      out.write("        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td><img src=\"");
      out.print(request.getContextPath());
      out.write("/backImages/menu_topline.gif\" width=\"182\" height=\"5\" /></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("        <ul class=\"MM\">\r\n");
      out.write("\t\t  <li><a href=\"/Stock/manage/admin/admin/Admin_list.action\" target=\"main\">管理员列表</a></li>\r\n");
      out.write("\t\t  <li><a href=\"/Stock/manage/admin/admin/admin_insert.action\" target=\"main\">增加管理员</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("      <h1 class=\"type\"><a href=\"javascript:void(0)\">注册用户管理</a></h1>\r\n");
      out.write("      <div class=\"content\">\r\n");
      out.write("        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td><img src=\"");
      out.print(request.getContextPath());
      out.write("/backImages/menu_topline.gif\" width=\"182\" height=\"5\" /></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("        <ul class=\"MM\">\r\n");
      out.write("          <li><a href=\"/Stock/manage/admin/users/Users_list.action\" target=\"main\">会员管理</a></li>\r\n");
      out.write("          <li><a href=\"#\" target=\"main\">留言管理</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("      <h1 class=\"type\"><a href=\"javascript:void(0)\">软件管理</a></h1>\r\n");
      out.write("      <div class=\"content\">\r\n");
      out.write("        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td><img src=\"");
      out.print(request.getContextPath());
      out.write("/backImages/menu_topline.gif\" width=\"182\" height=\"5\" /></td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("        <ul class=\"MM\">\r\n");
      out.write("\t\t  <li><a href=\"/Stock/manage/Software_list.action\" target=\"main\">软件列表</a></li>\r\n");
      out.write("\t\t  <li><a href=\"/Stock/manage/SoftwareUpload.action\" target=\"main\">增加软件</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\t\tvar contents = document.getElementsByClassName('content');\r\n");
      out.write("\t\tvar toggles = document.getElementsByClassName('type');\r\n");
      out.write("\t\r\n");
      out.write("\t\tvar myAccordion = new fx.Accordion(\r\n");
      out.write("\t\t\ttoggles, contents, {opacity: true, duration: 400}\r\n");
      out.write("\t\t);\r\n");
      out.write("\t\tmyAccordion.showThisHideOpen(contents[0]);\r\n");
      out.write("\t</script>\r\n");
      out.write("        </td>\r\n");
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
}
