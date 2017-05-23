package com.idetronic.eis.service.persistence;

import java.util.List;

import com.idetronic.eis.model.FactIrItem;
import com.idetronic.eis.model.FactIrSubmission;
import com.idetronic.eis.model.FactSeating;
import com.idetronic.eis.model.impl.FactIrItemImpl;
import com.idetronic.eis.model.impl.FactSeatingImpl;
import com.idetronic.eis.model.impl.FactVisitorImpl;
import com.idetronic.eis.model.impl.MasterFileImpl;
import com.idetronic.eis.model.impl.SeatingCategoryImpl;
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

public class FactSeatingFinderImpl extends BasePersistenceImpl<FactSeating>
implements FactSeatingFinder
{
	public List<FactSeating> findLatestEntry (long libraryId,String period)
	{
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(
	        		FIND_LATEST_BY_LIBRARY_PERIOD);

	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("FactSeating", FactSeatingImpl.class); 

	        QueryPos qPos = QueryPos.getInstance(q);  
	        
	        qPos.add(libraryId);
	        qPos.add(period);
	       

	        List<FactSeating> results = (List<FactSeating>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        
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
	        q.addEntity("FactSeating", FactSeatingImpl.class); 
	        q.addEntity("SeatingCategory", MasterFileImpl.class);

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
	
	public static final String FIND_LATEST_BY_LIBRARY_PERIOD =
			FactSeatingFinder.class.getName() +
		        ".findLatestEntryByP_L";
	public static final String FIND_ENTRY_HISTORY =
			FactSeatingFinder.class.getName() +
		        ".getHistoryByL_P";
	
	private static Log LOGGER = LogFactoryUtil.getLog(FactSeatingFinderImpl.class);

}