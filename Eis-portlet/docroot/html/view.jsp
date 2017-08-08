<%@ include file="/html/init.jsp" %>
<%@ include file="/html/toolbar.jsp" %>

<%
	long libraryId = ParamUtil.getLong(request, "library");
	String periodFilter = ParamUtil.getString(request, "period");
	long dataId = ParamUtil.getLong(request, "dataType");
	long userId = themeDisplay.getUserId();
	if (Validator.isNull(dataId))
	{
		dataId = EisUtil.DATA_ALL_DATA;
	}

%>


	
	<portlet:renderURL var="viewURL">
		
	</portlet:renderURL>
	
	<div>
	
	<aui:form action="<%=viewURL %>">
		<aui:layout>
			<aui:col span="3">
				<eis:library-selector2
					adminAllowAll="<%= mLibraryAdminAllowAll %>"
					addAllOption = "<%= true %>"
				
				/>
			</aui:col>
			<aui:col span="3">
				<eis:period-selector 
					allowPreviousYear="<%=mPeriodAllowPreviousYear %>"
					useYearRange="<%= mPeriodUseYearRange %>" 
					numberPreviousYear="<%= mPeriodNumYearPrevious %>"
					numberFutureYear="<%= mPeriodNumYearForward %>"
					useMonthName="<%= mPeriodUseMonthName %>"
					startYear="<%= mPeriodStartYear %>"
					endYear="<%= mPeriodEndYear %>"
					includeEmptyOption="<%= false %>"
					allowFuturePeriod= "<%= false%>"
					dataCountDay = "<%= mDataCountDay %>"
					value="<%=periodFilter%>"
					
				/>
				
				
			</aui:col>
			
			
			<aui:col span="3">
				<div class="control-group">
					<label class="control-label">&nbsp;</label>
					<aui:button primary="<%= true %>" name="filter" type="submit" value="filter"  />
					
				</div>
			
			</aui:col>
			
		
		</aui:layout>
		
		
	
	
	</aui:form>
	</div>
	
	<%
		

		int dataDueDay = GetterUtil.getInteger(props.get(EisUtil.CONFIG_DATA_DUE_DAY));
		Calendar cal = CalendarFactoryUtil.getCalendar(); 
		
		int today = cal.get(Calendar.DATE);
		int due = 0;
		boolean showDue = false;
		if (today >= 1 && today < dataDueDay)
		{
			showDue = true;
			due = dataDueDay - today;
		}
		int month = cal.get(Calendar.MONTH)+1;
		int year = cal.get(Calendar.YEAR);
		
		String period = StringPool.BLANK;
		
		//default to previous month
		month--;
		if (month == 0)
		{
			year--;
			month = 12;
		}
		
		DateFormatSymbols dateFmt = new DateFormatSymbols(themeDisplay.getLocale());
		String monthName = dateFmt.getMonths()[month];
		//String periodString = monthName + " " + String.valueOf(year);
		
		if (Validator.isNotNull(periodFilter))
		{
			period = periodFilter;
		}else
		{
			period = String.valueOf(year) + String.format("%02d", month);
		}
		String periodString = EisUtil.getPeriodString(period);// monthName + " " + String.valueOf(year);

		//boolean isAdmin = permissionChecker.isOmniadmin();
		ArrayList missingData = MissingDataUtil.getUserMissingData(themeDisplay.getUserId(),period,themeDisplay.getLocale(),libraryId,isAdmin,mLibraryAdminAllowAll);
		//long userId,String period,Locale locale,long libraryId,boolean isAdmin,boolean adminAllowAllLibrary
	%>
	
	<div>
		<c:if test="<%= showDue %>">
			<div class="alert alert-warning">
				<liferay-ui:message key="data-due-in-x-days" arguments="<%= due %>" />
				
			</div>
		
		</c:if>
		
		<aui:row>
			<div class="alert alert-warning">
				<div class="align-center">
				
					<h4>Senarai data yang tidak lengkap untuk bulan <%=periodString %></h4>
				</div>
			</div>
				<c:choose>
					<c:when test="<%= missingData.size() > 0 %>">
					<liferay-portlet:renderURL varImpl="iteratorURL">
						<portlet:param name="library" value="<%= String.valueOf(libraryId) %>"/>
						<portlet:param name="period" value="<%= period %>"/>
						<portlet:param name="dataId" value="<%= String.valueOf(dataId) %>"/>
					</liferay-portlet:renderURL>
					
					
						<liferay-ui:search-container delta="10" emptyResultsMessage="no-data"
							iteratorURL="<%= iteratorURL %>"
						>
						    <liferay-ui:search-container-results
						        results="<%= ListUtil.subList(missingData,searchContainer.getStart(), searchContainer.getEnd()) %>"
						        total="<%= missingData.size() %>"
						    />
						    <liferay-ui:search-container-row
						        className="java.util.HashMap"
						        keyProperty="libraryName"
						        modelVar="missingItem"
						    >
						         <liferay-ui:search-container-column-text
						            name="library-name"
						            value='<%= missingItem.get("libraryName").toString() %>'
						        />
						
						        
						        <liferay-ui:search-container-column-text
						            name="data-type"
						            value='<%= missingItem.get("dataName").toString() %>'
						        />
						        
						        
						        
						       <%
						       		PortletURL url = getEditURL(Integer.valueOf(missingItem.get("dataId").toString()),
						       				renderResponse);
						       
						       %>
						       
						       
						        
						       <liferay-ui:search-container-column-text>
						       
						       	<liferay-ui:icon image="edit" message="edit"
 									  url="<%= url.toString() %>" />
						       
						       </liferay-ui:search-container-column-text>
						       
						        
						    </liferay-ui:search-container-row>
						
						    <liferay-ui:search-iterator />
						
						</liferay-ui:search-container>
						
					</c:when>
					<c:otherwise>
						<liferay-ui:message key="no-incomplete-data" />
					</c:otherwise>
				</c:choose>
			
		</aui:row>
		
		
		
	
	</div>
	
	
	
	
	
<%!
public PortletURL getEditURL(int dataType,javax.portlet.RenderResponse response)
{
	
	
	
	String page = StringPool.BLANK;
    switch (dataType)
    {
	    case EisUtil.DATA_IR: page = "/html/fact/irItem.jsp";
	    	break;
	    	
	    case EisUtil.DATA_PRINTED_MATERIAL: page = "/html/fact/printedMaterial.jsp";
	    	break;
	    
	    case EisUtil.DATA_NON_PRINTED_MATERIAL: page = "/html/fact/nonPrintedMaterial.jsp";
	    	break;
	    
	    case EisUtil.DATA_MEMBERSHIP: page="/html/fact/member.jsp";
	    	break;
	    	
	    case EisUtil.DATA_LOAN: page="/html/fact/loan.jsp";
	    	break;
	    	
	    case EisUtil.DATA_POSITION: page="/html/fact/post.jsp";
	    	break;
	    	
	    case EisUtil.DATA_SEATING: page="/html/fact/seating.jsp";
	    	break;
	    	
	    case EisUtil.DATA_VISITOR : page = "/html/fact/visitor.jsp";
	    	break;
	    	
	    case EisUtil.DATA_EXPENSE : page = "/html/fact/expense.jsp";
    		break;
    	
	    case EisUtil.DATA_ACADEMIC_CONSULTATION : page = "/html/fact/consultation.jsp";
	    	break;
	    case EisUtil.DATA_ACQUISITION : page  = "/html/fact/acquisition.jsp";
	    	break;
	    case EisUtil.DATA_DATABASE_USAGE: page = "/html/fact/databaseUsage.jsp";
	    	break;
	    
	    case EisUtil.DATA_DIGITAL_COLLECTION : page = "/html/fact/digitalCollection.jsp";
	    	break;
	    case EisUtil.DATA_INCOME : page="/html/fact/income.jsp";
	    	break;
    }
    
    
    PortletURL url = response.createRenderURL();
	url.setParameter("mvcPath", page);
	
	return url;
}
%>