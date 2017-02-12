
package com.ndnu.refl1;

import java.lang.reflect.*;

import java.util.*;



public class ClassExaminer {

	public String getClassName(Object o) { //prints out the full name of the class. Ex: com.ndnu.refl1.FlightInfo

	// 1. Retrieve the Class object.
	// 2. Invoke the getName() method in that Class object.

	  Class c = o.getClass(); //always need this.
	  return c.getName();
	}

	public ArrayList<String> getClassModifiers(Object o) {

	// 1. Retrieve the Class object.
	// 2. Invoke the getModifiers() method in that Class object.
	// 3. Use isPublic(), isAbstract(), and isFinal() in the Modifier class.
	
	  ArrayList<String> list = new ArrayList<String>();

	  Class c = o.getClass();  //always need to retrieve the Class object.
	  int m = c.getModifiers(); // The int value returned is a combination of the 
				    // values assigned to each modifier. For example,
				    // a class declared as public (1) and final(16) 
				    // will return a value of 17.
      	  if (Modifier.isPublic(m))
		list.add("public");
      	  if (Modifier.isAbstract(m))
		list.add("abstract");
      	  if (Modifier.isFinal(m))
		list.add("final");

	  return list;
	}

	
	public ArrayList<String> getSuperClasses(Object o) {

    // 1. Retrieve the Class object.
	// 2. Use the getSuperClass() method in the Class object.

	  ArrayList<String> list = new ArrayList<String>();

	  Class c = o.getClass(); 
	  Class superclass = c.getSuperclass(); //this is a method of the Class class (Oracle documentation has reference to all available methods.)
          while (superclass != null) { //while loop iterates through all parent class to retrieve all of them. 
             String className = superclass.getName();
	     list.add(className);
             c = superclass;
             superclass = c.getSuperclass();
      	  }

	  return list;
	}


	public ArrayList<String> getInterfaces(Object o) { // since you can implement as many interfaces 
		// for a class, this method loops through and extracts all of them. 

        // 1. Retrieve the Class object.
        // 2. Use the getInterfaces() method in the Class object.

          ArrayList<String> list = new ArrayList<String>();

          Class c = o.getClass();
          Class[] interfaces = c.getInterfaces();
	  for (int i = 0; i < interfaces.length; i++) {
              String interfaceName = interfaces[i].getName();
	      list.add(interfaceName);
          }

          return list;
        }

	public ArrayList<String> getFields(Object o) { //retrieves all the instance variables in a Field[ ] array.

        // 1. Retrieve the Class object.
        // 2. Use the getFields() method in the Class object.
   	//    getFields() retrieves public fields ONLY.
	// 3. Use the getName() and getType() methods in the Field object.

          ArrayList<String> list = new ArrayList<String>();

          Class c = o.getClass();
	  Field[] publicFields = c.getFields();
      	  for (int i = 0; i < publicFields.length; i++) {
         	  String fieldName = publicFields[i].getName();
         	  Class typeClass = publicFields[i].getType();
         	  String fieldType = typeClass.getName();
         	  list.add(fieldName + " " + fieldType);
          }

	  return list;
	}

	public ArrayList<String> getMethods(Object o) { //retrieves all the methods of the class. 

	  // 1. Retrieve the Class object.
	  // 2. Use the getMethods() method in the Class object.
	  // 3. Use the Method class to get the modifier, name, parameters
	  //    and return type of each method. 

	  ArrayList<String> list = new ArrayList<String>();

	  Class c = o.getClass();
	  Method[] methods = c.getMethods();
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
	     list.add(methodString);
          }
	  return list;
	}

	public static void main(String[] args) {
	  ClassExaminer ce = new ClassExaminer();
	  Department dep = new Department();
	//import /com.ndnu.jdbc3/Department
	  System.out.println(ce.getClassName(dep));
	  
	  ArrayList<String> list = ce.getClassModifiers(dep);
	  System.out.println(list);
	  
	  System.out.println(list = ce.getSuperClasses(dep));
	  System.out.println(list = ce.getInterfaces(dep));
	  System.out.println(list = ce.getFields(dep));
	  System.out.println(list = ce.getMethods(dep));
	  
	  
/*	  FlightInfo fi = new FlightInfo();
	  System.out.println(ce.getClassName(fi));  // prints FlightInfo - gets the name of the FlightInfo object class.

	  ArrayList<String> list = ce.getClassModifiers(fi);
	  System.out.println(list);  // prints [public]
				    // prints [] if class modifier is at the package level

	  list = ce.getSuperClasses(fi);
	  System.out.println(list);  // prints [java.lang.Object] <-- Object is the SuperClass.

	  list = ce.getInterfaces(fi);
	  System.out.println(list);  // prints [Viewable] <-- Viewable is the interfaces that extends the class FlightInfo.

	  list = ce.getFields(fi);
	  System.out.println(list);  // prints [REG_FLTNUM int, SPCL_FLTNUM int] The variables/fields are printed in an Array format. 

	  list = ce.getMethods(fi);  // prints all method signatures
	  for (int k = 0; k < list.size(); ++k) {
	    System.out.println(list.get(k));
	  }
*/	} 
}
