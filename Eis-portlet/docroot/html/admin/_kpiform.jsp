<%@ include file="/html/init.jsp" %>
<%
	KpiType kpiType = (KpiType)request.getAttribute("kpiType");
	String year = (String) request.getAttribute("year");
	
	
%>

<c:if test="<%= kpiType.getPeriodYear() %>">
<%
	List<KpiEntry> entries  = KpiEntryLocalServiceUtil.findByYearPeriodType(kpiType.getKpiTypeId(), year, EisUtil.KPI_YEARLY);
	double kpi = 0;
	//double actual= 0;
	Object value = 0;
	Object actual = 0;
	if (entries.size() > 0)
	{
		value = entries.get(0).getValue();
		actual = entries.get(0).getActual();
		if (!kpiType.getIsDecimal())
		{
			value = (long)entries.get(0).getValue();
			actual = (long)entries.get(0).getActual();
		}
	}
%>	
	<liferay-ui:panel collapsible="<%= true%>" extended="<%=true%>" title="period-year">
		<div class="item-data-cont">
			<div class="data-cont">
				<aui:input class="dataInput" name="periodYear" label="period-year" value="<%= kpi %>">
					 <aui:validator name="digits"></aui:validator>
					
				</aui:input>
				
				<c:if test="<%= kpiType.getManualValue() %>">
					<aui:input class="dataInput" name="periodYearValue" label="kpi-actual-value" value="<%= actual %>">
						 <aui:validator name="digits"></aui:validator>
						
					</aui:input>
				
				</c:if>
			</div>
		</div>
			
	</liferay-ui:panel>

</c:if>


<c:if test="<%= kpiType.getPeriodSemiAnnual() %>">
	<%
		List<KpiEntry> entries  = KpiEntryLocalServiceUtil.findByYearPeriodType(kpiType.getKpiTypeId(), year, EisUtil.KPI_SEMI_ANUALLY);
		//ArrayList<Object> values = new ArrayList<Object>(2);
		ArrayList<Object[]> valuesArray = new ArrayList<Object[]>();
		//Object[] vals = {0 , 0};
		
		
		
		if (entries.size() > 0)
		{
			for (int i = 0; i < entries.size(); i++)
			{
				Object[] entryValues = new Object[2];
				Object value = entries.get(i).getValue();
				Object actual = entries.get(i).getActual();
				
				if (!kpiType.getIsDecimal())
				{
					value = (long)entries.get(i).getValue();
					actual = (long)entries.get(i).getActual();
				}
				
				entryValues[0] = value;
				entryValues[1] = actual;
				
				valuesArray.add(entryValues);
				
				
				
				//vals[i] = entries.get(i).getValue();
				//values.add(entryValues);
			}
		} else
		{
			Object[] entryValues = new Object[2];
			entryValues[0] = 0;
			entryValues[1] = 0;
		
			valuesArray.add(entryValues);
			valuesArray.add(entryValues);
		}
		
	%>
	
	<liferay-ui:panel collapsible="<%= true%>" extended="<%=true%>" title="semi-annual">
		<aui:layout>
			
		
			<aui:col span="6">
				<div class="item-data-cont">
					<div class="data-cont">
						<aui:input cssClass="dataInput"  value="<%= valuesArray.get(0)[0] %>" name="sa1" label="semi-annual-1"></aui:input>
						<c:if test="<%= kpiType.getManualValue() %>">
							<aui:input cssClass="dataInput"  value="<%= valuesArray.get(0)[1] %>" name="sa1value" label="kpi-actual-value"></aui:input>
						
						</c:if>
					</div>
				</div>
			</aui:col>
			
			<aui:col span="6">
				<div class="item-data-cont">
					<div class="data-cont">
						<aui:input cssClass="dataInput"  value="<%= valuesArray.get(1)[0] %>" name="sa2" label="semi-annual-2"></aui:input>
						<c:if test="<%= kpiType.getManualValue() %>">
							<aui:input cssClass="dataInput"  value="<%= valuesArray.get(1)[1] %>" name="sa2value" label="kpi-actual-value"></aui:input>
						
						</c:if>
					</div>
				</div>
			</aui:col>
		</aui:layout>
	</liferay-ui:panel>
</c:if>



<c:if test="<%= kpiType.getPeriodQuarter() %>">
	<%
		List<KpiEntry> entries  = KpiEntryLocalServiceUtil.findByYearPeriodType(kpiType.getKpiTypeId(), year, EisUtil.KPI_QUARTERLY);
		//double[] vals = {0,0,0,0};
		Object[] vals = {0,0,0,0};
		ArrayList<Object> values = new ArrayList<Object>();
		ArrayList<Object[]> valuesArray = new ArrayList<Object[]>();

		if (entries.size() > 0)
		{
			for (int i = 0; i <entries.size() ; i++)
			{
				Object[] entryValues = new Object[2];
				Object value = entries.get(i).getValue();
				Object actual = entries.get(i).getActual();
				
				if (!kpiType.getIsDecimal())
				{
					value = (long)entries.get(i).getValue();
					actual = (long)entries.get(i).getActual();
				}
				
				entryValues[0] = value;
				entryValues[1] = actual;
				
				valuesArray.add(entryValues);
				
			
			}
		} else
		{
			Object[] entryValues = new Object[2]; //set default value to 0
			entryValues[0] = 0;
			entryValues[1] = 0;
			for (int i = 0; i < 4; i++)
			{
				valuesArray.add(entryValues);
			}
			
		}
	
	%>
	<liferay-ui:panel collapsible="<%= true%>" extended="<%=true%>" title="period-quarter">
		<aui:layout>
			<aui:col span="3">
				<div class="item-data-cont">
					<div class="data-cont">
						<aui:input cssClass="dataInput"  value="<%= valuesArray.get(0)[0] %>" name="q1" label="quarter-1"></aui:input>
						<c:if test="<%= kpiType.getManualValue() %>">
							<aui:input cssClass="dataInput"  value="<%= valuesArray.get(0)[1] %>" name="q1value" label="kpi-actual-value"></aui:input>
						
						</c:if>
					</div>
				</div>
			</aui:col>
			<aui:col span="3">
				<div class="item-data-cont">
					<div class="data-cont">
						<aui:input cssClass="dataInput"  value="<%= valuesArray.get(1)[0] %>" name="q2" label="quarter-2"></aui:input>
						<c:if test="<%= kpiType.getManualValue() %>">
							<aui:input cssClass="dataInput"  value="<%= valuesArray.get(1)[1] %>" name="q2value" label="kpi-actual-value"></aui:input>
						
						</c:if>
					</div>
				</div>
			</aui:col>
			<aui:col span="3">
				<div class="item-data-cont">
					<div class="data-cont">
						<aui:input cssClass="dataInput"  value="<%= valuesArray.get(2)[0] %>" name="q3" label="quarter-3"></aui:input>
						<c:if test="<%= kpiType.getManualValue() %>">
							<aui:input cssClass="dataInput"  value="<%= valuesArray.get(2)[1] %>" name="q3value" label="kpi-actual-value"></aui:input>
						
						</c:if>
					</div>
				</div>
			</aui:col>
			<aui:col span="3">
				<div class="item-data-cont">
					<div class="data-cont">
						<aui:input cssClass="dataInput"  value="<%= valuesArray.get(3)[0] %>" name="q4" label="quarter-4"></aui:input>
						<c:if test="<%= kpiType.getManualValue() %>">
							<aui:input cssClass="dataInput"  value="<%= valuesArray.get(3)[1] %>" name="q4value" label="kpi-actual-value"></aui:input>
						
						</c:if>
					</div>
				</div>
			</aui:col>
		</aui:layout>
		
	</liferay-ui:panel>
</c:if>
<c:if test="<%= kpiType.getPeriodMonth() %>">
	<%
		List<KpiEntry> entries  = KpiEntryLocalServiceUtil.findByYearPeriodType(kpiType.getKpiTypeId(), year, EisUtil.KPI_MONTHLY);
		
		ArrayList<Object[]> valuesArray = new ArrayList<Object[]>();
		if (entries.size() > 0)
		{
			for (int i = 0; i <entries.size() ; i++)
			{
				Object[] entryValues = new Object[2];
				Object value = entries.get(i).getValue();
				Object actual = entries.get(i).getActual();
				
				if (!kpiType.getIsDecimal())
				{
					value = (long)entries.get(i).getValue();
					actual = (long)entries.get(i).getActual();
				}
				
				entryValues[0] = value;
				entryValues[1] = actual;
				
				valuesArray.add(entryValues);
				/*
				if (!kpiType.getIsDecimal())
				{
					value =  (long)entries.get(i).getValue();
				}
				vals[i] = value;
				*/
			}
		}else
		{
			Object[] entryValues = new Object[2]; //set default value to 0
			entryValues[0] = 0;
			entryValues[1] = 0;
			for (int i = 0; i < 13; i++)
			{
				valuesArray.add(entryValues);
			}
		}
	
	%>

	<liferay-ui:panel collapsible="<%= true%>" extended="<%=true%>" title="period-monthly">
		<aui:layout>
			<aui:col span="3">
				<div class="item-data-cont">
					<div class="data-cont">
						<aui:input cssClass="dataInput"  value="<%= valuesArray.get(0)[0] %>" name="month1"></aui:input>
						<c:if test="<%= kpiType.getManualValue() %>">
							<aui:input cssClass="dataInput"  value="<%= valuesArray.get(0)[1] %>" name="month1value" label="kpi-actual-value"></aui:input>
						
						</c:if>
					</div>
				</div>
			</aui:col>
			<aui:col span="3">
				<div class="item-data-cont">
					<div class="data-cont">
						<aui:input cssClass="dataInput"   value="<%= valuesArray.get(1)[0] %>" name="month2"></aui:input>
						<c:if test="<%= kpiType.getManualValue() %>">
							<aui:input cssClass="dataInput"  value="<%= valuesArray.get(1)[1] %>" name="month2value" label="kpi-actual-value"></aui:input>
						
						</c:if>
					</div>
				</div>
			</aui:col>
			<aui:col span="3">
				<div class="item-data-cont">
					<div class="data-cont">
						<aui:input cssClass="dataInput"   value="<%= valuesArray.get(2)[0] %>" name="month3"></aui:input>
						<c:if test="<%= kpiType.getManualValue() %>">
							<aui:input cssClass="dataInput"  value="<%= valuesArray.get(2)[1] %>" name="month3value" label="kpi-actual-value"></aui:input>
						
						</c:if>
					</div>
				</div>
			</aui:col>
			<aui:col span="3">
				<div class="item-data-cont">
					<div class="data-cont">
						<aui:input cssClass="dataInput"   value="<%= valuesArray.get(3)[0] %>" name="month4"></aui:input>
						<c:if test="<%= kpiType.getManualValue() %>">
							<aui:input cssClass="dataInput"  value="<%= valuesArray.get(3)[1] %>" name="month4value" label="kpi-actual-value"></aui:input>
						
						</c:if>
					</div>
				</div>
			</aui:col>
		</aui:layout>
		<aui:layout>
			<aui:col span="3">
				<div class="item-data-cont">
					<div class="data-cont">
						<aui:input cssClass="dataInput"   value="<%= valuesArray.get(4)[0] %>" name="month5"></aui:input>
						<c:if test="<%= kpiType.getManualValue() %>">
							<aui:input cssClass="dataInput"  value="<%= valuesArray.get(4)[1] %>" name="month5value" label="kpi-actual-value"></aui:input>
						
						</c:if>
					</div>
				</div>
			</aui:col>
			<aui:col span="3">
				<div class="item-data-cont">
					<div class="data-cont">
						<aui:input cssClass="dataInput"   value="<%= valuesArray.get(5)[0] %>" name="month6"></aui:input>
						<c:if test="<%= kpiType.getManualValue() %>">
							<aui:input cssClass="dataInput"  value="<%= valuesArray.get(5)[1] %>" name="month6value" label="kpi-actual-value"></aui:input>
						
						</c:if>
					</div>
				</div>
			</aui:col>
			<aui:col span="3">
				<div class="item-data-cont">
					<div class="data-cont">
						<aui:input cssClass="dataInput"   value="<%= valuesArray.get(6)[0] %>" name="month7"></aui:input>
						<c:if test="<%= kpiType.getManualValue() %>">
							<aui:input cssClass="dataInput"  value="<%= valuesArray.get(6)[1] %>" name="month7value" label="kpi-actual-value"></aui:input>
						
						</c:if>
					</div>
				</div>
			</aui:col>
			<aui:col span="3">
				<div class="item-data-cont">
					<div class="data-cont">
						<aui:input cssClass="dataInput"   value="<%=valuesArray.get(7)[0] %>" name="month8"></aui:input>
						<c:if test="<%= kpiType.getManualValue() %>">
							<aui:input cssClass="dataInput"  value="<%= valuesArray.get(7)[1] %>" name="month8value" label="kpi-actual-value"></aui:input>
						
						</c:if>
					</div>
				</div>
			</aui:col>
		</aui:layout> 
		<aui:layout>
			<aui:col span="3">
				<div class="item-data-cont">
					<div class="data-cont">
						<aui:input cssClass="dataInput"   value="<%= valuesArray.get(8)[0] %>" name="month9"></aui:input>
						<c:if test="<%= kpiType.getManualValue() %>">
							<aui:input cssClass="dataInput"  value="<%= valuesArray.get(8)[1] %>" name="month9value" label="kpi-actual-value"></aui:input>
						
						</c:if>
					</div>
				</div>
			</aui:col>
			<aui:col span="3">
				<div class="item-data-cont">
					<div class="data-cont">
						<aui:input cssClass="dataInput"   value="<%= valuesArray.get(9)[0] %>" name="month10"></aui:input>
						<c:if test="<%= kpiType.getManualValue() %>">
							<aui:input cssClass="dataInput"  value="<%= valuesArray.get(9)[1] %>" name="month10value" label="kpi-actual-value"></aui:input>
						
						</c:if>
					</div>
				</div>
			</aui:col>
			<aui:col span="3">
				<div class="item-data-cont">
					<div class="data-cont">
						<aui:input cssClass="dataInput"   value="<%= valuesArray.get(10)[0] %>" name="month11"></aui:input>
						<c:if test="<%= kpiType.getManualValue() %>">
							<aui:input cssClass="dataInput"  value="<%= valuesArray.get(10)[1] %>" name="month11value" label="kpi-actual-value"></aui:input>
						
						</c:if>
					</div>
				</div>
			</aui:col>
			<aui:col span="3">
				<div class="item-data-cont">
					<div class="data-cont">
						<aui:input cssClass="dataInput"   value="<%= valuesArray.get(11)[0] %>" name="month12"></aui:input>
						<c:if test="<%= kpiType.getManualValue() %>">
							<aui:input cssClass="dataInput"  value="<%= valuesArray.get(11)[1] %>" name="month12value" label="kpi-actual-value"></aui:input>
						
						</c:if>
					</div>
				</div>
			</aui:col>
		</aui:layout>
		
		
	</liferay-ui:panel>

</c:if>

<%
	List<KpiEntry> yearEntries = KpiEntryLocalServiceUtil.findByYearPeriodType(kpiType.getKpiTypeId(), year, EisUtil.KPI_YEARLY);
	KpiEntry yearEntry = null;
	Object val = null;
	for (KpiEntry entry : yearEntries)
	{
		yearEntry = entry;
		val = entry.getValue();
		if (!kpiType.getIsDecimal())
		{
			val =  (long)entry.getValue();
		}
		
	}
	
%>

<aui:input type="hidden" name="yearValue" value="<%=val %>" ></aui:input>
<aui:input type="hidden" name="floatingPoint" value="<%=kpiType.getIsDecimal() ? 2 : 0 %>" ></aui:input>
<aui:script>
var yearKPI = A.one('#<portlet:namespace/>periodYear');

if (yearKPI == null)
	{
		console.log('null');
	return;
	}


</aui:script>