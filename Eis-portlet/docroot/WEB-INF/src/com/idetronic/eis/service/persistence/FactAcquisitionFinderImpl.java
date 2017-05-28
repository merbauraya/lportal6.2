package com.idetronic.eis.service.persistence;

import java.util.List;

import com.idetronic.eis.model.FactAcquisition;
import com.idetronic.eis.model.impl.FactAcquisitionImpl;
import com.idetronic.eis.model.impl.MasterFileImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class FactAcquisitionFinderImpl extends BasePersistenceImpl<FactAcquisition> implements FactAcquisitionFinder
{
	
	public List<FactAcquisition> getLatestEntry (long facultyId,String period)
	{
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(
	        		FIND_LATEST_BY_PERIOD);

	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("FactAcquisition", FactAcquisitionImpl.class); 

	        QueryPos qPos = QueryPos.getInstance(q);  
	        qPos.add(facultyId);
	        qPos.add(period);
	       
	        

	        List<FactAcquisition> results = (List<FactAcquisition>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        
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
	
	public List getHistory(long facultyId,String period)
	{
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(
	        		FIND_ENTRY_HISTORY);

	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("FactAcquisition", FactAcquisitionImpl.class); 
	        q.addEntity("MasterFile", MasterFileImpl.class);
	        
	        
	        QueryPos qPos = QueryPos.getInstance(q);  
	        qPos.add(facultyId);
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
	
	
	public static final String FIND_LATEST_BY_PERIOD =
			FactAcquisitionFinder.class.getName() +
		        ".findLatestEntryByL_P";
	
	public static final String FIND_ENTRY_HISTORY =
			FactAcquisitionFinder.class.getName() +
		        ".getHistoryByL_P";
	
	

}