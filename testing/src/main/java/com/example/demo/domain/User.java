/**
 * 
 */
package com.example.demo.domain;

/**
 * @author dinesh.joshi
 *
 */
// @JsonInclude(JsonInclude.Include.NON_NULL)
// @JsonPropertyOrder({ "firstName", "lastName", "role" })
public class User {

	// @JsonProperty("firstName")
	private String firstName;

	// @JsonProperty("lastName")
	private String lastName;

	// @JsonProperty("role")
	private Role role;

	public User() {
		super();
	}

	public User(String firstName, String lastName, Role role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
