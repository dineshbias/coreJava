/**
 *
 */
package test.xmlToObject;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author edinjos
 *
 */
@XmlRootElement
public class Customer {

	String name;
	int age,id;


	public void setName(String name)
	{
		this.name = name;
	}


	public void setAge(int age)
	{
		this.age = age;
	}


	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return this.name;
	}

	public int getAge()
	{
		return this.age;
	}

	public int getId()
	{
		return this.id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + " " + this.age + " " + this.id;
	}
}
