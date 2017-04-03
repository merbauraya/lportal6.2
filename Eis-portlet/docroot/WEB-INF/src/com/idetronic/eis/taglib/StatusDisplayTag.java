package com.idetronic.eis.taglib;

import javax.servlet.http.HttpServletRequest;

import com.liferay.taglib.util.IncludeTag;

public class StatusDisplayTag extends IncludeTag{
	
	final String _PAGE = "/html/taglib/eis/status_display.jsp";
	private int m_status = 3;
	private int m_progress;
	
	public void setStatus(int value)
	{
		m_status = value;
	}
	
	public int getStatus()
	{
		return m_status;
	}
	public void setProgress(int value)
	{
		m_progress = value;
	}
	
	public int getProgress()
	{
		return m_progress;
	}
	
			
	@Override
	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("eis:status-display:status", m_status);
		request.setAttribute("eis:status-display:progress", m_progress);


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
