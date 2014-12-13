package org.stockii.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

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

public class DataTransferWindow {
	private Display display;
	private Shell shell;
	protected Text t;
	protected Table ta;
	private int SHEET_NUM = 0;

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
						//getExcel(t.getText().trim());
						read2003Excel(new File(t.getText().trim()));
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
	 * 读取 office 2003 excel
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private List<List<Object>> read2003Excel(File file)
			throws IOException {
		List<List<Object>> list = new LinkedList<List<Object>>();
		HSSFWorkbook hwb = new HSSFWorkbook(new FileInputStream(file));
		ta.removeAll();
		
		//打开SHEET
		HSSFSheet sheet = null;
		try {
			sheet = hwb.getSheetAt(SHEET_NUM);
		} catch (Exception e1) {
			MessageBox mb = new MessageBox(shell, SWT.NONE);
			mb.setText("提示");
			mb.setMessage("文件格式不支持或sheet不存在！");
			mb.open();

			return null;
		}
		
		//设置列数
		HSSFRow row1 = sheet.getRow(0);
		int iiis = 7;
		if (row1 != null) {
			iiis = row1.getLastCellNum() - row1.getFirstCellNum() + 1;
		}

		for (int i = 0; i < iiis; i++) {
			TableColumn t = new TableColumn(ta, SWT.NONE);
			t.setWidth(1000 / iiis);
		}
		
		Object value = null;
		HSSFRow row = null;
		HSSFCell cell = null;
		int counter = 0;
		for (int i = sheet.getFirstRowNum(); counter < sheet
				.getPhysicalNumberOfRows(); i++) {
			//每一行
			row = sheet.getRow(i);			
			if (row == null) {
				continue;
			} else {
				counter++;
			}
			
			TableItem ti = new TableItem(ta, SWT.NONE);
			String[] ss = new String[iiis];
			
			List<Object> linked = new LinkedList<Object>();
			for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
				cell = row.getCell(j);
				if (cell == null) {
					continue;
				}
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
				System.out.println(value);
				ss[j] = (String) value;
				linked.add(value);
			}
			ti.setText(ss);
			list.add(linked);
		}
		return list;
	}
}
