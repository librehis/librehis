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

package ims.core.vo.beans;

public class CareContextSmallVoBean extends ims.vo.ValueObjectBean
{
	public CareContextSmallVoBean()
	{
	}
	public CareContextSmallVoBean(ims.core.vo.CareContextSmallVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.context = vo.getContext() == null ? null : (ims.vo.LookupInstanceBean)vo.getContext().getBean();
		this.startdatetime = vo.getStartDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStartDateTime().getBean();
		this.enddatetime = vo.getEndDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEndDateTime().getBean();
		this.carecontexthistory = vo.getCareContextHistory() == null ? null : vo.getCareContextHistory().getBeanCollection();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.CareContextSmallVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.context = vo.getContext() == null ? null : (ims.vo.LookupInstanceBean)vo.getContext().getBean();
		this.startdatetime = vo.getStartDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getStartDateTime().getBean();
		this.enddatetime = vo.getEndDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getEndDateTime().getBean();
		this.carecontexthistory = vo.getCareContextHistory() == null ? null : vo.getCareContextHistory().getBeanCollection();
	}

	public ims.core.vo.CareContextSmallVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.CareContextSmallVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.CareContextSmallVo vo = null;
		if(map != null)
			vo = (ims.core.vo.CareContextSmallVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.CareContextSmallVo();
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
	public ims.vo.LookupInstanceBean getContext()
	{
		return this.context;
	}
	public void setContext(ims.vo.LookupInstanceBean value)
	{
		this.context = value;
	}
	public ims.framework.utils.beans.DateTimeBean getStartDateTime()
	{
		return this.startdatetime;
	}
	public void setStartDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.startdatetime = value;
	}
	public ims.framework.utils.beans.DateTimeBean getEndDateTime()
	{
		return this.enddatetime;
	}
	public void setEndDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.enddatetime = value;
	}
	public ims.core.vo.beans.CareContextHistVoBean[] getCareContextHistory()
	{
		return this.carecontexthistory;
	}
	public void setCareContextHistory(ims.core.vo.beans.CareContextHistVoBean[] value)
	{
		this.carecontexthistory = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean context;
	private ims.framework.utils.beans.DateTimeBean startdatetime;
	private ims.framework.utils.beans.DateTimeBean enddatetime;
	private ims.core.vo.beans.CareContextHistVoBean[] carecontexthistory;
}
