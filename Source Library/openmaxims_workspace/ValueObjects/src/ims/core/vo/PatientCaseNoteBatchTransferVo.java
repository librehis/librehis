//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.vo;

/**
 * Linked to core.clinical.PatientCaseNote business object (ID: 1003100130).
 */
public class PatientCaseNoteBatchTransferVo extends ims.core.clinical.vo.PatientCaseNoteRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientCaseNoteBatchTransferVo()
	{
	}
	public PatientCaseNoteBatchTransferVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientCaseNoteBatchTransferVo(ims.core.vo.beans.PatientCaseNoteBatchTransferVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.type = bean.getType() == null ? null : ims.core.vo.lookups.CaseNoteType.buildLookup(bean.getType());
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.CaseNoteStatus.buildLookup(bean.getStatus());
		this.trackingid = bean.getTrackingID();
		this.currentlocation = bean.getCurrentLocation() == null ? null : bean.getCurrentLocation().buildVo();
		this.folder = bean.getFolder() == null ? null : ims.core.vo.lookups.FolderCaseNote.buildLookup(bean.getFolder());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientCaseNoteBatchTransferVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.type = bean.getType() == null ? null : ims.core.vo.lookups.CaseNoteType.buildLookup(bean.getType());
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.CaseNoteStatus.buildLookup(bean.getStatus());
		this.trackingid = bean.getTrackingID();
		this.currentlocation = bean.getCurrentLocation() == null ? null : bean.getCurrentLocation().buildVo(map);
		this.folder = bean.getFolder() == null ? null : ims.core.vo.lookups.FolderCaseNote.buildLookup(bean.getFolder());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientCaseNoteBatchTransferVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientCaseNoteBatchTransferVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientCaseNoteBatchTransferVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("TYPE"))
			return getType();
		if(fieldName.equals("STATUS"))
			return getStatus();
		if(fieldName.equals("TRACKINGID"))
			return getTrackingID();
		if(fieldName.equals("CURRENTLOCATION"))
			return getCurrentLocation();
		if(fieldName.equals("FOLDER"))
			return getFolder();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientLite_IdentifiersVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientLite_IdentifiersVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getTypeIsNotNull()
	{
		return this.type != null;
	}
	public ims.core.vo.lookups.CaseNoteType getType()
	{
		return this.type;
	}
	public void setType(ims.core.vo.lookups.CaseNoteType value)
	{
		this.isValidated = false;
		this.type = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public ims.core.vo.lookups.CaseNoteStatus getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.core.vo.lookups.CaseNoteStatus value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getTrackingIDIsNotNull()
	{
		return this.trackingid != null;
	}
	public String getTrackingID()
	{
		return this.trackingid;
	}
	public static int getTrackingIDMaxLength()
	{
		return 20;
	}
	public void setTrackingID(String value)
	{
		this.isValidated = false;
		this.trackingid = value;
	}
	public boolean getCurrentLocationIsNotNull()
	{
		return this.currentlocation != null;
	}
	public ims.core.vo.LocationLiteVo getCurrentLocation()
	{
		return this.currentlocation;
	}
	public void setCurrentLocation(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.currentlocation = value;
	}
	public boolean getFolderIsNotNull()
	{
		return this.folder != null;
	}
	public ims.core.vo.lookups.FolderCaseNote getFolder()
	{
		return this.folder;
	}
	public void setFolder(ims.core.vo.lookups.FolderCaseNote value)
	{
		this.isValidated = false;
		this.folder = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.type == null)
			listOfErrors.add("Type is mandatory");
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
		if(this.trackingid == null || this.trackingid.length() == 0)
			listOfErrors.add("TrackingID is mandatory");
		else if(this.trackingid.length() > 20)
			listOfErrors.add("The length of the field [trackingid] in the value object [ims.core.vo.PatientCaseNoteBatchTransferVo] is too big. It should be less or equal to 20");
		if(this.currentlocation == null)
			listOfErrors.add("CurrentLocation is mandatory");
		if(this.folder == null)
			listOfErrors.add("Folder is mandatory");
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		PatientCaseNoteBatchTransferVo clone = new PatientCaseNoteBatchTransferVo(this.id, this.version);
		
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientLite_IdentifiersVo)this.patient.clone();
		if(this.type == null)
			clone.type = null;
		else
			clone.type = (ims.core.vo.lookups.CaseNoteType)this.type.clone();
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.CaseNoteStatus)this.status.clone();
		clone.trackingid = this.trackingid;
		if(this.currentlocation == null)
			clone.currentlocation = null;
		else
			clone.currentlocation = (ims.core.vo.LocationLiteVo)this.currentlocation.clone();
		if(this.folder == null)
			clone.folder = null;
		else
			clone.folder = (ims.core.vo.lookups.FolderCaseNote)this.folder.clone();
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(PatientCaseNoteBatchTransferVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientCaseNoteBatchTransferVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientCaseNoteBatchTransferVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientCaseNoteBatchTransferVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.patient != null)
			count++;
		if(this.type != null)
			count++;
		if(this.status != null)
			count++;
		if(this.trackingid != null)
			count++;
		if(this.currentlocation != null)
			count++;
		if(this.folder != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.core.vo.PatientLite_IdentifiersVo patient;
	protected ims.core.vo.lookups.CaseNoteType type;
	protected ims.core.vo.lookups.CaseNoteStatus status;
	protected String trackingid;
	protected ims.core.vo.LocationLiteVo currentlocation;
	protected ims.core.vo.lookups.FolderCaseNote folder;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
