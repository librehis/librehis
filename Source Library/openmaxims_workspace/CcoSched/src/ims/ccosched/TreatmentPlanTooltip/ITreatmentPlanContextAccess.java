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
package ims.ccosched.TreatmentPlanTooltip;

import ims.dto.client.Go_ptplact;
import ims.dto.client.Go_ptreatpl;
import ims.dto.client.Lkup;

public interface ITreatmentPlanContextAccess
{
	ims.framework.UIEngine getEngine();
	ims.dto.DTODomain getDomain();

	Lkup getAnaesthetic();
	void setAnaesthetic(Lkup value);

	Lkup getTechnique();
	void setTechnique(Lkup value);

	Go_ptreatpl.Go_ptreatplRecord getTreatmentPlanDetails();
	void setTreatmentPlanDetails(Go_ptreatpl.Go_ptreatplRecord value);

	void setTreatmentPlanActions(Go_ptplact value);
}
