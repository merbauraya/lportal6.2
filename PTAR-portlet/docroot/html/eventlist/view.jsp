<%@page import="com.liferay.portal.kernel.util.FastDateFormatConstants"%>
<%@page import="com.liferay.portal.kernel.util.DateFormatFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portlet.calendar.service.CalEventLocalServiceUtil"%>
<%@page import="com.liferay.portlet.calendar.service.CalEventLocalServiceWrapper"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="java.text.Format"%>
<%@page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Time"%>
<%@page import="com.liferay.portal.kernel.util.TimeZoneUtil"%>


<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.Comparator"%>
<%@page import="com.liferay.portlet.calendar.model.CalEvent"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portlet.calendar.model.CalEventConstants"%>
<%@page import="com.liferay.portlet.calendar.service.CalEventLocalServiceUtil"%>
<%@page import="com.liferay.calendar.service.CalendarBookingLocalServiceUtil" %>


<%@ include file="/html/eventlist/init-event.jsp" %>



This is the <b>Event List</b> portlet in View mode.
<%
	
	int eventCount = 0;
	long parentCalendarBookingId = 0;
	if (!allCalendars) {
		calendars = new ArrayList<Calendar>();
		
		for (int i = 0; i < calendarIds.length; i++) {
			calendars.add(CalendarLocalServiceUtil.getCalendar(calendarIds[i])); 
			eventCount += CalendarBookingLocalServiceUtil.getCalendarBookingsCount(calendarIds[i], parentCalendarBookingId);
		}
	}
	else {
		calendarIds = new long[calendars.size()];
		for (int i = 0; i < calendars.size(); i++) {
			Calendar calendar = calendars.get(i);
			calendarIds[i] = calendar.getCalendarId();
			eventCount += CalendarBookingLocalServiceUtil.getCalendarBookingsCount(calendarIds[i], parentCalendarBookingId);

		}
	}
	

	//int count = CalendarBookingServiceUtil.searchCount(companyId, groupIds, calendarIds, calendarResourceIds, parentCalendarBookingId, keywords, startTime, endTime, recurring, statuses)
	
			
	
	

	int daysToProcess = 365;
	try{
		daysToProcess=Integer.parseInt(nbDays);
	}
	catch(Exception e){};

	int nbToDisplay = 5;
	try{
		nbToDisplay=Integer.parseInt(nbEvents);
	}
	catch(Exception e){}
	
	int totalEvents = 0;
	int cptNbDisplayed = 0;
	List<Calendar> groupCalendars = Collections.emptyList();   
	
	
 	
	
	
	Calendar defaultCalendar = null;

	for (Calendar groupCalendar : groupCalendars) {
		if (groupCalendar.isDefaultCalendar()) {
			defaultCalendar = groupCalendar;
		}
	}
	
	
	try {  
	
		
		if (eventCount > 0){
			ArrayList<String> idEvents = new ArrayList<String>();
			Comparator<CalEvent> comparator = new Comparator<CalEvent>() {

				@Override
				public int compare(CalEvent c1, CalEvent c2) {

					return c1.getStartDate().compareTo(c2.getStartDate());
				}
			};
			
			SimpleDateFormat dfMonth = new SimpleDateFormat("MMM",locale);
			SimpleDateFormat dfDay = new SimpleDateFormat("dd",locale);
			
			Format dateFormatDate = FastDateFormatFactoryUtil.getDate(locale);
			Format dft = FastDateFormatFactoryUtil.getDateTime(FastDateFormatConstants.LONG, FastDateFormatConstants.SHORT, locale, timeZone);
			Format df = FastDateFormatFactoryUtil.getDate(FastDateFormatConstants.LONG, locale, timeZone);			
			//DateFormat dateFormatISO8601 = DateUtil.getISO8601Format();
		
			try{
				nbToDisplay=Integer.parseInt(nbEvents);
			}
			catch(Exception e){}
		
			GregorianCalendar nextOccur;
			GregorianCalendar gregCal = new GregorianCalendar();
			gregCal.set(java.util.Calendar.HOUR_OF_DAY, 0); 
			gregCal.set(java.util.Calendar.MINUTE, 0);
			gregCal.set(java.util.Calendar.SECOND, 0);
		
			List<CalEvent> lstEvents;
			Date date;
			for (int i=0; i<daysToProcess; i++){
				lstEvents = CalendarBookingLocalServiceUtil.search(themeDisplay.getCompanyId(),  
						groupIds, calendarIds, calendarResourceIds, parentCalendarBookingId, 
						null, gregCal, null, 
						null, WorkflowConstants.STATUS_APPROVED, start, end, orderByComparator) 
						//.getEvents(scopeGroupId, gregCal, new String());
				ListUtil.sort(lstEvents, comparator);
				
				for (CalEvent ce : lstEvents) {
					//System.out.println(ce.getUuid());
					cptNbDisplayed++;
					if (!idEvents.contains(ce.getUuid())){
						idEvents.add(ce.getUuid());
					}
					
					nextOccur = new GregorianCalendar();
					nextOccur.setTime(ce.getStartDate());					
					nextOccur.set(Calendar.DAY_OF_MONTH, gregCal.get(Calendar.DAY_OF_MONTH));
					nextOccur.set(Calendar.MONTH, gregCal.get(Calendar.MONTH));
					
					date = Time.getDate(nextOccur.getTime(), TimeZoneUtil.getDefault());
%>
					<div class="nt-up-ev-item">
						<div class="nt-up-ev-date">
							<div class="nt-up-ev-month"><%=dfMonth.format(Time.getDate(nextOccur.getTime(), TimeZoneUtil.getDefault()))%></div>
							<div class="nt-up-ev-day"><%=dfDay.format(Time.getDate(nextOccur.getTime(), TimeZoneUtil.getDefault()))%></div>
						</div>
						<div class="nt-up-ev-text">
							<div class="nt-up-ev-title">
								<a href="/c/calendar/find_event?eventId=<%=ce.getEventId()%>"><%=ce.getTitle()%></a>
							</div>
							<div class="nt-up-ev-fulldate"><%=(ce.isAllDay())? df.format(date): dft.format(date)%></div>
							<div class="nt-up-ev-location"><%=ce.getLocation()%></div>
						</div>
					</div>
<%
					if (cptNbDisplayed >= nbToDisplay) {
						break;
					}
				}
				if (cptNbDisplayed >= nbToDisplay) {
					break;
				}
				gregCal.set(GregorianCalendar.DATE, gregCal.get(GregorianCalendar.DATE)+1);
			}
/*			
			if (cptNbDisplayed < nbToDisplay){
				Date currentDate = gregCal.getTime();
				
				lstEvents = CalEventLocalServiceUtil.getEvents(themeDisplay.getLayout()
						.getGroupId() , new String(), 0, 100000);				
				
				for (CalEvent ce : lstEvents) {
					if (currentDate.compareTo(ce.getEndDate()) > 0 ||  idEvents.contains(ce.getUuid())) {
						continue;
					}					
					cptNbDisplayed++;
*/
%>
<%
/*
					if (cptNbDisplayed >= nbToDisplay) {
						break;
					}
				}
			}
*/			 
		}
	} catch (Exception e) {
		System.out.println("unable to retrieve events : " + e.getMessage());
		e.printStackTrace();
	}
	if (cptNbDisplayed == 0) {
%>
		<div class="nt-up-ev-noitem">
			<div class="nt-up-ev-noitem-left"></div>
			<div class="nt-up-ev-noitem-right">
				<liferay-ui:message key="no-events-currently-planned" />
			</div>
		</div>
<%
	}
	if (!calendarPage.equals(StringPool.BLANK)){
%>
		<div class="nt-up-ev-view-all"><a href="<%= calendarPage %>"><liferay-ui:message key="view-all-events" /></a></div>
<%
	}
%>
