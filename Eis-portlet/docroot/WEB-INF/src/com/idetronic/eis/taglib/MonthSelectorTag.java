package com.idetronic.eis.taglib;

import javax.servlet.http.HttpServletRequest;

import com.liferay.taglib.util.IncludeTag;

public class MonthSelectorTag extends IncludeTag{
	
	final String _PAGE = "/html/taglib/eis/month_selector.jsp";
	private int m_value = -20;
	private String m_controlName = "month";
	
	
	public void setValue(int value)
	{
		m_value = value;
	}
	public void setControlName(String name)
	{
		m_controlName = name;
	}
	
	public int getValue()
	{
		return m_value;
	}
	
	public String getControlName()
	{
		return m_controlName;
	}
	
	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("eis:month-selector:value", m_value);
		request.setAttribute("eis:month-selector:controlName", m_controlName);


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
