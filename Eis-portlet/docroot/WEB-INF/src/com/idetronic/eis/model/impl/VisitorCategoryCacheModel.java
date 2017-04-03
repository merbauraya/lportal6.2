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

package com.idetronic.eis.model.impl;

import com.idetronic.eis.model.VisitorCategory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing VisitorCategory in entity cache.
 *
 * @author Mazlan Mat
 * @see VisitorCategory
 * @generated
 */
public class VisitorCategoryCacheModel implements CacheModel<VisitorCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{visitorCategoryId=");
		sb.append(visitorCategoryId);
		sb.append(", visitorCategoryCode=");
		sb.append(visitorCategoryCode);
		sb.append(", visitorCategoryName=");
		sb.append(visitorCategoryName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VisitorCategory toEntityModel() {
		VisitorCategoryImpl visitorCategoryImpl = new VisitorCategoryImpl();

		visitorCategoryImpl.setVisitorCategoryId(visitorCategoryId);

		if (visitorCategoryCode == null) {
			visitorCategoryImpl.setVisitorCategoryCode(StringPool.BLANK);
		}
		else {
			visitorCategoryImpl.setVisitorCategoryCode(visitorCategoryCode);
		}

		if (visitorCategoryName == null) {
			visitorCategoryImpl.setVisitorCategoryName(StringPool.BLANK);
		}
		else {
			visitorCategoryImpl.setVisitorCategoryName(visitorCategoryName);
		}

		visitorCategoryImpl.resetOriginalValues();

		return visitorCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		visitorCategoryId = objectInput.readLong();
		visitorCategoryCode = objectInput.readUTF();
		visitorCategoryName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(visitorCategoryId);

		if (visitorCategoryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(visitorCategoryCode);
		}

		if (visitorCategoryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(visitorCategoryName);
		}
	}

	public long visitorCategoryId;
	public String visitorCategoryCode;
	public String visitorCategoryName;
}