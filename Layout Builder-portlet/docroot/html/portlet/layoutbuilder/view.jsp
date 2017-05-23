<%@include file="/html/portlet/layoutbuilder/init.jsp"%>
<!-- 
  @author vipin.bardia
  @email bardia.vipin@gmail.com
 -->
<portlet:resourceURL var="exportForms" id="exportLayout">
</portlet:resourceURL>
<input type="hidden" id="exportForms" value="${exportForms }" />
<input type="hidden" id="elCanvasicon" value="" />

		<div style="">
			<div id="layoutParent" style="width:600px;height:610px;display:inline;outline: 5px solid #427ead;float: left;" class="">
				<div id="row-1" class="row-class" style="height:100%">
					<input type="hidden" class="column-count" value="1" />
				</div>
			</div>
		</div>
		<div id="layoutTools" class="layout-partition">
			<div>
				<div style="float:left;">
					<div >
						<img class="img-class" id="columnImg" src="<%=renderRequest.getContextPath() %>/images/icons/table-column_128-48.png" alt="Drag me to container for New Column" title="Drag me to container for New Column" />
					</div>
					<div>
						<img class="img-class" id="rowImg" src="<%=renderRequest.getContextPath() %>/images/icons/table-row_128-48.png" alt="Drag me to container for New Row" title="Drag me to container for New Row"  />
					</div>
				</div>	
				<div id="iconImage" class="iconImage">
					
				</div>
			</div>
			<div class="property-container">
				<div class="margin-10">
					<label>Layout Name</label>
					<input type="text" id="elLayoutName" value="" />
				</div>
				<div>
					<input type="checkbox" id="bootstrap" value="true" />
					<label for="bootstrap" style="display:inline-block;">Bootstrap Layout</label>
					<liferay-ui:icon-help message="Bootstrap layout is divided in 12 spans." />
				</div>
				<div style="border-top:3px solid #427ead">
					<label>Container Classes</label>
					<input type="text" class="text-css" name="containerCss" id="containerCss" value=""/>			
					<liferay-ui:icon-help message="Add classes to main-content. To separate classes use space." />	
				</div>
				<div>
					<label>Row Classes</label>
					<input type="text" class="text-css" name="rowCss" id="rowCss" value=""/>
					<liferay-ui:icon-help message="Add classes per row basis. To separate classes use space." />	
				</div>
				<div>
					<label>Column Classes</label>
					<input type="text" class="text-css" name="columnCss" id="columnCss" value=""/>
					<liferay-ui:icon-help message="Add classes per coulmn basis. To separate classes use space." />	
				</div>
				<div>
					<select id="porltetDropDown" style="width:170px;">
						<option value="-1" selected>Portlet List</option>
						<c:forEach items="${portletList }" var="portlets">
							<option value="<%=PortalUtil.getPortletNamespace(((Portlet)pageContext.getAttribute("portlets")).getPortletId())%>##${portlets.instanceable}">
								<%= PortalUtil.getPortletTitle((Portlet)pageContext.getAttribute("portlets"), application,locale)%>
							</option>
						</c:forEach>
					</select>
					
					<input type="checkbox" id="border" value="border" />
					<label for="border"  style="display:inline-block;">No Border</label>
				</div>				
				<div class="margin-10">
					<input type="button" value="Add Properties" onclick="addClasses()" />
				</div>
			</div>
			<div class="clear control-bar">
				<div>
					<input type="button" value="Reset" onclick="resetLayout()" />
					<input type="button" value="Preview" style="margin-left: 20px;" onclick="previewLayout()" />
				</div>
				<div>
					<input type="button" value="Create Layout" onclick="generateWar()" />
					<%
					if(themeDisplay.getLayout().getGroup().getName().equals(GroupConstants.CONTROL_PANEL)){
					%>
						<input type="button" value="Install Layout" style="margin-left: 20px;" onclick="installFile()" />
					<% } %>
				</div>
			</div>
		</div>
		
		<div id="dialog-confirm" style="display:none;height: 50px !important;" title="Form will be reset!">	
			<p>
				<span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>
				This form will be reset after this action, you have to start from scratch!
			</p>		
		</div>
		<div id="setContent" style="display:none;">
			<div class="" id="main-content-copy" role="main" >					
			</div>						
		</div>	
		<textarea id="previewHtml" style="display:none;	width:600px;height:300px;margin-top: 20px;"></textarea>
		
		<div id="preparing-file-modal" title="Preparing war..." style="display: none;">
    		Your download is in progress...
 
		    <!--Throw what you'd like for a progress indicator below-->
		    <div class="ui-progressbar-value ui-corner-left ui-corner-right" style="width: 100%; height:22px; margin-top: 20px;"></div>
		</div>
		 
		<div id="error-modal" title="Error" style="display: none;">
		    There was a problem generating your layout, please try again.
		</div>