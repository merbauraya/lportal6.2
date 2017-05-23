package com.idetronic.eis.service.persistence;

import java.util.List;

import com.idetronic.eis.model.FactVisitor;
import com.idetronic.eis.model.impl.FactPostImpl;
import com.idetronic.eis.model.impl.FactVisitorImpl;
import com.idetronic.eis.model.impl.MasterFileImpl;
import com.idetronic.eis.model.impl.VisitorCategoryImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class FactVisitorFinderImpl extends BasePersistenceImpl<FactVisitor>
implements FactVisitorFinder
{
	
	/**
	 * Get latest data entry
	 */
	public List<FactVisitor> findLatestEntry (long libraryId,String period)
	{
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(
	        		FIND_LATEST_BY_LIBRARY_PERIOD_ALL);

	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("FactVisitor", FactVisitorImpl.class); 

	        QueryPos qPos = QueryPos.getInstance(q);  
	        qPos.add(libraryId);
	        qPos.add(period);
	        

	        List<FactVisitor> results = (List<FactVisitor>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        
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
	
	public List getHistory(long libraryId,String period)
	{
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(
	        		FIND_ENTRY_HISTORY);

	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("FactVisitor", FactVisitorImpl.class); 
	        q.addEntity("MasterFile", MasterFileImpl.class);

	        QueryPos qPos = QueryPos.getInstance(q);  
	        qPos.add(libraryId);
	        qPos.add(period);
	        
	        
	        return (List) q.list();
	        //List<FactVisitor> results = (List<FactVisitor>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        
	        
	    
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
	
	public static final String FIND_LATEST_BY_LIBRARY_PERIOD_ALL =
			FactVisitorFinder.class.getName() +
		        ".findLatestEntryByL_P";
	public static final String FIND_ENTRY_HISTORY =
			FactVisitorFinder.class.getName() +
		        ".getHistoryByL_P";
	private static Log LOGGER = LogFactoryUtil.getLog(FactVisitorFinderImpl.class);

}