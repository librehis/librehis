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

package ims.core.domain;

// Generated from form domain impl
public interface PatientDocumentSearch extends ims.domain.DomainInterface
{
	// Generated from form domain interface definition
	public ims.core.vo.EpisodeofCareShortVoCollection listEpisodesOfCare(ims.core.patient.vo.PatientRefVo patientId);

	// Generated from form domain interface definition
	public ims.core.vo.PatientDocumentSearchListVoCollection listPatientDocuments(ims.core.patient.vo.PatientRefVo patientRef, ims.core.admin.vo.EpisodeOfCareRefVo eoc, ims.core.vo.lookups.Specialty speciality, ims.core.resource.people.vo.MemberOfStaffRefVo creatingMos, ims.framework.utils.Date creatingDateFrom, ims.framework.utils.Date creatingDateTo, ims.core.vo.lookups.DocumentCategory documentType, ims.core.vo.lookups.DocumentStatus documentStatus);

	// Generated from form domain interface definition
	public ims.core.vo.PatientDocumentVo getPatientDocument(ims.core.documents.vo.PatientDocumentRefVo documentID);

	// Generated from form domain interface definition
	public ims.core.vo.PatientDocumentSearchListVo getPatientDocumentSearchListVo(ims.core.documents.vo.PatientDocumentRefVo patientDocumentId);

	// Generated from form domain interface definition
	public ims.core.vo.PatientDocumentVo savePatientDocument(ims.core.vo.PatientDocumentVo document) throws ims.domain.exceptions.StaleObjectException;

	// Generated from form domain interface definition
	public void saveToBeDeteled(ims.core.vo.DocumentsToBeDeletedVo document);

	// Generated from form domain interface definition
	public Boolean isStaleObjectException(ims.core.vo.PatientDocumentVo patientDocument);
}