<%@ include file="/html/init.jsp" %>

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
		<aui:fieldset>
			<div class="lfr-form-row lfr-form-row-inline">
				<div class="row-fields" style="display: flex;">
		
					<aui:input label="low-range" name="lowRange1" />
					<aui:input label="high-range" name="highRange1"  />	
					
					
	                
					<div class="control-group colorSelectorGroup">
						<aui:input type="hidden" name="kpiColor1" cssClass="colorValue"/>
						<label class="control-label">Color</label>
						<a href="#" class="kpiRed" class="kpiColorSelector">
							<i class="red colorSelector icon-sign-blank icon-check"></i>
						</a>
						<a href="#" class="kpiYellow" class="kpiColorSelector">
							<i class="yellow colorSelector icon-sign-blank"></i>
						</a>
						<a href="#" class="kpiGreen" class="kpiColorSelector">
							<i class="green colorSelector icon-sign-blank"></i>
						</a>
						<a href="#" class="kpiBlue" class="kpiColorSelector">
							<i class="blue colorSelector icon-sign-blank"></i>
						</a>
					</div>
				
				</div>
			</div>
		</aui:fieldset>
		
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
		
		
		inp.set('value',this.attr('class'));
		
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

