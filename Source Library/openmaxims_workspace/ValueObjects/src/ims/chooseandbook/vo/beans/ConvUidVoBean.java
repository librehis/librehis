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

package ims.chooseandbook.vo.beans;

public class ConvUidVoBean extends ims.vo.ValueObjectBean
{
	public ConvUidVoBean()
	{
	}
	public ConvUidVoBean(ims.chooseandbook.vo.ConvUidVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.convid = vo.getConvId() == null ? null : (ims.chooseandbook.vo.beans.ConvIdVoBean)vo.getConvId().getBean();
		this.msguid = vo.getMsgUid();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.chooseandbook.vo.ConvUidVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.convid = vo.getConvId() == null ? null : (ims.chooseandbook.vo.beans.ConvIdVoBean)vo.getConvId().getBean(map);
		this.msguid = vo.getMsgUid();
	}

	public ims.chooseandbook.vo.ConvUidVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.chooseandbook.vo.ConvUidVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.chooseandbook.vo.ConvUidVo vo = null;
		if(map != null)
			vo = (ims.chooseandbook.vo.ConvUidVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.chooseandbook.vo.ConvUidVo();
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
	public ims.chooseandbook.vo.beans.ConvIdVoBean getConvId()
	{
		return this.convid;
	}
	public void setConvId(ims.chooseandbook.vo.beans.ConvIdVoBean value)
	{
		this.convid = value;
	}
	public String getMsgUid()
	{
		return this.msguid;
	}
	public void setMsgUid(String value)
	{
		this.msguid = value;
	}

	private Integer id;
	private int version;
	private ims.chooseandbook.vo.beans.ConvIdVoBean convid;
	private String msguid;
}
