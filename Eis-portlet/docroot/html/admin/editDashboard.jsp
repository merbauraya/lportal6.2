<%@ include file="/html/init.jsp" %>

<style>
.dbcontainer
{
 background-color: #F7F7F7;
  
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


</style>


<aui:row>
	<aui:col span="3">
		 <div class="eisSidebar">
		 <liferay-ui:panel collapsible="<%= true%>" extended="<%= true%>" title="summary">
		 	<ul class="nav nav-list" id="summaryBoxList">
		 		<li class="portlet-item" id="box-visitor">Pengunjung</li>
		 		<li class="portlet-item" id="box-seating">Tempat Duduk</li>
		 		<li class="portlet-item" id="box-loan">Pinjaman</li>
		 		<li class="portlet-item" id="box-membership">Ahli Perpustakaan</li>
		 		<li class="portlet-item" id="box-printedItem">Bahan Bercetak</li>
		 		<li class="portlet-item" id="box-nonPrintedItem">Bahan Bukan Bercetak</li>
		 		<li class="portlet-item" id="box-irItem">Harta Intelek</li>
		 		<li class="portlet-item" id="box-position">Perjawatan</li>
		 		<li class="portlet-item" id="box-expense">Perbelanjaan</li>
		 		<li class="portlet-item" id="box-consultation">Konsultasi</li>
		 	</ul>
	 	</liferay-ui:panel>
	 	 <liferay-ui:panel collapsible="<%= true%>" extended="<%= true%>" title="info">
		 	<ul class="nav nav-list" id="infoBoxList">
		 		<li class="portlet-item" id="info-library">Perpustakaan</li>
		 		<li class="portlet-item" id="info-stat">Statistik</li>
		 		
		 	</ul>
		 	
		 	
		 </liferay-ui:panel>
		 
         
      </div>
	</aui:col>
	<aui:col span="9">
		<div id="mySortableLayout">
			<h2> Dashboard Title</h2>
			<aui:row>
				<aui:col span="3" cssClass="dbContainer">
				</aui:col>
				<aui:col span="3" cssClass="dbContainer">
				</aui:col>
				<aui:col span="3" cssClass="dbContainer">
				</aui:col>
				<aui:col span="3" cssClass="dbContainer">
				</aui:col>
			
			</aui:row>
			
		</div>
	</aui:col>

</aui:row>

 
   
   

<div class="clearfix"></div>





<aui:script>
	var NEW_PORTLET_TPL = '<div class="portlet" id="{id}"> \
	<a class="removeDB pull-right" href="javascript:;"> \
	<i class="fa fa-close" accessKey="remove"></i> \
	</a> \
	<div class="titleCont"> \
	<div class="ptitle">{title}</div> \
	</div>\
	<img class="img-class" src="<%=renderRequest.getContextPath() %>/img/{IMG}"> \
	</div>'

AUI().use(
		  'aui-sortable-layout',
		  function(A) {
		    var proxyNode = A.Node.create('<div class="sm-st-drag sortable-layout-proxy"></div>');
		    var DDM = A.DD.DDM;

		    var sortableLayout = new A.SortableLayout(
		      {
		        dragNodes: '.portlet',
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
		        
		        console.log(boxId);
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
		        console.log(portletList);
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
			var portlet = e.target.ancestor('.portlet');
			portlet.remove();
			
			//console.log(portlet);
			var id = e.target.getAttribute("data-primkey");
			
			
			
			
			
			
		});
	var portletNode = A.all(".portlet");
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
	var portlet = A.all('.portlet');
	
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
						var portlet = e.target.ancestor('.portlet');
						
						
						var porletId = portlet.get('id');
						console.log('ID='+porletId);
						var portletText = portlet.one(".ptitle").html();
						
						var sumBoxParent;
						if (portlet.hasClass('sm-st')) //summary box
						{
							console.log(porletId +' removed lah');
							sumBoxParent = A.one('#summaryBoxList');
							
						} else //info box
						{
							sumBoxParent = A.one('#infoBoxList');
						}
						var newBox = portletId;
						
						sumBoxParent.append('<li class="portlet-item" id="' + portlet.get('id') + '">' + portletText + '</li>');
						portlet.remove();
					}
					
					if (e.target.getAttribute('className') == 'ptitle')
					{
						var prevVal = e.target.html();
						var titleCont = e.target.ancestor(".titleCont");
						var inputNode = INP_TPL.replace("{0}",prevVal);
						titleCont.append(inputNode);
						e.target.addClass("hide");
					}
						
				}
				if (e.target && e.target.get('type') == 'button')
				{
					var portlet = e.target.ancestor('.portlet');
					
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
				

				
				
				
				
				
				
			});
	
	portlet.on('clickoutside', function (e) {
	  
	    var inlineEdit = e.currentTarget.one('.add-page-editor');
	    if (inlineEdit)
    	{
	    	
	    	e.currentTarget.one('.ptitle').removeClass('hide');
	    	inlineEdit.remove();
    	}
	});
	
	
	Liferay.provide(
			window,
			'updateLabel',
			function(e) {
				console.log(e);
				
			},
			['liferay-util-list-fields']
	);

</aui:script>