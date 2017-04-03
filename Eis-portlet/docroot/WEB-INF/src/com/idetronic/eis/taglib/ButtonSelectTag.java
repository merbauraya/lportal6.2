package com.idetronic.eis.taglib;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import com.liferay.portal.kernel.servlet.taglib.aui.ValidatorTag;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.taglib.aui.ValidatorTagImpl;
import com.liferay.taglib.aui.base.BaseSelectTag;
import com.liferay.taglib.util.IncludeTag;

public class ButtonSelectTag extends BaseSelectTag{
	
	final String _PAGE = "/html/taglib/eis/button_select.jsp";
	private String m_value = StringPool.BLANK;
	private String m_name = StringPool.BLANK;
	
	@Override
	public int doEndTag() throws JspException {
		updateFormValidators();

		return super.doEndTag();
	}
	
	

	
	@Override
	public int doStartTag() throws JspException {
		addRequiredValidatorTag();

		return super.doStartTag();
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
		request.setAttribute("eis:button-select:value", m_value);
		request.setAttribute("eis:button-select:name", m_name);


	}
	
	@Override
	protected String getEndPage() {
		return null;
	}

	@Override
	protected String getStartPage() {
		return _PAGE;
	}
	
	@Override
	protected String getPage() {
		return _PAGE;
	}
	protected void addRequiredValidatorTag() {
		if (!getRequired()) {
			return;
		}

		ValidatorTag validatorTag = new ValidatorTagImpl(
			"required", null, null, false);

		addValidatorTag("required", validatorTag);
	}
	protected void addValidatorTag(
			String validatorName, ValidatorTag validatorTag) {

			if (_validators == null) {
				_validators = new HashMap<String, ValidatorTag>();
			}

			_validators.put(validatorName, validatorTag);
		}
	
	protected void updateFormValidators() {
		if (_validators == null) {
			return;
		}

		HttpServletRequest request =
			(HttpServletRequest)pageContext.getRequest();

		Map<String, List<ValidatorTag>> validatorTagsMap =
			(Map<String, List<ValidatorTag>>)request.getAttribute(
				"aui:form:validatorTagsMap");

		if (validatorTagsMap != null) {
			List<ValidatorTag> validatorTags = ListUtil.fromMapValues(
				_validators);

			validatorTagsMap.put(getName(), validatorTags);
		}
	}
	private Map<String, ValidatorTag> _validators;


}