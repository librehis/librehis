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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.20 build 40713.1615)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.forms.careplantemplatedetail;

import java.util.ArrayList;

import ims.configuration.gen.ConfigFlag;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.nursing.forms.careplantemplatedetail.GenForm.gridInterventionsRow;
import ims.nursing.vo.CarePlanTemplate;
import ims.nursing.vo.CarePlanTemplateIntervention;
import ims.nursing.vo.CarePlanTemplateInterventionCollection;
import ims.nursing.vo.CarePlanTemplateObjective;
import ims.nursing.vo.CarePlanTemplateObjectiveCollection;
import ims.nursing.vo.CarePlanTemplateTitle;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		form.getContextMenus().getAddUpDownMOVEDOWNItem().setVisible(false);
		form.getContextMenus().getAddUpDownMOVEUPItem().setVisible(false);

		form.chkActiveOnly().setValue(true);
		form.dateCreation().setValue(new Date());

		CarePlanTemplateTitle cpt;
		if ((cpt = form.getGlobalContext().COE.getCarePlanTemplateTitle()) != null)
		{
			// Edit/View
			form.setMode(FormMode.VIEW);

			CarePlanTemplate voCpt = new CarePlanTemplate();
			voCpt = domain.getCarePlanTemplate(cpt);

			// update local context
			form.getLocalContext().setcarePlanTemplate(voCpt);

			displayDetails(form.getLocalContext().getcarePlanTemplate());	//wdev-13375
			
			
		}
		else
		{
			// New
			form.setMode(FormMode.EDIT);
			form.chkActive().setValue(true);
		}
	}
	//wdev-13375
	private void displayDetails(CarePlanTemplate voCpt)
	{
		// Assessment Component
		form.comboBoxComponent().setValue(voCpt != null ? voCpt.getAssessmentComponent():null);

		// Creation Date
		form.dateCreation().setValue(voCpt != null ? voCpt.getCreationDate():null);

		// Active
		form.chkActive().setValue(voCpt != null && voCpt.getActiveIsNotNull() ? voCpt.getActive().booleanValue():null);

		// Title
		form.textBoxTitle().setValue(voCpt != null ? voCpt.getTitle():null);

		// Objective
		CarePlanTemplateObjectiveCollection objectiveValue;
		if ( voCpt != null && (objectiveValue = voCpt.getObjectives()) != null)
		{
			if (objectiveValue.size() > 0)
				form.textBoxObj().setValue(objectiveValue.get(0).getObjective());
		}

		// Interventions
		displayInterventions();
	}

	protected void onImbAddClick()
	{
		newInterventionRow();
	}

	private void newInterventionRow()
	{
		// add an intervention row
		GenForm.gridInterventionsRow row;
		row = form.gridInterventions().getRows().newRow();
		row.setValue(new CarePlanTemplateIntervention());
		row.setColActive(true);
	}

	protected void onBSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		CarePlanTemplate voCpt;

		if (form.getLocalContext().getcarePlanTemplate() == null)
		{
			// new cpt
			voCpt = new CarePlanTemplate();
		}
		else
		{
			// update
			voCpt = form.getLocalContext().getcarePlanTemplate();

		}

		try
		{
			ArrayList<String> screenErrors = new ArrayList<String>();
			// Assessment Component

			voCpt.setAssessmentComponent(form.comboBoxComponent().getValue());

			voCpt.setCreationDate(form.dateCreation().getValue());

			// Status
			voCpt.setActive(new Boolean(form.chkActive().getValue()));

			voCpt.setTitle(form.textBoxTitle().getValue());

			CarePlanTemplateObjectiveCollection objectiveValueColl = new CarePlanTemplateObjectiveCollection();
			if (objectiveValueColl != null)
			{
				if (objectiveValueColl.size() > 0)
				{
					objectiveValueColl.get(0).setObjective(form.textBoxObj().getValue());
				}
				else
				{
					CarePlanTemplateObjective voCpto = new CarePlanTemplateObjective(); // going
																						// in
																						// here
					// voCpto = ObjectiveValueColl.get(0); //wheither its a new
					// or update
					voCpto.setObjective(form.textBoxObj().getValue());
					objectiveValueColl.add(voCpto);
				}
			}
			voCpt.setObjectives(objectiveValueColl);

			// Interventions
			CarePlanTemplateInterventionCollection voCptInterColl = voCpt.getInterventions();
			if(voCptInterColl == null)
				voCptInterColl = new CarePlanTemplateInterventionCollection();
				
			GenForm.gridInterventionsRow row;
			if (form.gridInterventions().getRows().size() == 0 || noActiveInterventions())
			{
				screenErrors.add("At least one active intervention must be entered");
			}

			CarePlanTemplateIntervention voCptInter;
			for (int i = 0; i < form.gridInterventions().getRows().size(); i++)
			{
				row = form.gridInterventions().getRows().get(i);
				
				//WDEV-935 issue 2) - At the moment it is possible to save an intervention with a blank mand/opt combo. 
				if(row.getColManOpt() == null)
				{
					screenErrors.add("Please select the Mandatory/Optional type for the Intervention");
					break;
				}
				if (row.getColIntervention() == "" || row.getColIntervention() == null)
				{
					screenErrors.add("Intervention Name must be entered");
					break;
				}

				Integer setAction = new Integer(ConfigFlag.UI.CAREPLAN_ACTION_TEXT_LENGTH.getValue());
				Integer actualAction = new Integer(row.getColIntervention().length());
				if (actualAction.intValue() > setAction.intValue())
				{
					screenErrors.add("Care Plan Action can be no more than " + ConfigFlag.UI.CAREPLAN_ACTION_TEXT_LENGTH.getValue() + " characters");
					break;

				}

				if (row.getValue() != null)
				{
					voCptInter = row.getValue();
				}
				else
				{
					voCptInter = new CarePlanTemplateIntervention();

				}
				
				voCptInter.setInterventionType(row.getColManOpt());
				voCptInter.setIntervention(row.getColIntervention());
				voCptInter.setActive(new Boolean(row.getColActive()));
				if (!(row.getColActive()))
				{
					voCptInter.setDateInactive(new Date());
				}
				voCptInter.setInterventionNumber(new Integer(i));
				
				voCptInterColl.add(voCptInter);
			}

			voCpt.setInterventions(voCptInterColl);

			String[] arrErrors = voCpt.validate();
			String[] arrScreenAndVoErrors = addScreenErrorsToVOErrors(screenErrors, arrErrors);
			if (arrScreenAndVoErrors.length == 0)
			{
				voCpt = domain.saveCarePlanTemplate(voCpt);

				// if UPDATE is selected before exiting the form after just creating
				// a new care plan
				// then that care plan needs to be put in local content for updates,
				// else it will create a new record
				form.getLocalContext().setcarePlanTemplate(voCpt); // cmurphy
			}
			else{
				
				engine.showErrors("Error", arrScreenAndVoErrors);
				return;
			}

			

		}
		catch (StaleObjectException de)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			onFormOpen();
			return;
		}

		displayInterventions();
		form.setMode(FormMode.VIEW);
		
		form.getContextMenus().hideAllAddUpDownMenuItems();

	}
	
	private boolean noActiveInterventions() {
		gridInterventionsRow row = null;
		for (int i = 0; i < form.gridInterventions().getRows().size(); i++)
		{
			row = form.gridInterventions().getRows().get(i);
			if(row.getColActive())
				return false;
		}
		return true;
	}

	private String[] addScreenErrorsToVOErrors(ArrayList screenErrors, String[] arrErrors)
	{
		String[] arrAllErrors = null;

		if (arrErrors != null)
		{
			arrAllErrors = new String[screenErrors.size() + arrErrors.length];
			for (int i = 0; i < screenErrors.size(); i++)
				arrAllErrors[i] = (String) screenErrors.get(i);

			int i = 0;
			for (int p = screenErrors.size(); p < arrAllErrors.length; p++)
			{
				arrAllErrors[p] = arrErrors[i];
				i++;
			}
		}
		else
		{
			arrAllErrors = new String[screenErrors.size()];

			for (int i = 0; i < screenErrors.size(); i++)
				arrAllErrors[i] = (String) screenErrors.get(i);
		}

		return arrAllErrors;
	}

	protected void onBUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		
		form.gridInterventions().setValue(null);  //wdev-10783
		
	}

	protected void onBCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.getLocalContext().getcarePlanTemplate() == null
				|| form.getLocalContext().getcarePlanTemplate().getID_CarePlanTemplate() == null)
		{
			onBtnExit();
			return;
		}
		
		if (form.getMode().equals(FormMode.EDIT))
		{
			form.gridInterventions().getRows().clear();
			form.textBoxObj().setValue(null);
			form.textBoxTitle().setValue(null);
			form.comboBoxComponent().setValue(null);

			if(form.getGlobalContext().COE.getCarePlanTemplateTitle() != null)  //wdev-13375
				onFormOpen();
			else if(form.getLocalContext().getcarePlanTemplate() != null)		//wdev-13375
				displayDetails(form.getLocalContext().getcarePlanTemplate());
			else
				onFormOpen();
			
		}

		form.setMode(FormMode.VIEW);
	}

	protected void onBtnExit() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.open(form.getForms().Nursing.CarePlanTemplates, "Care Plan Templates");
	}

	private void displayInterventions()
	{
		form.gridInterventions().setValue(null);
		if (form.getLocalContext().getcarePlanTemplate() != null)
		{
			CarePlanTemplateInterventionCollection voCptInterColl;
			if ((voCptInterColl = form.getLocalContext().getcarePlanTemplate().getInterventions()) != null)
			{
				voCptInterColl.sort();
				// clear and add to grid
				form.gridInterventions().getRows().clear();
				GenForm.gridInterventionsRow row;
				for (int i = 0; i < voCptInterColl.size(); i++)
				{
					CarePlanTemplateIntervention voCpInt = voCptInterColl.get(i);

					if (form.chkActiveOnly().getValue() == true)
					{
						// show active interventions only
						if (voCpInt.getActiveIsNotNull() && voCpInt.getActive().booleanValue())
						{
							row = form.gridInterventions().getRows().newRow();
							// Intervention
							row.setValue(voCpInt);
							row.setColManOpt(voCpInt.getInterventionType());
							row.setColIntervention(voCpInt.getIntervention());
							row.setColActive(voCpInt.getActive().booleanValue());
							
						}
					}
					else
					{
						// show all interventions
						row = form.gridInterventions().getRows().newRow();
						// Intervention
						row.setValue(voCpInt);
						row.setColManOpt(voCpInt.getInterventionType());
						row.setColIntervention(voCpInt.getIntervention());
						row.setColActive(voCpInt.getActive().booleanValue());
						row.setDateInactive(voCpInt.getDateInactive());
						
						if (voCpInt.getActive().booleanValue() == false)
							row.setReadOnly(true);
					}
				}
				if (form.getLocalContext().getSelectedIntervention() != null)
					form.gridInterventions().setValue(form.getLocalContext().getSelectedIntervention());
			}
		}
	}

	protected void onGridInterventionsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		/*
		 * CarePlanTemplateIntervention cptInt =
		 * form.gridInterventions().getValue(); if
		 * (cptInt.getActive().booleanValue()) { //
		 * form.bUpdate().setEnabled(false); }
		 */
		if (form.getMode().equals(FormMode.EDIT))
			setUpDownBtns();
	}

	protected void onBDNClick()
	{
		buttonDOWN();
	}

	private void buttonDOWN()
	{
		form.gridInterventions().moveDown();
		setUpDownBtns();
	}

	protected void onBUPClick()
	{
		buttonUP();
	}

	private void buttonUP()
	{
		form.gridInterventions().moveUp();
		setUpDownBtns();
	}

	private void setUpDownBtns()
	{
		form.getContextMenus().getAddUpDownMOVEDOWNItem().setVisible(form.gridInterventions().canMoveCurrentDown());
		form.getContextMenus().getAddUpDownMOVEUPItem().setVisible(form.gridInterventions().canMoveCurrentUp());
	}

	protected void onChkActiveOnlyValueChanged() throws PresentationLogicException
	{
		displayInterventions();
		form.getContextMenus().hideAllAddUpDownMenuItems();
	}

	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		if (sender.equals(form.gridInterventions()))
		{
			switch (menuItemID)
			{
				case GenForm.ContextMenus.AddUpDown.ADD :
					newInterventionRow();
				break;
				case GenForm.ContextMenus.AddUpDown.MOVEDOWN :
					buttonDOWN();
				break;
				case GenForm.ContextMenus.AddUpDown.MOVEUP :
					buttonUP();
				break;
			}
		}

	}

	protected void onFormModeChanged()
	{
		form.getContextMenus().getAddUpDownADDItem().setVisible(form.getMode().equals(FormMode.EDIT));
	}

}
