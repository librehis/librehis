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

package ims.ocrr.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to OCRR.OrderingResults.SpecimenWorkListItem business object (ID: 1061100014).
 */
public class SpecimenWorkListItemVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<SpecimenWorkListItemVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<SpecimenWorkListItemVo> col = new ArrayList<SpecimenWorkListItemVo>();
	public String getBoClassName()
	{
		return "ims.ocrr.orderingresults.domain.objects.SpecimenWorkListItem";
	}
	public boolean add(SpecimenWorkListItemVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, SpecimenWorkListItemVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			this.col.add(index, value);
			return true;
		}
		return false;
	}
	public void clear()
	{
		this.col.clear();
	}
	public void remove(int index)
	{
		this.col.remove(index);
	}
	public int size()
	{
		return this.col.size();
	}
	public int indexOf(SpecimenWorkListItemVo instance)
	{
		return col.indexOf(instance);
	}
	public SpecimenWorkListItemVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, SpecimenWorkListItemVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(SpecimenWorkListItemVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(SpecimenWorkListItemVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		SpecimenWorkListItemVoCollection clone = new SpecimenWorkListItemVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((SpecimenWorkListItemVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		
		return clone;
	}
	public boolean isValidated()
	{
		for(int x = 0; x < col.size(); x++)
			if(!this.col.get(x).isValidated())
				return false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(col.size() == 0)
			return null;
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		for(int x = 0; x < col.size(); x++)
		{
			String[] listOfOtherErrors = this.col.get(x).validate();
			if(listOfOtherErrors != null)
			{
				for(int y = 0; y < listOfOtherErrors.length; y++)
				{
					listOfErrors.add(listOfOtherErrors[y]);
				}
			}
		}
		
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
			return null;
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		return result;
	}
	public SpecimenWorkListItemVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public SpecimenWorkListItemVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public SpecimenWorkListItemVoCollection sort(SortOrder order)
	{
		return sort(new SpecimenWorkListItemVoComparator(order));
	}
	public SpecimenWorkListItemVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new SpecimenWorkListItemVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public SpecimenWorkListItemVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.ocrr.orderingresults.vo.SpecimenWorkListItemRefVoCollection toRefVoCollection()
	{
		ims.ocrr.orderingresults.vo.SpecimenWorkListItemRefVoCollection result = new ims.ocrr.orderingresults.vo.SpecimenWorkListItemRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public SpecimenWorkListItemVo[] toArray()
	{
		SpecimenWorkListItemVo[] arr = new SpecimenWorkListItemVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<SpecimenWorkListItemVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class SpecimenWorkListItemVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public SpecimenWorkListItemVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public SpecimenWorkListItemVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public SpecimenWorkListItemVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			SpecimenWorkListItemVo voObj1 = (SpecimenWorkListItemVo)obj1;
			SpecimenWorkListItemVo voObj2 = (SpecimenWorkListItemVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.ocrr.vo.beans.SpecimenWorkListItemVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.ocrr.vo.beans.SpecimenWorkListItemVoBean[] getBeanCollectionArray()
	{
		ims.ocrr.vo.beans.SpecimenWorkListItemVoBean[] result = new ims.ocrr.vo.beans.SpecimenWorkListItemVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			SpecimenWorkListItemVo vo = ((SpecimenWorkListItemVo)col.get(i));
			result[i] = (ims.ocrr.vo.beans.SpecimenWorkListItemVoBean)vo.getBean();
		}
		return result;
	}
	public static SpecimenWorkListItemVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		SpecimenWorkListItemVoCollection coll = new SpecimenWorkListItemVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.ocrr.vo.beans.SpecimenWorkListItemVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static SpecimenWorkListItemVoCollection buildFromBeanCollection(ims.ocrr.vo.beans.SpecimenWorkListItemVoBean[] beans)
	{
		SpecimenWorkListItemVoCollection coll = new SpecimenWorkListItemVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}