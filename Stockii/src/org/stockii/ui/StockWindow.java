package org.stockii.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.stockii.common.HttpClientUtil;
import org.stockii.model.Stock;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class StockWindow {
	private Display display;
	private TableViewer tableViewerA;
	private TableViewer tableViewerB;
	private TableViewer tableViewerC;
	private DateTime startDate;
	private DateTime endDate;
	private Text text;
	private ProgressBar progressBar;
	boolean stop = false;//是否结束进度条
	
	public static final String ID = "股票代码";
	public static final String NAME = "股票名称";
	//public static final String DATE = "上市日期";
	public static final String START = "开始时间";
	public static final String STARTVALUE = "开始时间值";
	public static final String END = "结束时间";
	public static final String ENDVALUE = "结束时间值";
	public static final String AVG = "平均值";
	public static final String NUM = "跨区数";
	
	public static final String [] PROS = {ID,NAME,START,STARTVALUE,END,ENDVALUE,AVG,NUM};
	
	private List<Stock> stockListA = new ArrayList<Stock>();//股票列表
	private List<Stock> stockListB = new ArrayList<Stock>();//股票列表
	private List<Stock> stockListC = new ArrayList<Stock>();//股票列表
	
	public StockWindow(){
		display = Display.getDefault();
        Shell shell = new Shell(display);
        shell.setLayout(new GridLayout());
        shell.setSize(881, 508);
        shell.setText("均价生成器");

        // 按钮面板
        final Composite compControl1 = new Composite(shell, SWT.NONE);
        compControl1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false));
        final RowLayout rowLayout = new RowLayout();
        rowLayout.justify = true;
        compControl1.setLayout(rowLayout);
        
        Label label = new Label(compControl1, SWT.NONE);
		label.setBounds(0, 13, 44, 17);
		label.setText("\u7ED3\u679C\uFF1A");
		
		text = new Text(compControl1, SWT.BORDER);
		text.setLayoutData(new RowData(84, SWT.DEFAULT));
		text.setBounds(50, 10, 267, 23);
		
		Button button = new Button(compControl1, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
	
			@Override
			public void widgetSelected(SelectionEvent e) {
				progressBar.setSelection(10);
				new BackgroudThread(display,progressBar,progressBar.getMinimum(),progressBar.getMaximum()).start();
				
				Map<String,String> param = new HashMap<String,String>();

				
				param.put("start", startDate.getYear()+"-"+getDate(startDate.getMonth()+1)+"-"+getDate(startDate.getDay()));
				param.put("end", endDate.getYear()+"-"+getDate(endDate.getMonth()+1)+"-"+getDate(endDate.getDay()));
				String result = HttpClientUtil.sendPostRequest("http://localhost:8080/StockService/services/avgPrice/selectStocks", param, null, null);
				text.setText(result);
							
				progressBar.setSelection(progressBar.getMaximum());//完全进度
			}
		});
		button.setBounds(344, 10, 80, 27);
		button.setText("开始");
		
		//进度条
		progressBar = new ProgressBar(compControl1, SWT.SMOOTH);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
        
        final Composite compControl2 = new Composite(shell, SWT.NONE);
        compControl2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false));
        final RowLayout rowLayout2 = new RowLayout();
        rowLayout2.justify = true;
        compControl2.setLayout(rowLayout2);
        
        Label label_1 = new Label(compControl2, SWT.NONE);
		label_1.setBounds(0, 53, 61, 17);
		label_1.setText("\u8D77\u59CB\u65F6\u95F4\uFF1A");
		
		startDate = new DateTime(compControl2, SWT.DATE  |  SWT.CALENDAR);
		startDate.setBounds(58, 53, 93, 24);
		
		Label label_2 = new Label(compControl2, SWT.NONE);
		label_2.setBounds(157, 53, 61, 17);
		label_2.setText("\u7ED3\u675F\u65F6\u95F4\uFF1A");
		
		endDate = new DateTime(compControl2, SWT.DATE  |  SWT.CALENDAR);
		endDate.setBounds(224, 53, 93, 24);
	
		Button avgPriceButton = new Button(compControl2, SWT.NONE);
		avgPriceButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				progressBar.setSelection(10);
				new BackgroudThread(display,progressBar,progressBar.getMinimum(),progressBar.getMaximum()).start();
				
				Map<String,String> param = new HashMap<String,String>();

				
				param.put("start", startDate.getYear()+"-"+getDate(startDate.getMonth()+1)+"-"+getDate(startDate.getDay()));
				param.put("end", endDate.getYear()+"-"+getDate(endDate.getMonth()+1)+"-"+getDate(endDate.getDay()));
				String result = HttpClientUtil.sendPostRequest("http://localhost:8080/StockService/services/avgPrice/selectStocks", param, null, null);
				text.setText(result);
				
				if (result.equals("true")){
					Thread thread = new Thread(new Runnable(){
					    public void run(){
					    	String result = HttpClientUtil.sendGetRequest("http://localhost:8080/StockService/services/avgPrice/findA", "UTF-8");
							
							JSONParser parser=new JSONParser();  
							JSONObject demoJson;
							try {
								demoJson = (JSONObject) parser.parse(result);
								JSONArray array = (JSONArray)demoJson.get("avgprice");
								
								stockListA.clear();
								for (int i=0; i<array.size();++i){
									JSONObject map = (JSONObject)array.get(i);
									String id = (String) map.get("stock_id");
									String name = (String) map.get("stock_name");
									String start = (String)map.get("start_date");
									String startValue = (String) map.get("start_price");
									String end = (String) map.get("end_date");
									String endValue = (String) map.get("end_price");
									String avg = (String) map.get("avg_value");
									String num = (String) map.get("section_num");
									stockListA.add(new Stock(id,name,start,startValue,end,endValue,avg,num));
								}
								
								display.asyncExec(new Runnable(){

									@Override
									public void run() {
										tableViewerA.refresh();
									}
									
								});
								
								
							} catch (ParseException re) {
								display.asyncExec(new Runnable(){

									@Override
									public void run() {
										text.setText("ParseException");
										stop = true;//结束进度条
									}
									
								});
								
								
							}
							
							result = HttpClientUtil.sendGetRequest("http://localhost:8080/StockService/services/avgPrice/findB", "UTF-8");
							try {
								demoJson = (JSONObject) parser.parse(result);
								JSONArray array = (JSONArray)demoJson.get("avgprice");
								
								stockListB.clear();
								for (int i=0; i<array.size();++i){
									JSONObject map = (JSONObject)array.get(i);
									String id = (String) map.get("stock_id");
									String name = (String) map.get("stock_name");
									String start = (String)map.get("start_date");
									String startValue = (String) map.get("start_price");
									String end = (String) map.get("end_date");
									String endValue = (String) map.get("end_price");
									String avg = (String) map.get("avg_value");
									String num = (String) map.get("section_num");
									stockListB.add(new Stock(id,name,start,startValue,end,endValue,avg,num));
								}
								
								display.asyncExec(new Runnable(){

									@Override
									public void run() {
										tableViewerB.refresh();
									}
									
								});
								
								
							} catch (ParseException re) {
								display.asyncExec(new Runnable(){

									@Override
									public void run() {
										text.setText("ParseException");
										stop = true;//结束进度条
									}
									
								});								
								
							}
						
							result = HttpClientUtil.sendGetRequest("http://localhost:8080/StockService/services/avgPrice/findC", "UTF-8");
							
							try {
								demoJson = (JSONObject) parser.parse(result);
								JSONArray array = (JSONArray)demoJson.get("avgprice");
								
								stockListC.clear();
								for (int i=0; i<array.size();++i){
									JSONObject map = (JSONObject)array.get(i);
									String id = (String) map.get("stock_id");
									String name = (String) map.get("stock_name");
									String start = (String)map.get("start_date");
									String startValue = (String) map.get("start_price");
									String end = (String) map.get("end_date");
									String endValue = (String) map.get("end_price");
									String avg = (String) map.get("avg_value");
									String num = (String) map.get("section_num");
									stockListC.add(new Stock(id,name,start,startValue,end,endValue,avg,num));
								}
								
								display.asyncExec(new Runnable(){

									@Override
									public void run() {
										tableViewerC.refresh();
										progressBar.setSelection(progressBar.getMaximum());//完全进度
										text.setText("获取数据成功");
									}
									
								});
								
								
							} catch (ParseException re) {
								display.asyncExec(new Runnable(){

									@Override
									public void run() {
										text.setText("ParseException");
										stop = true;//结束进度条
									}
									
								});						
								
							}
					    }
					});
					thread.start();

				}else{
					progressBar.setSelection(progressBar.getMinimum());
				}

			}
		});
		avgPriceButton.setBounds(344, 53, 80, 27);
		avgPriceButton.setText("\u751F\u6210\u5747\u4EF7\u8868");
		
		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		GridData gd_tabFolder = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_tabFolder.widthHint = 854;
		gd_tabFolder.heightHint = 365;
		tabFolder.setLayoutData(gd_tabFolder);
		
		TabItem tbtma = new TabItem(tabFolder, SWT.NONE);
		tbtma.setText("\u5747\u4EF7A");
		
		TabItem tbtmb = new TabItem(tabFolder, SWT.NONE);
		tbtmb.setText("\u5747\u4EF7B");
		
		TabItem tbtmc = new TabItem(tabFolder, SWT.NONE);
		tbtmc.setText("\u5747\u4EF7C");
	
		
		// 表格面板
        Composite compositeA = new Composite(tabFolder, SWT.NONE);

        compositeA.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        compositeA.setLayout(new FillLayout());
        
        // 调用自定义方法生成表格
        tableViewerA = createTableViewer(compositeA);
        tableViewerA.setInput(stockListA);
        
        tbtma.setControl(compositeA);
        
     // 表格面板
        Composite compositeB = new Composite(tabFolder, SWT.NONE);

        compositeB.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        compositeB.setLayout(new FillLayout());
        
        // 调用自定义方法生成表格
        tableViewerB = createTableViewer(compositeB);
        tableViewerB.setInput(stockListB);
        
        tbtmb.setControl(compositeB);
        
        // 表格面板
        Composite compositeC = new Composite(tabFolder, SWT.NONE);

        compositeC.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        compositeC.setLayout(new FillLayout());
        
        // 调用自定义方法生成表格
        tableViewerC = createTableViewer(compositeC);
        tableViewerC.setInput(stockListC);
        
        tbtmc.setControl(compositeC);
        
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
	}

	 /** *//**
     * 生成TableViewer对象
     */
    private TableViewer createTableViewer(Composite compTableViewer) {
        // 第一步: 定义一个TableViewer对象, 并设置相应式样
    	TableViewer tableViewer = new TableViewer(compTableViewer, SWT.BORDER
                | SWT.MULTI | SWT.FULL_SELECTION);

        // 第二步: 通过TableViewer中的Table对其布局
    	Table  table = tableViewer.getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
       // table.setBounds(10, 97, 500, 330);
        TableLayout tableLayout = new TableLayout();
        table.setLayout(tableLayout);

        // 第三步: 建立TableViewer中的列
        tableLayout.addColumnData(new ColumnPixelData(94));
        new TableColumn(table, SWT.NONE).setText(ID);
        tableLayout.addColumnData(new ColumnPixelData(100));
        new TableColumn(table, SWT.NONE).setText(NAME);
        tableLayout.addColumnData(new ColumnPixelData(150));
        new TableColumn(table, SWT.NONE).setText(START);
        tableLayout.addColumnData(new ColumnPixelData(100));
        new TableColumn(table, SWT.NONE).setText(STARTVALUE);
        tableLayout.addColumnData(new ColumnPixelData(150));
        new TableColumn(table, SWT.NONE).setText(END);
        tableLayout.addColumnData(new ColumnPixelData(100));
        new TableColumn(table, SWT.NONE).setText(ENDVALUE);
        tableLayout.addColumnData(new ColumnPixelData(100));
        new TableColumn(table, SWT.NONE).setText(AVG);
        tableLayout.addColumnData(new ColumnPixelData(50));
        new TableColumn(table, SWT.NONE).setText(NUM);

        // 第四步: 设置内容器
        tableViewer.setContentProvider(new StockContentProvider());

        // 第五步: 设置标签器
        tableViewer.setLabelProvider(new StockLabelProvider());

        // 第六步: 用数据充实表格
		//tableViewer.setInput(stockList);

        // 返回
        return tableViewer;
    }
	
    /**
     * 后台运行线程，模拟进度条显示
     * @author tt
     *
     */
    class BackgroudThread extends Thread{
    	private Display display;
    	private ProgressBar progressBar;
    	private int min = 0;
    	private int max = 100;
    	   	
		public BackgroudThread(Display display, ProgressBar progressBar,
				int min, int max) {
			super();
			this.display = display;
			this.progressBar = progressBar;
			this.min = min;
			this.max = max;
		}



		public void run(){
			for (int i = min ; !stop && i < max ; ++i){
				try {
					Thread.sleep(500);//每0.5秒更新进度条一次
				}catch (Exception e){
					e.printStackTrace();
				}

				display.asyncExec(new Runnable(){

					@Override
					public void run() {
						if (progressBar.isDisposed()){
							return ;
						}
						progressBar.setSelection(progressBar.getSelection()+1);
					}
					
				});
			}
		}
    }
    
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		new StockWindow();
	}
	
	public String getDate(int time){
		if (time >9){
			return ""+time;
		}else{
			return "0"+time;
		}
	}
}
