<%@ include file="/html/taglib/eis/init.jsp" %>


<%
	
	int status = ((Integer)request.getAttribute("eis:progress-selector:progressStatus"));
	
	

	String controlName =(String)request.getAttribute("eis:progress-selector:controlName");
	if (Validator.isNull(controlName))
	{
		controlName = "progressStatus";
	}
	
	
	


%>
<aui:select name="<%= controlName %>" label="progress-status">
	<aui:option selected="<%= status == 1 %>" value="1" label="progress-future"></aui:option>
	<aui:option selected="<%= status == 2 %>" value="2" label="progress-ongoing"></aui:option>
	<aui:option selected="<%= status == 3 %>" value="3" label="progress-completed"></aui:option> 
	<aui:option selected="<%= status == 4 %>" value="3" label="progress-cancelled"></aui:option> 
	

</aui:select>

