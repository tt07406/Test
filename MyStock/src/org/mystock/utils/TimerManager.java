/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：TimerManager
 * 
 * 创建日期：2014-09-30
 */
package org.mystock.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.mystock.service.impl.NewsInfoServiceImpl;
import org.mystock.service.impl.NewsTypeServiceImpl;
import org.mystock.service.impl.TableServiceImpl;

/**
 * 定时工具类
 * @author tt
 *
 */
public class TimerManager {

	//时间间隔
	 private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;
	 public static boolean isValid = false;//开关参数
	 
	public TimerManager() {
		Calendar calendar = Calendar.getInstance();

		/*** 定制每日2:00执行方法 ***/

		calendar.set(Calendar.HOUR_OF_DAY, 2);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		Date date = calendar.getTime(); // 第一次执行定时任务的时间

		// 如果第一次执行定时任务的时间 小于 当前的时间
		// 此时要在 第一次执行定时任务的时间 加一天，以便此任务在下个时间点执行。如果不加一天，任务会立即执行。
		if (date.before(new Date())) {
			date = this.addDay(date, 1);
		}

		Timer timer = new Timer();

		NFDFlightDataTimerTask task = new NFDFlightDataTimerTask();
		// 安排指定的任务在指定的时间开始进行重复的固定延迟执行。
		timer.schedule(task, date, PERIOD_DAY);
	}

	// 增加或减少天数
	public Date addDay(Date date, int num) {
		Calendar startDT = Calendar.getInstance();
		startDT.setTime(date);
		startDT.add(Calendar.DAY_OF_MONTH, num);
		return startDT.getTime();
	}
	 
	 public class NFDFlightDataTimerTask extends TimerTask {
		 NewsTypeServiceImpl typeService = new NewsTypeServiceImpl();
		 NewsInfoServiceImpl service = new NewsInfoServiceImpl();
		 TableServiceImpl tableService = new TableServiceImpl();

		 private final Logger log = Logger.getLogger(NFDFlightDataTimerTask.class);

		 @Override
		 public void run() {
		  try {
		      if (TimerManager.isValid){
					Configuration cfg = new AnnotationConfiguration();
					SessionFactory sf = cfg.configure(
							"hibernate_backup.cfg.xml").buildSessionFactory();
					service.backup(sf);
					typeService.backup(sf);
					tableService.backup(sf);
					if (sf != null) {
						sf.close();
					}
		      }
		   
		  } catch (Exception e) {
		   log.info("-------------解析信息发生异常--------------");
		  }
		 }
	 }
}
