package com.idetronic.eis.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.idetronic.eis.model.UserLibrary;
import com.idetronic.eis.service.ConfigLocalServiceUtil;
import com.idetronic.eis.service.UserLibraryLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.notifications.NotificationEvent;
import com.liferay.portal.kernel.notifications.NotificationEventFactoryUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserNotificationDeliveryConstants;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;

public class ReminderNotification {
    public static final String PORTLET_ID = "eisadmin_WAR_Eisportlet";

	
	public static void checkFirstReminder() throws SystemException, PortalException
	{
		Calendar cal = Calendar.getInstance();
		
		String period = EisUtil.getPreviousPeriod();
		
		Map missingDataMap = getUserMissingData(period);
		
		
		
		Iterator entries = missingDataMap.entrySet().iterator();
		
		String firstNotificationBody = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_EMAIL_FIRST_NOTIFICATION_BODY);
		String firstNotificationSubject = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_EMAIL_FIRST_NOTIFICATION_SUBJECT);
		String fromAddress = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_EMAIL_FROM_ADDRESS);
		String fromName = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_EMAIL_FROM_NAME);
		
		while (entries.hasNext())
		{
			Map.Entry entry = (Map.Entry) entries.next();
			
			long userId = (Long) entry.getKey();
			ArrayList value = (ArrayList) entry.getValue();
			
			User user = UserLocalServiceUtil.getUser(userId);
			String body = replaceBodyTemplate(firstNotificationBody,user,value,period);
			String subject = replaceSubjectTemplate(firstNotificationSubject,user,period);
			
			
			try {
				InternetAddress from = new InternetAddress(fromAddress,fromName);
				InternetAddress toAddress = new InternetAddress(user.getEmailAddress(),user.getFullName());
				
				MailMessage mailMessage = new MailMessage();
				mailMessage.setTo(toAddress);
				mailMessage.setFrom(from);
				mailMessage.setSubject(subject);
				mailMessage.setBody(body);
				mailMessage.setHTMLFormat(true);
				MailServiceUtil.sendEmail(mailMessage);
				LOGGER.info("EIS 1st Reminder " + user.getEmailAddress());
				//UserNotificationEventLocalServiceUtil.addUserNotificationEvent(userId, notificationEvent)
				
			} catch (Exception e) {
				LOGGER.error("Error sending EIS 1st reminder");
				e.printStackTrace();
			} 
			
			
			
		}
		
		
	}
	public static void sendNotification(long userId) 
	{
		
		JSONObject notificationEventJSONObject =
				JSONFactoryUtil.createJSONObject();
		
		NotificationEvent notificationEvent =
				NotificationEventFactoryUtil.createNotificationEvent(
					System.currentTimeMillis(), PORTLET_ID,
					notificationEventJSONObject);

			notificationEvent.setDeliveryRequired(0);
			notificationEvent.setDeliverBy(
				UserNotificationDeliveryConstants.TYPE_WEBSITE);
			
			try {
				UserNotificationEventLocalServiceUtil.addUserNotificationEvent(userId, notificationEvent);
			} catch (PortalException e) {
				
				e.printStackTrace();
			} catch (SystemException e) {
			
				e.printStackTrace();
			}
		
	}
	
	public static void checkSecondReminder() throws SystemException, PortalException
	{
		String period = EisUtil.getPreviousPeriod();
		

		Map missingDataMap = getUserMissingData(period);
		
		Iterator entries = missingDataMap.entrySet().iterator();
		
		String notificationBody = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_EMAIL_SECOND_NOTIFICATION_BODY);
		String notificationSubject = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_EMAIL_SECOND_NOTIFICATION_SUBJECT);
		String fromAddress = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_EMAIL_FROM_ADDRESS);
		String fromName = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_EMAIL_FROM_NAME);
		
		while (entries.hasNext())
		{
			Map.Entry entry = (Map.Entry) entries.next();
			
			long userId = (Long) entry.getKey();
			
			ArrayList value = (ArrayList) entry.getValue();
			
			User user = UserLocalServiceUtil.getUser(userId);
			String body = replaceBodyTemplate(notificationBody,user,value,period);
			String subject = replaceSubjectTemplate(notificationSubject,user,period);

			
			
			try {
				InternetAddress from = new InternetAddress(fromAddress,fromName);
				InternetAddress toAddress = new InternetAddress(user.getEmailAddress(),user.getFullName());
				
				MailMessage mailMessage = new MailMessage();
				mailMessage.setTo(toAddress);
				mailMessage.setFrom(from);
				mailMessage.setSubject(subject);
				mailMessage.setBody(body);
				mailMessage.setHTMLFormat(true);
				MailServiceUtil.sendEmail(mailMessage);
				//LOGGER.info("EIS 2nd reminder: " + user.getEmailAddress());
				
			} catch (Exception e) {
				LOGGER.error("Error sending EIS 2nd reminder");

				e.printStackTrace();
			} 
			
			
			
		}
		
		
	}
	
	private static Map getUserMissingData(String period) throws SystemException, PortalException
	{
		List<UserLibrary> userLibraries = UserLibraryLocalServiceUtil.getUserLibraries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		Map userMap = new HashMap();
		
		
		for (UserLibrary userLibrary : userLibraries)
		{
			User user = UserLocalServiceUtil.getUser(userLibrary.getUserId());
			
			if (!userMap.containsKey(userLibrary.getUserId()))
			{
				ArrayList missingData = EisUtil.getMissingData(user.getUserId(), period, user.getLocale(), false,0,EisUtil.DATA_ALL_DATA);
				userMap.put(userLibrary.getUserId(), missingData);
				
			}
		}
		
		return userMap;
	}
	
	private static String replaceSubjectTemplate(String subject,User user,String period) throws SystemException, PortalException
	{
		//Company company = CompanyLocalServiceUtil.getCompanyByVirtualHost("km.ptar.uitm.edu.my");
		Company company = CompanyLocalServiceUtil.getCompanyByWebId(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));


		String portalURL = StringPool.BLANK;
		if (Validator.isNotNull(company))
		{
			portalURL = company.getVirtualHostname();
		}
		
		
		String toAddress =  user.getEmailAddress();// StringPool.BLANK;
		String toName = user.getFullName();// StringPool.BLANK;
		String dataType = StringPool.BLANK;
		String userScreenName = user.getScreenName();//StringPool.BLANK;
		
		String fromAddress = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_EMAIL_FROM_ADDRESS);
		String fromName = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_EMAIL_FROM_NAME);
		String periodName = EisUtil.getPeriodString(period);

		subject = StringUtil.replace(subject, new String[] 
			{"[$FROM_ADDRESS$]",
			"[$FROM_NAME$]",
			"[$PORTAL_URL$]",
			"[$TO_ADDRESS$]",
			"[$TO_NAME$]",
			"[$DATA_TYPE$]",
			"[$USER_SCREENNAME$]",
			"[$PERIOD$]"}, 
			new String[] {
			fromAddress, 
			fromName ,
			portalURL , 
			toAddress ,
			toName,
			dataType,
			userScreenName,
			periodName
			}
		);
			
		return subject;
	}
	
	private static String replaceBodyTemplate(String template,User user,ArrayList datas,String period) throws SystemException, PortalException
	{
		
		//Company company = CompanyLocalServiceUtil.getCompanyByVirtualHost("km.ptar.uitm.edu.my");
		Company company = CompanyLocalServiceUtil.getCompanyByWebId(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));


		String portalURL = StringPool.BLANK;
		if (Validator.isNotNull(company))
		{
			//portalURL = company.getVirtualHostname();
		}
	
		
		String toAddress =  user.getEmailAddress();// StringPool.BLANK;
		String toName = user.getFullName();// StringPool.BLANK;
		String dataType = StringPool.BLANK;
		String userScreenName = user.getScreenName();//StringPool.BLANK;
		
		String fromAddress = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_EMAIL_FROM_ADDRESS);
		String fromName = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.KEY_CONFIG_EMAIL_FROM_NAME);
		
		StringBuilder sb = new StringBuilder();
		
		
		for (Object obj : datas)
		{
			HashMap<String,String> data = (HashMap<String,String>) obj;
			String libraryName = data.get("libraryName").toString();
			String dataName = data.get("dataName").toString();
			
			sb.append("- ");
			sb.append(libraryName);
			sb.append(" : ");
			sb.append(dataName);
			sb.append("<br>");
			
			
		}
		
		dataType = sb.toString();
		String periodName = EisUtil.getPeriodString(period);
		template = StringUtil.replace(template, new String[] 
				{"[$FROM_ADDRESS$]",
				"[$FROM_NAME$]",
				"[$PORTAL_URL$]",
				"[$TO_ADDRESS$]",
				"[$TO_NAME$]",
				"[$DATA_TYPE$]",
				"[$USER_SCREENNAME$]",
				"[$PERIOD$]"}, 
				new String[] {
				fromAddress, 
				fromName ,
				portalURL , 
				toAddress ,
				toName,
				dataType,
				userScreenName,
				periodName
			}
		);
		
		
		return template;
	}
	
	private static Log LOGGER = LogFactoryUtil.getLog(ReminderNotification.class);


}
