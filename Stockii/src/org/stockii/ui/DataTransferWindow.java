package org.stockii.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Label;
import org.stockii.common.Common;
import org.stockii.common.LogUtil;
import org.stockii.dao.CashDAO;
import org.stockii.dao.EquityChangeDAO;
import org.stockii.dao.LiabilityDAO;
import org.stockii.dao.ProfitDAO;

public class DataTransferWindow {
	private Display display;
	private Shell shell;
	protected Text t;
	protected Table ta;
	private int SHEET_NUM = 0;
	
	private List<List<Object>> result = null;
	private Text rowNum;
	private Text colNum;

	public static void main(String[] args) {
		try {
			DataTransferWindow window = new DataTransferWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
		display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	// 创建组件
	protected void createContents() {
		shell = new Shell(SWT.MIN);
		shell.setSize(1000, 800);
		shell.setText("我的窗体");
		t = new Text(shell, SWT.NONE);
		t.setBounds(15, 15, 600, 20);
		t.setEditable(false);
		t.setBackground(new Color(display, 255, 255, 255));
		Button btn = new Button(shell, SWT.NONE);
		btn.setBounds(644, 10, 80, 27);
		btn.setText("选择文件");
		btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(shell, SWT.NONE);
				fd.setText("打开文件");
				fd.setFilterExtensions(new String[] { "*.xls" });
				String path = fd.open();
				t.setText(path == null ? "" : path);
				if (!"".equals(t.getText().trim())) {
					try {
						getExcel(t.getText().trim());						
					} catch (FileNotFoundException e1) {

						e1.printStackTrace();
					} catch (IOException e1) {

						e1.printStackTrace();
					}
				}
			}
		});

		Button last = new Button(shell, SWT.NONE);
		last.setBounds(761, 13, 70, 20);
		last.setText("上一个");
		last.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (SHEET_NUM-- < 0) {
					SHEET_NUM = 0;
				}
				if (!"".equals(t.getText().trim())) {
					try {
						getExcel(t.getText().trim());
					} catch (FileNotFoundException e1) {

						e1.printStackTrace();
					} catch (IOException e1) {

						e1.printStackTrace();
					}
				}
			}

		});

		Button next = new Button(shell, SWT.NONE);
		next.setBounds(857, 13, 70, 20);
		next.setText("下一个");
		next.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				SHEET_NUM++;
				if (!"".equals(t.getText().trim())) {
					try {
						getExcel(t.getText().trim());
					} catch (FileNotFoundException e1) {

						e1.printStackTrace();
					} catch (IOException e1) {

						e1.printStackTrace();
					}
				}
			}

		});

		ta = new Table(shell, SWT.BORDER);
		ta.setBounds(0, 150, 1000, 600);
		ta.setLinesVisible(true);
		ta.setRedraw(true);
		ta.setLayoutDeferred(true);
		
		rowNum = new Text(shell, SWT.BORDER);
		rowNum.setBounds(78, 58, 121, 20);
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(11, 61, 61, 17);
		label.setText("\u884C\u6570\uFF1A");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(11, 92, 61, 17);
		label_1.setText("\u5217\u6570\uFF1A");
		
		colNum = new Text(shell, SWT.BORDER);
		colNum.setBounds(78, 86, 121, 23);
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//新建文件夹（目录）对话框
		        DirectoryDialog folderdlg=new DirectoryDialog(shell);
		        //设置文件对话框的标题
		        folderdlg.setText("文件选择");

		        //设置对话框提示文本信息
		        folderdlg.setMessage("请选择相应的文件夹");
		        //打开文件对话框，返回选中文件夹目录
		        String selecteddir=folderdlg.open();
		        if(selecteddir==null){
		            return ;
		        }
		        else{
		            t.setText(selecteddir);
		            handleLiabilityBatch(selecteddir);
		        } 
			}
		});
		button.setBounds(285, 102, 96, 27);
		button.setText("\u8D1F\u503A\u8868\u6279\u91CF\u5BFC\u5165");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(shell, SWT.NONE);
				fd.setText("打开文件");
				fd.setFilterExtensions(new String[] { "*.xls" });
				String path = fd.open();
				t.setText(path == null ? "" : path);
				if (!"".equals(t.getText().trim())) {
					try {
						rowNum.setText("");
						colNum.setText("");
						//getExcel(t.getText().trim());
						result = read2003ExcelColumn(new File(t.getText().trim()));
						if (result != null && result.size() > 0){
							rowNum.setText(result.size()+"");
							colNum.setText(result.get(0).size()+"");
							LiabilityDAO dao = new LiabilityDAO();

							boolean success = dao.insertBatchBank(result);
							if (!success){
								t.setText("银行类批量插入失败");
								return;
							}
						}
						
					} catch (FileNotFoundException e1) {

						e1.printStackTrace();
					} catch (IOException e1) {

						e1.printStackTrace();
					}
				}
			}
		});
		button_1.setBounds(238, 56, 80, 27);
		button_1.setText("\u94F6\u884C\u8D1F\u503A\u8868");
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(shell, SWT.NONE);
				fd.setText("打开文件");
				fd.setFilterExtensions(new String[] { "*.xls" });
				String path = fd.open();
				t.setText(path == null ? "" : path);
				if (!"".equals(t.getText().trim())) {
					try {
						rowNum.setText("");
						colNum.setText("");
						//getExcel(t.getText().trim());
						result = read2003ExcelColumn(new File(t.getText().trim()));
						if (result != null && result.size() > 0){
							rowNum.setText(result.size()+"");
							colNum.setText(result.get(0).size()+"");
							LiabilityDAO dao = new LiabilityDAO();

							boolean success = dao.insertBatch(result);
							if (!success){
								t.setText("批量插入失败");
								return;
							}
						}
						
					} catch (FileNotFoundException e1) {

						e1.printStackTrace();
					} catch (IOException e1) {

						e1.printStackTrace();
					}
				}
			}
		});
		button_2.setBounds(340, 56, 84, 27);
		button_2.setText("\u975E\u94F6\u884C\u8D1F\u503A\u8868");
		
		Button button_3 = new Button(shell, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//新建文件夹（目录）对话框
		        DirectoryDialog folderdlg=new DirectoryDialog(shell);
		        //设置文件对话框的标题
		        folderdlg.setText("文件选择");

		        //设置对话框提示文本信息
		        folderdlg.setMessage("请选择相应的文件夹");
		        //打开文件对话框，返回选中文件夹目录
		        String selecteddir=folderdlg.open();
		        if(selecteddir==null){
		            return ;
		        }
		        else{
		            t.setText(selecteddir);
		            handleProfitBatch(selecteddir);
		        } 
			}
		});
		button_3.setBounds(458, 102, 96, 27);
		button_3.setText("\u5229\u6DA6\u8868\u6279\u91CF\u5BFC\u5165");
		
		Button button_4 = new Button(shell, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//新建文件夹（目录）对话框
		        DirectoryDialog folderdlg=new DirectoryDialog(shell);
		        //设置文件对话框的标题
		        folderdlg.setText("文件选择");

		        //设置对话框提示文本信息
		        folderdlg.setMessage("请选择相应的文件夹");
		        //打开文件对话框，返回选中文件夹目录
		        String selecteddir=folderdlg.open();
		        if(selecteddir==null){
		            return ;
		        }
		        else{
		            t.setText(selecteddir);
		            handleCashBatch(selecteddir);
		        } 
			}
		});
		button_4.setBounds(833, 102, 94, 27);
		button_4.setText("\u73B0\u91D1\u8868\u6279\u91CF\u5BFC\u5165");
		
		Button button_5 = new Button(shell, SWT.NONE);
		button_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//新建文件夹（目录）对话框
		        DirectoryDialog folderdlg=new DirectoryDialog(shell);
		        //设置文件对话框的标题
		        folderdlg.setText("文件选择");

		        //设置对话框提示文本信息
		        folderdlg.setMessage("请选择相应的文件夹");
		        //打开文件对话框，返回选中文件夹目录
		        String selecteddir=folderdlg.open();
		        if(selecteddir==null){
		            return ;
		        }
		        else{
		            t.setText(selecteddir);
		            handleChangeBatch(selecteddir);
		        } 
			}
		});
		button_5.setBounds(631, 102, 139, 27);
		button_5.setText("\u6743\u76CA\u53D8\u52A8\u8868\u6279\u91CF\u5BFC\u5165");
		
		Button button_6 = new Button(shell, SWT.NONE);
		button_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(shell, SWT.NONE);
				fd.setText("打开文件");
				fd.setFilterExtensions(new String[] { "*.xls" });
				String path = fd.open();
				t.setText(path == null ? "" : path);
				if (!"".equals(t.getText().trim())) {
					try {
						rowNum.setText("");
						colNum.setText("");
						//getExcel(t.getText().trim());
						result = read2003ExcelColumn(new File(t.getText().trim()));
						if (result != null && result.size() > 0){
							rowNum.setText(result.size()+"");
							colNum.setText(result.get(0).size()+"");
							ProfitDAO dao = new ProfitDAO();

							boolean success = dao.insertBatchBank(result);
							if (!success){
								t.setText("批量插入失败");
								return;
							}
						}
						
					} catch (FileNotFoundException e1) {

						e1.printStackTrace();
					} catch (IOException e1) {

						e1.printStackTrace();
					}
				}
			}
		});
		button_6.setBounds(446, 56, 80, 27);
		button_6.setText("\u94F6\u884C\u5229\u6DA6\u8868");
		
		Button button_7 = new Button(shell, SWT.NONE);
		button_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(shell, SWT.NONE);
				fd.setText("打开文件");
				fd.setFilterExtensions(new String[] { "*.xls" });
				String path = fd.open();
				t.setText(path == null ? "" : path);
				if (!"".equals(t.getText().trim())) {
					try {
						rowNum.setText("");
						colNum.setText("");
						//getExcel(t.getText().trim());
						result = read2003ExcelColumn(new File(t.getText().trim()));
						if (result != null && result.size() > 0){
							rowNum.setText(result.size()+"");
							colNum.setText(result.get(0).size()+"");
							ProfitDAO dao = new ProfitDAO();

							boolean success = dao.insertBatch(result);
							if (!success){
								t.setText("批量插入失败");
								return;
							}
						}
						
					} catch (FileNotFoundException e1) {

						e1.printStackTrace();
					} catch (IOException e1) {

						e1.printStackTrace();
					}
				}
			}
		});
		button_7.setBounds(553, 56, 96, 27);
		button_7.setText("\u975E\u94F6\u884C\u5229\u6DA6\u8868");
		
		Button button_8 = new Button(shell, SWT.NONE);
		button_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(shell, SWT.NONE);
				fd.setText("打开文件");
				fd.setFilterExtensions(new String[] { "*.xls" });
				String path = fd.open();
				t.setText(path == null ? "" : path);
				if (!"".equals(t.getText().trim())) {
					try {
						rowNum.setText("");
						colNum.setText("");
						//getExcel(t.getText().trim());
						result = read2003Excel(new File(t.getText().trim()));
						if (result != null && result.size() > 0){
							rowNum.setText(result.size()+"");
							colNum.setText(result.get(0).size()+"");
							EquityChangeDAO dao = new EquityChangeDAO();

							boolean success = dao.insertBatch(result);
							if (!success){
								t.setText("批量插入失败");
								return;
							}
						}
						
					} catch (FileNotFoundException e1) {

						e1.printStackTrace();
					} catch (IOException e1) {

						e1.printStackTrace();
					}
				}
			}
		});
		button_8.setBounds(679, 56, 80, 27);
		button_8.setText("\u6743\u76CA\u53D8\u52A8\u8868");
		
		Button button_9 = new Button(shell, SWT.NONE);
		button_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(shell, SWT.NONE);
				fd.setText("打开文件");
				fd.setFilterExtensions(new String[] { "*.xls" });
				String path = fd.open();
				t.setText(path == null ? "" : path);
				if (!"".equals(t.getText().trim())) {
					try {
						rowNum.setText("");
						colNum.setText("");
						//getExcel(t.getText().trim());
						result = read2003ExcelColumn(new File(t.getText().trim()));
						if (result != null && result.size() > 0){
							rowNum.setText(result.size()+"");
							colNum.setText(result.get(0).size()+"");
							CashDAO dao = new CashDAO();

							boolean success = dao.insertBatchBank(result);
							if (!success){
								t.setText("批量插入失败");
								return;
							}
						}
						
					} catch (FileNotFoundException e1) {

						e1.printStackTrace();
					} catch (IOException e1) {

						e1.printStackTrace();
					}
				}
			}
		});
		button_9.setBounds(788, 56, 80, 27);
		button_9.setText("\u94F6\u884C\u73B0\u91D1\u8868");
		
		Button button_10 = new Button(shell, SWT.NONE);
		button_10.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(shell, SWT.NONE);
				fd.setText("打开文件");
				fd.setFilterExtensions(new String[] { "*.xls" });
				String path = fd.open();
				t.setText(path == null ? "" : path);
				if (!"".equals(t.getText().trim())) {
					try {
						rowNum.setText("");
						colNum.setText("");
						//getExcel(t.getText().trim());
						result = read2003ExcelColumn(new File(t.getText().trim()));
						if (result != null && result.size() > 0){
							rowNum.setText(result.size()+"");
							colNum.setText(result.get(0).size()+"");
							CashDAO dao = new CashDAO();

							boolean success = dao.insertBatch(result);
							if (!success){
								t.setText("批量插入失败");
								return;
							}
						}
						
					} catch (FileNotFoundException e1) {

						e1.printStackTrace();
					} catch (IOException e1) {

						e1.printStackTrace();
					}
				}
			}
		});
		button_10.setBounds(890, 58, 94, 27);
		button_10.setText("\u975E\u94F6\u884C\u73B0\u91D1\u8868");
	}

	// 获取excel表格内容（无图）
	protected void getExcel(String fileToBeRead) throws FileNotFoundException,
			IOException {
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(
				fileToBeRead));
		ta.removeAll();
		HSSFSheet sheet = null;
		try {
			sheet = workbook.getSheetAt(SHEET_NUM);
		} catch (Exception e1) {
			MessageBox mb = new MessageBox(shell, SWT.NONE);
			mb.setText("提示");
			mb.setMessage("文件格式不支持或sheet不存在！");
			mb.open();

			return;
		}

		int rowNum = sheet.getLastRowNum();
		HSSFRow row1 = sheet.getRow(0);
		int iiis = 7;
		if (row1 != null) {
			iiis = row1.getLastCellNum();
		}

		for (int i = 0; i < iiis; i++) {
			TableColumn t = new TableColumn(ta, SWT.NONE);
			t.setWidth(1000 / iiis);
		}

		for (int j = 0; j < rowNum +1; j++) {
			String[] ss = new String[iiis];
			HSSFRow row = sheet.getRow(j);
			TableItem ti = new TableItem(ta, SWT.NONE);

			for (int i = 0; i < row.getLastCellNum(); i++) {
				HSSFCell cell = null;
				try {
					cell = row.getCell(i);

					if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
						ss[i] = cell.getStringCellValue();
					} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
						ss[i] = (long) (cell.getNumericCellValue()) + "";
					} else {
						ss[i] = cell.getRichStringCellValue().getString();
					}
				} catch (Exception e) {
					System.out.println("错误信息：" + e.getMessage());
				}
			}
			ti.setText(ss);
		}
	}
	
	/**
	 * 按行读取 office 2003 excel
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private List<List<Object>> read2003Excel(File file)
			throws IOException {
		List<List<Object>> list = new LinkedList<List<Object>>();
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(
				file));

		HSSFSheet sheet = null;
		Object value = null;
		try {
			sheet = workbook.getSheetAt(SHEET_NUM);
		} catch (Exception e1) {
			MessageBox mb = new MessageBox(shell, SWT.NONE);
			mb.setText("提示");
			mb.setMessage("文件格式不支持或sheet不存在！");
			mb.open();

			return list;
		}

		int rowNum = sheet.getLastRowNum();
		String sheetName = sheet.getSheetName();
		HSSFRow row1 = sheet.getRow(0);
		int iiis = 7;
		if (row1 != null) {
			iiis = row1.getLastCellNum();
		}
		
		for (int j = 1; j < rowNum +1; j++) {//第二行开始
			List<Object> col = new ArrayList<Object>();
			col.add(sheetName); //SHEET名为股票代码
			HSSFRow row = sheet.getRow(j);

			for (int i = 0; i < iiis; i++) {
				HSSFCell cell = null;
				try {
					cell = row.getCell(i);

					switch (cell.getCellType()) {
					case XSSFCell.CELL_TYPE_STRING:
						//System.out.println(i + "行" + j + " 列 is String type");
						value = cell.getStringCellValue();
						break;
					case XSSFCell.CELL_TYPE_NUMERIC:
						//System.out.println(i + "行" + j+ " 列 is Number type ; DateFormt:"+ cell.getCellStyle().getDataFormatString());
						long tmp = (long)cell.getNumericCellValue();
						value = (tmp == cell.getNumericCellValue())?tmp +"":cell.getNumericCellValue();
						break;
					case XSSFCell.CELL_TYPE_BOOLEAN:
						//System.out.println(i + "行" + j + " 列 is Boolean type");
						value = cell.getBooleanCellValue();
						break;
					case XSSFCell.CELL_TYPE_BLANK:
						//System.out.println(i + "行" + j + " 列 is Blank type");
						value = "";
						break;
					default:
						//System.out.println(i + "行" + j + " 列 is default type");
						value = cell.toString();
					}
					if (value == null || "".equals(value)) {
						continue;
					}
				} catch (Exception e) {
					System.out.println("错误信息：" + e.getMessage());
					value = "";
				}
				col.add(value);
			}
			list.add(col);
		}

		return list;
	}
	
	/**
	 * 按列读取 office 2003 excel
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private List<List<Object>> read2003ExcelColumn(File file)
			throws IOException {
		List<List<Object>> list = new LinkedList<List<Object>>();
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(
				file));

		HSSFSheet sheet = null;
		Object value = null;
		try {
			sheet = workbook.getSheetAt(SHEET_NUM);
		} catch (Exception e1) {
			MessageBox mb = new MessageBox(shell, SWT.NONE);
			mb.setText("提示");
			mb.setMessage("文件格式不支持或sheet不存在！");
			mb.open();

			return list;
		}

		int rowNum = sheet.getLastRowNum();
		String sheetName = sheet.getSheetName();
		HSSFRow row1 = sheet.getRow(0);
		int iiis = 7;
		if (row1 != null) {
			iiis = row1.getLastCellNum();
		}

		for (int i = 1; i < iiis; i++) {//第二列开始

			List<Object> col = new ArrayList<Object>();
			col.add(sheetName); //SHEET名为股票代码
			for (int j = 0; j < rowNum +1; j++) {

				HSSFRow row = sheet.getRow(j);
				
				HSSFCell cell = null;
				try {
					cell = row.getCell(i);

					switch (cell.getCellType()) {
					case XSSFCell.CELL_TYPE_STRING:
						//System.out.println(i + "行" + j + " 列 is String type");
						value = cell.getStringCellValue();
						break;
					case XSSFCell.CELL_TYPE_NUMERIC:
						//System.out.println(i + "行" + j+ " 列 is Number type ; DateFormt:"+ cell.getCellStyle().getDataFormatString());
						long tmp = (long)cell.getNumericCellValue();
						value = (tmp == cell.getNumericCellValue())?tmp +"":cell.getNumericCellValue();
						break;
					case XSSFCell.CELL_TYPE_BOOLEAN:
						//System.out.println(i + "行" + j + " 列 is Boolean type");
						value = cell.getBooleanCellValue();
						break;
					case XSSFCell.CELL_TYPE_BLANK:
						//System.out.println(i + "行" + j + " 列 is Blank type");
						value = "";
						break;
					default:
						//System.out.println(i + "行" + j + " 列 is default type");
						value = cell.toString();
					}
					if (value == null || "".equals(value)) {
						continue;
					}
				} catch (Exception e) {
					System.out.println("错误信息：" + e.getMessage());
					value = "";
				}
				col.add(value);
			}
			list.add(col);
		}

		return list;
	}
	
	/**
	 * 批量处理负债表
	 * @param filepath
	 */
	private void handleLiabilityBatch(String filepath){
		LiabilityDAO dao = new LiabilityDAO();
		boolean success = true;

		//获取所有表格文件 
		Collection<File> xlsFileCol = FileUtils.listFiles(new File(filepath), new String[]{"xls","xlsx"}, true); 
		
		for (File xlsFileColFile : xlsFileCol) { 

		      String filename = filepath+File.separatorChar+xlsFileColFile.getName();
		      int pos = xlsFileColFile.getName().indexOf(".");
		      String stockID = xlsFileColFile.getName().substring(0, pos);
	    	  try {
	    		  LogUtil.getLogger().info(stockID);
	    		  result = read2003ExcelColumn(new File(filename));
			      	if (!Common.bankList.contains(stockID)){//非银行类					

						success = dao.insertBatch(result);
						if (!success){
							t.setText("批量插入失败");
							return;
						}
			      	}else{

						success = dao.insertBatchBank(result);
						if (!success){
							t.setText("银行类批量插入失败");
							return;
						}
			      	}
		      } catch (IOException e) {

					e.printStackTrace();
			 }
	    	  
		}
		
		t.setText("负债表批量插入成功！");
	}
	
	/**
	 * 批量处理利润表
	 * @param filepath
	 */
	private void handleProfitBatch(String filepath){
		ProfitDAO dao = new ProfitDAO();
		boolean success = true;

		//获取所有表格文件 
		Collection<File> xlsFileCol = FileUtils.listFiles(new File(filepath), new String[]{"xls","xlsx"}, true); 
		
		for (File xlsFileColFile : xlsFileCol) { 

		      String filename = filepath+File.separatorChar+xlsFileColFile.getName();
		      int pos = xlsFileColFile.getName().indexOf(".");
		      String stockID = xlsFileColFile.getName().substring(0, pos);
	    	  try {
	    		  LogUtil.getLogger().info(stockID);
	    		  result = read2003ExcelColumn(new File(filename));
			      	if (!Common.bankList.contains(stockID)){//非银行类					

						success = dao.insertBatch(result);
						if (!success){
							t.setText("批量插入失败");
							return;
						}
			      	}else{

						success = dao.insertBatchBank(result);
						if (!success){
							t.setText("银行类批量插入失败");
							return;
						}
			      	}
		      } catch (IOException e) {

					e.printStackTrace();
			 }
	    	  
		}
		
		t.setText("利润表批量插入成功！");
	}
	
	/**
	 * 批量处理权益变动表
	 * @param filepath
	 */
	private void handleChangeBatch(String filepath){
		EquityChangeDAO dao = new EquityChangeDAO();
		boolean success = true;

		// 获取所有表格文件
		Collection<File> xlsFileCol = FileUtils.listFiles(new File(filepath),
				new String[] { "xls", "xlsx" }, true);

		for (File xlsFileColFile : xlsFileCol) {

			String filename = filepath + File.separatorChar
					+ xlsFileColFile.getName();
			int pos = xlsFileColFile.getName().indexOf(".");
			String stockID = xlsFileColFile.getName().substring(0, pos);
			try {
				LogUtil.getLogger().info(stockID);
				result = read2003Excel(new File(filename));

				success = dao.insertBatch(result);
				if (!success) {
					t.setText("批量插入失败");
					return;
				}

			} catch (IOException e) {

				e.printStackTrace();
			}

		}

		t.setText("权益变动表批量插入成功！");
	}
	
	/**
	 * 批量处理现金表
	 * @param filepath
	 */
	private void handleCashBatch(String filepath){
		CashDAO dao = new CashDAO();
		boolean success = true;

		//获取所有表格文件 
		Collection<File> xlsFileCol = FileUtils.listFiles(new File(filepath), new String[]{"xls","xlsx"}, true); 
		
		for (File xlsFileColFile : xlsFileCol) { 

		      String filename = filepath+File.separatorChar+xlsFileColFile.getName();
		      int pos = xlsFileColFile.getName().indexOf(".");
		      String stockID = xlsFileColFile.getName().substring(0, pos);
	    	  try {
	    		  LogUtil.getLogger().info(stockID);
	    		  result = read2003ExcelColumn(new File(filename));
			      	if (!Common.bankList.contains(stockID)){//非银行类					

						success = dao.insertBatch(result);
						if (!success){
							t.setText("批量插入失败");
							return;
						}
			      	}else{

						success = dao.insertBatchBank(result);
						if (!success){
							t.setText("银行类批量插入失败");
							return;
						}
			      	}
		      } catch (IOException e) {

					e.printStackTrace();
			 }
	    	  
		}
		
		t.setText("现金表批量插入成功！");
	}
}
