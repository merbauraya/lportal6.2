<%@ include file="/html/init.jsp" %>

<%
	String type = ParamUtil.getString(request, "type");
	String id = ParamUtil.getString(request, "id");
	String title = ParamUtil.getString(request, "title");
	out.print(type);
	out.print(id);
%>

<c:if test="<%= type.equalsIgnoreCase(\"infoBox\") %>">

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
IN DRAW