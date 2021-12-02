package com.revature.strings;

public class Driver {
	
	public static void main(String[] args) {
		
		String strObject = new String("hello");
		String strLitrel = "hello";
		String str2 = "hello";
		
		System.out.println(str2.equals(strLitrel));
		System.out.println(str2 == strLitrel);
		System.out.println(strObject == str2);
		System.out.println(str2.equals(strObject));
		
		String str3 = new String("hello");
		
		String str4 = "Hello world";
		String str5 = "Hello " + "world";
		
		System.out.println(str4 == str5);
		
		// hashcode respresent value of proprietie of the object ;
		
		
		System.out.println(str2.hashCode());
	
		System.out.println(strObject.hashCode());
		
		
		String str7 = "hello ";
		String str6 = str7 + "world" ; // like we do new String becase we appending ==> goes to general heap ;
		
		System.out.println(str7 == str6);
		
				
		String strPool = str6.intern();
		
		System.out.println(strPool == str6); // go to the heap pool ;
		
		/*
		 * 
		 * string API
		 * .concat()
		 * .substring()
		 * 
		 *
		 * 
		 * 
		 * 
		 */
		
		String newSTrString = str2.concat(strPool);
		
		System.out.println(newSTrString);
		
		
		String test = "the quick for jump .....";
		
		String chopped = test.substring(3);
		
		System.out.println(chopped);
		
		
		/////////////////////////////////////////////////
		
		
		StringBuilder sBuilder = new StringBuilder("hello");
		
		sBuilder.append(" world");
		sBuilder.append(" !");
		
		System.out.println(sBuilder); 
		
		// same object ;
		
		String stToPoolString =  sBuilder.toString();
		
		String stringtoPoolString = stToPoolString.intern();
		
		stToPoolString = stringtoPoolString;
		
		System.out.println(stToPoolString == stringtoPoolString);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
