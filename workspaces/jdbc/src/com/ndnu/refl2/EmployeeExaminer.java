package com.ndnu.refl2;
import java.lang.reflect.*;

import java.util.*;

public class EmployeeExaminer {

	public String getClassName(Object o) { //prints out the full name of the class.

	// 1. Retrieve the Class object.
	// 2. Invoke the getName() method in that Class object.

	  Class c = o.getClass(); //always need this.
	  return c.getName();
	}
	
	public int getClassMethodCount(Object o) {
		Class c = o.getClass();
		
		 int NumOfMethods = c.getDeclaredMethods().length;
		 Method[] methods = c.getDeclaredMethods();
				 
				 //length - 1;
		 
		 return NumOfMethods;
		}
	
	public ArrayList<String> getClassMethods(Object o) {
		Class c = o.getClass();
		
		ArrayList<String> listOfMethods = new ArrayList<String>();
		Method[] methods = c.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
		     int m  = methods[i].getModifiers();
		     String methodString = Modifier.toString(m) + " ";
	             methodString += methods[i].getReturnType().getName() + " ";
	             methodString += methods[i].getName() + "(";
	             Class[] parameterTypes = methods[i].getParameterTypes();
	             for (int k = 0; k < parameterTypes.length; k ++) {
	                methodString += parameterTypes[k].getName() + " ";
	             }
		     methodString += ")";
		     listOfMethods.add(methodString);
	          }
		return listOfMethods;
	}
	
	public int getPrivateClassFields(Object o) {
		Class c = o.getClass();
	    
		Field[] variables = c.getDeclaredFields();
		int count = 0;
		
		for (int i = 0; i < variables.length; i++) {
		     int v  = variables[i].getModifiers();
		     	if (Modifier.isPrivate(v)) {
		     		++count;
		     	}
		}
		System.out.println("Employee Class has: " + count + " private fields.");
     	return count;
	}
	
	public Object getFieldValue(Object obj, String fieldName) {
		Class c = obj.getClass();
		Object value = null;
		Field objectValue = null;
			try {
				objectValue = c.getField(fieldName);
			} catch (NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
			
			try {
				value = objectValue.get(obj);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return value;
	}
	
	public static void main(String[] args) {
		EmployeeExaminer emex = new EmployeeExaminer();
		Employee emp = new Employee();
		System.out.println(emex.getClassName(emp));
		System.out.println(emex.getClassMethodCount(emp));
		System.out.println(emex.getClassMethods(emp));
		emex.getPrivateClassFields(emp);
		System.out.println(emex.getFieldValue(emp, "x"));
	}
	
}
