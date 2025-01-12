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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.30 build 2012.21169)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.scheduling.domain.impl;

import ims.RefMan.domain.objects.CatsReferral;
import ims.RefMan.domain.objects.PatientElectiveList;
import ims.RefMan.domain.objects.TCIForPatientElectiveList;
import ims.RefMan.vo.CatsReferralForClinicListVo;
import ims.RefMan.vo.PatientElectiveListForDNAAppointmentsVo;
import ims.RefMan.vo.TCIForPatientElectiveListAppointmentDNAVo;
import ims.RefMan.vo.domain.CatsReferralForClinicListVoAssembler;
import ims.RefMan.vo.domain.PatientElectiveListForDNAAppointmentsVoAssembler;
import ims.RefMan.vo.domain.TCIForPatientElectiveListAppointmentDNAVoAssembler;
import ims.chooseandbook.vo.lookups.ActionRequestType;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.domain.objects.CareSpell;
import ims.core.helper.IClinicListDNAAppt;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.people.domain.objects.MemberOfStaff;
import ims.core.vo.ActivityVo;
import ims.core.vo.CareSpellVo;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.PatientShort;
import ims.core.vo.ServiceFunctionVoCollection;
import ims.core.vo.ServiceShortVo;
import ims.core.vo.domain.CareSpellVoAssembler;
import ims.core.vo.domain.MemberOfStaffLiteVoAssembler;
import ims.core.vo.domain.PatientListVoAssembler;
import ims.core.vo.lookups.ContextType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainException;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.impl.DomainImpl;
import ims.domain.lookups.LookupInstance;
import ims.domain.lookups.LookupMapping;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;
import ims.framework.utils.DateTime;
import ims.framework.utils.Image;
import ims.framework.utils.ImagePath;
import ims.framework.utils.Time;
import ims.pathways.configuration.domain.objects.Event;
import ims.pathways.configuration.domain.objects.RTTStatusPoint;
import ims.pathways.configuration.vo.EventRefVo;
import ims.pathways.domain.HL7PathwayIf;
import ims.pathways.domain.impl.HL7PathwayIfImpl;
import ims.pathways.domain.objects.PathwayClock;
import ims.pathways.domain.objects.PathwayRTTStatus;
import ims.pathways.domain.objects.PatientEvent;
import ims.pathways.domain.objects.PatientJourneyTarget;
import ims.pathways.domain.objects.PatientPathwayJourney;
import ims.pathways.domain.objects.RTTStatusEventMap;
import ims.pathways.vo.PatientEventVo;
import ims.pathways.vo.PatientJourneyTargetRefVo;
import ims.pathways.vo.PatientJourneyTargetVo;
import ims.pathways.vo.PatientJourneyVo;
import ims.pathways.vo.RTTStatusEventMapVo;
import ims.pathways.vo.domain.PatientJourneyTargetVoAssembler;
import ims.pathways.vo.domain.PatientJourneyVoAssembler;
import ims.pathways.vo.domain.RTTStatusEventMapVoAssembler;
import ims.pathways.vo.lookups.EventStatus;
import ims.scheduling.domain.DirectoryOfServiceAdmin;
import ims.scheduling.domain.Profiles;
import ims.scheduling.domain.SessionAdmin;
import ims.scheduling.domain.objects.Booking_Appointment;
import ims.scheduling.domain.objects.DirectoryOfServiceSessionSlot;
import ims.scheduling.domain.objects.Sch_Session;
import ims.scheduling.domain.objects.Session_Slot;
import ims.scheduling.helper.CABRequests;
import ims.scheduling.vo.BookingAppointmentOutcomeVo;
import ims.scheduling.vo.Booking_AppointmentRefVo;
import ims.scheduling.vo.Booking_AppointmentVo;
import ims.scheduling.vo.DirectoryOfServiceVo;
import ims.scheduling.vo.ProfileShortVo;
import ims.scheduling.vo.ProfileShortVoCollection;
import ims.scheduling.vo.Sch_BookingVoCollection;
import ims.scheduling.vo.Sch_SessionRefVo;
import ims.scheduling.vo.SessionShortVo;
import ims.scheduling.vo.SessionShortVoCollection;
import ims.scheduling.vo.SessionSlotVo;
import ims.scheduling.vo.SessionSlotVoCollection;
import ims.scheduling.vo.Session_SlotRefVo;
import ims.scheduling.vo.domain.Booking_AppointmentVoAssembler;
import ims.scheduling.vo.domain.Sch_BookingVoAssembler;
import ims.scheduling.vo.domain.SessionShortVoAssembler;
import ims.scheduling.vo.domain.SessionSlotVoAssembler;
import ims.scheduling.vo.lookups.LookupHelper;
import ims.scheduling.vo.lookups.ProfileListType;
import ims.scheduling.vo.lookups.Status_Reason;
import ims.vo.LookupInstVo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ClinicListImpl extends DomainImpl implements ims.scheduling.domain.ClinicList, ims.domain.impl.Transactional, IClinicListDNAAppt
{
	private static final long serialVersionUID = 1L;
	
	private static final int PATIENT_DNA_NAT_CODE = 33;

	public SessionShortVoCollection listSession(ServiceShortVo service, ServiceFunctionVoCollection functionColl, ProfileShortVo profile, Date sessionDate, ProfileListType listtype)	//wdev-19419 
	{
		DomainFactory factory = getDomainFactory();
		SessionShortVoCollection voCollSessionShort = new SessionShortVoCollection();
			
		List sessions;
		if(service != null)
		{
			sessions = factory.find(" from Sch_Session session where session.sessionDate = :sessionDate and " +
										" session.service.id = :serviceId",
										new String[]{"sessionDate","serviceId"},
										new Object[]{sessionDate.getDate(), service.getID_Service()});
		}
		else
		{
			if( listtype == null )
			{
				sessions = factory.find(" from Sch_Session session where session.sessionDate = :sessionDate and " +
									" session.sch_Profile.id = :profileId",
									new String[]{"sessionDate","profileId"},
									new Object[]{sessionDate.getDate(), profile.getID_Sch_Profile()});
			}
			else
			{
				sessions = factory.find(" from Sch_Session session where session.sessionDate = :sessionDate and " +
						" session.sch_Profile.id = :profileId and session.listType.id = :idListType",
						new String[]{"sessionDate","profileId","idListType"},
						new Object[]{sessionDate.getDate(), profile.getID_Sch_Profile(),getDomLookup(listtype).getId()});
			}
		}
		
		voCollSessionShort = SessionShortVoAssembler.createSessionShortVoCollectionFromSch_Session(sessions);
					
		return voCollSessionShort;	
	}

	public ims.core.vo.ServiceShortVoCollection listService(ims.core.vo.ServiceShortVo serviceShort)
	{
		DirectoryOfServiceAdmin impl = (DirectoryOfServiceAdmin) getDomainImpl(DirectoryOfServiceAdminImpl.class);
		return impl.listService(serviceShort);
	}

	public ims.core.vo.ServiceFunctionVoCollection listServiceFunctions(ims.core.vo.ServiceShortVo serviceShort)
	{
		DirectoryOfServiceAdmin impl = (DirectoryOfServiceAdmin) getDomainImpl(DirectoryOfServiceAdminImpl.class);
		return impl.listServiceFunctions(serviceShort);
	}

	/**
	 * Note: only one parameter can be filled 
	 */
	public SessionSlotVoCollection listSessionSlots(SessionShortVo session, Integer[] sessionIds) 
	{
		if(session != null && sessionIds != null)
			throw new CodingRuntimeException("parameters are mutually exclusive in method listSessionSlots");
		
		DomainFactory factory = getDomainFactory();

		SessionSlotVoCollection voCollSessionSlots = new SessionSlotVoCollection();
		if(session != null)
		{
			Sch_Session doSession = (Sch_Session) factory.getDomainObject(Sch_Session.class, session.getID_Sch_Session());
			voCollSessionSlots = SessionSlotVoAssembler.createSessionSlotVoCollectionFromSession_Slot(doSession.getSessionSlots()).sort();
		}
		else if(sessionIds != null)
		{
			SessionSlotVoCollection voCollSessionSlot = new SessionSlotVoCollection();
			for(int i=0;i<sessionIds.length;i++)
			{
				Sch_Session doSession = (Sch_Session) factory.getDomainObject(Sch_Session.class, sessionIds[i]);
				voCollSessionSlot = SessionSlotVoAssembler.createSessionSlotVoCollectionFromSession_Slot(doSession.getSessionSlots()).sort();
				for(int p=0;p<voCollSessionSlot.size();p++)
				{
					voCollSessionSlots.add(voCollSessionSlot.get(p));
				}
			}
		}
		return voCollSessionSlots;
	}

	public PatientShort getBookingPatient(Booking_AppointmentVo appointment) 
	{
		DomainFactory factory = getDomainFactory();
		List bookings =  factory.find("select booking from Sch_Booking booking join booking.appointments as appt where appt.id = :apptId",new String[]{"apptId"},new Object[]{appointment.getID_Booking_Appointment()});
		if(bookings != null && bookings.size() > 0)
			return Sch_BookingVoAssembler.createSch_BookingVoCollectionFromSch_Booking(bookings).get(0).getPatient();
		return null;
	}

	
	public ProfileShortVoCollection listProfiles(ServiceShortVo service, DirectoryOfServiceVo directoryOfService, Boolean activeOnly) 
	{
		Profiles impl = (Profiles) getDomainImpl(ProfilesImpl.class);
		return impl.listProfiles(service, directoryOfService, null, activeOnly, true, false, null, null,false);//WDEV-12952 exclude theatre's	(param 5 true & param 6 false)  //wdev-20074	
	}

	//WDEV-12568 //WDEV-18325
	public void dnaAppt(Booking_AppointmentVo appt,	CatsReferralForClinicListVo catsReferral,ActionRequestType requestType,	PatientElectiveListForDNAAppointmentsVo electiveList, Boolean isFirstAppointmentActivity) throws StaleObjectException, DomainInterfaceException
	{
		if(appt == null)
			throw new DomainRuntimeException("Invalid Booking to save");
		
		if(!appt.isValidated())
			throw new DomainRuntimeException("Booking Record not validated before save");
		
		if(catsReferral != null && !catsReferral.isValidated())
			throw new DomainRuntimeException("Referral Record not validated before save");
		
		DomainFactory factory = getDomainFactory();
		
		Booking_Appointment doAppt = Booking_AppointmentVoAssembler.extractBooking_Appointment(factory, appt);
		
		//pathways  WDEV-5021
		updateJourney(doAppt, false);
		
		try
		{
			if (electiveList != null)
			{
				@SuppressWarnings("rawtypes")
				HashMap domMap = new HashMap();
				TCIForPatientElectiveListAppointmentDNAVo currentTCI = electiveList.getTCIDetails();
				TCIForPatientElectiveList domTCIToSave = TCIForPatientElectiveListAppointmentDNAVoAssembler.extractTCIForPatientElectiveList(factory, currentTCI, domMap);
				electiveList.setTCIDetails(null);
				PatientElectiveList domPatientElectiveList = PatientElectiveListForDNAAppointmentsVoAssembler.extractPatientElectiveList(factory, electiveList, domMap);

				factory.save(domPatientElectiveList);
				factory.save(domTCIToSave);
			}

			factory.save(doAppt);
		}
		
		catch (DomainException e)
		{
			throw new DomainRuntimeException("Domain Error occured in dnaAppt " + e.getMessage(), e);
		}
		
		// WDEV-23646 - Ensure the correct event Date Time is used when creating a new RTT Status
		// When an appointment is DNA - use the Appointment Outcome Date/Time, or if not available - use the Appointment Date + Current Time
		java.util.Date eventDateTime = null;
		
		if (appt != null && appt.getOutcomeDateTime() != null)
		{
			eventDateTime = appt.getOutcomeDateTime().getJavaDate();
		}
		else
		{
			eventDateTime = new DateTime(appt.getAppointmentDate(), appt.getApptStartTime()).getJavaDate();
		}
		//WDEV-18524
		CatsReferral doCats = updateCatsReferral(factory, catsReferral, isFirstAppointmentActivity, eventDateTime);
			
		try
		{
			factory.save(doCats);
		}
		catch(StaleObjectException e)
		{
			doCats = updateCatsReferral(factory, catsReferral, isFirstAppointmentActivity, eventDateTime);
			factory.save(doCats);
		}
		
		//WDEV-18524
		if (doCats != null && isFirstAppointmentActivity && Boolean.TRUE.equals(doCats.isRTTClockImpact()) && doCats.getJourney() != null && doCats.getJourney().getCurrentClock() != null)
		{	
			DateTime apptDateTime = null;
			Status_Reason status_Reason = null;
			if(doAppt!=null )
			{
				status_Reason =(doAppt.getApptStatus()!= null ? LookupHelper.getStatus_ReasonInstance(getLookupService(), doAppt.getApptStatus().getId()):null);
				apptDateTime = new DateTime(new Date( doAppt.getAppointmentDate()),new Time(doAppt.getApptStartTime()));
			}
			instantiatePatientEvent(doCats,apptDateTime,status_Reason);
		}

		if(ConfigFlag.GEN.ICAB_ENABLED.getValue())
		{
			if(doAppt.isIsCABBooking() != null && doAppt.isIsCABBooking().booleanValue())
				sendRequestandUpdateReferences(factory, requestType, doAppt, "Appt DNA Requested from ClinicList");
		}
	}
	
	// WDEV-23646 - Ensure the correct event Date Time is used when creating a new RTT Status
	private CatsReferral updateCatsReferral(DomainFactory factory, CatsReferralForClinicListVo catsReferralVo, Boolean isFirstAppointmentActivity, java.util.Date eventDateTime)
	{
		//WDEV-18524
		CatsReferral doCats = (CatsReferral) factory.getDomainObject(CatsReferral.class, catsReferralVo.getID_CatsReferral());
		doCats.setConsultationActivityRequired(catsReferralVo.getConsultationActivityRequired());//WDEV-20748
		
		//WDEV-18325
		PathwayRTTStatus rttSTatusDO = null;
		
		if(doCats != null)
		{				
			if (isFirstAppointmentActivity && Boolean.TRUE.equals(doCats.isRTTClockImpact()))
			{
				PatientPathwayJourney journeyDO = doCats.getJourney();

				int dnaNatCode = PATIENT_DNA_NAT_CODE;

				rttSTatusDO = createPatientRTTStatus(dnaNatCode, eventDateTime);

				if  (journeyDO != null)
				{
					if (journeyDO.getCurrentClock() != null)
					{
						PathwayClock ptwClockDO = journeyDO.getCurrentClock();

						ptwClockDO.setCurrentRTTStatus(rttSTatusDO);

						List<PathwayRTTStatus> ptwClockHistory = ptwClockDO.getRTTStatusHistory();

						if (ptwClockHistory == null)
						{
							ptwClockHistory = new java.util.ArrayList();
						}
						ptwClockHistory.add(rttSTatusDO);
					}
				}
				doCats.setCurrentRTTStatus(rttSTatusDO);
			}
		}
		
		return doCats;
	}

	// WDEV-23646 - Ensure the correct event Date Time is used when creating a new RTT Status
	private PathwayRTTStatus createPatientRTTStatus(int nationalCode, java.util.Date eventDateTime) //WDEV-18325
	{
		PathwayRTTStatus rttSTatusDO = new PathwayRTTStatus();
		
		RTTStatusPoint rttStatusPoint = getRTTStatusPointFromConfig(nationalCode);
		
		rttSTatusDO.setRTTStatus(rttStatusPoint);
		
		Object mos = getMosUser();
		MemberOfStaff doMos = null;
		
		if(mos instanceof MemberOfStaffLiteVo)
		{
			doMos = MemberOfStaffLiteVoAssembler.extractMemberOfStaff(getDomainFactory(), (MemberOfStaffLiteVo) mos);
		}
		
		rttSTatusDO.setStatusBy(doMos);
		rttSTatusDO.setStatusDateTime(eventDateTime);
		
		rttSTatusDO.setSetting("O");
		
		return rttSTatusDO;
	}
	private DateTime getDNAEventDateTime(DateTime apptDateTime, Status_Reason apptStatus) 
	{
		if (!Status_Reason.DNA.equals(apptStatus))				
			return null;
		
		return new DateTime(apptDateTime);
	}
	private void  instantiatePatientEvent(CatsReferral doCats,DateTime apptDateTime, Status_Reason apptStatus) throws StaleObjectException, DomainInterfaceException //WDEV-18325
	{	
		if (!ConfigFlag.DOM.RTT_STATUS_POINT_FUNCTIONALITY.getValue())
			return;
		
		if(doCats == null || doCats.getJourney() == null || doCats.getJourney().getCurrentClock() == null)
			return;
		
		RTTStatusEventMapVo  rttEventMap = null;

		if (doCats.getJourney().getCurrentClock().getCurrentRTTStatus() != null)
		{
			rttEventMap = getRTTStatusEventMap(doCats.getJourney().getCurrentClock().getCurrentRTTStatus().getRTTStatus());
		}
		
		if (rttEventMap == null || rttEventMap.getEvent() == null)
			return;
		
		PatientEventVo patEvent = new PatientEventVo();
		patEvent.setPatient((PatientRefVo)PatientListVoAssembler.create(doCats.getPatient()));
		patEvent.setEvent(rttEventMap.getEvent());
		patEvent.setEventDateTime(getDNAEventDateTime(apptDateTime, apptStatus) != null ? getDNAEventDateTime(apptDateTime, apptStatus):new DateTime());
		patEvent.setEventStatus(EventStatus.ACTIVE);
		patEvent.setJourney(PatientJourneyVoAssembler.create(doCats.getJourney()));
		
		HL7PathwayIf impl = (HL7PathwayIf) getDomainImpl(ims.pathways.domain.impl.HL7PathwayIfImpl.class);
		
		impl.instantiatePatientEvent(patEvent);
		
	}
		
	private RTTStatusPoint getRTTStatusPointFromConfig(int nationalCode) //WDEV-18325
	{	
		String hql = "from RTTStatusPoint as rttpoint where rttpoint.nationalCode = :natCode";
		DomainFactory fact = getDomainFactory();
		
		List<?> results = fact.find(hql, new String[]{"natCode"}, new Object[] {nationalCode});
		if (results != null && results.size() != 0 && results.get(0) instanceof RTTStatusPoint)
		{	
			return (RTTStatusPoint) results.get(0);
						
		}
		return null;
	}

	private RTTStatusEventMapVo getRTTStatusEventMap(RTTStatusPoint rttStatusPoint) //WDEV-18325 
	{
		if (rttStatusPoint == null || rttStatusPoint.getId() == null)	
			return null;

		String hql = "select event from RTTStatusEventMap as event left join event.currentRTTStatus as rttstat where event.active = 1 and rttstat.nationalCode = :natCode and event.encounterType is null ";

		DomainFactory factory = getDomainFactory();

		List<?> events = factory.find(hql, new String[]{"natCode"}, new Object[] {rttStatusPoint.getNationalCode()});

		if (events != null && events.size() != 0 && events.get(0) instanceof RTTStatusEventMap)
		{
			return RTTStatusEventMapVoAssembler.create((RTTStatusEventMap) events.get(0));
		}
		return null;		
	}

	public Booking_Appointment sendRequestandUpdateReferences(DomainFactory factory,  ActionRequestType requestType, ims.domain.DomainObject doObject, String requestSource) throws StaleObjectException
	{
		if(requestType != null)
		{
			Booking_Appointment doAppt = null;
			Session_Slot doSlot = null;
			
			if(doObject instanceof Booking_Appointment)
				doAppt = (Booking_Appointment)doObject;
			else if(doObject instanceof Session_Slot)
			{
				doSlot = (Session_Slot)doObject;
				doAppt = doSlot.getAppointment();
			}
				
			
			if(ims.configuration.gen.ConfigFlag.DOM.SCHEDULING_SLOTS_CREATION.getValue().equals("Choose and Book"))
			{
				// wdev-5700 - cannot cancel slot without previously cancelling an appointment, so removed code from here that tried to handle that
				if (doAppt != null && (requestType.equals(ActionRequestType.NOTIFY_APPT_CANCEL) || requestType.equals(ActionRequestType.NOTIFY_DNA)))
				{
					CABRequests.placeOutgoingRequest(factory, getDomLookup(requestType), doAppt.buildCabMessage(getDomLookup(requestType)), requestSource);
				}

				// wdev-5726
				if(doSlot != null && requestType.equals(ActionRequestType.NOTIFY_SLOT_CANCEL))
				{
					StringBuffer cabMessage = new StringBuffer();
					cabMessage.append("USRN:");
					Iterator it = doSlot.getDirectoryOfServices().iterator();
					while (it.hasNext())
					{
						ims.scheduling.domain.objects.DirectoryOfServiceSessionSlot slotDos = (DirectoryOfServiceSessionSlot) it.next();
						if (slotDos.isIsPublished() != null && slotDos.isIsPublished().booleanValue() == true)
						{
							if (slotDos.getUBRN() == null || (doSlot.getAppointment() != null && (doSlot.getAppointment().isIsCABBooking() == null 
									|| doSlot.getAppointment().isIsCABBooking().booleanValue() == false)))
							{
								cabMessage.append(slotDos.getUSRN());
								if (it.hasNext())
									cabMessage.append(";");
							}
						}
					}
					cabMessage.append(";");
					if (cabMessage.length() > 0 && !cabMessage.toString().equals("") && !cabMessage.toString().equals("USRN:;"))
						CABRequests.placeOutgoingRequest(factory, getDomLookup(requestType), cabMessage.toString(), "Slot Cancel requested through Clinic List");
					
				}
			}
							
			return doAppt;
		}	
		
		return null;
	}
	

	public PatientEventVo createAndSaveEvent(Event event, Booking_Appointment doAppt, PatientJourneyVo voJourney) throws DomainInterfaceException, StaleObjectException
	{
		PatientEventVo voEvent = new PatientEventVo();
		voEvent.setEventDateTime(!Status_Reason.DNA.equals(doAppt.getApptStatus()) ? new DateTime(): new DateTime(new Date(doAppt.getAppointmentDate()), new Time(doAppt.getApptStartTime())));//WDEV-20603
		voEvent.setEvent(new EventRefVo(event.getId(),event.getVersion()));
		voEvent.setScheduledDate(new DateTime(new Date(doAppt.getAppointmentDate()), new Time(doAppt.getApptStartTime())));
		
		//called from this class
		if(voJourney == null)
		{
			PatientJourneyTargetVo voPatientJourneyTarget =  PatientJourneyTargetVoAssembler.create(getFirstPathwayEvent(doAppt.getPathwayEvents()));
			if(voPatientJourneyTarget != null)
			{
				voEvent.setJourney(voPatientJourneyTarget.getPathwayJourney());
				if(voPatientJourneyTarget.getPathwayJourneyIsNotNull())
					voEvent.setPatient(voPatientJourneyTarget.getPathwayJourney().getPatient());
				
				voEvent.setPatientTarget(voPatientJourneyTarget);
				if(voPatientJourneyTarget.getPathwayJourney().getPathwayIsNotNull())
					voEvent.setSpecialty(voPatientJourneyTarget.getPathwayJourney().getPathway().getSpecialty());
			}
		}
		else
		{
			//called from Booking Screen
			voEvent.setJourney(voJourney);
			voEvent.setPatient(voJourney.getPatient());
			voEvent.setPatientTarget( getPatientTarget(event, voJourney));
			if(voJourney.getPathwayIsNotNull())
				voEvent.setSpecialty(voJourney.getPathway().getSpecialty());
		}

		HL7PathwayIf impl = (HL7PathwayIf) getDomainImpl(HL7PathwayIfImpl.class);
		return impl.instantiatePatientEvent(voEvent);
	}

	private PatientJourneyTargetRefVo getPatientTarget(Event event, PatientJourneyVo voJourney)
	{
		String hql = "select pjt from PatientJourneyTarget as pjt left join pjt.pathwayTarget as pt left join pt.target as target1 left join pjt.pathwayJourney as pj, EventTarget as et left join et.target as target2 left join et.event as event where " +
		"(pj.id = :idJourney and event.id = :idEvent)";
		
		List pjts = getDomainFactory().find(hql, new String[]{"idJourney","idEvent"}, new Object[]{event.getId(), voJourney.getID_PatientPathwayJourney()});
		if(pjts != null && pjts.size() > 0)
			PatientJourneyTargetVoAssembler.create((PatientJourneyTarget) pjts.get(0));
	
		return null;
	}

	private PatientJourneyTarget getFirstPathwayEvent(Set pathwayEvents)
	{
		Iterator it = pathwayEvents.iterator();
		PatientEvent pe;
		if(it.hasNext())
		{
			pe = (PatientEvent)it.next();
			return pe.getPatientTarget();
		}
		return null;
	}

	

	public void cancelSlot(SessionSlotVo sessionSlot, ActionRequestType requestType, String requestSource) throws StaleObjectException
	{
			SessionAdmin impl = (SessionAdmin) getDomainImpl(SessionAdminImpl.class);
			impl.cancelSlot(sessionSlot, requestType, requestSource);
	}

	public Booking_AppointmentVo cancelAppt(Booking_AppointmentVo appt, ActionRequestType requestType, String requestSource) throws DomainInterfaceException, StaleObjectException  
	{		
			SessionAdmin impl = (SessionAdmin) getDomainImpl(SessionAdminImpl.class);
			return impl.cancelAppt(appt, requestType, requestSource);
	}
		
	public void reOpenSlot(SessionSlotVo sessionSlot) throws StaleObjectException 
	{
		DomainFactory factory = getDomainFactory();
		Session_Slot doSessionSlot = SessionSlotVoAssembler.extractSession_Slot(factory, sessionSlot);
		factory.save(doSessionSlot);
	}

	private Booking_Appointment saveAppt(DomainFactory factory, Booking_AppointmentVo appt) throws StaleObjectException
	{		
		Booking_Appointment doAppt = Booking_AppointmentVoAssembler.extractBooking_Appointment(factory, appt);
		
		//increment slots remaining if its a cancel
		// wdev-5745 only for non-icab bookings as they will get set to provisional only
		if ((doAppt.isIsCABBooking() == null || doAppt.isIsCABBooking().booleanValue() == false) && doAppt.getApptStatus().equals(getDomLookup(Status_Reason.CANCELLED)))
			doAppt.getSession().incrementRemainingSlots(1);

		// WDEV-5745 only set to cancelled provisional at this stage
		if (doAppt.isIsCABBooking() != null &&  doAppt.isIsCABBooking().booleanValue() == true && ConfigFlag.GEN.ICAB_ENABLED.getValue())
			doAppt.setApptStatus(getDomLookup(Status_Reason.CANCEL_PROVISIONAL));
		
		//WDEV-5021
		updateJourney(doAppt, true);

		try {
			factory.save(doAppt);
		} catch (DomainException e) {
			throw new DomainRuntimeException("Domain Error occured in saveAppt " + e.getMessage(),e);
		} 
		return doAppt;
	}

	public Sch_BookingVoCollection listFlexibleBookings(Sch_SessionRefVo session) 
	{
		DomainFactory factory = getDomainFactory();
		
		List bookings = factory.find("select booking from Sch_Booking as booking left join booking.appointments as appt where appt.session.id = :sessionId", new String[]{"sessionId"}, new Object[]{session.getID_Sch_Session()});
		return Sch_BookingVoAssembler.createSch_BookingVoCollectionFromSch_Booking(bookings);
	}

	public SessionSlotVoCollection listAppointments(Sch_SessionRefVo session, Integer[] sessionIds, Status_Reason apptType)
	{
		if(session != null && sessionIds != null)
			throw new CodingRuntimeException("parameters are mutually exclusive in method listAppointments");
		
		DomainFactory factory = getDomainFactory();

		String hql = "";
		if(session != null)
		{
			hql = "select sessionSlot from Sch_Session as session join session.sessionSlots as sessionSlot" + 
				" where (session.id = :idSession" +  (apptType == null ? ")" : "");
		}
		else if(sessionIds != null)
		{
			hql = "select sessionSlot from Sch_Session as session join session.sessionSlots as sessionSlot" + 
				" where (session.id in (" + getIdString(sessionIds) + ")" +  (apptType == null ? ")" : "");
		}
		
		if(apptType != null)
				hql += " and sessionSlot.appointment is not null and sessionSlot.appointment.apptStatus.id = " + apptType.getID() + ")";
		
		List slots = factory.find(hql, new String[] {"idSession"}, new Object[] {session.getID_Sch_Session()});
		return SessionSlotVoAssembler.createSessionSlotVoCollectionFromSession_Slot(slots).sort();	
	}
	
	private String getIdString(Integer[] sessionIds)
	{
		String idString = "";
		
		for(int i=0;i<sessionIds.length;i++)
		{
			idString += sessionIds[i];
			idString += ((sessionIds.length - (i+1)) > 0 ? "," : "");
		}
		
		return idString;
	}

	public void saveAppointment(Booking_AppointmentVo appt) throws StaleObjectException
	{
		saveAppt(getDomainFactory(), appt);
	}

	public CareSpellVo saveCareSpell(CareSpellVo voCareSpell) throws StaleObjectException
	{
		if (voCareSpell == null  || !voCareSpell.isValidated())
			throw new CodingRuntimeException("Care Spell is null or has not been validated");
			
		DomainFactory factory = getDomainFactory();
		CareSpell doCareSpell = CareSpellVoAssembler.extractCareSpell(factory, voCareSpell);		
		factory.save(doCareSpell);

		return CareSpellVoAssembler.create(doCareSpell);		}

	public ContextType getPASCode(ActivityVo activity)
	{
		DomainFactory factory = getDomainFactory();
		ims.domain.lookups.Lookup lookupType = factory.getLookup(ContextType.TYPE_ID);
		
		if (null != lookupType)
		{
			java.util.Set set = lookupType.getInstances();
			
			for (Iterator iter = set.iterator(); iter.hasNext();)
			{
				LookupInstance lookup = (LookupInstance) iter.next();
				
				if(lookup.isActive())
				{
					Set mappings = lookup.getMappings();
					
					for (Object object : mappings)
					{
						if(object instanceof LookupMapping)
						{
							LookupMapping mapping = (LookupMapping)object;
							
							if("PAS".equals(mapping.getExtSystem()) && activity.getID_Activity().toString().equalsIgnoreCase(mapping.getExtCode()))
							{
								LookupInstVo vo = createLookupinstanceVo(lookup);
								//public ContextType(int id, String text, boolean active, ContextType parent, Image image, Color color, int order)
								ContextType contextType = new ContextType(vo.getID(), vo.getText(), vo.isActive());
								return contextType;
							}
						}
					}
					
				}
				
			}
		}		
		
		return null;
	}
	
	private LookupInstVo createLookupinstanceVo(LookupInstance element)
	{
		if (element == null)
			return null;
		Image img = null;
		Image regImage = element.getImage();
		if (regImage != null)
		{
			img = new ImagePath(regImage.getImageId(), regImage.getImagePath());
		}
		LookupInstVo valueObject = new LookupInstVo(element.getId(), element.getText(), element.isActive(), null, img, element.getColor(), element.getOrder());
		LookupInstance doParent = element.getParent();
		if (doParent != null)
		{
			LookupInstVo voParent = createLookupinstanceVo(doParent);
			valueObject.setParentInstance(voParent);
		}
		return valueObject;
	}

	public void updateJourney(Booking_Appointment doAppt, Boolean isCancel) throws StaleObjectException
	{
		SessionAdmin impl = (SessionAdmin) getDomainImpl(SessionAdminImpl.class);
		impl.updateJourney(doAppt, isCancel);
	}

	//WDEV-12568
	public Booking_AppointmentVo getAppointment(Session_SlotRefVo sessionSlot)
	{
		if(sessionSlot == null || !sessionSlot.getID_Session_SlotIsNotNull())
			throw new DomainRuntimeException("Invalid Session Slot reference provided.");
		
		DomainFactory factory = getDomainFactory();
		String query = "select ss.appointment from Session_Slot as ss where ss.id = :SessionSlotId";
		
		List<?> list = factory.find(query, new String[] {"SessionSlotId"}, new Object[] {sessionSlot.getID_Session_Slot()});
		
		if(list == null || list.size() == 0)
			return null;
		
		if(list.size() > 1)
			throw new DomainRuntimeException("A session slot can not have associated more than one appointment.");
		
		return Booking_AppointmentVoAssembler.create((Booking_Appointment) list.get(0));
	}

	//WDEV-12568
	public CatsReferralForClinicListVo getCatsReferral(Booking_AppointmentRefVo appt)
	{
		if(appt == null || appt.getID_Booking_Appointment() == null)
			throw new CodingRuntimeException("Can not get Referral on null Appointment.");
		
		DomainFactory factory = getDomainFactory();
		List<?> cats = factory.find(" select catsref from CatsReferral as catsref left join catsref.appointments as appt where appt.id = :apptID",	new String[]{"apptID"},	new Object[]{appt.getID_Booking_Appointment()});
		if (cats != null && cats.size() > 0)
			return CatsReferralForClinicListVoAssembler.create((CatsReferral)cats.get(0));
		
		return null;
	}


	public Boolean hasTCI(Booking_AppointmentRefVo appointment)
	{
		if (appointment == null)
			return Boolean.FALSE;

		String query = "SELECT COUNT (tci.id) FROM TCIForPatientElectiveList AS tci LEFT JOIN tci.appointment AS appt WHERE appt.id = :APPT_ID and tci.isRIE is null";
		
		long count = getDomainFactory().countWithHQL(query, new String[] {"APPT_ID"}, new Object[] {appointment.getID_Booking_Appointment()});
		
		if (count > 0)
			return Boolean.TRUE;
		
		return Boolean.FALSE;
	}

	public PatientElectiveListForDNAAppointmentsVo getPatientElectiveList(Booking_AppointmentRefVo appointment)
	{
		if (appointment == null)
			return null;
		
		String query = "SELECT electivList FROM PatientElectiveList AS electivList LEFT JOIN electivList.tCIDetails AS tci LEFT JOIN tci.appointment AS appt WHERE appt.id = :APPT_ID ";
		
		return PatientElectiveListForDNAAppointmentsVoAssembler.create((PatientElectiveList) getDomainFactory().findFirst(query, "APPT_ID", appointment.getID_Booking_Appointment()));
	}


}
