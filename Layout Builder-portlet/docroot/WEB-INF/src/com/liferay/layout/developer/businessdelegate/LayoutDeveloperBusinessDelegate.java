package com.liferay.layout.developer.businessdelegate;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import com.liferay.layout.developer.constant.LayoutConstants;
import com.liferay.layout.developer.controller.LayoutDeveloper;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.util.comparator.PortletTitleComparator;

/**
 * @author vipin.bardia
 * @email bardia.vipin@gmail.com
 */
public class LayoutDeveloperBusinessDelegate {
	public static final Log LOGGER = LogFactoryUtil
			.getLog(LayoutDeveloper.class);

	/**
	 * Used to create directory structure for Layout plugin and create a war from it and delete that directory.
	 * @param layoutName
	 * @throws IOException
	 */
	public static File createAndZipLayoutStructure(String layoutName,String dataUrl,String tplContent) throws IOException{
		String layoutNameDash = layoutName.replace(StringPool.SPACE, StringPool.DASH);
		layoutNameDash = layoutNameDash.replace(StringPool.UNDERLINE, StringPool.DASH);
		
		String layoutNameUnderscore = layoutName.replace(StringPool.SPACE, StringPool.UNDERLINE);
		layoutNameUnderscore = layoutNameUnderscore.replace(StringPool.DASH, StringPool.UNDERLINE);
		
		File directory = createDirectiryStructure(layoutNameDash, layoutNameUnderscore,dataUrl,tplContent);
		
		File warFile = zip(directory, layoutNameUnderscore);
		FileUtils.deleteDirectory(directory);
		
		return warFile;
	}
	
	/**
	 * Used to create directory structure of layout plugin. 
	 * @param layoutNameDash
	 * @param layoutNameUnderscore
	 * @return File
	 * @throws IOException
	 */
	private static File createDirectiryStructure(String layoutNameDash, String layoutNameUnderscore,String dataUrl,String tplContent) throws IOException{
		File directory = createTempDir(null,layoutNameDash);
		File webInfDir = createTempDir(directory,LayoutConstants.DIR_WEB_INF);
		File metaInfDir = createTempDir(directory,LayoutConstants.DIR_META_INF);
		
		File metainf = createTempFile(metaInfDir,LayoutConstants.MANIFEST, LayoutConstants.EXTENSION_MF);
		FileUtils.writeStringToFile(metainf, LayoutConstants.MANIFEST_DATA);
		
		File tplFile = createTempFile(directory,layoutNameUnderscore, LayoutConstants.EXTENSION_TPL);
		FileUtils.writeStringToFile(tplFile, tplContent);
		
		File wapTplFile = createTempFile(directory,layoutNameUnderscore + StringPool.PERIOD + LayoutConstants.EXTENSION_WAP, LayoutConstants.EXTENSION_TPL);
		FileUtils.writeStringToFile(wapTplFile,tplContent);
		
		File pngFile = createTempFile(directory,layoutNameUnderscore, LayoutConstants.EXTENSION_PNG);
		if(!dataUrl.isEmpty()){
			createPng(dataUrl, pngFile);
		}
		
		File layoutTemplate = createTempFile(webInfDir,LayoutConstants.FILE_LAYOUT_TEMPLATE, LayoutConstants.EXTENSION_XML);
		String strLayoutTemplate = LayoutConstants.LAYOUT_TEMPLATE_XML_FILE.replace(LayoutConstants.LAYOUT_ID, layoutNameUnderscore);
		FileUtils.writeStringToFile(layoutTemplate, strLayoutTemplate);
		
		File pluginPackage = createTempFile(webInfDir,LayoutConstants.FILE_PLUGIN_PACKAGE, LayoutConstants.EXTENSION_PROP);
		String strPluginPackage = LayoutConstants.PLUGIN_PACKAGE.replace(LayoutConstants.LAYOUT_ID, layoutNameDash);
		FileUtils.writeStringToFile(pluginPackage, strPluginPackage);
		
		return directory;
	}
	/**
	 * Used to create directory if one does not exists without time stamp.
	 * @param parent
	 * @param folderName
	 * @return File
	 * @throws IOException
	 */
	public static File createTempDir(File parent,String folderName) throws IOException {
	    final String baseTempPath = System.getProperty("java.io.tmpdir");

	    File tempDir  = null;
	    
	    if(parent==null){
	    	tempDir = new File(baseTempPath + File.separator + folderName );
	    } else {
	    	LOGGER.info("CANONICAL PATH :: " + parent.getCanonicalPath());
	    	LOGGER.info("ABSOLUTE PATH :: " + parent.getAbsolutePath());
	    	tempDir = new File(parent.getAbsolutePath() + File.separator + folderName );
	    }
	    
	    if (tempDir.exists() == false) {
	        tempDir.mkdir();
	    }

	    return tempDir;
	}
	

	/**
	 * Used to create file without time stamp.
	 * @param diretory
	 * @param prefix
	 * @param suffix
	 * @return File
	 */
	public static File createTempFile(File diretory,String prefix, String suffix){
	     String fileName = (prefix != null ? prefix : "temp" ) + "." +  (suffix != null ? suffix : "xml" ) ;
	     
	     final String baseTempPath = System.getProperty("java.io.tmpdir");
		    
		    if(diretory==null){
		    	diretory = new File(baseTempPath );
		    } 
		    
		    File tempFile = new File(diretory, fileName);
		    
	     return tempFile;
	}
	
	/**
	 * Used to zip directory recursively.
	 * @param directory
	 * @param layoutNameUnderscore
	 * @throws IOException
	 */
	public static File zip(File directory, String layoutNameUnderscore) throws IOException {
		
		File zipfile = createTempFile(null, layoutNameUnderscore, LayoutConstants.EXTENSION_WAR);
		
	    URI base = directory.toURI();
	    Deque<File> queue = new LinkedList<File>();
	    queue.push(directory);
	    OutputStream out = new FileOutputStream(zipfile);
	    Closeable res = out;
	    try {
	      ZipOutputStream zout = new ZipOutputStream(out);
	      res = zout;
	      while (!queue.isEmpty()) {
	        directory = queue.pop();
	        for (File kid : directory.listFiles()) {
	          String name = base.relativize(kid.toURI()).getPath();
	          if (kid.isDirectory()) {
	            queue.push(kid);
	            name = name.endsWith("/") ? name : name + "/";
	            zout.putNextEntry(new ZipEntry(name));
	          } else {
	            zout.putNextEntry(new ZipEntry(name));
	            copy(kid, zout);
	            zout.closeEntry();
	          }
	        }
	      }
	    } finally {
	      res.close();
	    }
	    
	    return zipfile;
	  }
	
	 private static void copy(File file, OutputStream out) throws IOException {
		    InputStream in = new FileInputStream(file);
		    try {
		      copy(in, out);
		    } finally {
		      in.close();
		    }
		  }
	 
	 private static void copy(InputStream in, OutputStream out) throws IOException {
		    byte[] buffer = new byte[1024];
		    while (true) {
		      int readCount = in.read(buffer);
		      if (readCount < 0) {
		        break;
		      }
		      out.write(buffer, 0, readCount);
		    }
		  }
	 
	 /**
	  * Used to get Portlet List
	  * @param companyId
	  * @param locale
	  * @return List<Portlet>
	  */
	 public static List<Portlet> getPortletList(long companyId, Locale locale)
	  {
		 List<Portlet> portletList = null;
	    try
	    {
	      portletList = PortletLocalServiceUtil.getPortlets(companyId, false, false);
	      portletList = ListUtil.sort(portletList, new PortletTitleComparator(locale));
	      
	      Iterator<Portlet> iterator = portletList.iterator();
	      while(iterator.hasNext()){
	    	  Portlet portlet = iterator.next();
	    	  if(!portlet.isActive() || portlet.isSystem()){
	    		  iterator.remove();
	    	  }
	      }
	    }
	    catch (SystemException e)
	    {
	      LOGGER.error("System Exception while fetching portlet names :: " + e.getMessage());
	    }
	    return portletList;
	  }
	 
	 /**
	  * This method will create png image for layout icon.
	  * @param dataUrl
	  * @param layoutNameUnderscore
	  * @return File
	  * @throws IOException
	  */
	 private static void createPng(String dataUrl,File pngFile) {
		String encodingPrefix = "base64,";
		try{
			int contentStartIndex = dataUrl.indexOf(encodingPrefix) + encodingPrefix.length();
			byte[] imageData = org.apache.commons.codec.binary.Base64.decodeBase64(dataUrl.substring(contentStartIndex));
			BufferedImage inputImage = ImageIO.read(new ByteArrayInputStream(imageData));
			ImageIO.write(inputImage, LayoutConstants.EXTENSION_PNG, pngFile);
			
		} catch(Exception e){
			LOGGER.error("Unable to create icon for layout :: " + e.getMessage());
		}
	 }
}
