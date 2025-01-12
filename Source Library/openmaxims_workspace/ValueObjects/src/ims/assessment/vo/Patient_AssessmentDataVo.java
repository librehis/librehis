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

package ims.assessment.vo;

/**
 * Linked to Assessment.Instantiation.PatientAssessmentData business object (ID: 1003100050).
 */
public class Patient_AssessmentDataVo extends ims.assessment.instantiation.vo.PatientAssessmentDataRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public Patient_AssessmentDataVo()
	{
	}
	public Patient_AssessmentDataVo(Integer id, int version)
	{
		super(id, version);
	}
	public Patient_AssessmentDataVo(ims.assessment.vo.beans.Patient_AssessmentDataVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.userassessment = bean.getUserAssessment() == null ? null : bean.getUserAssessment().buildVo();
		this.answergroups = ims.assessment.vo.Patient_AssessmentGroupVoCollection.buildFromBeanCollection(bean.getAnswerGroups());
		this.graphicfindings = ims.assessment.vo.Patient_GraphicAssessmentVoCollection.buildFromBeanCollection(bean.getGraphicFindings());
		this.graphicquestion = ims.assessment.vo.Patient_GraphicAssessmentQuestionAnswerVoCollection.buildFromBeanCollection(bean.getGraphicQuestion());
		this.graphic = bean.getGraphic() == null ? null : bean.getGraphic().buildVo();
		this.groupquestionwidth = bean.getGroupQuestionWidth();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.beans.Patient_AssessmentDataVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.userassessment = bean.getUserAssessment() == null ? null : bean.getUserAssessment().buildVo(map);
		this.answergroups = ims.assessment.vo.Patient_AssessmentGroupVoCollection.buildFromBeanCollection(bean.getAnswerGroups());
		this.graphicfindings = ims.assessment.vo.Patient_GraphicAssessmentVoCollection.buildFromBeanCollection(bean.getGraphicFindings());
		this.graphicquestion = ims.assessment.vo.Patient_GraphicAssessmentQuestionAnswerVoCollection.buildFromBeanCollection(bean.getGraphicQuestion());
		this.graphic = bean.getGraphic() == null ? null : bean.getGraphic().buildVo(map);
		this.groupquestionwidth = bean.getGroupQuestionWidth();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.beans.Patient_AssessmentDataVoBean bean = null;
		if(map != null)
			bean = (ims.assessment.vo.beans.Patient_AssessmentDataVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.assessment.vo.beans.Patient_AssessmentDataVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("USERASSESSMENT"))
			return getUserAssessment();
		if(fieldName.equals("ANSWERGROUPS"))
			return getAnswerGroups();
		if(fieldName.equals("GRAPHICFINDINGS"))
			return getGraphicFindings();
		if(fieldName.equals("GRAPHICQUESTION"))
			return getGraphicQuestion();
		if(fieldName.equals("GRAPHIC"))
			return getGraphic();
		if(fieldName.equals("GROUPQUESTIONWIDTH"))
			return getGroupQuestionWidth();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getUserAssessmentIsNotNull()
	{
		return this.userassessment != null;
	}
	public ims.assessment.vo.User_AssessmentVo getUserAssessment()
	{
		return this.userassessment;
	}
	public void setUserAssessment(ims.assessment.vo.User_AssessmentVo value)
	{
		this.isValidated = false;
		this.userassessment = value;
	}
	public boolean getAnswerGroupsIsNotNull()
	{
		return this.answergroups != null;
	}
	public ims.assessment.vo.Patient_AssessmentGroupVoCollection getAnswerGroups()
	{
		return this.answergroups;
	}
	public void setAnswerGroups(ims.assessment.vo.Patient_AssessmentGroupVoCollection value)
	{
		this.isValidated = false;
		this.answergroups = value;
	}
	public boolean getGraphicFindingsIsNotNull()
	{
		return this.graphicfindings != null;
	}
	public ims.assessment.vo.Patient_GraphicAssessmentVoCollection getGraphicFindings()
	{
		return this.graphicfindings;
	}
	public void setGraphicFindings(ims.assessment.vo.Patient_GraphicAssessmentVoCollection value)
	{
		this.isValidated = false;
		this.graphicfindings = value;
	}
	public boolean getGraphicQuestionIsNotNull()
	{
		return this.graphicquestion != null;
	}
	public ims.assessment.vo.Patient_GraphicAssessmentQuestionAnswerVoCollection getGraphicQuestion()
	{
		return this.graphicquestion;
	}
	public void setGraphicQuestion(ims.assessment.vo.Patient_GraphicAssessmentQuestionAnswerVoCollection value)
	{
		this.isValidated = false;
		this.graphicquestion = value;
	}
	public boolean getGraphicIsNotNull()
	{
		return this.graphic != null;
	}
	public ims.assessment.vo.Graphic_AssessmentVo getGraphic()
	{
		return this.graphic;
	}
	public void setGraphic(ims.assessment.vo.Graphic_AssessmentVo value)
	{
		this.isValidated = false;
		this.graphic = value;
	}
	public boolean getGroupQuestionWidthIsNotNull()
	{
		return this.groupquestionwidth != null;
	}
	public Integer getGroupQuestionWidth()
	{
		return this.groupquestionwidth;
	}
	public void setGroupQuestionWidth(Integer value)
	{
		this.isValidated = false;
		this.groupquestionwidth = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.answergroups != null)
		{
			if(!this.answergroups.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.graphicfindings != null)
		{
			if(!this.graphicfindings.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.graphicquestion != null)
		{
			if(!this.graphicquestion.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.answergroups != null)
		{
			String[] listOfOtherErrors = this.answergroups.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.graphicfindings != null)
		{
			String[] listOfOtherErrors = this.graphicfindings.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.graphicquestion != null)
		{
			String[] listOfOtherErrors = this.graphicquestion.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		Patient_AssessmentDataVo clone = new Patient_AssessmentDataVo(this.id, this.version);
		
		if(this.userassessment == null)
			clone.userassessment = null;
		else
			clone.userassessment = (ims.assessment.vo.User_AssessmentVo)this.userassessment.clone();
		if(this.answergroups == null)
			clone.answergroups = null;
		else
			clone.answergroups = (ims.assessment.vo.Patient_AssessmentGroupVoCollection)this.answergroups.clone();
		if(this.graphicfindings == null)
			clone.graphicfindings = null;
		else
			clone.graphicfindings = (ims.assessment.vo.Patient_GraphicAssessmentVoCollection)this.graphicfindings.clone();
		if(this.graphicquestion == null)
			clone.graphicquestion = null;
		else
			clone.graphicquestion = (ims.assessment.vo.Patient_GraphicAssessmentQuestionAnswerVoCollection)this.graphicquestion.clone();
		if(this.graphic == null)
			clone.graphic = null;
		else
			clone.graphic = (ims.assessment.vo.Graphic_AssessmentVo)this.graphic.clone();
		clone.groupquestionwidth = this.groupquestionwidth;
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(Patient_AssessmentDataVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A Patient_AssessmentDataVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((Patient_AssessmentDataVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((Patient_AssessmentDataVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.userassessment != null)
			count++;
		if(this.answergroups != null)
			count++;
		if(this.graphicfindings != null)
			count++;
		if(this.graphicquestion != null)
			count++;
		if(this.graphic != null)
			count++;
		if(this.groupquestionwidth != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.assessment.vo.User_AssessmentVo userassessment;
	protected ims.assessment.vo.Patient_AssessmentGroupVoCollection answergroups;
	protected ims.assessment.vo.Patient_GraphicAssessmentVoCollection graphicfindings;
	protected ims.assessment.vo.Patient_GraphicAssessmentQuestionAnswerVoCollection graphicquestion;
	protected ims.assessment.vo.Graphic_AssessmentVo graphic;
	protected Integer groupquestionwidth;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
