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

import com.idetronic.eis.model.Faculty;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Faculty in entity cache.
 *
 * @author Mazlan Mat
 * @see Faculty
 * @generated
 */
public class FacultyCacheModel implements CacheModel<Faculty>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{facultyId=");
		sb.append(facultyId);
		sb.append(", facultyTypeId=");
		sb.append(facultyTypeId);
		sb.append(", facultyName=");
		sb.append(facultyName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Faculty toEntityModel() {
		FacultyImpl facultyImpl = new FacultyImpl();

		facultyImpl.setFacultyId(facultyId);
		facultyImpl.setFacultyTypeId(facultyTypeId);

		if (facultyName == null) {
			facultyImpl.setFacultyName(StringPool.BLANK);
		}
		else {
			facultyImpl.setFacultyName(facultyName);
		}

		facultyImpl.resetOriginalValues();

		return facultyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		facultyId = objectInput.readLong();
		facultyTypeId = objectInput.readLong();
		facultyName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(facultyId);
		objectOutput.writeLong(facultyTypeId);

		if (facultyName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(facultyName);
		}
	}

	public long facultyId;
	public long facultyTypeId;
	public String facultyName;
}