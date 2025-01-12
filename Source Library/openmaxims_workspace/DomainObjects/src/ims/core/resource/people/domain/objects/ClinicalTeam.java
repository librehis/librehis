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
 * Generated: 12/10/2015, 13:28
 *
 */
package ims.core.resource.people.domain.objects;

/**
 * 
 * @author John MacEnri
 * Generated.
 */


public class ClinicalTeam extends ims.domain.DomainObject implements ims.domain.SystemInformationRetainer, java.io.Serializable {
	public static final int CLASSID = 1006100003;
	private static final long serialVersionUID = 1006100003L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	/** Clinical Team Name */
	private String teamName;
	/** Clinical Team - Type */
	private ims.domain.lookups.LookupInstance teamType;
	/** Member Collection
	  * Collection of ims.core.resource.people.domain.objects.ClinicalTeamMember.
	  */
	private java.util.Set members;
	/** Lead HCP */
	private ims.core.resource.people.domain.objects.Hcp leadHCP;
	/** Active Flag */
	private Boolean isActive;
	/** SystemInformation */
	private ims.domain.SystemInformation systemInformation = new ims.domain.SystemInformation();
    public ClinicalTeam (Integer id, int ver)
    {
    	super(id, ver);
    }
    public ClinicalTeam ()
    {
    	super();
    }
    public ClinicalTeam (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.core.resource.people.domain.objects.ClinicalTeam.class;
	}


	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		if ( null != teamName && teamName.length() > 50 ) {
			throw new ims.domain.exceptions.DomainRuntimeException("MaxLength ($MaxLength) exceeded for teamName. Tried to set value: "+
				teamName);
		}
		this.teamName = teamName;
	}

	public ims.domain.lookups.LookupInstance getTeamType() {
		return teamType;
	}
	public void setTeamType(ims.domain.lookups.LookupInstance teamType) {
		this.teamType = teamType;
	}

	public java.util.Set getMembers() {
		if ( null == members ) {
			members = new java.util.HashSet();
		}
		return members;
	}
	public void setMembers(java.util.Set paramValue) {
		this.members = paramValue;
	}

	public ims.core.resource.people.domain.objects.Hcp getLeadHCP() {
		return leadHCP;
	}
	public void setLeadHCP(ims.core.resource.people.domain.objects.Hcp leadHCP) {
		this.leadHCP = leadHCP;
	}

	public Boolean isIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public ims.domain.SystemInformation getSystemInformation() {
		if (systemInformation == null) systemInformation = new ims.domain.SystemInformation();
		return systemInformation;
	}


	/**
	 * isConfigurationObject
	 * Taken from the Usage property of the business object, this method will return
	 * a boolean indicating whether this is a configuration object or not
	 * Configuration = true, Instantiation = false
	 */
	public static boolean isConfigurationObject()
	{
		if ( "Instantiation".equals("Configuration") )
			return true;
		else
			return false;
	}





	public int getClassId() {
		return CLASSID;
	}

	public String getClassVersion()
	{
		return CLASSVERSION;
	}

	public String toAuditString()
	{
		StringBuffer auditStr = new StringBuffer();
		
		auditStr.append("\r\n*teamName* :");
		auditStr.append(teamName);
	    auditStr.append("; ");
		auditStr.append("\r\n*teamType* :");
		if (teamType != null)
			auditStr.append(teamType.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*members* :");
		if (members != null)
		{
			java.util.Iterator it3 = members.iterator();
			int i3=0;
			while (it3.hasNext())
			{
				if (i3 > 0)
					auditStr.append(",");
				ims.core.resource.people.domain.objects.ClinicalTeamMember obj = (ims.core.resource.people.domain.objects.ClinicalTeamMember)it3.next();
		if (obj != null)
		{
		   if (i3 == 0)
		   {
			auditStr.append(toShortClassName(obj));
			auditStr.append("[");
		   }
		
		   auditStr.append(obj.getId());
		}
			i3++;
		}
		if (i3 > 0)
			auditStr.append("] " + i3);
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*leadHCP* :");
		if (leadHCP != null)
		{
			auditStr.append(toShortClassName(leadHCP));
				
		    auditStr.append(leadHCP.getId());
		}
	    auditStr.append("; ");
		auditStr.append("\r\n*isActive* :");
		auditStr.append(isActive);
	    auditStr.append("; ");
		return auditStr.toString();
	}
	
	public String toXMLString()
	{
		return toXMLString(new java.util.HashMap());
	}
	
	public String toXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<class type=\"" + this.getClass().getName() + "\" ");		
		sb.append(" id=\"" + this.getId() + "\""); 
		sb.append(" source=\"" + ims.configuration.EnvironmentConfig.getImportExportSourceName() + "\" ");
		sb.append(" classVersion=\"" + this.getClassVersion() + "\" ");
		sb.append(" component=\"" + this.getIsComponentClass() + "\" >");
		
		if (domMap.get(this) == null)
		{
			domMap.put(this, this);
			sb.append(this.fieldsToXMLString(domMap));
		}
		sb.append("</class>");
		
		String keyClassName = "ClinicalTeam";
		String externalSource = ims.configuration.EnvironmentConfig.getImportExportSourceName();
		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + this.getId());
		if (impObj == null)
		{
    		impObj = new ims.configuration.ImportedObject();
    		impObj.setExternalId(this.getId());
    		impObj.setExternalSource(externalSource);
    		impObj.setDomainObject(this);
			impObj.setLocalId(this.getId()); 
    		impObj.setClassName(keyClassName); 
			domMap.put(keyClassName + "_" + externalSource + "_" + this.getId(), impObj);
		}
		
		return sb.toString();
	}

	public String fieldsToXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		if (this.getTeamName() != null)
		{
			sb.append("<teamName>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.getTeamName().toString()));
			sb.append("</teamName>");		
		}
		if (this.getTeamType() != null)
		{
			sb.append("<teamType>");
			sb.append(this.getTeamType().toXMLString()); 
			sb.append("</teamType>");		
		}
		if (this.getMembers() != null)
		{
			if (this.getMembers().size() > 0 )
			{
			sb.append("<members>");
			sb.append(ims.domain.DomainObject.toXMLString(this.getMembers(), domMap));
			sb.append("</members>");		
			}
		}
		if (this.getLeadHCP() != null)
		{
			sb.append("<leadHCP>");
			sb.append(this.getLeadHCP().toXMLString(domMap)); 	
			sb.append("</leadHCP>");		
		}
		if (this.isIsActive() != null)
		{
			sb.append("<isActive>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.isIsActive().toString()));
			sb.append("</isActive>");		
		}
		return sb.toString();
	}
		
	public static java.util.List fromListXMLString(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.List list, java.util.HashMap domMap) throws Exception
	{
		if (list == null)
		 list = new java.util.ArrayList();
		fillListFromXMLString(list, el, factory, domMap);
		return list;
	}
	
	public static java.util.Set fromSetXMLString(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.Set set, java.util.HashMap domMap) throws Exception
	{
		if (set == null)
			 set = new java.util.HashSet();
		fillSetFromXMLString(set, el, factory, domMap);
		return set;
	}
	
	private static void fillSetFromXMLString(java.util.Set set, org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return;
		
		java.util.List cl = el.elements("class");
		int size = cl.size();
		
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			org.dom4j.Element itemEl = (org.dom4j.Element)cl.get(i);
			ClinicalTeam domainObject = getClinicalTeamfromXML(itemEl, factory, domMap);

			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!set.contains(domainObject)) 
				set.add(domainObject);
			newSet.add(domainObject);			
		}
		
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = set.iterator();
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
			set.remove(iter.next());
		}		
	}
	
	private static void fillListFromXMLString(java.util.List list, org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return;
		
		java.util.List cl = el.elements("class");
		int size = cl.size();
		
		for(int i=0; i<size; i++) 
		{
			org.dom4j.Element itemEl = (org.dom4j.Element)cl.get(i);
			ClinicalTeam domainObject = getClinicalTeamfromXML(itemEl, factory, domMap);

			if (domainObject == null)
			{
				continue;
			}

			int domIdx = list.indexOf(domainObject);
			if (domIdx == -1)
			{
				list.add(i, domainObject);
			}
			else if (i != domIdx && i < list.size())
			{
				Object tmp = list.get(i);
				list.set(i, list.get(domIdx));
				list.set(domIdx, tmp);
			}
		}		
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=list.size();
		while (i1 > size)
		{
			list.remove(i1-1);
			i1=list.size();
		}
	}
		
	public static ClinicalTeam getClinicalTeamfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getClinicalTeamfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static ClinicalTeam getClinicalTeamfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!ClinicalTeam.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!ClinicalTeam.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the ClinicalTeam class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (ClinicalTeam)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(ClinicalTeam.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		ClinicalTeam ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (ClinicalTeam)factory.getImportedDomainObject(ClinicalTeam.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new ClinicalTeam();
		}
		String keyClassName = "ClinicalTeam";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (ClinicalTeam)impObj.getDomainObject();
		}
		else
		{
    		impObj = new ims.configuration.ImportedObject();
    		impObj.setExternalId(extId);
    		impObj.setExternalSource(externalSource);
    		impObj.setDomainObject(ret);
			domMap.put(keyClassName + "_" + externalSource + "_" + extId, impObj);
		}
		fillFieldsfromXML(el, factory, ret, domMap);
		return ret;
	}

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, ClinicalTeam obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("teamName");
		if(fldEl != null)
		{	
    		obj.setTeamName(new String(fldEl.getTextTrim()));	
		}
		fldEl = el.element("teamType");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setTeamType(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("members");
		if(fldEl != null)
		{
			fldEl = fldEl.element("set");	
			obj.setMembers(ims.core.resource.people.domain.objects.ClinicalTeamMember.fromSetXMLString(fldEl, factory, obj.getMembers(), domMap));
		}
		fldEl = el.element("leadHCP");
		if(fldEl != null)
		{
			fldEl = fldEl.element("class");		
			obj.setLeadHCP(ims.core.resource.people.domain.objects.Hcp.getHcpfromXML(fldEl, factory, domMap)); 
		}
		fldEl = el.element("isActive");
		if(fldEl != null)
		{	
    		obj.setIsActive(new Boolean(fldEl.getTextTrim()));	
		}
	}

	public static String[] getCollectionFields()
	{
		return new String[]{
		 "members"
		};
	}


	public static class FieldNames	
	{
	public static final String ID = "id";
		public static final String TeamName = "teamName";
		public static final String TeamType = "teamType";
		public static final String Members = "members";
		public static final String LeadHCP = "leadHCP";
		public static final String IsActive = "isActive";
	}
}

