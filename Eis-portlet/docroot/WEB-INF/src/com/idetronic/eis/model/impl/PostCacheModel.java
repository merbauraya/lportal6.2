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

import com.idetronic.eis.model.Post;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Post in entity cache.
 *
 * @author Mazlan Mat
 * @see Post
 * @generated
 */
public class PostCacheModel implements CacheModel<Post>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{postId=");
		sb.append(postId);
		sb.append(", postCategoryId=");
		sb.append(postCategoryId);
		sb.append(", postName=");
		sb.append(postName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Post toEntityModel() {
		PostImpl postImpl = new PostImpl();

		postImpl.setPostId(postId);
		postImpl.setPostCategoryId(postCategoryId);

		if (postName == null) {
			postImpl.setPostName(StringPool.BLANK);
		}
		else {
			postImpl.setPostName(postName);
		}

		postImpl.resetOriginalValues();

		return postImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		postId = objectInput.readLong();
		postCategoryId = objectInput.readLong();
		postName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(postId);
		objectOutput.writeLong(postCategoryId);

		if (postName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(postName);
		}
	}

	public long postId;
	public long postCategoryId;
	public String postName;
}