package hospitalrecords;

public class PatientStatistics {
	
	public static void calculatePatientPercent(int inCount, 
			int outCount, int totalPatients) {
		
		double inPercent = (double)inCount/totalPatients * 100;
		System.out.println("In Patient percentage is " + inPercent + "%");
		double outPercent = (double)outCount/totalPatients * 100;
		System.out.println("Out Patient percentage is " + outPercent + "%");
	}

}
