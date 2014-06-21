//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.vo;


public class AuditListFilterVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AuditListFilterVo()
	{
	}
	public AuditListFilterVo(ims.core.vo.beans.AuditListFilterVoBean bean)
	{
		this.datefrom = bean.getDateFrom() == null ? null : bean.getDateFrom().buildDateTime();
		this.dateto = bean.getDateTo() == null ? null : bean.getDateTo().buildDateTime();
		this.action = bean.getAction();
		this.user = bean.getUser();
		this.classname = bean.getClassName();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo();
		this.classid = bean.getClassId();
		this.hostname = bean.getHostname();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo();
		this.auditlocation = bean.getAuditLocation() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getAuditLocation().getId()), bean.getAuditLocation().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.AuditListFilterVoBean bean)
	{
		this.datefrom = bean.getDateFrom() == null ? null : bean.getDateFrom().buildDateTime();
		this.dateto = bean.getDateTo() == null ? null : bean.getDateTo().buildDateTime();
		this.action = bean.getAction();
		this.user = bean.getUser();
		this.classname = bean.getClassName();
		this.patient = bean.getPatient() == null ? null : bean.getPatient().buildVo(map);
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo(map);
		this.classid = bean.getClassId();
		this.hostname = bean.getHostname();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo(map);
		this.auditlocation = bean.getAuditLocation() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getAuditLocation().getId()), bean.getAuditLocation().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.AuditListFilterVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.AuditListFilterVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.AuditListFilterVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getDateFromIsNotNull()
	{
		return this.datefrom != null;
	}
	public ims.framework.utils.DateTime getDateFrom()
	{
		return this.datefrom;
	}
	public void setDateFrom(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.datefrom = value;
	}
	public boolean getDateToIsNotNull()
	{
		return this.dateto != null;
	}
	public ims.framework.utils.DateTime getDateTo()
	{
		return this.dateto;
	}
	public void setDateTo(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.dateto = value;
	}
	public boolean getActionIsNotNull()
	{
		return this.action != null;
	}
	public String getAction()
	{
		return this.action;
	}
	public static int getActionMaxLength()
	{
		return 255;
	}
	public void setAction(String value)
	{
		this.isValidated = false;
		this.action = value;
	}
	public boolean getUserIsNotNull()
	{
		return this.user != null;
	}
	public String getUser()
	{
		return this.user;
	}
	public static int getUserMaxLength()
	{
		return 255;
	}
	public void setUser(String value)
	{
		this.isValidated = false;
		this.user = value;
	}
	public boolean getClassNameIsNotNull()
	{
		return this.classname != null;
	}
	public String getClassName()
	{
		return this.classname;
	}
	public static int getClassNameMaxLength()
	{
		return 255;
	}
	public void setClassName(String value)
	{
		this.isValidated = false;
		this.classname = value;
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.vo.PatientShort getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.PatientShort value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.vo.ClinicalContactShortVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.ClinicalContactShortVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
	}
	public boolean getClassIdIsNotNull()
	{
		return this.classid != null;
	}
	public Integer getClassId()
	{
		return this.classid;
	}
	public void setClassId(Integer value)
	{
		this.isValidated = false;
		this.classid = value;
	}
	public boolean getHostnameIsNotNull()
	{
		return this.hostname != null;
	}
	public String getHostname()
	{
		return this.hostname;
	}
	public static int getHostnameMaxLength()
	{
		return 255;
	}
	public void setHostname(String value)
	{
		this.isValidated = false;
		this.hostname = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.vo.CareContextShortVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.CareContextShortVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getAuditLocationIsNotNull()
	{
		return this.auditlocation != null;
	}
	public ims.core.resource.place.vo.LocationRefVo getAuditLocation()
	{
		return this.auditlocation;
	}
	public void setAuditLocation(ims.core.resource.place.vo.LocationRefVo value)
	{
		this.isValidated = false;
		this.auditlocation = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof AuditListFilterVo))
			return false;
		AuditListFilterVo compareObj = (AuditListFilterVo)obj;
		if(this.getClassName() == null && compareObj.getClassName() != null)
			return false;
		if(this.getClassName() != null && compareObj.getClassName() == null)
			return false;
		if(this.getClassName() != null && compareObj.getClassName() != null)
			if(!this.getClassName().equals(compareObj.getClassName()))
				return false;
		if(this.getAction() == null && compareObj.getAction() != null)
			return false;
		if(this.getAction() != null && compareObj.getAction() == null)
			return false;
		if(this.getAction() != null && compareObj.getAction() != null)
			return this.getAction().equals(compareObj.getAction());
		return super.equals(obj);
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
		if(this.patient != null)
		{
			if(!this.patient.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.clinicalcontact != null)
		{
			if(!this.clinicalcontact.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.carecontext != null)
		{
			if(!this.carecontext.isValidated())
			{
				this.isBusy = false;
				return false;
			}
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
		if(this.patient != null)
		{
			String[] listOfOtherErrors = this.patient.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.clinicalcontact != null)
		{
			String[] listOfOtherErrors = this.clinicalcontact.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.carecontext != null)
		{
			String[] listOfOtherErrors = this.carecontext.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		AuditListFilterVo clone = new AuditListFilterVo();
		
		if(this.datefrom == null)
			clone.datefrom = null;
		else
			clone.datefrom = (ims.framework.utils.DateTime)this.datefrom.clone();
		if(this.dateto == null)
			clone.dateto = null;
		else
			clone.dateto = (ims.framework.utils.DateTime)this.dateto.clone();
		clone.action = this.action;
		clone.user = this.user;
		clone.classname = this.classname;
		if(this.patient == null)
			clone.patient = null;
		else
			clone.patient = (ims.core.vo.PatientShort)this.patient.clone();
		if(this.clinicalcontact == null)
			clone.clinicalcontact = null;
		else
			clone.clinicalcontact = (ims.core.vo.ClinicalContactShortVo)this.clinicalcontact.clone();
		clone.classid = this.classid;
		clone.hostname = this.hostname;
		if(this.carecontext == null)
			clone.carecontext = null;
		else
			clone.carecontext = (ims.core.vo.CareContextShortVo)this.carecontext.clone();
		clone.auditlocation = this.auditlocation;
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
		if (!(AuditListFilterVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AuditListFilterVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		AuditListFilterVo compareObj = (AuditListFilterVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getUser() == null && compareObj.getUser() != null)
				return -1;
			if(this.getUser() != null && compareObj.getUser() == null)
				return 1;
			if(this.getUser() != null && compareObj.getUser() != null)
			{
				if(caseInsensitive)
					retVal = this.getUser().toLowerCase().compareTo(compareObj.getUser().toLowerCase());
				else
					retVal = this.getUser().compareTo(compareObj.getUser());
			}
		}
		if (retVal == 0)
		{
			if(this.getClassName() == null && compareObj.getClassName() != null)
				return -1;
			if(this.getClassName() != null && compareObj.getClassName() == null)
				return 1;
			if(this.getClassName() != null && compareObj.getClassName() != null)
			{
				if(caseInsensitive)
					retVal = this.getClassName().toLowerCase().compareTo(compareObj.getClassName().toLowerCase());
				else
					retVal = this.getClassName().compareTo(compareObj.getClassName());
			}
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.datefrom != null)
			count++;
		if(this.dateto != null)
			count++;
		if(this.action != null)
			count++;
		if(this.user != null)
			count++;
		if(this.classname != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.clinicalcontact != null)
			count++;
		if(this.classid != null)
			count++;
		if(this.hostname != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.auditlocation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected ims.framework.utils.DateTime datefrom;
	protected ims.framework.utils.DateTime dateto;
	protected String action;
	protected String user;
	protected String classname;
	protected ims.core.vo.PatientShort patient;
	protected ims.core.vo.ClinicalContactShortVo clinicalcontact;
	protected Integer classid;
	protected String hostname;
	protected ims.core.vo.CareContextShortVo carecontext;
	protected ims.core.resource.place.vo.LocationRefVo auditlocation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}