package application;

import java.io.Serializable;


public class MemberBean implements Serializable {

    private long id;
    private String firstName;
    private String lastName;
    private String handle;
    private String email;

    public MemberBean() {
    }

    public MemberBean(long id, String firstName, String lastName, String handle, String email) {
    	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.handle = handle;
	this.email = email;
    }

    public long getId() {
    	return id;
    }

    public void setId(long id) {
    	this.id = id;
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


    public String getHandle() {
    	return handle;
    }

    public void setHandle(String handle) {
    	this.handle = handle;
    }


    public String getEmail() {
    	return email;
    }

    public void setEmail(String email) {
    	this.email = email;
    }

}
