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

import com.idetronic.eis.model.PostCategory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PostCategory in entity cache.
 *
 * @author Mazlan Mat
 * @see PostCategory
 * @generated
 */
public class PostCategoryCacheModel implements CacheModel<PostCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{postCategoryId=");
		sb.append(postCategoryId);
		sb.append(", postCategoryCode=");
		sb.append(postCategoryCode);
		sb.append(", postCategoryName=");
		sb.append(postCategoryName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PostCategory toEntityModel() {
		PostCategoryImpl postCategoryImpl = new PostCategoryImpl();

		postCategoryImpl.setPostCategoryId(postCategoryId);

		if (postCategoryCode == null) {
			postCategoryImpl.setPostCategoryCode(StringPool.BLANK);
		}
		else {
			postCategoryImpl.setPostCategoryCode(postCategoryCode);
		}

		if (postCategoryName == null) {
			postCategoryImpl.setPostCategoryName(StringPool.BLANK);
		}
		else {
			postCategoryImpl.setPostCategoryName(postCategoryName);
		}

		postCategoryImpl.resetOriginalValues();

		return postCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		postCategoryId = objectInput.readLong();
		postCategoryCode = objectInput.readUTF();
		postCategoryName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(postCategoryId);

		if (postCategoryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(postCategoryCode);
		}

		if (postCategoryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(postCategoryName);
		}
	}

	public long postCategoryId;
	public String postCategoryCode;
	public String postCategoryName;
}