/** 
CPSC 501 Assignment 2
Nathan Ou 10079578
**/



import java.lang.reflect.*;
import java.util.*;


public class Inspector
{
	public void inspect(Object obj, boolean recursive)
	{
		Class objClass = obj.getClass();
        String declaringClass = objClass.getName();
        System.out.println("Declaring Class: " + declaringClass);


        String superClass = objClass.getSuperclass().getName();
        System.out.println("Super Class: " + superClass);
	}
}


