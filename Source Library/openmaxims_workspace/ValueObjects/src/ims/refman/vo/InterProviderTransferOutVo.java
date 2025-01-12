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

package ims.RefMan.vo;

/**
 * Linked to RefMan.InterProviderTransferOut business object (ID: 1096100086).
 */
public class InterProviderTransferOutVo extends ims.RefMan.vo.InterProviderTransferOutRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public InterProviderTransferOutVo()
	{
	}
	public InterProviderTransferOutVo(Integer id, int version)
	{
		super(id, version);
	}
	public InterProviderTransferOutVo(ims.RefMan.vo.beans.InterProviderTransferOutVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.RefMan.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
		this.requesteddate = bean.getRequestedDate() == null ? null : bean.getRequestedDate().buildDate();
		this.referringclinican = bean.getReferringClinican() == null ? null : bean.getReferringClinican().buildVo();
		this.iptorganisation = bean.getIPTOrganisation() == null ? null : ims.RefMan.vo.lookups.OtherProviders.buildLookup(bean.getIPTOrganisation());
		this.iptservice = bean.getIPTService();
		this.iptclinician = bean.getIPTClinician();
		this.iptcomments = bean.getIPTComments();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.InterProviderTransferOutVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.RefMan.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
		this.requesteddate = bean.getRequestedDate() == null ? null : bean.getRequestedDate().buildDate();
		this.referringclinican = bean.getReferringClinican() == null ? null : bean.getReferringClinican().buildVo(map);
		this.iptorganisation = bean.getIPTOrganisation() == null ? null : ims.RefMan.vo.lookups.OtherProviders.buildLookup(bean.getIPTOrganisation());
		this.iptservice = bean.getIPTService();
		this.iptclinician = bean.getIPTClinician();
		this.iptcomments = bean.getIPTComments();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.InterProviderTransferOutVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.InterProviderTransferOutVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.InterProviderTransferOutVoBean();
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
		if(fieldName.equals("CATSREFERRAL"))
			return getCatsReferral();
		if(fieldName.equals("REQUESTEDDATE"))
			return getRequestedDate();
		if(fieldName.equals("REFERRINGCLINICAN"))
			return getReferringClinican();
		if(fieldName.equals("IPTORGANISATION"))
			return getIPTOrganisation();
		if(fieldName.equals("IPTSERVICE"))
			return getIPTService();
		if(fieldName.equals("IPTCLINICIAN"))
			return getIPTClinician();
		if(fieldName.equals("IPTCOMMENTS"))
			return getIPTComments();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getCatsReferralIsNotNull()
	{
		return this.catsreferral != null;
	}
	public ims.RefMan.vo.CatsReferralRefVo getCatsReferral()
	{
		return this.catsreferral;
	}
	public void setCatsReferral(ims.RefMan.vo.CatsReferralRefVo value)
	{
		this.isValidated = false;
		this.catsreferral = value;
	}
	public boolean getRequestedDateIsNotNull()
	{
		return this.requesteddate != null;
	}
	public ims.framework.utils.Date getRequestedDate()
	{
		return this.requesteddate;
	}
	public void setRequestedDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.requesteddate = value;
	}
	public boolean getReferringClinicanIsNotNull()
	{
		return this.referringclinican != null;
	}
	public ims.core.vo.HcpLiteVo getReferringClinican()
	{
		return this.referringclinican;
	}
	public void setReferringClinican(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.referringclinican = value;
	}
	public boolean getIPTOrganisationIsNotNull()
	{
		return this.iptorganisation != null;
	}
	public ims.RefMan.vo.lookups.OtherProviders getIPTOrganisation()
	{
		return this.iptorganisation;
	}
	public void setIPTOrganisation(ims.RefMan.vo.lookups.OtherProviders value)
	{
		this.isValidated = false;
		this.iptorganisation = value;
	}
	public boolean getIPTServiceIsNotNull()
	{
		return this.iptservice != null;
	}
	public String getIPTService()
	{
		return this.iptservice;
	}
	public static int getIPTServiceMaxLength()
	{
		return 250;
	}
	public void setIPTService(String value)
	{
		this.isValidated = false;
		this.iptservice = value;
	}
	public boolean getIPTClinicianIsNotNull()
	{
		return this.iptclinician != null;
	}
	public String getIPTClinician()
	{
		return this.iptclinician;
	}
	public static int getIPTClinicianMaxLength()
	{
		return 250;
	}
	public void setIPTClinician(String value)
	{
		this.isValidated = false;
		this.iptclinician = value;
	}
	public boolean getIPTCommentsIsNotNull()
	{
		return this.iptcomments != null;
	}
	public String getIPTComments()
	{
		return this.iptcomments;
	}
	public static int getIPTCommentsMaxLength()
	{
		return 2500;
	}
	public void setIPTComments(String value)
	{
		this.isValidated = false;
		this.iptcomments = value;
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
		if(this.catsreferral == null)
			listOfErrors.add("Cats Referral is mandatory");
		if(this.requesteddate == null)
			listOfErrors.add("Date Requested is mandatory");
		if(this.referringclinican == null)
			listOfErrors.add("Referring Clinician is mandatory");
		if(this.iptorganisation == null)
			listOfErrors.add("IPT to Organisation is mandatory");
		if(this.iptservice == null || this.iptservice.length() == 0)
			listOfErrors.add("IPT to Service is mandatory");
		else if(this.iptservice.length() > 250)
			listOfErrors.add("The length of the field [iptservice] in the value object [ims.RefMan.vo.InterProviderTransferOutVo] is too big. It should be less or equal to 250");
		if(this.iptclinician != null)
			if(this.iptclinician.length() > 250)
				listOfErrors.add("The length of the field [iptclinician] in the value object [ims.RefMan.vo.InterProviderTransferOutVo] is too big. It should be less or equal to 250");
		if(this.iptcomments != null)
			if(this.iptcomments.length() > 2500)
				listOfErrors.add("The length of the field [iptcomments] in the value object [ims.RefMan.vo.InterProviderTransferOutVo] is too big. It should be less or equal to 2500");
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
	
		InterProviderTransferOutVo clone = new InterProviderTransferOutVo(this.id, this.version);
		
		clone.patient = this.patient;
		clone.catsreferral = this.catsreferral;
		if(this.requesteddate == null)
			clone.requesteddate = null;
		else
			clone.requesteddate = (ims.framework.utils.Date)this.requesteddate.clone();
		if(this.referringclinican == null)
			clone.referringclinican = null;
		else
			clone.referringclinican = (ims.core.vo.HcpLiteVo)this.referringclinican.clone();
		if(this.iptorganisation == null)
			clone.iptorganisation = null;
		else
			clone.iptorganisation = (ims.RefMan.vo.lookups.OtherProviders)this.iptorganisation.clone();
		clone.iptservice = this.iptservice;
		clone.iptclinician = this.iptclinician;
		clone.iptcomments = this.iptcomments;
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
		if (!(InterProviderTransferOutVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A InterProviderTransferOutVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((InterProviderTransferOutVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((InterProviderTransferOutVo)obj).getBoId());
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
		if(this.catsreferral != null)
			count++;
		if(this.requesteddate != null)
			count++;
		if(this.referringclinican != null)
			count++;
		if(this.iptorganisation != null)
			count++;
		if(this.iptservice != null)
			count++;
		if(this.iptclinician != null)
			count++;
		if(this.iptcomments != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.RefMan.vo.CatsReferralRefVo catsreferral;
	protected ims.framework.utils.Date requesteddate;
	protected ims.core.vo.HcpLiteVo referringclinican;
	protected ims.RefMan.vo.lookups.OtherProviders iptorganisation;
	protected String iptservice;
	protected String iptclinician;
	protected String iptcomments;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
