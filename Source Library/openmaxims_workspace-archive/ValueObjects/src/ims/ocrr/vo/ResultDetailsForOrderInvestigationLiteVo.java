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

package ims.ocrr.vo;

/**
 * Linked to OCRR.OrderingResults.ResultDetails business object (ID: 1070100028).
 */
public class ResultDetailsForOrderInvestigationLiteVo extends ims.ocrr.orderingresults.vo.ResultDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ResultDetailsForOrderInvestigationLiteVo()
	{
	}
	public ResultDetailsForOrderInvestigationLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public ResultDetailsForOrderInvestigationLiteVo(ims.ocrr.vo.beans.ResultDetailsForOrderInvestigationLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pathologyresultdetails = ims.ocrr.vo.PathResultDetailsShortVoCollection.buildFromBeanCollection(bean.getPathologyResultDetails());
		this.clinicalresultdetails = bean.getClinicalResultDetails() == null ? null : bean.getClinicalResultDetails().buildVo();
		this.documentresultdetails = bean.getDocumentResultDetails() == null ? null : new ims.core.documents.vo.PatientDocumentRefVo(new Integer(bean.getDocumentResultDetails().getId()), bean.getDocumentResultDetails().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.ResultDetailsForOrderInvestigationLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pathologyresultdetails = ims.ocrr.vo.PathResultDetailsShortVoCollection.buildFromBeanCollection(bean.getPathologyResultDetails());
		this.clinicalresultdetails = bean.getClinicalResultDetails() == null ? null : bean.getClinicalResultDetails().buildVo(map);
		this.documentresultdetails = bean.getDocumentResultDetails() == null ? null : new ims.core.documents.vo.PatientDocumentRefVo(new Integer(bean.getDocumentResultDetails().getId()), bean.getDocumentResultDetails().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.ResultDetailsForOrderInvestigationLiteVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.ResultDetailsForOrderInvestigationLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.ResultDetailsForOrderInvestigationLiteVoBean();
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
		if(fieldName.equals("PATHOLOGYRESULTDETAILS"))
			return getPathologyResultDetails();
		if(fieldName.equals("CLINICALRESULTDETAILS"))
			return getClinicalResultDetails();
		if(fieldName.equals("DOCUMENTRESULTDETAILS"))
			return getDocumentResultDetails();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPathologyResultDetailsIsNotNull()
	{
		return this.pathologyresultdetails != null;
	}
	public ims.ocrr.vo.PathResultDetailsShortVoCollection getPathologyResultDetails()
	{
		return this.pathologyresultdetails;
	}
	public void setPathologyResultDetails(ims.ocrr.vo.PathResultDetailsShortVoCollection value)
	{
		this.isValidated = false;
		this.pathologyresultdetails = value;
	}
	public boolean getClinicalResultDetailsIsNotNull()
	{
		return this.clinicalresultdetails != null;
	}
	public ims.ocrr.vo.RadResultDetailsVo getClinicalResultDetails()
	{
		return this.clinicalresultdetails;
	}
	public void setClinicalResultDetails(ims.ocrr.vo.RadResultDetailsVo value)
	{
		this.isValidated = false;
		this.clinicalresultdetails = value;
	}
	public boolean getDocumentResultDetailsIsNotNull()
	{
		return this.documentresultdetails != null;
	}
	public ims.core.documents.vo.PatientDocumentRefVo getDocumentResultDetails()
	{
		return this.documentresultdetails;
	}
	public void setDocumentResultDetails(ims.core.documents.vo.PatientDocumentRefVo value)
	{
		this.isValidated = false;
		this.documentresultdetails = value;
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
		if(this.pathologyresultdetails != null)
		{
			if(!this.pathologyresultdetails.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.clinicalresultdetails != null)
		{
			if(!this.clinicalresultdetails.isValidated())
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
		if(this.pathologyresultdetails != null)
		{
			String[] listOfOtherErrors = this.pathologyresultdetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.clinicalresultdetails != null)
		{
			String[] listOfOtherErrors = this.clinicalresultdetails.validate();
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
	
		ResultDetailsForOrderInvestigationLiteVo clone = new ResultDetailsForOrderInvestigationLiteVo(this.id, this.version);
		
		if(this.pathologyresultdetails == null)
			clone.pathologyresultdetails = null;
		else
			clone.pathologyresultdetails = (ims.ocrr.vo.PathResultDetailsShortVoCollection)this.pathologyresultdetails.clone();
		if(this.clinicalresultdetails == null)
			clone.clinicalresultdetails = null;
		else
			clone.clinicalresultdetails = (ims.ocrr.vo.RadResultDetailsVo)this.clinicalresultdetails.clone();
		clone.documentresultdetails = this.documentresultdetails;
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
		if (!(ResultDetailsForOrderInvestigationLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ResultDetailsForOrderInvestigationLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ResultDetailsForOrderInvestigationLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ResultDetailsForOrderInvestigationLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.pathologyresultdetails != null)
			count++;
		if(this.clinicalresultdetails != null)
			count++;
		if(this.documentresultdetails != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.ocrr.vo.PathResultDetailsShortVoCollection pathologyresultdetails;
	protected ims.ocrr.vo.RadResultDetailsVo clinicalresultdetails;
	protected ims.core.documents.vo.PatientDocumentRefVo documentresultdetails;
	private boolean isValidated = false;
	private boolean isBusy = false;
}