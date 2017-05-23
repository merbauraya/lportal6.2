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

import com.idetronic.eis.model.MasterFile;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MasterFile in entity cache.
 *
 * @author Mazlan Mat
 * @see MasterFile
 * @generated
 */
public class MasterFileCacheModel implements CacheModel<MasterFile>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{masterFileId=");
		sb.append(masterFileId);
		sb.append(", masterTypeId=");
		sb.append(masterTypeId);
		sb.append(", parentId1=");
		sb.append(parentId1);
		sb.append(", parentId2=");
		sb.append(parentId2);
		sb.append(", masterFileName=");
		sb.append(masterFileName);
		sb.append(", status1=");
		sb.append(status1);
		sb.append(", status2=");
		sb.append(status2);
		sb.append(", status3=");
		sb.append(status3);
		sb.append(", status4=");
		sb.append(status4);
		sb.append(", masterCode=");
		sb.append(masterCode);
		sb.append(", oldId=");
		sb.append(oldId);
		sb.append(", note=");
		sb.append(note);
		sb.append(", inActive=");
		sb.append(inActive);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MasterFile toEntityModel() {
		MasterFileImpl masterFileImpl = new MasterFileImpl();

		masterFileImpl.setMasterFileId(masterFileId);
		masterFileImpl.setMasterTypeId(masterTypeId);
		masterFileImpl.setParentId1(parentId1);
		masterFileImpl.setParentId2(parentId2);

		if (masterFileName == null) {
			masterFileImpl.setMasterFileName(StringPool.BLANK);
		}
		else {
			masterFileImpl.setMasterFileName(masterFileName);
		}

		masterFileImpl.setStatus1(status1);
		masterFileImpl.setStatus2(status2);
		masterFileImpl.setStatus3(status3);
		masterFileImpl.setStatus4(status4);

		if (masterCode == null) {
			masterFileImpl.setMasterCode(StringPool.BLANK);
		}
		else {
			masterFileImpl.setMasterCode(masterCode);
		}

		masterFileImpl.setOldId(oldId);

		if (note == null) {
			masterFileImpl.setNote(StringPool.BLANK);
		}
		else {
			masterFileImpl.setNote(note);
		}

		masterFileImpl.setInActive(inActive);

		masterFileImpl.resetOriginalValues();

		return masterFileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		masterFileId = objectInput.readLong();
		masterTypeId = objectInput.readLong();
		parentId1 = objectInput.readLong();
		parentId2 = objectInput.readLong();
		masterFileName = objectInput.readUTF();
		status1 = objectInput.readBoolean();
		status2 = objectInput.readBoolean();
		status3 = objectInput.readBoolean();
		status4 = objectInput.readBoolean();
		masterCode = objectInput.readUTF();
		oldId = objectInput.readLong();
		note = objectInput.readUTF();
		inActive = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(masterFileId);
		objectOutput.writeLong(masterTypeId);
		objectOutput.writeLong(parentId1);
		objectOutput.writeLong(parentId2);

		if (masterFileName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(masterFileName);
		}

		objectOutput.writeBoolean(status1);
		objectOutput.writeBoolean(status2);
		objectOutput.writeBoolean(status3);
		objectOutput.writeBoolean(status4);

		if (masterCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(masterCode);
		}

		objectOutput.writeLong(oldId);

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}

		objectOutput.writeBoolean(inActive);
	}

	public long masterFileId;
	public long masterTypeId;
	public long parentId1;
	public long parentId2;
	public String masterFileName;
	public boolean status1;
	public boolean status2;
	public boolean status3;
	public boolean status4;
	public String masterCode;
	public long oldId;
	public String note;
	public boolean inActive;
}