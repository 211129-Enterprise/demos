public class HelloWorld {

	
	public static void main (String[] args) {
		System.out.println("Hello World!!!");
		// Ctrl + Space autofills 
		System.out.println("It works");
		
		
		/**
		 * Java has 8 primitives
		 */
		
		boolean isOn = true; // 1 bit memory ( 0 or 1)
		byte reallySmallNum = 127; // 8 bits of memory 0000 0000 to 1111 1111 eg.
		short smallNum; // 16 bits of memory 
		char letter = 'A'; // 16 bits of memory
		int regularNum; // 32 bits of memory
		float lessPreciseDouble; // 32 bits of memory
		double decimal; // 64 bits of memory
		long bigNumber = 1234L; // 64 bits of memory
		
		// all the primitives start with smaller case
		
		
		/**
		 * Casting is converting one data type to another
		 * 
		 * widening -> implicit  -> moving to bigger data type
		 * narrow -> explicit -> shrinking to smaller data type -> this can cause loss of data
		 */
		
		double dub = 1.23;
		int myInt = (int) dub;
		System.out.println(myInt);
		
		String name = "SquarePants"; // this is a string literal = square pants
		
		/**
		 * Note here String here is blue and not orange, because its a class
		 * 
		 * all our primitives above eg. boolean, byte, short, int, float, double etc. also have object version of them 
		 * These are called Wrapper classes
		 * 
		 * Wrapper Class is class name of primitive data type
		 * we use these because they are data structures which only work with objects, eg. collections framework
		 * 
		 * 
		 * An Object is a reusable component with method and properties which we call
		 * 
		 * A Class is blueprint of Object -> a Class tells us how to create an Object, 
		 */
		
		int min = Integer.MIN_VALUE;
		// integer min is equal to minimum value of the Integer Class
		// MIN_VALUE is a property of Integer Class
		System.out.println(min);
		
	
		Integer obj1 = new Integer(20);
		
		System.out.println(obj1);
		// This is coverting primitive to Integer Object
		// This is called Autoboxing
		
		
		
		
	}
/**
 *  Forward / and ** and enter -> by this we can enter multi line comment
 */

  }


