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

import com.idetronic.eis.model.ItemTypeCategory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ItemTypeCategory in entity cache.
 *
 * @author Mazlan Mat
 * @see ItemTypeCategory
 * @generated
 */
public class ItemTypeCategoryCacheModel implements CacheModel<ItemTypeCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{itemTypeCategoryId=");
		sb.append(itemTypeCategoryId);
		sb.append(", itemTypeCategoryName=");
		sb.append(itemTypeCategoryName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ItemTypeCategory toEntityModel() {
		ItemTypeCategoryImpl itemTypeCategoryImpl = new ItemTypeCategoryImpl();

		itemTypeCategoryImpl.setItemTypeCategoryId(itemTypeCategoryId);

		if (itemTypeCategoryName == null) {
			itemTypeCategoryImpl.setItemTypeCategoryName(StringPool.BLANK);
		}
		else {
			itemTypeCategoryImpl.setItemTypeCategoryName(itemTypeCategoryName);
		}

		itemTypeCategoryImpl.resetOriginalValues();

		return itemTypeCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		itemTypeCategoryId = objectInput.readLong();
		itemTypeCategoryName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(itemTypeCategoryId);

		if (itemTypeCategoryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(itemTypeCategoryName);
		}
	}

	public long itemTypeCategoryId;
	public String itemTypeCategoryName;
}