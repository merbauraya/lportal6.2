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

import com.idetronic.eis.model.ItemType;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ItemType in entity cache.
 *
 * @author Mazlan Mat
 * @see ItemType
 * @generated
 */
public class ItemTypeCacheModel implements CacheModel<ItemType>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{itemTypeId=");
		sb.append(itemTypeId);
		sb.append(", itemTypeName=");
		sb.append(itemTypeName);
		sb.append(", printedType=");
		sb.append(printedType);
		sb.append(", IRType=");
		sb.append(IRType);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ItemType toEntityModel() {
		ItemTypeImpl itemTypeImpl = new ItemTypeImpl();

		itemTypeImpl.setItemTypeId(itemTypeId);

		if (itemTypeName == null) {
			itemTypeImpl.setItemTypeName(StringPool.BLANK);
		}
		else {
			itemTypeImpl.setItemTypeName(itemTypeName);
		}

		itemTypeImpl.setPrintedType(printedType);
		itemTypeImpl.setIRType(IRType);
		itemTypeImpl.setActive(active);

		itemTypeImpl.resetOriginalValues();

		return itemTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		itemTypeId = objectInput.readLong();
		itemTypeName = objectInput.readUTF();
		printedType = objectInput.readInt();
		IRType = objectInput.readBoolean();
		active = objectInput.readBoolean();
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

		objectOutput.writeInt(printedType);
		objectOutput.writeBoolean(IRType);
		objectOutput.writeBoolean(active);
	}

	public long itemTypeId;
	public String itemTypeName;
	public int printedType;
	public boolean IRType;
	public boolean active;
}