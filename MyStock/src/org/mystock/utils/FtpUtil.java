/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������FtpUtil
 * 
 * �������ڣ�2014-09-30
 */
package org.mystock.utils;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
import sun.net.TelnetInputStream;
import sun.net.TelnetOutputStream;
import sun.net.ftp.FtpClient;
/**
 * FTP�ϴ�������
 * @author icelove
 *
 */
public class FtpUtil {
	
	private String ip = "";
	private String username = "";
	private String password = "";
	private int port = -1;
	private String path = "";
	private FtpClient ftpClient = null;
	private OutputStream os = null;
	private FileInputStream is = null;
	private static boolean isValid = false;
	
	public static boolean isValid() {
		return isValid;
	}

	public static void setValid(boolean valid) {
		isValid = valid;
	}

	public FtpUtil(String serverIP, String username, String password) {
		this.ip = serverIP;
		this.username = username;
		this.password = password;
	}

	public FtpUtil(String serverIP, int port, String username, String password) {
		this.ip = serverIP;
		this.username = username;
		this.password = password;
		this.port = port;
	}

	/**
	 * ����ftp������
	 * 
	 * @throws IOException
	 */
	public boolean connectServer() {
		ftpClient = new FtpClient();

		try {
			if (this.port != -1) {
				ftpClient.openServer(this.ip, this.port);
			} else {
				ftpClient.openServer(this.ip);
			}
			ftpClient.login(this.username, this.password);
			if (this.path.length() != 0) {
				ftpClient.cd(this.path);// path��ftp��������Ŀ¼����Ŀ¼
			}
			ftpClient.binary();// ��2�����ϴ�������
			System.out.println("�ѵ�¼��\"" + ftpClient.pwd() + "\"Ŀ¼");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * �Ͽ���ftp����������
	 * 
	 * @throws IOException
	 */
	public boolean closeServer() {
		try {
			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}
			if (ftpClient != null) {
				ftpClient.closeServer();
			}
			System.out.println("�Ѵӷ������Ͽ�");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * ����ļ����ڵ�ǰĿ¼���Ƿ����
	 * 
	 * @param dir
	 * @return
	 */
	private boolean isDirExist(String dir) {
		String pwd = "";
		try {
			pwd = ftpClient.pwd();
			ftpClient.cd(dir);
			ftpClient.cd(pwd);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * �ڵ�ǰĿ¼�´����ļ���
	 * 
	 * @param dir
	 * @return
	 * @throws Exception
	 */
	private boolean createDir(String dir) {
		try {
			ftpClient.ascii();
			StringTokenizer s = new StringTokenizer(dir, "/"); // sign
			s.countTokens();
			String pathName = ftpClient.pwd();
			while (s.hasMoreElements()) {
				pathName = pathName + "/" + (String) s.nextElement();
				try {
					ftpClient.sendServer("MKD " + pathName + "\r\n");
				} catch (Exception e) {
					e = null;
					return false;
				}
				ftpClient.readServerResponse();
			}
			ftpClient.binary();
			return true;
		} catch (IOException e1) {
			e1.printStackTrace();
			return false;
		}
	}

	/**
	 * ftp�ϴ� ������������Ѵ�����Ϊfilename���ļ��У����ļ�������Ҫ�ϴ����ļ�����ͬ�����ļ������滻
	 * 
	 * @param filename
	 *            Ҫ�ϴ����ļ������ļ��У���
	 * @return
	 * @throws Exception
	 */
	public boolean upload(String filename) {
		String newname = "";
		if (filename.indexOf("/") > -1) {
			newname = filename.substring(filename.lastIndexOf("/") + 1);
		} else {
			newname = filename;
		}
		return upload(filename, newname);
	}

	/**
	 * ftp�ϴ� ������������Ѵ�����ΪnewName���ļ��У����ļ�������Ҫ�ϴ����ļ�����ͬ�����ļ������滻
	 * 
	 * @param fileName
	 *            Ҫ�ϴ����ļ������ļ��У���
	 * @param newName
	 *            ��������Ҫ���ɵ��ļ������ļ��У���
	 * @return
	 */
	public boolean upload(String fileName, String newName) {
		try {
			String savefilename = new String(fileName.getBytes("ISO-8859-1"),
					"GBK");

			File file_in = new File(savefilename);// �򿪱��ش��������ļ�
			if (!file_in.exists()) {
				throw new Exception("���ļ����ļ���[" + file_in.getName() + "]����򲻴���!");
			}
			if (file_in.isDirectory()) {
				upload(file_in.getPath(), newName, ftpClient.pwd());
			} else {
				uploadFile(file_in.getPath(), newName);
			}

			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception e in Ftp upload(): " + e.toString());
			return false;
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ���������ϴ��ķ���
	 * 
	 * @param fileName
	 * @param newName
	 * @param path
	 * @throws Exception
	 */
	private void upload(String fileName, String newName, String path)
			throws Exception {
		String savefilename = new String(fileName.getBytes("ISO-8859-1"), "GBK");
		File file_in = new File(savefilename);// �򿪱��ش��������ļ�
		if (!file_in.exists()) {
			throw new Exception("���ļ����ļ���[" + file_in.getName() + "]����򲻴���!");
		}
		if (file_in.isDirectory()) {
			if (!isDirExist(newName)) {
				createDir(newName);
			}
			ftpClient.cd(newName);
			File sourceFile[] = file_in.listFiles();
			for (int i = 0; i < sourceFile.length; i++) {
				if (!sourceFile[i].exists()) {
					continue;
				}
				if (sourceFile[i].isDirectory()) {
					this.upload(sourceFile[i].getPath(), sourceFile[i]
							.getName(), path + "/" + newName);
				} else {
					this.uploadFile(sourceFile[i].getPath(), sourceFile[i]
							.getName());
				}
			}
		} else {
			uploadFile(file_in.getPath(), newName);
		}
		ftpClient.cd(path);
	}

	/**
	 * upload �ϴ��ļ�
	 * 
	 * @param filename
	 *            Ҫ�ϴ����ļ���
	 * @param newname
	 *            �ϴ�������ļ���
	 * @return -1 �ļ������� >=0 �ɹ��ϴ��������ļ��Ĵ�С
	 * @throws Exception
	 */
	public long uploadFile(String filename, String newname) throws Exception {
		long result = 0;
		TelnetOutputStream os = null;
		FileInputStream is = null;
		try {
			java.io.File file_in = new java.io.File(filename);
			if (!file_in.exists())
				return -1;
			os = ftpClient.put(newname);
			result = file_in.length();
			is = new FileInputStream(file_in);
			byte[] bytes = new byte[1024];
			int c;
			while ((c = is.read(bytes)) != -1) {
				os.write(bytes, 0, c);
			}
		} finally {
			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}
		}
		return result;
	}

	/**
	 * ��ftp�����ļ�������
	 * 
	 * @param filename
	 *            �������ϵ��ļ���
	 * @param newfilename
	 *            �������ɵ��ļ���
	 * @return
	 * @throws Exception
	 */
	public long downloadFile(String filename, String newfilename) {
		long result = 0;
		TelnetInputStream is = null;
		FileOutputStream os = null;
		try {
			is = ftpClient.get(filename);
			java.io.File outfile = new java.io.File(newfilename);
			os = new FileOutputStream(outfile);
			byte[] bytes = new byte[1024];
			int c;
			while ((c = is.read(bytes)) != -1) {
				os.write(bytes, 0, c);
				result = result + c;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * ȡ������ڵ�ǰ����Ŀ¼��ĳ��Ŀ¼�������ļ��б�
	 * 
	 * @param path
	 * @return
	 */
	public List getFileList(String path) {
		List list = new ArrayList();
		DataInputStream dis;
		try {
			dis = new DataInputStream(ftpClient.nameList(this.path + path));
			String filename = "";
			while ((filename = dis.readLine()) != null) {
				list.add(filename);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * �����ļ���FTP
	 * 
	 * @param serverIP
	 *            IP��ַ
	 * @param username
	 *            �û���
	 * @param password
	 *            ����
	 * @param fileName
	 *            Ҫ�ϴ����ļ���
	 * @param newname
	 *            �ϴ�������ļ���
	 * @return �Ƿ��ϴ��ɹ�
	 */
	public static boolean backupFile(String serverIP, String username,
			String password, String fileName, String newname) {
		if (serverIP==null||username==null||password==null||fileName==null||newname==null){
			return false;
		}
		
		FtpUtil ftp = new FtpUtil(serverIP, username, password);
		if (ftp.connectServer()) {
			if (ftp.upload(fileName, newname)) {
				return true;
			}
			System.out.println("ftp upload fail");
		} else {
			System.out.println("connect ftp fail");
		}
		return false;
	}

	/**
	 * �����ļ���FTP
	 * 
	 * @param fileName
	 *            Ҫ�ϴ����ļ���
	 * @param newname
	 *            �ϴ�������ļ���
	 * @return �Ƿ��ϴ��ɹ�
	 */
	public static boolean backupFile(String fileName, String newname) {
		if (fileName==null||newname==null){
			return false;
		}
		
		FtpUtil ftp = new FtpUtil("133.224.202.2", "tstbill", "tstbill");
		
		if (!isValid){
			return false;
		}
		
		if (ftp.connectServer()) {
			if (ftp.upload(fileName, newname)) {
				return true;
			}
			System.out.println("ftp upload fail");
		} else {
			System.out.println("connect ftp fail");
		}
		return false;
	}
 
 public static void main(String[] args) {
  FtpUtil ftp = new FtpUtil("133.224.202.2", "tstbill", "tstbill");
  ftp.connectServer();
  boolean result = ftp.upload("C:/test_why", "test_why/test");
  System.out.println(result ? "�ϴ��ɹ���" : "�ϴ�ʧ�ܣ�");
  List list = ftp.getFileList("test_why/test");
  for (int i = 0; i < list.size(); i++) {
   String name = list.get(i).toString();
   System.out.println(name);
  }
  ftp.closeServer();
  /**    
  FTPԶ�������б�    
  USER    PORT    RETR    ALLO    DELE    SITE    XMKD    CDUP    FEAT    
  PASS    PASV    STOR    REST    CWD     STAT    RMD     XCUP    OPTS    
  ACCT    TYPE    APPE    RNFR    XCWD    HELP    XRMD    STOU    AUTH    
  REIN    STRU    SMNT    RNTO    LIST    NOOP    PWD     SIZE    PBSZ    
  QUIT    MODE    SYST    ABOR    NLST    MKD     XPWD    MDTM    PROT    
  �ڷ�������ִ������,�����sendServer��ִ��Զ������(����ִ�б���FTP����)�Ļ�������FTP���Ҫ����\r\n    
  ftpclient.sendServer("XMKD /test/bb\r\n"); //ִ�з������ϵ�FTP����    
  ftpclient.readServerResponseһ��Ҫ��sendServer�����    
  nameList("/test")��ȡָĿ¼�µ��ļ��б�    
  XMKD����Ŀ¼����Ŀ¼���ڵ�������ٴδ���Ŀ¼ʱ����    
  XRMDɾ��Ŀ¼    
  DELEɾ���ļ�    
   */
 }
}