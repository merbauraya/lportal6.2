package com.hezla.indexer.portlet;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.portlet.calendar.service.CalEventLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class IndexerPortlet
 */
public class IndexerPortlet extends MVCPortlet {
	
	
	public void runIndexer(ActionRequest request,ActionResponse response) throws SearchException, SystemException
	{
		boolean calendar = ParamUtil.getBoolean(request, "calendar");
		boolean document = ParamUtil.getBoolean(request, "document");
		
		if (document)
		{
			indexDocument();
		}
		if (calendar)
		{
			indexCalendar();
		}
		
	}
	
	private void indexCalendar() throws SystemException, SearchException
	{
		Indexer indexer = IndexerRegistryUtil.getIndexer(DLFileEntry.class);
		List<CalEvent> events = CalEventLocalServiceUtil.getCalEvents(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		List<CalendarBooking> bookings = CalendarBookingLocalServiceUtil.getCalendarBookings(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		
		for (CalEvent event : events)
		{
			LOGGER.info(event.getTitle());
			indexer.reindex(event);
		}
		
		for (CalendarBooking booking : bookings)
		{
			LOGGER.info(booking.getTitle());
			indexer.reindex(booking);
		}
	}
	
	private void indexDocument() throws SystemException, SearchException
	{
		Indexer indexer = IndexerRegistryUtil.getIndexer(DLFileEntry.class);
		List<DLFileEntry> files = DLFileEntryLocalServiceUtil.getDLFileEntries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	
		for (DLFileEntry entry : files)
		{
			LOGGER.info(entry.getTitle());
			indexer.reindex(entry);
		}
	}
	
	private static Log LOGGER = LogFactoryUtil.getLog(IndexerPortlet.class);
 

}
