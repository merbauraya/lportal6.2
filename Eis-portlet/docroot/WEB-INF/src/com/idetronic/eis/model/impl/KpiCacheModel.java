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

import com.idetronic.eis.model.Kpi;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Kpi in entity cache.
 *
 * @author Mazlan Mat
 * @see Kpi
 * @generated
 */
public class KpiCacheModel implements CacheModel<Kpi>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", key=");
		sb.append(key);
		sb.append(", kpiType=");
		sb.append(kpiType);
		sb.append(", value=");
		sb.append(value);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Kpi toEntityModel() {
		KpiImpl kpiImpl = new KpiImpl();

		kpiImpl.setId(id);

		if (key == null) {
			kpiImpl.setKey(StringPool.BLANK);
		}
		else {
			kpiImpl.setKey(key);
		}

		kpiImpl.setKpiType(kpiType);
		kpiImpl.setValue(value);

		if (description == null) {
			kpiImpl.setDescription(StringPool.BLANK);
		}
		else {
			kpiImpl.setDescription(description);
		}

		kpiImpl.resetOriginalValues();

		return kpiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		key = objectInput.readUTF();
		kpiType = objectInput.readInt();
		value = objectInput.readInt();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (key == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(key);
		}

		objectOutput.writeInt(kpiType);
		objectOutput.writeInt(value);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long id;
	public String key;
	public int kpiType;
	public int value;
	public String description;
}