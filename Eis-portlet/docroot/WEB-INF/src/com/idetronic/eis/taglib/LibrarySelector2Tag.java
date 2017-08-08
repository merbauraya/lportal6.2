package com.idetronic.eis.taglib;

import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.taglib.util.IncludeTag;

public class LibrarySelector2Tag extends IncludeTag{
	
	final String _PAGE = "/html/taglib/eis/library_selector2.jsp";
	private String m_value = StringPool.BLANK;
	private String m_cssClass = StringPool.BLANK;
	private String m_name = "library";
	private boolean m_AdminAllowAll = false;
	private boolean m_addAllOption = false;
	private long m_masterTypeId;
	
	
	public void setMasterTypeId(long value)
	{
		m_masterTypeId = value;
	}
	public long getMasterTypeId()
	{
		return m_masterTypeId;
	}
	public void setAddAllOption(boolean value) 
	{
		m_addAllOption = true;
	}
	public boolean getAddAllOption()
	{
		return m_addAllOption;
	}
	public void setAdminAllowAll(boolean value)
	{
		m_AdminAllowAll = value;
	}
	public boolean getAdminAllowAll()
	{
		return m_AdminAllowAll;
	}
	public void setValue(String value)
	{
		m_value = value;
	}
	public void setName(String name)
	{
		m_name = name;
	}
	
	public String getValue()
	{
		return m_value;
	}
	
	public String getName()
	{
		return m_name;
	}
	public void setCssClass(String value)
	{
		m_cssClass = value;
	}
	public String getCssClass()
	{
		return m_cssClass;
	}
	
	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("eis:library-selector2:value", String.valueOf(m_value));
		request.setAttribute("eis:library-selector2:name", m_name);
		request.setAttribute("eis:library-selector2:adminAllowAll", String.valueOf(m_AdminAllowAll));
		request.setAttribute("eis:library-selector2:addAllOption", String.valueOf(m_addAllOption));
		request.setAttribute("eis:library-selector2:masterTypeId", String.valueOf(m_masterTypeId));
		request.setAttribute("eis:library-selector2:cssClass", m_cssClass );
	}
	
	@Override
	public int doStartTag() {
		return EVAL_BODY_INCLUDE;
	}
	@Override
	protected String getPage() {
		return _PAGE;
	}

}