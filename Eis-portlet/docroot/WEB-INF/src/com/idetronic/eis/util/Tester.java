package com.idetronic.eis.util;

import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;

import com.idetronic.eis.service.ConfigLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

public class Tester {
	
	
	public static void testNotification()
	{
		int firstReminderDay;
		int secondReminderDay;
		int firstRemindarDayUntil;
		int secondReminderDayUntil;
		Calendar cal = Calendar.getInstance();
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		Properties props;
		
		
		

		
		
		try {
			boolean notificationEnabled = GetterUtil.getBoolean(ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_ENABLE_EMAIL_NOTIFICATION),false);
			if (!notificationEnabled)
			{
				return;
			}
			
			props = ConfigLocalServiceUtil.getByKey(EisUtil.KEY_CONFIG);
			int dataDueDay = GetterUtil.getInteger(props.get(EisUtil.CONFIG_DATA_DUE_DAY));
			
			firstReminderDay = GetterUtil.getInteger(ConfigLocalServiceUtil.getByKeyAsString(EisUtil.CONFIG_REMINDER_DAY_1ST));
			secondReminderDay = GetterUtil.getInteger(ConfigLocalServiceUtil.getByKeyAsString(EisUtil.CONFIG_REMINDER_DAY_2ND));
			firstRemindarDayUntil = GetterUtil.getInteger(ConfigLocalServiceUtil.getByKeyAsString(EisUtil.CONFIG_REMINDER_DAY_1ST_UNTIL));
			secondReminderDayUntil = GetterUtil.getInteger(ConfigLocalServiceUtil.getByKeyAsString(EisUtil.CONFIG_REMINDER_DAY_2ND_UNTIL));
			
			//boolean firstReminderSendContinuous = GetterUtil.getBoolean(ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_REMINDER_1ST_SEND_CONTINUOUSLY),false);
			//boolean secondReminderSendContinuous = GetterUtil.getBoolean(ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_REMINDER_2ND_SEND_CONTINUOUSLY),false);
			 
			
			
			
			if (dayOfMonth >= firstReminderDay  && dayOfMonth <= firstRemindarDayUntil)
			{
				LOGGER.info("EIS 1st Reminder check");
				ReminderNotification.checkFirstReminder();
			} else
			{
				LOGGER.info("exclude first notification");
			}
				
			
			if (dayOfMonth >= secondReminderDay && dayOfMonth <= secondReminderDayUntil )
			{
				LOGGER.info("EIS 2nd Reminder check");
				ReminderNotification.checkSecondReminder();
			} else
			{
				LOGGER.info("exclude 2md notification");
			}
			
			
			
			
			

		} catch (SystemException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (PortalException e) {
			
			e.printStackTrace();
		}	

		
	

	
	}

	private static Log LOGGER = LogFactoryUtil.getLog(Tester.class);

}
