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
/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5589.25814)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated on 12/10/2015, 13:24
 *
 */
package ims.therapies.vo.domain;

import ims.vo.domain.DomainObjectMap;
import java.util.HashMap;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Peter Martin
 */
public class WheelchairSkillsVoAssembler
{
  	/**
	 * Copy one ValueObject to another
	 * @param valueObjectDest to be updated
	 * @param valueObjectSrc to copy values from
	 */
	 public static ims.therapies.vo.WheelchairSkillsVo copy(ims.therapies.vo.WheelchairSkillsVo valueObjectDest, ims.therapies.vo.WheelchairSkillsVo valueObjectSrc) 
	 {
	 	if (null == valueObjectSrc) 
		{
			return valueObjectSrc;
		}
		valueObjectDest.setID_WheelchairSkills(valueObjectSrc.getID_WheelchairSkills());
	    valueObjectDest.setIsRIE(valueObjectSrc.getIsRIE());
		// AuthoringDateTime
		valueObjectDest.setAuthoringDateTime(valueObjectSrc.getAuthoringDateTime());
		// AuthoringCP
		valueObjectDest.setAuthoringCP(valueObjectSrc.getAuthoringCP());
		// WheelchairSkills
		valueObjectDest.setWheelchairSkills(valueObjectSrc.getWheelchairSkills());
		// Details
		valueObjectDest.setDetails(valueObjectSrc.getDetails());
		// ClinicalContact
		valueObjectDest.setClinicalContact(valueObjectSrc.getClinicalContact());
	 	return valueObjectDest;
	 }

 
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * This is a convenience method only.
	 * It is intended to be used when one called to an Assembler is made.
 	 * If more than one call to an Assembler is made then #createWheelchairSkillsVoCollectionFromWheelchairSkills(DomainObjectMap, Set) should be used.
	 * @param domainObjectSet - Set of ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills objects.
	 */
	public static ims.therapies.vo.WheelchairSkillsVoCollection createWheelchairSkillsVoCollectionFromWheelchairSkills(java.util.Set domainObjectSet)	
	{
		return createWheelchairSkillsVoCollectionFromWheelchairSkills(new DomainObjectMap(), domainObjectSet);
	}
	
	/**
	 * Create the ValueObject collection to hold the set of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectSet - Set of ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills objects.
	 */
	public static ims.therapies.vo.WheelchairSkillsVoCollection createWheelchairSkillsVoCollectionFromWheelchairSkills(DomainObjectMap map, java.util.Set domainObjectSet)	
	{
		ims.therapies.vo.WheelchairSkillsVoCollection voList = new ims.therapies.vo.WheelchairSkillsVoCollection();
		if ( null == domainObjectSet ) 
		{
			return voList;
		}
		int rieCount=0;
		int activeCount=0;
		java.util.Iterator iterator = domainObjectSet.iterator();
		while( iterator.hasNext() ) 
		{
			ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills domainObject = (ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills) iterator.next();
			ims.therapies.vo.WheelchairSkillsVo vo = create(map, domainObject);
			
			if (vo != null)
				voList.add(vo);
				
			if (domainObject != null)
			{				
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param domainObjectList - List of ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills objects.
	 */
	public static ims.therapies.vo.WheelchairSkillsVoCollection createWheelchairSkillsVoCollectionFromWheelchairSkills(java.util.List domainObjectList) 
	{
		return createWheelchairSkillsVoCollectionFromWheelchairSkills(new DomainObjectMap(), domainObjectList);
	}
	
	/**
	 * Create the ValueObject collection to hold the list of DomainObjects.
	 * @param map - maps DomainObjects to created ValueObjects
	 * @param domainObjectList - List of ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills objects.
	 */
	public static ims.therapies.vo.WheelchairSkillsVoCollection createWheelchairSkillsVoCollectionFromWheelchairSkills(DomainObjectMap map, java.util.List domainObjectList) 
	{
		ims.therapies.vo.WheelchairSkillsVoCollection voList = new ims.therapies.vo.WheelchairSkillsVoCollection();
		if ( null == domainObjectList ) 
		{
			return voList;
		}		
		int rieCount=0;
		int activeCount=0;
		for (int i = 0; i < domainObjectList.size(); i++)
		{
			ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills domainObject = (ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills) domainObjectList.get(i);
			ims.therapies.vo.WheelchairSkillsVo vo = create(map, domainObject);

			if (vo != null)
				voList.add(vo);
			
			if (domainObject != null)
			{
				if (domainObject.getIsRIE() != null && domainObject.getIsRIE().booleanValue() == true)
					rieCount++;
				else
					activeCount++;
			}
		}
		
		voList.setRieCount(rieCount);
		voList.setActiveCount(activeCount);
		return voList;
	}

	/**
	 * Create the ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills set from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.Set extractWheelchairSkillsSet(ims.domain.ILightweightDomainFactory domainFactory, ims.therapies.vo.WheelchairSkillsVoCollection voCollection) 
	 {
	 	return extractWheelchairSkillsSet(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.Set extractWheelchairSkillsSet(ims.domain.ILightweightDomainFactory domainFactory, ims.therapies.vo.WheelchairSkillsVoCollection voCollection, java.util.Set domainObjectSet, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectSet == null)
		{
			domainObjectSet = new java.util.HashSet();			
		}
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			ims.therapies.vo.WheelchairSkillsVo vo = voCollection.get(i);
			ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills domainObject = WheelchairSkillsVoAssembler.extractWheelchairSkills(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!domainObjectSet.contains(domainObject)) domainObjectSet.add(domainObject);
			newSet.add(domainObject);			
		}
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = domainObjectSet.iterator();
		//Find out which objects need to be removed
		while (iter.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet.contains(o))
			{
				removedSet.add(o);
			}
		}
		iter = removedSet.iterator();
		//Remove the unwanted objects
		while (iter.hasNext())
		{
			domainObjectSet.remove(iter.next());
		}
		return domainObjectSet;	 
	 }


	/**
	 * Create the ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills list from the value object collection.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param voCollection - the collection of value objects	 
	 */
	 public static java.util.List extractWheelchairSkillsList(ims.domain.ILightweightDomainFactory domainFactory, ims.therapies.vo.WheelchairSkillsVoCollection voCollection) 
	 {
	 	return extractWheelchairSkillsList(domainFactory, voCollection, null, new HashMap());
	 }
	 
	 public static java.util.List extractWheelchairSkillsList(ims.domain.ILightweightDomainFactory domainFactory, ims.therapies.vo.WheelchairSkillsVoCollection voCollection, java.util.List domainObjectList, HashMap domMap) 
	 {
	 	int size = (null == voCollection) ? 0 : voCollection.size();
		if (domainObjectList == null)
		{
			domainObjectList = new java.util.ArrayList();			
		}
		for(int i=0; i<size; i++) 
		{
			ims.therapies.vo.WheelchairSkillsVo vo = voCollection.get(i);
			ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills domainObject = WheelchairSkillsVoAssembler.extractWheelchairSkills(domainFactory, vo, domMap);

			//TODO: This can only occur in the situation of a stale object exception. For now leave it to the Interceptor to handle it.
			if (domainObject == null)
			{
				continue;
			}

			int domIdx = domainObjectList.indexOf(domainObject);
			if (domIdx == -1)
			{
				domainObjectList.add(i, domainObject);
			}
			else if (i != domIdx && i < domainObjectList.size())
			{
				Object tmp = domainObjectList.get(i);
				domainObjectList.set(i, domainObjectList.get(domIdx));
				domainObjectList.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=domainObjectList.size();
		while (i1 > size)
		{
			domainObjectList.remove(i1-1);
			i1=domainObjectList.size();
		}
		return domainObjectList;	 
	 }

 

	/**
	 * Create the ValueObject from the ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills object.
	 * @param domainObject ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills
	 */
	 public static ims.therapies.vo.WheelchairSkillsVo create(ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return null;
		}
		DomainObjectMap map = new DomainObjectMap();
		return create(map, domainObject);
	 }
	 
	 /**
	  * Create the ValueObject from the ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills object.
	  * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	  * @param domainObject
	  */
	  public static ims.therapies.vo.WheelchairSkillsVo create(DomainObjectMap map, ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills domainObject) 
	  {
	  		if (null == domainObject) 
	  		{
				return null;
			}
			// check if the domainObject already has a valueObject created for it
			ims.therapies.vo.WheelchairSkillsVo valueObject = (ims.therapies.vo.WheelchairSkillsVo) map.getValueObject(domainObject, ims.therapies.vo.WheelchairSkillsVo.class);
			if ( null == valueObject ) 
			{
				valueObject = new ims.therapies.vo.WheelchairSkillsVo(domainObject.getId(), domainObject.getVersion());
				map.addValueObject(domainObject, valueObject);

				valueObject = insert(map, valueObject, domainObject);
				
			}
	 		return valueObject;
	  }

	/**
	 * Update the ValueObject with the Domain Object.
	 * @param valueObject to be updated
	 * @param domainObject ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills
	 */
	 public static ims.therapies.vo.WheelchairSkillsVo insert(ims.therapies.vo.WheelchairSkillsVo valueObject, ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
		DomainObjectMap map = new DomainObjectMap();
		return insert(map, valueObject, domainObject);
	 }
	 
	/**
	 * Update the ValueObject with the Domain Object.
	 * @param map DomainObjectMap of DomainObjects to already created ValueObjects.
	 * @param valueObject to be updated
	 * @param domainObject ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills
	 */
	 public static ims.therapies.vo.WheelchairSkillsVo insert(DomainObjectMap map, ims.therapies.vo.WheelchairSkillsVo valueObject, ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills domainObject) 
	 {
	 	if (null == domainObject) 
	 	{
			return valueObject;
		}
	 	if (null == map) 
	 	{
			map = new DomainObjectMap();
		}

		valueObject.setID_WheelchairSkills(domainObject.getId());
		valueObject.setIsRIE(domainObject.getIsRIE());
		
		// If this is a recordedInError record, and the domainObject
		// value isIncludeRecord has not been set, then we return null and
		// not the value object
		if (valueObject.getIsRIE() != null && valueObject.getIsRIE().booleanValue() == true && !domainObject.isIncludeRecord())
			return null;
			
		// If this is not a recordedInError record, and the domainObject
		// value isIncludeRecord has been set, then we return null and
		// not the value object
		if ((valueObject.getIsRIE() == null || valueObject.getIsRIE().booleanValue() == false) && domainObject.isIncludeRecord())
			return null;
			
		// AuthoringDateTime
		java.util.Date AuthoringDateTime = domainObject.getAuthoringDateTime();
		if ( null != AuthoringDateTime ) 
		{
			valueObject.setAuthoringDateTime(new ims.framework.utils.DateTime(AuthoringDateTime) );
		}
		// AuthoringCP
		valueObject.setAuthoringCP(ims.core.vo.domain.HcpAssembler.create(map, domainObject.getAuthoringCP()) );
		// WheelchairSkills
		java.util.List listWheelchairSkills = domainObject.getWheelchairSkills();
		ims.spinalinjuries.vo.lookups.WheelchairSkillCollection WheelchairSkills = new ims.spinalinjuries.vo.lookups.WheelchairSkillCollection();
		for(java.util.Iterator iterator = listWheelchairSkills.iterator(); iterator.hasNext(); ) 
		{
			ims.framework.utils.ImagePath img = null;
			ims.framework.utils.Color color = null;
		
			ims.domain.lookups.LookupInstance instance = 
				(ims.domain.lookups.LookupInstance) iterator.next();
			if (instance.getImage() != null) 
			{
				img = new ims.framework.utils.ImagePath(instance.getImage().getImageId(), instance.getImage().getImagePath());
			}
			else 
			{
				img = null;
			}
			color = instance.getColor();
			if (color != null) 
				color.getValue();
			ims.spinalinjuries.vo.lookups.WheelchairSkill voInstance = new ims.spinalinjuries.vo.lookups.WheelchairSkill(instance.getId(),instance.getText(), instance.isActive(), null, img, color);
			ims.spinalinjuries.vo.lookups.WheelchairSkill parentVoInstance = voInstance;
			ims.domain.lookups.LookupInstance parent = instance.getParent();
			while (parent != null)
			{
				if (parent.getImage() != null) 
				{
					img = new ims.framework.utils.ImagePath(parent.getImage().getImageId(), parent.getImage().getImagePath());
				}
				else 
				{
					img = null;
				}
				color = parent.getColor();
				if (color != null) 
					color.getValue();
								parentVoInstance.setParent(new ims.spinalinjuries.vo.lookups.WheelchairSkill(parent.getId(),parent.getText(), parent.isActive(), null, img, color));
				parentVoInstance = parentVoInstance.getParent();
								parent = parent.getParent();
			}			
			WheelchairSkills.add(voInstance);
		}
		valueObject.setWheelchairSkills( WheelchairSkills );
		// Details
		valueObject.setDetails(domainObject.getDetails());
		// ClinicalContact
		if (domainObject.getClinicalContact() != null)
		{
			if(domainObject.getClinicalContact() instanceof HibernateProxy) // If the proxy is set, there is no need to lazy load, the proxy knows the id already. 
			{
				HibernateProxy p = (HibernateProxy) domainObject.getClinicalContact();
				int id = Integer.parseInt(p.getHibernateLazyInitializer().getIdentifier().toString());				
				valueObject.setClinicalContact(new ims.core.admin.vo.ClinicalContactRefVo(id, -1));				
			}
			else
			{
				valueObject.setClinicalContact(new ims.core.admin.vo.ClinicalContactRefVo(domainObject.getClinicalContact().getId(), domainObject.getClinicalContact().getVersion()));
			}
		}
 		return valueObject;
	 }


	/**
	 * Create the domain object from the value object.
	 * @param domainFactory - used to create existing (persistent) domain objects.
	 * @param valueObject - extract the domain object fields from this.
	 */
	public static ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills extractWheelchairSkills(ims.domain.ILightweightDomainFactory domainFactory, ims.therapies.vo.WheelchairSkillsVo valueObject) 
	{
		return 	extractWheelchairSkills(domainFactory, valueObject, new HashMap());
	}

	public static ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills extractWheelchairSkills(ims.domain.ILightweightDomainFactory domainFactory, ims.therapies.vo.WheelchairSkillsVo valueObject, HashMap domMap) 
	{
		if (null == valueObject) 
		{
			return null;
		}
		Integer id = valueObject.getID_WheelchairSkills();
		ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills domainObject = null;
		if ( null == id) 
		{
			if (domMap.get(valueObject) != null)
			{
				return (ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills)domMap.get(valueObject);
			}
			// ims.therapies.vo.WheelchairSkillsVo ID_WheelchairSkills field is unknown
			domainObject = new ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills();
			domMap.put(valueObject, domainObject);
		}
		else 
		{
			String key = (valueObject.getClass().getName() + "__" + valueObject.getID_WheelchairSkills());
			if (domMap.get(key) != null)
			{
				return (ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills)domMap.get(key);
			}
			domainObject = (ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills) domainFactory.getDomainObject(ims.therapies.mobilitytransfers.domain.objects.WheelchairSkills.class, id );
			
			//TODO: Not sure how this should be handled. Effectively it must be a staleobject exception, but maybe should be handled as that further up.
			if (domainObject == null) 
				return null;

			domMap.put(key, domainObject);
		}
		domainObject.setVersion(valueObject.getVersion_WheelchairSkills());

		ims.framework.utils.DateTime dateTime1 = valueObject.getAuthoringDateTime();
		java.util.Date value1 = null;
		if ( dateTime1 != null ) 
		{
			value1 = dateTime1.getJavaDate();
		}
		domainObject.setAuthoringDateTime(value1);
		domainObject.setAuthoringCP(ims.core.vo.domain.HcpAssembler.extractHcp(domainFactory, valueObject.getAuthoringCP(), domMap));
		ims.spinalinjuries.vo.lookups.WheelchairSkillCollection collection3 =
	valueObject.getWheelchairSkills();
	    java.util.List domainWheelchairSkills = domainObject.getWheelchairSkills();;			
	    int collection3Size=0;
		if (collection3 == null)
		{
			domainWheelchairSkills = new java.util.ArrayList(0);
		}
		else
		{
			collection3Size = collection3.size();
		}
		
		for(int i=0; i<collection3Size; i++) 
		{
			int instanceId = collection3.get(i).getID();
			ims.domain.lookups.LookupInstanceRef dom =new ims.domain.lookups.LookupInstanceRef(domainFactory.getLookupInstance(instanceId));
			
			int domIdx = domainWheelchairSkills.indexOf(dom);
			if (domIdx == -1)
			{
				domainWheelchairSkills.add(i, dom);
			}
			else if (i != domIdx && i < domainWheelchairSkills.size())
			{
				Object tmp = domainWheelchairSkills.get(i);
				domainWheelchairSkills.set(i, domainWheelchairSkills.get(domIdx));
				domainWheelchairSkills.set(domIdx, tmp);
			}
		}
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int j3 = domainWheelchairSkills.size();
		while (j3 > collection3Size)
		{
			domainWheelchairSkills.remove(j3-1);
			j3 = domainWheelchairSkills.size();
		}

		domainObject.setWheelchairSkills(domainWheelchairSkills);		
		//This is to overcome a bug in both Sybase and Oracle which prevents them from storing an empty string correctly
		//Sybase stores it as a single space, Oracle stores it as NULL. This fix will make them consistent at least.
		if (valueObject.getDetails() != null && valueObject.getDetails().equals(""))
		{
			valueObject.setDetails(null);
		}
		domainObject.setDetails(valueObject.getDetails());
		ims.core.admin.domain.objects.ClinicalContact value5 = null;
		if ( null != valueObject.getClinicalContact() ) 
		{
			if (valueObject.getClinicalContact().getBoId() == null)
			{
				if (domMap.get(valueObject.getClinicalContact()) != null)
				{
					value5 = (ims.core.admin.domain.objects.ClinicalContact)domMap.get(valueObject.getClinicalContact());
				}
			}
			else if (valueObject.getBoVersion() == -1) // RefVo was not modified since obtained from the Assembler, no need to update the BO field
			{
				value5 = domainObject.getClinicalContact();	
			}
			else
			{
				value5 = (ims.core.admin.domain.objects.ClinicalContact)domainFactory.getDomainObject(ims.core.admin.domain.objects.ClinicalContact.class, valueObject.getClinicalContact().getBoId());
			}
		}
		domainObject.setClinicalContact(value5);

		return domainObject;
	}

}
