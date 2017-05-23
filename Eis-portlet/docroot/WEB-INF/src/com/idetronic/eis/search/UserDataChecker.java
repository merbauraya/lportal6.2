package com.idetronic.eis.search;

import javax.portlet.RenderResponse;

import com.idetronic.eis.NoSuchUserReportException;
import com.idetronic.eis.model.Report;
import com.idetronic.eis.model.UserReport;
import com.idetronic.eis.service.UserReportLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;

public class UserDataChecker extends RowChecker {
	
	private Report _report;
	private User _user;
	private long _libraryId;
	public UserDataChecker(RenderResponse renderResponse, User user,long libraryId) {
		super(renderResponse);

		_user = user;
		_libraryId = libraryId;
	}

	
	

	@Override
	public boolean isChecked(Object obj) {
		
		
		_report = (Report) obj;
		
		try {
			UserReport userData = UserReportLocalServiceUtil.findyUserData(_user.getUserId(),_libraryId,_report.getReportId());
		} catch (NoSuchUserReportException e) {
			return false;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	
	

	private static Log _log = LogFactoryUtil.getLog(UserDataChecker.class);

	

}