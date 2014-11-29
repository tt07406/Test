package org.stockii.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * ��װ��һЩ����HttpClient����HTTP����ķ���
 * @see �����������õ������µ�HttpComponents-Client-4.2.1
 * @see ���ڱ��������е�һЩ����˵��,�ɲο��·��г����ҵ���ƪ����
 * @see http://blog.csdn.net/jadyer/article/details/7615830
 * @see http://blog.csdn.net/jadyer/article/details/7615880
 * @see http://blog.csdn.net/jadyer/article/details/7802139
 * @create Feb 1, 2012 3:02:27 PM
 * @update Oct 8, 2012 3:48:55 PM
 * @author ����<http://blog.csdn/net/jadyer>
 * @version v1.3
 * @history v1.0-->�½�<code>sendGetRequest(String,String)</code>��<code>sendPostRequest(String,Map<String,String>,String,String)</code>����
 * @history v1.1-->����<code>sendPostSSLRequest(String,Map<String,String>,String,String)</code>����,���ڷ���HTTPS��POST����
 * @history v1.2-->����<code>sendPostRequest(String,String,boolean,String,String)</code>����,���ڷ���HTTPЭ�鱨����Ϊ�����ַ�����POST����
 * @history v1.3-->����<code>java.net.HttpURLConnection</code>ʵ�ֵ�<code>sendPostRequestByJava()</code>����
 */
public class HttpClientUtil {
	private HttpClientUtil(){}
	
	/**
	 * ����HTTP_GET����
	 * @see �÷������Զ��ر�����,�ͷ���Դ
	 * @param requestURL    �����ַ(������)
	 * @param decodeCharset �����ַ���,������Ӧ����ʱ��֮,��ΪnullʱĬ�ϲ���UTF-8����
	 * @return Զ��������Ӧ����
	 */
	public static String sendGetRequest(String reqURL, String decodeCharset){
		long responseLength = 0;       //��Ӧ����
		String responseContent = null; //��Ӧ����
		HttpClient httpClient = new DefaultHttpClient(); //����Ĭ�ϵ�httpClientʵ��
		HttpGet httpGet = new HttpGet(reqURL);           //����org.apache.http.client.methods.HttpGet
		try{
			HttpResponse response = httpClient.execute(httpGet); //ִ��GET����
			HttpEntity entity = response.getEntity();            //��ȡ��Ӧʵ��
			if(null != entity){
				responseLength = entity.getContentLength();
				responseContent = EntityUtils.toString(entity, decodeCharset==null ? "UTF-8" : decodeCharset);
				EntityUtils.consume(entity); //Consume response content
			}
			System.out.println("�����ַ: " + httpGet.getURI());
			System.out.println("��Ӧ״̬: " + response.getStatusLine());
			System.out.println("��Ӧ����: " + responseLength);
			System.out.println("��Ӧ����: " + responseContent);
		}catch(ClientProtocolException e){
			LogUtil.getLogger().error("���쳣ͨ����Э�������,���繹��HttpGet����ʱ�����Э�鲻��(��'http'д��'htp')���߷������˷��ص����ݲ�����HTTPЭ��Ҫ���,��ջ��Ϣ����", e);
		}catch(ParseException e){
			LogUtil.getLogger().error(e.getMessage(), e);
		}catch(IOException e){
			LogUtil.getLogger().error("���쳣ͨ��������ԭ�������,��HTTP������δ������,��ջ��Ϣ����", e);
		}finally{
			httpClient.getConnectionManager().shutdown(); //�ر�����,�ͷ���Դ
		}
		return responseContent;
	}
	
	
	/**
	 * ����HTTP_POST����
	 * @see �÷���Ϊ<code>sendPostRequest(String,String,boolean,String,String)</code>�ļ򻯷���
	 * @see �÷����ڶ��������ݵı������Ӧ���ݵĽ���ʱ,�����õ��ַ�����ΪUTF-8
	 * @see ��<code>isEncoder=true</code>ʱ,����Զ���<code>sendData</code>�е�[����][|][ ]�������ַ�����<code>URLEncoder.encode(string,"UTF-8")</code>
	 * @param isEncoder ����ָ�����������Ƿ���ҪUTF-8����,trueΪ��Ҫ
	 */
	public static String sendPostRequest(String reqURL, String sendData, boolean isEncoder){
		return sendPostRequest(reqURL, sendData, isEncoder, null, null);
	}
	
	
	/**
	 * ����HTTP_POST����
	 * @see �÷������Զ��ر�����,�ͷ���Դ
	 * @see ��<code>isEncoder=true</code>ʱ,����Զ���<code>sendData</code>�е�[����][|][ ]�������ַ�����<code>URLEncoder.encode(string,encodeCharset)</code>
	 * @param reqURL        �����ַ
	 * @param sendData      �������,���ж��������Ӧƴ�ӳ�param11=value11m22=value22m33=value33����ʽ��,����ò�����
	 * @param isEncoder     ���������Ƿ���ҪencodeCharset����,trueΪ��Ҫ
	 * @param encodeCharset �����ַ���,������������ʱ��֮,��ΪnullʱĬ�ϲ���UTF-8����
	 * @param decodeCharset �����ַ���,������Ӧ����ʱ��֮,��ΪnullʱĬ�ϲ���UTF-8����
	 * @return Զ��������Ӧ����
	 */
	public static String sendPostRequest(String reqURL, String sendData, boolean isEncoder, String encodeCharset, String decodeCharset){
		String responseContent = null;
		HttpClient httpClient = new DefaultHttpClient();
		
		HttpPost httpPost = new HttpPost(reqURL);
		//httpPost.setHeader(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=UTF-8");
		httpPost.setHeader(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded");
		try{
			if(isEncoder){
				List<NameValuePair> formParams = new ArrayList<NameValuePair>();
				for(String str : sendData.split("&")){
					formParams.add(new BasicNameValuePair(str.substring(0,str.indexOf("=")), str.substring(str.indexOf("=")+1)));
				}
				httpPost.setEntity(new StringEntity(URLEncodedUtils.format(formParams, encodeCharset==null ? "UTF-8" : encodeCharset)));
			}else{
				httpPost.setEntity(new StringEntity(sendData));
			}
			
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (null != entity) {
				responseContent = EntityUtils.toString(entity, decodeCharset==null ? "UTF-8" : decodeCharset);
				EntityUtils.consume(entity);
			}
		}catch(Exception e){
			LogUtil.getLogger().error("��[" + reqURL + "]ͨ�Ź����з����쳣,��ջ��Ϣ����", e);
		}finally{
			httpClient.getConnectionManager().shutdown();
		}
		return responseContent;
	}
	
	
	/**
	 * ����HTTP_POST����
	 * @see �÷������Զ��ر�����,�ͷ���Դ
	 * @see �÷������Զ���<code>params</code>�е�[����][|][ ]�������ַ�����<code>URLEncoder.encode(string,encodeCharset)</code>
	 * @param reqURL        �����ַ
	 * @param params        �������
	 * @param encodeCharset �����ַ���,������������ʱ��֮,��ΪnullʱĬ�ϲ���UTF-8����
	 * @param decodeCharset �����ַ���,������Ӧ����ʱ��֮,��ΪnullʱĬ�ϲ���UTF-8����
	 * @return Զ��������Ӧ����
	 */
	public static String sendPostRequest(String reqURL, Map<String, String> params, String encodeCharset, String decodeCharset){
		String responseContent = null;
		HttpClient httpClient = new DefaultHttpClient();
		
		HttpPost httpPost = new HttpPost(reqURL);
		List<NameValuePair> formParams = new ArrayList<NameValuePair>(); //������������
		for(Map.Entry<String,String> entry : params.entrySet()){
			formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		try{
			httpPost.setEntity(new UrlEncodedFormEntity(formParams, encodeCharset==null ? "UTF-8" : encodeCharset));
			
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (null != entity) {
				responseContent = EntityUtils.toString(entity, decodeCharset==null ? "UTF-8" : decodeCharset);
				EntityUtils.consume(entity);
			}
		}catch(Exception e){
			LogUtil.getLogger().error("��[" + reqURL + "]ͨ�Ź����з����쳣,��ջ��Ϣ����", e);
		}finally{
			httpClient.getConnectionManager().shutdown();
		}
		return responseContent;
	}
	
	
	/**
	 * ����HTTPS_POST����
	 * @see �÷���Ϊ<code>sendPostSSLRequest(String,Map<String,String>,String,String)</code>�����ļ򻯷���
	 * @see �÷����ڶ��������ݵı������Ӧ���ݵĽ���ʱ,�����õ��ַ�����ΪUTF-8
	 * @see �÷������Զ���<code>params</code>�е�[����][|][ ]�������ַ�����<code>URLEncoder.encode(string,"UTF-8")</code>
	 */
	public static String sendPostSSLRequest(String reqURL, Map<String, String> params){
		return sendPostSSLRequest(reqURL, params, null, null);
	}
	
	
	/**
	 * ����HTTPS_POST����
	 * @see �÷������Զ��ر�����,�ͷ���Դ
	 * @see �÷������Զ���<code>params</code>�е�[����][|][ ]�������ַ�����<code>URLEncoder.encode(string,encodeCharset)</code>
	 * @param reqURL        �����ַ
	 * @param params        �������
	 * @param encodeCharset �����ַ���,������������ʱ��֮,��ΪnullʱĬ�ϲ���UTF-8����
	 * @param decodeCharset �����ַ���,������Ӧ����ʱ��֮,��ΪnullʱĬ�ϲ���UTF-8����
	 * @return Զ��������Ӧ����
	 */
	public static String sendPostSSLRequest(String reqURL, Map<String, String> params, String encodeCharset, String decodeCharset){
		String responseContent = "";
		HttpClient httpClient = new DefaultHttpClient();
		X509TrustManager xtm = new X509TrustManager(){
			public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
			public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
			public X509Certificate[] getAcceptedIssuers() {return null;}
		};
		try {
			SSLContext ctx = SSLContext.getInstance("TLS");
			ctx.init(null, new TrustManager[]{xtm}, null);
			SSLSocketFactory socketFactory = new SSLSocketFactory(ctx);
			httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", 443, socketFactory));
			
			HttpPost httpPost = new HttpPost(reqURL);
			List<NameValuePair> formParams = new ArrayList<NameValuePair>();
			for(Map.Entry<String,String> entry : params.entrySet()){
				formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
			httpPost.setEntity(new UrlEncodedFormEntity(formParams, encodeCharset==null ? "UTF-8" : encodeCharset));
			
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (null != entity) {
				responseContent = EntityUtils.toString(entity, decodeCharset==null ? "UTF-8" : decodeCharset);
				EntityUtils.consume(entity);
			}
		} catch (Exception e) {
			LogUtil.getLogger().error("��[" + reqURL + "]ͨ�Ź����з����쳣,��ջ��ϢΪ", e);
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return responseContent;
	}
	
	
	/**
	 * ����HTTP_POST����
	 * @see �����͵�<code>params</code>�к�������,�ǵð���˫��Լ�����ַ���������<code>URLEncoder.encode(string,encodeCharset)</code>
	 * @see ������Ĭ�ϵ����ӳ�ʱʱ��Ϊ30��,Ĭ�ϵĶ�ȡ��ʱʱ��Ϊ30��
	 * @param reqURL �����ַ
	 * @param params ���͵�Զ����������������,����������Ϊ<code>java.util.Map<String, String></code>
	 * @return Զ��������Ӧ����`HTTP״̬��,��<code>"SUCCESS`200"</code>��ͨ�Ź����з����쳣�򷵻�"Failed`HTTP״̬��",��<code>"Failed`500"</code>
	 */
	public static String sendPostRequestByJava(String reqURL, Map<String, String> params){
		StringBuilder sendData = new StringBuilder();
		for(Map.Entry<String, String> entry : params.entrySet()){
			sendData.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
		}
		if(sendData.length() > 0){
			sendData.setLength(sendData.length() - 1); //ɾ�����һ��&����
		}
		return sendPostRequestByJava(reqURL, sendData.toString());
	}
	
	
	/**
	 * ����HTTP_POST����
	 * @see �����͵�<code>sendData</code>�к�������,�ǵð���˫��Լ�����ַ���������<code>URLEncoder.encode(string,encodeCharset)</code>
	 * @see ������Ĭ�ϵ����ӳ�ʱʱ��Ϊ30��,Ĭ�ϵĶ�ȡ��ʱʱ��Ϊ30��
	 * @param reqURL   �����ַ
	 * @param sendData ���͵�Զ����������������
	 * @return Զ��������Ӧ����`HTTP״̬��,��<code>"SUCCESS`200"</code>��ͨ�Ź����з����쳣�򷵻�"Failed`HTTP״̬��",��<code>"Failed`500"</code>
	 */
	public static String sendPostRequestByJava(String reqURL, String sendData){
		HttpURLConnection httpURLConnection = null;
		OutputStream out = null; //д
		InputStream in = null;   //��
		int httpStatusCode = 0;  //Զ��������Ӧ��HTTP״̬��
		try{
			URL sendUrl = new URL(reqURL);
			httpURLConnection = (HttpURLConnection)sendUrl.openConnection();
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setDoOutput(true);        //ָʾӦ�ó���Ҫ������д��URL����,��ֵĬ��Ϊfalse
			httpURLConnection.setUseCaches(false);
			httpURLConnection.setConnectTimeout(30000); //30�����ӳ�ʱ
			httpURLConnection.setReadTimeout(30000);    //30���ȡ��ʱ
			
			out = httpURLConnection.getOutputStream();
			out.write(sendData.toString().getBytes());
			
			//��ջ�����,��������
			out.flush();
			
			//��ȡHTTP״̬��
			httpStatusCode = httpURLConnection.getResponseCode();
			
			//�÷���ֻ�ܻ�ȡ��[HTTP/1.0 200 OK]�е�[OK]
			//���Է���Ӧ�����ķ����˷��ر��ĵ����һ��,��÷�����ȡ��������,��ֻ�ܻ�ȡ��[OK],�����ź�
			//respData = httpURLConnection.getResponseMessage();
			
//			//�����ؽ��
//			BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
//			String row = null;
//			String respData = "";
//			if((row=br.readLine()) != null){ //readLine()�����ڶ�������[\n]��س�[\r]ʱ,����Ϊ��������ֹ
//				respData = row;              //HTTPЭ��POST��ʽ�����һ������Ϊ��������
//			}
//			br.close();
			
			in = httpURLConnection.getInputStream();             
			byte[] byteDatas = new byte[in.available()];
			in.read(byteDatas);
			return new String(byteDatas) + "`" + httpStatusCode;
		}catch(Exception e){
			LogUtil.getLogger().error(e.getMessage());
			return "Failed`" + httpStatusCode;
		}finally{
			if(out != null){
				try{
					out.close();
				}catch (Exception e){
					LogUtil.getLogger().error("�ر������ʱ�����쳣,��ջ��Ϣ����", e);
				}
			}
			if(in != null){
				try{
					in.close();
				}catch(Exception e){
					LogUtil.getLogger().error("�ر�������ʱ�����쳣,��ջ��Ϣ����", e);
				}
			}
			if(httpURLConnection != null){
				httpURLConnection.disconnect();
				httpURLConnection = null;
			}
		}
	}
}
