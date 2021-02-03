package com.util.assignment;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import com.hospitalrecords.OutPatient;

public class CommonMethods {
	
	Scanner scanner = new Scanner(System.in);
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	
	public void checkDateInRange(ArrayList<OutPatient> patientList) {

		Date dateVisited;
		
		Iterator<OutPatient> iter = patientList.iterator();
		while(iter.hasNext())
		{
			OutPatient op = iter.next();
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				
				Date fromDate = dateFormat.parse("2021-01-01");
				Date toDate = dateFormat.parse("2021-02-01");
				dateVisited = op.getVisitDate();
				if(dateVisited.before(fromDate) || dateVisited.after(toDate))
					System.out.println("Patient " + op.getPatientName() + " visited on date Outside date range");
				else
					System.out.println("Patient " + op.getPatientName() + " visited on date Inside date range");
			}
			catch(ParseException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("-----------------------------------------------");
	}
	
	public void fetchPatientOnDate(ArrayList<OutPatient> patientList) {
		
		System.out.println("Enter Date to check which patients visited on a particular date (Format yyyy-MM-dd)");
		String enteredCheckVisitDate = scanner.next();
		Date checkVisitedDate = Calendar.getInstance().getTime();
		try {
			checkVisitedDate = dateFormat.parse(enteredCheckVisitDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Iterator<OutPatient> iter = patientList.iterator();
		while(iter.hasNext())
		{
			OutPatient op = iter.next();
		   // String location = op.getLocation();
		    Date dateVisited = op.getVisitDate();
		
			if(checkVisitedDate.equals(dateVisited)) 
				System.out.println("Patient " + op.getPatientName() + " visited on the date mentioned");
			else
				System.out.println("Patient " + op.getPatientName() + " did not visit on the date mentioned");
		}
		
		System.out.println("-----------------------------------------------");
	}
	
	public void calculatePatientPercent(ArrayList<OutPatient> patientList, int totalPatients) {
		
		int inCount = 0, outCount = 0;
		Iterator<OutPatient> iter = patientList.iterator();
		while(iter.hasNext())
		{
			OutPatient op = iter.next();
		    String location = op.getLocation();
		    if(location.equals("BGL")) {
		    	inCount ++;
		    }
		    else {
		    	outCount ++;
		    }
		}
		DecimalFormat df = new DecimalFormat("0.00");
		double inPercent = (double)inCount/totalPatients * 100;
		System.out.println("In Patient percentage is " + df.format(inPercent) + "%");
		double outPercent = (double)outCount/totalPatients * 100;
		System.out.println("Out Patient percentage is " + df.format(outPercent) + "%");
		
		System.out.println("-----------------------------------------------");
	}
	
	public ArrayList<OutPatient> fetchPatientData(int totalPatients){
		
		String patientName = "";
		String patientLocation = "";
		String enteredDate = "";
		Date date;
		
		ArrayList<OutPatient> patientList = new ArrayList<OutPatient>();
		
		for(int i = 1; i < totalPatients + 1; i++) {
			System.out.println("Enter Patient Number " + i + " Name");
			patientName = scanner.next();
			
			System.out.println("Enter Patient Number " + i + " Location");
			patientLocation = scanner.next();
			
			System.out.println("Enter Visit Date in yyyy-MM-dd format");
			enteredDate = scanner.next();
			
			date = Calendar.getInstance().getTime();
			try {
				date = dateFormat.parse(enteredDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			patientList.add(new OutPatient(patientName, patientLocation, date));
		}
		return patientList;
	}
}
