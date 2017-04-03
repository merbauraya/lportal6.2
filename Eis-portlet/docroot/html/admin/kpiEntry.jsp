<%@ include file="/html/init.jsp" %> 
<%
	List<KpiType> kpiTypes = KpiTypeLocalServiceUtil.getKpiTypes(QueryUtil.ALL_POS,QueryUtil.ALL_POS);

%>

<portlet:actionURL var="editURL" name="editKpiEntry">
	
</portlet:actionURL>

<aui:form action="<%= editURL %>" name="fm">
	<aui:row>
		<aui:layout>
			<aui:col span="6">
				<aui:select name="kpiType">
				<% for (KpiType kpiType : kpiTypes) 
				{	
				%>
					<aui:option value="<%=kpiType.getKpiTypeId() %>"><%= kpiType.getKpiName() %></aui:option>
				
				<%
				}
				%>
				
				</aui:select>
			</aui:col>
			<aui:col span="6">
				<eis:year-selector 
						allowPreviousYear="<%=mPeriodAllowPreviousYear %>"
						useYearRange="<%= mPeriodUseYearRange %>" 
						numberPreviousYear="<%= mPeriodNumYearPrevious %>"
						numberFutureYear="<%= mPeriodNumYearForward %>"
						
						startYear="<%= mPeriodStartYear %>"
						endYear="<%= mPeriodEndYear %>"
								
							/>
			</aui:col>
		</aui:layout>
	</aui:row>
	<aui:button type="button" 
			name="loadList" 
			label="load" 
			icon="icon-refresh"
	/>
	<hr/>
	<div id="yearContainer" style="display:none;">
		
	</div>
	
	
	<div id="divForm">
	
	</div>
	<aui:button-row>
		<aui:button type="submit" value="save"></aui:button>
	</aui:button-row>
</aui:form>

<portlet:resourceURL var="dataURL" id="<%= EisUtil.RESOURCE_KPI_ENTRY_DATA %>">

</portlet:resourceURL>

<aui:script use="aui-base,aui-io-plugin-deprecated,aui-io-request,aui-node,aui-event-delegate-change">
	var A = AUI();
	var floatingPoint = 0;
	
	A.all('select').on('change',function(){
		
		var inputs = A.all('.dataInput');
		
		inputs.each(function(){
			this.val(null);
			
		});
	});
	
	
	var btnLoad = A.one('#<portlet:namespace/>loadList');
	
	
	btnLoad.on('click',function(){
		
		
		
		

		var kpiTypeId = A.one('#<portlet:namespace/>kpiType').get('value');
		var year =  A.one('#<portlet:namespace/>year').get('value');
		
		
		var inputs = A.all('.dataInput');
		
		inputs.each(function(){
			this.val('');
			
		});
		
		
		A.io.request('<%=dataURL.toString()%>', { 
            method: 'get',
            dataType: 'json',
            data: {
		    	
            	<portlet:namespace/>kpiTypeId : kpiTypeId,
		    	<portlet:namespace/>year : year,
		    	
		    	
		    },
            
            on: {
                 success: function() {
                	 var data=this.get('responseData');
                		A.one('#divForm').html(data);
                		A.one('#yearContainer').show();
                		A.one('#<portlet:namespace/>periodYear').val(A.one('#<portlet:namespace/>yearValue').get('value'));
                		floatingPoint = A.one('#<portlet:namespace/>floatingPoint').get('value')
                 }
            }
         });
		
		
		return;
	
	});
	

	
	
	var yearKPI = A.one('#<portlet:namespace/>periodYear');
	
	
	
	if (yearKPI == null)
		{
		
		return;
		}
	
	
	yearKPI.on('change',function(){
		
	var yearKPI = this.get('value');
	
	var sa1 = A.one('#<portlet:namespace/>sa1');
	console.log(sa1.get('value'));
	if (sa1 != null && sa1.get('value') == 0)
	{
		
		var sa1 = A.one('#<portlet:namespace/>sa1');
		var sa2 = A.one('#<portlet:namespace/>sa2');
		var saValue = Number(yearKPI/2).toFixed(floatingPoint);
		
		sa1.val(saValue);
		sa2.val(saValue);
		
	}
	
	var q1 = A.one('#<portlet:namespace/>q1');
	if (q1 != null && q1.get('value') == 0)
	{
		
		var quarterVal = Number(yearKPI/4).toFixed(floatingPoint);
		
		
			A.one('#<portlet:namespace/>q1').val(quarterVal);
			A.one('#<portlet:namespace/>q2').val(quarterVal);
			A.one('#<portlet:namespace/>q3').val(quarterVal);
			A.one('#<portlet:namespace/>q4').val(quarterVal);
		
		
	}
	var m1 = A.one('#<portlet:namespace/>month1');
	if (m1 != null && m1.get('value') == 0)
	{
		
		var monthVal = Number(yearKPI/12).toFixed(floatingPoint);
		
		for (var i =1; i < 13 ;i++)
		{
			var mthInput = '#<portlet:namespace/>' + 'month'+i;
			A.one(mthInput).val(monthVal);
		}
			
			
		
		
	}	
		
});

</aui:script>
<aui:script use="aui-node">
	var A = AUI();
	var formContainer = A.one("#divForm");
	console.log(formContainer);


formContainer.delegate(
		'change',
		function(event) {
			console.log(event.currentTarget);
		}
		
	);


</aui:script>
<aui:script use="liferay-form">
         var myForm = Liferay.Form.get('<portlet:namespace />fm');
         var fieldRules = myForm.get('fieldRules');
 
         var addrules = [
            {
                 fieldName: '<portlet:namespace />periodYear',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />periodYearValue',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />sa1',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />sa1value',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />sa2',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />sa2value',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />q1',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />q1value',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />q2',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />q2value',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />q3',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />q3value',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />q4',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />q4value',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />month1',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />month1value',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />month2',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />month2value',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />month3',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />month3value',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />month4',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />month4value',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />month5',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />month5value',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />month6',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />month6value',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />month7',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />month7value',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />month8',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />month8value',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />month9',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />month9value',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />month10',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />month10value',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />month11',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />month11value',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />month12',
                 validatorName: 'digits'
             },
             {
                 fieldName: '<portlet:namespace />month12value',
                 validatorName: 'digits'
             },
             
        ];

        fieldRules = fieldRules.concat(addrules);
        fieldRules = A.Array.unique(fieldRules);

        myForm.set('fieldRules', fieldRules);
</aui:script>