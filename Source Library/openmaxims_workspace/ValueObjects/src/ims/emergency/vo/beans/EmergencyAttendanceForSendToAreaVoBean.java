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

package ims.emergency.vo.beans;

public class EmergencyAttendanceForSendToAreaVoBean extends ims.vo.ValueObjectBean
{
	public EmergencyAttendanceForSendToAreaVoBean()
	{
	}
	public EmergencyAttendanceForSendToAreaVoBean(ims.emergency.vo.EmergencyAttendanceForSendToAreaVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.dischargedatetime = vo.getDischargeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDischargeDateTime().getBean();
		this.outcome = vo.getOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcome().getBean();
		this.conclusiondatetime = vo.getConclusionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getConclusionDateTime().getBean();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextForTrackingShortVoBean)vo.getCareContext().getBean();
		this.ambulancearrivaldatetime = vo.getAmbulanceArrivalDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAmbulanceArrivalDateTime().getBean();
		this.ambulancejobno = vo.getAmbulanceJobNo();
		this.ambulancehandoverdatetime = vo.getAmbulanceHandoverDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAmbulanceHandoverDateTime().getBean();
		this.ambulancedelayreason = vo.getAmbulanceDelayReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getAmbulanceDelayReason().getBean();
		this.modeofarrival = vo.getModeOfArrival() == null ? null : (ims.vo.LookupInstanceBean)vo.getModeOfArrival().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.EmergencyAttendanceForSendToAreaVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.dischargedatetime = vo.getDischargeDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getDischargeDateTime().getBean();
		this.outcome = vo.getOutcome() == null ? null : (ims.vo.LookupInstanceBean)vo.getOutcome().getBean();
		this.conclusiondatetime = vo.getConclusionDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getConclusionDateTime().getBean();
		this.carecontext = vo.getCareContext() == null ? null : (ims.core.vo.beans.CareContextForTrackingShortVoBean)vo.getCareContext().getBean(map);
		this.ambulancearrivaldatetime = vo.getAmbulanceArrivalDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAmbulanceArrivalDateTime().getBean();
		this.ambulancejobno = vo.getAmbulanceJobNo();
		this.ambulancehandoverdatetime = vo.getAmbulanceHandoverDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getAmbulanceHandoverDateTime().getBean();
		this.ambulancedelayreason = vo.getAmbulanceDelayReason() == null ? null : (ims.vo.LookupInstanceBean)vo.getAmbulanceDelayReason().getBean();
		this.modeofarrival = vo.getModeOfArrival() == null ? null : (ims.vo.LookupInstanceBean)vo.getModeOfArrival().getBean();
	}

	public ims.emergency.vo.EmergencyAttendanceForSendToAreaVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.EmergencyAttendanceForSendToAreaVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.EmergencyAttendanceForSendToAreaVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.EmergencyAttendanceForSendToAreaVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.EmergencyAttendanceForSendToAreaVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.framework.utils.beans.DateTimeBean getDischargeDateTime()
	{
		return this.dischargedatetime;
	}
	public void setDischargeDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.dischargedatetime = value;
	}
	public ims.vo.LookupInstanceBean getOutcome()
	{
		return this.outcome;
	}
	public void setOutcome(ims.vo.LookupInstanceBean value)
	{
		this.outcome = value;
	}
	public ims.framework.utils.beans.DateTimeBean getConclusionDateTime()
	{
		return this.conclusiondatetime;
	}
	public void setConclusionDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.conclusiondatetime = value;
	}
	public ims.core.vo.beans.CareContextForTrackingShortVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.beans.CareContextForTrackingShortVoBean value)
	{
		this.carecontext = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAmbulanceArrivalDateTime()
	{
		return this.ambulancearrivaldatetime;
	}
	public void setAmbulanceArrivalDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.ambulancearrivaldatetime = value;
	}
	public String getAmbulanceJobNo()
	{
		return this.ambulancejobno;
	}
	public void setAmbulanceJobNo(String value)
	{
		this.ambulancejobno = value;
	}
	public ims.framework.utils.beans.DateTimeBean getAmbulanceHandoverDateTime()
	{
		return this.ambulancehandoverdatetime;
	}
	public void setAmbulanceHandoverDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.ambulancehandoverdatetime = value;
	}
	public ims.vo.LookupInstanceBean getAmbulanceDelayReason()
	{
		return this.ambulancedelayreason;
	}
	public void setAmbulanceDelayReason(ims.vo.LookupInstanceBean value)
	{
		this.ambulancedelayreason = value;
	}
	public ims.vo.LookupInstanceBean getModeOfArrival()
	{
		return this.modeofarrival;
	}
	public void setModeOfArrival(ims.vo.LookupInstanceBean value)
	{
		this.modeofarrival = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.DateTimeBean dischargedatetime;
	private ims.vo.LookupInstanceBean outcome;
	private ims.framework.utils.beans.DateTimeBean conclusiondatetime;
	private ims.core.vo.beans.CareContextForTrackingShortVoBean carecontext;
	private ims.framework.utils.beans.DateTimeBean ambulancearrivaldatetime;
	private String ambulancejobno;
	private ims.framework.utils.beans.DateTimeBean ambulancehandoverdatetime;
	private ims.vo.LookupInstanceBean ambulancedelayreason;
	private ims.vo.LookupInstanceBean modeofarrival;
}