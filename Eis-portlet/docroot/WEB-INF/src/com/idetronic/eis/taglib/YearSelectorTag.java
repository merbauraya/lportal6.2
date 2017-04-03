package com.idetronic.eis.taglib;

import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.taglib.util.IncludeTag;

public class YearSelectorTag extends IncludeTag{
	
	final String _PAGE = "/html/taglib/eis/year_selector.jsp";
	private String m_value = StringPool.BLANK;
	private String m_controlName = "year";
	
	private boolean m_allowPreviousYear;
	private boolean m_useYearRange;
	private int m_numberPreviousYear;
	private int m_numberFutureYear;
	
	
	private int m_startYear = 2015;
	private int m_endYear = 2020;
	
	
	public int getNumberFutureYear()
	{
		return m_numberFutureYear;
	}
	
	public void setNumberFutureYear(int value)
	{
		m_numberFutureYear = value;
	}
	
	
	public void setNumberPreviousYear(int value)
	{
		m_numberPreviousYear = value;
	}
	public int getNumberPreviousYear()
	{
		return m_numberPreviousYear;
	}
	
	public void setUseYearRange(boolean value)
	{
		m_useYearRange = value;
	}
	public boolean getUseYearRange()
	{
		return m_useYearRange;
	}
	
	public void setAllowPreviousYear(boolean value)
	{
		m_allowPreviousYear  =value;
	}
	public boolean getAllowPreviousYear()
	{
		return m_allowPreviousYear;
	}
	
	public void setEndYear(int value)
	{
		m_endYear = value;
	}
	
	public void setStartYear(int value)
	{
		m_startYear = value;
	}
	
	public void setValue(String value)
	{
		m_value = value;
	}
	public void setControlName(String name)
	{
		m_controlName = name;
	}
	
	public String getValue()
	{
		return m_value;
	}
	
	public String getControlName()
	{
		return m_controlName;
	}
	
	public int getStartYear()
	{
		return m_startYear;
	}
	
	public int getEndYear()
	{
		return m_endYear;
	}
	
	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("eis:year-selector:value", m_value);
		request.setAttribute("eis:year-selector:controlName", m_controlName);
		
		request.setAttribute("eis:year-selector:startYear", String.valueOf(m_startYear));
		request.setAttribute("eis:year-selector:endYear", String.valueOf(m_endYear));
		request.setAttribute("eis:period-select:allowPreviousYear", String.valueOf(m_allowPreviousYear));
		request.setAttribute("eis:year-selector:useYearRange", String.valueOf(m_useYearRange));
		
		request.setAttribute("eis:year-selector:numberPreviousYear", String.valueOf(m_numberPreviousYear));
		request.setAttribute("eis:year-selector:numberFutureYear", String.valueOf(m_numberFutureYear) );
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