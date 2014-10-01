/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������TimerManager
 * 
 * �������ڣ�2014-09-30
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
 * ��ʱ������
 * @author tt
 *
 */
public class TimerManager {

	//ʱ����
	 private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;
	 public static boolean isValid = false;//���ز���
	 
	public TimerManager() {
		Calendar calendar = Calendar.getInstance();

		/*** ����ÿ��2:00ִ�з��� ***/

		calendar.set(Calendar.HOUR_OF_DAY, 2);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		Date date = calendar.getTime(); // ��һ��ִ�ж�ʱ�����ʱ��

		// �����һ��ִ�ж�ʱ�����ʱ�� С�� ��ǰ��ʱ��
		// ��ʱҪ�� ��һ��ִ�ж�ʱ�����ʱ�� ��һ�죬�Ա���������¸�ʱ���ִ�С��������һ�죬���������ִ�С�
		if (date.before(new Date())) {
			date = this.addDay(date, 1);
		}

		Timer timer = new Timer();

		NFDFlightDataTimerTask task = new NFDFlightDataTimerTask();
		// ����ָ����������ָ����ʱ�俪ʼ�����ظ��Ĺ̶��ӳ�ִ�С�
		timer.schedule(task, date, PERIOD_DAY);
	}

	// ���ӻ��������
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
		   log.info("-------------������Ϣ�����쳣--------------");
		  }
		 }
	 }
}
