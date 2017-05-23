/*
 * @author vipin.bardia
 * @email bardia.vipin@gmail.com
 */
var columnId = 1;
var rowId = 2;
var className = "column-class";
var classColumn = "portlet-column";
var classOnlyColumn = "portlet-column-only";
var classFirstColumn = "portlet-column-first";
var classLastColumn = "portlet-column-last";
var classContentOnly = "portlet-column-content-only";
var classContentFirst = "portlet-column-content-first";
var classContentLast = "portlet-column-content-last";
var currentDiv = "col-1";
var rowClasses = "row-class";
var containerClasses= "layout-partition";
var classResizable = "ui-resizable";
var classDroppable = "ui-droppable";
var classSortable = "ui-sortable";
var classSortableHandle="ui-sortable-handle";
var classUiActive="custom-ui-row-active-class";
var classPortletRow="portlet-layout";
var classRowFluid = "row-fluid";
var bootstrapLayout = false;
var maxColumnCount = 20;
var maxWidthCol = 30;
var acceptedPixels = [50,100,150,200,250,300,350,400,450,500,550,600];
var spanLabelPreview = "1";
	
function addColumn(rowId,moveToNext){
	
	if(rowId.indexOf("row") == -1){
		return;
	}
	//console.log("columCount :: " + parseInt($("#" + rowId + " .column-count").val()));
	var columnCount = parseInt($("#" + rowId + " .column-count").val());
	if(columnCount>maxColumnCount){
		alert("You cannot add more than " + maxColumnCount + " columns.");
		return;
	}
	var width = 100;
	
	width = 100/columnCount;
	
	if(typeof moveToNext === "undefined"){
		$('#' + rowId).append(
			$('<div/>')
			.attr("id","col-" + columnId)
			.addClass(className)
		);		
	} else {	
		moveToNext.after(
			$('<div/>')
			.attr("id","col-" + columnId)
			.addClass(className)
		);		
	}
	
	$('#col-' + columnId).append(
		$('<label/>')
		.text(width + "%")
	).append(
		$('<input/>')
		.attr("type", "hidden")
		.addClass("portlet-ids")
		.attr("value", "")
	);
	
	
	var resizeMe = 1;
	var increasedWidth = 0;
	var parentWidth = $("#" + rowId).width();
	
	$( "#" + rowId +" .column-class" ).each(function() {
	    $(this).css("width",width+"%");
	    $("#" + $(this).attr("id") + " label:first-child").text(parseInt(width) + "%");
	    
	    if(resizeMe != columnCount){	    		
	    	$(this).resizable({
				handles: 'e',
	    		minWidth: maxWidthCol,
	    		ghost: true,
	    		start: function( event, ui ) {
					maxResizeWidth = parseInt($(this).width())+(parseInt($(this).next().width())-parseInt($(this).resizable( "option", "minWidth")));
					$(this).resizable( "option", "maxWidth", parseInt(maxResizeWidth));
					increasedWidth = 0;
	    		},
	    		stop: function( event, ui ) {
					$( "#" + rowId +" .column-class" ).each(function( index ) {
						increasedWidth = increasedWidth + $(this).width();
					});
					//console.log( "increasedWidth : " + increasedWidth);
					//console.log( "totalWidth : " + parentWidth);
					var remainingSpace = parentWidth - increasedWidth;
					//console.log( "remaining Width : " + remainingSpace);				
					
					var divTwo = $(this).next();
					//console.log( "divTwo.width() : " + divTwo.width());
	    			var divTwoWidth = remainingSpace + divTwo.width();
	    			divTwo.css('width', divTwoWidth + 'px');					
					divTwo.css('width', parseInt(divTwo.percWidth()) + "%");					
					
					$( "#" + rowId +" .column-class" ).each(function( index ) {
						$(this).css("width",parseInt($(this).percWidth()) + "%");
					});
					
					var containerWidth = $(this).parent().width();
					var calculateWidth = 0;
					$( "#" + rowId +" .column-class" ).each(function( index ) {
						calculateWidth = calculateWidth + $(this).width();
					});
					
					if(containerWidth > calculateWidth){
						var difference = containerWidth - calculateWidth;
						//console.log("difference :: " + difference);
						//console.log("first width :: " + $(this).width());
						$(this).css("width", $(this).width() + difference + "px");
						$(this).css("width", $(this).percWidth() + "%");
					}
					//console.log(calculateWidth);
	    			$( "#" + rowId +" .column-class" ).each(function( index ) {
						$("#" + $(this).attr("id") + " label:first-child").text(parseInt($(this).percWidth()) + "%");
					});
	    			$(this).css('height','100%');
					createIcon();						
	    		},
	    		resize: function() { 
					
	    		  }
	    	});
	    	resizeMe = resizeMe + 1;
	    }
	});		
	
	currentDivAttr(	$('#col-' + columnId));
	setColumnIds();
	setDroppable();
	setCurrentDiv();	
	createIcon();	
	$("#previewHtml").hide();
	
	$("#" + rowId + " .column-count").val(columnCount + 1);	
}

function addRow(currentRow){
	
	var height=100/rowId;
	
	currentRow.after(
			$('<div/>')
			.attr("id", "row-" + rowId)
			.addClass("row-class")
	);
	
	$('#row-' + rowId).append(
		$('<input/>')
		.attr("type", "hidden")
		.addClass("column-count")
		.attr("value", "1")
	);
	$(".row-class").each(function() {
	    $(this).css("height",height+"%");
	});
	
	$(".row-class").last().css("height",$(".row-class").last().height() - (3*rowId));
	$(".row-class").last().css("height",$(".row-class").last().percHeight() + "%");
	
	if($("#bootstrap").is(':checked')){
		addColumnBootstrap("row-" + rowId);
	} else {
		addColumn("row-" + rowId);
	}	
	
	rowId = rowId + 1;	
	$("#previewHtml").hide();
}

function addClasses(){
	$("#" + currentDiv).removeClass().addClass($.trim(className + " " + classDroppable + " " + classResizable + " " + $.trim($("#columnCss").val().replace(classColumn,""))));
	$("#" + currentDiv).parent().removeClass().addClass($.trim(rowClasses + " " + classSortableHandle + " " + classDroppable + " " + $.trim($("#rowCss").val().replace(classPortletRow,""))));
	$("#" + currentDiv).parent().parent().removeClass().addClass($.trim(classSortable + " " + $("#containerCss").val()));
	
	var setPortletIds = $("#porltetDropDown").val();
	var qualifier = "#" + currentDiv + " .portlet-ids";
	if($("#porltetDropDown").val()!='-1' && $("#porltetDropDown").val()!=null){		
		if($("#border").is(':checked')){
			setPortletIds = setPortletIds + "," + $("#border").val();
		} else {
			setPortletIds = setPortletIds + ",";
		}			
	}	else {
		setPortletIds = "";
		$("#border").prop('checked', false);
	}
	$(qualifier).val(setPortletIds);
	$("#previewHtml").hide();
}

function resetLayout(){
	columnId = 1;
	$(".row-class").each(function() {
	    if($(this).attr("id")!="row-1"){
	    	$(this).remove();
	    } else {
	    	$("#row-1 .column-class").each(function() {
	    		$(this).remove();
	    	});
	    	$("#row-1").css('height','100%');
	    	$("#row-1 .column-count").val("1");
			$("#row-1").removeClass().addClass(rowClasses).addClass(classSortableHandle).addClass(classDroppable);
			$("#layoutParent").removeClass().addClass(classSortable);
			$("#columnCss").val('');
			$("#rowCss").val('');
			$("#containerCss").val('');

			if($("#bootstrap").is(':checked')){
				addColumnBootstrap("row-1");
			} else {
				addColumn("row-1");
			}
	    }
	});
	
	rowId = 2;
	createIcon();
	previewLayout();
	$("#previewHtml").hide();
}

$.fn.percWidth = function(){
  return this.outerWidth() / this.parent().outerWidth() * 100;
};

$.fn.percHeight = function(){
  return this.height() / this.parent().height() * 100;
};

function createIcon(){
	$("#iconImage").html($("#layoutParent").html());
	
	$( "#iconImage .column-class" ).each(function() {				
		$(this).css("outline","");		
		$(this).attr("id","");		
		$(this).removeClass().addClass("column-class-copy");
	});
	$("#iconImage label").each(function() {	
		$(this).html($(this).text().replace("%",""));		
		//$(this).parent().css("width",$(this).html()+"%");
	});
	$( "#iconImage .row-class" ).each(function() {
		$(this).removeClass().addClass("border-class-copy");
	});
	
	$("#iconImage").find("input").remove();
}

function deleteColumn(deleteCol){
	var deleteColRowId = deleteCol.parent().attr("id");	
	
	var columnCount = parseInt($("#" + deleteColRowId + " .column-count").val());
	if(columnCount > 2){	

		//Width of this div will be added to next or prev div
		var deletedWidth = deleteCol.width();	
		
		var $closestDiv = deleteCol.next(".column-class");
		if(typeof $closestDiv.attr("id") === "undefined"){
			$closestDiv = deleteCol.prev(".column-class");
		}
		
		$closestDiv.css('width', ($closestDiv.width() + deletedWidth) + 'px');
		$closestDiv.css('width', $closestDiv.percWidth() + '%');
		
		deleteCol.remove();
		
		columnCount = columnCount -2;	
		var width = 100;
		
		width = 100/columnCount;
		
		var resizeMe = 1;
		var increasedWidth = 0;
		var parentWidth = $("#" + deleteColRowId).width();
	
		$( "#" + deleteColRowId +" .column-class" ).each(function() {
			$(this).css("width",width+"%");
			$("#" + $(this).attr("id") + " label:first-child").text(parseInt(width) + "%");
			
			if(resizeMe != columnCount){	    		
				$(this).resizable({
					handles: 'e',
					minWidth: maxWidthCol,
					ghost: true,
					start: function( event, ui ) {
						maxResizeWidth = parseInt($(this).width())+(parseInt($(this).next().width())-parseInt($(this).resizable( "option", "minWidth")));
						$(this).resizable( "option", "maxWidth", parseInt(maxResizeWidth));
						increasedWidth = 0;
					},
					stop: function( event, ui ) {
					$( "#" + deleteColRowId +" .column-class" ).each(function( index ) {
						increasedWidth = increasedWidth + $(this).width();
					});
					//console.log( "increasedWidth : " + increasedWidth);
					//console.log( "totalWidth : " + parentWidth);
					var remainingSpace = parentWidth - increasedWidth;
					//console.log( "remaining Width : " + remainingSpace);				
					
					var divTwo = $(this).next();
					//console.log( "divTwo.width() : " + divTwo.width());
	    			var divTwoWidth = remainingSpace + divTwo.width();
	    			divTwo.css('width', divTwoWidth + 'px');					
					divTwo.css('width', parseInt(divTwo.percWidth()) + "%");					
					
					$( "#" + deleteColRowId +" .column-class" ).each(function( index ) {
						$(this).css("width",parseInt($(this).percWidth()) + "%");
					});
					
					var containerWidth = $(this).parent().width();
					var calculateWidth = 0;
					$( "#" + deleteColRowId +" .column-class" ).each(function( index ) {
						calculateWidth = calculateWidth + $(this).width();
					});
					
					if(containerWidth > calculateWidth){
						var difference = containerWidth - calculateWidth;
						//console.log("difference :: " + difference);
						//console.log("first width :: " + $(this).width());
						$(this).css("width", $(this).width() + difference + "px");
						$(this).css("width", $(this).percWidth() + "%");
					}
					//console.log(calculateWidth);
	    			$( "#" + deleteColRowId +" .column-class" ).each(function( index ) {
						$("#" + $(this).attr("id") + " label:first-child").text(parseInt($(this).percWidth()) + "%");
					});
	    			$(this).css('height','100%');
					createIcon();					
					},
					resize: function() { 	
						
					  }
				});
				resizeMe = resizeMe + 1;
				//console.log("resizeMe :: " + resizeMe);
			} else {
				try{
					$(this).resizable('destroy');
				}catch(err){
				}				
			}
		});	
		
		setColumnIds();	
		setDroppable();
		setCurrentDiv();	
		createIcon();		
		currentDivAttr(	$('#col-1'));
		
		$("#" + deleteColRowId + " .column-count").val(columnCount + 1);	
	} else {
		deleteRow(deleteCol.parent());
	}		
}

function deleteRow(delRow){
	if(rowId > 2){
		delRow.remove();
		
		rowId = 1;
		$(" .row-class" ).each(function() {
			$(this).attr("id","row-" + rowId);		
			rowId = rowId + 1;
		});
		
		var height=100/(rowId-1);
		
		$(".row-class").each(function() {
			$(this).css("height",height+"%");
		});
		
		/*$(".row-class").last().css("height",$(".row-class").last().height() - (3*rowId));
		$(".row-class").last().css("height",$(".row-class").last().percHeight() + "%");*/
		
		setColumnIds();
		createIcon();
	} else {
		alert("Operation cannot be done");
	}	
}

function setCurrentDiv(){
	$(".column-class" ).click(function(event) {		
		currentDivAttr($(this));
		event.stopPropagation();
		event.stopImmediatePropagation();
	});
}

function currentDivAttr(obj){	
	//$("#" + currentDiv).css("outline","3px solid #427ead");
	$(" .column-class" ).each(function() {
		$(this).css("outline","3px solid #427ead");
	});	
	obj.css("outline","5px solid #fbd850");
	currentDiv = obj.attr("id");
	
	$("#columnCss").val($.trim(obj.attr("class").replace(className,"").replace(classResizable,"").replace(classDroppable,"").replace(classUiActive,"") + " " + classColumn));
	$("#rowCss").val($.trim(obj.parent().attr("class").replace(rowClasses,"").replace(classSortableHandle,"").replace(classDroppable,"").replace(classUiActive,"") + " " + classPortletRow));
	$("#containerCss").val($.trim(obj.parent().parent().attr("class").replace(classSortable,"")));
	
	if(bootstrapLayout){
		if($("#rowCss").val().indexOf(classRowFluid)==-1){
			$("#rowCss").val( $("#rowCss").val() + " " + classRowFluid);
		}
	}
	var qualifier = "#" + currentDiv + " .portlet-ids";
	var portletIds = $(qualifier).val();
		
	if(portletIds!=''){
		var arrPortlet = portletIds.split(',');
		$("#porltetDropDown").val(arrPortlet[0]);
		if(arrPortlet[1]!=''){
			$("#border").prop('checked', true);		
		} else {
			$("#border").prop('checked', false);		
		}
	} else {
		$("#porltetDropDown").val('-1');
		$("#border").prop('checked', false);			
	}
}

function setDroppable(){
	
	$(" .column-class" ).each(function() {
		$( this ).droppable({
			hoverClass: "custom-ui-active-class",		
			drop: function( event, ui ) {	
				//console.log(ui.draggable.context.id);
				//console.log(event.target);
				if(ui.draggable.context.id=="columnImg") {
					if($("#bootstrap").is(':checked')){
						addColumnBootstrap($( this ).parent().attr("id"),$("#" +event.target.id));
					} else {
						addColumn($( this ).parent().attr("id"),$("#" +event.target.id));
					}
					$("#columnCss").val($.trim($("#columnCss").val().replace(classUiActive,"")));
				} else if(ui.draggable.context.id=="rowImg") {
					addRow($(this).parent());
				}
			}
		});
	});
	
	$(" .row-class" ).each(function() {
		$( this ).droppable({
			hoverClass: classUiActive,
			drop: function( event, ui ) {
			}
		});
	});
}

function setColumnIds(){
	columnId = 1;
	$(" .column-class" ).each(function() {
		$(this).attr("id","col-" + columnId);
		columnId = columnId + 1;
	});
}

function fnOpenNormalDialog() {
    // Define the Dialog and its properties.
    $("#dialog-confirm").dialog({
        resizable: false,
        modal: true,
        title: "Are you sure?",
        height: 250,
		width:300,
        buttons: {
            "Yes": function () {
                $(this).dialog('close');
                resetAndBootstrap(true);
            },
                "No": function () {
                $(this).dialog('close');
                resetAndBootstrap(false);
            }
        }
    });
}

function resetAndBootstrap(value) {
    if (value) {			
		if($("#bootstrap").is(':checked')){
			bootstrapLayout = true;
			maxColumnCount = 12;
			maxWidthCol = 50;
		} else{
			bootstrapLayout = false;
			maxColumnCount = 20;
			maxWidthCol = 30;
		}
		resetLayout();			
    } else {
    	if(bootstrapLayout){
    		$("#bootstrap").prop('checked', true);
    	} else {
    		$("#bootstrap").prop('checked', false); 
    	}
	}
}

function addColumnBootstrap(rowId,moveToNext){
	if(rowId.indexOf("row") == -1){
		return;
	}
	
	var columnCount = parseInt($("#" + rowId + " .column-count").val());
	if(columnCount > maxColumnCount){
		alert("You cannot add more than " + maxColumnCount + " columns.");
		return;
	}
	var width = 100;
	
	width = 100/columnCount;
	
	if(typeof moveToNext === "undefined"){	
		$('#' + rowId).append(
			$('<div/>')
			.attr("id","col-" + columnId)
			.addClass(className)
			.css("width","100%")
		);		
	} else {
		moveToNext.after(
			$('<div/>')
			.attr("id","col-" + columnId)
			.addClass(className)
			.css("width","8.33%")
		);		
	}
	
	$('#col-' + columnId).append(
		$('<label/>')
		.text("")
	).append(
		$('<input/>')
		.attr("type", "hidden")
		.addClass("portlet-ids")
		.attr("value", "")
	);	
	
	var resizeMe = 1;
	var increasedWidth = 0;
	var parentWidth = $("#" + rowId).width();
	
	if(columnCount>1){	
		$( "#" + rowId +" .column-class" ).each(function() {
			if($(this).width() > 50){
				$(this).css('width', ($(this).width() - 50) + 'px');
				$(this).css('width', $(this).percWidth() + '%');
				return false;
			}		
		});
	}
	
	$( "#" + rowId +" .column-class" ).each(function() {
	   // $(this).css("width",width+"%");	    
	    if(resizeMe != columnCount){	    		
	    	$(this).resizable({
				handles: 'e',
	    		minWidth: maxWidthCol,
	    		ghost: true,
	    		start: function( event, ui ) {
					maxResizeWidth = parseInt($(this).width())+(parseInt($(this).next().width())-parseInt($(this).resizable( "option", "minWidth")));
					$(this).resizable( "option", "maxWidth", parseInt(maxResizeWidth));
					increasedWidth = 0;
	    		},
	    		stop: function( event, ui ) {
					$( "#" + rowId +" .column-class" ).each(function( index ) {
						increasedWidth = increasedWidth + $(this).width();
					});
					//console.log( "increasedWidth : " + increasedWidth);
					//console.log( "totalWidth : " + parentWidth);
					var remainingSpace = parentWidth - increasedWidth;
					//console.log( "remaining Width : " + remainingSpace);				
					
					var divTwo = $(this).next();
					//console.log( "divTwo.width() : " + divTwo.width());
	    			var divTwoWidth = remainingSpace + divTwo.width();	    				
					
					var closestSpanNextWidth = closest(divTwoWidth);
					//console.log("closestSpanNextWidth : " + closestSpanNextWidth);
					divTwo.css('width', closestSpanNextWidth + 'px');					
					divTwo.css('width', divTwo.percWidth() + "%");	
					
					var closestSpanWidth = divTwoWidth - closestSpanNextWidth;
					//console.log("closestSpanWidth : " + closestSpanWidth);
					var divOneWidth = $(this).width() + closestSpanWidth;
					$(this).css('width', divOneWidth + 'px');
					$(this).css('width', $(this).percWidth() + "%");	
					
					$( "#" + rowId +" .column-class" ).each(function( index ) {
						$(this).css("width",$(this).percWidth() + "%");
					});
					
	    			$( "#" + rowId +" .column-class" ).each(function( index ) {
						assignSpanLabel($(this).width());
						$("#" + $(this).attr("id") + " label:first-child").text(spanLabelPreview);
					});
	    			$(this).css('height','100%');
					createIcon();						
	    		},
	    		resize: function() { 
					
	    		  }
	    	});
	    	resizeMe = resizeMe + 1;
	    }
	});	
	
	$( "#" + rowId +" .column-class" ).each(function( index ) {
		assignSpanLabel($(this).width());
		$("#" + $(this).attr("id") + " label:first-child").text(spanLabelPreview);
	});	
	
	currentDivAttr(	$('#col-' + columnId));
	setColumnIds();
	setDroppable();
	setCurrentDiv();
	createIcon();	
	$("#previewHtml").hide();
	
	$("#" + rowId + " .column-count").val(columnCount + 1);	
}

function closest (num) {
	var curr = acceptedPixels[0];
	var diff = Math.abs (num - curr);
	for (var val = 0; val < acceptedPixels.length; val++) {
		var newdiff = Math.abs (num - acceptedPixels[val]);
		if (newdiff < diff) {
			diff = newdiff;
			curr = acceptedPixels[val];
		}
	}
	return curr;
}

function previewLayout(){
	$("#main-content-copy").html($("#layoutParent").html());
	$("#main-content-copy").removeClass();
	if($.trim($('#elLayoutName').val())!=''){
		$("#main-content-copy").addClass($.trim($('#elLayoutName').val()));
	} else {
		$("#main-content-copy").addClass("custom-layout");
	}
	
	var cssClasses = "";
	if(!bootstrapLayout){
		cssClasses = '\n<style type="text/css">\n';
		var allClasses = "";
		$( "#main-content-copy .column-class" ).each(function() {
			var auiClass = parseFloat($(this).percWidth()).toFixed(2);
			if(allClasses.indexOf(auiClass)==-1){
				allClasses = allClasses + " " + auiClass;
				var auiClassName = "aui-w" + auiClass.replace(".","-");
				cssClasses = cssClasses + "\t." + auiClassName + "{width:" + auiClass + "%;}\n";	
				$(this).addClass(auiClassName);
			}
		});
		cssClasses = cssClasses + '</style>';
	}
	
	var totalColumnCount = 1;	
	$("#main-content-copy .row-class").each(function() {
	    $(this).removeAttr("style").removeAttr("id");		
		
		var rowColCount = $(this).find("input:first").val();
		$(this).find("input:first").remove();
		rowColCount = rowColCount - 1;		
		
		$(this).find("div").removeClass(classResizable).removeClass(classDroppable).removeClass(classUiActive);
		
		if(rowColCount == 1){
			$(this).find("div").addClass(classOnlyColumn);
		} else {
			$(this).find("div:first").addClass(classFirstColumn);
			$(this).find("div:last").addClass(classLastColumn);
		}		
	});
	
	$("#main-content-copy .row-class").each(function() {
		$(this).removeClass(classDroppable).removeClass(classSortableHandle).addClass(classPortletRow).removeClass(rowClasses);
		if(bootstrapLayout){
			$(this).addClass(classRowFluid);			
		}
	});
	$( "#main-content-copy .column-class" ).each(function() {		
		$(this).removeAttr("style");
		$(this).attr("id","column-" + totalColumnCount);		
		
		if(bootstrapLayout){
			var spanLabel = "span" + $(this).find("label").text();
			$(this).addClass(spanLabel);
		}
		
		var portletSettings = $(this).find("input").val();
		
		$(this).html('');
		var allClassNames = $(this).attr("class");
			
		if(allClassNames.indexOf(classOnlyColumn)!=-1){
			allClassNames = classContentOnly;
		} else if(allClassNames.indexOf(classFirstColumn)!=-1){
			allClassNames = classContentFirst;
		} else {
			allClassNames = classContentLast;
		}
		
		var processColumn = '\n\t\t$processor.processColumn("column-' + totalColumnCount +'", "portlet-column-content ' + allClassNames + '")\n';			
		var processPortlet = "";
		if(typeof portletSettings != "undefined" && portletSettings!=''){
			var portletArr = portletSettings.split(",");
			var qualifiedNameInstance = portletArr[0].split("##");
			var qualifiedName = qualifiedNameInstance[0].replace("_","").replace(/_$/, '');
			var isInstanceable = qualifiedNameInstance[1];
			var strInstance = "_INSTANCE_";
			
			if(isInstanceable == 'true'){
				qualifiedName = qualifiedName + strInstance + randomString(12, '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ');
			} 
			if(portletArr[1]!=""){
				processPortlet = '\n\t\t#set ($VOID = $velocityPortletPreferences.setValue("portlet-setup-show-borders", "false"))\n';
				processPortlet = processPortlet + '\t\t$theme.runtime("' + qualifiedName + '", "", $velocityPortletPreferences.toString())\n';
				processPortlet = processPortlet + '\t\t#set ($VOID = $velocityPortletPreferences.reset())\n';
			} else {
				processPortlet = '\n\t\t$processor.processPortlet("' + qualifiedName + '")\n';
			}
		} 
		$(this).html(processColumn + processPortlet);
		totalColumnCount = totalColumnCount + 1;
	});
	$( "#main-content-copy .column-class" ).each(function() {	
		$(this).removeClass(className).addClass(classColumn);
	});
	
	$( "#main-content-copy").addClass($.trim($("#layoutParent").attr("class").replace(classSortable,"")));

	$("#previewHtml").val($("#setContent").html() + cssClasses);
	$("#previewHtml").val($("#previewHtml").val().replace("main-content-copy","main-content"));
	$("#previewHtml").format({method: 'xml'});
	$("#previewHtml").toggle();
	
	//var myhtml = "" + $("#setContent").html();
	//console.log(formatXml(myhtml));
	//$("#previewHtml").html( $("#setContent").html() + cssClasses).format({method: 'xml'});
	//$("#previewHtml").toggle();
}

function assignSpanLabel(bootDivWidth){	
	switch (bootDivWidth) {
		case 50:
			spanLabelPreview = "1";
			break;
		case 100:
			spanLabelPreview = "2";
			break;
		case 150:
			spanLabelPreview = "3";
			break;
		case 200:
			spanLabelPreview = "4";
			break;
		case 250:
			spanLabelPreview = "5";
			break;
		case 300:
			spanLabelPreview = "6";
			break;
		case 350:
			spanLabelPreview = "7";
			break;
		case 400:
			spanLabelPreview = "8";
			break;
		case 450:
			spanLabelPreview = "9";
			break;
		case 500:
			spanLabelPreview = "10";
			break;
		case 550:
			spanLabelPreview = "11";
			break;
		case 600:
			spanLabelPreview = "12";
			break;
	}
}

function deleteColumnBootstrap(deleteCol){
	var deleteColRowId = deleteCol.parent().attr("id");		
	
	var columnCount = parseInt($("#" + deleteColRowId + " .column-count").val());
	if(columnCount > 2){	
		var deletedWidth = deleteCol.width();	
		//Width of this div will be added to next or prev div
		var $closestDiv = deleteCol.next(".column-class");
		if(typeof $closestDiv.attr("id") === "undefined"){
			$closestDiv = deleteCol.prev(".column-class");
		}
		
		$closestDiv.css('width', ($closestDiv.width() + deletedWidth) + 'px');
		$closestDiv.css('width', $closestDiv.percWidth() + '%');	
		
		deleteCol.remove();
		
		columnCount = columnCount -2;				
		
		var resizeMe = 1;
		var increasedWidth = 0;
		var parentWidth = $("#" + deleteColRowId).width();		
	
		
		$( "#" + deleteColRowId +" .column-class" ).each(function() {
	    //$(this).css("width",width+"%");
			
			if(resizeMe != columnCount){	    		
				$(this).resizable({
					handles: 'e',
					minWidth: maxWidthCol,
					ghost: true,
					start: function( event, ui ) {
						maxResizeWidth = parseInt($(this).width())+(parseInt($(this).next().width())-parseInt($(this).resizable( "option", "minWidth")));
						$(this).resizable( "option", "maxWidth", parseInt(maxResizeWidth));
						increasedWidth = 0;
					},
					stop: function( event, ui ) {
						$( "#" + deleteColRowId +" .column-class" ).each(function( index ) {
							increasedWidth = increasedWidth + $(this).width();
						});
						//console.log( "increasedWidth : " + increasedWidth);
						//console.log( "totalWidth : " + parentWidth);
						var remainingSpace = parentWidth - increasedWidth;
						//console.log( "remaining Width : " + remainingSpace);				
						
						var divTwo = $(this).next();
						//console.log( "divTwo.width() : " + divTwo.width());
						var divTwoWidth = remainingSpace + divTwo.width();	    				
						
						var closestSpanNextWidth = closest(divTwoWidth);
						//console.log("closestSpanNextWidth : " + closestSpanNextWidth);
						divTwo.css('width', closestSpanNextWidth + 'px');					
						divTwo.css('width', divTwo.percWidth() + "%");	
						
						var closestSpanWidth = divTwoWidth - closestSpanNextWidth;
						//console.log("closestSpanWidth : " + closestSpanWidth);
						var divOneWidth = $(this).width() + closestSpanWidth;
						$(this).css('width', divOneWidth + 'px');
						$(this).css('width', $(this).percWidth() + "%");	
						
						$( "#" + deleteColRowId +" .column-class" ).each(function( index ) {
							$(this).css("width",$(this).percWidth() + "%");
						});
						
						$( "#" + deleteColRowId +" .column-class" ).each(function( index ) {
							assignSpanLabel($(this).width());
							$("#" + $(this).attr("id") + " label:first-child").text(spanLabelPreview);
						});
						$(this).css('height','100%');
						createIcon();	
					},
					resize: function() { 	
						
					  }
				});
				resizeMe = resizeMe + 1;
				//console.log("resizeMe :: " + resizeMe);
			} else {
				try{
					$(this).resizable('destroy');
				}catch(err){
				}				
			}
		});	
		
		$( "#" + deleteColRowId +" .column-class" ).each(function( index ) {
			assignSpanLabel($(this).width());
			$("#" + $(this).attr("id") + " label:first-child").text(spanLabelPreview);
		});
				
		setColumnIds();		
		setDroppable();
		setCurrentDiv();
		createIcon();					
		currentDivAttr(	$('#col-1'));
		
		$("#" + deleteColRowId + " .column-count").val(columnCount + 1);	
	} else {
		deleteRow(deleteCol.parent());
	}		
}



$( document ).ready(function() {
	// Add first column by default
	addColumnBootstrap("row-1");	
    
	$("#bootstrap").prop('checked', true);
	bootstrapLayout = true;
	maxColumnCount = 12;
	maxWidthCol = 50;
	
	// Sort functionality added to rows
	$("#layoutParent").sortable({
		stop: function( event, ui ) {
			columnId = 1;
			$(" .column-class" ).each(function() {
				$(this).attr("id","col-" + columnId);
				columnId = columnId + 1;
				//$(this).css("outline","3px solid #427ead");
			});
			// Icon refreshed
			createIcon();
		}
	});
	
	// Change listener for bootstrap
	$('#bootstrap').change(function () {
		fnOpenNormalDialog();		
	});
	
	// Draggable event added for row and column Items
	$("#rowImg").draggable({ cursor: "move",revert: "true",helper: "clone" });
	$("#columnImg").draggable({ cursor: "move",revert: "true",helper: "clone" });
	$( "body" ).droppable();	
	
	// Context menu added
    $('#layoutParent').contextMenu({
        selector: 'div', 
        callback: function(key, options) {
            //var m = "clicked: " + key + " on " + $(this).attr("id");
            //window.console && console.log(m) ; 
			if(key==='deletecol'){
				if(!bootstrapLayout){
					deleteColumn($(this));
				} else {
					deleteColumnBootstrap($(this));
				}
			} else if(key==='deleterow'){
				deleteRow($(this).parent());
			} else if(key==='reset'){
				resetLayout();
			}
        },
        items: {
            "deletecol": {name: "Delete Column"},
            "deleterow": {name: "Delete Row"}, 
            "sep1": "---------",
            "reset": {name: "Reset"}
        }
    });   
    
    // On click of close dialog maintain bootstrap value 
    $(".ui-dialog-titlebar-close").bind( "click", function() {
    	if($("#bootstrap").is(':checked')){
    		$("#bootstrap").prop('checked', false); 
    	} else {
    		$("#bootstrap").prop('checked', true); 
    	}
	});
});

// This function is used to generate instanceId's
function randomString(length, chars) {
    var result = '';
    for (var i = length; i > 0; --i) result += chars[Math.round(Math.random() * (chars.length - 1))];
    return result;
}

// Send request to server with parameter saying it creates a war and download it to browser.
function generateWar(){
	capture();
	setTimeout(function(){ ajaxFileDownload(); }, 1000);
}

// This method will use html2canvas api and create an encoded image for layout icon.
function capture() {
	html2canvas($("#iconImage"), {
	        onrendered: function(canvas) {
	        $('#elCanvasicon').val(canvas.toDataURL("image/png"));
	        }
	    });
	previewLayout();
}

function ajaxFileDownload(){
	$("#previewHtml").hide();
	 
    var $preparingFileModal = $("#preparing-file-modal");
 
        $preparingFileModal.dialog({ modal: true });
 
        $.fileDownload($("#exportForms").val(), {
            successCallback: function(url) {
 
                $preparingFileModal.dialog('close');
            },
            failCallback: function(responseHtml, url) {
 
                $preparingFileModal.dialog('close');
            $("#error-modal").dialog({ modal: true });
        },
        httpMethod: "POST",
        data : {
        	myaction : "create",
        	layoutname:$('#elLayoutName').val(),
			canvasicon : $('#elCanvasicon').val(),
			tplcontent : $("#previewHtml").val()
		}
    });
    return false; //this is critical to stop the click event which will trigger a normal file download!
}

// Send request to server with parameter saying it needs to copy war to deploy dir.
function installFile(){
	capture();
	setTimeout(function(){$.ajax({
		url : $("#exportForms").val(),
		data : {
			myaction : "install",
			layoutname : $('#elLayoutName').val(),
			canvasicon : $('#elCanvasicon').val(),
			tplcontent : $("#previewHtml").val()
		},
		type : 'get',
		success : function(data) {
			if(data=="success"){
				alert("Your server is processing your layout, will be available in a minute.");
			} else {
				alert("There is a problem installing your layout, please try again.");
			}
		}
	}); }, 1000);
	
}