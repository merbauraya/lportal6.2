package com.idetronic.eis.search;

import javax.portlet.RenderResponse;

import com.idetronic.eis.model.Library;
import com.idetronic.eis.model.MasterFile;
import com.idetronic.eis.service.UserLibraryLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;

public class UserLibraryChecker extends RowChecker {
	
	private MasterFile _library;
	private User _user;
	
	public UserLibraryChecker(RenderResponse renderResponse, User user) {
		super(renderResponse);

		_user = user;
	}

	
	public UserLibraryChecker(RenderResponse renderResponse, MasterFile library) {
		super(renderResponse);

		_library = library;
	}

	@Override
	public boolean isChecked(Object obj) {
		User user =  null;//(User)obj;
		MasterFile library = null;
		
		if (obj instanceof User)
		{
			
			_user = (User)obj;
		}else 
		{
			
			_library = (MasterFile)obj;
			
		}
		
		try {
			return UserLibraryLocalServiceUtil.hasAssociation(
					_library.getMasterFileId(), _user.getUserId());
		}
		catch (Exception e) {
			_log.error(e, e);

			return false;
		}
	}
	
	
	

	private static Log _log = LogFactoryUtil.getLog(UserLibraryChecker.class);

	

}