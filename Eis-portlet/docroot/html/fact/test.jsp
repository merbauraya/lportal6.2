<%@ include file="/html/init.jsp" %>
<%@ include file="/html/toolbar.jsp" %>


<eis:library-selector
	adminAllowAll="<%= mLibraryAdminAllowAll %>"

/>



 <liferay-ui:icon-menu icon="../aui/cog" message="" showArrow="<%= false %>">
        <liferay-ui:icon iconCssClass="icon-user" message="Use" url="javascript:hx()" />
        <liferay-ui:icon iconCssClass="icon-film" message="Film" url="www.liferay.com" />
        <liferay-ui:icon iconCssClass="icon-edit" message="Edit" url="www.liferay.com" />
        <liferay-ui:icon iconCssClass="icon-trash" message="Trash" url="www.liferay.com" />
    </liferay-ui:icon-menu>


<hr/>
<liferay-ui:icon-menu
	
	direction="down"
	extended="<%= true %>"
	icon="../aui/cog"
	message=""
	showArrow="<%= false %>"
	showWhenSingleIcon="<%= true %>"
>
	<liferay-portlet:icon-refresh />

	<liferay-portlet:icon-portlet-css />

	<liferay-portlet:icon-configuration />

	<liferay-portlet:icon-edit />

	<liferay-portlet:icon-edit-defaults />

	<liferay-portlet:icon-edit-guest />

	<liferay-portlet:icon-export-import />

	<liferay-portlet:icon-help />

	<liferay-portlet:icon-print />

	<liferay-portlet:icon-maximize />

	<liferay-portlet:icon-minimize />

	<liferay-portlet:icon-close />
</liferay-ui:icon-menu>

<script>
	function hx()
	{
		console.log('xxx');
	}

</script>

<hr/>
<liferay-portlet:icon-options></liferay-portlet:icon-options>
<menu>
	<div>
		<a class="dropdown-toggle direction-down max-display-items-10" href="javascript:;" id="_Eis_WAR_Eisportlet_kldx_column1_0_menu" title="Options"> <i class="icon-cog"></i><span class="lfr-icon-menu-text"></span><i class="caret"></i> </a>
		<ul class="dropdown-menu lfr-menu-list direction-down">
		   <li class="portlet-css portlet-css-icon lfr-js-required" role="presentation">
		      <a href="javascript:;" class=" taglib-icon" id="_Eis_WAR_Eisportlet_kldx_column1_0_menu_look-and-feel" onclick="Liferay.Portlet.loadCSSEditor('Eis_WAR_Eisportlet'); return false;" role="menuitem">
		      <span class="" id="">
		      <i class="icon-picture"></i>
		      </span>
		      <span class="taglib-text-icon">Look and Feel</span>
		      </a>
		   </li>
		   <li class="portlet-configuration portlet-configuration-icon" role="presentation">
		      <a href="http://localhost:8080/web/eis/home?p_p_id=86&amp;p_p_lifecycle=0&amp;p_p_state=pop_up&amp;p_p_col_id=column-1&amp;p_p_col_count=1&amp;_86_struts_action=%2Fportlet_configuration%2Fedit_permissions&amp;_86_redirect=%2Fweb%2Feis%2Fhome%3Fp_p_id%3DEis_WAR_Eisportlet%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_count%3D1%26_Eis_WAR_Eisportlet_redirect%3D%252Fweb%252Feis%252Fhome%253Fp_p_id%253DEis_WAR_Eisportlet%2526p_p_lifecycle%253D0%2526p_p_state%253Dnormal%2526p_p_mode%253Dview%2526p_p_col_id%253Dcolumn-1%2526p_p_col_count%253D1%2526_Eis_WAR_Eisportlet_mvcPath%253D%25252Fhtml%25252Fproject%25252Fview.jsp%2526%26_Eis_WAR_Eisportlet_mvcPath%3D%252Fhtml%252Ffact%252Ftest.jsp%26_Eis_WAR_Eisportlet_backURL%3D%252Fweb%252Feis%252Fhome%253Fp_p_id%253DEis_WAR_Eisportlet%2526p_p_lifecycle%253D0%2526p_p_state%253Dnormal%2526p_p_mode%253Dview%2526p_p_col_id%253Dcolumn-1%2526p_p_col_count%253D1%2526_Eis_WAR_Eisportlet_mvcPath%253D%25252Fhtml%25252Fproject%25252Fview.jsp%2526&amp;_86_returnToFullPageURL=%2Fweb%2Feis%2Fhome%3Fp_p_id%3DEis_WAR_Eisportlet%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_count%3D1%26_Eis_WAR_Eisportlet_redirect%3D%252Fweb%252Feis%252Fhome%253Fp_p_id%253DEis_WAR_Eisportlet%2526p_p_lifecycle%253D0%2526p_p_state%253Dnormal%2526p_p_mode%253Dview%2526p_p_col_id%253Dcolumn-1%2526p_p_col_count%253D1%2526_Eis_WAR_Eisportlet_mvcPath%253D%25252Fhtml%25252Fproject%25252Fview.jsp%2526%26_Eis_WAR_Eisportlet_mvcPath%3D%252Fhtml%252Ffact%252Ftest.jsp%26_Eis_WAR_Eisportlet_backURL%3D%252Fweb%252Feis%252Fhome%253Fp_p_id%253DEis_WAR_Eisportlet%2526p_p_lifecycle%253D0%2526p_p_state%253Dnormal%2526p_p_mode%253Dview%2526p_p_col_id%253Dcolumn-1%2526p_p_col_count%253D1%2526_Eis_WAR_Eisportlet_mvcPath%253D%25252Fhtml%25252Fproject%25252Fview.jsp%2526&amp;_86_portletResource=Eis_WAR_Eisportlet&amp;_86_resourcePrimKey=63104_LAYOUT_Eis_WAR_Eisportlet&amp;_86_" class=" taglib-icon" id="_Eis_WAR_Eisportlet_kldx_column1_0_menu_configuration" onclick="Liferay.Portlet.openWindow('#p_p_id_Eis_WAR_Eisportlet_', 'Eis_WAR_Eisportlet', 'http://localhost:8080/web/eis/home?p_p_id=86&amp;p_p_lifecycle=0&amp;p_p_state=pop_up&amp;p_p_col_id=column-1&amp;p_p_col_count=1&amp;_86_struts_action=%2Fportlet_configuration%2Fedit_permissions&amp;_86_redirect=%2Fweb%2Feis%2Fhome%3Fp_p_id%3DEis_WAR_Eisportlet%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_count%3D1%26_Eis_WAR_Eisportlet_redirect%3D%252Fweb%252Feis%252Fhome%253Fp_p_id%253DEis_WAR_Eisportlet%2526p_p_lifecycle%253D0%2526p_p_state%253Dnormal%2526p_p_mode%253Dview%2526p_p_col_id%253Dcolumn-1%2526p_p_col_count%253D1%2526_Eis_WAR_Eisportlet_mvcPath%253D%25252Fhtml%25252Fproject%25252Fview.jsp%2526%26_Eis_WAR_Eisportlet_mvcPath%3D%252Fhtml%252Ffact%252Ftest.jsp%26_Eis_WAR_Eisportlet_backURL%3D%252Fweb%252Feis%252Fhome%253Fp_p_id%253DEis_WAR_Eisportlet%2526p_p_lifecycle%253D0%2526p_p_state%253Dnormal%2526p_p_mode%253Dview%2526p_p_col_id%253Dcolumn-1%2526p_p_col_count%253D1%2526_Eis_WAR_Eisportlet_mvcPath%253D%25252Fhtml%25252Fproject%25252Fview.jsp%2526&amp;_86_returnToFullPageURL=%2Fweb%2Feis%2Fhome%3Fp_p_id%3DEis_WAR_Eisportlet%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_count%3D1%26_Eis_WAR_Eisportlet_redirect%3D%252Fweb%252Feis%252Fhome%253Fp_p_id%253DEis_WAR_Eisportlet%2526p_p_lifecycle%253D0%2526p_p_state%253Dnormal%2526p_p_mode%253Dview%2526p_p_col_id%253Dcolumn-1%2526p_p_col_count%253D1%2526_Eis_WAR_Eisportlet_mvcPath%253D%25252Fhtml%25252Fproject%25252Fview.jsp%2526%26_Eis_WAR_Eisportlet_mvcPath%3D%252Fhtml%252Ffact%252Ftest.jsp%26_Eis_WAR_Eisportlet_backURL%3D%252Fweb%252Feis%252Fhome%253Fp_p_id%253DEis_WAR_Eisportlet%2526p_p_lifecycle%253D0%2526p_p_state%253Dnormal%2526p_p_mode%253Dview%2526p_p_col_id%253Dcolumn-1%2526p_p_col_count%253D1%2526_Eis_WAR_Eisportlet_mvcPath%253D%25252Fhtml%25252Fproject%25252Fview.jsp%2526&amp;_86_portletResource=Eis_WAR_Eisportlet&amp;_86_resourcePrimKey=63104_LAYOUT_Eis_WAR_Eisportlet&amp;_86_', '_Eis_WAR_Eisportlet_', 'Configuration'); return false;" role="menuitem">
		      <span class="" id="">
		      <i class="icon-wrench"></i>
		      </span>
		      <span class="taglib-text-icon">Configuration</span>
		      </a>
		   </li>
		   <li class="portlet-export-import portlet-export-import-icon" role="presentation">
		      <a href="http://localhost:8080/web/eis/home?p_p_id=86&amp;p_p_lifecycle=0&amp;p_p_state=pop_up&amp;p_p_col_id=column-1&amp;p_p_col_count=1&amp;_86_struts_action=%2Fportlet_configuration%2Fexport_import&amp;_86_redirect=%2Fweb%2Feis%2Fhome%3Fp_p_id%3DEis_WAR_Eisportlet%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_count%3D1%26_Eis_WAR_Eisportlet_redirect%3D%252Fweb%252Feis%252Fhome%253Fp_p_id%253DEis_WAR_Eisportlet%2526p_p_lifecycle%253D0%2526p_p_state%253Dnormal%2526p_p_mode%253Dview%2526p_p_col_id%253Dcolumn-1%2526p_p_col_count%253D1%2526_Eis_WAR_Eisportlet_mvcPath%253D%25252Fhtml%25252Fproject%25252Fview.jsp%2526%26_Eis_WAR_Eisportlet_mvcPath%3D%252Fhtml%252Ffact%252Ftest.jsp%26_Eis_WAR_Eisportlet_backURL%3D%252Fweb%252Feis%252Fhome%253Fp_p_id%253DEis_WAR_Eisportlet%2526p_p_lifecycle%253D0%2526p_p_state%253Dnormal%2526p_p_mode%253Dview%2526p_p_col_id%253Dcolumn-1%2526p_p_col_count%253D1%2526_Eis_WAR_Eisportlet_mvcPath%253D%25252Fhtml%25252Fproject%25252Fview.jsp%2526&amp;_86_returnToFullPageURL=%2Fweb%2Feis%2Fhome%3Fp_p_id%3DEis_WAR_Eisportlet%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_count%3D1%26_Eis_WAR_Eisportlet_redirect%3D%252Fweb%252Feis%252Fhome%253Fp_p_id%253DEis_WAR_Eisportlet%2526p_p_lifecycle%253D0%2526p_p_state%253Dnormal%2526p_p_mode%253Dview%2526p_p_col_id%253Dcolumn-1%2526p_p_col_count%253D1%2526_Eis_WAR_Eisportlet_mvcPath%253D%25252Fhtml%25252Fproject%25252Fview.jsp%2526%26_Eis_WAR_Eisportlet_mvcPath%3D%252Fhtml%252Ffact%252Ftest.jsp%26_Eis_WAR_Eisportlet_backURL%3D%252Fweb%252Feis%252Fhome%253Fp_p_id%253DEis_WAR_Eisportlet%2526p_p_lifecycle%253D0%2526p_p_state%253Dnormal%2526p_p_mode%253Dview%2526p_p_col_id%253Dcolumn-1%2526p_p_col_count%253D1%2526_Eis_WAR_Eisportlet_mvcPath%253D%25252Fhtml%25252Fproject%25252Fview.jsp%2526&amp;_86_portletResource=Eis_WAR_Eisportlet&amp;_86_" class=" taglib-icon" id="_Eis_WAR_Eisportlet_kldx_column1_0_menu_export-import" onclick="Liferay.Portlet.openWindow('#p_p_id_Eis_WAR_Eisportlet_', 'Eis_WAR_Eisportlet', 'http://localhost:8080/web/eis/home?p_p_id=86&amp;p_p_lifecycle=0&amp;p_p_state=pop_up&amp;p_p_col_id=column-1&amp;p_p_col_count=1&amp;_86_struts_action=%2Fportlet_configuration%2Fexport_import&amp;_86_redirect=%2Fweb%2Feis%2Fhome%3Fp_p_id%3DEis_WAR_Eisportlet%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_count%3D1%26_Eis_WAR_Eisportlet_redirect%3D%252Fweb%252Feis%252Fhome%253Fp_p_id%253DEis_WAR_Eisportlet%2526p_p_lifecycle%253D0%2526p_p_state%253Dnormal%2526p_p_mode%253Dview%2526p_p_col_id%253Dcolumn-1%2526p_p_col_count%253D1%2526_Eis_WAR_Eisportlet_mvcPath%253D%25252Fhtml%25252Fproject%25252Fview.jsp%2526%26_Eis_WAR_Eisportlet_mvcPath%3D%252Fhtml%252Ffact%252Ftest.jsp%26_Eis_WAR_Eisportlet_backURL%3D%252Fweb%252Feis%252Fhome%253Fp_p_id%253DEis_WAR_Eisportlet%2526p_p_lifecycle%253D0%2526p_p_state%253Dnormal%2526p_p_mode%253Dview%2526p_p_col_id%253Dcolumn-1%2526p_p_col_count%253D1%2526_Eis_WAR_Eisportlet_mvcPath%253D%25252Fhtml%25252Fproject%25252Fview.jsp%2526&amp;_86_returnToFullPageURL=%2Fweb%2Feis%2Fhome%3Fp_p_id%3DEis_WAR_Eisportlet%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_count%3D1%26_Eis_WAR_Eisportlet_redirect%3D%252Fweb%252Feis%252Fhome%253Fp_p_id%253DEis_WAR_Eisportlet%2526p_p_lifecycle%253D0%2526p_p_state%253Dnormal%2526p_p_mode%253Dview%2526p_p_col_id%253Dcolumn-1%2526p_p_col_count%253D1%2526_Eis_WAR_Eisportlet_mvcPath%253D%25252Fhtml%25252Fproject%25252Fview.jsp%2526%26_Eis_WAR_Eisportlet_mvcPath%3D%252Fhtml%252Ffact%252Ftest.jsp%26_Eis_WAR_Eisportlet_backURL%3D%252Fweb%252Feis%252Fhome%253Fp_p_id%253DEis_WAR_Eisportlet%2526p_p_lifecycle%253D0%2526p_p_state%253Dnormal%2526p_p_mode%253Dview%2526p_p_col_id%253Dcolumn-1%2526p_p_col_count%253D1%2526_Eis_WAR_Eisportlet_mvcPath%253D%25252Fhtml%25252Fproject%25252Fview.jsp%2526&amp;_86_portletResource=Eis_WAR_Eisportlet&amp;_86_', '_Eis_WAR_Eisportlet_', 'Export / Import'); return false;" role="menuitem">
		      <span class="" id="">
		      <i class="icon-download-alt"></i>
		      </span>
		      <span class="taglib-text-icon">Export / Import</span>
		      </a>
		   </li>
		   <li class="portlet-maximize portlet-maximize-icon" role="presentation">
		      <a href="http://localhost:8080/web/eis/home?p_p_id=Eis_WAR_Eisportlet&amp;p_p_lifecycle=0&amp;p_p_state=maximized&amp;p_p_state_rcv=1&amp;p_p_col_id=column-1&amp;p_p_col_count=1&amp;_Eis_WAR_Eisportlet_backURL=%2Fweb%2Feis%2Fhome%3Fp_p_id%3DEis_WAR_Eisportlet%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_count%3D1%26_Eis_WAR_Eisportlet_mvcPath%3D%252Fhtml%252Fproject%252Fview.jsp%26&amp;_Eis_WAR_Eisportlet_mvcPath=%2Fhtml%2Ffact%2Ftest.jsp&amp;_Eis_WAR_Eisportlet_redirect=%2Fweb%2Feis%2Fhome%3Fp_p_id%3DEis_WAR_Eisportlet%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_count%3D1%26_Eis_WAR_Eisportlet_mvcPath%3D%252Fhtml%252Fproject%252Fview.jsp%26" class=" taglib-icon" id="_Eis_WAR_Eisportlet_kldx_column1_0_menu_maximize" onclick="submitForm(document.hrefFm, 'http://localhost:8080/web/eis/home?p_p_id=Eis_WAR_Eisportlet&amp;p_p_lifecycle=0&amp;p_p_state=maximized&amp;p_p_state_rcv=1&amp;p_p_col_id=column-1&amp;p_p_col_count=1&amp;_Eis_WAR_Eisportlet_backURL=%2Fweb%2Feis%2Fhome%3Fp_p_id%3DEis_WAR_Eisportlet%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_count%3D1%26_Eis_WAR_Eisportlet_mvcPath%3D%252Fhtml%252Fproject%252Fview.jsp%26&amp;_Eis_WAR_Eisportlet_mvcPath=%2Fhtml%2Ffact%2Ftest.jsp&amp;_Eis_WAR_Eisportlet_redirect=%2Fweb%2Feis%2Fhome%3Fp_p_id%3DEis_WAR_Eisportlet%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_count%3D1%26_Eis_WAR_Eisportlet_mvcPath%3D%252Fhtml%252Fproject%252Fview.jsp%26'); return false;" role="menuitem">
		      <span class="" id="">
		      <i class="icon-plus"></i>
		      </span>
		      <span class="taglib-text-icon">Maximize</span>
		      </a>
		   </li>
		   <li class="portlet-minimize portlet-minimize-icon" role="presentation">
		      <a href="/c/portal/update_layout?p_l_id=63104&amp;p_p_id=Eis_WAR_Eisportlet&amp;p_p_restore=false&amp;p_v_l_s_g_id=54301&amp;doAsUserId=&amp;cmd=minimize&amp;referer=%2Fc%2Fportal%2Flayout%3Fp_auth%3DwRD1Q8pH%26p_l_id%3D63104%26doAsUserId%3D&amp;refresh=1" class=" taglib-icon" id="_Eis_WAR_Eisportlet_kldx_column1_0_menu_minimize" onclick="Liferay.Portlet.minimize('#p_p_id_Eis_WAR_Eisportlet_', this); return false;" role="menuitem">
		      <span class="" id="">
		      <i class="icon-minus"></i>
		      </span>
		      <span class="taglib-text-icon">Minimize</span>
		      </a>
		   </li>
		   <li class="portlet-close portlet-close-icon" role="presentation">
		      <a href="/c/portal/update_layout?p_auth=wRD1Q8pH&amp;p_l_id=63104&amp;p_p_id=Eis_WAR_Eisportlet&amp;p_v_l_s_g_id=54301&amp;doAsUserId=&amp;cmd=delete&amp;referer=%2Fc%2Fportal%2Flayout%3Fp_l_id%3D63104%26doAsUserId%3D&amp;refresh=1" class=" taglib-icon" id="_Eis_WAR_Eisportlet_kldx_column1_0_menu_remove" onclick="Liferay.Portlet.close('#p_p_id_Eis_WAR_Eisportlet_'); return false;" role="menuitem">
		      <span class="" id="">
		      <i class="icon-remove"></i>
		      </span>
		      <span class="taglib-text-icon">Remove</span>
		      </a>
		   </li>
		</ul>
	</div>
</menu>


    <div class="btn-group">
      <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
        Action
        <span class="caret"></span>
      </a>
      <ul class="dropdown-menu">
        <li href="#xx">xx</li>
        <li href="#BB">bb</li>
        
      </ul>
    </div>


<div class="btn-group" id="mz">
	<aui:input name="selval" type="hidden" />
	<button role="menuitem" aria-haspopup="true" href="javascript:void(0)" data-toggle="dropdown" class="btn btn-default dropdown  dropdown-toggle" type="button">
		<span id="selectLabel" class="select-label">Kampus Negeri</span>  <span class="caret"></span> 
	</button>
	<ul class="dropdown-menu " id="brx" role="menu">
		<li role="presentation">
			<a role="menuitem" href="javascript:mmz(10,'AKademik')">Akademik</a></li>
		<li role="presentation"><a role="menuitem" href="javascript:mmz(11,'COE')">COE</a></li>
		<li role="presentation"><a role="menuitem" href="javascript:mmz(12,'Fakulti')">Fakulti</a></li><li><a href="#HICOE">HICOE</a></li><li><a href="#Jabatan/Unit">Jabatan/Unit</a></li><li><a href="#Kampus Negeri">Kampus Negeri</a></li></ul>

</div>

<aui:script use="aui-base,event-move,event-outside,liferay-menu-toggle,liferay-store">
				var toggleMenu = new Liferay.MenuToggle(
					{
						content: '#mz',
						toggle: <%= false %>,
						toggleTouch: true,
						trigger: '#mz button'
					}
				);
				
				
				Liferay.provide(
						window,
						'mmz',
						function(id,name) {
							var A = AUI();
							console.log(name);
							A.one('#selectLabel').html(name);
							A.one('#mz').removeClass('open');
						},
						['liferay-util-list-fields']
					);
				
			</aui:script>

<a class="dropdown" href="javascript:void(0)" role="menuitem">
	<span class="nav-item-label">Menu</span>
	<i id="yui_patched_v3_11_0_1_1463323642730_1607" class="icon-caret-down"></i>
</a>
		<ul class="dropdown-menu "><li><a href="#Akademik">Akademik</a></li><li><a href="#COE">COE</a></li><li><a href="#Fakulti">Fakulti</a></li><li><a href="#HICOE">HICOE</a></li><li><a href="#Jabatan/Unit">Jabatan/Unit</a></li><li><a href="#Kampus Negeri">Kampus Negeri</a></li></ul>




<div id="_20_displayStyleButtons">
	<div class="btn-group lfr-icon-menu"><a class="dropdown-toggle direction-down max-display-items-15 btn select" href="javascript:;" id="_20_tiym_null_null_menu" title=""> <i class="icon-th-list"></i><i class="caret"></i> </a><ul class="dropdown-menu lfr-menu-list direction-down">

		<li class="" role="presentation">
			<a href="javascript&#x3a;&#x3b;" class=" taglib-icon" id="_20_tiym_null_null_menu_icon" onClick="nzqz_null_null_onClickDisplayStyle(this);" role="menuitem" data-displayStyle="icon" >

				<span class=""  id=""><i class="icon-th-large"></i></span>
	
				<span class="taglib-text-icon">Icon</span>
	
			</a>
		</li>
		<li class="" role="presentation">
				<a href="javascript&#x3a;&#x3b;" class=" taglib-icon" id="_20_tiym_null_null_menu_descriptive" onClick="nzqz_null_null_onClickDisplayStyle(this);" role="menuitem" data-displayStyle="descriptive" >
						
	
				<span class=""  id="">
			
					<i class="icon-th-list"></i>

				</span>
	

				<span class="taglib-text-icon">Descriptive</span>
	
				</a>
				
				
			
		</li>
	
	<li class="" role="presentation">
			
				
					<a href="javascript&#x3a;&#x3b;" class=" taglib-icon" id="_20_tiym_null_null_menu_list" onClick="nzqz_null_null_onClickDisplayStyle(this);" role="menuitem" data-displayStyle="list" >
		
	
		<span class=""  id="">
			
	<i class="icon-align-justify"></i>

	

		</span>
	
	<span class="taglib-text-icon">List</span>
		</a>
</li>
	</ul></div>
	</div>
