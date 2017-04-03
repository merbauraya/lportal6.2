package com.idetronic.eis.service.persistence;

import java.util.List;

import com.idetronic.eis.model.Loan;
import com.idetronic.eis.model.impl.FactVisitorImpl;
import com.idetronic.eis.model.impl.LoanImpl;
import com.idetronic.eis.model.impl.MemberCategoryImpl;
import com.idetronic.eis.model.impl.VisitorCategoryImpl;
import com.idetronic.eis.portlet.EisPortlet;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class LoanFinderImpl extends BasePersistenceImpl<Loan> implements LoanFinder
{
	
	
	
	public List<Loan> findLatestEntry(long libraryId,String period)
	{
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(
	        		FIND_LATEST_BY_LIBRARY_PERIOD_ALL);

	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("Loan", LoanImpl.class); 

	        QueryPos qPos = QueryPos.getInstance(q);  
	        qPos.add(libraryId);
	        qPos.add(period);
	        

	        List<Loan> results = (List<Loan>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        //LOGGER.info(results.size() + ":"+ libraryId + ":"+period);
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
	        q.addEntity("Loan", LoanImpl.class); 
	        q.addEntity("MemberCategory", MemberCategoryImpl.class);

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
			LoanFinder.class.getName() +
		        ".findLatestEntryByL_P";
	public static final String FIND_ENTRY_HISTORY =
			LoanFinder.class.getName() +
		        ".getHistoryByL_P";
	private static Log LOGGER = LogFactoryUtil.getLog(LoanFinderImpl.class);

}