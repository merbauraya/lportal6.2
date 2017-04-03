package com.idetronic.eis.search;

import javax.portlet.RenderResponse;

import com.idetronic.eis.model.Library;

import com.idetronic.eis.service.UserLibraryLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;

public class UserLibraryChecker extends RowChecker {

	public UserLibraryChecker(RenderResponse renderResponse, Library library) {
		super(renderResponse);

		_library = library;
	}

	@Override
	public boolean isChecked(Object obj) {
		User user = (User)obj;

		try {
			return UserLibraryLocalServiceUtil.hasAssociation(
					_library.getLibraryId(), user.getUserId());
		}
		catch (Exception e) {
			_log.error(e, e);

			return false;
		}
	}

	

	private static Log _log = LogFactoryUtil.getLog(UserLibraryChecker.class);

	private Library _library;

}