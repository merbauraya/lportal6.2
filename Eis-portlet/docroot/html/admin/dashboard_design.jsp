<%@ include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.json.JSONArray" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactory" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%
	List<Config> infoBoxes = ConfigLocalServiceUtil.findWithKeyWildcard(EisUtil.EIS_INFO_BOX,QueryUtil.ALL_POS,QueryUtil.ALL_POS);
	List<Report> reports = ReportLocalServiceUtil.findMainReport();// .getReports(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	
	
	
	String layoutSettingString = ConfigLocalServiceUtil.getByKeyAsString(EisUtil.EIS_DASHBOARD_LAYOUT);

	JSONArray settingArray = JSONFactoryUtil.createJSONArray(layoutSettingString);
	JSONArray sumArray = JSONFactoryUtil.createJSONArray();
	JSONArray infoArray = JSONFactoryUtil.createJSONArray();
	JSONArray boxArray = JSONFactoryUtil.createJSONArray();
	JSONObject layoutSetting = JSONFactoryUtil.createJSONObject();
	
	int infoColCount = 0;
	if (settingArray.length() > 0)
	{
		layoutSetting = settingArray.getJSONObject(0);
		//out.print(layoutSetting.getInt("sumColSize"));
		infoColCount = layoutSetting.getInt("infoColSize");
		sumArray = settingArray.getJSONObject(1).getJSONArray("summaryBox");
		infoArray = settingArray.getJSONObject(2).getJSONArray("infoBox");
	}
	
	if (infoColCount == 0)
	{
		infoColCount = 3;
	}
	
	
	
	
	
	JSONArray sumBox = JSONFactoryUtil.createJSONArray();
	JSONArray infoBoxArray = JSONFactoryUtil.createJSONArray();
	
%>

<style>
.dbContainer
{
/* background-color: #F7F7F7; */
 border-right: 1px dashed #808080;
  
}
#mySortableLayout h2
{
	text-align:center;
}
#mySortableLayout
{
	border : 2px solid;
	padding: 10px;
	
	
}
.portlet-item
{
	border: 1px solid grey;
	margin-bottom: 5px;
	padding : 3px;
}
.info-st
{
	border:2px groove;
}
.info-st .ptitle
{
	text-align:center;
}
.portlet-box
{
	padding: 0;
	min-height:140px;
}
.ptitle
{
	font-weight:bold;
	font-size:smaller;
	padding: 5px;
}
.boxPlaceHolder
{
	border-style:dashed;
	border-width:1px;
	border-color: #808080;
	
}

</style>

<portlet:actionURL var="editURL" name="editDashboard">
	
</portlet:actionURL>

<aui:form name="fm" method="post" action="<%=editURL %>" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "submitForm();" %>'>

<aui:row>
	<aui:col span="3">
		 <div class="eisSidebar">
		 <liferay-ui:panel collapsible="<%= true%>" extended="<%= true%>" title="summary">
		 	<ul class="nav nav-list" id="summaryBoxList">
		 	<%
		 		for (Report report: reports)
		 		{
		 			String reportId = "box-" + report.getReportKey();
		 			boolean add = true;
		 			for (int i = 0 ; i < sumArray.length(); i++)
		 			{
		 				String itemKey = sumArray.getJSONObject(i).getString("id");
		 				if (itemKey.equals(reportId))
		 				{
		 					add = false;
		 				}
		 			}
		 	%>
		 		<c:if test="<%= add %>">
		 			<li class="portlet-item" id="<%= reportId %>"><%= report.getReportTitle() %></li>
		 		</c:if>
		 	<%
		 		}
		 	%>
		 		
		 	</ul>
	 	</liferay-ui:panel>
	 	 <liferay-ui:panel collapsible="<%= true%>" extended="<%= true%>" title="info">
	 	 	<aui:input name="infoColumnCount" value="3" type="hidden" />
	 	 	<!-- 
	 	 	<aui:select name="infoColumnCount" label="total-column" onChange='<%= renderResponse.getNamespace() + "updateInfoLayout();"%>'>
	 	 		<aui:option value="3" selected="<%= infoColCount == 3 %>">3</aui:option>
	 	 		<aui:option value="4" selected="<%= infoColCount == 4 %>">4</aui:option>
	 	 	</aui:select>
	 	 	-->
		 	<ul class="nav nav-list" id="infoBoxList">
		 		<%
		 			for (Config infoBox : infoBoxes)
		 			{
		 				boolean add = true;
		 				String infoBoxId = "info-" + infoBox.getId();
		 				for (int i = 0; i < infoArray.length(); i++)
		 				{
		 					String itemKey = infoArray.getJSONObject(i).getString("id");
		 					if (itemKey.equals(infoBoxId))
		 					{
		 						add = false;
		 					}
		 				}
		 				
		 		%>
		 		<c:if test="<%= add %>">
		 			<li class="portlet-item" id="<%= infoBoxId %>"><%= infoBox.getTitle() %></li>
		 		</c:if>
		 		
		 		<%
		 			}
		 		%>
		 		
		 		
		 	</ul>
		 	
		 	
		 </liferay-ui:panel>
		 
         <aui:button-row>
			
			<aui:button type="submit"></aui:button>
	</aui:button-row>
      </div>
	</aui:col>
	<aui:col span="9">
		<div id="mySortableLayout">
			<h2> Dashboard Title</h2>
			<aui:row id="sumContainer" cssClass="sumContainer boxPlaceHolder">
			<%
			int curSumItem = 0;
			String type="sumBox";
			boxArray = sumArray;
			%>
				<aui:col span="3" cssClass="dbContainer">
					<%@ include file="/html/admin/drawDashboard.jspf" %> 		
				</aui:col>
			
				
				<aui:col span="3" cssClass="dbContainer">
					<%@ include file="/html/admin/drawDashboard.jspf" %> 	
				</aui:col>
				<aui:col span="3" cssClass="dbContainer">
					<%@ include file="/html/admin/drawDashboard.jspf" %> 	
				</aui:col>
				<aui:col span="3" cssClass="dbContainer">
					<%@ include file="/html/admin/drawDashboard.jspf" %> 
				</aui:col>
			
			</aui:row>
			<aui:row>
				
				<p class="text-center">Information Container</p>
			</aui:row>
			<aui:row id="infoContainer" cssClass="infoContainer boxPlaceHolder">
				<%
				int curSumItem = 0;
				String type="infoBox";
				boxArray = infoArray;
				%>
				<aui:col span="4" cssClass="dbContainer">
					<%@ include file="/html/admin/drawDashboard.jspf" %> 
				</aui:col>
				<aui:col span="4" cssClass="dbContainer">
					<%@ include file="/html/admin/drawDashboard.jspf" %> 
				</aui:col>
				<aui:col span="4" cssClass="dbContainer">
					<%@ include file="/html/admin/drawDashboard.jspf" %> 
				</aui:col>
				
			</aui:row>
			
		</div>
	</aui:col>
	<aui:button-row>
			
			<aui:button type="submit"></aui:button>
	</aui:button-row>
</aui:row>
	<aui:input type="hidden" name="layoutSetting" />
</aui:form>
   
   

<div class="clearfix"></div>





<aui:script>
	var NEW_PORTLET_TPL = '<div class="portlet-box" id="{id}"> \
	<a class="removeDB pull-right" href="javascript:;"> \
	<i class="icon-remove" accessKey="remove"></i> \
	</a> \
	<div class="titleCont"> \
	<div class="ptitle">{title}</div> \
	</div>\
	<img class="center" src="<%=renderRequest.getContextPath() %>/img/{IMG}"> \
	</div>'

AUI().use(
		  'aui-sortable-layout',
		  function(A) {
		    var proxyNode = A.Node.create('<div class="sm-st-drag sortable-layout-proxy"></div>');
		    var DDM = A.DD.DDM;

		    var sortableLayout = new A.SortableLayout(
		      {
		        dragNodes: '.portlet-box',
		        dropContainer: '#mySortableLayout',
		        proxyNode: proxyNode,
		        dropNodes : '.dbContainer'
		        
		      }
		    );

		    //Create new constructor for Portlet adding widget
		    var PortletItem = function() {
		      PortletItem.superclass.constructor.apply(this, arguments);
		    };

		    PortletItem.NAME = 'PortletItem';
		    PortletItem.ATTRS = {
		      dd: {
		        value: false
		      },
		      delegateConfig: {
		        value: {
		          nodes: '.portlet-item',
		          target: false
		        }
		      },
		      itemContainer: {
		        value: '.eisSidebar'
		      },
		      proxyNode: {
		        value: proxyNode
		      }
		    };

		    //Extend widget to clone itself when dragged
		    //var color = '';
		    var boxId = '';
		    var type = '';
		    A.extend(
		      PortletItem,
		      A.SortableLayout,
		      {
		        _getAppendNode: function() {
		          var instance = this;
		          instance.appendNode = DDM.activeDrag.get('node').clone();
		          
		          boxId = instance.appendNode.get('id');
		         // boxId = boxId.split("-").pop();
		          type = instance.appendNode.get('accessKey');
		          

		          return instance.appendNode;
		        }
		      }
		    );

		    var portletList = new PortletItem();

		    //Create new node which replaces clone and add drop plugin to new node
		    var livePortlet;
		    portletList.on(
		      'drag:end',
		      function(event) {
		    	  //console.log(event.target);
		    	  var sourceBox = A.one("#"+ boxId);
		    	  
		          var title = sourceBox.text();
		        var str = NEW_PORTLET_TPL.replace('{id}',boxId);
		        
		        //console.log(boxId);
		        str = str.replace('{title}',title);
		        var newPortlet;
		        
		        if (boxId.startsWith("box-")) //summary box
		        {
		        	str = str.replace('{IMG}','db-figure.png');
		        	newPortlet = A.Node.create(str);
		        	newPortlet.addClass('sm-st');
		        	
		        	
		        } else
		        {
		        	str = str.replace('{IMG}','info-figure.png');
		        	newPortlet = A.Node.create(str);
		        	newPortlet.addClass('info-st');
		        	
		        }
		        
		        var dropConfig = {
		          bubbleTargets: this,
		          useShim: false
		        };
		        if (sourceBox)
	        	  {
	        	  	sourceBox.remove();
	        	  }
		        
		        var curNode = portletList.get('id');
		        //console.log(portletList);
		        if (portletList.appendNode && portletList.appendNode.inDoc()) {
		          portletList.appendNode.replace(newPortlet);
		          var livePortlet = A.one('#' + boxId);
		          livePortlet.plug(A.Plugin.Drop, dropConfig);
		          livePortlet.drop.set('groups', ['portal-layoutx']);
		          
		          
		         
		          
		        }
		      }
		    );
		  }
		);

</aui:script>
<portlet:actionURL var="editDbBoxTitleURL" name="editDbBoxTitle">   

</portlet:actionURL>

<aui:script use="aui-base,liferay-layout,aui-io-request,event,node-event-simulate">
var INP_TPL = '<div class="add-page-editor" > \
	<div class="input-append toolbar-content component toolbar toolbar-focused"> \
	<input class="add-page-editor-input inline-input" type="text" value="{0}" /> \
	<button type="button" onclick="updateLabel(this);" class="btn btn-content" title="Save"> <i class="icon-ok"></i> \
	</button></div></div>';
	
var TPL_FIELD_INPUT = '<input class="add-page-editor-input" type="text" value="{0}" />';
var closeDB = A.all('.removeDB');

	closeDB.on(
		'click',
		function(e) {
			//console.log(e);
			var portlet = e.target.ancestor('.portlet-box');
			portlet.remove();
			
			//console.log(portlet);
			var id = e.target.getAttribute("data-primkey");
			
			
			
			
			
			
		});
	var portletNode = A.all(".portlet-box");
	var portletTitle = portletNode.one(".ptitle");
	if (portletTitle)
	{
		portletTitle.swallowEvent('click');	
	}

	
	var pTitles = A.all(".ptitle");
	pTitles.on(
			'click',
			function(e) {
				var prevVal = e.target.html();
				var titleCont = e.target.ancestor(".titleCont");
				var inputNode = INP_TPL.replace("{0}",prevVal);
				titleCont.append(inputNode);
				e.target.addClass("hide");
				
				
				
				
				
				
			});
	var portlet = A.one('#mySortableLayout');
	
	
	portlet.on(
			'click',
			function(e) {
				
				if (e.target != null)
				{
					//console.log(e.target.getAttribute('className'));
					if (e.target.get('accessKey') == 'remove')
					{
						
						var closeDB = e.target.ancestor('.removeDB');
						
						closeDB.simulate('click');
						var portlet = e.target.ancestor('.portlet-box');
						
						
						var porletId = portlet.get('id');
						//console.log('ID='+porletId);
						var portletText = portlet.one(".ptitle").html();
						
						var sumBoxParent;
						if (portlet.hasClass('sm-st')) //summary box
						{
							//console.log(porletId +' removed lah');
							sumBoxParent = A.one('#summaryBoxList');
							
						} else //info box
						{
							sumBoxParent = A.one('#infoBoxList');
						}
						//var newBox = portletId;
						
						sumBoxParent.append('<li class="portlet-item" id="' + portlet.get('id') + '">' + portletText + '</li>');
						portlet.remove();
					}
					
					/*
					if (e.target.getAttribute('className') == 'ptitle')
					{
						var prevVal = e.target.html();
						var titleCont = e.target.ancestor(".titleCont");
						var inputNode = INP_TPL.replace("{0}",prevVal);
						titleCont.append(inputNode);
						e.target.addClass("hide");
					}
					*/	
				}
				/*
				if (e.target && e.target.get('type') == 'button')
				{
					var portlet = e.target.ancestor('.portlet-box');
					
					var portletId = e.currentTarget.get('id');
					var title = portlet.one('.inline-input').get('value');
					//console.log(portletId + ":" + title);
					var ptitle = portlet.one('.ptitle')
					
					ptitle.html(title);
					//console.log(title);
					A.io.request(
				           '<%=editDbBoxTitleURL.toString()%> ',
				            {
				                method: 'POST',
				                data :{
				                	<portlet:namespace/>boxId: portletId,
				                	<portlet:namespace/>boxTitle : title
				                },
				                
				                on: {
				                    success: function() {
				                    	
				                        
				                    }
				                }
				            }
				        );
					e.currentTarget.one('.add-page-editor').remove();
					ptitle.removeClass('hide');
					
					
				}
				*/

				
				
				
				
				
				
			});
	
Liferay.provide(
	    window,
	    '<portlet:namespace />submitForm',
	    function() 
{
	    	var layoutContainer = A.one('#mySortableLayout');
	    	
	    	var sumBoxes = layoutContainer.all('#<portlet:namespace/>sumContainer .portlet-box');
	    	
	    	var infoBoxes = layoutContainer.all('#<portlet:namespace/>infoContainer .portlet-box');
	    	
	    	var summaryItems = [];
	    	
	    	sumBoxes.each(function()
    			{
	    		var item = {id:this.get("id"),"x":this.getX(),"y":this.getY(),"title":this.one(".ptitle").html()};
	    		summaryItems.push(item);
    		
    			});
	    	console.log(summaryItems);
    		var infoItems = [];
	    	infoBoxes.each(function()
    			{
	    		var item = {id:this.get("id"),"x":this.getX(),"y":this.getY(),title:this.one(".ptitle").html()};
	    		infoItems.push(item);
    		
    			});
	     
    	  var layout = {};
    	  layout.sumColSize = 4;
    	  layout.infoColSize = 3;
		 
    	  summaryItems.sort(function(a, b) {
		  //sort by x, secondary by y
		 	 //return a.x == b.x ? a.y - b.y : a.x - b.x;
		 		return a.x == b.x ? a.y - b.y : a.x - b.x;
			});
    	  
    	  infoItems.sort(function(a, b) {
    		  //sort by x, secondary by y
    		 	 //return a.x == b.x ? a.y - b.y : a.x - b.x;
    		 		return a.x == b.x ? a.y - b.y : a.x - b.x;
    			});
	    	
	    	var dashboard = [];
	    	
	    	dashboard.push(layout);
	    
	    	
	    	dashboard.push({"summaryBox" : sortLayout(summaryItems)});
	    	dashboard.push({"infoBox" : sortLayout(infoItems)});
	    	
	    	
	    	
	    	
	    	console.log(dashboard);
	    
	      
	   
	      document.<portlet:namespace />fm.<portlet:namespace />layoutSetting.value =  JSON.stringify(dashboard);
  		 submitForm(document.<portlet:namespace />fm);

});

function sortLayout(items)
{
	var itemsArray = [];
	for (var i = 0; i < items.length; i++) {

		  //check if was already added
		  if (typeof(items[i].wasAdded) == "undefined") {
			  itemsArray.push(items[i]);
		    items[i].wasAdded = "true";

		    for (j = i + 1; j < items.length; j++) {
		      if (items[i].x > items[j].x && typeof(items[j].wasAdded) == "undefined") {
		    	  itemsArray.push(items[j]);
		        items[j].wasAdded = "true";
		      }
		    }
		  }
		}
	
	//console.log(itemsArray);
	return itemsArray;
	
}



Liferay.provide(
	    window,
	    '<portlet:namespace />updateInfoLayout',
	    function() {

	        var A = AUI();

	        var infoSelect = A.one('#<portlet:namespace />infoColumnCount');
	        console.log(infoSelect);
	        var column = infoSelect.get('value');
			var infoContainer = A.one('#<portlet:namespace />infoContainer');
	        var dbContainer = infoContainer.all('.dbContainer');
	        
	        //reset all span
	        var spanSize = 12 /column;
			dbContainer.removeClass('span6').removeClass('span3').removeClass('span4').addClass('span'+ spanSize);
			/*
			if (dbContainer.length < column)
			{
				dbContainer.append('<div class="dbContainer yui3-dd-drop span"' + spanSize + '"></div>"' );
			}
			*/
	        // selecting the sourceSelect drop-down to get the current value
	       // var sourceElement = A.one("#<portlet:namespace />subject");

	        // selecting the targetSelect drop-down to populate values
	        //var targetElement = A.one("#<portlet:namespace />topic");

	       
	    });
</aui:script>