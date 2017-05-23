package com.liferay.layout.developer.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.liferay.layout.developer.businessdelegate.LayoutDeveloperBusinessDelegate;
import com.liferay.layout.developer.constant.LayoutConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * @author vipin.bardia
 * @email bardia.vipin@gmail.com
 */
public class LayoutDeveloper extends MVCPortlet{

	public static final Log LOGGER = LogFactoryUtil.getLog(LayoutDeveloper.class);
	
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		LOGGER.info(" START doView");
		
	    ThemeDisplay themeDisplay =(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	    List<Portlet> portletList = LayoutDeveloperBusinessDelegate.getPortletList(themeDisplay.getCompanyId(), themeDisplay.getLocale());
	  
	    if(portletList!=null){
	    	renderRequest.setAttribute("portletList", portletList);
	    } else {
	    	renderRequest.setAttribute("portletList", new ArrayList<Portlet>());
	    }
	    renderRequest.setAttribute(WebKeys.PORTLET_DECORATE, Boolean.FALSE);
	    
	    LOGGER.info(" END doView");
	    
		super.doView(renderRequest, renderResponse);
	}
	
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		LOGGER.info(" START serveResource");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String exportLayout = resourceRequest.getResourceID();
		String action = ParamUtil.getString(resourceRequest, "myaction");
		
		try {
			if(action.equals("install") && !themeDisplay.getLayout().getGroup().getName().equals(GroupConstants.CONTROL_PANEL)){
				return;
			}
		} catch (PortalException e1) {
		} catch (SystemException e1) {
		}
		
		if(Validator.isNotNull(exportLayout.isEmpty())){
			
			String dataUrl = ParamUtil.getString(resourceRequest, "canvasicon");
			String layoutName = ParamUtil.getString(resourceRequest, "layoutname");
			String tplContent = ParamUtil.getString(resourceRequest, "tplcontent");
			// Create temporary directory for plugin.
	 
			if(layoutName.isEmpty()){
				layoutName = "custom-layout";
			}
			resourceResponse.setContentType("application/war");
			resourceResponse.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
			resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=" + layoutName + StringPool.PERIOD + LayoutConstants.EXTENSION_WAR);
			
			File warFile = LayoutDeveloperBusinessDelegate.createAndZipLayoutStructure(layoutName,dataUrl,tplContent);
			
		
			if(action.equals("create")){
				OutputStream out = resourceResponse.getPortletOutputStream();
				InputStream in = new FileInputStream(warFile);
				IOUtils.copy(in, out);
				
				out.flush();
				in.close();
				out.close();
			} else {
				String deployDir = PropsUtil.get("auto.deploy.deploy.dir");
				LOGGER.info("Deploy directory is :: " + deployDir);
				File dir = new File(deployDir);
				
				if(dir!=null){
					System.out.println(dir.getAbsolutePath());
					FileUtils.copyFileToDirectory(warFile, dir);
				}
				PrintWriter pw = resourceResponse.getWriter();
				pw.write("success");
				pw.close();
			}
			try{
				warFile.delete();
			} catch(Exception e){
				LOGGER.error("Unable to clear temp :: "+ e.getMessage());
			}
		}
		LOGGER.info("END serveResource");
	}
}
