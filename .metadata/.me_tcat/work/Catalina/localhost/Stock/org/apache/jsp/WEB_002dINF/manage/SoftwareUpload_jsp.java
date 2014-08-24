package org.apache.jsp.WEB_002dINF.manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class SoftwareUpload_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    double perMaxSize = 1024;//单个文件允许的max大小
    String sizeUnit = "MB";//perMaxSize数据对应的单位
    //String ext = "*.jpg;*.jpeg;*.gif";//允许上传的文件类型
    String ext = "*.*";//允许上传的文件类型
    //文件上传提交的目标页面
	StringBuffer uploadUrl = new StringBuffer("http://");
	uploadUrl.append(request.getHeader("Host"));
	uploadUrl.append(request.getContextPath());
	uploadUrl.append("/manage/Software_upload.action");

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>批量相片上传</title>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/css/default.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/js/swfupload.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/js/swfupload.swfobject.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/js/swfupload.queue.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/js/fileprogress.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/js/handlers.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var swfu;\r\n");
      out.write("\r\n");
      out.write("SWFUpload.onload = function () {\r\n");
      out.write("\tvar settings = {\r\n");
      out.write("\t\tflash_url : \"");
      out.print(request.getContextPath());
      out.write("/js/swfupload.swf\",\r\n");
      out.write("\t\tupload_url: \"");
      out.print(uploadUrl.toString());
      out.write("\",\r\n");
      out.write("\t\tpost_params: {\r\n");
      out.write("\t\t\t\"user_id\" : \"stehen830\",\r\n");
      out.write("\t\t\t\"pass_id\" : \"1231\"\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tfile_post_name : \"file\",\r\n");
      out.write("\t\tfile_size_limit : \"");
      out.print(perMaxSize);
      out.write(' ');
      out.print(sizeUnit);
      out.write("\",\r\n");
      out.write("\t\tfile_types : \"");
      out.print(ext);
      out.write("\",\r\n");
      out.write("\t\tfile_types_description : \"");
      out.print(ext);
      out.write("\",\r\n");
      out.write("\t\tfile_upload_limit : 100,\r\n");
      out.write("\t\tfile_queue_limit : 0,\r\n");
      out.write("\t\tcustom_settings : {\r\n");
      out.write("\t\t\tprogressTarget : \"fsUploadProgress\",\r\n");
      out.write("\t\t\tcancelButtonId : \"btnCancel\",\r\n");
      out.write("\t\t\tuploadButtonId : \"btnUpload\",\r\n");
      out.write("\t\t\tmyFileListTarget : \"idFileList\"\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tdebug: false,\r\n");
      out.write("\t\tauto_upload:false,\r\n");
      out.write("\r\n");
      out.write("\t\t// Button Settings\r\n");
      out.write("\t\tbutton_image_url : \"");
      out.print(request.getContextPath());
      out.write("/backImages/XPButtonUploadText_61x22.png\",\t// Relative to the SWF file\r\n");
      out.write("\t\tbutton_placeholder_id : \"spanButtonPlaceholder\",\r\n");
      out.write("\t\tbutton_width: 61,\r\n");
      out.write("\t\tbutton_height: 22,\r\n");
      out.write("\r\n");
      out.write("\t\t// The event handler functions are defined in handlers.js\r\n");
      out.write("\t\tswfupload_loaded_handler : swfUploadLoaded,\r\n");
      out.write("\t\tfile_queued_handler : fileQueued,\r\n");
      out.write("\t\tfile_queue_error_handler : fileQueueError,\r\n");
      out.write("\t\tfile_dialog_complete_handler : fileDialogComplete,\r\n");
      out.write("\t\tupload_start_handler : uploadStart,\r\n");
      out.write("\t\tupload_progress_handler : uploadProgress,\r\n");
      out.write("\t\tupload_error_handler : uploadError,\r\n");
      out.write("\t\tupload_success_handler : uploadSuccess,\r\n");
      out.write("\t\tupload_complete_handler : uploadComplete,\r\n");
      out.write("\t\tqueue_complete_handler : queueComplete,\t// Queue plugin event\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// SWFObject settings\r\n");
      out.write("\t\tminimum_flash_version : \"9.0.28\",\r\n");
      out.write("\t\tswfupload_pre_load_handler : swfUploadPreLoad,\r\n");
      out.write("\t\tswfupload_load_failed_handler : swfUploadLoadFailed\r\n");
      out.write("\t};\r\n");
      out.write("\r\n");
      out.write("\tswfu = new SWFUpload(settings);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body bgcolor=\"#FCFCFC\" topmargin=\"0px\" leftmargin=\"10px\" rightmargin=\"10px\">\r\n");
      out.write("<table width=\"100%\" cellspacing=\"4\" cellpadding=\"4\" border=\"0\" bgcolor=\"#FCFCFC\">\r\n");
      out.write("\t<tr> \r\n");
      out.write("\t<td class=\"DH1\">\r\n");
      out.write("\t<table width=\"100%\" cellspacing=\"4\" cellpadding=\"4\" border=\"0\" bgcolor=\"#FCFCFC\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t<td class=\"DH2\">\r\n");
      out.write("\t<STRONG>批量上传软件 （支持的类型：");
      out.print(ext);
      out.write("；单个软件最大不能超过：");
      out.print(perMaxSize);
      out.write(' ');
      out.print(sizeUnit);
      out.write("）</STRONG> \r\n");
      out.write("\t</td><td class=\"DH2\" align=\"right\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("<div id=\"content\">\r\n");
      out.write("\t<form id=\"form1\" action=\"Software_upload\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t<table width=\"90%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\"><tr><td>\r\n");
      out.write("\t\t<span id=\"spanButtonPlaceholder\"></span>\r\n");
      out.write("\t\t<input id=\"btnUpload\" type=\"button\" value=\"上传软件\" class=\"btn\" />\r\n");
      out.write("\t\t<input id=\"btnCancel\" type=\"button\" value=\"取消全部上传\" disabled=\"disabled\" class=\"btn\" /></td>\r\n");
      out.write("\t\t</tr></table>\r\n");
      out.write("\t\t<table id=\"idFileList\" class=\"uploadFileList\"><tr class=\"uploadTitle\"><td><B>文件名</B></td><td><B>文件大小</B></td><td width=100px><B>状态</B></td><td width=35px>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td></tr></table>\r\n");
      out.write("\t\t等待上传 <span id=\"idFileListCount\">0</span> 个 ，成功上传 <span id=\"idFileListSuccessUploadCount\">0</span> 个\r\n");
      out.write("\t\t<div id=\"divSWFUploadUI\" style=\"visibility: hidden;\"></div>\r\n");
      out.write("\t\t<noscript style=\"display: block; margin: 10px 25px; padding: 10px 15px;\">\r\n");
      out.write("\t\t\t很抱歉，相片上传界面无法载入，请将浏览器设置成支持JavaScript。\r\n");
      out.write("\t\t</noscript>\r\n");
      out.write("\t\t<div id=\"divLoadingContent\" class=\"content\" style=\"background-color: #FFFF66; border-top: solid 4px #FF9966; border-bottom: solid 4px #FF9966; margin: 10px 25px; padding: 10px 15px; display: none;\">\r\n");
      out.write("\t\t\t上传界面正在载入，请稍后...\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"divLongLoading\" class=\"content\" style=\"background-color: #FFFF66; border-top: solid 4px #FF9966; border-bottom: solid 4px #FF9966; margin: 10px 25px; padding: 10px 15px; display: none;\">\r\n");
      out.write("\t\t\t上传界面载入失败，请确保浏览器已经开启对JavaScript的支持，并且已经安装可以工作的Flash插件版本。\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"divAlternateContent\" class=\"content\" style=\"background-color: #FFFF66; border-top: solid 4px #FF9966; border-bottom: solid 4px #FF9966; margin: 10px 25px; padding: 10px 15px; display: none;\">\r\n");
      out.write("\t\t\t很抱歉，上传界面无法载入，请安装或者升级您的Flash插件。\r\n");
      out.write("\t\t\t请访问： <a href=\"http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash\" target=\"_blank\">Adobe网站</a> 获取最新的Flash插件。\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("</td></tr></table>\r\n");
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
