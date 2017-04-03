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

import com.idetronic.eis.model.LibraryType;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LibraryType in entity cache.
 *
 * @author Mazlan Mat
 * @see LibraryType
 * @generated
 */
public class LibraryTypeCacheModel implements CacheModel<LibraryType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{libraryTypeId=");
		sb.append(libraryTypeId);
		sb.append(", libraryTypeCode=");
		sb.append(libraryTypeCode);
		sb.append(", libraryTypeName=");
		sb.append(libraryTypeName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LibraryType toEntityModel() {
		LibraryTypeImpl libraryTypeImpl = new LibraryTypeImpl();

		libraryTypeImpl.setLibraryTypeId(libraryTypeId);

		if (libraryTypeCode == null) {
			libraryTypeImpl.setLibraryTypeCode(StringPool.BLANK);
		}
		else {
			libraryTypeImpl.setLibraryTypeCode(libraryTypeCode);
		}

		if (libraryTypeName == null) {
			libraryTypeImpl.setLibraryTypeName(StringPool.BLANK);
		}
		else {
			libraryTypeImpl.setLibraryTypeName(libraryTypeName);
		}

		libraryTypeImpl.resetOriginalValues();

		return libraryTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		libraryTypeId = objectInput.readLong();
		libraryTypeCode = objectInput.readUTF();
		libraryTypeName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(libraryTypeId);

		if (libraryTypeCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(libraryTypeCode);
		}

		if (libraryTypeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(libraryTypeName);
		}
	}

	public long libraryTypeId;
	public String libraryTypeCode;
	public String libraryTypeName;
}