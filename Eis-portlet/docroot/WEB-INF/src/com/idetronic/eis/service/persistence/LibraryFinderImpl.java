package com.idetronic.eis.service.persistence;

import java.util.Iterator;
import java.util.List;

import com.idetronic.eis.model.Library;
import com.idetronic.eis.model.impl.LibraryImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class LibraryFinderImpl extends BasePersistenceImpl<Library>
implements LibraryFinder
{
	
	public List<Library> findMissingPrintedMaterialDataByPeriod(String period)
	{
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(
	        		FIND_MISSING_PRINTED_MATERIAL_DATA_BY_PERIOD);

	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("Library", LibraryImpl.class);

	        QueryPos qPos = QueryPos.getInstance(q);  
	        qPos.add(period);
	        

	        List<Library> results = (List<Library>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	        
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
	
	public int getPrintedItemCountByLibraryPeriod(long libraryId,String period)
	{
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(
	        		COUNT_PRINTED_ITEM_BY_LIBRARY_PERIOD);

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
	
	public int getNonPrintedItemCountByLibraryPeriod(long libraryId,String period)
	{
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(
	        		COUNT_NON_PRINTED_ITEM_BY_LIBRARY_PERIOD);

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
	
	public int getPositionCountByLibraryPeriod(long libraryId,String period)
	{
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(
	        		COUNT_POSITION_BY_LIBRARY_PERIOD);

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
	
	public int getMembershipCountByLibraryPeriod(long libraryId,String period)
	{
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(
	        		COUNT_MEMBERSHIP_BY_LIBRARY_PERIOD);

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
	
	public int getSeatingCountByLibraryPeriod(long libraryId,String period)
	{
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(
	        		COUNT_SEATING_BY_LIBRARY_PERIOD);

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
	
	public int getVisitorCountByLibraryPeriod(long libraryId,String period)
	{
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(
	        		COUNT_VISITOR_BY_LIBRARY_PERIOD);

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
	public int getLoanCountByLibraryPeriod(long libraryId,String period)
	{
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(
	        		COUNT_LOAN_BY_LIBRARY_PERIOD);

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
	/**
	 * Return total row for IR item for a specific library and period
	 * @param libraryId 
	 * @param period
	 * @return
	 */
	public int getIrItemCountByLibraryPeriod(long libraryId,String period)
	{
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(
	        		COUNT_IR_ITEM_BY_LIBRARY_PERIOD);

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
	
	
	
	public static final String FIND_MISSING_PRINTED_MATERIAL_DATA_BY_PERIOD =
			LibraryFinder.class.getName() +
		        ".findMissingPrintedMaterialDataBy_P";
	
	
	public static final String COUNT_IR_ITEM_BY_LIBRARY_PERIOD =
			LibraryFinder.class.getName() +
		        ".CountIrItemByL_P";
	public static final String COUNT_PRINTED_ITEM_BY_LIBRARY_PERIOD =
			LibraryFinder.class.getName() +
		        ".CountPrintedByL_P";
	public static final String COUNT_NON_PRINTED_ITEM_BY_LIBRARY_PERIOD =
			LibraryFinder.class.getName() +
		        ".CountNonPrintedByL_P";
	public static final String COUNT_POSITION_BY_LIBRARY_PERIOD =
			LibraryFinder.class.getName() +
		        ".CountPositionByL_P";
	public static final String COUNT_MEMBERSHIP_BY_LIBRARY_PERIOD =
			LibraryFinder.class.getName() +
		        ".CountLibraryMembershipByL_P";
	
	public static final String COUNT_SEATING_BY_LIBRARY_PERIOD =
			LibraryFinder.class.getName() +
		        ".CountSeatingByL_P";
	public static final String COUNT_VISITOR_BY_LIBRARY_PERIOD =
			LibraryFinder.class.getName() +
		        ".CountVisitorByL_P";
	
	public static final String COUNT_LOAN_BY_LIBRARY_PERIOD =
			LibraryFinder.class.getName() +
		        ".CountLoanByL_P";
	
}