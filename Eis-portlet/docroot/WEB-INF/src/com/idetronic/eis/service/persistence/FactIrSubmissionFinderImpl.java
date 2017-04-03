package com.idetronic.eis.service.persistence;

import java.util.List;

import com.idetronic.eis.model.FactIrSubmission;
import com.idetronic.eis.model.FactPost;
import com.idetronic.eis.model.impl.FactIrSubmissionImpl;
import com.idetronic.eis.model.impl.FactPostImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class FactIrSubmissionFinderImpl extends BasePersistenceImpl<FactIrSubmission>
implements FactIrSubmissionFinder
{
	public List<FactIrSubmission> findLatestEntry (long libraryId,String period,long facultyId)
	{
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(
	        		FIND_LATEST_BY_LIBRARY_PERIOD_FACULTY);

	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("FactIrSubmission", FactIrSubmissionImpl.class); 

	        QueryPos qPos = QueryPos.getInstance(q);  
	        qPos.add(libraryId);
	        qPos.add(period);
	        qPos.add(facultyId);

	        List<FactIrSubmission> results = (List<FactIrSubmission>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        
	        return results;
	    
	    } catch (Exception e) {
	        try {
	            throw new SystemException(e);
	        } catch (SystemException se) {
	            se.printStackTrace();
	        }
	    } finally {
	        closeSession(session);
	    }

	    return null;
	}
	
	public static final String FIND_LATEST_BY_LIBRARY_PERIOD_FACULTY =
			FactIrSubmissionFinder.class.getName() +
		        ".findLatestEntryByL_P_F";
	private static Log LOGGER = LogFactoryUtil.getLog(FactIrSubmissionFinderImpl.class);

}