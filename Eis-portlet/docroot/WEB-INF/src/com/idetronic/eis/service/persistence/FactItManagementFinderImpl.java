package com.idetronic.eis.service.persistence;

import java.util.List;

import com.idetronic.eis.model.FactIrItem;
import com.idetronic.eis.model.FactIrSubmission;
import com.idetronic.eis.model.FactItManagement;
import com.idetronic.eis.model.impl.FactIrItemImpl;
import com.idetronic.eis.model.impl.FactIrSubmissionImpl;
import com.idetronic.eis.model.impl.FactItManagementImpl;
import com.idetronic.eis.model.impl.FactNonPrintedMaterialImpl;
import com.idetronic.eis.model.impl.ItemMediumImpl;
import com.idetronic.eis.model.impl.ItemTypeImpl;
import com.idetronic.eis.model.impl.MasterFileImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class FactItManagementFinderImpl extends BasePersistenceImpl<FactItManagement>
implements FactItManagementFinder
{
	public List<FactItManagement> getLatestEntry (long libraryId,String period)
	{
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(
	        		FIND_LATEST_BY_PERIOD);

	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("FactItManagement", FactItManagementImpl.class); 

	        QueryPos qPos = QueryPos.getInstance(q);  
	        qPos.add(libraryId);
	        qPos.add(period);
	       
	        

	        List<FactItManagement> results = (List<FactItManagement>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        
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
	        q.addEntity("FactItManagement", FactItManagementImpl.class); 
	        q.addEntity("ItemType", MasterFileImpl.class);
	        //q.addEntity("ItemMedium", MasterFileImpl.class);
	        
	        
	        
	        
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
	
	public static final String FIND_LATEST_BY_PERIOD =
			FactItManagementFinder.class.getName() +
		        ".findLatestEntryByLP";
	
	public static final String FIND_ENTRY_HISTORY =
			FactItManagementFinder.class.getName() +
		        ".getHistoryByL_P";
	
	private static Log LOGGER = LogFactoryUtil.getLog(FactItManagementFinderImpl.class);

}