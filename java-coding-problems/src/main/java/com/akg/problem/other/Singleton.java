/**
 * 
 */
package com.akg.problem.other;

/**
 * @author amit
 * 	
 * method name as that of class
 */
public class Singleton {

	/** static variable single_instance of type Singleton */
	//	private static Singleton single_instance=null;
	private static volatile Singleton single_instance;

	/** variable of type String */
	public String str;

	/** private constructor restricted to this class itself */
	private Singleton(){

		str = "Hello, from Singleton class";

		/** Prevent form the reflection api. */
		if (single_instance != null){
			throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
		}

	}



		/** static method to create instance of Singleton class */
		public static Singleton getInstance()	{
	
			/** To ensure only one instance is created */
			if (single_instance == null) {
				single_instance = new Singleton();
			}
			return single_instance;
		}


		/** Thread safe version 1 */
		public synchronized static Singleton getInstance2(){
			if (single_instance == null){ //if there is no instance available... create new one
				single_instance = new Singleton();
			}
			return single_instance;
		}


	/** Thread safe version 2: less overhead compare to version 1 */
	public static Singleton getInstance3() {
		/**Double check locking pattern */
		if (single_instance == null) { /** Check for the first time */

			synchronized (Singleton.class) {   /**Check for the second time. */
				/**if there is no instance available... create new one */
				if (single_instance == null) single_instance = new Singleton();
			}
		}

		return single_instance;
	}


	/** Make singleton from serialize and deserialize operation. */
	protected Singleton readResolve() {
		return getInstance3();
	}

}



