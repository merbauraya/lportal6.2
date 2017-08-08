<%@ include file="/html/taglib/eis/init.jsp" %>
<%@ page import="java.lang.reflect.Method" %>
<%@ page import="java.lang.reflect.Array" %>

<%
	
	
	long value = GetterUtil.getLong((String) request.getAttribute("eis:library-selector2:value"));
	boolean adminAllowAll = GetterUtil.getBoolean((String) request.getAttribute("eis:library-selector2:adminAllowAll"));
	boolean addAllOption = GetterUtil.getBoolean((String) request.getAttribute("eis:library-selector2:addAllOption"));

	String controlName =(String)request.getAttribute("eis:library-selector2:name");
	String cssClass = ((String)request.getAttribute("eis:library-selector2:cssClass"));
	
	boolean isAdmin  = permissionChecker.isOmniadmin() || permissionChecker.isGroupAdmin(themeDisplay.getScopeGroupId());
		
	List<?> userLibraries = null;
	
	if (adminAllowAll && isAdmin)
	{
		Object libraryService  = (Object)PortletBeanLocatorUtil.locate("Eis-portlet","LibraryLocalService");
		Object masterFileService = (Object)PortletBeanLocatorUtil.locate("Eis-portlet","MasterFileLocalService");
		
		Method methodGetLibrary = masterFileService.getClass().getMethod("getAllLibraries",null);

		userLibraries = (List<?>) methodGetLibrary.invoke(masterFileService);

	}else
	{
		Object userLibraryService  = (Object)PortletBeanLocatorUtil.locate("Eis-portlet","UserLibraryLocalService");
			
		Method methodGetLibraryByUser = userLibraryService.getClass().getMethod("getLibraryByUser2",new Class[]{long.class});

		userLibraries = (List<?>) methodGetLibraryByUser.invoke(userLibraryService,themeDisplay.getUserId());

	}
	
	
	Class type = userLibraries.getClass();
	
	Object libraryList = null; 
	
	
	cssClass = cssClass + " library-selector";
%>

 
	
	<aui:select name="<%= controlName %>" cssClass="<%= cssClass %>">
	<%	
		if (addAllOption)
		{
	%>
			<aui:option selected="<%= value == 0 %>" label="<%= StringPool.BLANK %>" value="<%= 0 %>" />
						
	<%		
		}
	
		for (Object library :  userLibraries)
		{
			
			
			String libraryName = (String)library.getClass().getMethod("getMasterFileName", null).invoke(library);
			long libraryId = (Long)library.getClass().getMethod("getMasterFileId", null).invoke(library);
			

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

