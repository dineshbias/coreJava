/**
 * 
 */
package com.test;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author edinjos
 *
 */
public class Convertor {

	/**
	 * 
	 */
	public Convertor() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("deprecation")
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis());
		Employee employee = new Employee("Dinesh",29,(float)5.5,new Date(),12234.4);
	      ObjectMapper mapper = new ObjectMapper();
	      try
	      {
	    	  System.out.println(mapper.writeValueAsString(employee));
	    	  mapper.writeValue(new File("C:\\CodeBase\\java_first_pojo\\abc.json"), employee);
	      } catch (JsonGenerationException e)
	      {
	         e.printStackTrace();
	      } catch (JsonMappingException e)
	      {
	         e.printStackTrace();
	      } catch (IOException e)
	      {
	         e.printStackTrace();
	      }
	   }
	}

