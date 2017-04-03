<%@ include file="/html/taglib/eis/init.jsp" %>


<%
	
	int status = ((Integer)request.getAttribute("eis:status-display:status"));
	int progress = ((Integer)request.getAttribute("eis:status-display:progress"));
	
	String statusColor = StringPool.BLANK;
	switch (status)
	{
	case 0:
		statusColor = " status-blue ";
		break;
	
		case 1: 
			statusColor = " status-red ";
   			 break;
   			 
		case 2: statusColor = " status-yellow ";
			break;
			
		case 3: statusColor = " status-green ";
			break;
			
		default: statusColor = "";
			break;
   			 
		
	}
	
	
	String progressStr = "&nbsp;" + progress + "&nbsp;";
	if (progress > 9 )
	{
		progressStr = "&nbsp;" + progress ;
	}

%>
	<span class="badge <%= statusColor %>"><%= progressStr %> </span>

