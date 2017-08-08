<%@ include file="/html/init.jsp" %>

<%
	String type = (String)request.getAttribute("type");
	String id = (String)request.getAttribute("id");
	String title =(String)request.getAttribute("title");
	Double x = (Double) request.getAttribute("x");
	

%>

<c:if test="<%= type.equalsIgnoreCase(\"infoBox\") %>">
	<%= x %>
	<div class="portlet-box sm-st yui3-dd-drop" id="<%= id%>"> 	
		<a class="removeDB pull-right" href="javascript:;"> 	
			<i class="fa fa-close" accesskey="remove"></i> 	
		</a> 	
		<div class="titleCont"> 	
			<div class="ptitle"><%= title %></div> 	
		</div>	
		<img class="center" src="/Eis-portlet/img/db-figure.png"> 	
	</div>


</c:if>
