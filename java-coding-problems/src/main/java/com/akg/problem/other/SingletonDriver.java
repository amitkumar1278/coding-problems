/**
 * 
 */
package com.akg.problem.other;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author amit
 *
 */
public class SingletonDriver {

	public static void main(String args[])
	{
		System.out.println("==================== Testing Singleton Class ====================");
		Singleton x = Singleton.getInstance();
		Singleton y = Singleton.getInstance();

		System.out.println("==================== Testing Basic Singleton  ====================");		
		/** changing variable of instance x */
		x.str = (x.str).toUpperCase();
		System.out.println("String from x is: " + x.str);
		System.out.println("String from y is: " + y.str);
		System.out.println("\n");

		/** changing variable of instance x */
		y.str = (y.str).toLowerCase();
		System.out.println("String from x is: " + x.str);
		System.out.println("String from y is: " + y.str);

		System.out.println("==================== Testing Reflection proof Singleton  ====================");
		testSingletonReflectionProof();
		System.out.println("==================== Testing Thread safe Singleton  ====================");
		testSingletonForThreadSafety();
		System.out.println("==================== Testing serialization safe Singleton  ====================");
		testSingletonForSerialization();

	}

	/**
	 * 
	 */
	private static void testSingletonForSerialization() {
		
		try {
            Singleton instance1 = Singleton.getInstance();
            ObjectOutput out = null;

            out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
            out.writeObject(instance1);
            out.close();

            //deserialize from file to object
            ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
            Singleton instance2 = (Singleton) in.readObject();
            in.close();

            System.out.println("instance1 hashCode=" + instance1.hashCode());
            System.out.println("instance2 hashCode=" + instance2.hashCode());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		
	}

	/**
	 * 
	 */
	private static void testSingletonReflectionProof() {

		//Create the 1st instance
		Singleton instance1 = Singleton.getInstance();

		//Create 2nd instance using Java Reflection API.
		Singleton instance2 = null;
		try {
			Class<Singleton> clazz = Singleton.class;
			Constructor<Singleton> cons = clazz.getDeclaredConstructor();
			cons.setAccessible(true);
			instance2 = cons.newInstance();
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}

		//now lets check the hash key.
		System.out.println("Instance 1 hash:" + instance1.hashCode());
		System.out.println("Instance 2 hash:" + instance2.hashCode());

	}

	/**
	 * 
	 */
	private static void testSingletonForThreadSafety() {
		// TODO Auto-generated method stub

		/** Make Singleton thread safe */
		//Thread 1
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				Singleton instance1 = Singleton.getInstance();
				System.out.println("Instance 1 hash:" + instance1.hashCode());
			}
		});

		//Thread 2
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				Singleton instance2 = Singleton.getInstance();
				System.out.println("Instance 2 hash:" + instance2.hashCode());
			}
		});

		//start both the threads
		t1.start();
		t2.start();
	}

}
