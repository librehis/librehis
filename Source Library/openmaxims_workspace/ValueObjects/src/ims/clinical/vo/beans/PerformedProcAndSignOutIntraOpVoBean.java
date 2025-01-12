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

package ims.clinical.vo.beans;

public class PerformedProcAndSignOutIntraOpVoBean extends ims.vo.ValueObjectBean
{
	public PerformedProcAndSignOutIntraOpVoBean()
	{
	}
	public PerformedProcAndSignOutIntraOpVoBean(ims.clinical.vo.PerformedProcAndSignOutIntraOpVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.theatreappointment = vo.getTheatreAppointment() == null ? null : new ims.vo.RefVoBean(vo.getTheatreAppointment().getBoId(), vo.getTheatreAppointment().getBoVersion());
		this.unplannedreturntotheatre = vo.getUnplannedreturntotheatre();
		this.confirmedcountscomplete = vo.getConfirmedCountsComplete();
		this.antibioticsafterknifetoskin = vo.getAntibioticsAfterKnifeToSkin() == null ? null : (ims.vo.LookupInstanceBean)vo.getAntibioticsAfterKnifeToSkin().getBean();
		this.timeintraopantibioticsgiven = vo.getTimeIntraOpAntibioticsGiven() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTimeIntraOpAntibioticsGiven().getBean();
		this.administrationrecordcompleted = vo.getAdministrationRecordCompleted();
		this.anyspecimenshavebeenlabelled = vo.getAnySpecimensHaveBeenLabelled();
		this.anyequipmentproblemsaddressed = vo.getAnyEquipmentProblemsAddressed() == null ? null : (ims.vo.LookupInstanceBean)vo.getAnyEquipmentProblemsAddressed().getBean();
		this.keyconcernsdocumented = vo.getKeyConcernsDocumented();
		this.signaturebyregisteredpractitioner = vo.getSignatureByRegisteredPractitioner() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getSignatureByRegisteredPractitioner().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.PerformedProcAndSignOutIntraOpVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.theatreappointment = vo.getTheatreAppointment() == null ? null : new ims.vo.RefVoBean(vo.getTheatreAppointment().getBoId(), vo.getTheatreAppointment().getBoVersion());
		this.unplannedreturntotheatre = vo.getUnplannedreturntotheatre();
		this.confirmedcountscomplete = vo.getConfirmedCountsComplete();
		this.antibioticsafterknifetoskin = vo.getAntibioticsAfterKnifeToSkin() == null ? null : (ims.vo.LookupInstanceBean)vo.getAntibioticsAfterKnifeToSkin().getBean();
		this.timeintraopantibioticsgiven = vo.getTimeIntraOpAntibioticsGiven() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getTimeIntraOpAntibioticsGiven().getBean();
		this.administrationrecordcompleted = vo.getAdministrationRecordCompleted();
		this.anyspecimenshavebeenlabelled = vo.getAnySpecimensHaveBeenLabelled();
		this.anyequipmentproblemsaddressed = vo.getAnyEquipmentProblemsAddressed() == null ? null : (ims.vo.LookupInstanceBean)vo.getAnyEquipmentProblemsAddressed().getBean();
		this.keyconcernsdocumented = vo.getKeyConcernsDocumented();
		this.signaturebyregisteredpractitioner = vo.getSignatureByRegisteredPractitioner() == null ? null : (ims.core.vo.beans.HcpLiteVoBean)vo.getSignatureByRegisteredPractitioner().getBean(map);
	}

	public ims.clinical.vo.PerformedProcAndSignOutIntraOpVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.PerformedProcAndSignOutIntraOpVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.PerformedProcAndSignOutIntraOpVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.PerformedProcAndSignOutIntraOpVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.PerformedProcAndSignOutIntraOpVo();
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
	public ims.vo.RefVoBean getTheatreAppointment()
	{
		return this.theatreappointment;
	}
	public void setTheatreAppointment(ims.vo.RefVoBean value)
	{
		this.theatreappointment = value;
	}
	public Boolean getUnplannedreturntotheatre()
	{
		return this.unplannedreturntotheatre;
	}
	public void setUnplannedreturntotheatre(Boolean value)
	{
		this.unplannedreturntotheatre = value;
	}
	public Boolean getConfirmedCountsComplete()
	{
		return this.confirmedcountscomplete;
	}
	public void setConfirmedCountsComplete(Boolean value)
	{
		this.confirmedcountscomplete = value;
	}
	public ims.vo.LookupInstanceBean getAntibioticsAfterKnifeToSkin()
	{
		return this.antibioticsafterknifetoskin;
	}
	public void setAntibioticsAfterKnifeToSkin(ims.vo.LookupInstanceBean value)
	{
		this.antibioticsafterknifetoskin = value;
	}
	public ims.framework.utils.beans.DateTimeBean getTimeIntraOpAntibioticsGiven()
	{
		return this.timeintraopantibioticsgiven;
	}
	public void setTimeIntraOpAntibioticsGiven(ims.framework.utils.beans.DateTimeBean value)
	{
		this.timeintraopantibioticsgiven = value;
	}
	public Boolean getAdministrationRecordCompleted()
	{
		return this.administrationrecordcompleted;
	}
	public void setAdministrationRecordCompleted(Boolean value)
	{
		this.administrationrecordcompleted = value;
	}
	public Boolean getAnySpecimensHaveBeenLabelled()
	{
		return this.anyspecimenshavebeenlabelled;
	}
	public void setAnySpecimensHaveBeenLabelled(Boolean value)
	{
		this.anyspecimenshavebeenlabelled = value;
	}
	public ims.vo.LookupInstanceBean getAnyEquipmentProblemsAddressed()
	{
		return this.anyequipmentproblemsaddressed;
	}
	public void setAnyEquipmentProblemsAddressed(ims.vo.LookupInstanceBean value)
	{
		this.anyequipmentproblemsaddressed = value;
	}
	public Boolean getKeyConcernsDocumented()
	{
		return this.keyconcernsdocumented;
	}
	public void setKeyConcernsDocumented(Boolean value)
	{
		this.keyconcernsdocumented = value;
	}
	public ims.core.vo.beans.HcpLiteVoBean getSignatureByRegisteredPractitioner()
	{
		return this.signaturebyregisteredpractitioner;
	}
	public void setSignatureByRegisteredPractitioner(ims.core.vo.beans.HcpLiteVoBean value)
	{
		this.signaturebyregisteredpractitioner = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean theatreappointment;
	private Boolean unplannedreturntotheatre;
	private Boolean confirmedcountscomplete;
	private ims.vo.LookupInstanceBean antibioticsafterknifetoskin;
	private ims.framework.utils.beans.DateTimeBean timeintraopantibioticsgiven;
	private Boolean administrationrecordcompleted;
	private Boolean anyspecimenshavebeenlabelled;
	private ims.vo.LookupInstanceBean anyequipmentproblemsaddressed;
	private Boolean keyconcernsdocumented;
	private ims.core.vo.beans.HcpLiteVoBean signaturebyregisteredpractitioner;
}
