package com.idetronic.eis.scheduler;

import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;

import com.idetronic.eis.service.ConfigLocalServiceUtil;
import com.idetronic.eis.util.EisUtil;
import com.idetronic.eis.util.ReminderNotification;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.util.GetterUtil;

public class EisScheduler implements MessageListener{
	Properties props;

	@Override
	public void receive(Message message) throws MessageListenerException {
	
		int firstReminderDay;
		int secondReminderDay;
		int firstRemindarDayUntil;
		int secondReminderDayUntil;
		Calendar cal = Calendar.getInstance();
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		EisUtil.updateDataLatestPeriod();
		
		

		
		
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
			 
			
			
			
			if (dayOfMonth >= firstReminderDay  && dayOfMonth <= secondReminderDay)
			{
				LOGGER.info("EIS 1st Reminder check");
				ReminderNotification.checkFirstReminder();
			}
				
			
			if (dayOfMonth >= secondReminderDay && dayOfMonth <= secondReminderDayUntil )
			{
				LOGGER.info("EIS 2nd Reminder check");
				ReminderNotification.checkSecondReminder();
			}
			
			
			
			
			

		} catch (SystemException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (PortalException e) {
			
			e.printStackTrace();
		}


		
	}
	
	private static Log LOGGER = LogFactoryUtil.getLog(EisScheduler.class);
	
	
	

}
