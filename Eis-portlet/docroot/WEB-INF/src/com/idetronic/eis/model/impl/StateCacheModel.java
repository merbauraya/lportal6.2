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

import com.idetronic.eis.model.State;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing State in entity cache.
 *
 * @author Mazlan Mat
 * @see State
 * @generated
 */
public class StateCacheModel implements CacheModel<State>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{stateId=");
		sb.append(stateId);
		sb.append(", stateName=");
		sb.append(stateName);
		sb.append(", stateCode=");
		sb.append(stateCode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public State toEntityModel() {
		StateImpl stateImpl = new StateImpl();

		stateImpl.setStateId(stateId);

		if (stateName == null) {
			stateImpl.setStateName(StringPool.BLANK);
		}
		else {
			stateImpl.setStateName(stateName);
		}

		if (stateCode == null) {
			stateImpl.setStateCode(StringPool.BLANK);
		}
		else {
			stateImpl.setStateCode(stateCode);
		}

		stateImpl.resetOriginalValues();

		return stateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stateId = objectInput.readLong();
		stateName = objectInput.readUTF();
		stateCode = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(stateId);

		if (stateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stateName);
		}

		if (stateCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stateCode);
		}
	}

	public long stateId;
	public String stateName;
	public String stateCode;
}