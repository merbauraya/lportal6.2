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

import com.idetronic.eis.model.ItemMedium;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ItemMedium in entity cache.
 *
 * @author Mazlan Mat
 * @see ItemMedium
 * @generated
 */
public class ItemMediumCacheModel implements CacheModel<ItemMedium>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{itemMediumId=");
		sb.append(itemMediumId);
		sb.append(", itemMediumName=");
		sb.append(itemMediumName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ItemMedium toEntityModel() {
		ItemMediumImpl itemMediumImpl = new ItemMediumImpl();

		itemMediumImpl.setItemMediumId(itemMediumId);

		if (itemMediumName == null) {
			itemMediumImpl.setItemMediumName(StringPool.BLANK);
		}
		else {
			itemMediumImpl.setItemMediumName(itemMediumName);
		}

		itemMediumImpl.resetOriginalValues();

		return itemMediumImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		itemMediumId = objectInput.readLong();
		itemMediumName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(itemMediumId);

		if (itemMediumName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(itemMediumName);
		}
	}

	public long itemMediumId;
	public String itemMediumName;
}