<%@ include file="/html/taglib/eis/init.jsp" %>


<%
	
	String value = ((String)request.getAttribute("eis:year-selector:value"));
	
	
	String controlName = ((String)request.getAttribute("eis:year-selector:controlName"));
	//boolean useMonthName = ((Boolean)request.getAttribute("eis:year-selector:useMonthName"));
	boolean useMonthName = GetterUtil.getBoolean((String)request.getAttribute("eis:year-selector:useMonthName"), false);
	//int startYear = Integer.parseInt((String)request.getAttribute("eis:year-selector:startYear"));
	int startYear = GetterUtil.getInteger((String)request.getAttribute("eis:year-selector:startYear"));
	int endYear = GetterUtil.getInteger((String)request.getAttribute("eis:year-selector:endYear"));
	
	
	
	boolean allowPreviousYear = GetterUtil.getBoolean((String) request.getAttribute("eis:period-select:allowPreviousYear"), true);
	boolean useYearRange = GetterUtil.getBoolean((String) request.getAttribute("eis:year-selector:useYearRange"), false);
	
	int numberPreviousYear = GetterUtil.getInteger((String) request.getAttribute("eis:year-selector:numberPreviousYear"), 1);
	int numberFutureYear = GetterUtil.getInteger((String)request.getAttribute("eis:year-selector:numberFutureYear"),1);
	

	
	
	
	//int endYear = Integer.parseInt((String)request.getAttribute("eis:period-selector:endYear"));
	
	Calendar cal = CalendarFactoryUtil.getCalendar(themeDisplay.getLocale());
	int curMonth = cal.get(Calendar.MONTH) + 1; // Note: zero based!
	int curYear = cal.get(Calendar.YEAR);

	
	if (allowPreviousYear)
	{
		if (!useYearRange)
		{
			startYear = curYear - numberPreviousYear;
			endYear = curYear + numberFutureYear;
		}
		
	}else
	{
		startYear = curYear;
		endYear = curYear;
	}
	

%>
	
			
			<aui:select name="<%= controlName %>">
			<%	
				
				DateFormatSymbols dateFmt = new DateFormatSymbols(themeDisplay.getLocale());
				
				for (int year = startYear; year <= endYear ; year++)
				{
					
					String yearValue = String.valueOf(year);		
						//display label
					boolean selected = false;
					if (value == yearValue)
					{
						selected = true;
						
					}
						
			%>			
						
					<aui:option selected="<%= selected %>" label="<%= yearValue %>" value="<%= yearValue.toString() %>" />
						
			<%
					
				}
			%>	
			
			
			</aui:select>
			
	


