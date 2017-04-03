<%@ include file="/html/init.jsp" %>

<portlet:defineObjects />

Select asset to be indexed

<portlet:actionURL name="runIndexer" var="actionURL"> 
	
</portlet:actionURL>

<aui:form method="post" action="<%= actionURL %>">

	
	<aui:input type="checkbox" name="calendar"></aui:input>
	<aui:input type="checkbox" name="document"></aui:input>
	
	<aui:button-row>
		<aui:button type="submit" value="Run Indexer"></aui:button>
	</aui:button-row>
</aui:form>