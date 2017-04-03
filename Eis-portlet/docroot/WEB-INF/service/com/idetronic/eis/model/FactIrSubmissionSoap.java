/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.idetronic.eis.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.idetronic.eis.service.http.FactIrSubmissionServiceSoap}.
 *
 * @author Mazlan Mat
 * @see com.idetronic.eis.service.http.FactIrSubmissionServiceSoap
 * @generated
 */
public class FactIrSubmissionSoap implements Serializable {
	public static FactIrSubmissionSoap toSoapModel(FactIrSubmission model) {
		FactIrSubmissionSoap soapModel = new FactIrSubmissionSoap();

		soapModel.setSubmissionId(model.getSubmissionId());
		soapModel.setLibraryId(model.getLibraryId());
		soapModel.setFacultyId(model.getFacultyId());
		soapModel.setPeriod(model.getPeriod());
		soapModel.setItemMediumId(model.getItemMediumId());
		soapModel.setTitleTotal(model.getTitleTotal());
		soapModel.setVolumeTotal(model.getVolumeTotal());
		soapModel.setCreatedByUserId(model.getCreatedByUserId());
		soapModel.setCreatedByUserName(model.getCreatedByUserName());
		soapModel.setCreatedDate(model.getCreatedDate());

		return soapModel;
	}

	public static FactIrSubmissionSoap[] toSoapModels(FactIrSubmission[] models) {
		FactIrSubmissionSoap[] soapModels = new FactIrSubmissionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FactIrSubmissionSoap[][] toSoapModels(
		FactIrSubmission[][] models) {
		FactIrSubmissionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FactIrSubmissionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FactIrSubmissionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FactIrSubmissionSoap[] toSoapModels(
		List<FactIrSubmission> models) {
		List<FactIrSubmissionSoap> soapModels = new ArrayList<FactIrSubmissionSoap>(models.size());

		for (FactIrSubmission model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FactIrSubmissionSoap[soapModels.size()]);
	}

	public FactIrSubmissionSoap() {
	}

	public long getPrimaryKey() {
		return _submissionId;
	}

	public void setPrimaryKey(long pk) {
		setSubmissionId(pk);
	}

	public long getSubmissionId() {
		return _submissionId;
	}

	public void setSubmissionId(long submissionId) {
		_submissionId = submissionId;
	}

	public long getLibraryId() {
		return _libraryId;
	}

	public void setLibraryId(long libraryId) {
		_libraryId = libraryId;
	}

	public long getFacultyId() {
		return _facultyId;
	}

	public void setFacultyId(long facultyId) {
		_facultyId = facultyId;
	}

	public String getPeriod() {
		return _period;
	}

	public void setPeriod(String period) {
		_period = period;
	}

	public long getItemMediumId() {
		return _itemMediumId;
	}

	public void setItemMediumId(long itemMediumId) {
		_itemMediumId = itemMediumId;
	}

	public int getTitleTotal() {
		return _titleTotal;
	}

	public void setTitleTotal(int titleTotal) {
		_titleTotal = titleTotal;
	}

	public int getVolumeTotal() {
		return _volumeTotal;
	}

	public void setVolumeTotal(int volumeTotal) {
		_volumeTotal = volumeTotal;
	}

	public long getCreatedByUserId() {
		return _createdByUserId;
	}

	public void setCreatedByUserId(long createdByUserId) {
		_createdByUserId = createdByUserId;
	}

	public String getCreatedByUserName() {
		return _createdByUserName;
	}

	public void setCreatedByUserName(String createdByUserName) {
		_createdByUserName = createdByUserName;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	private long _submissionId;
	private long _libraryId;
	private long _facultyId;
	private String _period;
	private long _itemMediumId;
	private int _titleTotal;
	private int _volumeTotal;
	private long _createdByUserId;
	private String _createdByUserName;
	private Date _createdDate;
}