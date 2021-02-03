package com.hospitalrecords;

import java.util.Calendar;
import java.util.Date;

public class OutPatient {
	
	private String patientName;
	private String Location;
	Date visitDate;

	public OutPatient() {
		this.patientName = "";
		this.Location = "";
		this.visitDate = calendar.getTime();
	}
	
	Calendar calendar = Calendar.getInstance();
	
	public OutPatient(String name, String location, Date visitationDate) {
		this.patientName = name;
		this.Location = location;
		this.visitDate = visitationDate;
	}

	@Override
	public String toString() {
	    return "Patient Name " + this.getPatientName() + 
	           ", Patient Location " + this.getLocation();
	}
	
	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}
	
	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
}
