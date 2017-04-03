package com.idetronic.eis.taglib;

import javax.servlet.http.HttpServletRequest;

import com.liferay.taglib.util.IncludeTag;

public class ProgressStatusSelectorTag extends IncludeTag{
	
	final String _PAGE = "/html/taglib/eis/progress_selector.jsp";
	private int m_status = 3;
	private String m_controlName = "progressStatus";
	
	public void setProgressStatus(int value)
	{
		m_status = value;
	}
	public void setControlName(String name)
	{
		m_controlName = name;
	}
	
	public int getProgressStatus()
	{
		return m_status;
	}
	
	public String getControlName()
	{
		return m_controlName;
	}
			
	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("eis:progress-selector:progressStatus", m_status);
		request.setAttribute("eis:progress-selector:controlName", m_controlName);


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
