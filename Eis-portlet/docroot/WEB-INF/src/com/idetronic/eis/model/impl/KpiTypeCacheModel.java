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

import com.idetronic.eis.model.KpiType;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing KpiType in entity cache.
 *
 * @author Mazlan Mat
 * @see KpiType
 * @generated
 */
public class KpiTypeCacheModel implements CacheModel<KpiType>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{kpiTypeId=");
		sb.append(kpiTypeId);
		sb.append(", kpiTypeKey=");
		sb.append(kpiTypeKey);
		sb.append(", kpiName=");
		sb.append(kpiName);
		sb.append(", periodMonth=");
		sb.append(periodMonth);
		sb.append(", periodQuarter=");
		sb.append(periodQuarter);
		sb.append(", periodSemiAnnual=");
		sb.append(periodSemiAnnual);
		sb.append(", periodYear=");
		sb.append(periodYear);
		sb.append(", isDecimal=");
		sb.append(isDecimal);
		sb.append(", manualValue=");
		sb.append(manualValue);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public KpiType toEntityModel() {
		KpiTypeImpl kpiTypeImpl = new KpiTypeImpl();

		kpiTypeImpl.setKpiTypeId(kpiTypeId);

		if (kpiTypeKey == null) {
			kpiTypeImpl.setKpiTypeKey(StringPool.BLANK);
		}
		else {
			kpiTypeImpl.setKpiTypeKey(kpiTypeKey);
		}

		if (kpiName == null) {
			kpiTypeImpl.setKpiName(StringPool.BLANK);
		}
		else {
			kpiTypeImpl.setKpiName(kpiName);
		}

		kpiTypeImpl.setPeriodMonth(periodMonth);
		kpiTypeImpl.setPeriodQuarter(periodQuarter);
		kpiTypeImpl.setPeriodSemiAnnual(periodSemiAnnual);
		kpiTypeImpl.setPeriodYear(periodYear);
		kpiTypeImpl.setIsDecimal(isDecimal);
		kpiTypeImpl.setManualValue(manualValue);

		kpiTypeImpl.resetOriginalValues();

		return kpiTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		kpiTypeId = objectInput.readLong();
		kpiTypeKey = objectInput.readUTF();
		kpiName = objectInput.readUTF();
		periodMonth = objectInput.readBoolean();
		periodQuarter = objectInput.readBoolean();
		periodSemiAnnual = objectInput.readBoolean();
		periodYear = objectInput.readBoolean();
		isDecimal = objectInput.readBoolean();
		manualValue = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(kpiTypeId);

		if (kpiTypeKey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(kpiTypeKey);
		}

		if (kpiName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(kpiName);
		}

		objectOutput.writeBoolean(periodMonth);
		objectOutput.writeBoolean(periodQuarter);
		objectOutput.writeBoolean(periodSemiAnnual);
		objectOutput.writeBoolean(periodYear);
		objectOutput.writeBoolean(isDecimal);
		objectOutput.writeBoolean(manualValue);
	}

	public long kpiTypeId;
	public String kpiTypeKey;
	public String kpiName;
	public boolean periodMonth;
	public boolean periodQuarter;
	public boolean periodSemiAnnual;
	public boolean periodYear;
	public boolean isDecimal;
	public boolean manualValue;
}