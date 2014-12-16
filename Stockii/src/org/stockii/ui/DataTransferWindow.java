package org.stockii.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
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
import org.stockii.dao.LiabilityDAO;

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
		btn.setBounds(800, 15, 70, 20);
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
						rowNum.setText("");
						colNum.setText("");
						//getExcel(t.getText().trim());
						result = read2003ExcelColumn(new File(t.getText().trim()));
						if (result != null && result.size() > 0){
							rowNum.setText(result.size()+"");
							colNum.setText(result.get(0).size()+"");
						}
						
					} catch (FileNotFoundException e1) {

						e1.printStackTrace();
					} catch (IOException e1) {

						e1.printStackTrace();
					}
				}
			}
		});

		Button last = new Button(shell, SWT.NONE);
		last.setBounds(600, 100, 70, 20);
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
		next.setBounds(700, 100, 70, 20);
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
						ss[i] = (int) (cell.getNumericCellValue()) + "";
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

					DecimalFormat df = new DecimalFormat("0");// 格式化 number String 字符
					SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
					DecimalFormat nf = new DecimalFormat("0.00");// 格式化数字
					switch (cell.getCellType()) {
					case XSSFCell.CELL_TYPE_STRING:
						System.out.println(i + "行" + j + " 列 is String type");
						value = cell.getStringCellValue();
						break;
					case XSSFCell.CELL_TYPE_NUMERIC:
						System.out.println(i + "行" + j
								+ " 列 is Number type ; DateFormt:"
								+ cell.getCellStyle().getDataFormatString());
						if ("@".equals(cell.getCellStyle().getDataFormatString())) {
							value = df.format(cell.getNumericCellValue());
						} else if ("General".equals(cell.getCellStyle()
								.getDataFormatString())) {
							value = nf.format(cell.getNumericCellValue());
						} else {
							value = sdf.format(HSSFDateUtil.getJavaDate(cell
									.getNumericCellValue()));
						}
						break;
					case XSSFCell.CELL_TYPE_BOOLEAN:
						System.out.println(i + "行" + j + " 列 is Boolean type");
						value = cell.getBooleanCellValue();
						break;
					case XSSFCell.CELL_TYPE_BLANK:
						System.out.println(i + "行" + j + " 列 is Blank type");
						value = "";
						break;
					default:
						System.out.println(i + "行" + j + " 列 is default type");
						value = cell.toString();
					}
					if (value == null || "".equals(value)) {
						continue;
					}
				} catch (Exception e) {
					System.out.println("错误信息：" + e.getMessage());
				}
				col.add(value);
			}
			list.add(col);
		}

		return list;
	}
	
	private void handleLiabilityBatch(String filepath){
		LiabilityDAO dao = new LiabilityDAO();

		//获取所有表格文件 
		Collection<File> xlsFileCol = FileUtils.listFiles(new File(filepath), new String[]{"xls","xlsx"}, true); 

		for (File xlsFileColFile : xlsFileCol) { 
		      String filename = xlsFileColFile.getName();
		      if (!Common.bankList.contains(filename)){
		    	  long start = dao.getCount() + 1;
		    	  dao.insertBatch(result, start);
		      }
		}
	}
}
