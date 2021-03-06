package com.idetronic.eis.service.persistence;

import java.util.Iterator;
import java.util.List;

import com.idetronic.eis.model.FactDatabaseUsage;
import com.idetronic.eis.model.impl.FactDatabaseUsageImpl;
import com.idetronic.eis.model.impl.MasterFileImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class FactDatabaseUsageFinderImpl extends BasePersistenceImpl<FactDatabaseUsage> implements FactDatabaseUsageFinder
{
	
	public List<FactDatabaseUsage> getLatestEntry (long libraryId,String period)
	{
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(
	        		FIND_LATEST_BY_PERIOD);

	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("FactDatabaseUsage", FactDatabaseUsageImpl.class); 

	        QueryPos qPos = QueryPos.getInstance(q);  
	        qPos.add(libraryId);
	        qPos.add(period);
	       
	        

	        List<FactDatabaseUsage> results = (List<FactDatabaseUsage>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        
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
	        q.addEntity("FactDatabaseUsage", FactDatabaseUsageImpl.class); 
	        q.addEntity("MasterFile", MasterFileImpl.class);
	        
	        
	        QueryPos qPos = QueryPos.getInstance(q);  
	        qPos.add(libraryId);
	        qPos.add(period);
	        
	        
	        return (List) q.list();
	        
	        
	    
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
	
	public int getDataCount(long libraryId,String period)
	{
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(
	        		COUNT_BY_LIBRARY_PERIOD);

	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        
	        q.addScalar("totalCount",Type.INTEGER);
	        
	        QueryPos qPos = QueryPos.getInstance(q);  
	        qPos.add(libraryId);
	        qPos.add(period);
	        
	        Iterator itr = q.list().iterator();
	        
	        if (itr.hasNext()) {
	            int count = (int)itr.next();
	    
	            return count;
	          }
	        
	        

	       
	        
	        return 0;
	    
	    } catch (Exception e) {
	        try {
	            throw new SystemException(e);
	        } catch (SystemException se) {
	            se.printStackTrace();
	        }
	    } finally {
	        closeSession(session);
	    }

	    return 0;
	}
	
	public static final String COUNT_BY_LIBRARY_PERIOD =
			FactDatabaseUsageFinder.class.getName() +
		        ".CountByLibrary_P";
	
	public static final String FIND_LATEST_BY_PERIOD =
			FactDatabaseUsageFinder.class.getName() +
		        ".findLatestEntryByL_P";
	
	public static final String FIND_ENTRY_HISTORY =
			FactDatabaseUsageFinder.class.getName() +
		        ".getHistoryByL_P";
	
	

}