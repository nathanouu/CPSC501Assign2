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
		Class objectClass = obj.getClass();
        String declaringClass = objectClass.getName();
        System.out.println("	Declaring Class: " + declaringClass);


        String superClass = objectClass.getSuperclass().getName();
        System.out.println("	Super Class: " + superClass);


        interfaceNames(obj, objectClass, recursive);
        System.out.println();


        System.out.println("\n******* Constructors");
        constructorNames(objectClass);


        System.out.println("\n******* Methods");
        methodNames(objectClass);


	}

    public void interfaceNames(Object obj, Class objectClass, boolean recursive)
    {
        Class[] interfaces = objectClass.getInterfaces();
        
        for (Class interFace : interfaces) 
        {

            System.out.println("	Interface : " + interFace.getName());

            if (interFace.getConstructors().length != (new Constructor[] {}).length)
            {
                System.out.println("\n*****  Interface constructors *****");
                constructorNames(interFace);
            }
            
            System.out.println("\n****** End of Interface traversal  ******\n");
        }

    }


    public void constructorNames(Class objectClass) 
    {
        Constructor[] constructors = objectClass.getConstructors();
        Class[] params;

        for (Constructor constructor : constructors) {
            System.out.println("	Constructor: " + constructor.getName());
            
            params = constructor.getParameterTypes();
            for (Class param : params) 
            {
                System.out.println("		Parameter: " + param.getName());
            }

            System.out.println("		Modifiers : " + constructor.getModifiers() + "\n");

        }

    }

    public void methodNames(Class objectClass) 
    {
        Method[] declaredMethods = objectClass.getDeclaredMethods();

        Class[] exceptions;
        Class[] params;

        for (Method method : declaredMethods) 
        {
            System.out.println("	Method: " + method.getName());

            exceptions = method.getExceptionTypes();

            for (Class exception : exceptions) 
            {
                System.out.println("		Exception : " + exception.getName());
            }

            params = method.getParameterTypes();
            for (Class param : params) 
            {
                System.out.println("		Parameter : " + param.getName());
            }

            System.out.println("		Return type : " + method.getReturnType().getName());
            System.out.println("		Modifiers : " + method.getModifiers() + "\n");            
            System.out.println();
        }


    }












}












