package ocp.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import ocp.reflection.test.Sample;

public class TestReflection {

	public static void main(String[] args) {

		System.out.println("Executing Main...");
		testKnownMethodsAndFields();
		testUnknown();
	}

	private static void testUnknown() {

		for (int i = 0; i < 200; i++)
			System.out.print("*");

		Class reflectClass = Sample.class;
		System.out.println("\nName of the class " + reflectClass.getName());
		System.out.println("Cannonical Name of the class " + reflectClass.getCanonicalName());
		int classModifier = reflectClass.getModifiers();
		System.out.println("Class Modifier Public: " + Modifier.isPublic(classModifier));
		System.out.println("Class Modifier Protected: " + Modifier.isProtected(classModifier));
		System.out.println("Class Modifier Private: " + Modifier.isPrivate(classModifier));
		System.out.println("Class Modifier Static: " + Modifier.isStatic(classModifier));
		System.out.println();

		Class[] interfaces = reflectClass.getInterfaces();
		Class superClass = reflectClass.getSuperclass();
		System.out.print(" Interfaces ");
		for (Class interfa : interfaces)
			System.out.print(interfa);
		System.out.println("\nsuperClass " + superClass);
		System.out.println();

		for (int i = 0; i < 200; i++)
			System.out.print("*");
	}

	private static void testKnownMethodsAndFields() {
		for (int i = 0; i < 200; i++)
			System.out.print("*");
		Sample s = new Sample();
		s.setPotectedS("initial");
		s.setPrivateI(1);
		s.setPublicS("initial");

		System.out.println(s);

		Class testRefClass = s.getClass();
		Field f;
		try {
			f = testRefClass.getDeclaredField("privateI");
			f.setAccessible(true);
			f.set(s, new Integer(22));
			f = testRefClass.getDeclaredField("potectedS");
			f.setAccessible(true);
			f.set(s, "Updated");
			f = testRefClass.getDeclaredField("publicS");
			f.setAccessible(true);
			f.set(s, "Updated");
			System.out.println(s);
		} catch (NoSuchFieldException | SecurityException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		System.out.println();
		Method[] methods = testRefClass.getMethods();
		for (Method method : methods)
			System.out.println(method.getName());
		System.out.println();

		try {
			Method m1 = testRefClass.getDeclaredMethod("getPrivateMethod", null);
			m1.setAccessible(true);
			m1.invoke(s, null);
			System.out.println(m1.invoke(s, null));

			Method m2 = testRefClass.getDeclaredMethod("getProtectedMethod", null);
			m2.setAccessible(true);
			m2.invoke(s, null);
			System.out.println(m2.invoke(s, null));

			Method m3 = testRefClass.getDeclaredMethod("getDefaultMethod", null);
			m3.setAccessible(true);
			System.out.println(m3.invoke(s, null));

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < 200; i++)
			System.out.print("*");
	}

}
