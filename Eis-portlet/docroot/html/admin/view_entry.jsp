<%@ include file="/html/init.jsp" %> 

<%
	String navigation = ParamUtil.getString(request, "navigation","home");

%>
<%= navigation %>
hallo