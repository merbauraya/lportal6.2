package com.idetronic.eis.service.persistence;

import java.util.List;

import com.idetronic.eis.model.FactNonPrintedMaterial;
import com.idetronic.eis.model.FactPrintedMaterial;
import com.idetronic.eis.model.impl.FactNonPrintedMaterialImpl;
import com.idetronic.eis.model.impl.FactPrintedMaterialImpl;
import com.idetronic.eis.model.impl.ItemTypeImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class FactNonPrintedMaterialFinderImpl extends BasePersistenceImpl<FactPrintedMaterial>
implements FactNonPrintedMaterialFinder
{
	public FactNonPrintedMaterial findItemTypeLatestEntry(long libraryId,String period,long itemTypeId)
	{
		Session session = null;
	    try {
	        session = openSession();
	
	        String sql = CustomSQLUtil.get(
	        		FIND_LATEST_BY_LIBRARY_PERIOD_ITEMTYPE);
	
	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("Fact", FactPrintedMaterialImpl.class);
	
	        QueryPos qPos = QueryPos.getInstance(q);  
	        qPos.add(libraryId);
	        qPos.add(period);
	        qPos.add(itemTypeId);
	
	        List<FactNonPrintedMaterial> results = (List<FactNonPrintedMaterial>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        
	        if (results.size() > 0)
	        	return results.get(0);
	    
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
	public List<FactNonPrintedMaterial> findAllLatestEntry(long libraryId,String period)
	{
		Session session = null;
	    try {
	        session = openSession();
	
	        String sql = CustomSQLUtil.get(
	        		FIND_LATEST_BY_LIBRARY_PERIOD_ALL);
	
	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("Fact", FactNonPrintedMaterialImpl.class);
	
	        QueryPos qPos = QueryPos.getInstance(q);  
	        qPos.add(libraryId);
	        qPos.add(period);
	        
	
	        List<FactNonPrintedMaterial> results = (List<FactNonPrintedMaterial>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        
	        
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
	        q.addEntity("FactNonPrintedMaterial", FactNonPrintedMaterialImpl.class); 
	        q.addEntity("ItemType", ItemTypeImpl.class);

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
			FactNonPrintedMaterialFinder.class.getName() +
		        ".findLatestEntryByL_P";
	public static final String FIND_LATEST_BY_LIBRARY_PERIOD_ITEMTYPE =
	FactNonPrintedMaterialFinder.class.getName() +
	    ".findLatestEntryByL_P_T";
	
	public static final String FIND_ENTRY_HISTORY =
			FactNonPrintedMaterialFinder.class.getName() +
			    ".getHistoryByL_P";
}