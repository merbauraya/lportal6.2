<%@ include file="/html/taglib/eis/init.jsp" %>


<%
	
	String value = ((String)request.getAttribute("eis:period-selector:value"));
	

	String controlName = ((String)request.getAttribute("eis:period-selector:controlName"));
	//boolean useMonthName = ((Boolean)request.getAttribute("eis:period-selector:useMonthName"));
	boolean useMonthName = GetterUtil.getBoolean((String)request.getAttribute("eis:period-selector:useMonthName"), false);
	//int startYear = Integer.parseInt((String)request.getAttribute("eis:period-selector:startYear"));
	int startYear = GetterUtil.getInteger((String)request.getAttribute("eis:period-selector:startYear"));
	int endYear = GetterUtil.getInteger((String)request.getAttribute("eis:period-selector:endYear"));
	String cssClass = ((String)request.getAttribute("eis:period-selector:cssClass"));
	
	
	boolean allowPreviousYear = GetterUtil.getBoolean((String) request.getAttribute("eis:period-select:allowPreviousYear"), true);
	boolean useYearRange = GetterUtil.getBoolean((String) request.getAttribute("eis:period-selector:useYearRange"), false);
	boolean allowFuturePeriod = GetterUtil.getBoolean((String) request.getAttribute("eis:period-selector:allowFuturePeriod"), false);
	
	
	int numberPreviousYear = GetterUtil.getInteger((String) request.getAttribute("eis:period-selector:numberPreviousYear"), 1);
	int numberFutureYear = GetterUtil.getInteger((String)request.getAttribute("eis:period-selector:numberFutureYear"),1);
	int dataCountDay = GetterUtil.getInteger((String)request.getAttribute("eis:period-selector:dataCountDay"),10);
	
	
	boolean includeEmptyOption = GetterUtil.getBoolean((String)request.getAttribute("eis:period-selector:includeEmptyOption"),false);
			
	
	
	
	
	
	
	Calendar cal = CalendarFactoryUtil.getCalendar(themeDisplay.getLocale());
	int curMonth = cal.get(Calendar.MONTH) + 1; // Note: zero based!
	int curYear = cal.get(Calendar.YEAR);
	int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

	
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
	
			
			<aui:select name="<%= controlName %>" label="period-year-month" cssClass="<%= cssClass%>">
				<c:if test="<%= includeEmptyOption %>">
					<%
						boolean selected = Validator.isNull(value);
					%>
				
					<aui:option selected="<%= selected %>" label="<%= StringPool.BLANK %>" value="<%= StringPool.BLANK %>" />
					
				
				</c:if>
			
			<%	
				
				DateFormatSymbols dateFmt = new DateFormatSymbols(themeDisplay.getLocale());
				
				for (int year = startYear; year <= endYear ; year++)
				{
					for (int month = 1; month <= 12; month++)
					{
						boolean selected = false;
						StringBuilder displayValue = new StringBuilder();
						StringBuilder stringValue = new StringBuilder();
						
						//value
						stringValue.append(year);
						stringValue.append(String.format("%02d", month));
						
						//display label
						
						if (useMonthName)
						{
							String mthName = dateFmt.getMonths()[month-1];
							displayValue.append(mthName);
							displayValue.append(StringPool.SPACE);
							displayValue.append(year);
						}else
						{	
							displayValue = stringValue;
							
						}
						
						
						if (Validator.isNotNull(value))	
						{
							if (value.equalsIgnoreCase(stringValue.toString()))
							{
								selected = true;
							}
						}
						
						boolean addMonth = true;
						if (!allowFuturePeriod)
						{
							if (year > curYear)
							{
								addMonth = false;
							}
						}
						
						if (year == curYear)
						{
							//only add up to previous month
							if (month >= curMonth )
							{
								addMonth = false;
							}
							if (curMonth-1 == month) selected = true;
							
						}
						
						//handle jan december
						if (curMonth == 1) //currently we are in january
						{
							
							if (year  == curYear - 1) //check if previous year
							{
								
								if (month == 12) //if december
								{
									
									selected = true;
								}
							}
						}
						
						
						if (addMonth)
						{
			%>			
						
						<aui:option selected="<%= selected %>" label="<%= displayValue.toString() %>" value="<%= stringValue.toString() %>" />
						
			<%
						}
					}
				}
			%>	
			
			
			</aui:select>
			
	


<%!
private static Log LOGGER = LogFactoryUtil.getLog("eisPortlet.taglib.eis.periodSelector_jsp");
%>