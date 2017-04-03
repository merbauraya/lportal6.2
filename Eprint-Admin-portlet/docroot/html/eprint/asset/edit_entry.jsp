<%@include file="/html/eprint/init.jsp" %>
<liferay-ui:asset-tags-error />
<%
	String eprintId = request.getParameter("eprintId");
	
	Eprint eprint = EprintLocalServiceUtil.fetchEprint(Long.parseLong(eprintId));
	String eprintUrl = null;
	if (Validator.isNotNull(eprint))
	{
		//eprintUrl = eprintConfig.getEprintURL() + eprint.getEprintId();
		com.liferay.portal.util.PortalUtil.setPageTitle("Update- "+ eprint.getTitle(), request); 
	}
	

	PortletURL updateEntryUrl = renderResponse.createActionURL();
	updateEntryUrl.setParameter(ActionRequest.ACTION_NAME, "updateEntry");

%>

<form action="<%=updateEntryUrl.toString() %>" method="post" class="form-horizontal" name="<portlet:namespace />configuration">
	<aui:model-context bean="<%= eprint %>" model="<%= Eprint.class %>" />
	<input type="hidden" name="eprintId" value="<%=eprintId %>">
	<div class="form-group">
    	<label for="title" class="col-sm-2 control-label">Title</label>
    	<div class="col-sm-10">
      		<input type="text" class="form-control" id="title" name="title" value ="<%= eprint.getTitle()%>" placeholder="Title">
    	</div>
  	</div>
  <div class="form-group">
    	<label for="abstract" class="col-sm-2 control-label">Abstract</label>
    	<div class="col-sm-10">
      		<textarea class="form-control" id="abstract" name="abstract" rows="10" placeholder="Abstract"><%= eprint.getEprintAbstract() %></textarea>
    	</div>
  	</div>
  	 <div class="form-group">
  	 	<label for="keywords" class="col-sm-2 control-label"></label>
  	 		<div class="col-sm-10">
    	 		<aui:input name="tags" type="assetTags" />
    	 		
    	 		
    	 		
    	 	</div>
  	</div>
  	 <div class="form-group">
  	 	<label for="keywords" class="col-sm-2 control-label">Related Assets</label>
  	 		<div class="col-sm-10">
    	 		
				<liferay-ui:input-asset-links
					assetEntryId="<%= eprint.getEprintId() %>"
					className="<%= Eprint.class.getName() %>"
					classPK="<%= eprint.getEprintId() %>"
				/>
			
    	 		
    	 		
    	 		
    	 	</div>
  	</div>
 	<div class="form-group">
    	<label for="keywords" class="col-sm-2 control-label">Keywords</label>
    	<div class="col-sm-10">
      		<input type="text" class="form-control" id="keywords" name="abstract" placeholder="Abstract" value="<%= eprint.getEprintKeywords() %>" >
    	</div>
    	
  	</div>
  	
  	<div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Save</button>
    </div>
    
   
</form>

 