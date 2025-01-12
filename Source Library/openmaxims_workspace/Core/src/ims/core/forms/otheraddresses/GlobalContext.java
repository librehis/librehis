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

package ims.core.forms.otheraddresses;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Core = new CoreContext(context);
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getOtherAddressesIsNotNull()
		{
			return !cx_CoreOtherAddresses.getValueIsNull(context);
		}
		public ims.core.vo.PersonAddressCollection getOtherAddresses()
		{
			return (ims.core.vo.PersonAddressCollection)cx_CoreOtherAddresses.getValue(context);
		}
		public void setOtherAddresses(ims.core.vo.PersonAddressCollection value)
		{
			cx_CoreOtherAddresses.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreOtherAddresses = new ims.framework.ContextVariable("Core.OtherAddresses", "_cv_Core.OtherAddresses");
		public boolean getParentFormModeIsNotNull()
		{
			return !cx_CoreParentFormMode.getValueIsNull(context);
		}
		public ims.framework.enumerations.FormMode getParentFormMode()
		{
			return (ims.framework.enumerations.FormMode)cx_CoreParentFormMode.getValue(context);
		}

		private ims.framework.ContextVariable cx_CoreParentFormMode = new ims.framework.ContextVariable("Core.ParentFormMode", "_cv_Core.ParentFormMode");
		public boolean getPatientShortIsNotNull()
		{
			return !cx_CorePatientShort.getValueIsNull(context);
		}
		public ims.core.vo.PatientShort getPatientShort()
		{
			return (ims.core.vo.PatientShort)cx_CorePatientShort.getValue(context);
		}
		public void setPatientShort(ims.core.vo.PatientShort value)
		{
			cx_CorePatientShort.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CorePatientShort = new ims.framework.ContextVariable("Core.PatientShort", "_cvp_Core.PatientShort");
		public boolean getCommChannelsIsNotNull()
		{
			return !cx_CoreCommChannels.getValueIsNull(context);
		}
		public ims.core.vo.CommChannelVoCollection getCommChannels()
		{
			return (ims.core.vo.CommChannelVoCollection)cx_CoreCommChannels.getValue(context);
		}
		public void setCommChannels(ims.core.vo.CommChannelVoCollection value)
		{
			cx_CoreCommChannels.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreCommChannels = new ims.framework.ContextVariable("Core.CommChannels", "_cv_Core.CommChannels");
		public boolean getNOKPersonAddressIsNotNull()
		{
			return !cx_CoreNOKPersonAddress.getValueIsNull(context);
		}
		public ims.core.vo.PersonAddress getNOKPersonAddress()
		{
			return (ims.core.vo.PersonAddress)cx_CoreNOKPersonAddress.getValue(context);
		}
		public void setNOKPersonAddress(ims.core.vo.PersonAddress value)
		{
			cx_CoreNOKPersonAddress.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreNOKPersonAddress = new ims.framework.ContextVariable("Core.NOKPersonAddress", "_cv_Core.NOKPersonAddress");

		private ims.framework.Context context;
	}

	public CoreContext Core;
}
