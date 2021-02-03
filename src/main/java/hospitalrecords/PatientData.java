package hospitalrecords;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class PatientData extends OutPatient {

	public void fetchPatientDetails() {
		
		String patientName = "";
		String patientLocation = "";
		int totalPatients;
	
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter total number of patients ");
		totalPatients = scanner.nextInt();
		
		ArrayList<OutPatient> patientList = new ArrayList<OutPatient>();
		
		for(int i = 1; i < totalPatients + 1; i++) {
			System.out.println("Enter Patient Number " + i + " Name");
			patientName = scanner.next();
			
			System.out.println("Enter Patient Number " + i + " Location");
			patientLocation = scanner.next();
			
			Date date = Calendar.getInstance().getTime();
			
			patientList.add(new OutPatient(patientName, patientLocation, date));
		}

		for(OutPatient x: patientList) {
		    System.out.println(x);  // Will invoke overrided `toString()` method
		}
	}
}