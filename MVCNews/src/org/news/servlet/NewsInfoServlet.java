/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������NewsInfoServlet
 * 
 * �������ڣ�2014-06-24
 */
package org.news.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.news.service.*;
import org.news.utils.*;
import com.jspsmart.upload.*;
import org.news.model.Admin;
import org.news.model.NewsAttachment;
import org.news.model.NewsInfo;
import org.news.model.NewsType;
import org.news.model.NewsVO;

/**
 * �������Ų�����Servlet
 * 
 * @author tt
 * @version 14.6.18
 */
public class NewsInfoServlet extends HttpServlet {
	
	private static final long serialVersionUID = -5962311512440267268L;
	private NewsInfoService service = new NewsInfoService();
	private NewsTypeService typeService = new NewsTypeService();
	private ServletConfig config;

	public void init(ServletConfig arg0) throws ServletException {
		config = arg0;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pages = "../../../errors.jsp";//����ҳ	
		
		String status = request.getParameter("status");//��ȡ��ǰ�Ĳ���״̬
		
		if (!(status == null || "".equals(status))) {
			if ("list".equals(status)) {
				this.list(request, response);
			}
			if ("insertpre".equals(status)) {
				this.insertpre(request, response);
			}
			if ("updatepre".equals(status)) {
				this.updatepre(request, response);
			}
			if ("show".equals(status)) {
				this.show(request, response);
			}
			if ("delete".equals(status)) {
				this.delete(request, response);
			}			
		}else{
			//ʹ��SmartUpload�ϴ�
			SmartUpload smart = new SmartUpload() ;

			//������Ӻ�ɾ����Ҫ��smartupload�л�ò���
			try {
				smart.initialize(config, request, response);
				smart.setMaxFileSize(1024*1024*20);//�������20M
				smart.setCharset("utf-8");
				smart.setDeniedFilesList("exe,bat");
				smart.upload() ;
			} catch (SmartUploadException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			status = smart.getRequest().getParameter("status");
			
			if ("insert".equals(status)) {
				this.insert(request, response, smart);
			}else if ("update".equals(status)) {
				this.update(request, response, smart);
			}else{				
			    request.getRequestDispatcher(pages).forward(request, response);
			}
		}
	}
	
	/**
	 * ��������
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void update(HttpServletRequest request, HttpServletResponse response, SmartUpload smart)
			throws ServletException, IOException {
		String pages = "../../../errors.jsp";

		//���ϸ�ҳ���ȡһϵ������
		String name = smart.getRequest().getParameter("name") ;
		String describe = smart.getRequest().getParameter("describe") ;
		String author = smart.getRequest().getParameter("author") ;
		String content = smart.getRequest().getParameter("content") ;
		Admin admin = (Admin) request.getSession().getAttribute("admin") ;//��¼�Ĺ���Ա
		String[] newsType = smart.getRequest().getParameterValues("typeid");//һ�����ſ������ڶ��Ƶ��
		int newsInfoId = 0;//����ID
		String msg = "�޷���ȡ���";

		if (admin == null){
			msg = "��δ��¼���¼��";
			pages = "forward.jsp";
		}else if (newsType != null){
				NewsInfo news = null;
				StringBuffer type = new StringBuffer();
				for (int i = 0; i<newsType.length; i++){
					type.append(newsType[i]+",");
				}
				msg = "�����޸�ʧ�ܣ�" ;
				newsInfoId = Integer.parseInt(smart.getRequest().getParameter("pid")) ;
				news = new NewsInfo(newsInfoId,name,describe,content,
						service.searchNewsInfo(newsInfoId).getNewsInfoTime(),author,admin.getAdminId(),type.toString(),1);//����ʱ�䲻��
				try {//�������ݿ�
					if(service.updateNewsInformation(news,smart)){
						msg = "�����޸ĳɹ���" ;
					}
					pages = "newsinfo_operate_do.jsp";
					//��ȡҳ��Ĳ������´���
					request.setAttribute("pg", smart.getRequest().getParameter("pg"));
					request.setAttribute("cp", smart.getRequest().getParameter("cp"));
					request.setAttribute("ls", smart.getRequest().getParameter("ls"));
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		request.setAttribute("msg", msg);
		request.getRequestDispatcher(pages).forward(request, response);
		
	}
	
	/**
	 * ��������
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void insert(HttpServletRequest request, HttpServletResponse response, SmartUpload smart)
			throws ServletException, IOException {
		String pages = "../../../errors.jsp";
		
		//���ϸ�ҳ���ȡһϵ������
		String name = smart.getRequest().getParameter("name") ;
		String describe = smart.getRequest().getParameter("describe") ;
		String author = smart.getRequest().getParameter("author") ;
		String content = smart.getRequest().getParameter("content") ;
		Admin admin = (Admin) request.getSession().getAttribute("admin") ;//��¼�Ĺ���Ա
		String[] newsType = smart.getRequest().getParameterValues("typeid");//һ�����ſ������ڶ��Ƶ��
		int newsInfoId = 0;//����ID
		String msg = "�޷���ȡ���";
		
		if (admin == null){
			msg = "��δ��¼���¼��";
			pages = "forward.jsp";
		}else if (newsType != null){
				NewsInfo news = null;
				StringBuffer type = new StringBuffer();
				for (int i = 0; i<newsType.length; i++){
					type.append(newsType[i]+",");
				}
				msg = "��������ʧ�ܣ�" ;
				List<NewsInfo> infoList = service.getAllNewsInfo();
				newsInfoId = ((infoList.size() == 0)? 1: (service.getAllNewsInfo().get(0).getNewsInfoId()+1));//�µ�ID��������ID��1
				news = new NewsInfo(newsInfoId,name,describe,content,
						new Date(new java.util.Date().getTime()),author,admin.getAdminId(),type.toString(),0);//����ʱ��Ϊ��ǰʱ��
				try {//�������ݿ�
					if(service.addNewsInfo(news,smart)){
						msg = "�������ӳɹ���" ;
					}
					pages = "newsinfo_insert_do.jsp";
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		request.setAttribute("msg", msg);
		request.getRequestDispatcher(pages).forward(request, response);
	}
	
	/**
	 * �鿴������Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void show(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pages = "../../../errors.jsp";
		int newsId = Integer.parseInt(request.getParameter("pid")) ;
		try {//��ȡ��ǰ��ԱVO�������¸�ҳ��
			NewsInfo pro = service.searchNewsInfo(newsId);
			if(pro != null) {
				request.setAttribute("newsinfo",pro);
				AttachmentService attiService = new AttachmentService();
				List<NewsAttachment> attachments = attiService.findNewsAttachmentByNewsId((long)newsId);
				request.setAttribute("attachments", attachments);
			}
			pages = "newsinfo_show.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(pages).forward(request, response);
	}
	
	/**
	 * ����ǰ�Ĳ���
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updatepre(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pages = "../../../errors.jsp";
		int newsId = Integer.parseInt(request.getParameter("pid")) ;
		try {//��ȡ��ǰ��ԱVO�������¸�ҳ��
			NewsInfo pro = service.searchNewsInfo(newsId);
			String[] typeNames = null;
			List<NewsType> newsType = typeService.getAllNewsType();
			request.setAttribute("types", newsType);//��������
			if(pro != null) {
				request.setAttribute("newsinfo",pro);
				typeNames = pro.getNewsType().split(",");
				request.setAttribute("typeNames",typeNames);//��ѡ������
				AttachmentService attiService = new AttachmentService();
				List<NewsAttachment> attachments = attiService.findNewsAttachmentByNewsId((long)newsId);//��ѡ�ĸ���
				request.setAttribute("attachments", attachments);
			}
			pages = "newsinfo_update.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(pages).forward(request, response);
	}
	
	/**
	 * ����ǰ�Ĳ���
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void insertpre(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pages = "newsinfo_insert.jsp";
		List<NewsType> newsType = typeService.getAllNewsType();
		request.setAttribute("types", newsType);//��������
		request.getRequestDispatcher(pages).forward(request, response);
	}
	
	/**
	 * ɾ��������Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pages = "../../../errors.jsp";
		int pid = Integer.parseInt(request.getParameter("pid")) ;
		int currentPage = 1 ;	// Ϊ��ǰ���ڵ�ҳ��Ĭ���ڵ�1ҳ
		int lineSize = 20;		// ÿ����ʾ�ļ�¼��
		String page = (String)request.getParameter("pg") ;
		try{
			currentPage = Integer.parseInt(request.getParameter("cp")) ;
		} catch(Exception e) {}
		try{
			lineSize = Integer.parseInt(request.getParameter("ls")) ;
		} catch(Exception e) {}

		int[] newsId = new int[1];
		newsId[0] = pid;
		try {
			if (service.deleteNewsInfo(newsId)) {
				request.setAttribute("msg", MessageUtil
						.get("newsinfo.delete.true"));
			} else {
				request.setAttribute("msg", MessageUtil
						.get("newsinfo.delete.false"));
			}
			pages = "newsinfo_operate_do.jsp";//������תҳ��
			
			//������ת�������Դ����¸�ҳ��
			request.setAttribute("pg", page);
			request.setAttribute("cp", currentPage);
			request.setAttribute("ls", lineSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(pages).forward(request, response);
	}
	
	/**
	 * 
	 * ��ȡ���е������б�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pages = "../../../errors.jsp";
		String URL = "NewsInfoServlet?status=list" ;
		
		try {
			int currentPage = 1 ;	// Ϊ��ǰ���ڵ�ҳ��Ĭ���ڵ�1ҳ
			int lineSize = 20;		// ÿ����ʾ�ļ�¼��
			long allRecorders = 0 ;	// ��ʾȫ���ļ�¼��
			String keyWord = request.getParameter("kw") ;	// ���ղ�ѯ�ؼ���
			
			Logger.log(keyWord, Logger.DEBUG);
			try{
				currentPage = Integer.parseInt(request.getParameter("cp")) ;
			} catch(Exception e) {}
			try{
				lineSize = Integer.parseInt(request.getParameter("ls")) ;
			} catch(Exception e) {}
			if(keyWord == null){
				keyWord = "" ;	// ���ģ����ѯû�йؼ��֣����ʾ��ѯȫ��
			}
			
			List<NewsInfo> all = service.getAllNewsInfo(keyWord,currentPage,lineSize) ;
			List<NewsVO> allVO = new ArrayList<NewsVO>();
			for (int i = 0; i<all.size(); ++i){
				allVO.add(service.toNewsVO(all.get(i)));
			}
			
			allRecorders = service.getAllCount(keyWord) ;
			request.setAttribute("newsInfos",allVO);
			request.setAttribute("recorders",allRecorders);
			request.setAttribute("url", URL);
			request.setAttribute("page", currentPage);
			request.setAttribute("size", lineSize);
	
			
			pages = "newsinfo_list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(pages).forward(request, response);
	}
}
