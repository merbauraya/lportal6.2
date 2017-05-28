<%@ include file="/html/init.jsp" %>

<%
	String html = ParamUtil.getString(request, "html"); 

%>
<div class="hpanel">
	<%
	out.print(html); 
	%>
</div>

