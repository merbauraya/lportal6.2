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

import com.idetronic.eis.model.KpiEntry;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing KpiEntry in entity cache.
 *
 * @author Mazlan Mat
 * @see KpiEntry
 * @generated
 */
public class KpiEntryCacheModel implements CacheModel<KpiEntry>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{kpiEntryId=");
		sb.append(kpiEntryId);
		sb.append(", kpiTypeId=");
		sb.append(kpiTypeId);
		sb.append(", periodYear=");
		sb.append(periodYear);
		sb.append(", periodType=");
		sb.append(periodType);
		sb.append(", period=");
		sb.append(period);
		sb.append(", value=");
		sb.append(value);
		sb.append(", actual=");
		sb.append(actual);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public KpiEntry toEntityModel() {
		KpiEntryImpl kpiEntryImpl = new KpiEntryImpl();

		kpiEntryImpl.setKpiEntryId(kpiEntryId);
		kpiEntryImpl.setKpiTypeId(kpiTypeId);

		if (periodYear == null) {
			kpiEntryImpl.setPeriodYear(StringPool.BLANK);
		}
		else {
			kpiEntryImpl.setPeriodYear(periodYear);
		}

		kpiEntryImpl.setPeriodType(periodType);

		if (period == null) {
			kpiEntryImpl.setPeriod(StringPool.BLANK);
		}
		else {
			kpiEntryImpl.setPeriod(period);
		}

		kpiEntryImpl.setValue(value);
		kpiEntryImpl.setActual(actual);

		kpiEntryImpl.resetOriginalValues();

		return kpiEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		kpiEntryId = objectInput.readLong();
		kpiTypeId = objectInput.readLong();
		periodYear = objectInput.readUTF();
		periodType = objectInput.readInt();
		period = objectInput.readUTF();
		value = objectInput.readDouble();
		actual = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(kpiEntryId);
		objectOutput.writeLong(kpiTypeId);

		if (periodYear == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(periodYear);
		}

		objectOutput.writeInt(periodType);

		if (period == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(period);
		}

		objectOutput.writeDouble(value);
		objectOutput.writeDouble(actual);
	}

	public long kpiEntryId;
	public long kpiTypeId;
	public String periodYear;
	public int periodType;
	public String period;
	public double value;
	public double actual;
}