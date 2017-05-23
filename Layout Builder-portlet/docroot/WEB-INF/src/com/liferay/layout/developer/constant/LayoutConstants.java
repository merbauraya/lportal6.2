package com.liferay.layout.developer.constant;

public final class LayoutConstants {

	public static final String LAYOUT_TEMPLATE_XML_FILE="<?xml version='1.0'?><layout-templates><custom><layout-template id='LAYOUT_ID' name='LAYOUT_ID'>" +
			"<template-path>/LAYOUT_ID.tpl</template-path><wap-template-path>/LAYOUT_ID.wap.tpl</wap-template-path>" +
			"<thumbnail-path>/LAYOUT_ID.png</thumbnail-path></layout-template></custom></layout-templates>";
	
	public static final String PLUGIN_PACKAGE = "name=LAYOUT_ID\nmodule-group-id=liferay\nmodule-incremental-version=1\ntags=layout, template, ui\nshort-description=" +
	"long-description=Layout Templates\nchange-log=\npage-url=http://www.liferay.com\nauthor=Liferay, Inc.\nlicenses=LGPL\nliferay-versions=6.2.0+";

	// File and Directories name
	public static final String MANIFEST = "MANIFEST";
	public static final String DIR_META_INF = "META-INF";
	public static final String DIR_WEB_INF = "WEB-INF";
	public static final String FILE_PLUGIN_PACKAGE= "liferay-plugin-package";
	public static final String FILE_LAYOUT_TEMPLATE = "liferay-layout-templates";
	
	public static final String MANIFEST_DATA = "Manifest-Version: 1.0\n\rClass-Path:"; 
	public static final String LAYOUT_ID = "LAYOUT_ID";
	
	// File Extensions
	public static final String EXTENSION_WAP = "wap";
	public static final String EXTENSION_TPL = "tpl";
	public static final String EXTENSION_MF = "MF";
	public static final String EXTENSION_XML = "xml";
	public static final String EXTENSION_PNG = "png";
	public static final String EXTENSION_WAR = "war";
	public static final String EXTENSION_PROP = "properties";
	
	private LayoutConstants(){
		throw new AssertionError();
	}
}
