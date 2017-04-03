<%@ include file="/html/taglib/eis/init.jsp" %>
<%@ page import="java.lang.reflect.Method" %>
<%@ page import="java.lang.reflect.Array" %>

<%
	
	
	long value = GetterUtil.getLong((String) request.getAttribute("eis:library-selector:value"));
	boolean adminAllowAll = GetterUtil.getBoolean((String) request.getAttribute("eis:library-selector:adminAllowAll"));
	boolean addAllOption = GetterUtil.getBoolean((String) request.getAttribute("eis:library-selector:addAllOption"));

	String controlName =(String)request.getAttribute("eis:library-selector:name");
	
	boolean isAdmin  = permissionChecker.isOmniadmin() || permissionChecker.isGroupAdmin(themeDisplay.getScopeGroupId());
		
	List<?> userLibraries = null;
	
	if (adminAllowAll && isAdmin)
	{
		Object libraryService  = (Object)PortletBeanLocatorUtil.locate("Eis-portlet","LibraryLocalService");
		
		Method methodGetLibrary = libraryService.getClass().getMethod("getLibraries",new Class[]{int.class,int.class});

		userLibraries = (List<?>) methodGetLibrary.invoke(libraryService,QueryUtil.ALL_POS,QueryUtil.ALL_POS);

	}else
	{
		Object userLibraryService  = (Object)PortletBeanLocatorUtil.locate("Eis-portlet","UserLibraryLocalService");
			
		Method methodGetLibraryByUser = userLibraryService.getClass().getMethod("getLibraryByUser",new Class[]{long.class});

		userLibraries = (List<?>) methodGetLibraryByUser.invoke(userLibraryService,themeDisplay.getUserId());

	}
	
	
	Class type = userLibraries.getClass();
	
	Object libraryList = null; 
	
	

%>


	
	<aui:select cssClass="library-selector" name="<%= controlName %>">
	<%	
		if (addAllOption)
		{
	%>
			<aui:option selected="<%= value == 0 %>" label="<%= StringPool.BLANK %>" value="<%= 0 %>" />
						
	<%		
		}
	
		for (Object library :  userLibraries)
		{
			
			
			String libraryName = (String)library.getClass().getMethod("getLibraryName", null).invoke(library);
			long libraryId = (Long)library.getClass().getMethod("getLibraryId", null).invoke(library);
			

			boolean selected = false;
			if (libraryId == value)
			{
				selected = true;
			}
			
	%>
			<aui:option selected="<%= selected %>" label="<%= libraryName %>" value="<%= libraryId %>" />
			
	
			
		<%	
			
		}
	
		 	
		%>
		
		
	
	</aui:select>

