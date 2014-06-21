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
// This code was generated by Vasile Purdila using IMS Development Environment (version 1.39 build 2153.19769)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.diagnosisprocedureproblemsearch;

import ims.clinical.vo.ClinicalProblemShortVo;
import ims.clinical.vo.ClinicalProblemShortVoCollection;
import ims.core.forms.diagnosisprocedureproblemsearch.GenForm.grdItemsRow;
import ims.core.forms.diagnosisprocedureproblemsearch.GenForm.grdSelectedItemsRow;
import ims.core.vo.DiagLiteVo;
import ims.core.vo.DiagLiteVoCollection;
import ims.core.vo.ProcedureLiteVo;
import ims.core.vo.ProcedureLiteVoCollection;
import ims.core.vo.VaccineLiteVo;
import ims.core.vo.VaccineLiteVoCollection;
import ims.domain.exceptions.DomainInterfaceException;
import ims.framework.Control;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		if(form.getGlobalContext().Clinical.getPMHConfigSearchTypeIsNotNull() && form.getGlobalContext().Clinical.getPMHConfigSearchType().equalsIgnoreCase("P"))
		{
			form.grdItems().setcolItemsCaption("Procedures");
			form.grdSelectedItems().setcolItemsCaption("Selected Procedures");
		}
		else if(form.getGlobalContext().Clinical.getPMHConfigSearchTypeIsNotNull() && form.getGlobalContext().Clinical.getPMHConfigSearchType().equalsIgnoreCase("D"))
		{
			form.grdItems().setcolItemsCaption("Diagnosis");
			form.grdSelectedItems().setcolItemsCaption("Selected Diagnosis");
		}
		else if(form.getGlobalContext().Clinical.getPMHConfigSearchTypeIsNotNull() && form.getGlobalContext().Clinical.getPMHConfigSearchType().equalsIgnoreCase("PR"))
		{
			form.grdItems().setcolItemsCaption("Problem");
			form.grdSelectedItems().setcolItemsCaption("Selected Problem");
		}
		else if(form.getGlobalContext().Clinical.getPMHConfigSearchTypeIsNotNull() && form.getGlobalContext().Clinical.getPMHConfigSearchType().equalsIgnoreCase("VACCINE"))
		{
			form.grdItems().setcolItemsCaption("Vaccines");
			form.grdSelectedItems().setcolItemsCaption("Selected Vaccines");
			engine.setCaption("Vaccine");
			
			if(form.getGlobalContext().Clinical.CCISearch.getSelectedVaccinesIsNotNull())
			{
				VaccineLiteVoCollection coll = form.getGlobalContext().Clinical.CCISearch.getSelectedVaccines();
				
				displaySelectedVaccines(coll);
			}
		}
		
		form.txtSearch().setFocus();
		form.grdItems().setEnabled(true);
		form.grdItems().setReadOnly(false);
		updateControlsState();
	}
	
	private void displaySelectedVaccines(VaccineLiteVoCollection coll) 
	{
		if(coll == null)
			return;
		
		form.grdSelectedItems().getRows().clear();
		for (int i = 0; i < coll.size(); i++)
		{
			if(coll.get(i) != null)
			{
				grdSelectedItemsRow selRow = form.grdSelectedItems().getRows().newRow();
				selRow.setcolItems(coll.get(i).getVaccineName());
				selRow.setValue(coll.get(i));
			}
		}
	}
	
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	protected void onBtnOKClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(form.grdSelectedItems().getRows().size() == 0)
		{
			engine.showMessage("No items were selected.");
			return;
		}
		
		ProcedureLiteVoCollection procColl = new ProcedureLiteVoCollection();
		DiagLiteVoCollection diagColl = new DiagLiteVoCollection();
		ClinicalProblemShortVoCollection probColl = new ClinicalProblemShortVoCollection();
		VaccineLiteVoCollection vaccColl = new VaccineLiteVoCollection();
		
		for (int j = 0; j < form.grdSelectedItems().getRows().size(); j++)
		{
			grdSelectedItemsRow selRow = form.grdSelectedItems().getRows().get(j);

			if(selRow.getValue() instanceof ProcedureLiteVo)
				procColl.add((ProcedureLiteVo)selRow.getValue());
			else if(selRow.getValue() instanceof DiagLiteVo)
				diagColl.add((DiagLiteVo)selRow.getValue());
			else if(selRow.getValue() instanceof ClinicalProblemShortVo)
				probColl.add((ClinicalProblemShortVo)selRow.getValue());
			else if(selRow.getValue() instanceof VaccineLiteVo)
				vaccColl.add((VaccineLiteVo) selRow.getValue());
		}
		
		if(form.getGlobalContext().Clinical.getPMHConfigSearchTypeIsNotNull() && form.getGlobalContext().Clinical.getPMHConfigSearchType().equalsIgnoreCase("P"))
			form.getGlobalContext().Clinical.setSelectedProcedures(procColl);
		else if(form.getGlobalContext().Clinical.getPMHConfigSearchTypeIsNotNull() && form.getGlobalContext().Clinical.getPMHConfigSearchType().equalsIgnoreCase("D"))
			form.getGlobalContext().Clinical.setSelectedDiagnosis(diagColl);
		else if(form.getGlobalContext().Clinical.getPMHConfigSearchTypeIsNotNull() && form.getGlobalContext().Clinical.getPMHConfigSearchType().equalsIgnoreCase("PR"))
			form.getGlobalContext().Clinical.setSelectedProblems(probColl);
		else if(form.getGlobalContext().Clinical.getPMHConfigSearchTypeIsNotNull() && form.getGlobalContext().Clinical.getPMHConfigSearchType().equalsIgnoreCase("VACCINE"))
			form.getGlobalContext().Clinical.CCISearch.setSelectedVaccines(vaccColl);
		
		engine.close(DialogResult.OK);
	}
	
	protected void onBtnAddClick() throws ims.framework.exceptions.PresentationLogicException
	{
		for(int i = 0; i < form.grdItems().getRows().size(); i++)
		{
			grdItemsRow row = form.grdItems().getRows().get(i);
			
			if(row.getColumnSelect() == false)
				continue;
			
			boolean bFound = false;
			for (int j = 0; j < form.grdSelectedItems().getRows().size(); j++)
			{
				grdSelectedItemsRow selRow = form.grdSelectedItems().getRows().get(j);
				
				if(row.getValue().equals(selRow.getValue()))
				{
					bFound = true;
					break;
				}
			}
			
			if(bFound == false)
			{
				grdSelectedItemsRow selRow = form.grdSelectedItems().getRows().newRow();
				
				selRow.setValue(row.getValue());
				
				if(row.getValue() instanceof ProcedureLiteVo)
				{
					selRow.setcolItems(((ProcedureLiteVo)row.getValue()).getProcedureName());
				}
				else if(row.getValue() instanceof DiagLiteVo)
				{
					selRow.setcolItems(((DiagLiteVo)row.getValue()).getDiagnosisName());
				}
				else if(row.getValue() instanceof ClinicalProblemShortVo)
				{
					selRow.setcolItems(((ClinicalProblemShortVo)row.getValue()).getPCName());
				}
				else if(row.getValue() instanceof VaccineLiteVo)
				{
					selRow.setcolItems(((VaccineLiteVo)row.getValue()).getVaccineName());
				}
			}
		}
		updateControlsState();
	}
	
	protected void onBtnSelectAllClick() throws ims.framework.exceptions.PresentationLogicException
	{
		for(int i = 0; i < form.grdItems().getRows().size(); i++)
		{
			grdItemsRow row = form.grdItems().getRows().get(i);
			
			row.setColumnSelect(true);
		}
	}
	
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.grdItems().getRows().clear();

		if(form.getGlobalContext().Clinical.getPMHConfigSearchTypeIsNotNull() && form.getGlobalContext().Clinical.getPMHConfigSearchType().equalsIgnoreCase("P"))
		{
			ProcedureLiteVoCollection coll;
			try 
			{
				coll = domain.listProcedures(form.txtSearch().getValue());
			}
			catch (DomainInterfaceException e) 
			{
				engine.showMessage(e.getMessage());
				return;
			}
			
			if(coll == null || coll.size() == 0)
			{
				engine.showMessage("No procedures found !");
				return;
			}			
			displayProcedureCollection(coll);
		}
		else if(form.getGlobalContext().Clinical.getPMHConfigSearchTypeIsNotNull() && form.getGlobalContext().Clinical.getPMHConfigSearchType().equalsIgnoreCase("D"))
		{	
			DiagLiteVoCollection coll;
			try 
			{
				coll = domain.listDiagnosis(form.txtSearch().getValue());
			} 
			catch (DomainInterfaceException e) 
			{
				engine.showMessage(e.getMessage());
				return;
			}

			if(coll == null || coll.size() == 0)
			{
				engine.showMessage("No diagnosis found !");
				return;
			}
			
			displayDiagnosisCollection(coll);
		}
		else if(form.getGlobalContext().Clinical.getPMHConfigSearchTypeIsNotNull() && form.getGlobalContext().Clinical.getPMHConfigSearchType().equalsIgnoreCase("PR"))
		{
			ClinicalProblemShortVoCollection coll;
			try 
			{
				coll = domain.listProblems(form.txtSearch().getValue());
			} 
			catch (DomainInterfaceException e) 
			{
				engine.showMessage(e.getMessage());
				return;
			}

			if(coll == null || coll.size() == 0)
			{
				engine.showMessage("No Problems found !");
				return;
			}
			
			ClinicalProblemShortVoCollection filteredColl = filterExistingProblems(coll);
			displayProblemCollection(filteredColl);
		}
		else if(form.getGlobalContext().Clinical.getPMHConfigSearchTypeIsNotNull() && form.getGlobalContext().Clinical.getPMHConfigSearchType().equalsIgnoreCase("VACCINE"))
		{
			VaccineLiteVoCollection coll;
			
			try 
			{
				coll = domain.listVaccine(form.txtSearch().getValue());
			}
			catch (DomainInterfaceException e) 
			{
				engine.showMessage(e.getMessage());
				return;
			}

			if(coll == null || coll.size() == 0)
			{
				engine.showMessage("No Vaccines found.");
				return;
			}
			
			VaccineLiteVoCollection newColl = filterExistingVaccines(coll);
			displayVaccinesCollection(newColl);
		}
	}
	
	private void displayVaccinesCollection(VaccineLiteVoCollection coll) 
	{
		for(int i = 0; i < coll.size(); i++)
		{
			grdItemsRow row = form.grdItems().getRows().newRow();
			
			row.setValue(coll.get(i));
			row.setcolItems(coll.get(i).getVaccineName());
			row.setColumnSelect(false);
		}
	}
	
	private VaccineLiteVoCollection filterExistingVaccines(VaccineLiteVoCollection coll) 
	{
		VaccineLiteVoCollection newVaccinesColl = new VaccineLiteVoCollection();
		
		if(form.grdSelectedItems().getRows().size() == 0)
			return coll;
		
		coll.sort(SortOrder.ASCENDING);
		for(int j=0; j<coll.size(); j++)
		{
			boolean vaccineFound = false;
			for(int i=0; i<form.grdSelectedItems().getRows().size(); i++)
			{
				if(coll.get(j).equals((VaccineLiteVo) form.grdSelectedItems().getRows().get(i).getValue()))
				{
					vaccineFound = true;
					break;
				}
			}
			if(!vaccineFound)
			{
				newVaccinesColl.add(coll.get(j));
			}
		}
		return newVaccinesColl;
	}
	
	private ClinicalProblemShortVoCollection filterExistingProblems(ClinicalProblemShortVoCollection coll)
	{
		
		
		ClinicalProblemShortVoCollection existingColl  = form.getGlobalContext().Clinical.getSelectedProblems(); 
	
		if(existingColl == null || (existingColl != null && existingColl.size() == 0))
			return coll;
		ClinicalProblemShortVoCollection newProblemColl = new ClinicalProblemShortVoCollection();
		existingColl.sort(SortOrder.ASCENDING);
		coll.sort(SortOrder.ASCENDING);
		
		
		
			for (int i = 0; i < coll.size() ; i++)
			{
				if(existingColl.contains(coll.get(i))== false)
				{
					newProblemColl.add(coll.get(i));
				}
			}
		
			//form.getGlobalContext().Clinical.setSelectedProblems(null);
		return newProblemColl;
	}
	
	private void displayDiagnosisCollection(DiagLiteVoCollection coll)
	{
		for(int i = 0; i < coll.size(); i++)
		{
			grdItemsRow row = form.grdItems().getRows().newRow();
			
			row.setValue(coll.get(i));
			row.setcolItems(coll.get(i).getDiagnosisName());
			row.setColumnSelect(false);
		}
	}
	
	private void displayProblemCollection(ClinicalProblemShortVoCollection coll)
	{
		for(int i = 0; i < coll.size(); i++)
		{
			grdItemsRow row = form.grdItems().getRows().newRow();
			
			row.setValue(coll.get(i));
			row.setcolItems(coll.get(i).getPCName());
			row.setColumnSelect(false);
		}
	}
	
	private void displayProcedureCollection(ProcedureLiteVoCollection coll)
	{
		for(int i = 0; i < coll.size(); i++)
		{
			grdItemsRow row = form.grdItems().getRows().newRow();
			
			row.setValue(coll.get(i));
			row.setcolItems(coll.get(i).getProcedureName());
			row.setColumnSelect(false);
		}
		
	}
	
	protected void onBtnClearClick() throws PresentationLogicException
	{
		for(int i = 0; i < form.grdItems().getRows().size(); i++)
		{
			grdItemsRow row = form.grdItems().getRows().get(i);
			
			row.setColumnSelect(false);
		}
	}

	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.CoreNamespace.VaccineRemove.REMOVE:
				removeFromSelectedItems();
				break;
			case GenForm.ContextMenus.CoreNamespace.VaccineRemove.REMOVEALL:
				removeAllFromSelectedItems();
				break;
		}
		updateControlsState();
	}

	private void updateControlsState() 
	{
		form.getContextMenus().Core.getVaccineRemoveREMOVEItem().setVisible(form.grdSelectedItems().getSelectedRow() != null);
		form.getContextMenus().Core.getVaccineRemoveREMOVEALLItem().setVisible(form.grdSelectedItems().getRows().size() > 0);
	}

	private void removeAllFromSelectedItems() 
	{
		form.grdSelectedItems().getRows().clear();
	}

	private void removeFromSelectedItems() 
	{
		if(form.grdSelectedItems().getSelectedRow() != null)
		{
			form.grdSelectedItems().getRows().remove(form.grdSelectedItems().getSelectedRowIndex());
		}
	}

	@Override
	protected void onGrdSelectedItemsSelectionChanged() throws PresentationLogicException 
	{
		updateControlsState();
	}
}