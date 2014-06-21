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

package ims.core.vo.beans;

public class DeathDetailsVoBean extends ims.vo.ValueObjectBean
{
	public DeathDetailsVoBean()
	{
	}
	public DeathDetailsVoBean(ims.core.vo.DeathDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.deathplaceofdeath = vo.getDeathPlaceofDeath() == null ? null : (ims.vo.LookupInstanceBean)vo.getDeathPlaceofDeath().getBean();
		this.deathcauseestablished = vo.getDeathCauseEstablished() == null ? null : (ims.vo.LookupInstanceBean)vo.getDeathCauseEstablished().getBean();
		this.cancerrelateddeath = vo.getCancerRelatedDeath() == null ? null : (ims.vo.LookupInstanceBean)vo.getCancerRelatedDeath().getBean();
		this.deathcodediscrepency = vo.getDeathCodeDiscrepency() == null ? null : (ims.vo.LookupInstanceBean)vo.getDeathCodeDiscrepency().getBean();
		this.deathconditions = vo.getDeathConditions() == null ? null : vo.getDeathConditions().getBeanCollection();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean();
		this.referredtocorroner = vo.getReferredToCorroner();
		this.postmortem = vo.getPostMortem() == null ? null : (ims.vo.LookupInstanceBean)vo.getPostMortem().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.DeathDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.deathplaceofdeath = vo.getDeathPlaceofDeath() == null ? null : (ims.vo.LookupInstanceBean)vo.getDeathPlaceofDeath().getBean();
		this.deathcauseestablished = vo.getDeathCauseEstablished() == null ? null : (ims.vo.LookupInstanceBean)vo.getDeathCauseEstablished().getBean();
		this.cancerrelateddeath = vo.getCancerRelatedDeath() == null ? null : (ims.vo.LookupInstanceBean)vo.getCancerRelatedDeath().getBean();
		this.deathcodediscrepency = vo.getDeathCodeDiscrepency() == null ? null : (ims.vo.LookupInstanceBean)vo.getDeathCodeDiscrepency().getBean();
		this.deathconditions = vo.getDeathConditions() == null ? null : vo.getDeathConditions().getBeanCollection();
		this.patient = vo.getPatient() == null ? null : (ims.core.vo.beans.PatientShortBean)vo.getPatient().getBean(map);
		this.referredtocorroner = vo.getReferredToCorroner();
		this.postmortem = vo.getPostMortem() == null ? null : (ims.vo.LookupInstanceBean)vo.getPostMortem().getBean();
	}

	public ims.core.vo.DeathDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.DeathDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.DeathDetailsVo vo = null;
		if(map != null)
			vo = (ims.core.vo.DeathDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.DeathDetailsVo();
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
	public ims.vo.LookupInstanceBean getDeathPlaceofDeath()
	{
		return this.deathplaceofdeath;
	}
	public void setDeathPlaceofDeath(ims.vo.LookupInstanceBean value)
	{
		this.deathplaceofdeath = value;
	}
	public ims.vo.LookupInstanceBean getDeathCauseEstablished()
	{
		return this.deathcauseestablished;
	}
	public void setDeathCauseEstablished(ims.vo.LookupInstanceBean value)
	{
		this.deathcauseestablished = value;
	}
	public ims.vo.LookupInstanceBean getCancerRelatedDeath()
	{
		return this.cancerrelateddeath;
	}
	public void setCancerRelatedDeath(ims.vo.LookupInstanceBean value)
	{
		this.cancerrelateddeath = value;
	}
	public ims.vo.LookupInstanceBean getDeathCodeDiscrepency()
	{
		return this.deathcodediscrepency;
	}
	public void setDeathCodeDiscrepency(ims.vo.LookupInstanceBean value)
	{
		this.deathcodediscrepency = value;
	}
	public ims.core.vo.beans.DeathConditionsVoBean[] getDeathConditions()
	{
		return this.deathconditions;
	}
	public void setDeathConditions(ims.core.vo.beans.DeathConditionsVoBean[] value)
	{
		this.deathconditions = value;
	}
	public ims.core.vo.beans.PatientShortBean getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.vo.beans.PatientShortBean value)
	{
		this.patient = value;
	}
	public Boolean getReferredToCorroner()
	{
		return this.referredtocorroner;
	}
	public void setReferredToCorroner(Boolean value)
	{
		this.referredtocorroner = value;
	}
	public ims.vo.LookupInstanceBean getPostMortem()
	{
		return this.postmortem;
	}
	public void setPostMortem(ims.vo.LookupInstanceBean value)
	{
		this.postmortem = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean deathplaceofdeath;
	private ims.vo.LookupInstanceBean deathcauseestablished;
	private ims.vo.LookupInstanceBean cancerrelateddeath;
	private ims.vo.LookupInstanceBean deathcodediscrepency;
	private ims.core.vo.beans.DeathConditionsVoBean[] deathconditions;
	private ims.core.vo.beans.PatientShortBean patient;
	private Boolean referredtocorroner;
	private ims.vo.LookupInstanceBean postmortem;
}