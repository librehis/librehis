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

package ims.clinical.vo;


public class CSPrimaryDiagnosisAndPoceduresVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CSPrimaryDiagnosisAndPoceduresVo()
	{
	}
	public CSPrimaryDiagnosisAndPoceduresVo(ims.clinical.vo.beans.CSPrimaryDiagnosisAndPoceduresVoBean bean)
	{
		this.primaryprocedures = ims.clinical.vo.CSPatientSummaryProcedureVoCollection.buildFromBeanCollection(bean.getPrimaryProcedures());
		this.primarydiagnosis = ims.clinical.vo.CSPatientSummaryDiagnosisVoCollection.buildFromBeanCollection(bean.getPrimaryDiagnosis());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.CSPrimaryDiagnosisAndPoceduresVoBean bean)
	{
		this.primaryprocedures = ims.clinical.vo.CSPatientSummaryProcedureVoCollection.buildFromBeanCollection(bean.getPrimaryProcedures());
		this.primarydiagnosis = ims.clinical.vo.CSPatientSummaryDiagnosisVoCollection.buildFromBeanCollection(bean.getPrimaryDiagnosis());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.CSPrimaryDiagnosisAndPoceduresVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.CSPrimaryDiagnosisAndPoceduresVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.CSPrimaryDiagnosisAndPoceduresVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getPrimaryProceduresIsNotNull()
	{
		return this.primaryprocedures != null;
	}
	public ims.clinical.vo.CSPatientSummaryProcedureVoCollection getPrimaryProcedures()
	{
		return this.primaryprocedures;
	}
	public void setPrimaryProcedures(ims.clinical.vo.CSPatientSummaryProcedureVoCollection value)
	{
		this.isValidated = false;
		this.primaryprocedures = value;
	}
	public boolean getPrimaryDiagnosisIsNotNull()
	{
		return this.primarydiagnosis != null;
	}
	public ims.clinical.vo.CSPatientSummaryDiagnosisVoCollection getPrimaryDiagnosis()
	{
		return this.primarydiagnosis;
	}
	public void setPrimaryDiagnosis(ims.clinical.vo.CSPatientSummaryDiagnosisVoCollection value)
	{
		this.isValidated = false;
		this.primarydiagnosis = value;
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
		if(!(obj instanceof CSPrimaryDiagnosisAndPoceduresVo))
			return false;
		CSPrimaryDiagnosisAndPoceduresVo compareObj = (CSPrimaryDiagnosisAndPoceduresVo)obj;
		if(this.getPrimaryProcedures() == null && compareObj.getPrimaryProcedures() != null)
			return false;
		if(this.getPrimaryProcedures() != null && compareObj.getPrimaryProcedures() == null)
			return false;
		if(this.getPrimaryProcedures() != null && compareObj.getPrimaryProcedures() != null)
			if(!this.getPrimaryProcedures().equals(compareObj.getPrimaryProcedures()))
				return false;
		if(this.getPrimaryDiagnosis() == null && compareObj.getPrimaryDiagnosis() != null)
			return false;
		if(this.getPrimaryDiagnosis() != null && compareObj.getPrimaryDiagnosis() == null)
			return false;
		if(this.getPrimaryDiagnosis() != null && compareObj.getPrimaryDiagnosis() != null)
			return this.getPrimaryDiagnosis().equals(compareObj.getPrimaryDiagnosis());
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
		if(this.primaryprocedures != null)
		{
			if(!this.primaryprocedures.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.primarydiagnosis != null)
		{
			if(!this.primarydiagnosis.isValidated())
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
		if(this.primaryprocedures != null)
		{
			String[] listOfOtherErrors = this.primaryprocedures.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.primarydiagnosis != null)
		{
			String[] listOfOtherErrors = this.primarydiagnosis.validate();
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
	
		CSPrimaryDiagnosisAndPoceduresVo clone = new CSPrimaryDiagnosisAndPoceduresVo();
		
		if(this.primaryprocedures == null)
			clone.primaryprocedures = null;
		else
			clone.primaryprocedures = (ims.clinical.vo.CSPatientSummaryProcedureVoCollection)this.primaryprocedures.clone();
		if(this.primarydiagnosis == null)
			clone.primarydiagnosis = null;
		else
			clone.primarydiagnosis = (ims.clinical.vo.CSPatientSummaryDiagnosisVoCollection)this.primarydiagnosis.clone();
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
		if (!(CSPrimaryDiagnosisAndPoceduresVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CSPrimaryDiagnosisAndPoceduresVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		CSPrimaryDiagnosisAndPoceduresVo compareObj = (CSPrimaryDiagnosisAndPoceduresVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getPrimaryProcedures() == null && compareObj.getPrimaryProcedures() != null)
				return -1;
			if(this.getPrimaryProcedures() != null && compareObj.getPrimaryProcedures() == null)
				return 1;
			if(this.getPrimaryProcedures() != null && compareObj.getPrimaryProcedures() != null)
				retVal = this.getPrimaryProcedures().compareTo(compareObj.getPrimaryProcedures());
		}
		if (retVal == 0)
		{
			if(this.getPrimaryProcedures() == null && compareObj.getPrimaryProcedures() != null)
				return -1;
			if(this.getPrimaryProcedures() != null && compareObj.getPrimaryProcedures() == null)
				return 1;
			if(this.getPrimaryProcedures() != null && compareObj.getPrimaryProcedures() != null)
				retVal = this.getPrimaryProcedures().compareTo(compareObj.getPrimaryProcedures());
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
		if(this.primaryprocedures != null)
			count++;
		if(this.primarydiagnosis != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.clinical.vo.CSPatientSummaryProcedureVoCollection primaryprocedures;
	protected ims.clinical.vo.CSPatientSummaryDiagnosisVoCollection primarydiagnosis;
	private boolean isValidated = false;
	private boolean isBusy = false;
}