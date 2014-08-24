package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

 //文件上传提交的目标页面
	StringBuffer uploadUrl = new StringBuffer("http://");
	uploadUrl.append(request.getHeader("Host"));
	uploadUrl.append(request.getContextPath());
	uploadUrl.append("/manage/Software_upload.action");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("  <link href=\"");
      out.print(basePath);
      out.write("css/default.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("   \t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("js/swfupload.js\"></script>\r\n");
      out.write("   \t<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("js/swfupload.queue.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("js/fileprogress.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("js/handlers.js\"></script>\r\n");
      out.write("   \t<!-- 初始化swfupload 对象-->\r\n");
      out.write("   <script type=\"text/javascript\">\r\n");
      out.write("\t\tvar upload1, upload2;\r\n");
      out.write("\r\n");
      out.write("\t\twindow.onload = function() {\r\n");
      out.write("\t\t\tupload1 = new SWFUpload({\r\n");
      out.write("\t\t\t\t// Backend Settings\r\n");
      out.write("\t\t\t\tupload_url: \"");
      out.print(uploadUrl.toString());
      out.write("\",\r\n");
      out.write("\t\t\t\tpost_params: {\"picSESSID\" : \"songhao\"},\r\n");
      out.write("\t\t\t\tfile_post_name: \"file\",\r\n");
      out.write("\t\t\t\t// File Upload Settings\r\n");
      out.write("\t\t\t\tfile_size_limit : \"102400\",\t// 100MB\r\n");
      out.write("\t\t\t\tfile_types : \"*.*\",\r\n");
      out.write("\t\t\t\tfile_types_description : \"All Files\",\r\n");
      out.write("\t\t\t\tfile_upload_limit : \"10\",\r\n");
      out.write("\t\t\t\tfile_queue_limit : \"0\",\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t// Event Handler Settings (all my handlers are in the Handler.js file)\r\n");
      out.write("\t\t\t\tfile_dialog_start_handler : fileDialogStart,\r\n");
      out.write("\t\t\t\tfile_queued_handler : fileQueued,\r\n");
      out.write("\t\t\t\tfile_queue_error_handler : fileQueueError,\r\n");
      out.write("\t\t\t\tfile_dialog_complete_handler : fileDialogComplete,\r\n");
      out.write("\t\t\t\tupload_start_handler : uploadStart,\r\n");
      out.write("\t\t\t\tupload_progress_handler : uploadProgress,\r\n");
      out.write("\t\t\t\tupload_error_handler : uploadError,\r\n");
      out.write("\t\t\t\tupload_success_handler : uploadSuccess,\r\n");
      out.write("\t\t\t\tupload_complete_handler : uploadComplete,\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t// Button Settings\r\n");
      out.write("\t\t\t\tbutton_image_url : \"backImages/XPButtonUploadText_61x22.png\",\r\n");
      out.write("\t\t\t\tbutton_placeholder_id : \"spanButtonPlaceholder1\",\r\n");
      out.write("\t\t\t\tbutton_width: 61,\r\n");
      out.write("\t\t\t\tbutton_height: 22,\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t// Flash Settings\r\n");
      out.write("\t\t\t\tflash_url : \"js/swfupload.swf\",\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tcustom_settings : {\r\n");
      out.write("\t\t\t\t\tprogressTarget : \"fsUploadProgress1\",\r\n");
      out.write("\t\t\t\t\tcancelButtonId : \"btnCancel1\"\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t// Debug Settings\r\n");
      out.write("\t\t\t\tdebug: false\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tupload2 = new SWFUpload({\r\n");
      out.write("\t\t\t\t// Backend Settings\r\n");
      out.write("\t\t\t\tupload_url: \"");
      out.print(uploadUrl.toString());
      out.write("\",\r\n");
      out.write("\t\t\t\tpost_params: {\"SESSID\" : \"file\"},\r\n");
      out.write("\t\t\t\tfile_post_name: \"file\",\r\n");
      out.write("\t\t\t\t// File Upload Settings\r\n");
      out.write("\t\t\t\tfile_size_limit : \"200\",\t// 200 kb\r\n");
      out.write("\t\t\t\tfile_types : \"*.jpg;*.gif;*.png\",\r\n");
      out.write("\t\t\t\tfile_types_description : \"Image Files\",\r\n");
      out.write("\t\t\t\tfile_upload_limit : \"10\",\r\n");
      out.write("\t\t\t\tfile_queue_limit : \"5\",\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t// Event Handler Settings (all my handlers are in the Handler.js file)\r\n");
      out.write("\t\t\t\tfile_dialog_start_handler : fileDialogStart,\r\n");
      out.write("\t\t\t\tfile_queued_handler : fileQueued,\r\n");
      out.write("\t\t\t\tfile_queue_error_handler : fileQueueError,\r\n");
      out.write("\t\t\t\tfile_dialog_complete_handler : fileDialogComplete,\r\n");
      out.write("\t\t\t\tupload_start_handler : uploadStart,\r\n");
      out.write("\t\t\t\tupload_progress_handler : uploadProgress,\r\n");
      out.write("\t\t\t\tupload_error_handler : uploadError,\r\n");
      out.write("\t\t\t\tupload_success_handler : uploadSuccess,\r\n");
      out.write("\t\t\t\tupload_complete_handler : uploadComplete,\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t// Button Settings\r\n");
      out.write("\t\t\t\tbutton_image_url : \"backImages/XPButtonUploadText_61x22.png\",\r\n");
      out.write("\t\t\t\tbutton_placeholder_id : \"spanButtonPlaceholder2\",\r\n");
      out.write("\t\t\t\tbutton_width: 61,\r\n");
      out.write("\t\t\t\tbutton_height: 22,\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t// Flash Settings\r\n");
      out.write("\t\t\t\tflash_url : \"js/swfupload.swf\",\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tswfupload_element_id : \"flashUI2\",\t\t// Setting from graceful degradation plugin\r\n");
      out.write("\t\t\t\tdegraded_element_id : \"degradedUI2\",\t// Setting from graceful degradation plugin\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tcustom_settings : {\r\n");
      out.write("\t\t\t\t\tprogressTarget : \"fsUploadProgress2\",\r\n");
      out.write("\t\t\t\t\tcancelButtonId : \"btnCancel2\"\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t// Debug Settings\r\n");
      out.write("\t\t\t\tdebug: false\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t     }\r\n");
      out.write("\t    \r\n");
      out.write("\t</script>\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("  <div id=\"header\">\r\n");
      out.write("\t<h1 id=\"logo\"><a href=\"../\">SWFUpload</a></h1>\r\n");
      out.write("\t<div id=\"version\">v2.2.0</div>\r\n");
      out.write("</div>\r\n");
      out.write("  <div id=\"content\">\r\n");
      out.write("\t<h2>Multi-Instance Demo</h2>\r\n");
      out.write("    <form action=\"pictureAction\" method=\"post\" name=\"thisform\" enctype=\"multipart/form-data\">\r\n");
      out.write("    \t<p>This page demonstrates how multiple instances of SWFUpload can be loaded on the same page.\r\n");
      out.write("\t\t\tIt also demonstrates the use of the graceful degradation plugin and the queue plugin.</p>\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<tr valign=\"top\">\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"fieldset flash\" id=\"fsUploadProgress1\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"legend\">Large File Upload Site</span>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div style=\"padding-left: 5px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<span id=\"spanButtonPlaceholder1\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t<input id=\"btnCancel1\" type=\"button\" value=\"Cancel Uploads\" onclick=\"cancelQueue(upload1);\" disabled=\"disabled\" style=\"margin-left: 2px; height: 22px; font-size: 8pt;\" />\r\n");
      out.write("\t\t\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"fieldset flash\" id=\"fsUploadProgress2\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"legend\">Small File Upload Site</span>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div style=\"padding-left: 5px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<span id=\"spanButtonPlaceholder2\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t<input id=\"btnCancel2\" type=\"button\" value=\"Cancel Uploads\" onclick=\"cancelQueue(upload2);\" disabled=\"disabled\" style=\"margin-left: 2px; height: 22px; font-size: 8pt;\" />\r\n");
      out.write("\t\t\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("    </form>\r\n");
      out.write("    </div>\r\n");
      out.write("  </body>\r\n");
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
