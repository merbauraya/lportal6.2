package com.idetronic.eis.taglib;

import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.taglib.util.IncludeTag;

public class PeriodSelectorTag extends IncludeTag{
	
	final String _PAGE = "/html/taglib/eis/period_selector.jsp";
	private String m_value = StringPool.BLANK;
	private String m_controlName = "period";
	private boolean m_useMonthName = false;
	private boolean m_allowPreviousYear;
	private boolean m_useYearRange;
	private boolean m_includeEmptyOption = false;
	private boolean m_allowFuturePeriod = false;
	
	private int m_numberPreviousYear;
	private int m_numberFutureYear;
	
	
	private int m_startYear = 2015;
	private int m_endYear = 2020;
	private int m_dataCountDay = 10;
	
	
	public int getNumberFutureYear()
	{
		return m_numberFutureYear;
	}
	public boolean getIncludeEmptyOption()
	{
		return m_includeEmptyOption ;
	}
	public void setIncludeEmptyOption(boolean value)
	{
		m_includeEmptyOption = value;
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
	public boolean getAllowFuturePeriod()
	{
		return m_allowFuturePeriod;
	}
	
	public void setAllowFuturePeriod(boolean value)
	{
		m_allowFuturePeriod = value;
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
	public void setUseMonthName(boolean value)
	{
		m_useMonthName = value;
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
	public boolean getUseMonthName()
	{
		return m_useMonthName;
	}
	public int getStartYear()
	{
		return m_startYear;
	}
	
	public int getEndYear()
	{
		return m_endYear;
	}
	
	public void setdataCountDay(int value)
	{
		m_dataCountDay = value;
	}
	public int getDataCountDay()
	{
		return m_dataCountDay;
	}
	
	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("eis:period-selector:value", m_value);
		request.setAttribute("eis:period-selector:controlName", m_controlName);
		request.setAttribute("eis:period-selector:useMonthName", String.valueOf(m_useMonthName));
		request.setAttribute("eis:period-selector:startYear", String.valueOf(m_startYear));
		request.setAttribute("eis:period-selector:endYear", String.valueOf(m_endYear));
		request.setAttribute("eis:period-select:allowPreviousYear", String.valueOf(m_allowPreviousYear));
		request.setAttribute("eis:period-selector:useYearRange", String.valueOf(m_useYearRange));
		request.setAttribute("eis:period-selector:includeEmptyOption", String.valueOf(m_includeEmptyOption));
		request.setAttribute("eis:period-selector:numberPreviousYear", String.valueOf(m_numberPreviousYear));
		request.setAttribute("eis:period-selector:numberFutureYear", String.valueOf(m_numberFutureYear) );
		request.setAttribute("eis:period-selector:dataCountDay", String.valueOf(m_dataCountDay) );
		request.setAttribute("eis:period-selector:allowFuturePeriod", String.valueOf(m_allowFuturePeriod) );
	}
	
	@Override
	public int doStartTag() {
		return EVAL_BODY_INCLUDE;
	}
	@Override
	protected String getPage() {
		return _PAGE;
	}
	private static Log LOGGER = LogFactoryUtil.getLog(PeriodSelectorTag.class);
}