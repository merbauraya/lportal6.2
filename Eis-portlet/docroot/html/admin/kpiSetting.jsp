<%@ include file="/html/init.jsp" %>

<%
	List<Config> kpiSettings = ConfigLocalServiceUtil.findWithKeyWildcard(EisUtil.KEY_KPI_SETTING_RANGE,QueryUtil.ALL_POS,QueryUtil.ALL_POS);
	int[] rowIndexes = null;
	
	
	String rowIndexesParam = ParamUtil.getString(request, "rowIndexes");
	
	
	if (kpiSettings.size() == 0)
	{
		kpiSettings = new ArrayList<Config>();
		rowIndexes = new int[] {0};
	} else
	{
		rowIndexes = new int[kpiSettings.size()];
		for (int i = 0; i < kpiSettings.size(); i++)
		{
			rowIndexes[i] = i;
		}
		
	}
	
	if (kpiSettings.isEmpty())
	{
		kpiSettings = new ArrayList<Config>();
		kpiSettings.add(new ConfigImpl());
		rowIndexes = new int[] {0};
	}
	if (rowIndexes == null)
	{
		rowIndexes = new int[] {0};
	}
	
	
	
	

	


%>
<liferay-portlet:renderURL varImpl="iteratorURL">
       <portlet:param name="mvcPath" value="/html/admin/view.jsp" />
       <portlet:param name="navigation" value="kpiSetting" />
</liferay-portlet:renderURL>

<portlet:actionURL var="editURL" name="editKpiSetting">
	
</portlet:actionURL>
<style>

.red {
	background : red;
}
.yellow {
background : yellow;}

.green {
	background : green;}
.blue {
	background : blue;
}
.colorSelector{
	padding: 5px;
	margin-right: 5px;
	
}

.colorSelectorGroup a:hover,.colorSelectorGroup a:visited, .colorSelectorGroup a:active,.colorSelectorGroup a:link
{
	text-decoration: none;
	color: transparent;
}
.colorSelected {
	color : #FFF;
}
</style>

<aui:form action="<%= editURL %>" name="fm">
	<div id="auto-fields-container">
		<%
			for (int i = 0; i < rowIndexes.length; i++)
			{
				int rowIndex = rowIndexes[i];
				Config kpiSetting = kpiSettings.get(i);
				String setting = kpiSetting.getValue();
				
				String[] settingArray = null;
				if (Validator.isBlank(setting))
				{
					settingArray = new String[] {"","",""};
				} else
				{
					settingArray = setting.split(",");
				}
			
				
				String lowRange = settingArray[0];
				String highRange = settingArray[1];
				String color = settingArray[2];
				String classSelected = "icon-sign-blank";
				
				
				
			
		
		%>
		<aui:fieldset>
			<div class="lfr-form-row lfr-form-row-inline">
				<div class="row-fields" style="display: flex;">
		
					<aui:input label="low-range" name='<%="lowRange" + rowIndex %>' value = "<%= lowRange %>"/>
					<aui:input label="high-range" name='<%= "highRange" + rowIndex %>'  value="<%= highRange %>"/>	
					
					
	                
					<div class="control-group colorSelectorGroup">
						<aui:input type="hidden" name='<%= "kpiColor" + rowIndex %>' cssClass="colorValue" value="<%= color %>"/>
						<label class="control-label">Color</label>
						<a href="#" kpiColor="red" class="kpiColorSelector">
							<%
								if (color.equalsIgnoreCase("red"))
								{
									classSelected = "icon-check colorSelected";
								}
							%>
							<i class='<%= "red colorSelector " + classSelected %>'></i>
						</a>
						<a href="#" kpiColor="yellow" class="kpiColorSelector">
							<%
							classSelected = "icon-sign-blank";
								if (color.equalsIgnoreCase("yellow"))
								{
									classSelected = "icon-check colorSelected";
								}
							%>
							<i class='<%= "yellow colorSelector " + classSelected %>'></i>
						</a>
						<a href="#" kpiColor="green" class="kpiColorSelector">
							<%
							classSelected = "icon-sign-blank";
								if (color.equalsIgnoreCase("green"))
								{
									classSelected = "icon-check colorSelected";
								}
							%>
							<i class='<%= "green colorSelector " + classSelected %>'></i>
						</a>
						<a href="#" kpiColor="blue" class="kpiColorSelector">
							<%
							classSelected = "icon-sign-blank";
								if (color.equalsIgnoreCase("blue"))
								{
									classSelected = "icon-check colorSelected";
								}
							%>
							<i class='<%= "blue colorSelector " + classSelected %>'></i>
						</a>
					</div>
				
				</div>
			</div>
		</aui:fieldset>
		<%
			}
		%>
		
	</div>
 
	<aui:button-row>
		<aui:button type="submit" value="save" />
    </aui:button-row>
	
</aui:form>
<aui:script use="liferay-auto-fields">
new Liferay.AutoFields({
	contentBox: '#auto-fields-container',
	fieldIndexes: '<portlet:namespace />rowIndexes',
	on: {
		'clone': function(event) {
			
			console.log(event);
		},
		'delete': function(event) {
		
			console.log(event);
		}
	},
	sortable: true,
	sortableHandle: '.lfr-form-row'
	}).render();
	
	var container = A.one('#auto-fields-container');
	container.delegate('click', function(event){
		var parent = this.ancestor();
		
		var inp = parent.one('.colorValue');
		
		
		inp.set('value',this.attr('kpiColor'));
		
		var i = parent.all('i');
		
		i.removeClass('icon-check');
		i.addClass('icon-sign-blank');
		i.removeClass("colorSelected");
		
		var selectedLink = this.one('i');
		
		selectedLink.addClass('icon-check');
		selectedLink.addClass("colorSelected");
		selectedLink.removeClass('icon-sign-blank');
		
		
		}, 'a');

</aui:script>

