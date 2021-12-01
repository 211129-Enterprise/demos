package com.revature.abstraction;

public interface Ectothermic {
	
	// all fields are static public final ;
	
	int Max_Body_Temp = 90; 
	
	// absract and public 
	
	void heatUp();
	
	void CoolDown();
	
	default void saySomething() {
		System.out.println("I can provide inp");
	}
	
	

}
