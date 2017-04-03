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
		Calendar cal = Calendar.getInstance();
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		Properties props;
		
		try {
			props = ConfigLocalServiceUtil.getByKey(EisUtil.KEY_CONFIG);
			firstReminderDay = GetterUtil.getInteger(props.get(EisUtil.CONFIG_REMINDER_DAY_1ST));
			secondReminderDay = GetterUtil.getInteger(props.get(EisUtil.CONFIG_REMINDER_DAY_2ND));
			boolean firstReminderSendContinuous = GetterUtil.getBoolean(ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_REMINDER_1ST_SEND_CONTINUOUSLY),false);
			boolean secondReminderSendContinuous = GetterUtil.getBoolean(ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_REMINDER_2ND_SEND_CONTINUOUSLY),false);
			LOGGER.info("dayOfMonth= "+dayOfMonth); 
			
			if (firstReminderSendContinuous)
			{

				if (dayOfMonth >= firstReminderDay  && dayOfMonth < secondReminderDay)
				{
					LOGGER.info("first reminder,continious day="+ dayOfMonth);
					ReminderNotification.checkFirstReminder();
				}
				
			}else
			{
				if (dayOfMonth == firstReminderDay)
				{
					LOGGER.info("first reminder,Non continious day="+ dayOfMonth);

					ReminderNotification.checkFirstReminder();
				}
			}
			
			if (secondReminderSendContinuous)
			{
				if (dayOfMonth  >= secondReminderDay)
				{
					LOGGER.info("2nd conti");
					ReminderNotification.checkSecondReminder();

				}
			}else
			{
				if (dayOfMonth == secondReminderDay)
				{
					ReminderNotification.checkSecondReminder();
				}
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
