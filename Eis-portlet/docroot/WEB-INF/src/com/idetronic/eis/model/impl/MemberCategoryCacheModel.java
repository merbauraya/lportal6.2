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

import com.idetronic.eis.model.MemberCategory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MemberCategory in entity cache.
 *
 * @author Mazlan Mat
 * @see MemberCategory
 * @generated
 */
public class MemberCategoryCacheModel implements CacheModel<MemberCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{memberCategoryId=");
		sb.append(memberCategoryId);
		sb.append(", memberCategoryName=");
		sb.append(memberCategoryName);
		sb.append(", memberCategoryGroupName=");
		sb.append(memberCategoryGroupName);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MemberCategory toEntityModel() {
		MemberCategoryImpl memberCategoryImpl = new MemberCategoryImpl();

		memberCategoryImpl.setMemberCategoryId(memberCategoryId);

		if (memberCategoryName == null) {
			memberCategoryImpl.setMemberCategoryName(StringPool.BLANK);
		}
		else {
			memberCategoryImpl.setMemberCategoryName(memberCategoryName);
		}

		if (memberCategoryGroupName == null) {
			memberCategoryImpl.setMemberCategoryGroupName(StringPool.BLANK);
		}
		else {
			memberCategoryImpl.setMemberCategoryGroupName(memberCategoryGroupName);
		}

		memberCategoryImpl.setActive(active);

		memberCategoryImpl.resetOriginalValues();

		return memberCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		memberCategoryId = objectInput.readLong();
		memberCategoryName = objectInput.readUTF();
		memberCategoryGroupName = objectInput.readUTF();
		active = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(memberCategoryId);

		if (memberCategoryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(memberCategoryName);
		}

		if (memberCategoryGroupName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(memberCategoryGroupName);
		}

		objectOutput.writeBoolean(active);
	}

	public long memberCategoryId;
	public String memberCategoryName;
	public String memberCategoryGroupName;
	public boolean active;
}