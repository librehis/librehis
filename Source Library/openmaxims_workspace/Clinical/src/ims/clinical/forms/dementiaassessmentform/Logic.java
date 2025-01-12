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
// This code was generated by Cornel Ventuneac using IMS Development Environment (version 1.80 build 4696.13908)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.dementiaassessmentform;

import ims.clinical.vo.DementiaAssessAndInvestigateVo;
import ims.clinical.vo.DementiaVo;
import ims.clinical.vo.enums.DementiaEventEnumeration;
import ims.clinical.vo.enums.DementiaWorklistOpenFormModeEnum;
import ims.configuration.AppRight;
import ims.configuration.gen.ConfigFlag;
import ims.core.clinical.vo.DementiaRefVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.lookups.DementiaWorklistStatus;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.framework.LayerBridge;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;


	//-------------------------------------------------------------------------------------------------------------------------------------------------------------
	//	Event handlers 
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		// Case 1: - There is a Dementia record passed as a parameter (when form is open as a dialog)
		if (args != null && args.length > 0 && args[0] instanceof DementiaRefVo)
			form.getLocalContext().setselectedDementia(domain.getDementia((DementiaRefVo) args[0]));
		// Case 2: - There are no arguments, so retrieve the Dementia record based on selected Patient record 
		// 				(when form was opened from alert icon or from navigation)
		else
			form.getLocalContext().setselectedDementia(domain.getDementiaForPatient(form.getGlobalContext().Core.getPatientShort()));
		
		// Initialize the form
		initialize();
		
		// Present the form to user
		open(args != null && args.length >= 2 ? (DementiaWorklistOpenFormModeEnum) args[1] : null);
	}

	
	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}
	
	
	@Override
	protected void onlyrStepsTabChanged(LayerBridge tab)
	{
	}


	@Override
	protected void onRecbrAMTSValueChanged() throws PresentationLogicException
	{
		form.getGlobalContext().Clinical.setAMTSRecordToView(form.lyrSteps().tabPageFollowUp().recbrAMTS().getValue());
		form.lyrSteps().tabPageFollowUp().ccAMTSFollowUp().setValue(form.getLocalContext().getselectedDementia(), form.lyrSteps().tabPageFollowUp().recbrAMTS().getValue());
	}

	
	@Override
	protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (engine.isDialog())
			engine.close(DialogResult.ABORT);
	}


	@Override
	protected void onBtnCloseFollowUpClick() throws PresentationLogicException
	{
		if (engine.isDialog())
			engine.close(DialogResult.ABORT);
	}
	

	@Override
	protected void onCcStep1FindValueChanged() throws PresentationLogicException
	{
		if (DementiaEventEnumeration.SAVE.equals(form.lyrSteps().tabPageStep1().ccStep1Find().getSelectedEvent()))
		{
			// Reset event for component
			form.lyrSteps().tabPageStep1().ccStep1Find().resetSelectedEvent();
			
			// Update Dementia record in context
			form.getLocalContext().setselectedDementia(form.lyrSteps().tabPageStep1().ccStep1Find().getValue());
			DementiaVo dementia = form.getLocalContext().getselectedDementia();
			
			// If Dementia record requires a STEP 2 ASSESSMENT and one is not recorded, present screen to user to record STEP 2 ASSESSMENT
			if ((dementia.getCurrentWorklistStatus() != null
					&& DementiaWorklistStatus.STEP_TWO_ASSESS_INVESTIGATE_OUTSTANDING.equals(dementia.getCurrentWorklistStatus().getStatus()))
					|| dementia.getStepTwoAssess() != null)
			{
				open(DementiaWorklistOpenFormModeEnum.STEP2_AMTS_EDIT);
			}
			else
			{
				if (engine.isDialog())
					engine.close(DialogResult.CANCEL);
				else
					open(DementiaWorklistOpenFormModeEnum.VIEW);
			}
		}
		else if (DementiaEventEnumeration.CLOSE.equals(form.lyrSteps().tabPageStep1().ccStep1Find().getSelectedEvent()))
		{
			form.lyrSteps().tabPageStep1().ccStep1Find().resetSelectedEvent();
			
			if (engine.isDialog())
				engine.close(DialogResult.CANCEL);
			else
				open(DementiaWorklistOpenFormModeEnum.VIEW);
		}
		else if (DementiaEventEnumeration.NEW.equals(form.lyrSteps().tabPageStep1().ccStep1Find().getSelectedEvent()))
		{
			form.lyrSteps().tabPageStep1().ccStep1Find().resetSelectedEvent();
			
			open(DementiaWorklistOpenFormModeEnum.STEP1EDIT);
		}
		else if (DementiaEventEnumeration.MARK_RIE.equals(form.lyrSteps().tabPageStep1().ccStep1Find().getSelectedEvent()))
		{
			form.lyrSteps().tabPageStep1().ccStep1Find().resetSelectedEvent();
			doRIE();
		}
		//SOE
		else if (DementiaEventEnumeration.CANCEL.equals(form.lyrSteps().tabPageStep1().ccStep1Find().getSelectedEvent()) 
			|| DementiaEventEnumeration.SOE.equals(form.lyrSteps().tabPageStep1().ccStep1Find().getSelectedEvent()))
		{
			form.lyrSteps().tabPageStep1().ccStep1Find().resetSelectedEvent();
			open(DementiaWorklistOpenFormModeEnum.VIEW);
		}
	}
	

	@Override
	protected void onCcAMTSValueChanged() throws PresentationLogicException
	{
		if (DementiaEventEnumeration.SAVE.equals(form.lyrSteps().tabPageStep2().ccAMTS().getSelectedEvent()) 
			|| DementiaEventEnumeration.CANCEL.equals(form.lyrSteps().tabPageStep2().ccAMTS().getSelectedEvent()))
		{
			// Reset event for component
			form.lyrSteps().tabPageStep2().ccAMTS().resetSelectedEvent();

			// Refresh dementia record
			form.getLocalContext().setselectedDementia(form.lyrSteps().tabPageStep2().ccAMTS().getValue());

			// Determine if STEP 2 was recorded for Dementia record
			boolean stepTwoVisible = form.getLocalContext().getselectedDementia().getStepTwoAssess() != null
										&& form.getLocalContext().getselectedDementia().getCurrentWorklistStatus() != null
										&& DementiaWorklistStatus.STEP_TWO_ASSESS_INVESTIGATE_OUTSTANDING.equals(form.getLocalContext().getselectedDementia().getCurrentWorklistStatus().getStatus());

			// If there was a STEP 2 recorded for Dementia record
			open(stepTwoVisible ? DementiaWorklistOpenFormModeEnum.STEP2_AMTS_VIEW : DementiaWorklistOpenFormModeEnum.VIEW);
		}
		else if (DementiaEventEnumeration.EDIT.equals(form.lyrSteps().tabPageStep2().ccAMTS().getSelectedEvent()))
		{
			// Reset event for component
			form.lyrSteps().tabPageStep2().ccAMTS().resetSelectedEvent();
			
			// Set form to edit STEP 2
			open(DementiaWorklistOpenFormModeEnum.STEP2_AMTS_EDIT);
		}
		else if (DementiaEventEnumeration.CLOSE.equals(form.lyrSteps().tabPageStep2().ccAMTS().getSelectedEvent()))
		{
			// Reset event for component
			form.lyrSteps().tabPageStep2().ccAMTS().resetSelectedEvent();
			
			if (engine.isDialog())
				engine.close(DialogResult.CANCEL);
			else
				open(DementiaWorklistOpenFormModeEnum.VIEW);
		}
		else if (DementiaEventEnumeration.SOE.equals(form.lyrSteps().tabPageStep2().ccAMTS().getSelectedEvent()))
		{
			// Reset event for component
			form.lyrSteps().tabPageStep2().ccAMTS().resetSelectedEvent();
			// Refresh the form
			open(DementiaWorklistOpenFormModeEnum.VIEW);
		}
		else if (DementiaEventEnumeration.MARK_RIE.equals(form.lyrSteps().tabPageStep2().ccAMTS().getSelectedEvent()))
		{
			// Reset event for component
			form.lyrSteps().tabPageStep2().ccAMTS().resetSelectedEvent();
			doRIE();
		}
	}

	
	@Override
	protected void onCcAMTSFollowUpValueChanged() throws PresentationLogicException
	{
		if (DementiaEventEnumeration.RELOAD_AMTS_BROWSER.equals(form.lyrSteps().tabPageFollowUp().ccAMTSFollowUp().getSelectedEvent()))
		{
			// Reset event for component
			form.lyrSteps().tabPageFollowUp().ccAMTSFollowUp().resetSelectedEvent();
			// Refresh Dementia record value
			form.getLocalContext().setselectedDementia(domain.getDementia(form.getLocalContext().getselectedDementia()));

			open(DementiaWorklistOpenFormModeEnum.FOLLOWUP_AMTS_VIEW);
		}
		else if (DementiaEventEnumeration.NEW.equals(form.lyrSteps().tabPageFollowUp().ccAMTSFollowUp().getSelectedEvent()))
		{
			// Reset event for component
			form.lyrSteps().tabPageFollowUp().ccAMTSFollowUp().resetSelectedEvent();
			
			open(DementiaWorklistOpenFormModeEnum.FOLLOWUP_AMTS_NEW);
		}
		else if (DementiaEventEnumeration.EDIT.equals(form.lyrSteps().tabPageFollowUp().ccAMTSFollowUp().getSelectedEvent()))
		{
			// Reset event for component
			form.lyrSteps().tabPageFollowUp().ccAMTSFollowUp().resetSelectedEvent();
			
			open(DementiaWorklistOpenFormModeEnum.FOLLOWUP_AMTS_EDIT);
		}
		else if (DementiaEventEnumeration.SOE.equals(form.lyrSteps().tabPageFollowUp().ccAMTSFollowUp().getSelectedEvent()) )
		{
			// Reset event for component
			form.lyrSteps().tabPageFollowUp().ccAMTSFollowUp().resetSelectedEvent();
			
			open(DementiaWorklistOpenFormModeEnum.FOLLOWUP_AMTS_VIEW);
		}
	}



	//-------------------------------------------------------------------------------------------------------------------------------------------------------------
	//	Form presentation functions 
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------

	
	private void initialize()
	{
		// Initialize the components
		form.lyrSteps().tabPageStep1().ccStep1Find().initialize(engine.isDialog());
		form.lyrSteps().tabPageStep2().ccAMTS().initialize(Boolean.FALSE);
		form.lyrSteps().tabPageFollowUp().ccAMTSFollowUp().initialize(Boolean.TRUE);
	}
	

	/**
	 *	Present form to user
	 * 	@param openMode 
	 * 				- Based on parameter value passed set the form to take appropriate action. Default action will show user all controls,
	 * 				but will not allow user to take any action
	 *	<li>DementiaWorklistOpenFormModeEnum.VIEW</li>
	 *	<li>DementiaWorklistOpenFormModeEnum.STEP1VIEW</li>
	 *	<li>DementiaWorklistOpenFormModeEnum.STEP1EDIT</li>
	 *	<li>DementiaWorklistOpenFormModeEnum.STEP2_AMTS_VIEW</li>
	 *	<li>DementiaWorklistOpenFormModeEnum.STEP2_AMTS_EDIT</li>
	 *	<li>DementiaWorklistOpenFormModeEnum.STEP2_NOTE_VIEW</li>
	 *	<li>DementiaWorklistOpenFormModeEnum.STEP2_NOTE_EDIT</li>
	 *	<li>DementiaWorklistOpenFormModeEnum.FOLLOWUP_AMTS_VIEW</li>
	 *	<li>DementiaWorklistOpenFormModeEnum.FOLLOWUP_AMTS_EDIT</li>
	 *	<li>DementiaWorklistOpenFormModeEnum.EDIT</li>
	 */
	private void open(DementiaWorklistOpenFormModeEnum openMode)
	{
		form.getLocalContext().setselectedDementia(domain.getDementia(form.getLocalContext().getselectedDementia()));
		
		// If form was opened as a dialog and there is no dementia record - close it down
		if (engine.isDialog() && form.getLocalContext().getselectedDementia() == null)
		{
			engine.close(DialogResult.ABORT);
			return;
		}

		populateScreenFromData(form.getLocalContext().getselectedDementia());
		
		// Based on openMode parameter set the form to appropriate view
		// Prepare the form to take appropriate action (default action will show all controls but will not allow user to take any action)
		if (openMode == null || DementiaWorklistOpenFormModeEnum.VIEW.equals(openMode) || DementiaWorklistOpenFormModeEnum.STEP1VIEW.equals(openMode))
		{
			form.lyrSteps().showtabPageStep1();
			form.lyrSteps().tabPageStep1().ccStep1Find().setMode(FormMode.VIEW);
			form.lyrSteps().tabPageStep2().ccAMTS().setMode(FormMode.VIEW);
			form.lyrSteps().tabPageFollowUp().ccAMTSFollowUp().setMode(FormMode.VIEW);
			form.setMode(FormMode.VIEW);
		}
		else if (DementiaWorklistOpenFormModeEnum.STEP1EDIT.equals(openMode))
		{
			form.lyrSteps().showtabPageStep1();
			form.lyrSteps().tabPageStep1().ccStep1Find().setMode(FormMode.EDIT);
			form.setMode(FormMode.EDIT);
		}
		else if (DementiaWorklistOpenFormModeEnum.STEP2_AMTS_VIEW.equals(openMode) || DementiaWorklistOpenFormModeEnum.STEP2_NOTE_VIEW.equals(openMode))
		{
			form.lyrSteps().showtabPageStep2();
			form.lyrSteps().tabPageStep1().ccStep1Find().setMode(FormMode.VIEW);
			form.lyrSteps().tabPageStep2().ccAMTS().setMode(FormMode.VIEW);
			form.lyrSteps().tabPageFollowUp().ccAMTSFollowUp().setMode(FormMode.VIEW);
			form.setMode(FormMode.VIEW);
		}
		else if (DementiaWorklistOpenFormModeEnum.STEP2_AMTS_EDIT.equals(openMode) || DementiaWorklistOpenFormModeEnum.STEP2_NOTE_EDIT.equals(openMode))
		{
			form.lyrSteps().showtabPageStep2();
			form.lyrSteps().tabPageStep2().ccAMTS().setMode(FormMode.EDIT);
			form.setMode(FormMode.EDIT);
		}
		else if (DementiaWorklistOpenFormModeEnum.FOLLOWUP_AMTS_VIEW.equals(openMode))
		{
			form.lyrSteps().showtabPageFollowUp();
			form.lyrSteps().tabPageStep1().ccStep1Find().setMode(FormMode.VIEW);
			form.lyrSteps().tabPageStep2().ccAMTS().setMode(FormMode.VIEW);
			form.lyrSteps().tabPageFollowUp().ccAMTSFollowUp().setMode(FormMode.VIEW);
			form.setMode(FormMode.VIEW);
		}
		else if (DementiaWorklistOpenFormModeEnum.FOLLOWUP_AMTS_EDIT.equals(openMode) || DementiaWorklistOpenFormModeEnum.FOLLOWUP_AMTS_NEW.equals(openMode))
		{
			if (DementiaWorklistOpenFormModeEnum.FOLLOWUP_AMTS_NEW.equals(openMode))
				form.lyrSteps().tabPageFollowUp().ccAMTSFollowUp().setValue(form.getLocalContext().getselectedDementia(), null);
			
			form.lyrSteps().showtabPageFollowUp();
			form.lyrSteps().tabPageFollowUp().ccAMTSFollowUp().setMode(FormMode.EDIT);
			form.setMode(FormMode.EDIT);
		}
		else if (DementiaWorklistOpenFormModeEnum.EDIT.equals(openMode))
		{
			// Get HCP user
			HcpLiteVo hcpUser = (HcpLiteVo) domain.getHcpLiteUser();
			
			DementiaVo dementia = form.getLocalContext().getselectedDementia();
			if (dementia != null && dementia.getStepOneFind() != null && dementia.getStepTwoAssess() == null
					&& ((dementia.getStepOneFind().getAuthoringInformation().getAuthoringHcp() != null && dementia.getStepOneFind().getAuthoringInformation().getAuthoringHcp().equals(hcpUser))
						|| engine.hasRight(AppRight.CAN_EDIT_AND_RIE_DEMENTIA)))
			{
				form.lyrSteps().showtabPageStep1();
				form.lyrSteps().tabPageStep1().ccStep1Find().setMode(FormMode.EDIT);
				form.setMode(FormMode.EDIT);
			}
			else if (dementia != null && dementia.getStepOneFind() != null && dementia.getStepTwoAssess() != null
					&& ((dementia.getStepTwoAssess().getAuthoringInformation().getAuthoringHcp() != null && dementia.getStepTwoAssess().getAuthoringInformation().getAuthoringHcp().equals(hcpUser))
						|| engine.hasRight(AppRight.CAN_EDIT_AND_RIE_DEMENTIA)))
			{
				form.lyrSteps().showtabPageStep2();
				form.lyrSteps().tabPageStep2().ccAMTS().setMode(FormMode.EDIT);
				form.setMode(FormMode.EDIT);
			}
			else if (dementia != null && dementia.getStepOneFind() != null && dementia.getStepTwoAssess() != null
					&& dementia.getStepTwoAssess().getAuthoringInformation().getAuthoringHcp() != null && !dementia.getStepTwoAssess().getAuthoringInformation().getAuthoringHcp().equals(hcpUser)
					&& dementia.getStepOneFind().getAuthoringInformation().getAuthoringHcp() != null && dementia.getStepOneFind().getAuthoringInformation().getAuthoringHcp().equals(hcpUser))
			{
				form.lyrSteps().showtabPageStep1();
				form.lyrSteps().tabPageStep1().ccStep1Find().setMode(FormMode.EDIT);
				form.setMode(FormMode.EDIT);
			}
		}
	}


	private void updateControlsState()
	{
		// Set tab page header state
		if (form.getLocalContext().getselectedDementia() != null)	// Keep condition like this
		{															// For no Dementia record we want to present the user with all controls disabled
			form.lyrSteps().tabPageStep2().setHeaderVisible(form.getLocalContext().getselectedDementia().getStepOneFind() != null);
			form.lyrSteps().tabPageFollowUp().setHeaderVisible(form.getLocalContext().getselectedDementia().getStepTwoAssess() != null);
		}
		
		form.lyrSteps().tabPageStep1().setHeaderEnabled(FormMode.VIEW.equals(form.getMode()) || form.lyrSteps().tabPageStep1().isVisible());
		form.lyrSteps().tabPageStep2().setHeaderEnabled(FormMode.VIEW.equals(form.getMode()) || form.lyrSteps().tabPageStep2().isVisible());
		form.lyrSteps().tabPageFollowUp().setHeaderEnabled(FormMode.VIEW.equals(form.getMode()) || form.lyrSteps().tabPageFollowUp().isVisible());
		
		// Close button on tab page Step 2
		form.lyrSteps().tabPageStep2().btnClose().setVisible(FormMode.VIEW.equals(form.getMode()) && engine.isDialog());
		form.lyrSteps().tabPageStep2().btnClose().setEnabled(FormMode.VIEW.equals(form.getMode()));
		
		// Close button on tab page Follow Up
		form.lyrSteps().tabPageFollowUp().btnCloseFollowUp().setVisible(FormMode.VIEW.equals(form.getMode()) && engine.isDialog());
		form.lyrSteps().tabPageFollowUp().btnCloseFollowUp().setEnabled(FormMode.VIEW.equals(form.getMode()));
	}


	private void doRIE()
	{
		try
		{
			form.getLocalContext().setselectedDementia(domain.rieAMTSRecord(form.getLocalContext().getselectedDementia(), form.getForms().Clinical.DementiaAssessmentFormDialog, 
					form.getLocalContext().getselectedDementia().getPatient().getID_Patient(), 
					null, 
					null,
					form.getGlobalContext().Core.getRieMessage()) );
		}
		catch (DomainInterfaceException e) 
		{
			engine.showMessage(e.getMessage());
			populateScreenFromData(form.getLocalContext().getselectedDementia());
			return;
		} 
		catch (StaleObjectException e)
		{
			engine.showErrors(new String[]{ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue()});
			form.getLocalContext().setselectedDementia(domain.getDementia(form.getLocalContext().getselectedDementia()));
			populateScreenFromData(form.getLocalContext().getselectedDementia());
			return;
		}
		catch (UnqViolationUncheckedException e)
		{
			engine.showErrors(new String[]{ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue()});
			form.getLocalContext().setselectedDementia(domain.getDementia(form.getLocalContext().getselectedDementia()));
			populateScreenFromData(form.getLocalContext().getselectedDementia());
			return;
		}

		//Refresh Dialog
		open(DementiaWorklistOpenFormModeEnum.VIEW);
	}

	
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------
	//	Form data exchange functions
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------

	
	private void clearScreen()
	{
		// Clear components
		
		// Clear record browser
		form.lyrSteps().tabPageFollowUp().recbrAMTS().clear();
	}

	
	private void populateScreenFromData(DementiaVo dementia)
	{
		// Clear the screen
		clearScreen();
		
		if (dementia == null)
			return;
		
		form.lyrSteps().tabPageStep1().ccStep1Find().setValue(dementia);
		form.lyrSteps().tabPageStep2().ccAMTS().setValue(dementia, dementia.getStepTwoAssess());
		
		// On the follow up tab select the latest record
		if (dementia.getFollowUpAssessments() != null && dementia.getFollowUpAssessments().size() > 0)
		{
			// Populate record browser
			form.lyrSteps().tabPageFollowUp().recbrAMTS().clear();
			dementia.getFollowUpAssessments().sort(SortOrder.DESCENDING);
			
			for (DementiaAssessAndInvestigateVo assessment : dementia.getFollowUpAssessments())
			{
				form.lyrSteps().tabPageFollowUp().recbrAMTS().newRow(assessment, assessment.getRecordBrowserText());
			}
			
			// Set the record browser value
			if (form.getGlobalContext().Clinical.getAMTSRecordToView() != null)
			{
				form.lyrSteps().tabPageFollowUp().recbrAMTS().setValue(form.getGlobalContext().Clinical.getAMTSRecordToView());
				form.getGlobalContext().Clinical.setAMTSRecordToView(form.lyrSteps().tabPageFollowUp().recbrAMTS().getValue());
			}
			else if (form.lyrSteps().tabPageFollowUp().recbrAMTS().getValues() != null && form.lyrSteps().tabPageFollowUp().recbrAMTS().getValues().size() > 0)
			{
				form.lyrSteps().tabPageFollowUp().recbrAMTS().setValue((DementiaAssessAndInvestigateVo) form.lyrSteps().tabPageFollowUp().recbrAMTS().getValues().get(0));
				form.getGlobalContext().Clinical.setAMTSRecordToView(form.lyrSteps().tabPageFollowUp().recbrAMTS().getValue());
			}

			// Set value for Follow up component
			form.lyrSteps().tabPageFollowUp().ccAMTSFollowUp().setValue(dementia, form.lyrSteps().tabPageFollowUp().recbrAMTS().getValue());
		}
		else
		{
			form.lyrSteps().tabPageFollowUp().ccAMTSFollowUp().setValue(dementia, null);
		}
	}
}
