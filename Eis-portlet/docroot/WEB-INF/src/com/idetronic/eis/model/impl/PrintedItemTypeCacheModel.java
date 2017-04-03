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

import com.idetronic.eis.model.PrintedItemType;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PrintedItemType in entity cache.
 *
 * @author Mazlan Mat
 * @see PrintedItemType
 * @generated
 */
public class PrintedItemTypeCacheModel implements CacheModel<PrintedItemType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{itemTypeId=");
		sb.append(itemTypeId);
		sb.append(", itemTypeName=");
		sb.append(itemTypeName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PrintedItemType toEntityModel() {
		PrintedItemTypeImpl printedItemTypeImpl = new PrintedItemTypeImpl();

		printedItemTypeImpl.setItemTypeId(itemTypeId);

		if (itemTypeName == null) {
			printedItemTypeImpl.setItemTypeName(StringPool.BLANK);
		}
		else {
			printedItemTypeImpl.setItemTypeName(itemTypeName);
		}

		printedItemTypeImpl.resetOriginalValues();

		return printedItemTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		itemTypeId = objectInput.readLong();
		itemTypeName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(itemTypeId);

		if (itemTypeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(itemTypeName);
		}
	}

	public long itemTypeId;
	public String itemTypeName;
}