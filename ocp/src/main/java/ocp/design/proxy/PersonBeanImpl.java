/**
 * 
 */
package ocp.design.proxy;

/**
 * @author dinesh.joshi
 *
 */
public class PersonBeanImpl implements PersonBean {

	private String name;
	private String gender;
	private String interest;
	private int rating;

	/**
	 * 
	 */
	public PersonBeanImpl() {
		// TODO Auto-generated constructor stub
	}

	public PersonBeanImpl(String name, String gender, String interest, int rating) {
		this.name = name;
		this.gender = gender;
		this.interest = interest;
		this.rating = rating;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ocp.design.proxy.PersonBean#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ocp.design.proxy.PersonBean#getGender()
	 */
	@Override
	public String getGender() {
		return this.gender;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ocp.design.proxy.PersonBean#getInterests()
	 */
	@Override
	public String getInterests() {
		return this.interest;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ocp.design.proxy.PersonBean#getHotOrNotRating()
	 */
	@Override
	public int getHotOrNotRating() {
		return this.rating;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ocp.design.proxy.PersonBean#setName()
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ocp.design.proxy.PersonBean#setGender()
	 */
	@Override
	public void setGender(String gender) {
		this.gender = gender;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ocp.design.proxy.PersonBean#setInterests()
	 */
	@Override
	public void setInterests(String interests) {
		this.interest = interests;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ocp.design.proxy.PersonBean#setHotOrNotRating()
	 */
	@Override
	public void setHotOrNotRating(int rating) {
		this.rating = rating;

	}

}
