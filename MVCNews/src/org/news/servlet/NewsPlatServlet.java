/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������NewsPlatServelet
 * 
 * �������ڣ�2014-07-07
 */
package org.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.news.model.NewsAttachment;
import org.news.model.NewsIndex;
import org.news.model.NewsInfo;
import org.news.model.NewsVO;
import org.news.service.AttachmentService;
import org.news.service.NewsInfoService;
import org.news.service.NewsTypeService;

import net.sf.json.JSONArray;

/**
 * ��ǰ�˽�����Servlet
 * 
 * @author tt
 * @version 14.6.18
 */
public class NewsPlatServlet extends HttpServlet {

	private static final long serialVersionUID = 5567597897632444888L;
	private NewsInfoService service = new NewsInfoService();
	private NewsTypeService typeService = new NewsTypeService();

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String status = request.getParameter("status");//��ȡ��ǰ�Ĳ���״̬
		
		if (!(status == null || "".equals(status))) {
			if ("list".equals(status)) {//��ȡ�����б�
				String style = request.getParameter("plat");
				int type = Integer.parseInt(request.getParameter("type"));//�������
				String newsType = typeService.getNewsTypeById(type).getNewsTypeName();
				if ("index".equals(style)){//ajax �첽���󣬷���JSON��ʽ
					List<NewsInfo> all = service.getAllNewsInfoByType(newsType);//��ȡĳ������������
					List<NewsIndex> allVO = new ArrayList<NewsIndex>();
					for (int i = 0; i<all.size(); ++i){
						allVO.add(service.toNewsIndex(all.get(i)));
					}
					String result = JSONArray.fromObject(allVO).toString();//ת����JSON��ʽ
					out.print(result);//���
				}
				if ("front".equals(style)){//�͹����̨�����б�һ��
					this.list(request, response);
				}
			}
			if ("show".equals(status)) {//��ȡ��������
				this.show(request, response);
			}
			if ("softwarelist".equals(status)){//��ȡJOSN��ʽ������б�
				AttachmentService attachService = new AttachmentService();
				List<NewsAttachment> attachments = attachService.findNewsAttachmentByNewsId(0);//�ҵ����е������Ϣ
				String result = JSONArray.fromObject(attachments).toString();//ת����JSON��ʽ
				out.print(result);//���
			}
		}else{
			
		}

		out.flush();
		out.close();
	}

	/**
	 * 
	 * ��ȡĳ�������б�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pages = "../errors.jsp";
		String URL = "NewsPlatServlet?status=list" ;
		
		try {
			int currentPage = 1 ;	// Ϊ��ǰ���ڵ�ҳ��Ĭ���ڵ�1ҳ
			int lineSize = 10;		// ÿ����ʾ�ļ�¼��
			long allRecorders = 0 ;	// ��ʾȫ���ļ�¼��
			int type = Integer.parseInt(request.getParameter("type"));//�������
			String newsType = typeService.getNewsTypeById(type).getNewsTypeName();
			
			try{
				currentPage = Integer.parseInt(request.getParameter("cp")) ;
			} catch(Exception e) {}
			try{
				lineSize = Integer.parseInt(request.getParameter("ls")) ;
			} catch(Exception e) {}
			
			//��ȡ�����ĳһҳ������
			List<NewsInfo> all = service.getAllNewsInfoByType(newsType,currentPage,lineSize) ;
			List<NewsVO> allVO = new ArrayList<NewsVO>();
			for (int i = 0; i<all.size(); ++i){
				allVO.add(service.toNewsVO(all.get(i)));
			}
			
			allRecorders = service.getAllNewsInfoByType(newsType).size() ;
			request.setAttribute("newsInfos",allVO);
			request.setAttribute("recorders",allRecorders);
			request.setAttribute("url", URL);
			request.setAttribute("page", currentPage);
			request.setAttribute("size", lineSize);
	
			
			pages = "newsfront_list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		String pages = "../errors.jsp";
		int newsId = Integer.parseInt(request.getParameter("pid")) ;
		try {//��ȡ��ǰ��ԱVO�������¸�ҳ��
			NewsInfo pro = service.searchNewsInfo(newsId);
			if(pro != null) {
				request.setAttribute("newsinfo",pro);
				AttachmentService attiService = new AttachmentService();
				List<NewsAttachment> attachments = attiService.findNewsAttachmentByNewsId((long)newsId);
				request.setAttribute("attachments", attachments);
			}
			pages = "newsfront_show.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(pages).forward(request, response);
	}
}
