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

public class CarePlanReviewVoBean extends ims.vo.ValueObjectBean
{
	public CarePlanReviewVoBean()
	{
	}
	public CarePlanReviewVoBean(ims.core.vo.CarePlanReviewVo vo)
	{
		this.carecontextvo = vo.getCareContextVo() == null ? null : (ims.core.vo.beans.CareContextShortVoBean)vo.getCareContextVo().getBean();
		this.ward = vo.getWard() == null ? null : (ims.core.vo.beans.LocMostVoBean)vo.getWard().getBean();
		this.hospital = vo.getHospital() == null ? null : (ims.core.vo.beans.LocMostVoBean)vo.getHospital().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.CarePlanReviewVo vo)
	{
		this.carecontextvo = vo.getCareContextVo() == null ? null : (ims.core.vo.beans.CareContextShortVoBean)vo.getCareContextVo().getBean(map);
		this.ward = vo.getWard() == null ? null : (ims.core.vo.beans.LocMostVoBean)vo.getWard().getBean(map);
		this.hospital = vo.getHospital() == null ? null : (ims.core.vo.beans.LocMostVoBean)vo.getHospital().getBean(map);
	}

	public ims.core.vo.CarePlanReviewVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.CarePlanReviewVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.CarePlanReviewVo vo = null;
		if(map != null)
			vo = (ims.core.vo.CarePlanReviewVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.CarePlanReviewVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public ims.core.vo.beans.CareContextShortVoBean getCareContextVo()
	{
		return this.carecontextvo;
	}
	public void setCareContextVo(ims.core.vo.beans.CareContextShortVoBean value)
	{
		this.carecontextvo = value;
	}
	public ims.core.vo.beans.LocMostVoBean getWard()
	{
		return this.ward;
	}
	public void setWard(ims.core.vo.beans.LocMostVoBean value)
	{
		this.ward = value;
	}
	public ims.core.vo.beans.LocMostVoBean getHospital()
	{
		return this.hospital;
	}
	public void setHospital(ims.core.vo.beans.LocMostVoBean value)
	{
		this.hospital = value;
	}

	private ims.core.vo.beans.CareContextShortVoBean carecontextvo;
	private ims.core.vo.beans.LocMostVoBean ward;
	private ims.core.vo.beans.LocMostVoBean hospital;
}