<%@ include file="/html/taglib/eis/init.jsp" %>


<%
	
	int value = ((Integer)request.getAttribute("eis:month-selector:value"));
	
	

	String controlName =(String)request.getAttribute("eis:month-selector:controlName");
	if (Validator.isNull(controlName))
	{
		controlName = "month";
	}
	 


%>


	
	<aui:select name="<%= controlName %>">
	<%
	    	//Calendar tzCal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kuala_Lumpur"));  
		 	//		 	Locale malaysianLocale = new Locale("ms", "MY");
			List<String> monthsList = new ArrayList<String>();
    		String[] months = new DateFormatSymbols().getMonths();
    		
    		boolean nullSelected = value < 0 ? true : false;
    		for (int i = 0; i < months.length-1; i++) {
    			boolean selected = value == i+1 ? true : false;
    			
		%>
			<aui:option 
				selected="<%= selected %>" 
				value="<%= i+1 %>"><%= months[i] %>
			</aui:option> 
		<%	
			
			}
	 
		 	
		%>
		
		<aui:option  value="-20" selected="<%=nullSelected %>">
		
		</aui:option>
	
	</aui:select>


