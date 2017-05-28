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

import com.idetronic.eis.model.MasterType;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MasterType in entity cache.
 *
 * @author Mazlan Mat
 * @see MasterType
 * @generated
 */
public class MasterTypeCacheModel implements CacheModel<MasterType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{masterTypeId=");
		sb.append(masterTypeId);
		sb.append(", masterTypeName=");
		sb.append(masterTypeName);
		sb.append(", status=");
		sb.append(status);
		sb.append(", parentType=");
		sb.append(parentType);
		sb.append(", pageLabel=");
		sb.append(pageLabel);
		sb.append(", nameLabel=");
		sb.append(nameLabel);
		sb.append(", hasParent1=");
		sb.append(hasParent1);
		sb.append(", parentId1=");
		sb.append(parentId1);
		sb.append(", parentId2=");
		sb.append(parentId2);
		sb.append(", hasParent2=");
		sb.append(hasParent2);
		sb.append(", parent1Label=");
		sb.append(parent1Label);
		sb.append(", parent2Label=");
		sb.append(parent2Label);
		sb.append(", hasStatus1=");
		sb.append(hasStatus1);
		sb.append(", hasStatus2=");
		sb.append(hasStatus2);
		sb.append(", hasStatus3=");
		sb.append(hasStatus3);
		sb.append(", hasStatus4=");
		sb.append(hasStatus4);
		sb.append(", hasStatus5=");
		sb.append(hasStatus5);
		sb.append(", status1Label=");
		sb.append(status1Label);
		sb.append(", status2Label=");
		sb.append(status2Label);
		sb.append(", status3Label=");
		sb.append(status3Label);
		sb.append(", status4Label=");
		sb.append(status4Label);
		sb.append(", status5Label=");
		sb.append(status5Label);
		sb.append(", hasCode=");
		sb.append(hasCode);
		sb.append(", codeLabel=");
		sb.append(codeLabel);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MasterType toEntityModel() {
		MasterTypeImpl masterTypeImpl = new MasterTypeImpl();

		masterTypeImpl.setMasterTypeId(masterTypeId);

		if (masterTypeName == null) {
			masterTypeImpl.setMasterTypeName(StringPool.BLANK);
		}
		else {
			masterTypeImpl.setMasterTypeName(masterTypeName);
		}

		masterTypeImpl.setStatus(status);
		masterTypeImpl.setParentType(parentType);

		if (pageLabel == null) {
			masterTypeImpl.setPageLabel(StringPool.BLANK);
		}
		else {
			masterTypeImpl.setPageLabel(pageLabel);
		}

		if (nameLabel == null) {
			masterTypeImpl.setNameLabel(StringPool.BLANK);
		}
		else {
			masterTypeImpl.setNameLabel(nameLabel);
		}

		masterTypeImpl.setHasParent1(hasParent1);
		masterTypeImpl.setParentId1(parentId1);
		masterTypeImpl.setParentId2(parentId2);
		masterTypeImpl.setHasParent2(hasParent2);

		if (parent1Label == null) {
			masterTypeImpl.setParent1Label(StringPool.BLANK);
		}
		else {
			masterTypeImpl.setParent1Label(parent1Label);
		}

		if (parent2Label == null) {
			masterTypeImpl.setParent2Label(StringPool.BLANK);
		}
		else {
			masterTypeImpl.setParent2Label(parent2Label);
		}

		masterTypeImpl.setHasStatus1(hasStatus1);
		masterTypeImpl.setHasStatus2(hasStatus2);
		masterTypeImpl.setHasStatus3(hasStatus3);
		masterTypeImpl.setHasStatus4(hasStatus4);
		masterTypeImpl.setHasStatus5(hasStatus5);

		if (status1Label == null) {
			masterTypeImpl.setStatus1Label(StringPool.BLANK);
		}
		else {
			masterTypeImpl.setStatus1Label(status1Label);
		}

		if (status2Label == null) {
			masterTypeImpl.setStatus2Label(StringPool.BLANK);
		}
		else {
			masterTypeImpl.setStatus2Label(status2Label);
		}

		if (status3Label == null) {
			masterTypeImpl.setStatus3Label(StringPool.BLANK);
		}
		else {
			masterTypeImpl.setStatus3Label(status3Label);
		}

		if (status4Label == null) {
			masterTypeImpl.setStatus4Label(StringPool.BLANK);
		}
		else {
			masterTypeImpl.setStatus4Label(status4Label);
		}

		if (status5Label == null) {
			masterTypeImpl.setStatus5Label(StringPool.BLANK);
		}
		else {
			masterTypeImpl.setStatus5Label(status5Label);
		}

		masterTypeImpl.setHasCode(hasCode);

		if (codeLabel == null) {
			masterTypeImpl.setCodeLabel(StringPool.BLANK);
		}
		else {
			masterTypeImpl.setCodeLabel(codeLabel);
		}

		masterTypeImpl.resetOriginalValues();

		return masterTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		masterTypeId = objectInput.readLong();
		masterTypeName = objectInput.readUTF();
		status = objectInput.readInt();
		parentType = objectInput.readBoolean();
		pageLabel = objectInput.readUTF();
		nameLabel = objectInput.readUTF();
		hasParent1 = objectInput.readBoolean();
		parentId1 = objectInput.readLong();
		parentId2 = objectInput.readLong();
		hasParent2 = objectInput.readBoolean();
		parent1Label = objectInput.readUTF();
		parent2Label = objectInput.readUTF();
		hasStatus1 = objectInput.readBoolean();
		hasStatus2 = objectInput.readBoolean();
		hasStatus3 = objectInput.readBoolean();
		hasStatus4 = objectInput.readBoolean();
		hasStatus5 = objectInput.readBoolean();
		status1Label = objectInput.readUTF();
		status2Label = objectInput.readUTF();
		status3Label = objectInput.readUTF();
		status4Label = objectInput.readUTF();
		status5Label = objectInput.readUTF();
		hasCode = objectInput.readBoolean();
		codeLabel = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(masterTypeId);

		if (masterTypeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(masterTypeName);
		}

		objectOutput.writeInt(status);
		objectOutput.writeBoolean(parentType);

		if (pageLabel == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pageLabel);
		}

		if (nameLabel == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nameLabel);
		}

		objectOutput.writeBoolean(hasParent1);
		objectOutput.writeLong(parentId1);
		objectOutput.writeLong(parentId2);
		objectOutput.writeBoolean(hasParent2);

		if (parent1Label == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(parent1Label);
		}

		if (parent2Label == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(parent2Label);
		}

		objectOutput.writeBoolean(hasStatus1);
		objectOutput.writeBoolean(hasStatus2);
		objectOutput.writeBoolean(hasStatus3);
		objectOutput.writeBoolean(hasStatus4);
		objectOutput.writeBoolean(hasStatus5);

		if (status1Label == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status1Label);
		}

		if (status2Label == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status2Label);
		}

		if (status3Label == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status3Label);
		}

		if (status4Label == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status4Label);
		}

		if (status5Label == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status5Label);
		}

		objectOutput.writeBoolean(hasCode);

		if (codeLabel == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codeLabel);
		}
	}

	public long masterTypeId;
	public String masterTypeName;
	public int status;
	public boolean parentType;
	public String pageLabel;
	public String nameLabel;
	public boolean hasParent1;
	public long parentId1;
	public long parentId2;
	public boolean hasParent2;
	public String parent1Label;
	public String parent2Label;
	public boolean hasStatus1;
	public boolean hasStatus2;
	public boolean hasStatus3;
	public boolean hasStatus4;
	public boolean hasStatus5;
	public String status1Label;
	public String status2Label;
	public String status3Label;
	public String status4Label;
	public String status5Label;
	public boolean hasCode;
	public String codeLabel;
}