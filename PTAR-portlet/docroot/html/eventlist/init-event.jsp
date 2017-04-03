
<%@ page import="com.liferay.calendar.model.CalendarBooking" %>
<%@ page import="com.liferay.calendar.service.CalendarServiceUtil" %>
<%@ page import="com.liferay.calendar.model.CalendarResource" %>
<%@ page import="com.liferay.calendar.model.Calendar" %>
<%@ page import="com.liferay.calendar.service.CalendarBookingServiceUtil" %>
<%@ page import="com.liferay.calendar.service.CalendarResourceLocalServiceUtil" %>
<%@ page import="com.liferay.calendar.service.persistence.CalendarBookingFinderUtil" %>

<%@ page import="com.liferay.calendar.service.CalendarLocalServiceUtil" %>
<%@ include file="/html/init.jsp" %>
	
<%
	final String CALENDAR_BOOKING = "CALENDAR_BOOKING";
	final String CALENDAR = "CALENDAR";
	String calendarPage=StringPool.BLANK;
	String nbEvents="5";
	String nbDays="365";
	
	
	
	
	PortletPreferences prefs = renderRequest.getPreferences();
	String portletResource = ParamUtil.getString(request,"portletResource");

	
	if (Validator.isNotNull(portletResource)) {
		prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	
	String calendarIdValues = prefs.getValue("calendarIdValues",StringPool.BLANK);
	long[] calendarIds = StringUtil.split(calendarIdValues, 0L);

	boolean allCalendars = GetterUtil.getBoolean(prefs.getValue("allCalendars", StringPool.BLANK));

	
	calendarPage= prefs.getValue("calendar-page", calendarPage);
	nbEvents= prefs.getValue("nb-events",nbEvents);
	nbDays= prefs.getValue("nb-days", nbDays);
	CalendarBooking calendarBooking = (CalendarBooking)request.getAttribute(CALENDAR_BOOKING);
	
	long classPK = scopeGroupId;
	long classNameId = PortalUtil.getClassNameId(Group.class);  

	if (themeDisplay.getScopeGroup().getClassNameId() == PortalUtil.getClassNameId(User.class)) {
		classNameId = PortalUtil.getClassNameId(User.class);
		classPK = themeDisplay.getLayout().getUserId(); 
	}
	CalendarResource calendarResource = CalendarResourceLocalServiceUtil.fetchCalendarResource(classNameId, classPK);
	
	List<Calendar> calendars = calendarResource.getCalendars();


%>