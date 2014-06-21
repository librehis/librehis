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
// This code was generated by Marius Mihalec using IMS Development Environment (version 1.62 build 3111.36466)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.bedspacelayoutlist;

import ims.core.vo.FloorBedSpaceLayoutLiteVo;
import ims.core.vo.FloorBedSpaceLayoutLiteVoCollection;
import ims.core.vo.enums.BedLayoutAction;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	@Override
	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		if(formName.equals(form.getForms().Core.BayBedSpaceLayoutDesigner) && result.equals(DialogResult.OK))
		{
			open();
		}
	}
	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();		
	}
	@Override
	protected void onGrdDetailsSelectionChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		updateControlsState();
	}
	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
	}
	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		updateInstance();
	}
	@Override
	protected void onContextMenuItemClick(int menuItemID, ims.framework.Control sender) throws ims.framework.exceptions.PresentationLogicException
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add:
				newInstance();
				break;
			case GenForm.ContextMenus.GenericGrid.Update:
				updateInstance();
				break;
			case GenForm.ContextMenus.GenericGrid.View:
				viewInstance();
				break;
			case GenForm.ContextMenus.GenericGrid.Confirm:
				cloneInstance();
				break;
		}
	}
	private void cloneInstance() 
	{
		form.getGlobalContext().Core.BedFloorLayout.setReadOnly(false);
		form.getGlobalContext().Core.BedFloorLayout.setSelection(form.grdDetails().getValue());
		form.getGlobalContext().Core.setBedLayoutAction(BedLayoutAction.CLONE);
		engine.open(form.getForms().Core.BayBedSpaceLayoutDesigner);		
	}
	public void clearInstanceControls() 
	{
		form.grdDetails().getRows().clear();
	}
	public void newInstance() throws PresentationLogicException 
	{
		form.getGlobalContext().Core.BedFloorLayout.setReadOnly(false);
		form.getGlobalContext().Core.BedFloorLayout.setSelection(null);
		engine.open(form.getForms().Core.BayBedSpaceLayoutDesigner);
	}
	public boolean save() throws PresentationLogicException 
	{
		return false;
	}
	public void updateControlsState() 
	{
		if(form.getMode().equals(FormMode.VIEW))
		{
			form.btnEdit().setVisible(form.grdDetails().getValue() != null);
			form.getContextMenus().getGenericGridUpdateItem().setVisible(form.grdDetails().getValue() != null);
			form.getContextMenus().getGenericGridViewItem().setVisible(form.grdDetails().getValue() != null);
			form.getContextMenus().getGenericGridConfirmItem().setVisible(form.grdDetails().getValue() != null);
		}
		else
		{
			form.btnEdit().setVisible(false);
			form.getContextMenus().getGenericGridUpdateItem().setVisible(false);
			form.getContextMenus().getGenericGridViewItem().setVisible(false);
			form.getContextMenus().getGenericGridConfirmItem().setVisible(false);
		}
	}
	public void updateInstance() 
	{
		viewOrUpdateInstance(false);
	}
	public void viewInstance() 
	{
		viewOrUpdateInstance(true);
	}
	private void viewOrUpdateInstance(boolean readOnly)
	{
		form.getGlobalContext().Core.BedFloorLayout.setReadOnly(readOnly);
		form.getGlobalContext().Core.BedFloorLayout.setSelection(form.grdDetails().getValue());
		if (readOnly)
			form.getGlobalContext().Core.setBedLayoutAction(BedLayoutAction.VIEW);
		else
			form.getGlobalContext().Core.setBedLayoutAction(BedLayoutAction.EDIT);
		engine.open(form.getForms().Core.BayBedSpaceLayoutDesigner);
	}
	public void initialize()
	{		
		form.getContextMenus().getGenericGridAddItem().setVisible(true);
		form.getContextMenus().getGenericGridConfirmItem().setText("Clone");
		form.chkTemplatesOnly().setValue(true);
	}
	public void open() throws PresentationLogicException 
	{
		clearInstanceControls();
		
		FloorBedSpaceLayoutLiteVoCollection list = domain.list(form.chkTemplatesOnly().getValue(), form.cmbStatus().getValue());
		
		if(list != null && list.size() > 0)
		{
			for(int x = 0; x < list.size(); x++)
			{
				add(list.get(x));
			}
		}
		else
		{
			engine.showMessage("No records found."); //WDEV-15335
		}
		
		updateControlsState();
	}
	private void add(FloorBedSpaceLayoutLiteVo value) 
	{
		if(value == null)
			return;
			
		ims.core.forms.bedspacelayoutlist.GenForm.grdDetailsRow row = form.grdDetails().getRows().newRow(value.equals(form.getGlobalContext().Core.BedFloorLayout.getSelection()));
		
		row.setcolName(value.getName());
		row.setcolStatus(value.getStatus());
		row.setcolTemplate(value.getIsTemplate());
		
		row.setValue(value);
	}
	
	@Override
	protected void onImbClearClick() throws PresentationLogicException
	{
		form.cmbStatus().setValue(null);
		form.chkTemplatesOnly().setValue(false);
		clearInstanceControls();
		updateControlsState();
	}
	
	@Override
	protected void onImbSearchClick() throws PresentationLogicException
	{
		open();
	}
}