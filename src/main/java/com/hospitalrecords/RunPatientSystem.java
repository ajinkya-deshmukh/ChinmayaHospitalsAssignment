package com.hospitalrecords;
import com.util.assignment.CommonMethods;
import java.util.ArrayList;
import java.util.Scanner;



public class RunPatientSystem extends OutPatient {

	public  static void main(String args[]) {
		
		int totalPatients;
		
		CommonMethods commonMethods = new CommonMethods();
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter total number of patients ");
		totalPatients = scanner.nextInt();
		
		// To fetch patient data - name, location visit date.
		ArrayList<OutPatient> patientList = commonMethods.fetchPatientData(totalPatients);

		// To calculate Local and Out-station Patients
		commonMethods.calculatePatientPercent(patientList, totalPatients);
		
		// To check patients in which date range
		commonMethods.checkDateInRange(patientList);
		
		// To check which patient visited on which date
		commonMethods.fetchPatientOnDate(patientList);
	}
}
