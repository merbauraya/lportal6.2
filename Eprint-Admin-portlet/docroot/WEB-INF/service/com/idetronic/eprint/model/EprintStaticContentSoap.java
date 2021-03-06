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

package com.idetronic.eprint.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mazlan Mat
 * @generated
 */
public class EprintStaticContentSoap implements Serializable {
	public static EprintStaticContentSoap toSoapModel(EprintStaticContent model) {
		EprintStaticContentSoap soapModel = new EprintStaticContentSoap();

		soapModel.setContentId(model.getContentId());
		soapModel.setContent(model.getContent());

		return soapModel;
	}

	public static EprintStaticContentSoap[] toSoapModels(
		EprintStaticContent[] models) {
		EprintStaticContentSoap[] soapModels = new EprintStaticContentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EprintStaticContentSoap[][] toSoapModels(
		EprintStaticContent[][] models) {
		EprintStaticContentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EprintStaticContentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EprintStaticContentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EprintStaticContentSoap[] toSoapModels(
		List<EprintStaticContent> models) {
		List<EprintStaticContentSoap> soapModels = new ArrayList<EprintStaticContentSoap>(models.size());

		for (EprintStaticContent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EprintStaticContentSoap[soapModels.size()]);
	}

	public EprintStaticContentSoap() {
	}

	public long getPrimaryKey() {
		return _contentId;
	}

	public void setPrimaryKey(long pk) {
		setContentId(pk);
	}

	public long getContentId() {
		return _contentId;
	}

	public void setContentId(long contentId) {
		_contentId = contentId;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	private long _contentId;
	private String _content;
}