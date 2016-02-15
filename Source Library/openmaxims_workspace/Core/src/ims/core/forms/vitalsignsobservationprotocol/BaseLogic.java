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

package ims.core.forms.vitalsignsobservationprotocol;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.core.domain.VitalSignsObservationProtocol.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.core.domain.VitalSignsObservationProtocol domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void clearContextInformation()
	{
		engine.clearPatientContextInformation();
	}
	protected final void oncmbOBSProtocolTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbOBSProtocolType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.OBSProtocolType existingInstance = (ims.core.vo.lookups.OBSProtocolType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbOBSProtocolTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.OBSProtocolType)
		{
			ims.core.vo.lookups.OBSProtocolType instance = (ims.core.vo.lookups.OBSProtocolType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbOBSProtocolTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.OBSProtocolType existingInstance = (ims.core.vo.lookups.OBSProtocolType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbOBSProtocolType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbOBSProtocolTypeLookup()
	{
		this.form.cmbOBSProtocolType().clear();
		ims.core.vo.lookups.OBSProtocolTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getOBSProtocolType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbOBSProtocolType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbOBSProtocolTypeLookupValue(int id)
	{
		ims.core.vo.lookups.OBSProtocolType instance = ims.core.vo.lookups.LookupHelper.getOBSProtocolTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbOBSProtocolType().setValue(instance);
	}
	protected final void defaultcmbOBSProtocolTypeLookupValue()
	{
		this.form.cmbOBSProtocolType().setValue((ims.core.vo.lookups.OBSProtocolType)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.OBSProtocolType.class, engine.getFormName().getID(), ims.core.vo.lookups.OBSProtocolType.TYPE_ID));
	}
	protected final void oncmbParameterValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbParameter().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.OBSType existingInstance = (ims.core.vo.lookups.OBSType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbParameterLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.OBSType)
		{
			ims.core.vo.lookups.OBSType instance = (ims.core.vo.lookups.OBSType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbParameterLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.OBSType existingInstance = (ims.core.vo.lookups.OBSType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbParameter().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbParameterLookup()
	{
		this.form.cmbParameter().clear();
		ims.core.vo.lookups.OBSTypeCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getOBSType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbParameter().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbParameterLookupValue(int id)
	{
		ims.core.vo.lookups.OBSType instance = ims.core.vo.lookups.LookupHelper.getOBSTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbParameter().setValue(instance);
	}
	protected final void defaultcmbParameterLookupValue()
	{
		this.form.cmbParameter().setValue((ims.core.vo.lookups.OBSType)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.OBSType.class, engine.getFormName().getID(), ims.core.vo.lookups.OBSType.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.core.domain.VitalSignsObservationProtocol domain;
}