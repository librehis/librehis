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

public class NurseVoBean extends ims.vo.ValueObjectBean
{
	public NurseVoBean()
	{
	}
	public NurseVoBean(ims.core.vo.NurseVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.hcptype = vo.getHcpType() == null ? null : (ims.vo.LookupInstanceBean)vo.getHcpType().getBean();
		this.queryname = vo.getQueryName() == null ? null : (ims.core.vo.beans.PersonNameBean)vo.getQueryName().getBean();
		this.isactive = vo.getIsActive();
		this.mos = vo.getMos() == null ? null : (ims.core.vo.beans.MemberOfStaffShortVoBean)vo.getMos().getBean();
		this.ishcparesponsiblehcp = vo.getIsHCPaResponsibleHCP();
		this.isalocalconsultant = vo.getIsALocalConsultant();
		this.isaresponsibleedclinician = vo.getIsAResponsibleEDClinician();
		this.nursetype = vo.getNurseType() == null ? null : (ims.vo.LookupInstanceBean)vo.getNurseType().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.NurseVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.hcptype = vo.getHcpType() == null ? null : (ims.vo.LookupInstanceBean)vo.getHcpType().getBean();
		this.queryname = vo.getQueryName() == null ? null : (ims.core.vo.beans.PersonNameBean)vo.getQueryName().getBean(map);
		this.isactive = vo.getIsActive();
		this.mos = vo.getMos() == null ? null : (ims.core.vo.beans.MemberOfStaffShortVoBean)vo.getMos().getBean(map);
		this.ishcparesponsiblehcp = vo.getIsHCPaResponsibleHCP();
		this.isalocalconsultant = vo.getIsALocalConsultant();
		this.isaresponsibleedclinician = vo.getIsAResponsibleEDClinician();
		this.nursetype = vo.getNurseType() == null ? null : (ims.vo.LookupInstanceBean)vo.getNurseType().getBean();
		this.specialty = vo.getSpecialty() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecialty().getBean();
	}

	public ims.core.vo.NurseVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.NurseVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.NurseVo vo = null;
		if(map != null)
			vo = (ims.core.vo.NurseVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.NurseVo();
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
	public ims.vo.LookupInstanceBean getHcpType()
	{
		return this.hcptype;
	}
	public void setHcpType(ims.vo.LookupInstanceBean value)
	{
		this.hcptype = value;
	}
	public ims.core.vo.beans.PersonNameBean getQueryName()
	{
		return this.queryname;
	}
	public void setQueryName(ims.core.vo.beans.PersonNameBean value)
	{
		this.queryname = value;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isactive = value;
	}
	public ims.core.vo.beans.MemberOfStaffShortVoBean getMos()
	{
		return this.mos;
	}
	public void setMos(ims.core.vo.beans.MemberOfStaffShortVoBean value)
	{
		this.mos = value;
	}
	public Boolean getIsHCPaResponsibleHCP()
	{
		return this.ishcparesponsiblehcp;
	}
	public void setIsHCPaResponsibleHCP(Boolean value)
	{
		this.ishcparesponsiblehcp = value;
	}
	public Boolean getIsALocalConsultant()
	{
		return this.isalocalconsultant;
	}
	public void setIsALocalConsultant(Boolean value)
	{
		this.isalocalconsultant = value;
	}
	public Boolean getIsAResponsibleEDClinician()
	{
		return this.isaresponsibleedclinician;
	}
	public void setIsAResponsibleEDClinician(Boolean value)
	{
		this.isaresponsibleedclinician = value;
	}
	public ims.vo.LookupInstanceBean getNurseType()
	{
		return this.nursetype;
	}
	public void setNurseType(ims.vo.LookupInstanceBean value)
	{
		this.nursetype = value;
	}
	public ims.vo.LookupInstanceBean getSpecialty()
	{
		return this.specialty;
	}
	public void setSpecialty(ims.vo.LookupInstanceBean value)
	{
		this.specialty = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean hcptype;
	private ims.core.vo.beans.PersonNameBean queryname;
	private Boolean isactive;
	private ims.core.vo.beans.MemberOfStaffShortVoBean mos;
	private Boolean ishcparesponsiblehcp;
	private Boolean isalocalconsultant;
	private Boolean isaresponsibleedclinician;
	private ims.vo.LookupInstanceBean nursetype;
	private ims.vo.LookupInstanceBean specialty;
}