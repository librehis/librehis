// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.referraldetails;

public final class FormInfo extends ims.framework.FormInfo
{
	private static final long serialVersionUID = 1L;
	public FormInfo(Integer formId)
	{
		super(formId);
	}
	public String getNamespaceName()
	{
		return "RefMan";
	}
	public String getFormName()
	{
		return "ReferralDetails";
	}
	public int getWidth()
	{
		return 848;
	}
	public int getHeight()
	{
		return 632;
	}
	public String[] getContextVariables()
	{
		return new String[] { "_cv_RefMan.OpenApptAndInvTab", "_cv_RefMan.CatsReferralStatus", "_cv_RefMan.RejectionReason", "_cv_RefMan.ReferralNote", "_cv_RefMan.CatsReferralHasGpLetter", "_cv_RefMan.ReferralReviewDetailsMode", "_cv_ICP.Service", "_cv_RefMan.IsComponentInEditMode", "_cv_RefMan.OpenBookAppointmentScreen", "_cv_RefMan.SecondOpinionReferralStatus", "_cv_RefMan.ReferralOutcomeReportType", "_cv_RefMan.CurrentServiceLiteVo", "_cv_RefMan.PrintRejectionLetters", "_cv_ICP.ProcedureID", "_cv_Scheduling.BookingService" };
	}
	public String getLocalVariablesPrefix()
	{
		return "_lv_RefMan.ReferralDetails.__internal_x_context__" + String.valueOf(getFormId());
	}
	public ims.framework.FormInfo[] getComponentsFormInfo()
	{
		ims.framework.FormInfo[] componentsInfo = new ims.framework.FormInfo[6];
		componentsInfo[0] = new ims.RefMan.forms.referraloverviewandkpis.FormInfo(134129);
		componentsInfo[1] = new ims.RefMan.forms.referraldetailscomponent.FormInfo(134118);
		componentsInfo[2] = new ims.RefMan.forms.presentationcomponent.FormInfo(134114);
		componentsInfo[3] = new ims.core.forms.uploaddocument.FormInfo(102264);
		componentsInfo[4] = new ims.RefMan.forms.referralappointmentdetailscomponent.FormInfo(134117);
		componentsInfo[5] = new ims.core.forms.referraldetailsnotes.FormInfo(134140);
		return componentsInfo;
	}
	public String getImagePath()
	{
		return "Images/RefMan/referral_details_48.png";
	}
}