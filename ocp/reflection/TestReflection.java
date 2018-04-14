package ocp.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import ocp.reflection.test.Sample;

public class TestReflection {

	public TestReflection() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		Sample s = new Sample();
		s.setPotectedS("initial");
		s.setPrivateI(1);
		s.setPublicS("initial");
		
		System.out.println(s);
		
		Class testRefClass = s.getClass();
		Field f = testRefClass.getDeclaredField("privateI");
		f.setAccessible(true);
		f.set(s, new Integer(22));
		f = testRefClass.getDeclaredField("potectedS");
		f.setAccessible(true);
		f.set(s, "Updated");
		f = testRefClass.getDeclaredField("publicS");
		f.setAccessible(true);
		f.set(s, "Updated");
		System.out.println(s);
		
		System.out.println();
		Method[] methods = testRefClass.getMethods();
		for (Method method:methods)
		System.out.println(method.getName());
		System.out.println();
	}

}
