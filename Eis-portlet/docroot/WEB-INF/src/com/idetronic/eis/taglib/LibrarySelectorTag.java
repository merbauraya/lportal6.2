package com.idetronic.eis.taglib;

import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.taglib.util.IncludeTag;

public class LibrarySelectorTag extends IncludeTag{
	
	final String _PAGE = "/html/taglib/eis/library_selector.jsp";
	private String m_value = StringPool.BLANK;
	private String m_name = "library";
	private boolean m_AdminAllowAll = false;
	private boolean m_addAllOption = false;
	
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
	
	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("eis:library-selector:value", String.valueOf(m_value));
		request.setAttribute("eis:library-selector:name", m_name);
		request.setAttribute("eis:library-selector:adminAllowAll", String.valueOf(m_AdminAllowAll));
		request.setAttribute("eis:library-selector:addAllOption", String.valueOf(m_addAllOption));

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