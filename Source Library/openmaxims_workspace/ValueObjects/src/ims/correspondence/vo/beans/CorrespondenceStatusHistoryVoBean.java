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

package ims.correspondence.vo.beans;

public class CorrespondenceStatusHistoryVoBean extends ims.vo.ValueObjectBean
{
	public CorrespondenceStatusHistoryVoBean()
	{
	}
	public CorrespondenceStatusHistoryVoBean(ims.correspondence.vo.CorrespondenceStatusHistoryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.templatename = vo.getTemplateName();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.mos = vo.getMos() == null ? null : (ims.core.vo.beans.MemberOfStaffShortVoBean)vo.getMos().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.correspondence.vo.CorrespondenceStatusHistoryVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.status = vo.getStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getStatus().getBean();
		this.templatename = vo.getTemplateName();
		this.sysinfo = vo.getSysInfo() == null ? null : (ims.vo.SysInfoBean)vo.getSysInfo().getBean();
		this.mos = vo.getMos() == null ? null : (ims.core.vo.beans.MemberOfStaffShortVoBean)vo.getMos().getBean(map);
	}

	public ims.correspondence.vo.CorrespondenceStatusHistoryVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.correspondence.vo.CorrespondenceStatusHistoryVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.correspondence.vo.CorrespondenceStatusHistoryVo vo = null;
		if(map != null)
			vo = (ims.correspondence.vo.CorrespondenceStatusHistoryVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.correspondence.vo.CorrespondenceStatusHistoryVo();
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
	public ims.vo.LookupInstanceBean getStatus()
	{
		return this.status;
	}
	public void setStatus(ims.vo.LookupInstanceBean value)
	{
		this.status = value;
	}
	public String getTemplateName()
	{
		return this.templatename;
	}
	public void setTemplateName(String value)
	{
		this.templatename = value;
	}
	public ims.vo.SysInfoBean getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SysInfoBean value)
	{
		this.sysinfo = value;
	}
	public ims.core.vo.beans.MemberOfStaffShortVoBean getMos()
	{
		return this.mos;
	}
	public void setMos(ims.core.vo.beans.MemberOfStaffShortVoBean value)
	{
		this.mos = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean status;
	private String templatename;
	private ims.vo.SysInfoBean sysinfo;
	private ims.core.vo.beans.MemberOfStaffShortVoBean mos;
}
